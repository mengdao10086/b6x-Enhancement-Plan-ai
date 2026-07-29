package vq;

import zo.z;

/* JADX INFO: loaded from: classes7.dex */
public class m {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new z());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new z((z) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new z()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACRIPEMD160", 160, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53347a = m.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53347a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.RIPEMD160", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + tn.b.f51360b, "RIPEMD160");
            b(aVar, "RIPEMD160", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "RIPEMD160", zm.a.f58657q);
            aVar.h("SecretKeyFactory.PBEWITHHMACRIPEMD160", str + "$PBEWithHmacKeyFactory");
            aVar.h("Mac.PBEWITHHMACRIPEMD160", str + "$PBEWithHmac");
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.k(new z()), 2, 2, 160);
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public f() {
            super("PBEwithHmacRIPEMD160", null, false, 2, 2, 160, 0);
        }
    }
}
