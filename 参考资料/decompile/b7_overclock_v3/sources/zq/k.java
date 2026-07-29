package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    public static class a extends d {
        public a() {
            super(128);
        }
    }

    public static class a0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public a0() {
            super(new jp.t(new cp.v(512)));
        }
    }

    public static class b extends d {
        public b() {
            super(256);
        }
    }

    public static class b0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public b0() {
            super(new ip.m(new jp.t(new cp.v(128)), 128));
        }
    }

    public static class c extends d {
        public c() {
            super(512);
        }
    }

    public static class c0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c0() {
            super(new ip.m(new jp.t(new cp.v(256)), 256));
        }
    }

    public static class d extends ar.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f59597d;

        public d(int i10) {
            this.f59597d = i10 / 8;
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[this.f59597d];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("DSTU7624");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSTU7624 parameter generation.");
        }
    }

    public static class d0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d0() {
            super(new ip.m(new jp.t(new cp.v(512)), 512));
        }
    }

    public static class e extends ar.h {
        @Override // ar.h, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "DSTU7624 IV";
        }
    }

    public static class e0 extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e0() {
            super(new ip.m(new jp.t(new cp.v(128)), 128));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f() {
            super(new jp.c(new cp.v(128)), 128);
        }
    }

    public static class f0 extends i0 {
        public f0() {
            super(128);
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public g() {
            super(new jp.c(new cp.v(256)), 256);
        }
    }

    public static class g0 extends i0 {
        public g0() {
            super(256);
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public h() {
            super(new jp.c(new cp.v(512)), 512);
        }
    }

    public static class h0 extends i0 {
        public h0() {
            super(512);
        }
    }

    public static class i extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public i() {
            super(new jp.r(new cp.v(128)));
        }
    }

    public static class i0 extends ar.c {
        public i0() {
            this(256);
        }

        public i0(int i10) {
            super("DSTU7624", i10, new org.bouncycastle.crypto.j());
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public j() {
            super(new jp.r(new cp.v(256)));
        }
    }

    public static class j0 extends zq.l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59598a = k.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59598a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.DSTU7624", sb2.toString());
            gm.y yVar = vn.g.f53288v;
            aVar.k("AlgorithmParameters", yVar, str + "$AlgParams");
            gm.y yVar2 = vn.g.f53289w;
            aVar.k("AlgorithmParameters", yVar2, str + "$AlgParams");
            gm.y yVar3 = vn.g.f53290x;
            aVar.k("AlgorithmParameters", yVar3, str + "$AlgParams");
            aVar.h("AlgorithmParameterGenerator.DSTU7624", str + "$AlgParamGen128");
            aVar.k("AlgorithmParameterGenerator", yVar, str + "$AlgParamGen128");
            aVar.k("AlgorithmParameterGenerator", yVar2, str + "$AlgParamGen256");
            aVar.k("AlgorithmParameterGenerator", yVar3, str + "$AlgParamGen512");
            aVar.h("Cipher.DSTU7624", str + "$ECB_128");
            aVar.h("Cipher.DSTU7624-128", str + "$ECB_128");
            aVar.h("Cipher.DSTU7624-256", str + "$ECB_256");
            aVar.h("Cipher.DSTU7624-512", str + "$ECB_512");
            gm.y yVar4 = vn.g.f53276j;
            aVar.k("Cipher", yVar4, str + "$ECB128");
            gm.y yVar5 = vn.g.f53277k;
            aVar.k("Cipher", yVar5, str + "$ECB256");
            gm.y yVar6 = vn.g.f53278l;
            aVar.k("Cipher", yVar6, str + "$ECB512");
            aVar.k("Cipher", yVar, str + "$CBC128");
            aVar.k("Cipher", yVar2, str + "$CBC256");
            aVar.k("Cipher", yVar3, str + "$CBC512");
            gm.y yVar7 = vn.g.f53291y;
            aVar.k("Cipher", yVar7, str + "$OFB128");
            gm.y yVar8 = vn.g.f53292z;
            aVar.k("Cipher", yVar8, str + "$OFB256");
            gm.y yVar9 = vn.g.A;
            aVar.k("Cipher", yVar9, str + "$OFB512");
            gm.y yVar10 = vn.g.f53282p;
            aVar.k("Cipher", yVar10, str + "$CFB128");
            gm.y yVar11 = vn.g.f53283q;
            aVar.k("Cipher", yVar11, str + "$CFB256");
            gm.y yVar12 = vn.g.f53284r;
            aVar.k("Cipher", yVar12, str + "$CFB512");
            gm.y yVar13 = vn.g.f53279m;
            aVar.k("Cipher", yVar13, str + "$CTR128");
            gm.y yVar14 = vn.g.f53280n;
            aVar.k("Cipher", yVar14, str + "$CTR256");
            gm.y yVar15 = vn.g.f53281o;
            aVar.k("Cipher", yVar15, str + "$CTR512");
            gm.y yVar16 = vn.g.E;
            aVar.k("Cipher", yVar16, str + "$CCM128");
            gm.y yVar17 = vn.g.F;
            aVar.k("Cipher", yVar17, str + "$CCM256");
            gm.y yVar18 = vn.g.G;
            aVar.k("Cipher", yVar18, str + "$CCM512");
            aVar.h("Cipher.DSTU7624KW", str + "$Wrap");
            aVar.h("Alg.Alias.Cipher.DSTU7624WRAP", "DSTU7624KW");
            aVar.h("Cipher.DSTU7624-128KW", str + "$Wrap128");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.Cipher.");
            gm.y yVar19 = vn.g.K;
            sb3.append(yVar19.L());
            aVar.h(sb3.toString(), "DSTU7624-128KW");
            aVar.h("Alg.Alias.Cipher.DSTU7624-128WRAP", "DSTU7624-128KW");
            aVar.h("Cipher.DSTU7624-256KW", str + "$Wrap256");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Alg.Alias.Cipher.");
            gm.y yVar20 = vn.g.L;
            sb4.append(yVar20.L());
            aVar.h(sb4.toString(), "DSTU7624-256KW");
            aVar.h("Alg.Alias.Cipher.DSTU7624-256WRAP", "DSTU7624-256KW");
            aVar.h("Cipher.DSTU7624-512KW", str + "$Wrap512");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Alg.Alias.Cipher.");
            gm.y yVar21 = vn.g.M;
            sb5.append(yVar21.L());
            aVar.h(sb5.toString(), "DSTU7624-512KW");
            aVar.h("Alg.Alias.Cipher.DSTU7624-512WRAP", "DSTU7624-512KW");
            aVar.h("Mac.DSTU7624GMAC", str + "$GMAC");
            aVar.h("Mac.DSTU7624-128GMAC", str + "$GMAC128");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Alg.Alias.Mac.");
            gm.y yVar22 = vn.g.B;
            sb6.append(yVar22.L());
            aVar.h(sb6.toString(), "DSTU7624-128GMAC");
            aVar.h("Mac.DSTU7624-256GMAC", str + "$GMAC256");
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Alg.Alias.Mac.");
            gm.y yVar23 = vn.g.C;
            sb7.append(yVar23.L());
            aVar.h(sb7.toString(), "DSTU7624-256GMAC");
            aVar.h("Mac.DSTU7624-512GMAC", str + "$GMAC512");
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Alg.Alias.Mac.");
            gm.y yVar24 = vn.g.D;
            sb8.append(yVar24.L());
            aVar.h(sb8.toString(), "DSTU7624-512GMAC");
            aVar.h("KeyGenerator.DSTU7624", str + "$KeyGen");
            aVar.k("KeyGenerator", yVar19, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar20, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar21, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar4, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar5, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar6, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar2, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar3, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar7, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar8, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar9, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar10, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar11, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar12, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar13, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar14, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar15, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar16, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar17, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar18, str + "$KeyGen512");
            aVar.k("KeyGenerator", yVar22, str + "$KeyGen128");
            aVar.k("KeyGenerator", yVar23, str + "$KeyGen256");
            aVar.k("KeyGenerator", yVar24, str + "$KeyGen512");
        }
    }

    /* JADX INFO: renamed from: zq.k$k, reason: collision with other inner class name */
    public static class C0701k extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public C0701k() {
            super(new jp.r(new cp.v(512)));
        }
    }

    public static class k0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public k0() {
            super(new org.bouncycastle.crypto.h(new jp.x(new cp.v(128), 128)), 128);
        }
    }

    public static class l extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public l() {
            super(new org.bouncycastle.crypto.h(new jp.e(new cp.v(128), 128)), 128);
        }
    }

    public static class l0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public l0() {
            super(new org.bouncycastle.crypto.h(new jp.x(new cp.v(256), 256)), 256);
        }
    }

    public static class m extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public m() {
            super(new org.bouncycastle.crypto.h(new jp.e(new cp.v(256), 256)), 256);
        }
    }

    public static class m0 extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public m0() {
            super(new org.bouncycastle.crypto.h(new jp.x(new cp.v(512), 512)), 512);
        }
    }

    public static class n extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public n() {
            super(new org.bouncycastle.crypto.h(new jp.e(new cp.v(512), 512)), 512);
        }
    }

    public static class n0 extends BaseWrapCipher {
        public n0() {
            super(new cp.w(128));
        }
    }

    public static class o extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public o() {
            super(new org.bouncycastle.crypto.h(new jp.s(new cp.v(128))), 128);
        }
    }

    public static class o0 extends BaseWrapCipher {
        public o0() {
            super(new cp.w(256));
        }
    }

    public static class p extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public p() {
            super(new org.bouncycastle.crypto.h(new jp.s(new cp.v(256))), 256);
        }
    }

    public static class p0 extends BaseWrapCipher {
        public p0() {
            super(new cp.w(512));
        }
    }

    public static class q extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public q() {
            super(new org.bouncycastle.crypto.h(new jp.s(new cp.v(512))), 512);
        }
    }

    public static class q0 extends BaseWrapCipher {
        public q0() {
            super(new cp.w(128));
        }
    }

    public static class r extends org.bouncycastle.jcajce.provider.symmetric.util.a {

        public class a implements ar.e {
            @Override // ar.e
            public org.bouncycastle.crypto.f get() {
                return new cp.v(128);
            }
        }

        public r() {
            super(new a());
        }
    }

    public static class s extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public s() {
            super(new cp.v(128));
        }
    }

    public static class t extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public t() {
            super(new cp.v(256));
        }
    }

    public static class u extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public u() {
            super(new cp.v(512));
        }
    }

    public static class v extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public v() {
            super(new cp.v(128));
        }
    }

    public static class w extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public w() {
            super(new cp.v(256));
        }
    }

    public static class x extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public x() {
            super(new cp.v(512));
        }
    }

    public static class y extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public y() {
            super(new jp.t(new cp.v(128)));
        }
    }

    public static class z extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public z() {
            super(new jp.t(new cp.v(256)));
        }
    }
}
