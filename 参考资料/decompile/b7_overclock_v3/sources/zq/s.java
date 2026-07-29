package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class s {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("Noekeon");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Noekeon parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Noekeon IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.l0();
            }
        }

        public c() {
            super(new a());
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.i(new jp.n(new cp.l0())));
        }
    }

    public static class e extends ar.c {
        public e() {
            super("Noekeon", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class f extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59623a = s.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59623a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.NOEKEON", sb2.toString());
            aVar.h("AlgorithmParameterGenerator.NOEKEON", str + "$AlgParamGen");
            aVar.h("Cipher.NOEKEON", str + "$ECB");
            aVar.h("KeyGenerator.NOEKEON", str + "$KeyGen");
            c(aVar, "NOEKEON", str + "$GMAC", str + "$KeyGen");
            d(aVar, "NOEKEON", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.q(new cp.l0()));
        }
    }

    public static class h extends ar.c {
        public h() {
            super("Poly1305-Noekeon", 256, new fp.k0());
        }
    }
}
