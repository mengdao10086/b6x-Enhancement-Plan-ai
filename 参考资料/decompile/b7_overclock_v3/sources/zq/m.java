package zq;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    public static class a extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public a() {
            super((org.bouncycastle.crypto.f) new jp.i(new cp.b0()), false, 128);
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b() {
            super(new org.bouncycastle.crypto.h(new jp.k(new cp.b0())), true, 64);
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new cp.b0());
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public d() {
            super(new org.bouncycastle.crypto.h(new jp.j(new cp.b0(), 8)), false, 128);
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public e() {
            super(new org.bouncycastle.crypto.h(new jp.j(new cp.b0())), false, 128);
        }
    }

    public static class f extends ar.c {
        public f() {
            this(256);
        }

        public f(int i10) {
            super("GOST3412-2015", i10, new org.bouncycastle.crypto.j());
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.e(new cp.b0()));
        }
    }

    public static class h extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59609a = m.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59609a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.GOST3412-2015", sb2.toString());
            aVar.h("Cipher.GOST3412-2015/CFB", str + "$GCFB");
            aVar.h("Cipher.GOST3412-2015/CFB8", str + "$GCFB8");
            aVar.h("Cipher.GOST3412-2015/OFB", str + "$OFB");
            aVar.h("Cipher.GOST3412-2015/CBC", str + "$CBC");
            aVar.h("Cipher.GOST3412-2015/CTR", str + "$CTR");
            aVar.h("KeyGenerator.GOST3412-2015", str + "$KeyGen");
            aVar.h("Mac.GOST3412MAC", str + "$Mac");
            aVar.h("Alg.Alias.Mac.GOST3412-2015", "GOST3412MAC");
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public i() {
            super(new org.bouncycastle.crypto.h(new jp.l(new cp.b0())), false, 128);
        }
    }
}
