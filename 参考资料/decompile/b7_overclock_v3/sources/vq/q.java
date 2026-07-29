package vq;

import zo.d0;

/* JADX INFO: loaded from: classes7.dex */
public class q {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new d0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new d0((d0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new d0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACSHA224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53351a = q.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53351a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.SHA-224", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.SHA224", et.e.f27138g);
            aVar.h("Alg.Alias.MessageDigest." + kn.d.f37598f, et.e.f27138g);
            aVar.h("Mac.PBEWITHHMACSHA224", str + "$HashMac");
            b(aVar, "SHA224", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "SHA224", pn.s.f46809h4);
        }
    }
}
