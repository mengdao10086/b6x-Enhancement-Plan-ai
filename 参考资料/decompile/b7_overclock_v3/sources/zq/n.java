package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class n {

    public static class a extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public a() {
            super(new cp.c0(), 12);
        }
    }

    public static class b extends ar.c {
        public b() {
            super("Grain128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class c extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59611a = n.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59611a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.Grain128", sb2.toString());
            aVar.h("KeyGenerator.Grain128", str + "$KeyGen");
        }
    }
}
