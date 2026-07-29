package vq;

/* JADX INFO: loaded from: classes7.dex */
public class g {

    public static class a extends vq.a implements Cloneable {
        public a() {
            super(new zo.m());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            a aVar = (a) super.clone();
            aVar.f53335a = new zo.m((zo.m) this.f53335a);
            return aVar;
        }
    }

    public static class b extends vq.a implements Cloneable {
        public b() {
            super(new zo.n());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            b bVar = (b) super.clone();
            bVar.f53335a = new zo.n((zo.n) this.f53335a);
            return bVar;
        }
    }

    public static class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f53341a = g.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f53341a;
            sb2.append(str);
            sb2.append("$Digest256");
            aVar.h("MessageDigest.HARAKA-256", sb2.toString());
            aVar.h("MessageDigest.HARAKA-512", str + "$Digest512");
        }
    }
}
