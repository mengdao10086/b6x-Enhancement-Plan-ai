package om;

import gm.c0;
import gm.d2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class u extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f44341c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44342d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f44343e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44344f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f44346b;

    public u() {
        this.f44345a = 0;
        this.f44346b = d2.f29657b;
    }

    public u(int i10, r rVar) {
        this.f44345a = i10;
        this.f44346b = rVar;
    }

    public u(n0 n0Var) {
        gm.h hVarY;
        int iQ = n0Var.q();
        this.f44345a = iQ;
        if (iQ == 0) {
            hVarY = d2.f29657b;
        } else if (iQ == 1) {
            hVarY = s.y(n0Var, false);
        } else {
            if (iQ != 2 && iQ != 3) {
                throw new IllegalArgumentException("unknown tag: " + this.f44345a);
            }
            hVarY = r.x(n0Var, true);
        }
        this.f44346b = hVarY;
    }

    public u(s sVar) {
        this.f44345a = 1;
        this.f44346b = sVar;
    }

    public static u x(Object obj) {
        if (obj == null || (obj instanceof u)) {
            return (u) obj;
        }
        if (obj instanceof n0) {
            return new u((n0) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new n2(false, this.f44345a, this.f44346b);
    }

    public gm.h y() {
        return this.f44346b;
    }

    public int z() {
        return this.f44345a;
    }
}
