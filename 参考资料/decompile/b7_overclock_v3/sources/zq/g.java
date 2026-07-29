package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("Camellia");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Camellia parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Camellia IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new cp.l()), 128);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.l();
            }
        }

        public d() {
            super(new a());
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.i(new jp.n(new cp.l())));
        }
    }

    public static class f extends ar.d {
        public f() {
            super("Camellia", null);
        }
    }

    /* JADX INFO: renamed from: zq.g$g, reason: collision with other inner class name */
    public static class C0697g extends j {
        public C0697g() {
            super(128);
        }
    }

    public static class h extends j {
        public h() {
            super(192);
        }
    }

    public static class i extends j {
        public i() {
            super(256);
        }
    }

    public static class j extends ar.c {
        public j() {
            this(256);
        }

        public j(int i10) {
            super("Camellia", i10, new org.bouncycastle.crypto.j());
        }
    }

    public static class k extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59581a = g.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59581a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.CAMELLIA", sb2.toString());
            gm.y yVar = mn.a.f41443a;
            aVar.k("Alg.Alias.AlgorithmParameters", yVar, "CAMELLIA");
            gm.y yVar2 = mn.a.f41444b;
            aVar.k("Alg.Alias.AlgorithmParameters", yVar2, "CAMELLIA");
            gm.y yVar3 = mn.a.f41445c;
            aVar.k("Alg.Alias.AlgorithmParameters", yVar3, "CAMELLIA");
            aVar.h("AlgorithmParameterGenerator.CAMELLIA", str + "$AlgParamGen");
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar, "CAMELLIA");
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar2, "CAMELLIA");
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar3, "CAMELLIA");
            aVar.h("Cipher.CAMELLIA", str + "$ECB");
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.k("Cipher", yVar2, str + "$CBC");
            aVar.k("Cipher", yVar3, str + "$CBC");
            aVar.h("Cipher.CAMELLIARFC3211WRAP", str + "$RFC3211Wrap");
            aVar.h("Cipher.CAMELLIAWRAP", str + "$Wrap");
            gm.y yVar4 = mn.a.f41446d;
            aVar.k("Alg.Alias.Cipher", yVar4, "CAMELLIAWRAP");
            gm.y yVar5 = mn.a.f41447e;
            aVar.k("Alg.Alias.Cipher", yVar5, "CAMELLIAWRAP");
            gm.y yVar6 = mn.a.f41448f;
            aVar.k("Alg.Alias.Cipher", yVar6, "CAMELLIAWRAP");
            aVar.h("SecretKeyFactory.CAMELLIA", str + "$KeyFactory");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar, "CAMELLIA");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar2, "CAMELLIA");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar3, "CAMELLIA");
            aVar.h("KeyGenerator.CAMELLIA", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar4, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar5, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar6, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar2, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar3, str + "$KeyGen256");
            c(aVar, "CAMELLIA", str + "$GMAC", str + "$KeyGen");
            d(aVar, "CAMELLIA", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class l extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public l() {
            super(new ip.q(new cp.l()));
        }
    }

    public static class m extends ar.c {
        public m() {
            super("Poly1305-Camellia", 256, new fp.k0());
        }
    }

    public static class n extends BaseWrapCipher {
        public n() {
            super(new cp.u0(new cp.l()), 16);
        }
    }

    public static class o extends BaseWrapCipher {
        public o() {
            super(new cp.n());
        }
    }
}
