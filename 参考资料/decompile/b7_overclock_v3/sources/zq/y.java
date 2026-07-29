package zq;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import kg.c;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;

/* JADX INFO: loaded from: classes5.dex */
public final class y {

    public static class a extends ar.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RC2ParameterSpec f59638d = null;

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            if (this.f59638d != null) {
                try {
                    AlgorithmParameters algorithmParametersA = a("RC2");
                    algorithmParametersA.init(this.f59638d);
                    return algorithmParametersA;
                } catch (Exception e10) {
                    throw new RuntimeException(e10.getMessage());
                }
            }
            byte[] bArr = new byte[8];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA2 = a("RC2");
                algorithmParametersA2.init(new IvParameterSpec(bArr));
                return algorithmParametersA2;
            } catch (Exception e11) {
                throw new RuntimeException(e11.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (!(algorithmParameterSpec instanceof RC2ParameterSpec)) {
                throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC2 parameter generation.");
            }
            this.f59638d = (RC2ParameterSpec) algorithmParameterSpec;
        }
    }

    public static class b extends ar.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final short[] f59639c = {189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, c.a.V4, 44, 195, 39, 95, c.a.Z4, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, c.a.U4, 23, 245, c.a.T4, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, c.a.Y4, 3, 121, 137, 98, 198, 215, 192, 210, 124, c.a.X4, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, c.a.S4, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, c.a.f37346a5, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, c.a.W4, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final short[] f59640d = {93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, c.a.Y4, 58, c.a.V4, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, c.a.Z4, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, c.a.X4, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, c.a.W4, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, c.a.U4, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, c.a.T4, 19, 236, c.a.f37346a5, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, c.a.S4, 24, 210, 205, 95, 50, 136, 14, 53, 253};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f59641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f59642b = 58;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            int i10;
            if ((cls == RC2ParameterSpec.class || cls == AlgorithmParameterSpec.class) && (i10 = this.f59642b) != -1) {
                return i10 < 256 ? new RC2ParameterSpec(f59640d[this.f59642b], this.f59641a) : new RC2ParameterSpec(this.f59642b, this.f59641a);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59641a);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to RC2 parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            return org.bouncycastle.util.a.p(this.f59641a);
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                int i10 = this.f59642b;
                return i10 == -1 ? new pn.v(engineGetEncoded()).getEncoded() : new pn.v(i10, engineGetEncoded()).getEncoded();
            }
            if (str.equals("RAW")) {
                return engineGetEncoded();
            }
            return null;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f59641a = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            if (!(algorithmParameterSpec instanceof RC2ParameterSpec)) {
                throw new InvalidParameterSpecException("IvParameterSpec or RC2ParameterSpec required to initialise a RC2 parameters algorithm parameters object");
            }
            RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
            int effectiveKeyBits = rC2ParameterSpec.getEffectiveKeyBits();
            if (effectiveKeyBits != -1) {
                int i10 = effectiveKeyBits;
                if (effectiveKeyBits < 256) {
                    i10 = f59639c[effectiveKeyBits];
                }
                this.f59642b = i10;
            }
            this.f59641a = rC2ParameterSpec.getIV();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59641a = org.bouncycastle.util.a.p(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                if (!str.equals("RAW")) {
                    throw new IOException("Unknown parameters format in IV parameters object");
                }
                engineInit(bArr);
            } else {
                pn.v vVarY = pn.v.y(gm.c0.D(bArr));
                if (vVarY.z() != null) {
                    this.f59642b = vVarY.z().intValue();
                }
                this.f59641a = vVarY.x();
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "RC2 Parameters";
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c() {
            super(new jp.c(new cp.o0()), 64);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.c(new cp.o0()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.d(new cp.o0()));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f() {
            super(new cp.o0());
        }
    }

    public static class g extends ar.c {
        public g() {
            super("RC2", 128, new org.bouncycastle.crypto.j());
        }
    }

    public static class h extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59643a = y.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59643a;
            sb2.append(str);
            sb2.append("$AlgParamGen");
            aVar.h("AlgorithmParameterGenerator.RC2", sb2.toString());
            aVar.h("AlgorithmParameterGenerator.1.2.840.113549.3.2", str + "$AlgParamGen");
            aVar.h("KeyGenerator.RC2", str + "$KeyGenerator");
            aVar.h("KeyGenerator.1.2.840.113549.3.2", str + "$KeyGenerator");
            aVar.h("AlgorithmParameters.RC2", str + "$AlgParams");
            aVar.h("AlgorithmParameters.1.2.840.113549.3.2", str + "$AlgParams");
            aVar.h("Cipher.RC2", str + "$ECB");
            aVar.h("Cipher.RC2WRAP", str + "$Wrap");
            aVar.k("Alg.Alias.Cipher", pn.s.f46838q6, "RC2WRAP");
            aVar.k("Cipher", pn.s.f46788a4, str + "$CBC");
            aVar.h("Mac.RC2MAC", str + "$CBCMAC");
            aVar.h("Alg.Alias.Mac.RC2", "RC2MAC");
            aVar.h("Mac.RC2MAC/CFB8", str + "$CFB8MAC");
            aVar.h("Alg.Alias.Mac.RC2/CFB8", "RC2MAC/CFB8");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDRC2-CBC", "PBEWITHMD2ANDRC2");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
            gm.y yVar = pn.s.R3;
            aVar.k("Alg.Alias.SecretKeyFactory", yVar, "PBEWITHMD2ANDRC2");
            gm.y yVar2 = pn.s.T3;
            aVar.k("Alg.Alias.SecretKeyFactory", yVar2, "PBEWITHMD5ANDRC2");
            gm.y yVar3 = pn.s.V3;
            aVar.k("Alg.Alias.SecretKeyFactory", yVar3, "PBEWITHSHA1ANDRC2");
            aVar.h("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
            aVar.h("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
            aVar.h("SecretKeyFactory.PBEWITHMD2ANDRC2", str + "$PBEWithMD2KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHMD5ANDRC2", str + "$PBEWithMD5KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHSHA1ANDRC2", str + "$PBEWithSHA1KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", str + "$PBEWithSHAAnd128BitKeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", str + "$PBEWithSHAAnd40BitKeyFactory");
            aVar.k("Alg.Alias.Cipher", yVar, "PBEWITHMD2ANDRC2");
            aVar.k("Alg.Alias.Cipher", yVar2, "PBEWITHMD5ANDRC2");
            aVar.k("Alg.Alias.Cipher", yVar3, "PBEWITHSHA1ANDRC2");
            aVar.h("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWithSHAAnd3KeyTripleDES", "PKCS12PBE");
            aVar.k("Alg.Alias.Cipher", pn.s.f46826m6, "PBEWITHSHAAND128BITRC2-CBC");
            aVar.k("Alg.Alias.Cipher", pn.s.f46829n6, "PBEWITHSHAAND40BITRC2-CBC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC2-CBC", "PBEWITHSHAAND128BITRC2-CBC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC2-CBC", "PBEWITHSHAAND40BITRC2-CBC");
            aVar.h("Cipher.PBEWITHSHA1ANDRC2", str + "$PBEWithSHA1AndRC2");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHAANDRC2-CBC", "PBEWITHSHA1ANDRC2");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
            aVar.h("Cipher.PBEWITHSHAAND128BITRC2-CBC", str + "$PBEWithSHAAnd128BitRC2");
            aVar.h("Cipher.PBEWITHSHAAND40BITRC2-CBC", str + "$PBEWithSHAAnd40BitRC2");
            aVar.h("Cipher.PBEWITHMD5ANDRC2", str + "$PBEWithMD5AndRC2");
            aVar.h("Alg.Alias.Cipher.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC2", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2-CBC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC2-CBC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC2-CBC", "PKCS12PBE");
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public i() {
            super("PBEwithMD2andRC2", pn.s.R3, true, 0, 5, 64, 64);
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public j() {
            super(new jp.c(new cp.o0()), 0, 0, 64, 8);
        }
    }

    public static class k extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public k() {
            super("PBEwithMD5andRC2", pn.s.T3, true, 0, 0, 64, 64);
        }
    }

    public static class l extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public l() {
            super(new jp.c(new cp.o0()), 0, 1, 64, 8);
        }
    }

    public static class m extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public m() {
            super("PBEwithSHA1andRC2", pn.s.V3, true, 0, 1, 64, 64);
        }
    }

    public static class n extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public n() {
            super("PBEwithSHAand128BitRC2-CBC", pn.s.f46826m6, true, 2, 1, 128, 64);
        }
    }

    public static class o extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public o() {
            super(new jp.c(new cp.o0()), 2, 1, 128, 8);
        }
    }

    public static class p extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public p() {
            super("PBEwithSHAand40BitRC2-CBC", pn.s.f46829n6, true, 2, 1, 40, 64);
        }
    }

    public static class q extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public q() {
            super(new jp.c(new cp.o0()), 2, 1, 40, 8);
        }
    }

    public static class r extends BaseWrapCipher {
        public r() {
            super(new cp.p0());
        }
    }
}
