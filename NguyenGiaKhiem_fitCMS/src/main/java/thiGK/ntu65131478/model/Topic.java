package thiGK.ntu65131478.model;

public class Topic {

    private int id;
    private String topicName;
    private String topicDescription;
    private int supervisorId;
    private String topicType;

    public Topic() {
    }

    public Topic(int id, String topicName, String topicDescription, int supervisorId, String topicType) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.supervisorId = supervisorId;
        this.topicType = topicType;
    }

    public int getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }
}