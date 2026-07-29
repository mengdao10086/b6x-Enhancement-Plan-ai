package vq;

import zo.e0;

/* JADX INFO: loaded from: classes7.dex */
public class r {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new e0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new e0((e0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new e0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACSHA256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53352a = r.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53352a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.SHA-256", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.SHA256", "SHA-256");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.MessageDigest.");
            gm.y yVar = kn.d.f37592c;
            sb3.append(yVar);
            aVar.h(sb3.toString(), "SHA-256");
            aVar.h("SecretKeyFactory.PBEWITHHMACSHA256", str + "$PBEWithMacKeyFactory");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA-256", "PBEWITHHMACSHA256");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar, "PBEWITHHMACSHA256");
            aVar.h("Mac.PBEWITHHMACSHA256", str + "$HashMac");
            b(aVar, "SHA256", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "SHA256", pn.s.f46812i4);
            c(aVar, "SHA256", yVar);
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public e() {
            super("PBEwithHmacSHA256", null, false, 2, 4, 256, 0);
        }
    }
}
