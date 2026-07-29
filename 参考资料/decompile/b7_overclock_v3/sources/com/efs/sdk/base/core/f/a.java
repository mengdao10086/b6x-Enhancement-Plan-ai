package com.efs.sdk.base.core.f;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ControllerCenter f12904a;

    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.f12946a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    public abstract void a();

    @Override // android.os.Handler
    public void handleMessage(@n0 Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
