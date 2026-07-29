package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f52300f = new y("1.3.6.1.5.5.11.0.2.1");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f52301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f52302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f52303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f52304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f52305e;

    public g(f0 f0Var) {
        this.f52301a = new t(1L);
        if (f0Var.size() < 3 && f0Var.size() > 5) {
            throw new IllegalArgumentException("wrong sequence size in constructor: " + f0Var.size());
        }
        t tVarI = t.I(f0Var.K(0));
        if (!tVarI.L(1)) {
            throw new IllegalArgumentException("incompatible version");
        }
        this.f52301a = tVarI;
        this.f52302b = f0.J(f0Var.K(1));
        for (int i10 = 2; i10 != f0Var.size() - 1; i10++) {
            gm.h hVarK = f0Var.K(i10);
            if (!(hVarK instanceof n0)) {
                throw new IllegalArgumentException("unknown object in getInstance: " + hVarK.getClass().getName());
            }
            n0 n0Var = (n0) hVarK;
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f52303c = e.y(n0Var, false);
            } else {
                if (iQ != 1) {
                    throw new IllegalArgumentException("unknown tag in getInstance: " + n0Var.q());
                }
                this.f52304d = f.y(n0Var, false);
            }
        }
        this.f52305e = d.z(f0Var.K(f0Var.size() - 1));
    }

    public g(e eVar, f fVar, b bVar) {
        this.f52301a = new t(1L);
        this.f52302b = new j2(bVar.y());
        this.f52303c = eVar;
        this.f52304d = fVar;
        this.f52305e = new d(new c(bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(un.g r5, un.d r6, un.b r7) {
        /*
            r4 = this;
            r4.<init>()
            gm.t r0 = new gm.t
            r1 = 1
            r0.<init>(r1)
            r4.f52301a = r0
            gm.t r0 = r5.f52301a
            r4.f52301a = r0
            if (r7 == 0) goto L45
            zn.b r7 = r7.y()
            gm.i r0 = new gm.i
            r0.<init>()
            gm.f0 r1 = r5.f52302b
            java.util.Enumeration r1 = r1.L()
            r2 = 0
        L22:
            boolean r3 = r1.hasMoreElements()
            if (r3 == 0) goto L3a
            java.lang.Object r3 = r1.nextElement()
            zn.b r3 = zn.b.z(r3)
            r0.a(r3)
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L22
            r2 = 1
        L3a:
            if (r2 != 0) goto L45
            r0.a(r7)
            gm.j2 r7 = new gm.j2
            r7.<init>(r0)
            goto L47
        L45:
            gm.f0 r7 = r5.f52302b
        L47:
            r4.f52302b = r7
            un.e r7 = r5.f52303c
            r4.f52303c = r7
            un.f r5 = r5.f52304d
            r4.f52304d = r5
            r4.f52305e = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: un.g.<init>(un.g, un.d, un.b):void");
    }

    public g(zn.b[] bVarArr, e eVar, f fVar, d dVar) {
        this.f52301a = new t(1L);
        this.f52302b = new j2(bVarArr);
        this.f52303c = eVar;
        this.f52304d = fVar;
        this.f52305e = dVar;
    }

    public static g A(n0 n0Var, boolean z10) {
        return B(f0.I(n0Var, z10));
    }

    public static g B(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f52301a);
        iVar.a(this.f52302b);
        e eVar = this.f52303c;
        if (eVar != null) {
            iVar.a(new n2(false, 0, (gm.h) eVar));
        }
        f fVar = this.f52304d;
        if (fVar != null) {
            iVar.a(new n2(false, 1, (gm.h) fVar));
        }
        iVar.a(this.f52305e);
        return new j2(iVar);
    }

    public String toString() {
        return "EvidenceRecord: Oid(" + f52300f + ee.a.f26979d;
    }

    public g x(b bVar, boolean z10) {
        if (z10) {
            return new g(this, this.f52305e.x(new c(bVar)), bVar);
        }
        c[] cVarArrY = this.f52305e.y();
        cVarArrY[cVarArrY.length - 1] = cVarArrY[cVarArrY.length - 1].x(bVar);
        return new g(this, new d(cVarArrY), (b) null);
    }

    public d y() {
        return this.f52305e;
    }

    public zn.b[] z() {
        int size = this.f52302b.size();
        zn.b[] bVarArr = new zn.b[size];
        for (int i10 = 0; i10 != size; i10++) {
            bVarArr[i10] = zn.b.z(this.f52302b.K(i10));
        }
        return bVarArr;
    }
}
