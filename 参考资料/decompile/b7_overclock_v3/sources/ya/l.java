package ya;

import com.google.android.exoplayer2.ExoPlaybackException;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements hd.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.l0 f56891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f56892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public o1 f56893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.p0
    public hd.v f56894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56895e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f56896f;

    public interface a {
        void b(h1 h1Var);
    }

    public l(a aVar, hd.c cVar) {
        this.f56892b = aVar;
        this.f56891a = new hd.l0(cVar);
    }

    public void a(o1 o1Var) {
        if (o1Var == this.f56893c) {
            this.f56894d = null;
            this.f56893c = null;
            this.f56895e = true;
        }
    }

    public void b(o1 o1Var) throws ExoPlaybackException {
        hd.v vVar;
        hd.v vVarX = o1Var.x();
        if (vVarX == null || vVarX == (vVar = this.f56894d)) {
            return;
        }
        if (vVar != null) {
            throw ExoPlaybackException.i(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f56894d = vVarX;
        this.f56893c = o1Var;
        vVarX.c(this.f56891a.e());
    }

    @Override // hd.v
    public void c(h1 h1Var) {
        hd.v vVar = this.f56894d;
        if (vVar != null) {
            vVar.c(h1Var);
            h1Var = this.f56894d.e();
        }
        this.f56891a.c(h1Var);
    }

    public void d(long j10) {
        this.f56891a.a(j10);
    }

    @Override // hd.v
    public h1 e() {
        hd.v vVar = this.f56894d;
        return vVar != null ? vVar.e() : this.f56891a.e();
    }

    public final boolean f(boolean z10) {
        o1 o1Var = this.f56893c;
        return o1Var == null || o1Var.b() || (!this.f56893c.d() && (z10 || this.f56893c.i()));
    }

    public void g() {
        this.f56896f = true;
        this.f56891a.b();
    }

    public void h() {
        this.f56896f = false;
        this.f56891a.d();
    }

    public long i(boolean z10) {
        j(z10);
        return n();
    }

    public final void j(boolean z10) {
        if (f(z10)) {
            this.f56895e = true;
            if (this.f56896f) {
                this.f56891a.b();
                return;
            }
            return;
        }
        hd.v vVar = (hd.v) hd.a.g(this.f56894d);
        long jN = vVar.n();
        if (this.f56895e) {
            if (jN < this.f56891a.n()) {
                this.f56891a.d();
                return;
            } else {
                this.f56895e = false;
                if (this.f56896f) {
                    this.f56891a.b();
                }
            }
        }
        this.f56891a.a(jN);
        h1 h1VarE = vVar.e();
        if (h1VarE.equals(this.f56891a.e())) {
            return;
        }
        this.f56891a.c(h1VarE);
        this.f56892b.b(h1VarE);
    }

    @Override // hd.v
    public long n() {
        return this.f56895e ? this.f56891a.n() : ((hd.v) hd.a.g(this.f56894d)).n();
    }
}
