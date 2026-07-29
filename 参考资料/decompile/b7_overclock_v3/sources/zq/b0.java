package zq;

import cp.b1;

/* JADX INFO: loaded from: classes5.dex */
public final class b0 {

    public static class a extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Rijndael IV";
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new b1();
            }
        }

        public b() {
            super(new a());
        }
    }

    public static class c extends ar.c {
        public c() {
            super("Rijndael", 192, new org.bouncycastle.crypto.j());
        }
    }

    public static class d extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59567a = b0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59567a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.RIJNDAEL", sb2.toString());
            aVar.h("KeyGenerator.RIJNDAEL", str + "$KeyGen");
            aVar.h("AlgorithmParameters.RIJNDAEL", str + "$AlgParams");
        }
    }
}
