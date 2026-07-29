package zq;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("CAST5");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for CAST5 parameter generation.");
        }
    }

    public static class b extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f59575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f59576b = 128;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new IvParameterSpec(this.f59575a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to CAST5 parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            byte[] bArr = this.f59575a;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return new in.a(engineGetEncoded(), this.f59576b).getEncoded();
            }
            if (str.equals("RAW")) {
                return engineGetEncoded();
            }
            return null;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a CAST5 parameters algorithm parameters object");
            }
            this.f59575a = ((IvParameterSpec) algorithmParameterSpec).getIV();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[bArr.length];
            this.f59575a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (a(str)) {
                in.a aVarY = in.a.y(new gm.s(bArr).n());
                this.f59576b = aVarY.z();
                this.f59575a = aVarY.x();
            } else {
                if (!str.equals("RAW")) {
                    throw new IOException("Unknown parameters format in IV parameters object");
                }
                engineInit(bArr);
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "CAST5 Parameters";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new cp.j()), 64);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public d() {
            super(new cp.j());
        }
    }

    /* JADX INFO: renamed from: zq.e$e, reason: collision with other inner class name */
    public static class C0695e extends ar.c {
        public C0695e() {
            super("CAST5", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class f extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59577a = e.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59577a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.CAST5", sb2.toString());
            aVar.h("Alg.Alias.AlgorithmParameters.1.2.840.113533.7.66.10", "CAST5");
            aVar.h("AlgorithmParameterGenerator.CAST5", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator.1.2.840.113533.7.66.10", "CAST5");
            aVar.h("Cipher.CAST5", str + "$ECB");
            gm.y yVar = in.c.f32565u;
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.h("KeyGenerator.CAST5", str + "$KeyGen");
            aVar.k("Alg.Alias.KeyGenerator", yVar, "CAST5");
        }
    }
}
