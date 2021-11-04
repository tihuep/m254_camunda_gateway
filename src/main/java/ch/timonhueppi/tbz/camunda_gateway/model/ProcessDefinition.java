package ch.timonhueppi.tbz.camunda_gateway.model;

public class ProcessDefinition {
    String id;
    String key;
    String category;
    String description;
    String name;
    Integer version;
    String resource;
    String deploymentId;
    Object diagram;
    Boolean suspended;
    String tenantId;
    String versionTag;
    String historyTimeToLive;
    Boolean startableInTasklist;

    public ProcessDefinition(String id, String key, String category, String description, String name, Integer version, String resource, String deploymentId, Object diagram, Boolean suspended, String tenantId, String versionTag, String historyTimeToLive, Boolean startableInTasklist) {
        this.id = id;
        this.key = key;
        this.category = category;
        this.description = description;
        this.name = name;
        this.version = version;
        this.resource = resource;
        this.deploymentId = deploymentId;
        this.diagram = diagram;
        this.suspended = suspended;
        this.tenantId = tenantId;
        this.versionTag = versionTag;
        this.historyTimeToLive = historyTimeToLive;
        this.startableInTasklist = startableInTasklist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Object getDiagram() {
        return diagram;
    }

    public void setDiagram(Object diagram) {
        this.diagram = diagram;
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

    public String getVersionTag() {
        return versionTag;
    }

    public void setVersionTag(String versionTag) {
        this.versionTag = versionTag;
    }

    public String getHistoryTimeToLive() {
        return historyTimeToLive;
    }

    public void setHistoryTimeToLive(String historyTimeToLive) {
        this.historyTimeToLive = historyTimeToLive;
    }

    public Boolean getStartableInTasklist() {
        return startableInTasklist;
    }

    public void setStartableInTasklist(Boolean startableInTasklist) {
        this.startableInTasklist = startableInTasklist;
    }
}
