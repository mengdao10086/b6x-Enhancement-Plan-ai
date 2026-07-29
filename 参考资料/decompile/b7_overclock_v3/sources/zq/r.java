package zq;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public final class r {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("IDEA");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
        }
    }

    public static class b extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f59620a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new IvParameterSpec(this.f59620a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return new in.b(engineGetEncoded("RAW")).getEncoded();
            }
            if (!str.equals("RAW")) {
                return null;
            }
            byte[] bArr = this.f59620a;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
            this.f59620a = ((IvParameterSpec) algorithmParameterSpec).getIV();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[bArr.length];
            this.f59620a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                if (!str.equals("ASN.1")) {
                    throw new IOException("Unknown parameters format in IV parameters object");
                }
                engineInit(in.b.y(bArr).x());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "IDEA Parameters";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new cp.g0()), 64);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.d(new cp.g0()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public e() {
            super(new cp.g0());
        }
    }

    public static class f extends ar.c {
        public f() {
            super("IDEA", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.c(new cp.g0()));
        }
    }

    public static class h extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59621a = r.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59621a;
            sb2.append(str);
            sb2.append("$AlgParamGen");
            aVar.h("AlgorithmParameterGenerator.IDEA", sb2.toString());
            aVar.h("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", str + "$AlgParamGen");
            aVar.h("AlgorithmParameters.IDEA", str + "$AlgParams");
            aVar.h("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", str + "$AlgParams");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
            aVar.h("Cipher.IDEA", str + "$ECB");
            gm.y yVar = in.c.f32567w;
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.h("Cipher.PBEWITHSHAANDIDEA-CBC", str + "$PBEWithSHAAndIDEA");
            aVar.h("KeyGenerator.IDEA", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar, str + "$KeyGen");
            aVar.h("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", str + "$PBEWithSHAAndIDEAKeyGen");
            aVar.h("Mac.IDEAMAC", str + "$Mac");
            aVar.h("Alg.Alias.Mac.IDEA", "IDEAMAC");
            aVar.h("Mac.IDEAMAC/CFB8", str + "$CFB8Mac");
            aVar.h("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public i() {
            super(new jp.c(new cp.g0()));
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public j() {
            super("PBEwithSHAandIDEA-CBC", null, true, 2, 1, 128, 64);
        }
    }
}
