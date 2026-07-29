package vq;

/* JADX INFO: loaded from: classes7.dex */
public class k {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.u());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.u((zo.u) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new zo.u()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACMD5", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53345a = k.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53345a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.MD5", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + pn.s.f46803f4, "MD5");
            b(aVar, "MD5", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "MD5", zm.a.f58654n);
        }
    }
}
