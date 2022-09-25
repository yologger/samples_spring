package com.yologger.stomp;

public class ChatMessage {

    private MessageType type;
    private Long senderId;
    private String roomId;
    private String message;

    enum MessageType {
        ENTER, TALK, EXIT
    }

    public ChatMessage(MessageType type, Long senderId, String roomId, String message) {
        this.type = type;
        this.senderId = senderId;
        this.roomId = roomId;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}