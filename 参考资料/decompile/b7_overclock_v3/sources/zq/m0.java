package zq;

import cp.k1;

/* JADX INFO: loaded from: classes5.dex */
public final class m0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "TEA IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b() {
            super(new k1());
        }
    }

    public static class c extends ar.c {
        public c() {
            super("TEA", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59610a = m0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59610a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.TEA", sb2.toString());
            aVar.h("KeyGenerator.TEA", str + "$KeyGen");
            aVar.h("AlgorithmParameters.TEA", str + "$AlgParams");
        }
    }
}
