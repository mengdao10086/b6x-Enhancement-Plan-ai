package vq;

import zo.a0;

/* JADX INFO: loaded from: classes7.dex */
public class n {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new a0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new a0((a0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b() {
            super(new ip.k(new a0()));
        }
    }

    public static class c extends ar.c {
        public c() {
            super("HMACRIPEMD256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53348a = n.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53348a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.RIPEMD256", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + tn.b.f51362d, "RIPEMD256");
            b(aVar, "RIPEMD256", str + "$HashMac", str + "$KeyGenerator");
        }
    }
}
