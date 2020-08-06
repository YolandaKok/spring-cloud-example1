package io.yolanda.kokkinou.dto;

public class LogMessage {
	private String message;
	private Type type;
	
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
