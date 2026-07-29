package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24368e = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f24369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f24371c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HandlerThread f24373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f24374g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f24372d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler.Callback f24375h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f24372d) {
                    return true;
                }
                long jElapsedRealtime = a.this.f24371c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f24373f != null) {
                        a.this.f24373f.quit();
                    }
                } else if (jElapsedRealtime < a.this.f24370b) {
                    a.this.f24374g.sendMessageDelayed(a.this.f24374g.obtainMessage(1), jElapsedRealtime);
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = (jElapsedRealtime2 + a.this.f24370b) - SystemClock.elapsedRealtime();
                    while (jElapsedRealtime3 < 0) {
                        jElapsedRealtime3 += a.this.f24370b;
                    }
                    a.this.f24374g.sendMessageDelayed(a.this.f24374g.obtainMessage(1), jElapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j10, long j11) {
        this.f24369a = j10;
        this.f24370b = j11;
        if (d()) {
            this.f24374g = new Handler(this.f24375h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f24373f = handlerThread;
        handlerThread.start();
        this.f24374g = new Handler(this.f24373f.getLooper(), this.f24375h);
    }

    public abstract void a(long j10);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f24372d = true;
        this.f24374g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f24372d = false;
        if (this.f24369a <= 0) {
            c();
            return this;
        }
        this.f24371c = SystemClock.elapsedRealtime() + this.f24369a;
        Handler handler = this.f24374g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
