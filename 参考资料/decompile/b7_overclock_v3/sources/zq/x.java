package zq;

/* JADX INFO: loaded from: classes5.dex */
public class x {

    public static class a extends ar.c {
        public a() {
            super("Poly1305", 256, new fp.k0());
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.q());
        }
    }

    public static class c extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59637a = x.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59637a;
            sb2.append(str);
            sb2.append("$Mac");
            aVar.h("Mac.POLY1305", sb2.toString());
            aVar.h("KeyGenerator.POLY1305", str + "$KeyGen");
        }
    }
}
