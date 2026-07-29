package org.bouncycastle.cms.jcajce;

import gm.d2;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;
import so.c1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class y implements c1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f44648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static l0 f44649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static l0 f44650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static l0 f44651k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PrivateKey f44652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f44653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f44654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cs.f0 f44655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zn.b f44656g;

    public static class a implements l0 {
        @Override // org.bouncycastle.cms.jcajce.l0
        public byte[] a(zn.b bVar, int i10, byte[] bArr) {
            try {
                return new nm.a(new zn.b(bVar.x(), d2.f29657b), bArr, org.bouncycastle.util.o.k(i10)).v(gm.j.f29713a);
            } catch (IOException e10) {
                throw new IllegalStateException("Unable to create KDF material: " + e10);
            }
        }
    }

    public static class b implements l0 {
        @Override // org.bouncycastle.cms.jcajce.l0
        public byte[] a(zn.b bVar, int i10, byte[] bArr) {
            return bArr;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f44648h = hashSet;
        hashSet.add(co.r.Z0);
        hashSet.add(co.r.f11157b1);
        f44649i = new a();
        f44650j = new b();
        f44651k = new o0();
    }

    public y(PrivateKey privateKey) {
        c cVar = new c(new org.bouncycastle.cms.jcajce.b());
        this.f44653d = cVar;
        this.f44654e = cVar;
        this.f44655f = new cs.k();
        this.f44656g = null;
        this.f44652c = org.bouncycastle.cms.jcajce.a.a(privateKey);
    }

    @Override // so.c1
    public zn.b f() {
        if (this.f44656g == null) {
            this.f44656g = pn.u.z(this.f44652c.getEncoded()).B();
        }
        return this.f44656g;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final SecretKey g(zn.b bVar, zn.b bVar2, PublicKey publicKey, gm.z zVar, PrivateKey privateKey, l0 l0Var) throws GeneralSecurityException, CMSException, IOException {
        PrivateKey privateKeyA = org.bouncycastle.cms.jcajce.a.a(privateKey);
        cr.w wVar = null;
        wVar = null;
        if (org.bouncycastle.cms.jcajce.a.i(bVar.x())) {
            nm.b bVarA = nm.b.A(zVar.J());
            PublicKey publicKeyGeneratePublic = this.f44653d.j(bVar.x()).generatePublic(new X509EncodedKeySpec(new zn.c1(f(), bVarA.y().A().H()).getEncoded()));
            KeyAgreement keyAgreementI = this.f44653d.i(bVar.x());
            byte[] bArrJ = bVarA.x() != null ? bVarA.x().J() : null;
            l0 l0Var2 = f44649i;
            if (l0Var == l0Var2) {
                bArrJ = l0Var2.a(bVar2, this.f44655f.a(bVar2), bArrJ);
            }
            keyAgreementI.init(privateKeyA, new cr.n(privateKeyA, publicKeyGeneratePublic, bArrJ));
            keyAgreementI.doPhase(publicKey, true);
            return keyAgreementI.generateSecret(bVar2.x().L());
        }
        KeyAgreement keyAgreementI2 = this.f44653d.i(bVar.x());
        if (org.bouncycastle.cms.jcajce.a.g(bVar.x())) {
            int iA = this.f44655f.a(bVar2);
            wVar = zVar != null ? new cr.w(l0Var.a(bVar2, iA, zVar.J())) : new cr.w(l0Var.a(bVar2, iA, null));
        } else if (org.bouncycastle.cms.jcajce.a.j(bVar.x())) {
            if (zVar != null) {
                wVar = new cr.w(zVar.J());
            }
        } else {
            if (!org.bouncycastle.cms.jcajce.a.h(bVar.x())) {
                throw new CMSException("Unknown key agreement algorithm: " + bVar.x());
            }
            if (zVar != null) {
                wVar = new cr.w(zVar.J());
            }
        }
        keyAgreementI2.init(privateKeyA, wVar);
        keyAgreementI2.doPhase(publicKey, true);
        return keyAgreementI2.generateSecret(bVar2.x().L());
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.security.Key h(zn.b r10, zn.b r11, zn.c1 r12, gm.z r13, byte[] r14) throws org.bouncycastle.cms.CMSException {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.cms.jcajce.y.h(zn.b, zn.b, zn.c1, gm.z, byte[]):java.security.Key");
    }

    public y i(String str) {
        this.f44654e = org.bouncycastle.cms.jcajce.a.b(str);
        return this;
    }

    public y j(Provider provider) {
        this.f44654e = org.bouncycastle.cms.jcajce.a.c(provider);
        return this;
    }

    public y k(zn.b bVar) {
        this.f44656g = bVar;
        return this;
    }

    public y l(String str) {
        c cVar = new c(new m0(str));
        this.f44653d = cVar;
        this.f44654e = cVar;
        return this;
    }

    public y m(Provider provider) {
        c cVar = new c(new n0(provider));
        this.f44653d = cVar;
        this.f44654e = cVar;
        return this;
    }

    public Key n(gm.y yVar, SecretKey secretKey, gm.y yVar2, byte[] bArr) throws CMSException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipherF = this.f44653d.f(yVar);
        cipherF.init(4, secretKey);
        return cipherF.unwrap(bArr, this.f44653d.u(yVar2), 3);
    }
}
