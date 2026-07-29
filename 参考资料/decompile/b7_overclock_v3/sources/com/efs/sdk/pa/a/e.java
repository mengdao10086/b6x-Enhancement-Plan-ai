package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
final class e implements Printer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13157f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13153b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13154c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13155d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13156e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector<d> f13152a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(">")) {
            this.f13155d = SystemClock.elapsedRealtime();
            this.f13156e = SystemClock.currentThreadTimeMillis();
            this.f13154c = str;
            this.f13153b = true;
            Iterator<d> it2 = this.f13152a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
            return;
        }
        if (this.f13153b && str.startsWith("<")) {
            this.f13153b = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f13155d;
            if (jElapsedRealtime > this.f13157f) {
                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.f13156e;
                Iterator<d> it3 = this.f13152a.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this.f13154c, jElapsedRealtime, jCurrentThreadTimeMillis);
                }
            }
        }
    }
}
