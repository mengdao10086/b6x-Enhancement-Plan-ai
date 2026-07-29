package vq;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.b(128));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.b((zo.b) this.f53335a);
            return aVar;
        }
    }

    public static class b extends vq.a implements Cloneable {
        public b() {
            super(new zo.b(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            b bVar = (b) super.clone();
            bVar.f53335a = new zo.b((zo.b) this.f53335a);
            return bVar;
        }
    }

    /* JADX INFO: renamed from: vq.c$c, reason: collision with other inner class name */
    public static class C0622c extends vq.a implements Cloneable {
        public C0622c() {
            super(new zo.b(224));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            C0622c c0622c = (C0622c) super.clone();
            c0622c.f53335a = new zo.b((zo.b) this.f53335a);
            return c0622c;
        }
    }

    public static class d extends vq.a implements Cloneable {
        public d() {
            super(new zo.b(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            d dVar = (d) super.clone();
            dVar.f53335a = new zo.b((zo.b) this.f53335a);
            return dVar;
        }
    }

    public static class e extends vq.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53338a = c.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53338a;
            sb2.append(str);
            sb2.append("$Blake2s256");
            aVar.h("MessageDigest.BLAKE2S-256", sb2.toString());
            aVar.h("Alg.Alias.MessageDigest." + in.c.L, "BLAKE2S-256");
            aVar.h("MessageDigest.BLAKE2S-224", str + "$Blake2s224");
            aVar.h("Alg.Alias.MessageDigest." + in.c.K, "BLAKE2S-224");
            aVar.h("MessageDigest.BLAKE2S-160", str + "$Blake2s160");
            aVar.h("Alg.Alias.MessageDigest." + in.c.J, "BLAKE2S-160");
            aVar.h("MessageDigest.BLAKE2S-128", str + "$Blake2s128");
            aVar.h("Alg.Alias.MessageDigest." + in.c.I, "BLAKE2S-128");
        }
    }
}
