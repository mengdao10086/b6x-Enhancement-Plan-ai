package vq;

/* JADX INFO: loaded from: classes7.dex */
public class l {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.y());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.y((zo.y) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new zo.y()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACRIPEMD128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53346a = l.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53346a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.RIPEMD128", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + tn.b.f51361c, "RIPEMD128");
            b(aVar, "RIPEMD128", str + "$HashMac", str + "$KeyGenerator");
        }
    }
}
