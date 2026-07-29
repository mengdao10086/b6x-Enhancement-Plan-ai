package om;

import gm.c0;
import gm.f0;
import gm.n0;
import java.util.Enumeration;
import zn.c1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class g extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f44282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f44283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f44284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f44285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xn.d f44286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f44287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xn.d f44288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c1 f44289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.d f44290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.d f44291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z f44292k;

    public g(f0 f0Var) {
        this.f44282a = f0Var;
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            switch (n0Var.q()) {
                case 0:
                    this.f44283b = gm.t.H(n0Var, false);
                    break;
                case 1:
                    this.f44284c = gm.t.H(n0Var, false);
                    break;
                case 2:
                    this.f44285d = zn.b.y(n0Var, false);
                    break;
                case 3:
                    this.f44286e = xn.d.z(n0Var, true);
                    break;
                case 4:
                    this.f44287f = n.x(f0.I(n0Var, false));
                    break;
                case 5:
                    this.f44288g = xn.d.z(n0Var, true);
                    break;
                case 6:
                    this.f44289h = c1.z(n0Var, false);
                    break;
                case 7:
                    this.f44290i = gm.d.J(n0Var, false);
                    break;
                case 8:
                    this.f44291j = gm.d.J(n0Var, false);
                    break;
                case 9:
                    this.f44292k = z.F(n0Var, false);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag: " + n0Var.q());
            }
        }
    }

    public static g y(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f44290i;
    }

    public c1 B() {
        return this.f44289h;
    }

    public gm.t C() {
        return this.f44284c;
    }

    public zn.b D() {
        return this.f44285d;
    }

    public xn.d E() {
        return this.f44288g;
    }

    public gm.d F() {
        return this.f44291j;
    }

    public n G() {
        return this.f44287f;
    }

    public int H() {
        gm.t tVar = this.f44283b;
        if (tVar != null) {
            return tVar.Q();
        }
        return -1;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f44282a;
    }

    public z x() {
        return this.f44292k;
    }

    public xn.d z() {
        return this.f44286e;
    }
}
