package hd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f31098a;

    public n0(Handler handler) {
        this.f31098a = handler;
    }

    @Override // hd.n
    public Message a(int i10, int i11, int i12) {
        return this.f31098a.obtainMessage(i10, i11, i12);
    }

    @Override // hd.n
    public boolean b(int i10, int i11) {
        return this.f31098a.sendEmptyMessageDelayed(i10, i11);
    }

    @Override // hd.n
    public boolean c(Runnable runnable) {
        return this.f31098a.post(runnable);
    }

    @Override // hd.n
    public Message d(int i10) {
        return this.f31098a.obtainMessage(i10);
    }

    @Override // hd.n
    public boolean e(int i10) {
        return this.f31098a.hasMessages(i10);
    }

    @Override // hd.n
    public boolean f(Runnable runnable, long j10) {
        return this.f31098a.postDelayed(runnable, j10);
    }

    @Override // hd.n
    public boolean g(int i10) {
        return this.f31098a.sendEmptyMessage(i10);
    }

    @Override // hd.n
    public Message h(int i10, int i11, int i12, @g.p0 Object obj) {
        return this.f31098a.obtainMessage(i10, i11, i12, obj);
    }

    @Override // hd.n
    public boolean i(int i10, long j10) {
        return this.f31098a.sendEmptyMessageAtTime(i10, j10);
    }

    @Override // hd.n
    public void j(int i10) {
        this.f31098a.removeMessages(i10);
    }

    @Override // hd.n
    public Message k(int i10, @g.p0 Object obj) {
        return this.f31098a.obtainMessage(i10, obj);
    }

    @Override // hd.n
    public void l(@g.p0 Object obj) {
        this.f31098a.removeCallbacksAndMessages(obj);
    }

    @Override // hd.n
    public Looper m() {
        return this.f31098a.getLooper();
    }
}
