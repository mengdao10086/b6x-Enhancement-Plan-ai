package vq;

/* JADX INFO: loaded from: classes7.dex */
public class h {

    public static class a extends f {
        public a() {
            super(224);
        }
    }

    public static class b extends f {
        public b() {
            super(256);
        }
    }

    public static class c extends f {
        public c() {
            super(288);
        }
    }

    public static class d extends f {
        public d() {
            super(384);
        }
    }

    public static class e extends f {
        public e() {
            super(512);
        }
    }

    public static class f extends vq.a implements Cloneable {
        public f(int i10) {
            super(new zo.q(i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new zo.q((zo.q) this.f53335a);
            return aVar;
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.k(new zo.q(224)));
        }
    }

    /* JADX INFO: renamed from: vq.h$h, reason: collision with other inner class name */
    public static class C0625h extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public C0625h() {
            super(new ip.k(new zo.q(256)));
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public i() {
            super(new ip.k(new zo.q(288)));
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.k(new zo.q(384)));
        }
    }

    public static class k extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public k() {
            super(new ip.k(new zo.q(512)));
        }
    }

    public static class l extends ar.c {
        public l() {
            super("HMACKECCAK224", 224, new org.bouncycastle.crypto.j());
        }
    }

    public static class m extends ar.c {
        public m() {
            super("HMACKECCAK256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class n extends ar.c {
        public n() {
            super("HMACKECCAK288", 288, new org.bouncycastle.crypto.j());
        }
    }

    public static class o extends ar.c {
        public o() {
            super("HMACKECCAK384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class p extends ar.c {
        public p() {
            super("HMACKECCAK512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class q extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53342a = h.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53342a;
            sb2.append(str);
            sb2.append("$Digest224");
            aVar.h("MessageDigest.KECCAK-224", sb2.toString());
            aVar.h("MessageDigest.KECCAK-288", str + "$Digest288");
            aVar.h("MessageDigest.KECCAK-256", str + "$Digest256");
            aVar.h("MessageDigest.KECCAK-384", str + "$Digest384");
            aVar.h("MessageDigest.KECCAK-512", str + "$Digest512");
            b(aVar, "KECCAK224", str + "$HashMac224", str + "$KeyGenerator224");
            b(aVar, "KECCAK256", str + "$HashMac256", str + "$KeyGenerator256");
            b(aVar, "KECCAK288", str + "$HashMac288", str + "$KeyGenerator288");
            b(aVar, "KECCAK384", str + "$HashMac384", str + "$KeyGenerator384");
            b(aVar, "KECCAK512", str + "$HashMac512", str + "$KeyGenerator512");
        }
    }
}
