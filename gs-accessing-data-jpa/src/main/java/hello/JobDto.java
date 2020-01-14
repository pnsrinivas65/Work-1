package hello;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class JobDto implements Serializable {

    private String name;
    private Long version;
    private Map<String, Object> params = new HashMap<>();
    private JobStatus status = JobStatus.SUBMITTED;
    private Integer priority;
    
    private String userProfileName;
    private boolean terminated;

    // Scheduled fields
    private String scheduledCron;

    private LocalDateTime scheduledTime;

    private QueueName queue;
    private QueueSubSystem subSystem;

    private LocalDateTime enqueueTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public JobDto() {
        // default
    }

    public JobDto(String name, QueueName queue) {
        this.name = name;
        this.queue = queue;
    }

    public JobDto(String name, QueueName queue, String scheduledCron) {
        this(name, queue);
        this.scheduledCron = scheduledCron;
    }

    public QueueName getQueue() {
        return queue;
    }

    public void setQueue(QueueName queue) {
        this.queue = queue;
    }

    public String getScheduledCron() {
        return scheduledCron;
    }

    public void setScheduledCron(String scheduledCron) {
        this.scheduledCron = scheduledCron;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDateTime getEnqueueTime() {
        return enqueueTime;
    }

    public void setEnqueueTime(LocalDateTime enqueueTime) {
        this.enqueueTime = enqueueTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUserProfileName() {
        return userProfileName;
    }

    public void setUserProfileName(final String userProfileName) {
        this.userProfileName = userProfileName;
    }

    public void setSubSystem(QueueSubSystem subSystem) {
        this.subSystem = subSystem;
    }

    public QueueSubSystem getSubSystem() {
        return subSystem;
    }
       

    public boolean getTerminated() {
        return terminated;
    }

    public void setTerminated(boolean isTerminated) {
        this.terminated = isTerminated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobDto jobDto = (JobDto) o;

        return new EqualsBuilder()
                .append(terminated, jobDto.terminated)
                .append(name, jobDto.name)
                .append(version, jobDto.version)
                .append(params, jobDto.params)
                .append(status, jobDto.status)
                .append(priority, jobDto.priority)
                .append(userProfileName, jobDto.userProfileName)
                .append(scheduledCron, jobDto.scheduledCron)
                .append(scheduledTime, jobDto.scheduledTime)
                .append(queue, jobDto.queue)
                .append(subSystem, jobDto.subSystem)
                .append(enqueueTime, jobDto.enqueueTime)
                .append(startTime, jobDto.startTime)
                .append(endTime, jobDto.endTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(version)
                .append(params)
                .append(status)
                .append(priority)
                .append(userProfileName)
                .append(terminated)
                .append(scheduledCron)
                .append(scheduledTime)
                .append(queue)
                .append(subSystem)
                .append(enqueueTime)
                .append(startTime)
                .append(endTime)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "JobDto{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", params=" + params +
                ", status=" + status +
                ", priority=" + priority +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userProfileName='" + userProfileName + "\'" +
                '}';
    }
}