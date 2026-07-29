package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "ChaCha7539 IV";
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "ChaCha20-Poly1305 IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public c() {
            super(new cp.o(), 12);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public d() {
            super(new cp.p(), 8);
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public e() {
            super((jp.b) new jp.g(), true, 12);
        }
    }

    public static class f extends ar.c {
        public f() {
            super("ChaCha7539", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class g extends ar.c {
        public g() {
            super("ChaCha", 128, new org.bouncycastle.crypto.j());
        }
    }

    /* JADX INFO: renamed from: zq.h$h, reason: collision with other inner class name */
    public static class C0698h extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59583a = h.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59583a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.CHACHA", sb2.toString());
            aVar.h("KeyGenerator.CHACHA", str + "$KeyGen");
            aVar.h("Cipher.CHACHA7539", str + "$Base7539");
            aVar.h("KeyGenerator.CHACHA7539", str + "$KeyGen7539");
            aVar.h("AlgorithmParameters.CHACHA7539", str + "$AlgParams");
            aVar.h("Alg.Alias.Cipher.CHACHA20", "CHACHA7539");
            aVar.h("Alg.Alias.KeyGenerator.CHACHA20", "CHACHA7539");
            aVar.h("Alg.Alias.AlgorithmParameters.CHACHA20", "CHACHA7539");
            aVar.h("Alg.Alias.KeyGenerator.CHACHA20-POLY1305", "CHACHA7539");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.KeyGenerator.");
            gm.y yVar = pn.s.f46804f5;
            sb3.append(yVar);
            aVar.h(sb3.toString(), "CHACHA7539");
            aVar.h("Cipher.CHACHA20-POLY1305", str + "$BaseCC20P1305");
            aVar.h("AlgorithmParameters.CHACHA20-POLY1305", str + "$AlgParamsCC1305");
            aVar.h("Alg.Alias.Cipher." + yVar, "CHACHA20-POLY1305");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar, "CHACHA20-POLY1305");
            aVar.h("Alg.Alias.Cipher.OID." + yVar, "CHACHA20-POLY1305");
            aVar.h("Alg.Alias.AlgorithmParameters.OID." + yVar, "CHACHA20-POLY1305");
        }
    }
}
