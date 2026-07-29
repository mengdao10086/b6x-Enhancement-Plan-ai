package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import ec.d0;
import g.p0;
import hd.v;
import java.io.IOException;
import ya.n1;
import ya.o1;
import ya.p1;
import ya.q1;
import ya.r1;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements o1, q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16740a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public r1 f16742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public d0 f16745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Format[] f16746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f16747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16748i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16751l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f16741b = new s0();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16749j = Long.MIN_VALUE;

    public a(int i10) {
        this.f16740a = i10;
    }

    public final r1 A() {
        return (r1) hd.a.g(this.f16742c);
    }

    public final s0 B() {
        this.f16741b.a();
        return this.f16741b;
    }

    public final int C() {
        return this.f16743d;
    }

    public final long D() {
        return this.f16748i;
    }

    public final Format[] E() {
        return (Format[]) hd.a.g(this.f16746g);
    }

    public final boolean F() {
        return i() ? this.f16750k : ((d0) hd.a.g(this.f16745f)).d();
    }

    public void G() {
    }

    public void H(boolean z10, boolean z11) throws ExoPlaybackException {
    }

    public void I(long j10, boolean z10) throws ExoPlaybackException {
    }

    public void J() {
    }

    public void K() throws ExoPlaybackException {
    }

    public void L() {
    }

    public void M(Format[] formatArr, long j10, long j11) throws ExoPlaybackException {
    }

    public final int N(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
        int iK = ((d0) hd.a.g(this.f16745f)).k(s0Var, decoderInputBuffer, z10);
        if (iK == -4) {
            if (decoderInputBuffer.m()) {
                this.f16749j = Long.MIN_VALUE;
                return this.f16750k ? -4 : -3;
            }
            long j10 = decoderInputBuffer.f16962e + this.f16747h;
            decoderInputBuffer.f16962e = j10;
            this.f16749j = Math.max(this.f16749j, j10);
        } else if (iK == -5) {
            Format format = (Format) hd.a.g(s0Var.f57068b);
            if (format.f16703p != Long.MAX_VALUE) {
                s0Var.f57068b = format.a().i0(format.f16703p + this.f16747h).E();
            }
        }
        return iK;
    }

    public int O(long j10) {
        return ((d0) hd.a.g(this.f16745f)).o(j10 - this.f16747h);
    }

    @Override // ya.o1
    public final void f(int i10) {
        this.f16743d = i10;
    }

    @Override // ya.o1
    public final void g() {
        hd.a.i(this.f16744e == 1);
        this.f16741b.a();
        this.f16744e = 0;
        this.f16745f = null;
        this.f16746g = null;
        this.f16750k = false;
        G();
    }

    @Override // ya.o1
    public final int getState() {
        return this.f16744e;
    }

    @Override // ya.o1, ya.q1
    public final int h() {
        return this.f16740a;
    }

    @Override // ya.o1
    public final boolean i() {
        return this.f16749j == Long.MIN_VALUE;
    }

    @Override // ya.o1
    public final void j() {
        this.f16750k = true;
    }

    @Override // ya.o1
    public final void k(r1 r1Var, Format[] formatArr, d0 d0Var, long j10, boolean z10, boolean z11, long j11, long j12) throws ExoPlaybackException {
        hd.a.i(this.f16744e == 0);
        this.f16742c = r1Var;
        this.f16744e = 1;
        this.f16748i = j10;
        H(z10, z11);
        l(formatArr, d0Var, j11, j12);
        I(j10, z10);
    }

    @Override // ya.o1
    public final void l(Format[] formatArr, d0 d0Var, long j10, long j11) throws ExoPlaybackException {
        hd.a.i(!this.f16750k);
        this.f16745f = d0Var;
        this.f16749j = j11;
        this.f16746g = formatArr;
        this.f16747h = j11;
        M(formatArr, j10, j11);
    }

    @Override // ya.o1
    public final q1 m() {
        return this;
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
    public void r(int i10, @p0 Object obj) throws ExoPlaybackException {
    }

    @Override // ya.o1
    public final void reset() {
        hd.a.i(this.f16744e == 0);
        this.f16741b.a();
        J();
    }

    @Override // ya.o1
    @p0
    public final d0 s() {
        return this.f16745f;
    }

    @Override // ya.o1
    public final void start() throws ExoPlaybackException {
        hd.a.i(this.f16744e == 1);
        this.f16744e = 2;
        K();
    }

    @Override // ya.o1
    public final void stop() {
        hd.a.i(this.f16744e == 2);
        this.f16744e = 1;
        L();
    }

    @Override // ya.o1
    public final void t() throws IOException {
        ((d0) hd.a.g(this.f16745f)).a();
    }

    @Override // ya.o1
    public final long u() {
        return this.f16749j;
    }

    @Override // ya.o1
    public final void v(long j10) throws ExoPlaybackException {
        this.f16750k = false;
        this.f16748i = j10;
        this.f16749j = j10;
        I(j10, false);
    }

    @Override // ya.o1
    public final boolean w() {
        return this.f16750k;
    }

    @Override // ya.o1
    @p0
    public v x() {
        return null;
    }

    public final ExoPlaybackException y(Throwable th2, @p0 Format format) {
        return z(th2, format, false);
    }

    public final ExoPlaybackException z(Throwable th2, @p0 Format format, boolean z10) {
        int i10;
        if (format == null || this.f16751l) {
            i10 = 4;
        } else {
            this.f16751l = true;
            try {
                int iD = p1.d(a(format));
                this.f16751l = false;
                i10 = iD;
            } catch (ExoPlaybackException unused) {
                this.f16751l = false;
                i10 = 4;
            } catch (Throwable th3) {
                this.f16751l = false;
                throw th3;
            }
        }
        return ExoPlaybackException.f(th2, getName(), C(), format, i10, z10);
    }
}
