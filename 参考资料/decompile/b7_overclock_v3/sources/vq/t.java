package vq;

import zo.f0;

/* JADX INFO: loaded from: classes7.dex */
public class t {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new f0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new f0((f0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new f0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACSHA384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53354a = t.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53354a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.SHA-384", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.SHA384", et.e.f27140i);
            aVar.h("Alg.Alias.MessageDigest." + kn.d.f37594d, et.e.f27140i);
            aVar.h("Mac.OLDHMACSHA384", str + "$OldSHA384");
            aVar.h("Mac.PBEWITHHMACSHA384", str + "$HashMac");
            b(aVar, "SHA384", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "SHA384", pn.s.f46815j4);
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.p(new f0()));
        }
    }
}
