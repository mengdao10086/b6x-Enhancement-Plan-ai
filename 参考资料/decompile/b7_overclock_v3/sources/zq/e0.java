package zq;

import cp.e1;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("SM4");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SM4 parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "SM4 IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.e(new e1()));
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new e1();
            }
        }

        public d() {
            super(new a());
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.i(new jp.n(new e1())));
        }
    }

    public static class f extends ar.c {
        public f() {
            super("SM4", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class g extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59578a = e0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59578a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.SM4", sb2.toString());
            aVar.h("AlgorithmParameterGenerator.SM4", str + "$AlgParamGen");
            aVar.h("Cipher.SM4", str + "$ECB");
            aVar.h("KeyGenerator.SM4", str + "$KeyGen");
            b(aVar, "SM4", str + "$CMAC", str + "$KeyGen");
            c(aVar, "SM4", str + "$GMAC", str + "$KeyGen");
            d(aVar, "SM4", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h() {
            super(new ip.q(new e1()));
        }
    }

    public static class i extends ar.c {
        public i() {
            super("Poly1305-SM4", 256, new fp.k0());
        }
    }
}
