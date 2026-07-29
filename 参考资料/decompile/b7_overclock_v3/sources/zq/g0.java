package zq;

import cp.g1;
import cp.m1;

/* JADX INFO: loaded from: classes5.dex */
public final class g0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Serpent IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b() {
            super(new jp.c(new g1()), 128);
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new org.bouncycastle.crypto.h(new jp.e(new g1(), 128)), 128);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new g1();
            }
        }

        public d() {
            super(new a());
        }
    }

    public static class e extends ar.c {
        public e() {
            super("Serpent", 192, new org.bouncycastle.crypto.j());
        }
    }

    public static class f extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59582a = g0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59582a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.Serpent", sb2.toString());
            aVar.h("KeyGenerator.Serpent", str + "$KeyGen");
            aVar.h("AlgorithmParameters.Serpent", str + "$AlgParams");
            aVar.h("Cipher.Tnepres", str + "$TECB");
            aVar.h("KeyGenerator.Tnepres", str + "$TKeyGen");
            aVar.h("AlgorithmParameters.Tnepres", str + "$TAlgParams");
            aVar.k("Cipher", ym.a.f57374j, str + "$ECB");
            aVar.k("Cipher", ym.a.f57378n, str + "$ECB");
            aVar.k("Cipher", ym.a.f57382r, str + "$ECB");
            aVar.k("Cipher", ym.a.f57375k, str + "$CBC");
            aVar.k("Cipher", ym.a.f57379o, str + "$CBC");
            aVar.k("Cipher", ym.a.f57383s, str + "$CBC");
            aVar.k("Cipher", ym.a.f57377m, str + "$CFB");
            aVar.k("Cipher", ym.a.f57381q, str + "$CFB");
            aVar.k("Cipher", ym.a.f57385u, str + "$CFB");
            aVar.k("Cipher", ym.a.f57376l, str + "$OFB");
            aVar.k("Cipher", ym.a.f57380p, str + "$OFB");
            aVar.k("Cipher", ym.a.f57384t, str + "$OFB");
            c(aVar, "SERPENT", str + "$SerpentGMAC", str + "$KeyGen");
            c(aVar, "TNEPRES", str + "$TSerpentGMAC", str + "$TKeyGen");
            d(aVar, "SERPENT", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public g() {
            super(new org.bouncycastle.crypto.h(new jp.x(new g1(), 128)), 128);
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h() {
            super(new ip.q(new g1()));
        }
    }

    public static class i extends ar.c {
        public i() {
            super("Poly1305-Serpent", 256, new fp.k0());
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.i(new jp.n(new g1())));
        }
    }

    public static class k extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Tnepres IV";
        }
    }

    public static class l extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new m1();
            }
        }

        public l() {
            super(new a());
        }
    }

    public static class m extends ar.c {
        public m() {
            super("Tnepres", 192, new org.bouncycastle.crypto.j());
        }
    }

    public static class n extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public n() {
            super(new ip.i(new jp.n(new m1())));
        }
    }
}
