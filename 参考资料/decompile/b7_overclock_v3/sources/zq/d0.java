package zq;

import cp.c1;
import cp.d1;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;

/* JADX INFO: loaded from: classes5.dex */
public final class d0 {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("SEED");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SEED parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "SEED IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new c1()), 128);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.e(new c1()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new c1();
            }
        }

        public e() {
            super(new a());
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.i(new jp.n(new c1())));
        }
    }

    public static class g extends ar.d {
        public g() {
            super("SEED", null);
        }
    }

    public static class h extends ar.c {
        public h() {
            super("SEED", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class i extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59574a = d0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59574a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.SEED", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar = gn.a.f29838a;
            sb3.append(yVar);
            aVar.h(sb3.toString(), "SEED");
            aVar.h("AlgorithmParameterGenerator.SEED", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar, "SEED");
            aVar.h("Cipher.SEED", str + "$ECB");
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.h("Cipher.SEEDWRAP", str + "$Wrap");
            gm.y yVar2 = gn.a.f29841d;
            aVar.k("Alg.Alias.Cipher", yVar2, "SEEDWRAP");
            aVar.h("Alg.Alias.Cipher.SEEDKW", "SEEDWRAP");
            aVar.h("KeyGenerator.SEED", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar, str + "$KeyGen");
            aVar.k("KeyGenerator", yVar2, str + "$KeyGen");
            aVar.h("SecretKeyFactory.SEED", str + "$KeyFactory");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar, "SEED");
            b(aVar, "SEED", str + "$CMAC", str + "$KeyGen");
            c(aVar, "SEED", str + "$GMAC", str + "$KeyGen");
            d(aVar, "SEED", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.q(new c1()));
        }
    }

    public static class k extends ar.c {
        public k() {
            super("Poly1305-SEED", 256, new fp.k0());
        }
    }

    public static class l extends BaseWrapCipher {
        public l() {
            super(new d1());
        }
    }
}
