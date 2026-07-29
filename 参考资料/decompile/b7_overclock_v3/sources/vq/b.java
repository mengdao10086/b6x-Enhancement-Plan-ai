package vq;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.a(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.a((zo.a) this.f53335a);
            return aVar;
        }
    }

    /* JADX INFO: renamed from: vq.b$b, reason: collision with other inner class name */
    public static class C0621b extends vq.a implements Cloneable {
        public C0621b() {
            super(new zo.a(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            C0621b c0621b = (C0621b) super.clone();
            c0621b.f53335a = new zo.a((zo.a) this.f53335a);
            return c0621b;
        }
    }

    public static class c extends vq.a implements Cloneable {
        public c() {
            super(new zo.a(384));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            c cVar = (c) super.clone();
            cVar.f53335a = new zo.a((zo.a) this.f53335a);
            return cVar;
        }
    }

    public static class d extends vq.a implements Cloneable {
        public d() {
            super(new zo.a(512));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            d dVar = (d) super.clone();
            dVar.f53335a = new zo.a((zo.a) this.f53335a);
            return dVar;
        }
    }

    public static class e extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53337a = b.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53337a;
            sb2.append(str);
            sb2.append("$Blake2b512");
            aVar.h("MessageDigest.BLAKE2B-512", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + in.c.H, "BLAKE2B-512");
            aVar.h("MessageDigest.BLAKE2B-384", str + "$Blake2b384");
            aVar.h("Alg.Alias.MessageDigest." + in.c.G, "BLAKE2B-384");
            aVar.h("MessageDigest.BLAKE2B-256", str + "$Blake2b256");
            aVar.h("Alg.Alias.MessageDigest." + in.c.F, "BLAKE2B-256");
            aVar.h("MessageDigest.BLAKE2B-160", str + "$Blake2b160");
            aVar.h("Alg.Alias.MessageDigest." + in.c.E, "BLAKE2B-160");
        }
    }
}
