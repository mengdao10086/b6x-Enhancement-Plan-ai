package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class i0 {

    public static class a extends ar.c {
        public a() {
            super("SipHash", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.s());
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.s(4, 8));
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59592a = i0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59592a;
            sb2.append(str);
            sb2.append("$Mac24");
            aVar.h("Mac.SIPHASH-2-4", sb2.toString());
            aVar.h("Alg.Alias.Mac.SIPHASH", "SIPHASH-2-4");
            aVar.h("Mac.SIPHASH-4-8", str + "$Mac48");
            aVar.h("KeyGenerator.SIPHASH", str + "$KeyGen");
            aVar.h("Alg.Alias.KeyGenerator.SIPHASH-2-4", "SIPHASH");
            aVar.h("Alg.Alias.KeyGenerator.SIPHASH-4-8", "SIPHASH");
        }
    }
}
