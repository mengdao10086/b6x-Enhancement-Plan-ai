package zq;

import cp.q1;

/* JADX INFO: loaded from: classes5.dex */
public final class s0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "XSalsa20 IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public b() {
            super(new q1(), 24);
        }
    }

    public static class c extends ar.c {
        public c() {
            super("XSalsa20", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59624a = s0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59624a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.XSALSA20", sb2.toString());
            aVar.h("KeyGenerator.XSALSA20", str + "$KeyGen");
            aVar.h("AlgorithmParameters.XSALSA20", str + "$AlgParams");
        }
    }
}
