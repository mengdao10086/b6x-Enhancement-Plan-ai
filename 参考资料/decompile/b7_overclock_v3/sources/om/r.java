package om;

import gm.c0;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class r extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f44328c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44329d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f44330e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44331f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f44332g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f44334b;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r(gm.n0 r4) {
        /*
            r3 = this;
            r3.<init>()
            int r0 = r4.q()
            r3.f44333a = r0
            r1 = 0
            if (r0 == 0) goto L37
            r2 = 1
            if (r0 == r2) goto L2a
            r2 = 2
            if (r0 == r2) goto L37
            r2 = 3
            if (r0 == r2) goto L25
            r2 = 4
            if (r0 != r2) goto L1d
            mm.t r4 = mm.t.z(r4, r1)
            goto L3b
        L1d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "unknown tag in POPOPrivKey"
            r4.<init>(r0)
            throw r4
        L25:
            om.q r4 = om.q.y(r4, r1)
            goto L3b
        L2a:
            gm.t r4 = gm.t.H(r4, r1)
            int r4 = r4.Q()
            om.w r4 = om.w.V(r4)
            goto L3b
        L37:
            gm.u1 r4 = gm.u1.R(r4, r1)
        L3b:
            r3.f44334b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: om.r.<init>(gm.n0):void");
    }

    public r(q qVar) {
        this.f44333a = 3;
        this.f44334b = qVar;
    }

    public r(w wVar) {
        this.f44333a = 1;
        this.f44334b = wVar;
    }

    public static r x(n0 n0Var, boolean z10) {
        return y(n0.S(n0Var, true));
    }

    public static r y(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj != null) {
            return new r(n0.T(obj));
        }
        return null;
    }

    public gm.h A() {
        return this.f44334b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new n2(false, this.f44333a, this.f44334b);
    }

    public int z() {
        return this.f44333a;
    }
}
