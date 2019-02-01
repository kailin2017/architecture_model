package com.kailin.architecture_model.architecture.interfaces;

import android.content.BroadcastReceiver;

public interface ReceiverInterface {

    void registerReceiver(BroadcastReceiver receiver, String... actions);

    void unRegisterReceiver(BroadcastReceiver receiver);
}
