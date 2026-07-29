package vq;

import zo.o0;

/* JADX INFO: loaded from: classes7.dex */
public class x {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new o0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new o0((o0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new o0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACTIGER", 192, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53358a = x.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53358a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.TIGER", sb2.toString());
            aVar.h("MessageDigest.Tiger", str + "$Digest");
            b(aVar, "TIGER", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "TIGER", zm.a.f58656p);
            aVar.h("SecretKeyFactory.PBEWITHHMACTIGER", str + "$PBEWithMacKeyFactory");
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.k(new o0()), 2, 3, 192);
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public f() {
            super("PBEwithHmacTiger", null, false, 2, 3, 192, 0);
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.k(new o0()));
        }
    }
}
