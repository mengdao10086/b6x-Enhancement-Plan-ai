package vq;

import zo.g0;
import zo.j0;

/* JADX INFO: loaded from: classes7.dex */
public class s {

    public static class a extends e {
        public a() {
            super(224);
        }
    }

    public static class b extends e {
        public b() {
            super(256);
        }
    }

    public static class c extends e {
        public c() {
            super(384);
        }
    }

    public static class d extends e {
        public d() {
            super(512);
        }
    }

    public static class e extends vq.a implements Cloneable {
        public e(int i10) {
            super(new g0(i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new g0((g0) this.f53335a);
            return aVar;
        }
    }

    public static class f extends vq.a implements Cloneable {
        public f(int i10, int i11) {
            super(new j0(i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new j0((j0) this.f53335a);
            return aVar;
        }
    }

    public static class g extends f {
        public g() {
            super(128, 256);
        }
    }

    public static class h extends f {
        public h() {
            super(256, 512);
        }
    }

    public static class i extends m {
        public i() {
            super(224);
        }
    }

    public static class j extends m {
        public j() {
            super(256);
        }
    }

    public static class k extends m {
        public k() {
            super(384);
        }
    }

    public static class l extends m {
        public l() {
            super(512);
        }
    }

    public static class m extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public m(int i10) {
            super(new ip.k(new g0(i10)));
        }
    }

    public static class n extends r {
        public n() {
            super(224);
        }
    }

    public static class o extends r {
        public o() {
            super(256);
        }
    }

    public static class p extends r {
        public p() {
            super(384);
        }
    }

    public static class q extends r {
        public q() {
            super(512);
        }
    }

    public static class r extends ar.c {
        public r(int i10) {
            super("HMACSHA3-" + i10, i10, new org.bouncycastle.crypto.j());
        }
    }

    /* JADX INFO: renamed from: vq.s$s, reason: collision with other inner class name */
    public static class C0626s extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53353a = s.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53353a;
            sb2.append(str);
            sb2.append("$Digest224");
            aVar.h("MessageDigest.SHA3-224", sb2.toString());
            aVar.h("MessageDigest.SHA3-256", str + "$Digest256");
            aVar.h("MessageDigest.SHA3-384", str + "$Digest384");
            aVar.h("MessageDigest.SHA3-512", str + "$Digest512");
            aVar.k("MessageDigest", kn.d.f37604i, str + "$Digest224");
            aVar.k("MessageDigest", kn.d.f37606j, str + "$Digest256");
            aVar.k("MessageDigest", kn.d.f37608k, str + "$Digest384");
            aVar.k("MessageDigest", kn.d.f37610l, str + "$Digest512");
            aVar.h("MessageDigest.SHAKE256-512", str + "$DigestShake256_512");
            aVar.h("MessageDigest.SHAKE128-256", str + "$DigestShake128_256");
            aVar.k("MessageDigest", kn.d.f37614n, str + "$DigestShake256_512");
            aVar.k("MessageDigest", kn.d.f37612m, str + "$DigestShake128_256");
            aVar.h("Alg.Alias.MessageDigest.SHAKE256", "SHAKE256-512");
            aVar.h("Alg.Alias.MessageDigest.SHAKE128", "SHAKE128-256");
            b(aVar, "SHA3-224", str + "$HashMac224", str + "$KeyGenerator224");
            c(aVar, "SHA3-224", kn.d.f37615o);
            b(aVar, "SHA3-256", str + "$HashMac256", str + "$KeyGenerator256");
            c(aVar, "SHA3-256", kn.d.f37616p);
            b(aVar, "SHA3-384", str + "$HashMac384", str + "$KeyGenerator384");
            c(aVar, "SHA3-384", kn.d.f37617q);
            b(aVar, "SHA3-512", str + "$HashMac512", str + "$KeyGenerator512");
            c(aVar, "SHA3-512", kn.d.f37618r);
        }
    }
}
