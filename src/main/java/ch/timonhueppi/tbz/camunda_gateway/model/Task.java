package ch.timonhueppi.tbz.camunda_gateway.model;

import java.util.Date;

public class Task {
    String id;
    String name;
    String assignee;
    Date created;
    Date due;
    Object followUp;
    Object delegationState;
    String description;
    String executionId;
    String owner;
    String parentTaskId;
    Integer priority;
    String processDefinitionId;
    String processInstanceId;
    String taskDefinitionKey;
    String caseExecutionId;
    String caseInstanceId;
    String caseDefinitionId;
    Boolean suspended;
    String formKey;
    String camundaFormRef;
    String tenantId;

    public Task(String id, String name, String assignee, Date created, Date due, Object followUp, Object delegationState, String description, String executionId, String owner, String parentTaskId, Integer priority, String processDefinitionId, String processInstanceId, String taskDefinitionKey, String caseExecutionId, String caseInstanceId, String caseDefinitionId, Boolean suspended, String formKey, String camundaFormRef, String tenantId) {
        this.id = id;
        this.name = name;
        this.assignee = assignee;
        this.created = created;
        this.due = due;
        this.followUp = followUp;
        this.delegationState = delegationState;
        this.description = description;
        this.executionId = executionId;
        this.owner = owner;
        this.parentTaskId = parentTaskId;
        this.priority = priority;
        this.processDefinitionId = processDefinitionId;
        this.processInstanceId = processInstanceId;
        this.taskDefinitionKey = taskDefinitionKey;
        this.caseExecutionId = caseExecutionId;
        this.caseInstanceId = caseInstanceId;
        this.caseDefinitionId = caseDefinitionId;
        this.suspended = suspended;
        this.formKey = formKey;
        this.camundaFormRef = camundaFormRef;
        this.tenantId = tenantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Object getFollowUp() {
        return followUp;
    }

    public void setFollowUp(Object followUp) {
        this.followUp = followUp;
    }

    public Object getDelegationState() {
        return delegationState;
    }

    public void setDelegationState(Object delegationState) {
        this.delegationState = delegationState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getCaseExecutionId() {
        return caseExecutionId;
    }

    public void setCaseExecutionId(String caseExecutionId) {
        this.caseExecutionId = caseExecutionId;
    }

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getCamundaFormRef() {
        return camundaFormRef;
    }

    public void setCamundaFormRef(String camundaFormRef) {
        this.camundaFormRef = camundaFormRef;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
