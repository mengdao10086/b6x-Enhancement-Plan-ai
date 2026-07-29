package lm;

import gm.f2;
import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f40014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b0 f40015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b0 f40016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.o f40017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f40018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.z f40019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.z f40020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gm.z f40021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.z f40022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.z f40023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f40024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gm.f0 f40025l;

    public x(int i10, zn.b0 b0Var, zn.b0 b0Var2) {
        this(new gm.t(i10), b0Var, b0Var2);
    }

    public x(gm.t tVar, zn.b0 b0Var, zn.b0 b0Var2) {
        this.f40014a = tVar;
        this.f40015b = b0Var;
        this.f40016c = b0Var2;
    }

    public static gm.f0 c(o oVar) {
        return new j2(oVar);
    }

    public static gm.f0 d(o[] oVarArr) {
        if (oVarArr != null) {
            return new j2(oVarArr);
        }
        return null;
    }

    public final void a(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(true, i10, hVar));
        }
    }

    public w b() {
        gm.i iVar = new gm.i(12);
        iVar.a(this.f40014a);
        iVar.a(this.f40015b);
        iVar.a(this.f40016c);
        a(iVar, 0, this.f40017d);
        a(iVar, 1, this.f40018e);
        a(iVar, 2, this.f40019f);
        a(iVar, 3, this.f40020g);
        a(iVar, 4, this.f40021h);
        a(iVar, 5, this.f40022i);
        a(iVar, 6, this.f40023j);
        a(iVar, 7, this.f40024k);
        a(iVar, 8, this.f40025l);
        this.f40017d = null;
        this.f40018e = null;
        this.f40019f = null;
        this.f40020g = null;
        this.f40021h = null;
        this.f40022i = null;
        this.f40023j = null;
        this.f40024k = null;
        this.f40025l = null;
        return w.A(new j2(iVar));
    }

    public x e(v vVar) {
        this.f40024k = vVar;
        return this;
    }

    public x f(gm.f0 f0Var) {
        this.f40025l = f0Var;
        return this;
    }

    public x g(o oVar) {
        return f(c(oVar));
    }

    public x h(o[] oVarArr) {
        return f(d(oVarArr));
    }

    public x i(gm.o oVar) {
        this.f40017d = oVar;
        return this;
    }

    public x j(zn.b bVar) {
        this.f40018e = bVar;
        return this;
    }

    public x k(gm.z zVar) {
        this.f40020g = zVar;
        return this;
    }

    public x l(byte[] bArr) {
        return k(bArr == null ? null : new f2(bArr));
    }

    public x m(gm.z zVar) {
        this.f40023j = zVar;
        return this;
    }

    public x n(byte[] bArr) {
        return m(bArr == null ? null : new f2(bArr));
    }

    public x o(gm.z zVar) {
        this.f40019f = zVar;
        return this;
    }

    public x p(byte[] bArr) {
        return o(bArr == null ? null : new f2(bArr));
    }

    public x q(gm.z zVar) {
        this.f40022i = zVar;
        return this;
    }

    public x r(byte[] bArr) {
        return q(bArr == null ? null : new f2(bArr));
    }

    public x s(gm.z zVar) {
        this.f40021h = zVar;
        return this;
    }

    public x t(byte[] bArr) {
        return s(bArr == null ? null : new f2(bArr));
    }
}
