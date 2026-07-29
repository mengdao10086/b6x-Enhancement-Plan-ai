package km;

import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.t f37536d = new gm.t(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f37537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f37538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.d f37539c;

    public class b extends gm.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gm.t f37540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xn.d f37541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final gm.f0 f37542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final gm.h0 f37543d;

        public b(gm.f0 f0Var) {
            if (f0Var.size() != 4) {
                throw new IllegalArgumentException("incorrect sequence size for CertificationRequestInfo");
            }
            this.f37540a = gm.t.I(f0Var.K(0));
            this.f37541b = xn.d.A(f0Var.K(1));
            gm.f0 f0VarJ = gm.f0.J(f0Var.K(2));
            this.f37542c = f0VarJ;
            if (f0VarJ.size() != 2) {
                throw new IllegalArgumentException("incorrect subjectPublicKeyInfo size for CertificationRequestInfo");
            }
            n0 n0Var = (n0) f0Var.K(3);
            if (n0Var.q() != 0) {
                throw new IllegalArgumentException("incorrect tag number on attributes for CertificationRequestInfo");
            }
            this.f37543d = gm.h0.H(n0Var, false);
        }

        public b(xn.d dVar, zn.b bVar, gm.d dVar2, gm.h0 h0Var) {
            this.f37540a = n.f37536d;
            this.f37541b = dVar;
            this.f37542c = new j2(new gm.h[]{bVar, dVar2});
            this.f37543d = h0Var;
        }

        public final gm.h0 B() {
            return this.f37543d;
        }

        public final xn.d C() {
            return this.f37541b;
        }

        public final gm.f0 D() {
            return this.f37542c;
        }

        public final gm.t E() {
            return this.f37540a;
        }

        @Override // gm.w, gm.h
        public gm.c0 b() {
            gm.i iVar = new gm.i(4);
            iVar.a(this.f37540a);
            iVar.a(this.f37541b);
            iVar.a(this.f37542c);
            iVar.a(new n2(false, 0, (gm.h) this.f37543d));
            return new j2(iVar);
        }
    }

    public n(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37537a = new b(gm.f0.J(f0Var.K(0)));
        this.f37538b = zn.b.z(f0Var.K(1));
        this.f37539c = u1.S(f0Var.K(2));
    }

    public n(xn.d dVar, zn.b bVar, gm.d dVar2, gm.h0 h0Var, zn.b bVar2, gm.d dVar3) {
        this.f37537a = new b(dVar, bVar, dVar2, h0Var);
        this.f37538b = bVar2;
        this.f37539c = dVar3;
    }

    public static n z(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(gm.f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f37539c;
    }

    public zn.b B() {
        return this.f37538b;
    }

    public xn.d C() {
        return this.f37537a.C();
    }

    public gm.d D() {
        return u1.S(this.f37537a.D().K(1));
    }

    public zn.b E() {
        return zn.b.z(this.f37537a.D().K(0));
    }

    public BigInteger F() {
        return this.f37537a.E().K();
    }

    public gm.c0 G() throws IOException {
        return gm.c0.D(D().L());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37537a);
        iVar.a(this.f37538b);
        iVar.a(this.f37539c);
        return new j2(iVar);
    }

    public gm.h0 y() {
        return this.f37537a.B();
    }
}
