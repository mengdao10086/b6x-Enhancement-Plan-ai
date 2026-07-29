package vq;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    public static class a extends C0623d {
        public a() {
            super(256);
        }
    }

    public static class b extends C0623d {
        public b() {
            super(384);
        }
    }

    public static class c extends C0623d {
        public c() {
            super(512);
        }
    }

    /* JADX INFO: renamed from: vq.d$d, reason: collision with other inner class name */
    public static class C0623d extends vq.a implements Cloneable {
        public C0623d(int i10) {
            super(new zo.f(i10));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            vq.a aVar = (vq.a) super.clone();
            aVar.f53335a = new zo.f((zo.f) this.f53335a);
            return aVar;
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.g(256));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.g(384));
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.g(512));
        }
    }

    public static class h extends ar.c {
        public h() {
            super("HMACDSTU7564-256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class i extends ar.c {
        public i() {
            super("HMACDSTU7564-384", 384, new org.bouncycastle.crypto.j());
        }
    }

    public static class j extends ar.c {
        public j() {
            super("HMACDSTU7564-512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class k extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53339a = d.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53339a;
            sb2.append(str);
            sb2.append("$Digest256");
            aVar.h("MessageDigest.DSTU7564-256", sb2.toString());
            aVar.h("MessageDigest.DSTU7564-384", str + "$Digest384");
            aVar.h("MessageDigest.DSTU7564-512", str + "$Digest512");
            aVar.k("MessageDigest", vn.g.f53270d, str + "$Digest256");
            aVar.k("MessageDigest", vn.g.f53271e, str + "$Digest384");
            aVar.k("MessageDigest", vn.g.f53272f, str + "$Digest512");
            b(aVar, "DSTU7564-256", str + "$HashMac256", str + "$KeyGenerator256");
            b(aVar, "DSTU7564-384", str + "$HashMac384", str + "$KeyGenerator384");
            b(aVar, "DSTU7564-512", str + "$HashMac512", str + "$KeyGenerator512");
            c(aVar, "DSTU7564-256", vn.g.f53273g);
            c(aVar, "DSTU7564-384", vn.g.f53274h);
            c(aVar, "DSTU7564-512", vn.g.f53275i);
        }
    }
}
