package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Blowfish IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b() {
            super(new jp.c(new cp.i()), 64);
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.e(new cp.i()));
        }
    }

    /* JADX INFO: renamed from: zq.d$d, reason: collision with other inner class name */
    public static class C0694d extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public C0694d() {
            super(new cp.i());
        }
    }

    public static class e extends ar.c {
        public e() {
            super("Blowfish", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class f extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59573a = d.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59573a;
            sb2.append(str);
            sb2.append("$CMAC");
            aVar.h("Mac.BLOWFISHCMAC", sb2.toString());
            aVar.h("Cipher.BLOWFISH", str + "$ECB");
            gm.y yVar = in.c.A;
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.h("KeyGenerator.BLOWFISH", str + "$KeyGen");
            aVar.k("Alg.Alias.KeyGenerator", yVar, "BLOWFISH");
            aVar.h("AlgorithmParameters.BLOWFISH", str + "$AlgParams");
            aVar.k("Alg.Alias.AlgorithmParameters", yVar, "BLOWFISH");
        }
    }
}
