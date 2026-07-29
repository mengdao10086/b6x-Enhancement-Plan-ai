package zq;

import cp.o1;

/* JADX INFO: loaded from: classes5.dex */
public final class q0 {

    public static class a extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public a() {
            super(new o1(), 16);
        }
    }

    public static class b extends ar.c {
        public b() {
            super("VMPC", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.u());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59619a = q0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59619a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.VMPC", sb2.toString());
            aVar.h("KeyGenerator.VMPC", str + "$KeyGen");
            aVar.h("Mac.VMPCMAC", str + "$Mac");
            aVar.h("Alg.Alias.Mac.VMPC", "VMPCMAC");
            aVar.h("Alg.Alias.Mac.VMPC-MAC", "VMPCMAC");
        }
    }
}
