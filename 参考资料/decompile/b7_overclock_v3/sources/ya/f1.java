package ya;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f1 implements o1, q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r1 f56654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.p0
    public ec.d0 f56657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56658e;

    public void A(long j10) throws ExoPlaybackException {
    }

    public void B() {
    }

    public void C() throws ExoPlaybackException {
    }

    public void D() {
    }

    @Override // ya.q1
    public int a(Format format) throws ExoPlaybackException {
        return p1.a(0);
    }

    @Override // ya.o1
    public boolean b() {
        return true;
    }

    @g.p0
    public final r1 c() {
        return this.f56654a;
    }

    @Override // ya.o1
    public boolean d() {
        return true;
    }

    public final int e() {
        return this.f56655b;
    }

    @Override // ya.o1
    public final void f(int i10) {
        this.f56655b = i10;
    }

    @Override // ya.o1
    public final void g() {
        hd.a.i(this.f56656c == 1);
        this.f56656c = 0;
        this.f56657d = null;
        this.f56658e = false;
        n();
    }

    @Override // ya.o1
    public final int getState() {
        return this.f56656c;
    }

    @Override // ya.o1, ya.q1
    public final int h() {
        return 7;
    }

    @Override // ya.o1
    public final boolean i() {
        return true;
    }

    @Override // ya.o1
    public final void j() {
        this.f56658e = true;
    }

    @Override // ya.o1
    public final void k(r1 r1Var, Format[] formatArr, ec.d0 d0Var, long j10, boolean z10, boolean z11, long j11, long j12) throws ExoPlaybackException {
        hd.a.i(this.f56656c == 0);
        this.f56654a = r1Var;
        this.f56656c = 1;
        y(z10);
        l(formatArr, d0Var, j11, j12);
        z(j10, z10);
    }

    @Override // ya.o1
    public final void l(Format[] formatArr, ec.d0 d0Var, long j10, long j11) throws ExoPlaybackException {
        hd.a.i(!this.f56658e);
        this.f56657d = d0Var;
        A(j11);
    }

    @Override // ya.o1
    public final q1 m() {
        return this;
    }

    public void n() {
    }

    @Override // ya.o1
    public /* synthetic */ void o(float f10, float f11) throws ExoPlaybackException {
        n1.a(this, f10, f11);
    }

    @Override // ya.q1
    public int p() throws ExoPlaybackException {
        return 0;
    }

    @Override // ya.l1.b
    public void r(int i10, @g.p0 Object obj) throws ExoPlaybackException {
    }

    @Override // ya.o1
    public final void reset() {
        hd.a.i(this.f56656c == 0);
        B();
    }

    @Override // ya.o1
    @g.p0
    public final ec.d0 s() {
        return this.f56657d;
    }

    @Override // ya.o1
    public final void start() throws ExoPlaybackException {
        hd.a.i(this.f56656c == 1);
        this.f56656c = 2;
        C();
    }

    @Override // ya.o1
    public final void stop() {
        hd.a.i(this.f56656c == 2);
        this.f56656c = 1;
        D();
    }

    @Override // ya.o1
    public final void t() throws IOException {
    }

    @Override // ya.o1
    public long u() {
        return Long.MIN_VALUE;
    }

    @Override // ya.o1
    public final void v(long j10) throws ExoPlaybackException {
        this.f56658e = false;
        z(j10, false);
    }

    @Override // ya.o1
    public final boolean w() {
        return this.f56658e;
    }

    @Override // ya.o1
    @g.p0
    public hd.v x() {
        return null;
    }

    public void y(boolean z10) throws ExoPlaybackException {
    }

    public void z(long j10, boolean z10) throws ExoPlaybackException {
    }
}
