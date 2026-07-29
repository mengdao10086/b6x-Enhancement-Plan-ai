package zq;

import cp.j1;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Skipjack IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b() {
            super(new j1());
        }
    }

    public static class c extends ar.c {
        public c() {
            super("Skipjack", 80, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.c(new j1()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.d(new j1()));
        }
    }

    public static class f extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59599a = k0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59599a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.SKIPJACK", sb2.toString());
            aVar.h("KeyGenerator.SKIPJACK", str + "$KeyGen");
            aVar.h("AlgorithmParameters.SKIPJACK", str + "$AlgParams");
            aVar.h("Mac.SKIPJACKMAC", str + "$Mac");
            aVar.h("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
            aVar.h("Mac.SKIPJACKMAC/CFB8", str + "$MacCFB8");
            aVar.h("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        }
    }
}
