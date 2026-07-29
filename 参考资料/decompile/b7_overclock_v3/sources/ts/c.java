package ts;

import gm.c0;
import gm.y;
import gm.z;
import is.k;
import is.l;
import is.m;
import is.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.lms.v;
import org.bouncycastle.pqc.crypto.xmss.d0;
import org.bouncycastle.pqc.crypto.xmss.f0;
import org.bouncycastle.pqc.crypto.xmss.w;
import org.bouncycastle.pqc.crypto.xmss.y;
import org.bouncycastle.util.o;
import pn.s;
import rs.j;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f51621a;

    public static class b extends g {
        public b() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            byte[] bArrJ = z.I(c1Var.D()).J();
            if (o.a(bArrJ, 0) == 1) {
                return v.f(org.bouncycastle.util.a.W(bArrJ, 4, bArrJ.length));
            }
            if (bArrJ.length == 64) {
                bArrJ = org.bouncycastle.util.a.W(bArrJ, 4, bArrJ.length);
            }
            return org.bouncycastle.pqc.crypto.lms.g.d(bArrJ);
        }
    }

    /* JADX INFO: renamed from: ts.c$c, reason: collision with other inner class name */
    public static class C0592c extends g {
        public C0592c() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            is.d dVarZ = is.d.z(c1Var.D());
            return new ms.h(dVarZ.A(), dVarZ.B(), dVarZ.y(), ts.e.c(dVarZ.x().x()));
        }
    }

    public static class d extends g {
        public d() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            return new ns.h(c1Var.C().H());
        }
    }

    public static class e extends g {
        public e() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            return new os.f(ts.e.e(c1Var.x()), c1Var.C().L());
        }
    }

    public static class f extends g {
        public f() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            return new j(c1Var.C().H(), ts.e.g(k.x(c1Var.x().A())));
        }
    }

    public static abstract class g {
        public g() {
        }

        public abstract np.c a(c1 c1Var, Object obj) throws IOException;
    }

    public static class h extends g {
        public h() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            f0.b bVarF;
            l lVarY = l.y(c1Var.x().A());
            if (lVarY != null) {
                y yVarX = lVarY.z().x();
                q qVarX = q.x(c1Var.D());
                bVarF = new f0.b(new d0(lVarY.x(), ts.e.b(yVarX))).g(qVarX.y()).h(qVarX.z());
            } else {
                byte[] bArrJ = z.I(c1Var.D()).J();
                bVarF = new f0.b(d0.k(o.a(bArrJ, 0))).f(bArrJ);
            }
            return bVarF.e();
        }
    }

    public static class i extends g {
        public i() {
            super();
        }

        @Override // ts.c.g
        public np.c a(c1 c1Var, Object obj) throws IOException {
            y.b bVarF;
            m mVarY = m.y(c1Var.x().A());
            if (mVarY != null) {
                gm.y yVarX = mVarY.A().x();
                q qVarX = q.x(c1Var.D());
                bVarF = new y.b(new w(mVarY.x(), mVarY.z(), ts.e.b(yVarX))).g(qVarX.y()).h(qVarX.z());
            } else {
                byte[] bArrJ = z.I(c1Var.D()).J();
                bVarF = new y.b(w.k(o.a(bArrJ, 0))).f(bArrJ);
            }
            return bVarF.e();
        }
    }

    static {
        HashMap map = new HashMap();
        f51621a = map;
        map.put(is.g.X, new e());
        f51621a.put(is.g.Y, new e());
        f51621a.put(is.g.f35791r, new f());
        f51621a.put(is.g.f35795v, new d());
        f51621a.put(is.g.f35796w, new h());
        f51621a.put(is.g.F, new i());
        f51621a.put(bn.a.f9499a, new h());
        f51621a.put(bn.a.f9500b, new i());
        f51621a.put(s.f46801e5, new b());
        f51621a.put(is.g.f35787n, new C0592c());
    }

    public static np.c a(InputStream inputStream) throws IOException {
        return b(c1.A(new gm.s(inputStream).n()));
    }

    public static np.c b(c1 c1Var) throws IOException {
        return c(c1Var, null);
    }

    public static np.c c(c1 c1Var, Object obj) throws IOException {
        zn.b bVarX = c1Var.x();
        g gVar = (g) f51621a.get(bVarX.x());
        if (gVar != null) {
            return gVar.a(c1Var, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + bVarX.x());
    }

    public static np.c d(byte[] bArr) throws IOException {
        return b(c1.A(c0.D(bArr)));
    }
}
