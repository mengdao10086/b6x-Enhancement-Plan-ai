package vq;

import zo.h0;
import zo.i0;

/* JADX INFO: loaded from: classes7.dex */
public class u {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new h0());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new h0((h0) this.f53335a);
            return aVar;
        }
    }

    public static class b extends d {
        public b() {
            super(224);
        }
    }

    public static class c extends d {
        public c() {
            super(256);
        }
    }

    public static class d extends vq.a implements Cloneable {
        public d(int i10) {
            super(new i0(i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            d dVar = (d) super.clone();
            dVar.f53335a = new i0((i0) this.f53335a);
            return dVar;
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.k(new h0()));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.k(new i0(224)));
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.k(new i0(256)));
        }
    }

    public static class h extends ar.c {
        public h() {
            super("HMACSHA512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class i extends ar.c {
        public i() {
            super("HMACSHA512/224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class j extends ar.c {
        public j() {
            super("HMACSHA512/256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class k extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53355a = u.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53355a;
            sb2.append(str);
            sb2.append("$Digest");
            aVar.h("MessageDigest.SHA-512", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest.SHA512", "SHA-512");
            aVar.h("Alg.Alias.MessageDigest." + kn.d.f37596e, "SHA-512");
            aVar.h("MessageDigest.SHA-512/224", str + "$DigestT224");
            aVar.h("Alg.Alias.MessageDigest.SHA512/224", "SHA-512/224");
            aVar.h("Alg.Alias.MessageDigest.SHA512224", "SHA-512/224");
            aVar.h("Alg.Alias.MessageDigest.SHA-512(224)", "SHA-512/224");
            aVar.h("Alg.Alias.MessageDigest.SHA512(224)", "SHA-512/224");
            aVar.h("Alg.Alias.MessageDigest." + kn.d.f37600g, "SHA-512/224");
            aVar.h("MessageDigest.SHA-512/256", str + "$DigestT256");
            aVar.h("Alg.Alias.MessageDigest.SHA512/256", rs.h.f49168c);
            aVar.h("Alg.Alias.MessageDigest.SHA512256", rs.h.f49168c);
            aVar.h("Alg.Alias.MessageDigest.SHA-512(256)", rs.h.f49168c);
            aVar.h("Alg.Alias.MessageDigest.SHA512(256)", rs.h.f49168c);
            aVar.h("Alg.Alias.MessageDigest." + kn.d.f37602h, rs.h.f49168c);
            aVar.h("Mac.OLDHMACSHA512", str + "$OldSHA512");
            aVar.h("Mac.PBEWITHHMACSHA512", str + "$HashMac");
            b(aVar, "SHA512", str + "$HashMac", str + "$KeyGenerator");
            c(aVar, "SHA512", pn.s.f46818k4);
            b(aVar, "SHA512/224", str + "$HashMacT224", str + "$KeyGeneratorT224");
            b(aVar, "SHA512/256", str + "$HashMacT256", str + "$KeyGeneratorT256");
        }
    }

    public static class l extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public l() {
            super(new ip.p(new h0()));
        }
    }
}
