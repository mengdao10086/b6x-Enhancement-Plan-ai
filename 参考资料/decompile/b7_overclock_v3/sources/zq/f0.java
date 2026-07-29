package zq;

import cp.f1;

/* JADX INFO: loaded from: classes5.dex */
public final class f0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Salsa20 IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public b() {
            super(new f1(), 8);
        }
    }

    public static class c extends ar.c {
        public c() {
            super("Salsa20", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59580a = f0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59580a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.SALSA20", sb2.toString());
            aVar.h("KeyGenerator.SALSA20", str + "$KeyGen");
            aVar.h("AlgorithmParameters.SALSA20", str + "$AlgParams");
        }
    }
}
