package zq;

import cp.l1;

/* JADX INFO: loaded from: classes5.dex */
public final class o0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-1024 IV";
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-256 IV";
        }
    }

    public static class c extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-512 IV";
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.e(new l1(1024)));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.e(new l1(256)));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.e(new l1(512)));
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public g() {
            super(new l1(1024));
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public h() {
            super(new l1(256));
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public i() {
            super(new l1(512));
        }
    }

    public static class j extends ar.c {
        public j() {
            super("Threefish-1024", 1024, new org.bouncycastle.crypto.j());
        }
    }

    public static class k extends ar.c {
        public k() {
            super("Threefish-256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class l extends ar.c {
        public l() {
            super("Threefish-512", 512, new org.bouncycastle.crypto.j());
        }
    }

    public static class m extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59615a = o0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59615a;
            sb2.append(str);
            sb2.append("$CMAC_256");
            aVar.h("Mac.Threefish-256CMAC", sb2.toString());
            aVar.h("Mac.Threefish-512CMAC", str + "$CMAC_512");
            aVar.h("Mac.Threefish-1024CMAC", str + "$CMAC_1024");
            aVar.h("Cipher.Threefish-256", str + "$ECB_256");
            aVar.h("Cipher.Threefish-512", str + "$ECB_512");
            aVar.h("Cipher.Threefish-1024", str + "$ECB_1024");
            aVar.h("KeyGenerator.Threefish-256", str + "$KeyGen_256");
            aVar.h("KeyGenerator.Threefish-512", str + "$KeyGen_512");
            aVar.h("KeyGenerator.Threefish-1024", str + "$KeyGen_1024");
            aVar.h("AlgorithmParameters.Threefish-256", str + "$AlgParams_256");
            aVar.h("AlgorithmParameters.Threefish-512", str + "$AlgParams_512");
            aVar.h("AlgorithmParameters.Threefish-1024", str + "$AlgParams_1024");
        }
    }
}
