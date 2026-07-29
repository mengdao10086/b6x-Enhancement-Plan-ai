package to;

import cp.o0;
import cp.t;
import cp.u0;
import gm.y;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import np.n1;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.l0;
import org.bouncycastle.crypto.v;
import org.bouncycastle.operator.OperatorCreationException;
import pn.s;
import zo.c0;
import zo.d0;
import zo.e0;
import zo.f0;
import zo.h0;

/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f51423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f51424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f51425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f51426d;

    public static class a implements ds.l {
        @Override // ds.l
        public v a(zn.b bVar) {
            return new c0();
        }
    }

    public static class b implements ds.l {
        @Override // ds.l
        public v a(zn.b bVar) {
            return new d0();
        }
    }

    public static class c implements ds.l {
        @Override // ds.l
        public v a(zn.b bVar) {
            return new e0();
        }
    }

    public static class d implements ds.l {
        @Override // ds.l
        public v a(zn.b bVar) {
            return new f0();
        }
    }

    public static class e implements ds.l {
        @Override // ds.l
        public v a(zn.b bVar) {
            return new h0();
        }
    }

    static {
        HashMap map = new HashMap();
        f51423a = map;
        HashMap map2 = new HashMap();
        f51424b = map2;
        HashSet hashSet = new HashSet();
        f51425c = hashSet;
        f51426d = d();
        y yVar = so.c.f50085b;
        map.put(yVar, "DESEDE");
        y yVar2 = so.c.f50093f;
        map.put(yVar2, m5.b.f40641c);
        y yVar3 = so.c.f50095g;
        map.put(yVar3, m5.b.f40641c);
        y yVar4 = so.c.f50097h;
        map.put(yVar4, m5.b.f40641c);
        map2.put(yVar, "DESEDEMac");
        map2.put(yVar2, "AESMac");
        map2.put(yVar3, "AESMac");
        map2.put(yVar4, "AESMac");
        map2.put(so.c.f50087c, "RC2Mac");
        hashSet.add(kn.d.C);
        hashSet.add(kn.d.K);
        hashSet.add(kn.d.S);
        hashSet.add(kn.d.D);
        hashSet.add(kn.d.L);
        hashSet.add(kn.d.T);
    }

    public static Object a(boolean z10, org.bouncycastle.crypto.k kVar, zn.b bVar) throws CMSException {
        try {
            return org.bouncycastle.crypto.util.c.c(z10, kVar, bVar);
        } catch (IllegalArgumentException e10) {
            throw new CMSException(e10.getMessage(), e10);
        }
    }

    public static l0 c(y yVar) throws CMSException {
        if (kn.d.f37625y.C(yVar) || kn.d.G.C(yVar) || kn.d.O.C(yVar)) {
            return new u0(new cp.a());
        }
        if (s.Z3.C(yVar)) {
            return new u0(new t());
        }
        if (on.b.f44361e.C(yVar)) {
            return new u0(new cp.s());
        }
        if (s.f46788a4.C(yVar)) {
            return new u0(new o0());
        }
        throw new CMSException("cannot recognise wrapper: " + yVar);
    }

    public static Map d() {
        HashMap map = new HashMap();
        map.put(s.f46806g4, new a());
        map.put(s.f46809h4, new b());
        map.put(s.f46812i4, new c());
        map.put(s.f46815j4, new d());
        map.put(s.f46818k4, new e());
        return Collections.unmodifiableMap(map);
    }

    public static v f(zn.b bVar) throws OperatorCreationException {
        return ((ds.l) f51426d.get(bVar.x())).a(null);
    }

    public org.bouncycastle.crypto.j b(y yVar, int i10, SecureRandom secureRandom) throws CMSException {
        try {
            return org.bouncycastle.crypto.util.d.b(yVar, secureRandom);
        } catch (IllegalArgumentException e10) {
            throw new CMSException(e10.getMessage(), e10);
        }
    }

    public zn.b e(y yVar, n1 n1Var, SecureRandom secureRandom) throws CMSException {
        try {
            return org.bouncycastle.crypto.util.a.a(yVar, n1Var.a().length * 8, secureRandom);
        } catch (IllegalArgumentException e10) {
            throw new CMSException(e10.getMessage(), e10);
        }
    }

    public boolean g(y yVar) {
        return f51425c.contains(yVar);
    }
}
