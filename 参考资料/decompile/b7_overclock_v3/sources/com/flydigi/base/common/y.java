package com.flydigi.base.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13373c = "UiHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f13374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13375b;

    public interface a {
        boolean D2(Message message, int i10, boolean z10);
    }

    public y() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(a aVar, Message message) {
        return aVar.D2(message, message.what, this.f13375b);
    }

    public Handler b() {
        return this.f13374a;
    }

    public boolean c() {
        return this.f13375b;
    }

    public boolean e(Runnable runnable) {
        if (this.f13375b) {
            this.f13374a.post(runnable);
        }
        return this.f13375b;
    }

    public boolean f(Runnable runnable, long j10) {
        if (this.f13375b) {
            this.f13374a.postDelayed(runnable, j10);
        }
        return this.f13375b;
    }

    public void g(Runnable runnable) {
        this.f13374a.removeCallbacks(runnable);
    }

    public void h(Object obj) {
        this.f13374a.removeCallbacksAndMessages(obj);
    }

    public void i(boolean z10) {
        this.f13375b = z10;
        if (z10) {
            return;
        }
        this.f13374a.removeCallbacksAndMessages(null);
    }

    public y(final a aVar) {
        this.f13375b = true;
        if (aVar != null) {
            this.f13374a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.flydigi.base.common.x
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f13371a.d(aVar, message);
                }
            });
        } else {
            this.f13374a = new Handler(Looper.getMainLooper());
        }
    }
}
