package com.fiberhome.mobiark.mdm;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

public class MDMAdminReceiver extends DeviceAdminReceiver {

    @Override
    public void onEnabled(@NonNull Context context, @NonNull Intent intent) {
        super.onEnabled(context, intent);
        String action = intent.getAction();
//        if (!TextUtils.isEmpty(action)) ExtKt.setAdminChange(action);
    }

    @Override
    public void onDisabled(@NonNull Context context, @NonNull Intent intent) {
        super.onDisabled(context, intent);
        String action = intent.getAction();
//        if (!TextUtils.isEmpty(action)) ExtKt.setAdminChange(action);
    }
}
