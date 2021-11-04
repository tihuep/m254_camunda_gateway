package ch.timonhueppi.tbz.camunda_gateway;

import ch.timonhueppi.tbz.camunda_gateway.model.*;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @PostMapping("/car")
    public String addCar(@RequestBody String newCarStr) {
        String body = "{\"variables\": null}";

        String deploymentId = WebProvider.getDeploymentId();
        ProcessDefinition processDefinition = WebProvider.getProcessDefinition(deploymentId);
        ProcessInstance processInstance = WebProvider.startProcessInstance(processDefinition.getId(), body);
        Task task = WebProvider.getTaskOfProcessInstance(processInstance.getId());

        WebProvider.claimTask(task.getId(), "demo");

        Gson gson = new Gson();
        Car car = gson.fromJson(newCarStr, Car.class);
        body = "{\"variables\": {\"car\": {\"value\": \"" + StringEscapeUtils.escapeJson(gson.toJson(car)) + "\", \"type\": \"String\"}}}";
        WebProvider.completeTask(task.getId(), body);

        task = WebProvider.getTaskOfProcessInstance(task.getProcessInstanceId());

        return task.getId();
    }

    @GetMapping("/car/{id}")
    public String getCar(@PathVariable(value = "id") String id){
        return StringEscapeUtils.unescapeJson(new Gson().fromJson(WebProvider.getVariableOfTask(id, "car"), Variable.class).getValue());
    }

    @PutMapping("/car/{id}/status")
    public String setStatusOfCar(@PathVariable(value = "id") String id, @RequestBody Boolean newStatus){
        String carStr = WebProvider.getVariableOfTask(id, "car");
        Gson gson = new Gson();
        Car car = gson.fromJson(StringEscapeUtils.unescapeJson(new Gson().fromJson(carStr, Variable.class).getValue()), Car.class);
        car.setStatus_ok(newStatus);
        carStr = gson.toJson(car);
        WebProvider.updateVariableOfTask(id, "car", StringEscapeUtils.escapeJson(carStr), null);
        WebProvider.updateVariableOfTask(id, "status_ok", null, newStatus);
        Task task = WebProvider.getTask(id);
        if (newStatus) {
            WebProvider.claimTask(id, "demo");
            String body = "{\"variables\": null}";
            WebProvider.completeTask(task.getId(), body);
            task = WebProvider.getTaskOfProcessInstance(task.getProcessInstanceId());
        }
        return task.getId();
    }

    @GetMapping("/car/{id}/status")
    public String getStatusOfCar(@PathVariable(value = "id") String id) {
        return new Gson().fromJson(StringEscapeUtils.unescapeJson(new Gson().fromJson(WebProvider.getVariableOfTask(id, "car"), Variable.class).getValue()), Car.class).getStatus_ok().toString();
    }

    @PostMapping("car/{id}/advertise")
    public String advertiseCar(@PathVariable(value = "id") String id){
        Task task = WebProvider.getTask(id);
        WebProvider.claimTask(id, "demo");
        String body = "{\"variables\": null}";
        WebProvider.completeTask(task.getId(), body);
        task = WebProvider.getTaskOfProcessInstance(task.getProcessInstanceId());
        return task.getId();
    }

    @PostMapping("/car/{id}/sell")
    public String sellCar(@PathVariable(value = "id") String id, @RequestBody String buyerInfo) {
        return id;
    }

    @PutMapping("/car/{id}/price")
    public String changePriceOfCar(@PathVariable(value = "id") String id, @RequestBody String newPrice){
        return id;
    }

    @DeleteMapping("/car/{id}")
    public String wreckCar(@PathVariable(value = "id") String id){
        return id;
    }
}
