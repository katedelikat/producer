package com.siemplify.producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is Dto object representing task to be submitted
 */
public class TaskDto {

    private final static String TASK_TEST = "task_text";
    private final static String CONSUMER_ID = "consumer_id";

    @JsonProperty(TASK_TEST)
    private String taskText;

    @JsonProperty(CONSUMER_ID)
    private String consumerId;

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }
}
