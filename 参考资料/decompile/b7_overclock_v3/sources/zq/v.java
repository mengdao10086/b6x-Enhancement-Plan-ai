package zq;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.jcajce.PBKDF2Key;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.d;

/* JADX INFO: loaded from: classes5.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f59630a;

    public static class a extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pn.q f59631a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new PBEParameterSpec(this.f59631a.B(), this.f59631a.y().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            try {
                return this.f59631a.v(gm.j.f29713a);
            } catch (IOException e10) {
                throw new RuntimeException("Oooops! " + e10.toString());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) {
            if (a(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            this.f59631a = new pn.q(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59631a = pn.q.x(gm.c0.D(bArr));
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("Unknown parameters format in PBKDF2 parameters object");
            }
            engineInit(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PBKDF2 Parameters";
        }
    }

    public static class b extends ar.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f59633d;

        public b(String str, int i10) {
            this(str, i10, 1);
        }

        public b(String str, int i10, int i11) {
            super(str, pn.s.X3);
            this.f59632c = i10;
            this.f59633d = i11;
        }

        public final int a(gm.y yVar) throws InvalidKeySpecException {
            Integer num = (Integer) v.f59630a.get(yVar);
            if (num != null) {
                return num.intValue();
            }
            throw new InvalidKeySpecException("Invalid KeySpec: unknown PRF algorithm " + yVar);
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof PBEKeySpec)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                return new PBKDF2Key(pBEKeySpec.getPassword(), this.f59632c == 1 ? PasswordConverter.ASCII : PasswordConverter.UTF8);
            }
            if (pBEKeySpec.getIterationCount() <= 0) {
                throw new InvalidKeySpecException("positive iteration count required: " + pBEKeySpec.getIterationCount());
            }
            if (pBEKeySpec.getKeyLength() <= 0) {
                throw new InvalidKeySpecException("positive key length required: " + pBEKeySpec.getKeyLength());
            }
            if (pBEKeySpec.getPassword().length == 0) {
                throw new IllegalArgumentException("password empty");
            }
            if (pBEKeySpec instanceof cr.q) {
                int iA = a(((cr.q) pBEKeySpec).a().x());
                int keyLength = pBEKeySpec.getKeyLength();
                return new BCPBEKey(this.f8862a, this.f8863b, this.f59632c, iA, keyLength, -1, pBEKeySpec, d.a.d(pBEKeySpec, this.f59632c, iA, keyLength));
            }
            int i10 = this.f59633d;
            int keyLength2 = pBEKeySpec.getKeyLength();
            return new BCPBEKey(this.f8862a, this.f8863b, this.f59632c, i10, keyLength2, -1, pBEKeySpec, d.a.d(pBEKeySpec, this.f59632c, i10, keyLength2));
        }
    }

    public static class c extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59634a = v.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59634a;
            sb2.append(str);
            sb2.append("$AlgParams");
            aVar.h("AlgorithmParameters.PBKDF2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.AlgorithmParameters.");
            gm.y yVar = pn.s.X3;
            sb3.append(yVar);
            aVar.h(sb3.toString(), "PBKDF2");
            aVar.h("SecretKeyFactory.PBKDF2", str + "$PBKDF2withUTF8");
            aVar.h("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1", "PBKDF2");
            aVar.h("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1ANDUTF8", "PBKDF2");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar, "PBKDF2");
            aVar.h("SecretKeyFactory.PBKDF2WITHASCII", str + "$PBKDF2with8BIT");
            aVar.h("Alg.Alias.SecretKeyFactory.PBKDF2WITH8BIT", "PBKDF2WITHASCII");
            aVar.h("Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1AND8BIT", "PBKDF2WITHASCII");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA224", str + "$PBKDF2withSHA224");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA256", str + "$PBKDF2withSHA256");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA384", str + "$PBKDF2withSHA384");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA512", str + "$PBKDF2withSHA512");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA3-224", str + "$PBKDF2withSHA3_224");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA3-256", str + "$PBKDF2withSHA3_256");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA3-384", str + "$PBKDF2withSHA3_384");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSHA3-512", str + "$PBKDF2withSHA3_512");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACGOST3411", str + "$PBKDF2withGOST3411");
            aVar.h("SecretKeyFactory.PBKDF2WITHHMACSM3", str + "$PBKDF2withSM3");
        }
    }

    public static class d extends b {
        public d() {
            super("PBKDF2", 1);
        }
    }

    public static class e extends b {
        public e() {
            super("PBKDF2", 5, 6);
        }
    }

    public static class f extends b {
        public f() {
            super("PBKDF2", 5, 7);
        }
    }

    public static class g extends b {
        public g() {
            super("PBKDF2", 5, 4);
        }
    }

    public static class h extends b {
        public h() {
            super("PBKDF2", 5, 8);
        }
    }

    public static class i extends b {
        public i() {
            super("PBKDF2", 5, 10);
        }
    }

    public static class j extends b {
        public j() {
            super("PBKDF2", 5, 11);
        }
    }

    public static class k extends b {
        public k() {
            super("PBKDF2", 5, 12);
        }
    }

    public static class l extends b {
        public l() {
            super("PBKDF2", 5, 13);
        }
    }

    public static class m extends b {
        public m() {
            super("PBKDF2", 5, 9);
        }
    }

    public static class n extends b {
        public n() {
            super("PBKDF2", 5, 14);
        }
    }

    public static class o extends b {
        public o() {
            super("PBKDF2", 5);
        }
    }

    static {
        HashMap map = new HashMap();
        f59630a = map;
        map.put(qm.a.f47453c, org.bouncycastle.util.j.g(6));
        map.put(pn.s.f46806g4, org.bouncycastle.util.j.g(1));
        map.put(pn.s.f46812i4, org.bouncycastle.util.j.g(4));
        map.put(pn.s.f46809h4, org.bouncycastle.util.j.g(7));
        map.put(pn.s.f46815j4, org.bouncycastle.util.j.g(8));
        map.put(pn.s.f46818k4, org.bouncycastle.util.j.g(9));
        map.put(kn.d.f37616p, org.bouncycastle.util.j.g(11));
        map.put(kn.d.f37615o, org.bouncycastle.util.j.g(10));
        map.put(kn.d.f37617q, org.bouncycastle.util.j.g(12));
        map.put(kn.d.f37618r, org.bouncycastle.util.j.g(13));
        map.put(xm.b.f55618c0, org.bouncycastle.util.j.g(14));
    }
}
