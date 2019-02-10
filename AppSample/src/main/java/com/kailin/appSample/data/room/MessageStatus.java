package com.kailin.appSample.data.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = MessageStatus.ROOM_TABLE_NAME)
public final class MessageStatus {

    public final static String ROOM_TABLE_NAME = "MessageStatus";

    @PrimaryKey
    private int messageId;

    private boolean isRead;

    @TypeConverters(MessageTypeConverters.class)
    private MessageType messageType;

    public MessageStatus(int messageId, boolean isRead) {
        this.messageId = messageId;
        this.isRead = isRead;
        if (messageId > 800000) {
            messageType = MessageType.Personal;
        } else if (messageId > 300000) {
            messageType = MessageType.General;
        } else {
            messageType = MessageType.UnKnown;
        }
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageStatus{" +
                "messageId=" + messageId +
                ", isRead=" + isRead +
                ", messageType=" + messageType +
                '}';
    }
}
