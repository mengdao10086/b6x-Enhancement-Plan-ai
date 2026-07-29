package bd;

import com.google.android.exoplayer2.Format;
import g.v0;
import hd.v;
import hd.w;
import ya.p1;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public abstract class o extends com.google.android.exoplayer2.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f9375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f9376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f9377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9378p;

    public o(int i10, e eVar, p pVar, k kVar) {
        super(i10);
        this.f9375m = eVar;
        this.f9376n = pVar;
        this.f9377o = kVar;
    }

    @Override // com.google.android.exoplayer2.a
    public final void H(boolean z10, boolean z11) {
        this.f9375m.e();
        this.f9376n.a(h(), 0L);
    }

    @Override // com.google.android.exoplayer2.a
    public final void K() {
        this.f9378p = true;
    }

    @Override // com.google.android.exoplayer2.a
    public final void L() {
        this.f9378p = false;
    }

    @Override // ya.q1
    public final int a(Format format) {
        String str = format.f16699l;
        return w.l(str) != h() ? p1.a(0) : this.f9375m.g(str) ? p1.a(4) : p1.a(1);
    }

    @Override // ya.o1
    public final boolean d() {
        return F();
    }

    @Override // com.google.android.exoplayer2.a, ya.o1
    public final v x() {
        return this.f9376n;
    }
}
