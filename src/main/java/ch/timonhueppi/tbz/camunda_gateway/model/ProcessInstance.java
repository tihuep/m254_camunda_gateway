package ch.timonhueppi.tbz.camunda_gateway.model;

import java.util.List;

public class ProcessInstance {
    List<?> links;
    String id;
    String definitionId;
    String businessKey;
    String caseInstanceId;
    Boolean ended;
    Boolean suspended;
    String tenantId;

    public ProcessInstance(List<?> links, String id, String definitionId, String businessKey, String caseInstanceId, Boolean ended, Boolean suspended, String tenantId) {
        this.links = links;
        this.id = id;
        this.definitionId = definitionId;
        this.businessKey = businessKey;
        this.caseInstanceId = caseInstanceId;
        this.ended = ended;
        this.suspended = suspended;
        this.tenantId = tenantId;
    }

    public List<?> getLinks() {
        return links;
    }

    public void setLinks(List<?> links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    public Boolean getEnded() {
        return ended;
    }

    public void setEnded(Boolean ended) {
        this.ended = ended;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
