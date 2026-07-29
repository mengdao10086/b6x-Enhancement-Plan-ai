package com.tmall.ultraviewpager;

import android.os.Handler;
import android.os.Message;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes5.dex */
public class c extends Handler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f22860e = 87108;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseIntArray f22861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22863c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f22864d;

    public interface a {
        int a();

        void b();
    }

    public c(a aVar, long j10) {
        this.f22864d = aVar;
        this.f22862b = j10;
    }

    public final long a(int i10) {
        long j10 = this.f22862b;
        SparseIntArray sparseIntArray = this.f22861a;
        if (sparseIntArray == null) {
            return j10;
        }
        long j11 = sparseIntArray.get(i10, -1);
        return j11 > 0 ? j11 : j10;
    }

    public boolean b() {
        return this.f22863c;
    }

    public void c(a aVar) {
        this.f22864d = aVar;
    }

    public void d(SparseIntArray sparseIntArray) {
        this.f22861a = sparseIntArray;
    }

    public void e(boolean z10) {
        this.f22863c = z10;
    }

    public void f(int i10) {
        sendEmptyMessageDelayed(f22860e, a(i10));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        if (87108 != message.what || (aVar = this.f22864d) == null) {
            return;
        }
        int iA = aVar.a();
        this.f22864d.b();
        f(iA);
    }
}
