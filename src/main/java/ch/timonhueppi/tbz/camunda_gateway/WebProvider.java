package ch.timonhueppi.tbz.camunda_gateway;

import ch.timonhueppi.tbz.camunda_gateway.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.tomcat.jni.Proc;
import org.springframework.http.HttpMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class WebProvider {
    public static String baseURL = "http://localhost:8080/engine-rest/";
    public static String provideRequest(String urlStr, HttpMethod method, String body){
        String response = null;
        try{
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(method.toString());
            if (body != null) {
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "*/*");
                con.setDoOutput(true);
                try(OutputStream os = con.getOutputStream()) {
                    byte[] input = body.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            if (body != null){
                StringBuilder sb = new StringBuilder();
                String responseLine = null;
                while ((responseLine = in.readLine()) != null) {
                    sb.append(responseLine.trim());
                }
                response = sb.toString();
            }else {
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                response = content.toString();
            }
            in.close();
            con.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }



    public static String getDeploymentId(){
        String deploymentsStr = provideRequest(baseURL + "deployment", HttpMethod.GET, null);
        String deploymentId = null;
        Gson gson = new Gson();
        List<Deployment> deployments = gson.fromJson(deploymentsStr, new TypeToken<List<Deployment>>() {}.getType());
        for (Deployment deployment :
                deployments) {
            if (deployment.getName().equals("lb2")) {
                deploymentId = deployment.getId();
            }
        }
        return deploymentId;
    }

    public static List<ProcessInstance> getProcessInstancesOfDeployment(String deploymentId){
        String processesStr = provideRequest(baseURL + "process-instance", HttpMethod.GET, null);
        Gson gson = new Gson();
        List<ProcessInstance> processInstances = gson.fromJson(processesStr, new TypeToken<List<ProcessInstance>>() {}.getType());
        String pattern = deploymentId.substring(deploymentId.length() - 12);
        processInstances.removeIf(processInstance -> !processInstance.getDefinitionId().endsWith(pattern));
        return processInstances;
    }

    public static List<Execution> getExecutionsOfDeployment(String deploymentId){
        String executionsStr = provideRequest(baseURL + "execution", HttpMethod.GET, null);
        Gson gson = new Gson();
        List<Execution> executions = gson.fromJson(executionsStr, new TypeToken<List<Execution>>() {}.getType());
        String pattern = deploymentId.substring(deploymentId.length() - 12);
        executions.removeIf(execution -> !execution.getProcessInstanceId().endsWith(pattern));
        return executions;
    }

    public static Task getTaskOfProcessInstance(String processInstanceId){
        String tasksStr = provideRequest(baseURL + "task", HttpMethod.GET, null);
        Gson gson = new Gson();
        List<Task> tasks = gson.fromJson(tasksStr, new TypeToken<List<Task>>() {}.getType());
        tasks.removeIf(task -> !task.getProcessInstanceId().equals(processInstanceId));
        return tasks.get(0);
    }

    public static Boolean claimTask(String taskId, String username){
        String body = "{\"userId\": \"" + username + "\"}";
        provideRequest(baseURL + "task/" + taskId + "/claim", HttpMethod.POST, body);
        return true;
    }

    public static Boolean completeTask(String taskId, String body){
        provideRequest(baseURL + "task/" + taskId + "/complete", HttpMethod.POST, body);
        return true;
    }

    public static Task getTask(String taskId){
        String taskStr = WebProvider.provideRequest(baseURL + "task/" + taskId, HttpMethod.GET, null);
        return new Gson().fromJson(taskStr, Task.class);
    }

    public static String getVariableOfTask(String taskId, String varname){
        return provideRequest(baseURL + "task/" + taskId + "/variables/" + varname, HttpMethod.GET, null);
    }

    public static void updateVariableOfTask(String taskId, String varname, String newStrValue, Boolean newBoolValue){
        String body = "{\"value\": \"" + (newStrValue != null?newStrValue:"") + (newBoolValue != null?newBoolValue.toString():"") + "\", \"type\": \"" + (newStrValue == null?"Boolean":"String") + "\"}";
        provideRequest(baseURL + "task/" + taskId + "/variables/" + varname, HttpMethod.PUT, body);
    }

    public static ProcessDefinition getProcessDefinition(String deploymentId){
        Gson gson = new Gson();
        String processesStr = provideRequest(baseURL + "process-definition", HttpMethod.GET, null);
        List<ProcessDefinition> processDefinitions = gson.fromJson(processesStr, new TypeToken<List<ProcessDefinition>>() {}.getType());
        for (ProcessDefinition processDefinition :
                processDefinitions) {
            if (processDefinition.getDeploymentId().equals(deploymentId)){
                return processDefinition;
            }
        }
        return null;
    }

    public static ProcessInstance startProcessInstance(String processDefinitionId, String body){
        Gson gson = new Gson();
        String processInstanceStr = provideRequest(
                baseURL + "process-definition/" + processDefinitionId + "/start", HttpMethod.POST, body);
        return gson.fromJson(processInstanceStr, ProcessInstance.class);
    }
}
