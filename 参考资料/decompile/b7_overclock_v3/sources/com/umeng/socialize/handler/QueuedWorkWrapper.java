package com.umeng.socialize.handler;

import com.umeng.socialize.common.QueuedWork;

/* JADX INFO: loaded from: classes5.dex */
public class QueuedWorkWrapper {
    public void onError(Runnable runnable) {
        QueuedWork.runInMain(runnable);
    }
}
