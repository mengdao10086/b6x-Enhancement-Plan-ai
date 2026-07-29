package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "CAST6 IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.k();
            }
        }

        public b() {
            super(new a());
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.i(new jp.n(new cp.k())));
        }
    }

    public static class d extends ar.c {
        public d() {
            super("CAST6", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class e extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59579a = f.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59579a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.CAST6", sb2.toString());
            aVar.h("KeyGenerator.CAST6", str + "$KeyGen");
            aVar.h("AlgorithmParameters.CAST6", str + "$AlgParams");
            c(aVar, "CAST6", str + "$GMAC", str + "$KeyGen");
            d(aVar, "CAST6", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    /* JADX INFO: renamed from: zq.f$f, reason: collision with other inner class name */
    public static class C0696f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public C0696f() {
            super(new ip.q(new cp.k()));
        }
    }

    public static class g extends ar.c {
        public g() {
            super("Poly1305-CAST6", 256, new fp.k0());
        }
    }
}
