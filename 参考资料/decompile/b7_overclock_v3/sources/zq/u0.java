package zq;

import cp.t1;
import cp.v1;

/* JADX INFO: loaded from: classes5.dex */
public class u0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Zuc IV";
        }
    }

    public static class b extends ar.c {
        public b() {
            super("ZUC128", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class c extends ar.c {
        public c() {
            super("ZUC256", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59629a = u0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59629a;
            sb2.append(str);
            sb2.append("$Zuc128");
            aVar.h("Cipher.ZUC-128", sb2.toString());
            aVar.h("KeyGenerator.ZUC-128", str + "$KeyGen128");
            aVar.h("AlgorithmParameters.ZUC-128", str + "$AlgParams");
            aVar.h("Cipher.ZUC-256", str + "$Zuc256");
            aVar.h("KeyGenerator.ZUC-256", str + "$KeyGen256");
            aVar.h("AlgorithmParameters.ZUC-256", str + "$AlgParams");
            aVar.h("Mac.ZUC-128", str + "$ZucMac128");
            aVar.h("Mac.ZUC-256", str + "$ZucMac256");
            aVar.h("Alg.Alias.Mac.ZUC-256-128", "ZUC-256");
            aVar.h("Mac.ZUC-256-64", str + "$ZucMac256_64");
            aVar.h("Mac.ZUC-256-32", str + "$ZucMac256_32");
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public e() {
            super(new t1(), 16, 128);
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public f() {
            super(new v1(), 25, 256);
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.v());
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h() {
            super(new ip.w(128));
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public i() {
            super(new ip.w(32));
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.w(64));
        }
    }
}
