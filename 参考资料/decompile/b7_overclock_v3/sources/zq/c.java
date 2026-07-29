package zq;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("ARIA");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for ARIA parameter generation.");
        }
    }

    public static class b extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "ARIA IV";
        }
    }

    /* JADX INFO: renamed from: zq.c$c, reason: collision with other inner class name */
    public static class C0693c extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public cq.a f59568a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || ar.g.f(cls)) {
                return ar.g.e() ? ar.g.c(this.f59568a.b()) : new cr.a(this.f59568a.z(), this.f59568a.x() * 8);
            }
            if (cls == cr.a.class) {
                return new cr.a(this.f59568a.z(), this.f59568a.x() * 8);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59568a.z());
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.f59568a.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return this.f59568a.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (ar.g.g(algorithmParameterSpec)) {
                this.f59568a = cq.a.y(ar.g.b(algorithmParameterSpec));
                return;
            }
            if (algorithmParameterSpec instanceof cr.a) {
                cr.a aVar = (cr.a) algorithmParameterSpec;
                this.f59568a = new cq.a(aVar.c(), aVar.b() / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59568a = cq.a.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("unknown format specified");
            }
            this.f59568a = cq.a.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "CCM";
        }
    }

    public static class d extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public cq.c f59569a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || ar.g.f(cls)) {
                return ar.g.e() ? ar.g.c(this.f59569a.b()) : new cr.a(this.f59569a.z(), this.f59569a.x() * 8);
            }
            if (cls == cr.a.class) {
                return new cr.a(this.f59569a.z(), this.f59569a.x() * 8);
            }
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59569a.z());
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.f59569a.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return this.f59569a.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (ar.g.g(algorithmParameterSpec)) {
                this.f59569a = ar.g.b(algorithmParameterSpec);
                return;
            }
            if (algorithmParameterSpec instanceof cr.a) {
                cr.a aVar = (cr.a) algorithmParameterSpec;
                this.f59569a = new cq.c(aVar.c(), aVar.b() / 8);
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59569a = cq.c.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("unknown format specified");
            }
            this.f59569a = cq.c.y(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "GCM";
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public e() {
            super(new jp.c(new cp.f()), 128);
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f() {
            super((jp.a) new jp.d(new cp.f()), false, 12);
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public g() {
            super(new org.bouncycastle.crypto.h(new jp.e(new cp.f(), 128)), 128);
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.f();
            }
        }

        public h() {
            super(new a());
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public i() {
            super(new jp.n(new cp.f()));
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.i(new jp.n(new cp.f())));
        }
    }

    public static class k extends ar.d {
        public k() {
            super("ARIA", null);
        }
    }

    public static class l extends o {
        public l() {
            super(128);
        }
    }

    public static class m extends o {
        public m() {
            super(192);
        }
    }

    public static class n extends o {
        public n() {
            super(256);
        }
    }

    public static class o extends ar.c {
        public o() {
            this(256);
        }

        public o(int i10) {
            super("ARIA", i10, new org.bouncycastle.crypto.j());
        }
    }

    public static class p extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59570a = c.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59570a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.ARIA", sb2.toString());
            gm.y yVar = ln.a.f40038h;
            aVar.k("Alg.Alias.AlgorithmParameters", yVar, "ARIA");
            gm.y yVar2 = ln.a.f40043m;
            aVar.k("Alg.Alias.AlgorithmParameters", yVar2, "ARIA");
            gm.y yVar3 = ln.a.f40048r;
            aVar.k("Alg.Alias.AlgorithmParameters", yVar3, "ARIA");
            aVar.h("AlgorithmParameterGenerator.ARIA", str + "$AlgParamGen");
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar, "ARIA");
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar2, "ARIA");
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar3, "ARIA");
            gm.y yVar4 = ln.a.f40040j;
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar4, "ARIA");
            gm.y yVar5 = ln.a.f40045o;
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar5, "ARIA");
            gm.y yVar6 = ln.a.f40050t;
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar6, "ARIA");
            gm.y yVar7 = ln.a.f40039i;
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar7, "ARIA");
            gm.y yVar8 = ln.a.f40044n;
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar8, "ARIA");
            gm.y yVar9 = ln.a.f40049s;
            aVar.k("Alg.Alias.AlgorithmParameterGenerator", yVar9, "ARIA");
            aVar.h("Cipher.ARIA", str + "$ECB");
            gm.y yVar10 = ln.a.f40037g;
            aVar.k("Cipher", yVar10, str + "$ECB");
            gm.y yVar11 = ln.a.f40042l;
            aVar.k("Cipher", yVar11, str + "$ECB");
            gm.y yVar12 = ln.a.f40047q;
            aVar.k("Cipher", yVar12, str + "$ECB");
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.k("Cipher", yVar2, str + "$CBC");
            aVar.k("Cipher", yVar3, str + "$CBC");
            aVar.k("Cipher", yVar7, str + "$CFB");
            aVar.k("Cipher", yVar8, str + "$CFB");
            aVar.k("Cipher", yVar9, str + "$CFB");
            aVar.k("Cipher", yVar4, str + "$OFB");
            aVar.k("Cipher", yVar5, str + "$OFB");
            aVar.k("Cipher", yVar6, str + "$OFB");
            aVar.h("Cipher.ARIARFC3211WRAP", str + "$RFC3211Wrap");
            aVar.h("Cipher.ARIAWRAP", str + "$Wrap");
            gm.y yVar13 = ln.a.H;
            aVar.k("Alg.Alias.Cipher", yVar13, "ARIAWRAP");
            gm.y yVar14 = ln.a.I;
            aVar.k("Alg.Alias.Cipher", yVar14, "ARIAWRAP");
            gm.y yVar15 = ln.a.J;
            aVar.k("Alg.Alias.Cipher", yVar15, "ARIAWRAP");
            aVar.h("Alg.Alias.Cipher.ARIAKW", "ARIAWRAP");
            aVar.h("Cipher.ARIAWRAPPAD", str + "$WrapPad");
            gm.y yVar16 = ln.a.K;
            aVar.k("Alg.Alias.Cipher", yVar16, "ARIAWRAPPAD");
            gm.y yVar17 = ln.a.L;
            aVar.k("Alg.Alias.Cipher", yVar17, "ARIAWRAPPAD");
            gm.y yVar18 = ln.a.M;
            aVar.k("Alg.Alias.Cipher", yVar18, "ARIAWRAPPAD");
            aVar.h("Alg.Alias.Cipher.ARIAKWP", "ARIAWRAPPAD");
            aVar.h("KeyGenerator.ARIA", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar13, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar14, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar15, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar16, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar17, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar18, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar10, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar11, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar12, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar2, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar3, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar7, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar8, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar9, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar4, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar5, str + "$KeyGen192");
            aVar.k("KeyGenerator", yVar6, str + "$KeyGen256");
            gm.y yVar19 = ln.a.E;
            aVar.k("KeyGenerator", yVar19, str + "$KeyGen128");
            gm.y yVar20 = ln.a.F;
            aVar.k("KeyGenerator", yVar20, str + "$KeyGen192");
            gm.y yVar21 = ln.a.G;
            aVar.k("KeyGenerator", yVar21, str + "$KeyGen256");
            gm.y yVar22 = ln.a.B;
            aVar.k("KeyGenerator", yVar22, str + "$KeyGen128");
            gm.y yVar23 = ln.a.C;
            aVar.k("KeyGenerator", yVar23, str + "$KeyGen192");
            gm.y yVar24 = ln.a.D;
            aVar.k("KeyGenerator", yVar24, str + "$KeyGen256");
            aVar.h("SecretKeyFactory.ARIA", str + "$KeyFactory");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar, "ARIA");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar2, "ARIA");
            aVar.k("Alg.Alias.SecretKeyFactory", yVar3, "ARIA");
            aVar.h("AlgorithmParameterGenerator.ARIACCM", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar19, "ARIACCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar20, "ARIACCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar21, "ARIACCM");
            aVar.h("Cipher.ARIACCM", str + "$CCM");
            aVar.k("Alg.Alias.Cipher", yVar19, "CCM");
            aVar.k("Alg.Alias.Cipher", yVar20, "CCM");
            aVar.k("Alg.Alias.Cipher", yVar21, "CCM");
            aVar.h("AlgorithmParameterGenerator.ARIAGCM", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar22, "ARIAGCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar23, "ARIAGCM");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar24, "ARIAGCM");
            aVar.h("Cipher.ARIAGCM", str + "$GCM");
            aVar.k("Alg.Alias.Cipher", yVar22, "ARIAGCM");
            aVar.k("Alg.Alias.Cipher", yVar23, "ARIAGCM");
            aVar.k("Alg.Alias.Cipher", yVar24, "ARIAGCM");
            c(aVar, "ARIA", str + "$GMAC", str + "$KeyGen");
            d(aVar, "ARIA", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class q extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public q() {
            super(new org.bouncycastle.crypto.h(new jp.x(new cp.f(), 128)), 128);
        }
    }

    public static class r extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public r() {
            super(new ip.q(new cp.f()));
        }
    }

    public static class s extends ar.c {
        public s() {
            super("Poly1305-ARIA", 256, new fp.k0());
        }
    }

    public static class t extends BaseWrapCipher {
        public t() {
            super(new cp.u0(new cp.f()), 16);
        }
    }

    public static class u extends BaseWrapCipher {
        public u() {
            super(new cp.g());
        }
    }

    public static class v extends BaseWrapCipher {
        public v() {
            super(new cp.h());
        }
    }
}
