package zq;

import cp.p1;

/* JADX INFO: loaded from: classes5.dex */
public final class r0 {

    public static class a extends org.bouncycastle.jcajce.provider.symmetric.util.c {
        public a() {
            super(new p1(), 16);
        }
    }

    public static class b extends ar.c {
        public b() {
            super("VMPC-KSA3", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class c extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59622a = r0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59622a;
            sb2.append(str);
            sb2.append("$Base");
            aVar.h("Cipher.VMPC-KSA3", sb2.toString());
            aVar.h("KeyGenerator.VMPC-KSA3", str + "$KeyGen");
        }
    }
}
