package hd;

import ya.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f31079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f31081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f31082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h1 f31083e = h1.f56784d;

    public l0(c cVar) {
        this.f31079a = cVar;
    }

    public void a(long j10) {
        this.f31081c = j10;
        if (this.f31080b) {
            this.f31082d = this.f31079a.e();
        }
    }

    public void b() {
        if (this.f31080b) {
            return;
        }
        this.f31082d = this.f31079a.e();
        this.f31080b = true;
    }

    @Override // hd.v
    public void c(h1 h1Var) {
        if (this.f31080b) {
            a(n());
        }
        this.f31083e = h1Var;
    }

    public void d() {
        if (this.f31080b) {
            a(n());
            this.f31080b = false;
        }
    }

    @Override // hd.v
    public h1 e() {
        return this.f31083e;
    }

    @Override // hd.v
    public long n() {
        long j10 = this.f31081c;
        if (!this.f31080b) {
            return j10;
        }
        long jE = this.f31079a.e() - this.f31082d;
        h1 h1Var = this.f31083e;
        return j10 + (h1Var.f56785a == 1.0f ? ya.g.c(jE) : h1Var.a(jE));
    }
}
