package ds;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.m0;
import org.bouncycastle.operator.OperatorCreationException;
import zo.a0;
import zo.c0;
import zo.d0;
import zo.e0;
import zo.f0;
import zo.g0;
import zo.h0;
import zo.j0;
import zo.k0;
import zo.z;

/* JADX INFO: loaded from: classes6.dex */
public class j implements ds.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f26491a = b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ds.l f26492b = new j();

    public static class a implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new j0(128);
        }
    }

    public static class b implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new j0(256);
        }
    }

    public static class c implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new x(new j0(128), gm.t.I(bVar.A()).Q());
        }
    }

    public static class d implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new x(new j0(256), gm.t.I(bVar.A()).Q());
        }
    }

    public static class e implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.u();
        }
    }

    public static class f implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.t();
        }
    }

    public static class g implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.s();
        }
    }

    public static class h implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.h();
        }
    }

    public static class i implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.j();
        }
    }

    /* JADX INFO: renamed from: ds.j$j, reason: collision with other inner class name */
    public static class C0300j implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.k();
        }
    }

    public static class k implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new c0();
        }
    }

    public static class l implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new zo.y();
        }
    }

    public static class m implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new z();
        }
    }

    public static class n implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new a0();
        }
    }

    public static class o implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new k0();
        }
    }

    public static class p implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new d0();
        }
    }

    public static class q implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new e0();
        }
    }

    public static class r implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new f0();
        }
    }

    public static class s implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new h0();
        }
    }

    public static class t implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new g0(224);
        }
    }

    public static class u implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new g0(256);
        }
    }

    public static class v implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new g0(384);
        }
    }

    public static class w implements ds.l {
        @Override // ds.l
        public org.bouncycastle.crypto.v a(zn.b bVar) {
            return new g0(512);
        }
    }

    public static class x implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0 f26493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f26494b;

        public x(m0 m0Var, int i10) {
            this.f26493a = m0Var;
            this.f26494b = i10;
        }

        @Override // org.bouncycastle.crypto.s
        public String b() {
            return this.f26493a.b() + "-" + this.f26494b;
        }

        @Override // org.bouncycastle.crypto.s
        public int c(byte[] bArr, int i10) {
            return f(bArr, i10, h());
        }

        @Override // org.bouncycastle.crypto.m0
        public int e(byte[] bArr, int i10, int i11) {
            return this.f26493a.e(bArr, i10, i11);
        }

        @Override // org.bouncycastle.crypto.m0
        public int f(byte[] bArr, int i10, int i11) {
            return this.f26493a.f(bArr, i10, i11);
        }

        @Override // org.bouncycastle.crypto.v
        public int g() {
            return this.f26493a.g();
        }

        @Override // org.bouncycastle.crypto.s
        public int h() {
            return (this.f26494b + 7) / 8;
        }

        @Override // org.bouncycastle.crypto.s
        public void reset() {
            this.f26493a.reset();
        }

        @Override // org.bouncycastle.crypto.s
        public void update(byte b10) {
            this.f26493a.update(b10);
        }

        @Override // org.bouncycastle.crypto.s
        public void update(byte[] bArr, int i10, int i11) {
            this.f26493a.update(bArr, i10, i11);
        }
    }

    public static Map b() {
        HashMap map = new HashMap();
        map.put(on.b.f44365i, new k());
        map.put(kn.d.f37598f, new p());
        map.put(kn.d.f37592c, new q());
        map.put(kn.d.f37594d, new r());
        map.put(kn.d.f37596e, new s());
        map.put(kn.d.f37604i, new t());
        map.put(kn.d.f37606j, new u());
        map.put(kn.d.f37608k, new v());
        map.put(kn.d.f37610l, new w());
        map.put(kn.d.f37612m, new a());
        map.put(kn.d.f37614n, new b());
        map.put(kn.d.f37619s, new c());
        map.put(kn.d.f37620t, new d());
        map.put(pn.s.f46803f4, new e());
        map.put(pn.s.f46800e4, new f());
        map.put(pn.s.f46797d4, new g());
        map.put(qm.a.f47452b, new h());
        map.put(qn.a.f47513c, new i());
        map.put(qn.a.f47514d, new C0300j());
        map.put(tn.b.f51361c, new l());
        map.put(tn.b.f51360b, new m());
        map.put(tn.b.f51362d, new n());
        map.put(xm.b.f55616b0, new o());
        return Collections.unmodifiableMap(map);
    }

    @Override // ds.l
    public org.bouncycastle.crypto.v a(zn.b bVar) throws OperatorCreationException {
        ds.l lVar = (ds.l) f26491a.get(bVar.x());
        if (lVar != null) {
            return lVar.a(bVar);
        }
        throw new OperatorCreationException("cannot recognise digest");
    }
}
