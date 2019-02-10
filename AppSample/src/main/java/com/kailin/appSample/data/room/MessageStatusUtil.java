package com.kailin.appSample.data.room;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;

public final class MessageStatusUtil {

    private static volatile MessageStatusUtil messageStatusUtil;

    public static MessageStatusUtil getInstance(Context context) {
        if (messageStatusUtil == null) {
            synchronized (MessageStatusUtil.class) {
                if (messageStatusUtil == null) {
                    messageStatusUtil = new MessageStatusUtil(context);
                }
            }
        }
        return messageStatusUtil;
    }

    private final MessageStatusDatabase database;
    private final MessageStatusDao dao;

    private MessageStatusUtil(Context context) {
        String dbName = String.format("%s.db", MessageStatusDatabase.class.getSimpleName());
        database = Room.databaseBuilder(context, MessageStatusDatabase.class, dbName).build();
        dao = database.messageStatusDao();
    }

    public List<MessageStatus> getGeneralMessages(boolean isRead) {
        return dao.getMessages(isRead, MessageType.General);
    }

    public List<MessageStatus> getPersonalMessages(boolean isRead) {
        return dao.getMessages(isRead, MessageType.Personal);
    }

    public List<MessageStatus> getUnread30GerneralMessages() {
        return dao.getUnread30Messages(MessageType.General);
    }

    public List<MessageStatus> getUnread30PersonalMessages() {
        return dao.getUnread30Messages(MessageType.Personal);
    }

    public void readAllGeneralMessages() {
        readAllMessages(getGeneralMessages(false));
    }

    public void readAllPersonalMessages() {
        readAllMessages(getPersonalMessages(false));
    }

    private void readAllMessages(List<MessageStatus> messageStatusesList) {
        for (MessageStatus messageStatus : messageStatusesList) {
            messageStatus.setRead(true);
        }
        updateMessages(messageStatusesList.toArray(new MessageStatus[]{}));
    }

    public void clearOldMessages() {
        clearOldMessages(getGeneralMessages(true));
        clearOldMessages(getPersonalMessages(true));
    }

    public void clearOldMessages(List<MessageStatus> messageStatusesList) {
        List<MessageStatus> messageStatusesOldList = new ArrayList<>();
        int tmp = 30;
        while (tmp < messageStatusesList.size()) {
            messageStatusesOldList.add(messageStatusesList.get(tmp));
            tmp++;
        }
        deleteMessages(messageStatusesOldList.toArray(new MessageStatus[]{}));
    }

    public int getUnreadCount() {
        return dao.getUnreadCount();
    }

    public void insertMessages(MessageStatus... messageStatus) {
        dao.insert(messageStatus);
    }

    public void updateMessages(MessageStatus... messageStatuses) {
        dao.update(messageStatuses);
    }

    public void deleteMessages(MessageStatus... messageStatuses) {
        dao.delete(messageStatuses);
    }
}
