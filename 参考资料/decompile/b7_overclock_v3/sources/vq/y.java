package vq;

import zo.q0;

/* JADX INFO: loaded from: classes7.dex */
public class y {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new q0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new q0((q0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new q0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACWHIRLPOOL", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53359a = y.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53359a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.WHIRLPOOL", sb2.toString());
            aVar.k("MessageDigest", fn.a.f28525e, str + "$Digest");
            b(aVar, "WHIRLPOOL", str + "$HashMac", str + "$KeyGenerator");
        }
    }
}
