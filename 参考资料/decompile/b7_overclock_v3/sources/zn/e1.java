package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class e1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f58708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f58709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xn.d f58710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j1 f58711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j1 f58712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public xn.d f58713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c1 f58714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.d f58715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gm.d f58716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public z f58717l;

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e1(gm.f0 r10) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.e1.<init>(gm.f0):void");
    }

    public static e1 A(Object obj) {
        if (obj instanceof e1) {
            return (e1) obj;
        }
        if (obj != null) {
            return new e1(gm.f0.J(obj));
        }
        return null;
    }

    public static e1 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public xn.d B() {
        return this.f58710e;
    }

    public gm.d C() {
        return this.f58715j;
    }

    public gm.t D() {
        return this.f58708c;
    }

    public b E() {
        return this.f58709d;
    }

    public j1 F() {
        return this.f58711f;
    }

    public xn.d G() {
        return this.f58713h;
    }

    public c1 H() {
        return this.f58714i;
    }

    public gm.d I() {
        return this.f58716k;
    }

    public gm.t J() {
        return this.f58707b;
    }

    public int K() {
        return this.f58707b.Q() + 1;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        if (org.bouncycastle.util.p.c("org.bouncycastle.x509.allow_non-der_tbscert") != null && !org.bouncycastle.util.p.d("org.bouncycastle.x509.allow_non-der_tbscert")) {
            gm.i iVar = new gm.i();
            if (!this.f58707b.L(0)) {
                iVar.a(new n2(true, 0, (gm.h) this.f58707b));
            }
            iVar.a(this.f58708c);
            iVar.a(this.f58709d);
            iVar.a(this.f58710e);
            gm.i iVar2 = new gm.i(2);
            iVar2.a(this.f58711f);
            iVar2.a(this.f58712g);
            iVar.a(new j2(iVar2));
            gm.h j2Var = this.f58713h;
            if (j2Var == null) {
                j2Var = new j2();
            }
            iVar.a(j2Var);
            iVar.a(this.f58714i);
            gm.d dVar = this.f58715j;
            if (dVar != null) {
                iVar.a(new n2(false, 1, (gm.h) dVar));
            }
            gm.d dVar2 = this.f58716k;
            if (dVar2 != null) {
                iVar.a(new n2(false, 2, (gm.h) dVar2));
            }
            z zVar = this.f58717l;
            if (zVar != null) {
                iVar.a(new n2(true, 3, (gm.h) zVar));
            }
            return new j2(iVar);
        }
        return this.f58706a;
    }

    public j1 x() {
        return this.f58712g;
    }

    public z y() {
        return this.f58717l;
    }
}
