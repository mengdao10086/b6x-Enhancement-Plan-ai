package zq;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<gm.y, String> f59600a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, gm.y> f59601b = new HashMap();

    public static class a extends ar.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f59602d = new byte[8];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f59603e = cp.z.j("E-A");

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(this.f59602d);
            try {
                AlgorithmParameters algorithmParametersA = a("GOST28147");
                algorithmParametersA.init(new cr.j(this.f59603e, this.f59602d));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (!(algorithmParameterSpec instanceof cr.j)) {
                throw new InvalidAlgorithmParameterException("parameter spec not supported");
            }
            this.f59603e = ((cr.j) algorithmParameterSpec).c();
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gm.y f59604c = qm.a.f47458h;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f59605d;

        @Override // zq.l.c, ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59605d);
            }
            if (cls == cr.j.class || cls == AlgorithmParameterSpec.class) {
                return new cr.j(this.f59604c, this.f59605d);
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        @Override // zq.l.c
        public byte[] e() throws IOException {
            return new qm.d(this.f59605d, this.f59604c).getEncoded();
        }

        @Override // zq.l.c, java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f59605d = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else {
                if (!(algorithmParameterSpec instanceof cr.j)) {
                    throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
                }
                this.f59605d = ((cr.j) algorithmParameterSpec).a();
                try {
                    this.f59604c = c.d(((cr.j) algorithmParameterSpec).c());
                } catch (IllegalArgumentException e10) {
                    throw new InvalidParameterSpecException(e10.getMessage());
                }
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "GOST 28147 IV Parameters";
        }

        @Override // zq.l.c
        public void f(byte[] bArr) throws IOException {
            gm.c0 c0VarD = gm.c0.D(bArr);
            if (c0VarD instanceof gm.z) {
                this.f59605d = gm.z.I(c0VarD).J();
            } else {
                if (!(c0VarD instanceof gm.f0)) {
                    throw new IOException("Unable to recognize parameters");
                }
                qm.d dVarA = qm.d.A(c0VarD);
                this.f59604c = dVarA.x();
                this.f59605d = dVarA.y();
            }
        }
    }

    public static abstract class c extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.y f59606a = qm.a.f47458h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f59607b;

        public static gm.y c(String str) {
            gm.y yVar = str != null ? (gm.y) l.f59601b.get(Strings.o(str)) : null;
            if (yVar != null) {
                return yVar;
            }
            throw new IllegalArgumentException("Unknown SBOX name: " + str);
        }

        public static gm.y d(byte[] bArr) {
            return c(cp.z.k(bArr));
        }

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f59607b);
            }
            if (cls == cr.j.class || cls == AlgorithmParameterSpec.class) {
                return new cr.j(this.f59606a, this.f59607b);
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: " + cls.getName());
        }

        public byte[] e() throws IOException {
            return new qm.d(this.f59607b, this.f59606a).getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public final byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        @Override // java.security.AlgorithmParametersSpi
        public final byte[] engineGetEncoded(String str) throws IOException {
            if (a(str)) {
                return e();
            }
            throw new IOException("Unknown parameter format: " + str);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f59607b = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else {
                if (!(algorithmParameterSpec instanceof cr.j)) {
                    throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
                }
                this.f59607b = ((cr.j) algorithmParameterSpec).a();
                try {
                    this.f59606a = d(((cr.j) algorithmParameterSpec).c());
                } catch (IllegalArgumentException e10) {
                    throw new InvalidParameterSpecException(e10.getMessage());
                }
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public final void engineInit(byte[] bArr) throws IOException {
            engineInit(bArr, "ASN.1");
        }

        @Override // java.security.AlgorithmParametersSpi
        public final void engineInit(byte[] bArr, String str) throws IOException {
            Objects.requireNonNull(bArr, "Encoded parameters cannot be null");
            if (!a(str)) {
                throw new IOException("Unknown parameter format: " + str);
            }
            try {
                f(bArr);
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new IOException("Parameter parsing failed: " + e11.getMessage());
            }
        }

        public abstract void f(byte[] bArr) throws IOException;
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public d() {
            super(new jp.c(new cp.z()), 64);
        }
    }

    public static class e extends BaseWrapCipher {
        public e() {
            super(new cp.r());
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public f() {
            super(new cp.z());
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public g() {
            super(new org.bouncycastle.crypto.h(new jp.m(new cp.z())), 64);
        }
    }

    public static class h extends BaseWrapCipher {
        public h() {
            super(new cp.a0());
        }
    }

    public static class i extends ar.c {
        public i() {
            this(256);
        }

        public i(int i10) {
            super("GOST28147", i10, new org.bouncycastle.crypto.j());
        }
    }

    public static class j extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public j() {
            super(new ip.j());
        }
    }

    public static class k extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59608a = l.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59608a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.GOST28147", sb2.toString());
            aVar.h("Alg.Alias.Cipher.GOST", "GOST28147");
            aVar.h("Alg.Alias.Cipher.GOST-28147", "GOST28147");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cipher.");
            gm.y yVar = qm.a.f47456f;
            sb3.append(yVar);
            aVar.h(sb3.toString(), str + "$GCFB");
            aVar.h("KeyGenerator.GOST28147", str + "$KeyGen");
            aVar.h("Alg.Alias.KeyGenerator.GOST", "GOST28147");
            aVar.h("Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
            aVar.h("Alg.Alias.KeyGenerator." + yVar, "GOST28147");
            aVar.h("AlgorithmParameters.GOST28147", str + "$AlgParams");
            aVar.h("AlgorithmParameterGenerator.GOST28147", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar, "GOST28147");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar, "GOST28147");
            aVar.h("Cipher." + qm.a.f47455e, str + "$CryptoProWrap");
            aVar.h("Cipher." + qm.a.f47454d, str + "$GostWrap");
            aVar.h("Mac.GOST28147MAC", str + "$Mac");
            aVar.h("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
        }
    }

    static {
        f59600a.put(qm.a.f47457g, "E-TEST");
        Map<gm.y, String> map = f59600a;
        gm.y yVar = qm.a.f47458h;
        map.put(yVar, "E-A");
        Map<gm.y, String> map2 = f59600a;
        gm.y yVar2 = qm.a.f47459i;
        map2.put(yVar2, "E-B");
        Map<gm.y, String> map3 = f59600a;
        gm.y yVar3 = qm.a.f47460j;
        map3.put(yVar3, "E-C");
        Map<gm.y, String> map4 = f59600a;
        gm.y yVar4 = qm.a.f47461k;
        map4.put(yVar4, "E-D");
        Map<gm.y, String> map5 = f59600a;
        gm.y yVar5 = qn.a.f47530t;
        map5.put(yVar5, "PARAM-Z");
        f59601b.put("E-A", yVar);
        f59601b.put("E-B", yVar2);
        f59601b.put("E-C", yVar3);
        f59601b.put("E-D", yVar4);
        f59601b.put("PARAM-Z", yVar5);
    }
}
