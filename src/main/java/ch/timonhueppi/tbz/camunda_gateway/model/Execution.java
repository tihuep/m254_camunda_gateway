package ch.timonhueppi.tbz.camunda_gateway.model;

public class Execution {
    String id;
    String processInstanceId;
    Boolean ended;
    String tenantId;

    public Execution(String id, String processInstanceId, Boolean ended, String tenantId) {
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.ended = ended;
        this.tenantId = tenantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Boolean getEnded() {
        return ended;
    }

    public void setEnded(Boolean ended) {
        this.ended = ended;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
