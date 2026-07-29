package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class q {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "HC256 IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public b() {
            super(new cp.f0(), 32);
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HC256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59618a = q.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59618a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.HC256", sb2.toString());
            aVar.h("KeyGenerator.HC256", str + "$KeyGen");
            aVar.h("AlgorithmParameters.HC256", str + "$AlgParams");
        }
    }
}
