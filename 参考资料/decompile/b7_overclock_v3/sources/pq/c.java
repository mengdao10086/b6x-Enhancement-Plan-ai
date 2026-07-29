package pq;

import cr.h;
import cr.x;
import fp.o0;
import fp.p0;
import fp.q;
import fp.r;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import np.l2;
import np.n0;
import np.o2;
import np.q0;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCEdDSAPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCEdDSAPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCXDHPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCXDHPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;

/* JADX INFO: loaded from: classes7.dex */
public class c extends KeyPairGeneratorSpi {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f46998e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f46999f = -2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f47000g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f47001h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f47002i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47003j = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f47006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.d f47007d;

    public static final class a extends c {
        public a() {
            super(1);
        }
    }

    public static final class b extends c {
        public b() {
            super(2);
        }
    }

    /* JADX INFO: renamed from: pq.c$c, reason: collision with other inner class name */
    public static final class C0536c extends c {
        public C0536c() {
            super(-1);
        }
    }

    public static final class d extends c {
        public d() {
            super(3);
        }
    }

    public static final class e extends c {
        public e() {
            super(4);
        }
    }

    public static final class f extends c {
        public f() {
            super(-2);
        }
    }

    public c(int i10) {
        this.f47004a = i10;
        if (a(i10) != i10) {
            this.f47005b = i10;
        }
    }

    public static int a(int i10) {
        if (i10 == 1 || i10 == 2) {
            return -1;
        }
        if (i10 == 3 || i10 == 4) {
            return -2;
        }
        return i10;
    }

    public static int b(String str) throws InvalidAlgorithmParameterException {
        if (str.equalsIgnoreCase(x.f25873b) || str.equals(tm.a.f51338b.L())) {
            return 3;
        }
        if (str.equalsIgnoreCase(h.f25815b) || str.equals(tm.a.f51340d.L())) {
            return 1;
        }
        if (str.equalsIgnoreCase(x.f25874c) || str.equals(tm.a.f51339c.L())) {
            return 4;
        }
        if (str.equalsIgnoreCase(h.f25816c) || str.equals(tm.a.f51341e.L())) {
            return 2;
        }
        throw new InvalidAlgorithmParameterException("invalid parameterSpec name: " + str);
    }

    public static String d(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        return algorithmParameterSpec instanceof ECGenParameterSpec ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : algorithmParameterSpec instanceof gr.b ? ((gr.b) algorithmParameterSpec).a() : algorithmParameterSpec instanceof h ? ((h) algorithmParameterSpec).a() : algorithmParameterSpec instanceof x ? ((x) algorithmParameterSpec).a() : i.h(algorithmParameterSpec);
    }

    public final int c(int i10) {
        if (i10 == 255 || i10 == 256) {
            int i11 = this.f47004a;
            if (i11 != -2) {
                if (i11 == -1 || i11 == 1) {
                    return 1;
                }
                if (i11 != 3) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            return 3;
        }
        if (i10 != 448) {
            throw new InvalidParameterException("unknown key size");
        }
        int i12 = this.f47004a;
        if (i12 != -2) {
            if (i12 == -1 || i12 == 2) {
                return 2;
            }
            if (i12 != 4) {
                throw new InvalidParameterException("key size not configurable");
            }
        }
        return 4;
    }

    public final org.bouncycastle.crypto.d e() {
        if (this.f47006c == null) {
            this.f47006c = n.f();
        }
        int i10 = this.f47005b;
        if (i10 == 1) {
            q qVar = new q();
            qVar.a(new n0(this.f47006c));
            return qVar;
        }
        if (i10 == 2) {
            r rVar = new r();
            rVar.a(new q0(this.f47006c));
            return rVar;
        }
        if (i10 == 3) {
            o0 o0Var = new o0();
            o0Var.a(new l2(this.f47006c));
            return o0Var;
        }
        if (i10 != 4) {
            throw new IllegalStateException("generator not correctly initialized");
        }
        p0 p0Var = new p0();
        p0Var.a(new o2(this.f47006c));
        return p0Var;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.f47005b == 0) {
            throw new IllegalStateException("generator not correctly initialized");
        }
        if (this.f47007d == null) {
            this.f47007d = e();
        }
        org.bouncycastle.crypto.c cVarB = this.f47007d.b();
        int i10 = this.f47005b;
        if (i10 == 1 || i10 == 2) {
            return new KeyPair(new BCEdDSAPublicKey(cVarB.b()), new BCEdDSAPrivateKey(cVarB.a()));
        }
        if (i10 == 3 || i10 == 4) {
            return new KeyPair(new BCXDHPublicKey(cVarB.b()), new BCXDHPrivateKey(cVarB.a()));
        }
        throw new IllegalStateException("generator not correctly initialized");
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f47005b = c(i10);
        this.f47006c = secureRandom;
        this.f47007d = null;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String strD = d(algorithmParameterSpec);
        if (strD == null) {
            throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
        }
        int iB = b(strD);
        int i10 = this.f47004a;
        if (i10 != iB && i10 != a(iB)) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        }
        this.f47005b = iB;
        this.f47006c = secureRandom;
        this.f47007d = null;
    }
}
