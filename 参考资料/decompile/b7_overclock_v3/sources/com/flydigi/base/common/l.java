package com.flydigi.base.common;

import android.app.Service;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends Service {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onDestroy");
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onLowMemory");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onTaskRemoved");
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onTrimMemory");
    }
}
