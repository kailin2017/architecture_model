package com.kailin.appSample.data.room;

import androidx.room.TypeConverter;

public interface MessageTypeConverters {

    @TypeConverter
    static String toString(MessageType messageType) {
        return messageType.name();
    }

    @TypeConverter
    static MessageType toMessageType(String string) {
        try {
            return MessageType.valueOf(string);
        } catch (Exception e) {
            return MessageType.UnKnown;
        }
    }
}
