package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class a0 {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("RC6");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC6 parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "RC6 IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new cp.t0()), 128);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public d() {
            super(new org.bouncycastle.crypto.h(new jp.e(new cp.t0(), 128)), 128);
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.t0();
            }
        }

        public e() {
            super(new a());
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.i(new jp.n(new cp.t0())));
        }
    }

    public static class g extends ar.c {
        public g() {
            super("RC6", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class h extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59565a = a0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59565a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.RC6", sb2.toString());
            aVar.h("KeyGenerator.RC6", str + "$KeyGen");
            aVar.h("AlgorithmParameters.RC6", str + "$AlgParams");
            c(aVar, "RC6", str + "$GMAC", str + "$KeyGen");
            d(aVar, "RC6", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public i() {
            super(new org.bouncycastle.crypto.h(new jp.x(new cp.t0(), 128)), 128);
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.q(new cp.t0()));
        }
    }

    public static class k extends ar.c {
        public k() {
            super("Poly1305-RC6", 256, new fp.k0());
        }
    }
}
