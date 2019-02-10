package com.kailin.appSample.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MessageStatus.class}, version = 1, exportSchema = false)
public abstract class MessageStatusDatabase extends RoomDatabase {

    public abstract MessageStatusDao messageStatusDao();
}
