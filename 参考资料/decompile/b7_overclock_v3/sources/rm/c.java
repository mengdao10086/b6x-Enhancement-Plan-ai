package rm;

import gm.f0;
import gm.h0;
import gm.j2;
import gm.n2;
import lm.b0;
import zn.s0;
import zn.t;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f48834k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f48835l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48836m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48837n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48838o = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48839a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f48840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f48841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.t f48842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f48843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b0 f48844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s0 f48845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h0 f48846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f0 f48847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f48848j;

    public c(g gVar, t tVar, gm.t tVar2, j jVar) {
        this.f48840b = gVar;
        this.f48841c = tVar;
        this.f48842d = tVar2;
        this.f48843e = jVar;
    }

    public b a() {
        gm.i iVar = new gm.i(10);
        if (this.f48839a != 1) {
            iVar.a(new gm.t(this.f48839a));
        }
        iVar.a(this.f48840b);
        iVar.a(this.f48841c);
        iVar.a(this.f48842d);
        iVar.a(this.f48843e);
        b0 b0Var = this.f48844f;
        if (b0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) b0Var));
        }
        s0 s0Var = this.f48845g;
        if (s0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) s0Var));
        }
        h0 h0Var = this.f48846h;
        if (h0Var != null) {
            iVar.a(new n2(false, 2, (gm.h) h0Var));
        }
        f0 f0Var = this.f48847i;
        if (f0Var != null) {
            iVar.a(new n2(false, 3, (gm.h) f0Var));
        }
        z zVar = this.f48848j;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return b.C(new j2(iVar));
    }

    public void b(n[] nVarArr) {
        this.f48847i = new j2(nVarArr);
    }

    public void c(g gVar) {
        this.f48840b = gVar;
    }

    public void d(b0 b0Var) {
        this.f48844f = b0Var;
    }

    public void e(z zVar) {
        this.f48848j = zVar;
    }

    public void f(t tVar) {
        this.f48841c = tVar;
    }

    public void g(s0 s0Var) {
        this.f48845g = s0Var;
    }

    public void h(h0 h0Var) {
        this.f48846h = h0Var;
    }

    public void i(j jVar) {
        this.f48843e = jVar;
    }

    public void j(gm.t tVar) {
        this.f48842d = tVar;
    }

    public void k(int i10) {
        this.f48839a = i10;
    }
}
