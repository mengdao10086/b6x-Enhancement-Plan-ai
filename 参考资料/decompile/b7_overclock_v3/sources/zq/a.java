package zq;

import cp.w0;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f59556a;

    public static class a0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public a0() {
            super(new jp.c(new cp.a()), 2, 1, 128, 16);
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.b {

        /* JADX INFO: renamed from: zq.a$b$a, reason: collision with other inner class name */
        public static class C0690a implements org.bouncycastle.crypto.a0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final jp.d f59557a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f59558b;

            public C0690a() {
                this.f59557a = new jp.d(new cp.a());
                this.f59558b = 8;
            }

            @Override // org.bouncycastle.crypto.a0
            public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
                this.f59557a.a(true, kVar);
                this.f59558b = this.f59557a.d().length;
            }

            @Override // org.bouncycastle.crypto.a0
            public String b() {
                return this.f59557a.b() + "Mac";
            }

            @Override // org.bouncycastle.crypto.a0
            public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
                try {
                    return this.f59557a.c(bArr, 0);
                } catch (InvalidCipherTextException e10) {
                    throw new IllegalStateException("exception on doFinal(): " + e10.toString());
                }
            }

            @Override // org.bouncycastle.crypto.a0
            public int d() {
                return this.f59558b;
            }

            @Override // org.bouncycastle.crypto.a0
            public void reset() {
                this.f59557a.reset();
            }

            @Override // org.bouncycastle.crypto.a0
            public void update(byte b10) throws IllegalStateException {
                this.f59557a.j(b10);
            }

            @Override // org.bouncycastle.crypto.a0
            public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
                this.f59557a.k(bArr, i10, i11);
            }
        }

        public b() {
            super(new C0690a());
        }
    }

    public static class b0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b0() {
            super(new jp.c(new cp.a()), 2, 1, 192, 16);
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.e(new cp.a()));
        }
    }

    public static class c0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public c0() {
            super(new jp.c(new cp.a()), 2, 1, 256, 16);
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.i(new jp.n(new cp.a())));
        }
    }

    public static class d0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public d0() {
            super(new jp.c(new cp.a()), 2, 4, 128, 16);
        }
    }

    public static class e extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a(m5.b.f40641c);
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class e0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public e0() {
            super(new jp.c(new cp.a()), 2, 4, 192, 16);
        }
    }

    public static class f extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.f8855b == null) {
                this.f8855b = new SecureRandom();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("CCM");
                algorithmParametersA.init(new cq.a(bArr, 12).getEncoded());
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class f0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f0() {
            super(new jp.c(new cp.a()), 2, 4, 256, 16);
        }
    }

    public static class g extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.f8855b == null) {
                this.f8855b = new SecureRandom();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("GCM");
                algorithmParametersA.init(new cq.c(bArr, 16).getEncoded());
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class g0 extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public g0() {
            super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
        }
    }

    public static class h extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "AES IV";
        }
    }

    public static class h0 extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public h0() {
            super("PBEWithSHA256And192BitAES-CBC-BC", null, true, 2, 4, 192, 128);
        }
    }

    public static class i extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public cq.a f59559a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || ar.g.f(cls)) {
                return ar.g.e() ? ar.g.c(this.f59559a.b()) : new cr.a(this.f59559a.z(), this.f59559a.x() * 8);
            }
            if (cls == cr.a.class) {
                return new cr.a(this.f59559a.z(), this.f59559a.x() * 8);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59559a.z());
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.f59559a.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return this.f59559a.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (ar.g.g(algorithmParameterSpec)) {
                this.f59559a = cq.a.y(ar.g.b(algorithmParameterSpec));
                return;
            }
            if (algorithmParameterSpec instanceof cr.a) {
                cr.a aVar = (cr.a) algorithmParameterSpec;
                this.f59559a = new cq.a(aVar.c(), aVar.b() / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59559a = cq.a.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("unknown format specified");
            }
            this.f59559a = cq.a.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "CCM";
        }
    }

    public static class i0 extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public i0() {
            super("PBEWithSHA256And256BitAES-CBC-BC", null, true, 2, 4, 256, 128);
        }
    }

    public static class j extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public cq.c f59560a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || ar.g.f(cls)) {
                return ar.g.e() ? ar.g.c(this.f59560a.b()) : new cr.a(this.f59560a.z(), this.f59560a.x() * 8);
            }
            if (cls == cr.a.class) {
                return new cr.a(this.f59560a.z(), this.f59560a.x() * 8);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59560a.z());
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.f59560a.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return this.f59560a.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (ar.g.g(algorithmParameterSpec)) {
                this.f59560a = ar.g.b(algorithmParameterSpec);
                return;
            }
            if (algorithmParameterSpec instanceof cr.a) {
                cr.a aVar = (cr.a) algorithmParameterSpec;
                this.f59560a = new cq.c(aVar.c(), aVar.b() / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59560a = cq.c.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("unknown format specified");
            }
            this.f59560a = cq.c.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "GCM";
        }
    }

    public static class j0 extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public j0() {
            super("PBEWithSHA1And128BitAES-CBC-BC", null, true, 2, 1, 128, 128);
        }
    }

    public static class k extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public k() {
            super(new jp.c(new cp.a()), 128);
        }
    }

    public static class k0 extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public k0() {
            super("PBEWithSHA1And192BitAES-CBC-BC", null, true, 2, 1, 192, 128);
        }
    }

    public static class l extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public l() {
            super((jp.a) new jp.d(new cp.a()), false, 12);
        }
    }

    public static class l0 extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public l0() {
            super("PBEWithSHA1And256BitAES-CBC-BC", null, true, 2, 1, 256, 128);
        }
    }

    public static class m extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public m() {
            super(new org.bouncycastle.crypto.h(new jp.e(new cp.a(), 128)), 128);
        }
    }

    public static class m0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public m0() {
            super(new ip.q(new cp.a()));
        }
    }

    public static class n extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        /* JADX INFO: renamed from: zq.a$n$a, reason: collision with other inner class name */
        public class C0691a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.a();
            }
        }

        public n() {
            super(new C0691a());
        }
    }

    public static class n0 extends ar.c {
        public n0() {
            super("Poly1305-AES", 256, new fp.k0());
        }
    }

    public static class o extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public o() {
            super(new jp.n(new cp.a()));
        }
    }

    public static class o0 extends BaseWrapCipher {
        public o0() {
            super(new cp.u0(new cp.a()), 16);
        }
    }

    public static class p extends ar.d {
        public p() {
            super(m5.b.f40641c, null);
        }
    }

    public static class p0 extends BaseWrapCipher {
        public p0() {
            super(new w0(new cp.a()));
        }
    }

    public static class q extends t {
        public q() {
            super(128);
        }
    }

    public static class q0 extends BaseWrapCipher {
        public q0() {
            super(new cp.d());
        }
    }

    public static class r extends t {
        public r() {
            super(192);
        }
    }

    public static class r0 extends BaseWrapCipher {
        public r0() {
            super(new cp.e());
        }
    }

    public static class s extends t {
        public s() {
            super(256);
        }
    }

    public static class t extends ar.c {
        public t() {
            this(192);
        }

        public t(int i10) {
            super(m5.b.f40641c, i10, new org.bouncycastle.crypto.j());
        }
    }

    public static class u extends zq.l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59561a = a.class.getName();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f59562b = "2.16.840.1.101.3.4.2";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f59563c = "2.16.840.1.101.3.4.22";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f59564d = "2.16.840.1.101.3.4.42";

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59561a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.AES", sb2.toString());
            aVar.h("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", m5.b.f40641c);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar = kn.d.f37625y;
            sb3.append(yVar);
            aVar.h(sb3.toString(), m5.b.f40641c);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar2 = kn.d.G;
            sb4.append(yVar2);
            aVar.h(sb4.toString(), m5.b.f40641c);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar3 = kn.d.O;
            sb5.append(yVar3);
            aVar.h(sb5.toString(), m5.b.f40641c);
            aVar.h("AlgorithmParameters.GCM", str + "$AlgParamsGCM");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar4 = kn.d.C;
            sb6.append(yVar4);
            aVar.h(sb6.toString(), "GCM");
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar5 = kn.d.K;
            sb7.append(yVar5);
            aVar.h(sb7.toString(), "GCM");
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar6 = kn.d.S;
            sb8.append(yVar6);
            aVar.h(sb8.toString(), "GCM");
            aVar.h("AlgorithmParameters.CCM", str + "$AlgParamsCCM");
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar7 = kn.d.D;
            sb9.append(yVar7);
            aVar.h(sb9.toString(), "CCM");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar8 = kn.d.L;
            sb10.append(yVar8);
            aVar.h(sb10.toString(), "CCM");
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar9 = kn.d.T;
            sb11.append(yVar9);
            aVar.h(sb11.toString(), "CCM");
            aVar.h("AlgorithmParameterGenerator.AES", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar, m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar2, m5.b.f40641c);
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar3, m5.b.f40641c);
            aVar.d("Cipher.AES", a.f59556a);
            aVar.h("Cipher.AES", str + "$ECB");
            aVar.h("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", m5.b.f40641c);
            aVar.h("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", m5.b.f40641c);
            aVar.h("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", m5.b.f40641c);
            gm.y yVar10 = kn.d.f37624x;
            aVar.k("Cipher", yVar10, str + "$ECB");
            gm.y yVar11 = kn.d.F;
            aVar.k("Cipher", yVar11, str + "$ECB");
            gm.y yVar12 = kn.d.N;
            aVar.k("Cipher", yVar12, str + "$ECB");
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.k("Cipher", yVar2, str + "$CBC");
            aVar.k("Cipher", yVar3, str + "$CBC");
            gm.y yVar13 = kn.d.f37626z;
            aVar.k("Cipher", yVar13, str + "$OFB");
            gm.y yVar14 = kn.d.H;
            aVar.k("Cipher", yVar14, str + "$OFB");
            gm.y yVar15 = kn.d.P;
            aVar.k("Cipher", yVar15, str + "$OFB");
            gm.y yVar16 = kn.d.A;
            aVar.k("Cipher", yVar16, str + "$CFB");
            gm.y yVar17 = kn.d.I;
            aVar.k("Cipher", yVar17, str + "$CFB");
            gm.y yVar18 = kn.d.Q;
            aVar.k("Cipher", yVar18, str + "$CFB");
            aVar.d("Cipher.AESWRAP", a.f59556a);
            aVar.h("Cipher.AESWRAP", str + "$Wrap");
            gm.y yVar19 = kn.d.B;
            aVar.k("Alg.Alias.Cipher", yVar19, "AESWRAP");
            gm.y yVar20 = kn.d.J;
            aVar.k("Alg.Alias.Cipher", yVar20, "AESWRAP");
            gm.y yVar21 = kn.d.R;
            aVar.k("Alg.Alias.Cipher", yVar21, "AESWRAP");
            aVar.h("Alg.Alias.Cipher.AESKW", "AESWRAP");
            aVar.d("Cipher.AESWRAPPAD", a.f59556a);
            aVar.h("Cipher.AESWRAPPAD", str + "$WrapPad");
            gm.y yVar22 = kn.d.E;
            aVar.k("Alg.Alias.Cipher", yVar22, "AESWRAPPAD");
            gm.y yVar23 = kn.d.M;
            aVar.k("Alg.Alias.Cipher", yVar23, "AESWRAPPAD");
            gm.y yVar24 = kn.d.U;
            aVar.k("Alg.Alias.Cipher", yVar24, "AESWRAPPAD");
            aVar.h("Alg.Alias.Cipher.AESKWP", "AESWRAPPAD");
            aVar.h("Cipher.AESRFC3211WRAP", str + "$RFC3211Wrap");
            aVar.h("Cipher.AESRFC5649WRAP", str + "$RFC5649Wrap");
            aVar.h("AlgorithmParameterGenerator.CCM", str + "$AlgParamGenCCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar7, "CCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar8, "CCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar9, "CCM");
            aVar.d("Cipher.CCM", a.f59556a);
            aVar.h("Cipher.CCM", str + "$CCM");
            aVar.k("Alg.Alias.Cipher", yVar7, "CCM");
            aVar.k("Alg.Alias.Cipher", yVar8, "CCM");
            aVar.k("Alg.Alias.Cipher", yVar9, "CCM");
            aVar.h("AlgorithmParameterGenerator.GCM", str + "$AlgParamGenGCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar4, "GCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar5, "GCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar6, "GCM");
            aVar.d("Cipher.GCM", a.f59556a);
            aVar.h("Cipher.GCM", str + "$GCM");
            aVar.k("Alg.Alias.Cipher", yVar4, "GCM");
            aVar.k("Alg.Alias.Cipher", yVar5, "GCM");
            aVar.k("Alg.Alias.Cipher", yVar6, "GCM");
            aVar.h("KeyGenerator.AES", str + "$KeyGen");
            aVar.h("KeyGenerator.2.16.840.1.101.3.4.2", str + "$KeyGen128");
            aVar.h("KeyGenerator.2.16.840.1.101.3.4.22", str + "$KeyGen192");
            aVar.h("KeyGenerator.2.16.840.1.101.3.4.42", str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar10, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar13, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar16, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar11, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar2, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar14, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar17, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar12, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar3, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar15, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar18, str + "$KeyGen256");
            aVar.h("KeyGenerator.AESWRAP", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar19, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar20, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar21, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar4, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar5, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar6, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar7, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar8, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar9, str + "$KeyGen256");
            aVar.h("KeyGenerator.AESWRAPPAD", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar22, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar23, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar24, str + "$KeyGen256");
            aVar.h("Mac.AESCMAC", str + "$AESCMAC");
            aVar.h("Mac.AESCCMMAC", str + "$AESCCMMAC");
            aVar.h("Alg.Alias.Mac." + yVar7.L(), "AESCCMMAC");
            aVar.h("Alg.Alias.Mac." + yVar8.L(), "AESCCMMAC");
            aVar.h("Alg.Alias.Mac." + yVar9.L(), "AESCCMMAC");
            gm.y yVar25 = im.a.f32490l;
            aVar.k("Alg.Alias.Cipher", yVar25, "PBEWITHSHAAND128BITAES-CBC-BC");
            gm.y yVar26 = im.a.f32491m;
            aVar.k("Alg.Alias.Cipher", yVar26, "PBEWITHSHAAND192BITAES-CBC-BC");
            gm.y yVar27 = im.a.f32492n;
            aVar.k("Alg.Alias.Cipher", yVar27, "PBEWITHSHAAND256BITAES-CBC-BC");
            gm.y yVar28 = im.a.f32493o;
            aVar.k("Alg.Alias.Cipher", yVar28, "PBEWITHSHA256AND128BITAES-CBC-BC");
            gm.y yVar29 = im.a.f32494p;
            aVar.k("Alg.Alias.Cipher", yVar29, "PBEWITHSHA256AND192BITAES-CBC-BC");
            gm.y yVar30 = im.a.f32495q;
            aVar.k("Alg.Alias.Cipher", yVar30, "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.h("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", str + "$PBEWithSHA1AESCBC128");
            aVar.h("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", str + "$PBEWithSHA1AESCBC192");
            aVar.h("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", str + "$PBEWithSHA1AESCBC256");
            aVar.h("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", str + "$PBEWithSHA256AESCBC128");
            aVar.h("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", str + "$PBEWithSHA256AESCBC192");
            aVar.h("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", str + "$PBEWithSHA256AESCBC256");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHAAND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHAAND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHAAND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.h("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            aVar.h("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            aVar.h("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            aVar.h("SecretKeyFactory.AES", str + "$KeyFactory");
            aVar.k("SecretKeyFactory", kn.d.f37623w, str + "$KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", str + "$PBEWithMD5And128BitAESCBCOpenSSL");
            aVar.h("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", str + "$PBEWithMD5And192BitAESCBCOpenSSL");
            aVar.h("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", str + "$PBEWithMD5And256BitAESCBCOpenSSL");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", str + "$PBEWithSHAAnd128BitAESBC");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", str + "$PBEWithSHAAnd192BitAESBC");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", str + "$PBEWithSHAAnd256BitAESBC");
            aVar.h("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", str + "$PBEWithSHA256And128BitAESBC");
            aVar.h("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", str + "$PBEWithSHA256And192BitAESBC");
            aVar.h("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", str + "$PBEWithSHA256And256BitAESBC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar25, "PBEWITHSHAAND128BITAES-CBC-BC");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar26, "PBEWITHSHAAND192BITAES-CBC-BC");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar27, "PBEWITHSHAAND256BITAES-CBC-BC");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar28, "PBEWITHSHA256AND128BITAES-CBC-BC");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar29, "PBEWITHSHA256AND192BITAES-CBC-BC");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar30, "PBEWITHSHA256AND256BITAES-CBC-BC");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar25.L(), "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar26.L(), "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar27.L(), "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar28.L(), "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar29.L(), "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar30.L(), "PKCS12PBE");
            c(aVar, m5.b.f40641c, str + "$AESGMAC", str + "$KeyGen128");
            d(aVar, m5.b.f40641c, str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class v extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public v() {
            super(new org.bouncycastle.crypto.h(new jp.x(new cp.a(), 128)), 128);
        }
    }

    public static class w extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public w() {
            super(new jp.c(new cp.a()));
        }
    }

    public static class x extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public x() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", null, true, 3, 0, 128, 128);
        }
    }

    public static class y extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public y() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", null, true, 3, 0, 192, 128);
        }
    }

    public static class z extends org.bouncycastle.jcajce.provider.symmetric.util.e {
        public z() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", null, true, 3, 0, 256, 128);
        }
    }

    static {
        HashMap map = new HashMap();
        f59556a = map;
        map.put("SupportedKeyClasses", "javax.crypto.SecretKey");
        map.put("SupportedKeyFormats", "RAW");
    }
}
