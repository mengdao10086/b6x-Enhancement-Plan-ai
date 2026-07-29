package zq;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    public static class a extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public a() {
            super(new cp.q0(), 0);
        }
    }

    /* JADX INFO: renamed from: zq.b$b, reason: collision with other inner class name */
    public static class C0692b extends ar.c {
        public C0692b() {
            super("RC4", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class c extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59566a = b.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59566a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.ARC4", sb2.toString());
            aVar.k("Alg.Alias.Cipher", pn.s.f46791b4, "ARC4");
            aVar.h("Alg.Alias.Cipher.ARCFOUR", "ARC4");
            aVar.h("Alg.Alias.Cipher.RC4", "ARC4");
            aVar.h("KeyGenerator.ARC4", str + "$KeyGen");
            aVar.h("Alg.Alias.KeyGenerator.RC4", "ARC4");
            aVar.h("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND128BITRC4", str + "$PBEWithSHAAnd128BitKeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND40BITRC4", str + "$PBEWithSHAAnd40BitKeyFactory");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar = pn.s.f46814i6;
            sb3.append(yVar);
            aVar.h(sb3.toString(), "PKCS12PBE");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar2 = pn.s.f46817j6;
            sb4.append(yVar2);
            aVar.h(sb4.toString(), "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
            aVar.h("Cipher.PBEWITHSHAAND128BITRC4", str + "$PBEWithSHAAnd128Bit");
            aVar.h("Cipher.PBEWITHSHAAND40BITRC4", str + "$PBEWithSHAAnd40Bit");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar, "PBEWITHSHAAND128BITRC4");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar2, "PBEWITHSHAAND40BITRC4");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
            aVar.k("Alg.Alias.Cipher", yVar, "PBEWITHSHAAND128BITRC4");
            aVar.k("Alg.Alias.Cipher", yVar2, "PBEWITHSHAAND40BITRC4");
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public d() {
            super(new cp.q0(), 0, 128, 1);
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public e() {
            super("PBEWithSHAAnd128BitRC4", pn.s.f46814i6, true, 2, 1, 128, 0);
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public f() {
            super(new cp.q0(), 0, 40, 1);
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public g() {
            super("PBEWithSHAAnd128BitRC4", pn.s.f46814i6, true, 2, 1, 40, 0);
        }
    }
}
