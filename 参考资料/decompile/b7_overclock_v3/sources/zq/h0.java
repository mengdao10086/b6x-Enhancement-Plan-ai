package zq;

import cp.i1;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class h0 {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[32];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("Shacal2");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Shacal2 parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Shacal2 IV";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new i1()), 256);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.e(new i1()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new i1();
            }
        }

        public e() {
            super(new a());
        }
    }

    public static class f extends ar.c {
        public f() {
            super("SHACAL-2", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class g extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59584a = h0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59584a;
            sb2.append(str);
            sb2.append("$CMAC");
            aVar.h("Mac.Shacal-2CMAC", sb2.toString());
            aVar.h("Cipher.Shacal2", str + "$ECB");
            aVar.h("Cipher.SHACAL-2", str + "$ECB");
            aVar.h("KeyGenerator.Shacal2", str + "$KeyGen");
            aVar.h("AlgorithmParameterGenerator.Shacal2", str + "$AlgParamGen");
            aVar.h("AlgorithmParameters.Shacal2", str + "$AlgParams");
            aVar.h("KeyGenerator.SHACAL-2", str + "$KeyGen");
            aVar.h("AlgorithmParameterGenerator.SHACAL-2", str + "$AlgParamGen");
            aVar.h("AlgorithmParameters.SHACAL-2", str + "$AlgParams");
        }
    }
}
