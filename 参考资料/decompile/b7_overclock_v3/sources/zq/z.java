package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class z {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("RC5");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC5 parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "RC5 IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new cp.r0()), 64);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.d(new cp.r0()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public e() {
            super(new cp.r0());
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f() {
            super(new cp.s0());
        }
    }

    public static class g extends ar.c {
        public g() {
            super("RC5", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class h extends ar.c {
        public h() {
            super("RC5-64", 256, new org.bouncycastle.crypto.j());
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public i() {
            super(new ip.c(new cp.r0()));
        }
    }

    public static class j extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59644a = z.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59644a;
            sb2.append(str);
            sb2.append("$ECB32");
            aVar.h("Cipher.RC5", sb2.toString());
            aVar.h("Alg.Alias.Cipher.RC5-32", "RC5");
            aVar.h("Cipher.RC5-64", str + "$ECB64");
            aVar.h("KeyGenerator.RC5", str + "$KeyGen32");
            aVar.h("Alg.Alias.KeyGenerator.RC5-32", "RC5");
            aVar.h("KeyGenerator.RC5-64", str + "$KeyGen64");
            aVar.h("AlgorithmParameters.RC5", str + "$AlgParams");
            aVar.h("AlgorithmParameters.RC5-64", str + "$AlgParams");
            aVar.h("Mac.RC5MAC", str + "$Mac32");
            aVar.h("Alg.Alias.Mac.RC5", "RC5MAC");
            aVar.h("Mac.RC5MAC/CFB8", str + "$CFB8Mac32");
            aVar.h("Alg.Alias.Mac.RC5/CFB8", "RC5MAC/CFB8");
        }
    }
}
