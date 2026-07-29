package vq;

/* JADX INFO: loaded from: classes7.dex */
public class w {

    public static class a extends vq.a implements Cloneable {
        public a(int i10) {
            super(new zo.m0(1024, i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new zo.m0((zo.m0) this.f53335a);
            return aVar;
        }
    }

    public static class a0 extends ar.c {
        public a0() {
            super("HMACSkein-512-256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class a1 extends ar.c {
        public a1() {
            super("Skein-MAC-512-224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class b extends vq.a implements Cloneable {
        public b(int i10) {
            super(new zo.m0(256, i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new zo.m0((zo.m0) this.f53335a);
            return aVar;
        }
    }

    public static class b0 extends ar.c {
        public b0() {
            super("HMACSkein-512-384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class b1 extends ar.c {
        public b1() {
            super("Skein-MAC-512-256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class c extends vq.a implements Cloneable {
        public c(int i10) {
            super(new zo.m0(512, i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new zo.m0((zo.m0) this.f53335a);
            return aVar;
        }
    }

    public static class c0 extends ar.c {
        public c0() {
            super("HMACSkein-512-512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class c1 extends ar.c {
        public c1() {
            super("Skein-MAC-512-384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends a {
        public d() {
            super(1024);
        }
    }

    public static class d0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d0() {
            super(new ip.k(new zo.m0(1024, 1024)));
        }
    }

    public static class d1 extends ar.c {
        public d1() {
            super("Skein-MAC-512-512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class e extends a {
        public e() {
            super(384);
        }
    }

    public static class e0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e0() {
            super(new ip.k(new zo.m0(1024, 384)));
        }
    }

    public static class e1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e1() {
            super(new ip.t(1024, 1024));
        }
    }

    public static class f extends a {
        public f() {
            super(512);
        }
    }

    public static class f0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f0() {
            super(new ip.k(new zo.m0(1024, 512)));
        }
    }

    public static class f1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f1() {
            super(new ip.t(1024, 384));
        }
    }

    public static class g extends b {
        public g() {
            super(128);
        }
    }

    public static class g0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g0() {
            super(new ip.k(new zo.m0(256, 128)));
        }
    }

    public static class g1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g1() {
            super(new ip.t(1024, 512));
        }
    }

    public static class h extends b {
        public h() {
            super(160);
        }
    }

    public static class h0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h0() {
            super(new ip.k(new zo.m0(256, 160)));
        }
    }

    public static class h1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h1() {
            super(new ip.t(256, 128));
        }
    }

    public static class i extends b {
        public i() {
            super(224);
        }
    }

    public static class i0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public i0() {
            super(new ip.k(new zo.m0(256, 224)));
        }
    }

    public static class i1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public i1() {
            super(new ip.t(256, 160));
        }
    }

    public static class j extends b {
        public j() {
            super(256);
        }
    }

    public static class j0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j0() {
            super(new ip.k(new zo.m0(256, 256)));
        }
    }

    public static class j1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j1() {
            super(new ip.t(256, 224));
        }
    }

    public static class k extends c {
        public k() {
            super(128);
        }
    }

    public static class k0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public k0() {
            super(new ip.k(new zo.m0(512, 128)));
        }
    }

    public static class k1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public k1() {
            super(new ip.t(256, 256));
        }
    }

    public static class l extends c {
        public l() {
            super(160);
        }
    }

    public static class l0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public l0() {
            super(new ip.k(new zo.m0(512, 160)));
        }
    }

    public static class l1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public l1() {
            super(new ip.t(512, 128));
        }
    }

    public static class m extends c {
        public m() {
            super(224);
        }
    }

    public static class m0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public m0() {
            super(new ip.k(new zo.m0(512, 224)));
        }
    }

    public static class m1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public m1() {
            super(new ip.t(512, 160));
        }
    }

    public static class n extends c {
        public n() {
            super(256);
        }
    }

    public static class n0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public n0() {
            super(new ip.k(new zo.m0(512, 256)));
        }
    }

    public static class n1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public n1() {
            super(new ip.t(512, 224));
        }
    }

    public static class o extends c {
        public o() {
            super(384);
        }
    }

    public static class o0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public o0() {
            super(new ip.k(new zo.m0(512, 384)));
        }
    }

    public static class o1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public o1() {
            super(new ip.t(512, 256));
        }
    }

    public static class p extends c {
        public p() {
            super(512);
        }
    }

    public static class p0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public p0() {
            super(new ip.k(new zo.m0(512, 512)));
        }
    }

    public static class p1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public p1() {
            super(new ip.t(512, 384));
        }
    }

    public static class q extends ar.c {
        public q() {
            super("HMACSkein-1024-1024", 1024, new org.bouncycastle.crypto.j());
        }
    }

    public static class q0 extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53357a = w.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53357a;
            sb2.append(str);
            sb2.append("$Digest_256_128");
            aVar.h("MessageDigest.Skein-256-128", sb2.toString());
            aVar.h("MessageDigest.Skein-256-160", str + "$Digest_256_160");
            aVar.h("MessageDigest.Skein-256-224", str + "$Digest_256_224");
            aVar.h("MessageDigest.Skein-256-256", str + "$Digest_256_256");
            aVar.h("MessageDigest.Skein-512-128", str + "$Digest_512_128");
            aVar.h("MessageDigest.Skein-512-160", str + "$Digest_512_160");
            aVar.h("MessageDigest.Skein-512-224", str + "$Digest_512_224");
            aVar.h("MessageDigest.Skein-512-256", str + "$Digest_512_256");
            aVar.h("MessageDigest.Skein-512-384", str + "$Digest_512_384");
            aVar.h("MessageDigest.Skein-512-512", str + "$Digest_512_512");
            aVar.h("MessageDigest.Skein-1024-384", str + "$Digest_1024_384");
            aVar.h("MessageDigest.Skein-1024-512", str + "$Digest_1024_512");
            aVar.h("MessageDigest.Skein-1024-1024", str + "$Digest_1024_1024");
            b(aVar, "Skein-256-128", str + "$HashMac_256_128", str + "$HMacKeyGenerator_256_128");
            b(aVar, "Skein-256-160", str + "$HashMac_256_160", str + "$HMacKeyGenerator_256_160");
            b(aVar, "Skein-256-224", str + "$HashMac_256_224", str + "$HMacKeyGenerator_256_224");
            b(aVar, "Skein-256-256", str + "$HashMac_256_256", str + "$HMacKeyGenerator_256_256");
            b(aVar, "Skein-512-128", str + "$HashMac_512_128", str + "$HMacKeyGenerator_512_128");
            b(aVar, "Skein-512-160", str + "$HashMac_512_160", str + "$HMacKeyGenerator_512_160");
            b(aVar, "Skein-512-224", str + "$HashMac_512_224", str + "$HMacKeyGenerator_512_224");
            b(aVar, "Skein-512-256", str + "$HashMac_512_256", str + "$HMacKeyGenerator_512_256");
            b(aVar, "Skein-512-384", str + "$HashMac_512_384", str + "$HMacKeyGenerator_512_384");
            b(aVar, "Skein-512-512", str + "$HashMac_512_512", str + "$HMacKeyGenerator_512_512");
            b(aVar, "Skein-1024-384", str + "$HashMac_1024_384", str + "$HMacKeyGenerator_1024_384");
            b(aVar, "Skein-1024-512", str + "$HashMac_1024_512", str + "$HMacKeyGenerator_1024_512");
            b(aVar, "Skein-1024-1024", str + "$HashMac_1024_1024", str + "$HMacKeyGenerator_1024_1024");
            d(aVar, 256, 128);
            d(aVar, 256, 160);
            d(aVar, 256, 224);
            d(aVar, 256, 256);
            d(aVar, 512, 128);
            d(aVar, 512, 160);
            d(aVar, 512, 224);
            d(aVar, 512, 256);
            d(aVar, 512, 384);
            d(aVar, 512, 512);
            d(aVar, 1024, 384);
            d(aVar, 1024, 512);
            d(aVar, 1024, 1024);
        }

        public final void d(uq.a aVar, int i10, int i11) {
            String str = "Skein-MAC-" + i10 + "-" + i11;
            StringBuilder sb2 = new StringBuilder();
            String str2 = f53357a;
            sb2.append(str2);
            sb2.append("$SkeinMac_");
            sb2.append(i10);
            sb2.append("_");
            sb2.append(i11);
            aVar.h("Mac." + str, sb2.toString());
            aVar.h("Alg.Alias.Mac.Skein-MAC" + i10 + fh.a.f28350w + i11, str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("KeyGenerator.");
            sb3.append(str);
            aVar.h(sb3.toString(), str2 + "$SkeinMacKeyGenerator_" + i10 + "_" + i11);
            aVar.h("Alg.Alias.KeyGenerator.Skein-MAC" + i10 + fh.a.f28350w + i11, str);
        }
    }

    public static class q1 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public q1() {
            super(new ip.t(512, 512));
        }
    }

    public static class r extends ar.c {
        public r() {
            super("HMACSkein-1024-384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class r0 extends ar.c {
        public r0() {
            super("Skein-MAC-1024-1024", 1024, new org.bouncycastle.crypto.j());
        }
    }

    public static class s extends ar.c {
        public s() {
            super("HMACSkein-1024-512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class s0 extends ar.c {
        public s0() {
            super("Skein-MAC-1024-384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class t extends ar.c {
        public t() {
            super("HMACSkein-256-128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class t0 extends ar.c {
        public t0() {
            super("Skein-MAC-1024-512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class u extends ar.c {
        public u() {
            super("HMACSkein-256-160", 160, new org.bouncycastle.crypto.j());
        }
    }

    public static class u0 extends ar.c {
        public u0() {
            super("Skein-MAC-256-128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class v extends ar.c {
        public v() {
            super("HMACSkein-256-224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class v0 extends ar.c {
        public v0() {
            super("Skein-MAC-256-160", 160, new org.bouncycastle.crypto.j());
        }
    }

    /* JADX INFO: renamed from: vq.w$w, reason: collision with other inner class name */
    public static class C0627w extends ar.c {
        public C0627w() {
            super("HMACSkein-256-256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class w0 extends ar.c {
        public w0() {
            super("Skein-MAC-256-224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class x extends ar.c {
        public x() {
            super("HMACSkein-512-128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class x0 extends ar.c {
        public x0() {
            super("Skein-MAC-256-256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class y extends ar.c {
        public y() {
            super("HMACSkein-512-160", 160, new org.bouncycastle.crypto.j());
        }
    }

    public static class y0 extends ar.c {
        public y0() {
            super("Skein-MAC-512-128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class z extends ar.c {
        public z() {
            super("HMACSkein-512-224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class z0 extends ar.c {
        public z0() {
            super("Skein-MAC-512-160", 160, new org.bouncycastle.crypto.j());
        }
    }
}
