package io.yolanda.kokkinou.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "log")
public class LogMessage {

    @Id
    private String id;
    private String message;
    // TODO: Add Date
    private Type type;

    public String getId() {return id;}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LogMessage [message=" + message + ", type=" + type + "]";
    }
}
