package com.efs.sdk.pa.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.blankj.utilcode.util.i0;
import com.efs.sdk.pa.PAANRListener;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f13118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f13119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread f13120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f13124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PAANRListener f13125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f13126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f13127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f13128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f13130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Runnable f13131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private HandlerThread f13132o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Application f13133p;

    public a(Application application, long j10) {
        this(application, j10, true);
    }

    public static boolean a(StringBuilder sb2) {
        Set<Map.Entry<Thread, StackTraceElement[]>> setEntrySet = Thread.getAllStackTraces().entrySet();
        if (setEntrySet.size() == 0) {
            return false;
        }
        boolean z10 = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : setEntrySet) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(key.getName());
                sb3.append(i0.f11861z);
                sb3.append(key.getPriority());
                sb3.append(i0.f11861z);
                sb3.append(key.getState());
                sb3.append("\n");
                for (StackTraceElement stackTraceElement : value) {
                    String string = stackTraceElement.toString();
                    sb3.append("  at  ");
                    sb3.append(string);
                    sb3.append('\n');
                }
                sb3.append("\n");
                sb2.insert(0, (CharSequence) sb3);
                z10 = true;
            } else {
                sb2.append(key.getName());
                sb2.append(i0.f11861z);
                sb2.append(key.getPriority());
                sb2.append(i0.f11861z);
                sb2.append(key.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement2 : value) {
                    String string2 = stackTraceElement2.toString();
                    sb2.append("  at  ");
                    sb2.append(string2);
                    sb2.append('\n');
                }
                sb2.append("\n");
            }
        }
        if (!z10) {
            sb2.insert(0, a(Looper.getMainLooper().getThread()));
        }
        return true;
    }

    public a(Application application, long j10, boolean z10) {
        this.f13118a = true;
        this.f13122e = 4L;
        this.f13123f = true;
        this.f13126i = 0L;
        this.f13130m = new Runnable() { // from class: com.efs.sdk.pa.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                PAANRListener pAANRListener;
                if (a.this.f13123f) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                long j11 = jUptimeMillis - aVar.f13127j;
                if (j11 > aVar.f13128k && (pAANRListener = aVar.f13125h) != null) {
                    pAANRListener.unexcept(Long.valueOf(j11));
                }
                if (a.this.f13118a) {
                    a aVar2 = a.this;
                    aVar2.f13126i = 0L;
                    aVar2.f13118a = false;
                    a aVar3 = a.this;
                    aVar3.f13119b.postAtFrontOfQueue(aVar3.f13131n);
                } else {
                    a aVar4 = a.this;
                    aVar4.f13126i++;
                    if (!aVar4.f13118a) {
                        a aVar5 = a.this;
                        long j12 = aVar5.f13126i;
                        long j13 = aVar5.f13122e;
                        if (j12 >= j13 && j12 == j13) {
                            StringBuilder sb2 = new StringBuilder();
                            if (aVar5.f13129l) {
                                sb2.append(a.a(aVar5.f13120c));
                            } else if (a.a(sb2)) {
                            }
                            if (aVar5.f13125h != null && sb2.length() > 0) {
                                aVar5.f13125h.anrStack(sb2.toString());
                            }
                        }
                    }
                }
                a.this.f13127j = SystemClock.uptimeMillis();
                a aVar6 = a.this;
                aVar6.f13124g.postDelayed(aVar6.f13130m, aVar6.f13121d);
            }
        };
        this.f13131n = new Runnable() { // from class: com.efs.sdk.pa.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.f13118a = true;
            }
        };
        this.f13128k = j10;
        this.f13133p = application;
        this.f13129l = z10;
        long j11 = ((long) (j10 * 0.8f)) / this.f13122e;
        this.f13121d = j11;
        if (j11 < 100) {
            this.f13121d = 100L;
            this.f13122e = j10 / 100;
        }
        StringBuilder sb2 = new StringBuilder("anrTrace, final mAnrBeatTime:");
        sb2.append(this.f13121d);
        sb2.append(", mAnrBeatRate:");
        sb2.append(this.f13121d);
        this.f13120c = Looper.getMainLooper().getThread();
        this.f13119b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.f13132o = handlerThread;
        handlerThread.start();
        this.f13124g = new Handler(this.f13132o.getLooper());
    }

    public static String a(Thread thread) {
        StringBuilder sb2 = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb2.append(thread.getName());
        sb2.append(i0.f11861z);
        sb2.append(thread.getPriority());
        sb2.append(i0.f11861z);
        sb2.append(thread.getState());
        sb2.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String string = stackTraceElement.toString();
            sb2.append("  at  ");
            sb2.append(string);
            sb2.append('\n');
        }
        sb2.append("\n");
        return sb2.toString();
    }
}
