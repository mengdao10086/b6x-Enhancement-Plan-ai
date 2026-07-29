package vq;

/* JADX INFO: loaded from: classes7.dex */
public class j {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.t());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.t((zo.t) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new zo.t()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACMD4", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53344a = j.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53344a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.MD4", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + pn.s.f46800e4, "MD4");
            b(aVar, "MD4", str + "$HashMac", str + "$KeyGenerator");
        }
    }
}
