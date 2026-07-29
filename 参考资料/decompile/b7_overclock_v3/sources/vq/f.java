package vq;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.j());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.j((zo.j) this.f53335a);
            return aVar;
        }
    }

    public static class b extends vq.a implements Cloneable {
        public b() {
            super(new zo.k());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            b bVar = (b) super.clone();
            bVar.f53335a = new zo.k((zo.k) this.f53335a);
            return bVar;
        }
    }

    public static class c extends vq.a implements Cloneable {
        public c() {
            super(new zo.h());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            c cVar = (c) super.clone();
            cVar.f53335a = new zo.h((zo.h) this.f53335a);
            return cVar;
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.k(new zo.j()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.k(new zo.k()));
        }
    }

    /* JADX INFO: renamed from: vq.f$f, reason: collision with other inner class name */
    public static class C0624f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public C0624f() {
            super(new ip.k(new zo.h()));
        }
    }

    public static class g extends ar.c {
        public g() {
            super("HMACGOST3411", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class h extends ar.c {
        public h() {
            super("HMACGOST3411", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class i extends ar.c {
        public i() {
            super("HMACGOST3411", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class j extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53340a = f.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53340a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.GOST3411", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.GOST", "GOST3411");
            aVar.h("Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.MessageDigest.");
            gm.y yVar = qm.a.f47452b;
            sb3.append(yVar);
            aVar.h(sb3.toString(), "GOST3411");
            b(aVar, "GOST3411", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "GOST3411", yVar);
            aVar.h("MessageDigest.GOST3411-2012-256", str + "$Digest2012_256");
            aVar.h("Alg.Alias.MessageDigest.GOST-2012-256", "GOST3411-2012-256");
            aVar.h("Alg.Alias.MessageDigest.GOST-3411-2012-256", "GOST3411-2012-256");
            aVar.h("Alg.Alias.MessageDigest." + qn.a.f47513c, "GOST3411-2012-256");
            b(aVar, "GOST3411-2012-256", str + "$HashMac2012_256", str + "$KeyGenerator2012_256");
            c(aVar, "GOST3411-2012-256", qn.a.f47515e);
            aVar.h("MessageDigest.GOST3411-2012-512", str + "$Digest2012_512");
            aVar.h("Alg.Alias.MessageDigest.GOST-2012-512", "GOST3411-2012-512");
            aVar.h("Alg.Alias.MessageDigest.GOST-3411-2012-512", "GOST3411-2012-512");
            aVar.h("Alg.Alias.MessageDigest." + qn.a.f47514d, "GOST3411-2012-512");
            b(aVar, "GOST3411-2012-512", str + "$HashMac2012_512", str + "$KeyGenerator2012_512");
            c(aVar, "GOST3411-2012-512", qn.a.f47516f);
            aVar.h("SecretKeyFactory.PBEWITHHMACGOST3411", str + "$PBEWithMacKeyFactory");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar, "PBEWITHHMACGOST3411");
        }
    }

    public static class k extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public k() {
            super("PBEwithHmacGOST3411", null, false, 2, 6, 256, 0);
        }
    }
}
