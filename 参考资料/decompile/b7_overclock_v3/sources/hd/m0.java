package hd;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public class m0 implements c {
    @Override // hd.c
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // hd.c
    public long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // hd.c
    public n c(Looper looper, @g.p0 Handler.Callback callback) {
        return new n0(new Handler(looper, callback));
    }

    @Override // hd.c
    public void d(long j10) {
        SystemClock.sleep(j10);
    }

    @Override // hd.c
    public long e() {
        return SystemClock.elapsedRealtime();
    }
}
