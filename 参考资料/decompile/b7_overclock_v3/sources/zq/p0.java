package zq;

import cp.n1;

/* JADX INFO: loaded from: classes5.dex */
public final class p0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Twofish IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new n1();
            }
        }

        public b() {
            super(new a());
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.i(new jp.n(new n1())));
        }
    }

    public static class d extends ar.c {
        public d() {
            super("Twofish", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class e extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59617a = p0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59617a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.Twofish", sb2.toString());
            aVar.h("KeyGenerator.Twofish", str + "$KeyGen");
            aVar.h("AlgorithmParameters.Twofish", str + "$AlgParams");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH-CBC", "PKCS12PBE");
            aVar.h("Cipher.PBEWITHSHAANDTWOFISH-CBC", str + "$PBEWithSHA");
            aVar.h("SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", str + "$PBEWithSHAKeyFactory");
            c(aVar, "Twofish", str + "$GMAC", str + "$KeyGen");
            d(aVar, "Twofish", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f() {
            super(new jp.c(new n1()), 2, 1, 256, 16);
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public g() {
            super("PBEwithSHAandTwofish-CBC", null, true, 2, 1, 256, 128);
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h() {
            super(new ip.q(new n1()));
        }
    }

    public static class i extends ar.c {
        public i() {
            super("Poly1305-Twofish", 256, new fp.k0());
        }
    }
}
