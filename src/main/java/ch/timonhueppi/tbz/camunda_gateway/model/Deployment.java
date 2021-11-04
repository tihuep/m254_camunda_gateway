package ch.timonhueppi.tbz.camunda_gateway.model;

import java.util.Date;
import java.util.List;

public class Deployment {
    List<?> links;
    String id;
    String name;
    String source;
    Date deploymentTime;
    String tenantId;

    public Deployment(List<?> links, String id, String name, String source, Date deploymentTime, String tenantId) {
        this.links = links;
        this.id = id;
        this.name = name;
        this.source = source;
        this.deploymentTime = deploymentTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(Date deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
