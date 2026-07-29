package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f12491b = new Handler(Looper.getMainLooper(), new a());

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f12492a = 1;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((s) message.obj).a();
            return true;
        }
    }

    public synchronized void a(s<?> sVar, boolean z10) {
        if (this.f12490a || z10) {
            this.f12491b.obtainMessage(1, sVar).sendToTarget();
        } else {
            this.f12490a = true;
            sVar.a();
            this.f12490a = false;
        }
    }
}
