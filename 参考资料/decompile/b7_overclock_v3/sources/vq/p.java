package vq;

import zo.c0;

/* JADX INFO: loaded from: classes7.dex */
public class p {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new c0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new c0((c0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new c0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACSHA1", 160, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53350a = p.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53350a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.SHA-1", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.SHA1", et.e.f27137f);
            aVar.h("Alg.Alias.MessageDigest.SHA", et.e.f27137f);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.MessageDigest.");
            gm.y yVar = on.b.f44365i;
            sb3.append(yVar);
            aVar.h(sb3.toString(), et.e.f27137f);
            b(aVar, "SHA1", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "SHA1", pn.s.f46806g4);
            c(aVar, "SHA1", zm.a.f58655o);
            aVar.h("Mac.PBEWITHHMACSHA", str + "$SHA1Mac");
            aVar.h("Mac.PBEWITHHMACSHA1", str + "$SHA1Mac");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar, "PBEWITHHMACSHA1");
            aVar.h("Alg.Alias.Mac." + yVar, "PBEWITHHMACSHA");
            aVar.h("SecretKeyFactory.PBEWITHHMACSHA1", str + "$PBEWithMacKeyFactory");
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public e() {
            super("PBEwithHmacSHA", null, false, 2, 1, 160, 0);
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.k(new c0()));
        }
    }
}
