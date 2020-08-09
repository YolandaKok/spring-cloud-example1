package io.yolanda.kokkinou.dto;

import java.util.Date;

public class LogMessage {
	private String message;
	private Date timestamp;
	private Type type;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

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
		return "LogMessage [message=" + message + "timestamp" + timestamp + ", type=" + type + "]";
	}
}
