package nb;

import g.i1;
import hb.a0;
import hb.b0;
import hd.u;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @i1
    public static final long f42018h = 100000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f42019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f42020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f42021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f42022g;

    public b(long j10, long j11, long j12) {
        this.f42022g = j10;
        this.f42019d = j12;
        u uVar = new u();
        this.f42020e = uVar;
        u uVar2 = new u();
        this.f42021f = uVar2;
        uVar.a(0L);
        uVar2.a(j11);
    }

    @Override // nb.g
    public long a(long j10) {
        return this.f42020e.b(u0.g(this.f42021f, j10, true, true));
    }

    public boolean b(long j10) {
        u uVar = this.f42020e;
        return j10 - uVar.b(uVar.c() - 1) < 100000;
    }

    public void c(long j10, long j11) {
        if (b(j10)) {
            return;
        }
        this.f42020e.a(j10);
        this.f42021f.a(j11);
    }

    @Override // nb.g
    public long d() {
        return this.f42019d;
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    public void f(long j10) {
        this.f42022g = j10;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        int iG = u0.g(this.f42020e, j10, true, true);
        b0 b0Var = new b0(this.f42020e.b(iG), this.f42021f.b(iG));
        if (b0Var.f30805a == j10 || iG == this.f42020e.c() - 1) {
            return new a0.a(b0Var);
        }
        int i10 = iG + 1;
        return new a0.a(b0Var, new b0(this.f42020e.b(i10), this.f42021f.b(i10)));
    }

    @Override // hb.a0
    public long h() {
        return this.f42022g;
    }
}
