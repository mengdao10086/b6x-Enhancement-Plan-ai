package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class p {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "HC128 IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public b() {
            super(new cp.e0(), 16);
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HC128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59616a = p.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59616a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.HC128", sb2.toString());
            aVar.h("KeyGenerator.HC128", str + "$KeyGen");
            aVar.h("AlgorithmParameters.HC128", str + "$AlgParams");
        }
    }
}
