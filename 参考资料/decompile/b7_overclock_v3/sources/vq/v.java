package vq;

import zo.k0;

/* JADX INFO: loaded from: classes7.dex */
public class v {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new k0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new k0((k0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new k0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACSM3", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53356a = v.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53356a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.SM3", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.SM3", "SM3");
            aVar.h("Alg.Alias.MessageDigest.1.2.156.197.1.401", "SM3");
            aVar.h("Alg.Alias.MessageDigest." + xm.b.f55616b0, "SM3");
            b(aVar, "SM3", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "SM3", xm.b.f55618c0);
        }
    }
}
