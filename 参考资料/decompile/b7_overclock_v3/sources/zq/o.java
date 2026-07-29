package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class o {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Grainv1 IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public b() {
            super(new cp.d0(), 8);
        }
    }

    public static class c extends ar.c {
        public c() {
            super("Grainv1", 80, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59614a = o.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59614a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.Grainv1", sb2.toString());
            aVar.h("KeyGenerator.Grainv1", str + "$KeyGen");
            aVar.h("AlgorithmParameters.Grainv1", str + "$AlgParams");
        }
    }
}
