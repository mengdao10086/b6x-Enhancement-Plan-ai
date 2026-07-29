package vq;

/* JADX INFO: loaded from: classes7.dex */
public class i {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.s());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.s((zo.s) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new zo.s()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACMD2", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53343a = i.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53343a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.MD2", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + pn.s.f46797d4, "MD2");
            b(aVar, "MD2", str + "$HashMac", str + "$KeyGenerator");
        }
    }
}
