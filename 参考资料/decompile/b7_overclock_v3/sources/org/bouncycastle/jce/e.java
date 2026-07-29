package org.bouncycastle.jce;

import co.r;
import gm.d2;
import gm.f0;
import gm.h0;
import gm.t;
import gm.u1;
import gm.y;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.a0;
import pn.s;
import zn.c1;
import zn.w1;

/* JADX INFO: loaded from: classes5.dex */
public class e extends pn.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Hashtable f45258d = new Hashtable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Hashtable f45259e = new Hashtable();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Hashtable f45260f = new Hashtable();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Hashtable f45261g = new Hashtable();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Set f45262h = new HashSet();

    static {
        f45258d.put("MD2WITHRSAENCRYPTION", new y("1.2.840.113549.1.1.2"));
        f45258d.put("MD2WITHRSA", new y("1.2.840.113549.1.1.2"));
        f45258d.put("MD5WITHRSAENCRYPTION", new y("1.2.840.113549.1.1.4"));
        f45258d.put("MD5WITHRSA", new y("1.2.840.113549.1.1.4"));
        f45258d.put("RSAWITHMD5", new y("1.2.840.113549.1.1.4"));
        f45258d.put("SHA1WITHRSAENCRYPTION", new y("1.2.840.113549.1.1.5"));
        f45258d.put("SHA1WITHRSA", new y("1.2.840.113549.1.1.5"));
        Hashtable hashtable = f45258d;
        y yVar = s.K3;
        hashtable.put("SHA224WITHRSAENCRYPTION", yVar);
        f45258d.put("SHA224WITHRSA", yVar);
        Hashtable hashtable2 = f45258d;
        y yVar2 = s.H3;
        hashtable2.put("SHA256WITHRSAENCRYPTION", yVar2);
        f45258d.put("SHA256WITHRSA", yVar2);
        Hashtable hashtable3 = f45258d;
        y yVar3 = s.I3;
        hashtable3.put("SHA384WITHRSAENCRYPTION", yVar3);
        f45258d.put("SHA384WITHRSA", yVar3);
        Hashtable hashtable4 = f45258d;
        y yVar4 = s.J3;
        hashtable4.put("SHA512WITHRSAENCRYPTION", yVar4);
        f45258d.put("SHA512WITHRSA", yVar4);
        Hashtable hashtable5 = f45258d;
        y yVar5 = s.G3;
        hashtable5.put("SHA1WITHRSAANDMGF1", yVar5);
        f45258d.put("SHA224WITHRSAANDMGF1", yVar5);
        f45258d.put("SHA256WITHRSAANDMGF1", yVar5);
        f45258d.put("SHA384WITHRSAANDMGF1", yVar5);
        f45258d.put("SHA512WITHRSAANDMGF1", yVar5);
        f45258d.put("RSAWITHSHA1", new y("1.2.840.113549.1.1.5"));
        Hashtable hashtable6 = f45258d;
        y yVar6 = tn.b.f51365g;
        hashtable6.put("RIPEMD128WITHRSAENCRYPTION", yVar6);
        f45258d.put("RIPEMD128WITHRSA", yVar6);
        Hashtable hashtable7 = f45258d;
        y yVar7 = tn.b.f51364f;
        hashtable7.put("RIPEMD160WITHRSAENCRYPTION", yVar7);
        f45258d.put("RIPEMD160WITHRSA", yVar7);
        Hashtable hashtable8 = f45258d;
        y yVar8 = tn.b.f51366h;
        hashtable8.put("RIPEMD256WITHRSAENCRYPTION", yVar8);
        f45258d.put("RIPEMD256WITHRSA", yVar8);
        f45258d.put("SHA1WITHDSA", new y("1.2.840.10040.4.3"));
        f45258d.put("DSAWITHSHA1", new y("1.2.840.10040.4.3"));
        Hashtable hashtable9 = f45258d;
        y yVar9 = kn.d.X;
        hashtable9.put("SHA224WITHDSA", yVar9);
        Hashtable hashtable10 = f45258d;
        y yVar10 = kn.d.Y;
        hashtable10.put("SHA256WITHDSA", yVar10);
        f45258d.put("SHA384WITHDSA", kn.d.Z);
        f45258d.put("SHA512WITHDSA", kn.d.f37589a0);
        Hashtable hashtable11 = f45258d;
        y yVar11 = r.f11170i0;
        hashtable11.put("SHA1WITHECDSA", yVar11);
        Hashtable hashtable12 = f45258d;
        y yVar12 = r.f11178n0;
        hashtable12.put("SHA224WITHECDSA", yVar12);
        Hashtable hashtable13 = f45258d;
        y yVar13 = r.f11180o0;
        hashtable13.put("SHA256WITHECDSA", yVar13);
        Hashtable hashtable14 = f45258d;
        y yVar14 = r.f11182p0;
        hashtable14.put("SHA384WITHECDSA", yVar14);
        Hashtable hashtable15 = f45258d;
        y yVar15 = r.f11184q0;
        hashtable15.put("SHA512WITHECDSA", yVar15);
        f45258d.put("ECDSAWITHSHA1", yVar11);
        Hashtable hashtable16 = f45258d;
        y yVar16 = qm.a.f47464n;
        hashtable16.put("GOST3411WITHGOST3410", yVar16);
        f45258d.put("GOST3410WITHGOST3411", yVar16);
        Hashtable hashtable17 = f45258d;
        y yVar17 = qm.a.f47465o;
        hashtable17.put("GOST3411WITHECGOST3410", yVar17);
        f45258d.put("GOST3411WITHECGOST3410-2001", yVar17);
        f45258d.put("GOST3411WITHGOST3410-2001", yVar17);
        f45261g.put(new y("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        f45261g.put(yVar, "SHA224WITHRSA");
        f45261g.put(yVar2, "SHA256WITHRSA");
        f45261g.put(yVar3, "SHA384WITHRSA");
        f45261g.put(yVar4, "SHA512WITHRSA");
        f45261g.put(yVar16, "GOST3411WITHGOST3410");
        f45261g.put(yVar17, "GOST3411WITHECGOST3410");
        f45261g.put(new y("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        f45261g.put(new y("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        f45261g.put(new y("1.2.840.10040.4.3"), "SHA1WITHDSA");
        f45261g.put(yVar11, "SHA1WITHECDSA");
        f45261g.put(yVar12, "SHA224WITHECDSA");
        f45261g.put(yVar13, "SHA256WITHECDSA");
        f45261g.put(yVar14, "SHA384WITHECDSA");
        f45261g.put(yVar15, "SHA512WITHECDSA");
        f45261g.put(on.b.f44367k, "SHA1WITHRSA");
        Hashtable hashtable18 = f45261g;
        y yVar18 = on.b.f44366j;
        hashtable18.put(yVar18, "SHA1WITHDSA");
        f45261g.put(yVar9, "SHA224WITHDSA");
        f45261g.put(yVar10, "SHA256WITHDSA");
        f45260f.put(s.f46854x3, "RSA");
        f45260f.put(r.W0, "DSA");
        f45262h.add(yVar11);
        f45262h.add(yVar12);
        f45262h.add(yVar13);
        f45262h.add(yVar14);
        f45262h.add(yVar15);
        f45262h.add(r.X0);
        f45262h.add(yVar18);
        f45262h.add(yVar9);
        f45262h.add(yVar10);
        f45262h.add(yVar16);
        f45262h.add(yVar17);
        y yVar19 = on.b.f44365i;
        d2 d2Var = d2.f29657b;
        f45259e.put("SHA1WITHRSAANDMGF1", C(new zn.b(yVar19, d2Var), 20));
        f45259e.put("SHA224WITHRSAANDMGF1", C(new zn.b(kn.d.f37598f, d2Var), 28));
        f45259e.put("SHA256WITHRSAANDMGF1", C(new zn.b(kn.d.f37592c, d2Var), 32));
        f45259e.put("SHA384WITHRSAANDMGF1", C(new zn.b(kn.d.f37594d, d2Var), 48));
        f45259e.put("SHA512WITHRSAANDMGF1", C(new zn.b(kn.d.f37596e, d2Var), 64));
    }

    public e(f0 f0Var) {
        super(f0Var);
    }

    public e(String str, X500Principal x500Principal, PublicKey publicKey, h0 h0Var, PrivateKey privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        this(str, B(x500Principal), publicKey, h0Var, privateKey, BouncyCastleProvider.f45329b);
    }

    public e(String str, X500Principal x500Principal, PublicKey publicKey, h0 h0Var, PrivateKey privateKey, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        this(str, B(x500Principal), publicKey, h0Var, privateKey, str2);
    }

    public e(String str, w1 w1Var, PublicKey publicKey, h0 h0Var, PrivateKey privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        this(str, w1Var, publicKey, h0Var, privateKey, BouncyCastleProvider.f45329b);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.lang.String r5, zn.w1 r6, java.security.PublicKey r7, gm.h0 r8, java.security.PrivateKey r9, java.lang.String r10) throws java.security.NoSuchAlgorithmException, java.security.SignatureException, java.security.InvalidKeyException, java.security.NoSuchProviderException {
        /*
            r4 = this;
            r4.<init>()
            java.lang.String r0 = org.bouncycastle.util.Strings.o(r5)
            java.util.Hashtable r1 = org.bouncycastle.jce.e.f45258d
            java.lang.Object r1 = r1.get(r0)
            gm.y r1 = (gm.y) r1
            if (r1 != 0) goto L1f
            gm.y r1 = new gm.y     // Catch: java.lang.Exception -> L17
            r1.<init>(r0)     // Catch: java.lang.Exception -> L17
            goto L1f
        L17:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Unknown signature type requested"
            r5.<init>(r6)
            throw r5
        L1f:
            if (r6 == 0) goto Lb5
            if (r7 == 0) goto Lad
            java.util.Set r2 = org.bouncycastle.jce.e.f45262h
            boolean r2 = r2.contains(r1)
            if (r2 == 0) goto L33
            zn.b r0 = new zn.b
            r0.<init>(r1)
        L30:
            r4.f46754b = r0
            goto L53
        L33:
            java.util.Hashtable r2 = org.bouncycastle.jce.e.f45259e
            boolean r2 = r2.containsKey(r0)
            if (r2 == 0) goto L4b
            zn.b r2 = new zn.b
            java.util.Hashtable r3 = org.bouncycastle.jce.e.f45259e
            java.lang.Object r0 = r3.get(r0)
            gm.h r0 = (gm.h) r0
            r2.<init>(r1, r0)
            r4.f46754b = r2
            goto L53
        L4b:
            zn.b r0 = new zn.b
            gm.d2 r2 = gm.d2.f29657b
            r0.<init>(r1, r2)
            goto L30
        L53:
            byte[] r7 = r7.getEncoded()     // Catch: java.io.IOException -> La5
            gm.c0 r7 = gm.c0.D(r7)     // Catch: java.io.IOException -> La5
            gm.f0 r7 = (gm.f0) r7     // Catch: java.io.IOException -> La5
            pn.f r0 = new pn.f     // Catch: java.io.IOException -> La5
            zn.c1 r7 = zn.c1.A(r7)     // Catch: java.io.IOException -> La5
            r0.<init>(r6, r7, r8)     // Catch: java.io.IOException -> La5
            r4.f46753a = r0     // Catch: java.io.IOException -> La5
            if (r10 != 0) goto L6f
            java.security.Signature r5 = java.security.Signature.getInstance(r5)
            goto L73
        L6f:
            java.security.Signature r5 = java.security.Signature.getInstance(r5, r10)
        L73:
            r5.initSign(r9)
            pn.f r6 = r4.f46753a     // Catch: java.lang.Exception -> L8d
            java.lang.String r7 = "DER"
            byte[] r6 = r6.v(r7)     // Catch: java.lang.Exception -> L8d
            r5.update(r6)     // Catch: java.lang.Exception -> L8d
            gm.u1 r6 = new gm.u1
            byte[] r5 = r5.sign()
            r6.<init>(r5)
            r4.f46755c = r6
            return
        L8d:
            r5 = move-exception
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "exception encoding TBS cert request - "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        La5:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "can't encode public key"
            r5.<init>(r6)
            throw r5
        Lad:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "public key must not be null"
            r5.<init>(r6)
            throw r5
        Lb5:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "subject must not be null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.e.<init>(java.lang.String, zn.w1, java.security.PublicKey, gm.h0, java.security.PrivateKey, java.lang.String):void");
    }

    public e(byte[] bArr) {
        super(I(bArr));
    }

    public static w1 B(X500Principal x500Principal) {
        try {
            return new j(x500Principal.getEncoded());
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    public static a0 C(zn.b bVar, int i10) {
        return new a0(bVar, new zn.b(s.E3, bVar), new t(i10), new t(1L));
    }

    public static String D(y yVar) {
        return s.f46803f4.C(yVar) ? "MD5" : on.b.f44365i.C(yVar) ? "SHA1" : kn.d.f37598f.C(yVar) ? "SHA224" : kn.d.f37592c.C(yVar) ? "SHA256" : kn.d.f37594d.C(yVar) ? "SHA384" : kn.d.f37596e.C(yVar) ? "SHA512" : tn.b.f51361c.C(yVar) ? "RIPEMD128" : tn.b.f51360b.C(yVar) ? "RIPEMD160" : tn.b.f51362d.C(yVar) ? "RIPEMD256" : qm.a.f47452b.C(yVar) ? "GOST3411" : yVar.L();
    }

    public static String G(zn.b bVar) {
        gm.h hVarA = bVar.A();
        if (hVarA == null || d2.f29657b.B(hVarA) || !bVar.x().C(s.G3)) {
            return bVar.x().L();
        }
        return D(a0.y(hVarA).x().x()) + "withRSAandMGF1";
    }

    public static f0 I(byte[] bArr) {
        try {
            return (f0) new gm.s(bArr).n();
        } catch (Exception unused) {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    public PublicKey E() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        return F(BouncyCastleProvider.f45329b);
    }

    public PublicKey F(String str) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        c1 c1VarA = this.f46753a.A();
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new u1(c1VarA).L());
            zn.b bVarX = c1VarA.x();
            try {
                return str == null ? KeyFactory.getInstance(bVarX.x().L()).generatePublic(x509EncodedKeySpec) : KeyFactory.getInstance(bVarX.x().L(), str).generatePublic(x509EncodedKeySpec);
            } catch (NoSuchAlgorithmException e10) {
                if (f45260f.get(bVarX.x()) == null) {
                    throw e10;
                }
                String str2 = (String) f45260f.get(bVarX.x());
                return str == null ? KeyFactory.getInstance(str2).generatePublic(x509EncodedKeySpec) : KeyFactory.getInstance(str2, str).generatePublic(x509EncodedKeySpec);
            }
        } catch (IOException unused) {
            throw new InvalidKeyException("error decoding public key");
        } catch (InvalidKeySpecException unused2) {
            throw new InvalidKeyException("error decoding public key");
        }
    }

    public final void H(Signature signature, gm.h hVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (hVar == null || d2.f29657b.B(hVar)) {
            return;
        }
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
        try {
            algorithmParameters.init(hVar.b().v(gm.j.f29713a));
            if (signature.getAlgorithm().endsWith("MGF1")) {
                try {
                    signature.setParameter(algorithmParameters.getParameterSpec(PSSParameterSpec.class));
                } catch (GeneralSecurityException e10) {
                    throw new SignatureException("Exception extracting parameters: " + e10.getMessage());
                }
            }
        } catch (IOException e11) {
            throw new SignatureException("IOException decoding parameters: " + e11.getMessage());
        }
    }

    public boolean J() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        return K(BouncyCastleProvider.f45329b);
    }

    public boolean K(String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        return L(F(str), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.bouncycastle.jce.e, pn.e] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.security.Signature] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.security.Signature] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.security.Signature] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public boolean L(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        try {
            str = str == 0 ? Signature.getInstance(G(this.f46754b)) : Signature.getInstance(G(this.f46754b), (String) str);
        } catch (NoSuchAlgorithmException e10) {
            if (f45261g.get(this.f46754b.x()) == null) {
                throw e10;
            }
            String str2 = (String) f45261g.get(this.f46754b.x());
            str = str == 0 ? Signature.getInstance(str2) : Signature.getInstance(str2, (String) str);
        }
        H(str, this.f46754b.A());
        str.initVerify(publicKey);
        try {
            str.update(this.f46753a.v(gm.j.f29713a));
            return str.verify(this.f46755c.L());
        } catch (Exception e11) {
            throw new SignatureException("exception encoding TBS cert request - " + e11);
        }
    }

    @Override // gm.w, org.bouncycastle.util.g
    public byte[] getEncoded() {
        try {
            return v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new RuntimeException(e10.toString());
        }
    }
}
