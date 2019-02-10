package com.kailin.appSample.data.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

@Dao
public interface MessageStatusDao {

    @Query("SELECT * FROM messagestatus WHERE isRead = :isRead AND messageType IN (:messageTypes)")
    List<MessageStatus> getMessages(boolean isRead, @TypeConverters(MessageTypeConverters.class) MessageType... messageTypes);

    @Query("SELECT * FROM messagestatus WHERE isRead = 0 AND messageType IN (:messageTypes) ORDER BY messageId DESC LIMIT 30")
    List<MessageStatus> getUnread30Messages(@TypeConverters(MessageTypeConverters.class) MessageType... messageTypes);

    @Query("SELECT COUNT(messageId) FROM messagestatus WHERE isRead = 0")
    int getUnreadCount();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MessageStatus... messageStatuses);

    @Update
    int update(MessageStatus... messageStatuses);

    @Delete
    int delete(MessageStatus... messageStatuses);
}
