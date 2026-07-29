package ya;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f56898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f56899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hd.c f56900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x1 f56901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f56902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.p0
    public Object f56903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Looper f56904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f56906i = g.f56663b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f56907j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f56908k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f56909l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f56910m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f56911n;

    public interface a {
        void c(l1 l1Var);
    }

    public interface b {
        void r(int i10, @g.p0 Object obj) throws ExoPlaybackException;
    }

    public l1(a aVar, b bVar, x1 x1Var, int i10, hd.c cVar, Looper looper) {
        this.f56899b = aVar;
        this.f56898a = bVar;
        this.f56901d = x1Var;
        this.f56904g = looper;
        this.f56900c = cVar;
        this.f56905h = i10;
    }

    public synchronized boolean a() throws InterruptedException {
        hd.a.i(this.f56908k);
        hd.a.i(this.f56904g.getThread() != Thread.currentThread());
        while (!this.f56910m) {
            wait();
        }
        return this.f56909l;
    }

    public synchronized boolean b(long j10) throws InterruptedException, TimeoutException {
        boolean z10;
        hd.a.i(this.f56908k);
        hd.a.i(this.f56904g.getThread() != Thread.currentThread());
        long jE = this.f56900c.e() + j10;
        while (true) {
            z10 = this.f56910m;
            if (z10 || j10 <= 0) {
                break;
            }
            wait(j10);
            j10 = jE - this.f56900c.e();
        }
        if (!z10) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.f56909l;
    }

    public synchronized l1 c() {
        hd.a.i(this.f56908k);
        this.f56911n = true;
        m(false);
        return this;
    }

    public boolean d() {
        return this.f56907j;
    }

    public Looper e() {
        return this.f56904g;
    }

    @g.p0
    public Object f() {
        return this.f56903f;
    }

    public long g() {
        return this.f56906i;
    }

    public b h() {
        return this.f56898a;
    }

    public x1 i() {
        return this.f56901d;
    }

    public int j() {
        return this.f56902e;
    }

    public int k() {
        return this.f56905h;
    }

    public synchronized boolean l() {
        return this.f56911n;
    }

    public synchronized void m(boolean z10) {
        this.f56909l = z10 | this.f56909l;
        this.f56910m = true;
        notifyAll();
    }

    public l1 n() {
        hd.a.i(!this.f56908k);
        if (this.f56906i == g.f56663b) {
            hd.a.a(this.f56907j);
        }
        this.f56908k = true;
        this.f56899b.c(this);
        return this;
    }

    public l1 o(boolean z10) {
        hd.a.i(!this.f56908k);
        this.f56907j = z10;
        return this;
    }

    @Deprecated
    public l1 p(Handler handler) {
        return q(handler.getLooper());
    }

    public l1 q(Looper looper) {
        hd.a.i(!this.f56908k);
        this.f56904g = looper;
        return this;
    }

    public l1 r(@g.p0 Object obj) {
        hd.a.i(!this.f56908k);
        this.f56903f = obj;
        return this;
    }

    public l1 s(int i10, long j10) {
        hd.a.i(!this.f56908k);
        hd.a.a(j10 != g.f56663b);
        if (i10 < 0 || (!this.f56901d.r() && i10 >= this.f56901d.q())) {
            throw new IllegalSeekPositionException(this.f56901d, i10, j10);
        }
        this.f56905h = i10;
        this.f56906i = j10;
        return this;
    }

    public l1 t(long j10) {
        hd.a.i(!this.f56908k);
        this.f56906i = j10;
        return this;
    }

    public l1 u(int i10) {
        hd.a.i(!this.f56908k);
        this.f56902e = i10;
        return this;
    }
}
