package io.yolanda.kokkinou.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "log")
public class LogMessage {

    @Id
    private String id;
    private String message;
    private Date timestamp;
    private Type type;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {return id;}

    public void setId(String id) { this.id = id; }

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
        return "LogMessage [message=" + message + ", timestamp=" + timestamp + ", type=" + type + "]";
    }
}
