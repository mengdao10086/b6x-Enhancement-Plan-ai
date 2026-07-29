package pq;

import cr.o;
import cr.p;
import cr.r;
import cr.x;
import gm.c0;
import gm.f0;
import gm.j;
import gm.y;
import gm.z;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import jt.h;
import np.n2;
import np.o0;
import np.p0;
import np.q2;
import np.s0;
import org.bouncycastle.crypto.util.g;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCEdDSAPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCEdDSAPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCXDHPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCXDHPublicKey;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class b extends org.bouncycastle.jcajce.provider.asymmetric.util.c implements br.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f46987d = h.b("3042300506032b656f033900");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f46988e = h.b("302a300506032b656e032100");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f46989f = h.b("3043300506032b6571033a00");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f46990g = h.b("302a300506032b6570032100");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f46991h = 111;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f46992i = 110;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f46993j = 113;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f46994k = 112;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f46995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f46996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46997c;

    public static class a extends b {
        public a() {
            super(cr.h.f25815b, false, 112);
        }
    }

    /* JADX INFO: renamed from: pq.b$b, reason: collision with other inner class name */
    public static class C0535b extends b {
        public C0535b() {
            super(cr.h.f25816c, false, 113);
        }
    }

    public static class c extends b {
        public c() {
            super("EdDSA", false, 0);
        }
    }

    public static class d extends b {
        public d() {
            super(x.f25873b, true, 110);
        }
    }

    public static class e extends b {
        public e() {
            super(x.f25874c, true, 111);
        }
    }

    public static class f extends b {
        public f() {
            super("XDH", true, 0);
        }
    }

    public b(String str, boolean z10, int i10) {
        this.f46995a = str;
        this.f46996b = z10;
        this.f46997c = i10;
    }

    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (this.f46996b) {
            int i10 = this.f46997c;
            if ((i10 == 0 || i10 == 111) && yVarX.C(tm.a.f51339c)) {
                return new BCXDHPublicKey(c1Var);
            }
            int i11 = this.f46997c;
            if ((i11 == 0 || i11 == 110) && yVarX.C(tm.a.f51338b)) {
                return new BCXDHPublicKey(c1Var);
            }
        } else {
            y yVar = tm.a.f51341e;
            if (yVarX.C(yVar) || yVarX.C(tm.a.f51340d)) {
                int i12 = this.f46997c;
                if ((i12 == 0 || i12 == 113) && yVarX.C(yVar)) {
                    return new BCEdDSAPublicKey(c1Var);
                }
                int i13 = this.f46997c;
                if ((i13 == 0 || i13 == 112) && yVarX.C(tm.a.f51340d)) {
                    return new BCEdDSAPublicKey(c1Var);
                }
            }
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognized");
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (this.f46996b) {
            int i10 = this.f46997c;
            if ((i10 == 0 || i10 == 111) && yVarX.C(tm.a.f51339c)) {
                return new BCXDHPrivateKey(uVar);
            }
            int i11 = this.f46997c;
            if ((i11 == 0 || i11 == 110) && yVarX.C(tm.a.f51338b)) {
                return new BCXDHPrivateKey(uVar);
            }
        } else {
            y yVar = tm.a.f51341e;
            if (yVarX.C(yVar) || yVarX.C(tm.a.f51340d)) {
                int i12 = this.f46997c;
                if ((i12 == 0 || i12 == 113) && yVarX.C(yVar)) {
                    return new BCEdDSAPrivateKey(uVar);
                }
                int i13 = this.f46997c;
                if ((i13 == 0 || i13 == 112) && yVarX.C(tm.a.f51340d)) {
                    return new BCEdDSAPrivateKey(uVar);
                }
            }
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognized");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof o)) {
            return super.engineGeneratePrivate(keySpec);
        }
        np.c cVarC = g.c(((o) keySpec).getEncoded());
        if (cVarC instanceof o0) {
            return new BCEdDSAPrivateKey((o0) cVarC);
        }
        throw new IllegalStateException("openssh private key not Ed25519 private key");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            byte[] encoded = ((X509EncodedKeySpec) keySpec).getEncoded();
            int i10 = this.f46997c;
            if (i10 == 0 || i10 == encoded[8]) {
                if (encoded[9] == 5 && encoded[10] == 0) {
                    c1 c1VarA = c1.A(encoded);
                    try {
                        encoded = new c1(new zn.b(c1VarA.x().x()), c1VarA.C().H()).v(j.f29713a);
                    } catch (IOException e10) {
                        throw new InvalidKeySpecException("attempt to reconstruct key failed: " + e10.getMessage());
                    }
                }
                switch (encoded[8]) {
                    case 110:
                        return new BCXDHPublicKey(f46988e, encoded);
                    case 111:
                        return new BCXDHPublicKey(f46987d, encoded);
                    case 112:
                        return new BCEdDSAPublicKey(f46990g, encoded);
                    case 113:
                        return new BCEdDSAPublicKey(f46989f, encoded);
                    default:
                        return super.engineGeneratePublic(keySpec);
                }
            }
        } else {
            if (keySpec instanceof r) {
                byte[] encoded2 = ((r) keySpec).getEncoded();
                switch (this.f46997c) {
                    case 110:
                        return new BCXDHPublicKey(new n2(encoded2));
                    case 111:
                        return new BCXDHPublicKey(new q2(encoded2));
                    case 112:
                        return new BCEdDSAPublicKey(new p0(encoded2));
                    case 113:
                        return new BCEdDSAPublicKey(new s0(encoded2));
                    default:
                        throw new InvalidKeySpecException("factory not a specific type, cannot recognise raw encoding");
                }
            }
            if (keySpec instanceof p) {
                np.c cVarC = org.bouncycastle.crypto.util.h.c(((p) keySpec).getEncoded());
                if (cVarC instanceof p0) {
                    return new BCEdDSAPublicKey(new byte[0], ((p0) cVarC).getEncoded());
                }
                throw new IllegalStateException("openssh public key not Ed25519 public key");
            }
        }
        return super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(o.class) && (key instanceof BCEdDSAPrivateKey)) {
            try {
                return new o(g.b(new o0(z.I(c0.D(z.I(f0.J(key.getEncoded()).K(2)).J())).J())));
            } catch (IOException e10) {
                throw new InvalidKeySpecException(e10.getMessage(), e10.getCause());
            }
        }
        if (!cls.isAssignableFrom(p.class) || !(key instanceof BCEdDSAPublicKey)) {
            if (cls.isAssignableFrom(r.class)) {
                if (key instanceof XDHPublicKey) {
                    return new r(((XDHPublicKey) key).z0());
                }
                if (key instanceof EdDSAPublicKey) {
                    return new r(((EdDSAPublicKey) key).c0());
                }
            }
            return super.engineGetKeySpec(key, cls);
        }
        try {
            byte[] encoded = key.getEncoded();
            byte[] bArr = f46990g;
            if (org.bouncycastle.util.a.f(bArr, 0, bArr.length, encoded, 0, encoded.length - 32)) {
                return new p(org.bouncycastle.crypto.util.h.a(new p0(encoded, bArr.length)));
            }
            throw new InvalidKeySpecException("Invalid Ed25519 public key encoding");
        } catch (IOException e11) {
            throw new InvalidKeySpecException(e11.getMessage(), e11.getCause());
        }
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }
}
