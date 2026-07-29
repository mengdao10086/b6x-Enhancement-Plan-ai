package org.bouncycastle.jcajce.provider.asymmetric.ec;

import co.r;
import cr.o;
import cr.p;
import gm.y;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import np.g0;
import np.m0;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class f extends org.bouncycastle.jcajce.provider.asymmetric.util.c implements br.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f44955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public uq.c f44956b;

    public static class a extends f {
        public a() {
            super("EC", BouncyCastleProvider.f45330c);
        }
    }

    public static class b extends f {
        public b() {
            super("ECDH", BouncyCastleProvider.f45330c);
        }
    }

    public static class c extends f {
        public c() {
            super("ECDHC", BouncyCastleProvider.f45330c);
        }
    }

    public static class d extends f {
        public d() {
            super("ECDSA", BouncyCastleProvider.f45330c);
        }
    }

    public static class e extends f {
        public e() {
            super("ECGOST3410", BouncyCastleProvider.f45330c);
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.f$f, reason: collision with other inner class name */
    public static class C0507f extends f {
        public C0507f() {
            super("ECGOST3410-2012", BouncyCastleProvider.f45330c);
        }
    }

    public static class g extends f {
        public g() {
            super("ECMQV", BouncyCastleProvider.f45330c);
        }
    }

    public f(String str, uq.c cVar) {
        this.f44955a = str;
        this.f44956b = cVar;
    }

    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (yVarX.C(r.f11174l0)) {
            return new BCECPublicKey(this.f44955a, c1Var, this.f44956b);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (yVarX.C(r.f11174l0)) {
            return new BCECPrivateKey(this.f44955a, uVar, this.f44956b);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof gr.f) {
            return new BCECPrivateKey(this.f44955a, (gr.f) keySpec, this.f44956b);
        }
        if (keySpec instanceof ECPrivateKeySpec) {
            return new BCECPrivateKey(this.f44955a, (ECPrivateKeySpec) keySpec, this.f44956b);
        }
        if (!(keySpec instanceof o)) {
            return super.engineGeneratePrivate(keySpec);
        }
        rn.a aVarX = rn.a.x(((o) keySpec).getEncoded());
        try {
            return new BCECPrivateKey(this.f44955a, new u(new zn.b(r.f11174l0, aVarX.B()), aVarX), this.f44956b);
        } catch (IOException e10) {
            throw new InvalidKeySpecException("bad encoding: " + e10.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        try {
            if (keySpec instanceof gr.g) {
                return new BCECPublicKey(this.f44955a, (gr.g) keySpec, this.f44956b);
            }
            if (keySpec instanceof ECPublicKeySpec) {
                return new BCECPublicKey(this.f44955a, (ECPublicKeySpec) keySpec, this.f44956b);
            }
            if (!(keySpec instanceof p)) {
                return super.engineGeneratePublic(keySpec);
            }
            np.c cVarC = org.bouncycastle.crypto.util.h.c(((p) keySpec).getEncoded());
            if (!(cVarC instanceof m0)) {
                throw new IllegalArgumentException("openssh key is not ec public key");
            }
            g0 g0VarD = ((m0) cVarC).d();
            return engineGeneratePublic(new gr.g(((m0) cVarC).e(), new gr.e(g0VarD.a(), g0VarD.b(), g0VarD.e(), g0VarD.c(), g0VarD.f())));
        } catch (Exception e10) {
            throw new InvalidKeySpecException("invalid KeySpec: " + e10.getMessage(), e10);
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if ((cls.isAssignableFrom(KeySpec.class) || cls.isAssignableFrom(ECPublicKeySpec.class)) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            gr.e eVarB = BouncyCastleProvider.f45330c.b();
            return new ECPublicKeySpec(eCPublicKey.getW(), org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVarB.a(), eVarB.e()), eVarB));
        }
        if ((cls.isAssignableFrom(KeySpec.class) || cls.isAssignableFrom(ECPrivateKeySpec.class)) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            if (eCPrivateKey.getParams() != null) {
                return new ECPrivateKeySpec(eCPrivateKey.getS(), eCPrivateKey.getParams());
            }
            gr.e eVarB2 = BouncyCastleProvider.f45330c.b();
            return new ECPrivateKeySpec(eCPrivateKey.getS(), org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVarB2.a(), eVarB2.e()), eVarB2));
        }
        if (cls.isAssignableFrom(gr.g.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            if (eCPublicKey2.getParams() != null) {
                return new gr.g(org.bouncycastle.jcajce.provider.asymmetric.util.h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCPublicKey2.getParams()));
            }
            return new gr.g(org.bouncycastle.jcajce.provider.asymmetric.util.h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), BouncyCastleProvider.f45330c.b());
        }
        if (cls.isAssignableFrom(gr.f.class) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey2 = (ECPrivateKey) key;
            if (eCPrivateKey2.getParams() != null) {
                return new gr.f(eCPrivateKey2.getS(), org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCPrivateKey2.getParams()));
            }
            return new gr.f(eCPrivateKey2.getS(), BouncyCastleProvider.f45330c.b());
        }
        if (cls.isAssignableFrom(p.class) && (key instanceof ECPublicKey)) {
            if (!(key instanceof BCECPublicKey)) {
                throw new IllegalArgumentException("invalid key type: " + key.getClass().getName());
            }
            BCECPublicKey bCECPublicKey = (BCECPublicKey) key;
            gr.e eVarB3 = bCECPublicKey.b();
            try {
                return new p(org.bouncycastle.crypto.util.h.a(new m0(bCECPublicKey.J0(), new g0(eVarB3.a(), eVarB3.b(), eVarB3.d(), eVarB3.c(), eVarB3.e()))));
            } catch (IOException e10) {
                throw new IllegalArgumentException("unable to produce encoding: " + e10.getMessage());
            }
        }
        if (!cls.isAssignableFrom(o.class) || !(key instanceof ECPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        if (!(key instanceof BCECPrivateKey)) {
            throw new IllegalArgumentException("invalid key type: " + key.getClass().getName());
        }
        try {
            return new o(u.z(key.getEncoded()).G().b().getEncoded());
        } catch (IOException e11) {
            throw new IllegalArgumentException("cannot encoded key: " + e11.getMessage());
        }
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof ECPublicKey) {
            return new BCECPublicKey((ECPublicKey) key, this.f44956b);
        }
        if (key instanceof ECPrivateKey) {
            return new BCECPrivateKey((ECPrivateKey) key, this.f44956b);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
