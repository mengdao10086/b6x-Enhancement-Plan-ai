package org.bouncycastle.jce.provider;

import cp.n1;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import np.a2;
import np.b2;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jce.provider.d;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.jce.provider.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Class[] f45377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public org.bouncycastle.crypto.h f45378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v1 f45379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f45380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f45381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f45382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f45383n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f45384o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AlgorithmParameters f45385p;

    public static class a extends b {
        public a() {
            super(new jp.c(new cp.s()), 0, 0, 64, 64);
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.jce.provider.b$b, reason: collision with other inner class name */
    public static class C0511b extends b {
        public C0511b() {
            super(new jp.c(new cp.s()), 0, 1, 64, 64);
        }
    }

    public static class c extends b {
        public c() {
            super(new jp.c(new cp.t()), 2, 1, 128, 64);
        }
    }

    public static class d extends b {
        public d() {
            super(new jp.c(new cp.t()), 2, 1, 192, 64);
        }
    }

    public static class e extends b {
        public e() {
            super(new jp.c(new cp.t()), 3, 1, 192, 64);
        }
    }

    public static class f extends b {
        public f() {
            super(new jp.c(new n1()), 3, 1, 256, 128);
        }
    }

    public b(org.bouncycastle.crypto.f fVar) {
        this.f45377h = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.f45380k = 2;
        this.f45381l = 1;
        this.f45384o = 0;
        this.f45385p = null;
        this.f45378i = new mp.e(fVar);
    }

    public b(org.bouncycastle.crypto.f fVar, int i10, int i11, int i12, int i13) {
        this.f45377h = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.f45380k = 2;
        this.f45381l = 1;
        this.f45384o = 0;
        this.f45385p = null;
        this.f45378i = new mp.e(fVar);
        this.f45380k = i10;
        this.f45381l = i11;
        this.f45382m = i12;
        this.f45383n = i13;
    }

    public int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException {
        int iH = i11 != 0 ? this.f45378i.h(bArr, i10, i11, bArr2, i12) : 0;
        try {
            return iH + this.f45378i.a(bArr2, i12 + iH);
        } catch (DataLengthException e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        } catch (InvalidCipherTextException e11) {
            throw new BadPaddingException(e11.getMessage());
        }
    }

    public byte[] b(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArr2 = new byte[f(i11)];
        int iH = i11 != 0 ? this.f45378i.h(bArr, i10, i11, bArr2, 0) : 0;
        try {
            int iA = iH + this.f45378i.a(bArr2, iH);
            byte[] bArr3 = new byte[iA];
            System.arraycopy(bArr2, 0, bArr3, 0, iA);
            return bArr3;
        } catch (DataLengthException e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        } catch (InvalidCipherTextException e11) {
            throw new BadPaddingException(e11.getMessage());
        }
    }

    public int c() {
        return this.f45378i.b();
    }

    public byte[] d() {
        v1 v1Var = this.f45379j;
        if (v1Var != null) {
            return v1Var.a();
        }
        return null;
    }

    public int e(Key key) {
        return key.getEncoded().length;
    }

    public int f(int i10) {
        return this.f45378i.c(i10);
    }

    public AlgorithmParameters g() {
        if (this.f45385p == null && this.f45379j != null) {
            String strB = this.f45378i.d().b();
            if (strB.indexOf(47) >= 0) {
                strB = strB.substring(0, strB.indexOf(47));
            }
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(strB, BouncyCastleProvider.f45329b);
                this.f45385p = algorithmParameters;
                algorithmParameters.init(this.f45379j.a());
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f45385p;
    }

    public void h(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec = null;
        if (algorithmParameters != null) {
            int i11 = 0;
            while (true) {
                Class[] clsArr = this.f45377h;
                if (i11 == clsArr.length) {
                    break;
                }
                try {
                    parameterSpec = algorithmParameters.getParameterSpec(clsArr[i11]);
                    break;
                } catch (Exception unused) {
                    i11++;
                }
            }
            if (parameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        this.f45385p = algorithmParameters;
        j(i10, key, parameterSpec, secureRandom);
    }

    public void i(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            j(i10, key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new IllegalArgumentException(e10.getMessage());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void j(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        v1 v1Var;
        org.bouncycastle.crypto.k kVar;
        org.bouncycastle.crypto.k kVar2;
        np.n1 n1Var;
        if (key instanceof BCPBEKey) {
            org.bouncycastle.crypto.k kVarC = d.a.c((BCPBEKey) key, algorithmParameterSpec, this.f45380k, this.f45381l, this.f45378i.d().b(), this.f45382m, this.f45383n);
            kVar2 = kVarC;
            if (this.f45383n != 0) {
                this.f45379j = (v1) kVarC;
                kVar2 = kVarC;
            }
        } else {
            if (algorithmParameterSpec == null) {
                n1Var = new np.n1(key.getEncoded());
            } else {
                if (algorithmParameterSpec instanceof IvParameterSpec) {
                    if (this.f45384o != 0) {
                        v1 v1Var2 = new v1(new np.n1(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                        this.f45379j = v1Var2;
                        kVar = v1Var2;
                    } else {
                        n1Var = new np.n1(key.getEncoded());
                    }
                } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                    RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                    a2 a2Var = new a2(key.getEncoded(), rC2ParameterSpec.getEffectiveKeyBits());
                    kVar = a2Var;
                    if (rC2ParameterSpec.getIV() != null) {
                        kVar = a2Var;
                        if (this.f45384o != 0) {
                            v1Var = new v1(a2Var, rC2ParameterSpec.getIV());
                            this.f45379j = v1Var;
                            kVar2 = v1Var;
                        }
                    }
                } else {
                    if (!(algorithmParameterSpec instanceof RC5ParameterSpec)) {
                        throw new InvalidAlgorithmParameterException("unknown parameter type.");
                    }
                    RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) algorithmParameterSpec;
                    b2 b2Var = new b2(key.getEncoded(), rC5ParameterSpec.getRounds());
                    if (rC5ParameterSpec.getWordSize() != 32) {
                        throw new IllegalArgumentException("can only accept RC5 word size 32 (at the moment...)");
                    }
                    kVar = b2Var;
                    if (rC5ParameterSpec.getIV() != null) {
                        kVar = b2Var;
                        if (this.f45384o != 0) {
                            v1Var = new v1(b2Var, rC5ParameterSpec.getIV());
                            this.f45379j = v1Var;
                            kVar2 = v1Var;
                        }
                    }
                }
                kVar2 = kVar;
            }
            kVar2 = n1Var;
        }
        org.bouncycastle.crypto.k kVar3 = kVar2;
        if (this.f45384o != 0) {
            boolean z10 = kVar2 instanceof v1;
            kVar3 = kVar2;
            if (!z10) {
                if (secureRandom == null) {
                    secureRandom = org.bouncycastle.crypto.n.f();
                }
                if (i10 != 1 && i10 != 3) {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
                byte[] bArr = new byte[this.f45384o];
                secureRandom.nextBytes(bArr);
                v1 v1Var3 = new v1(kVar2, bArr);
                this.f45379j = v1Var3;
                kVar3 = v1Var3;
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        System.out.println("eeek!");
                        return;
                    }
                }
            }
            this.f45378i.f(false, kVar3);
            return;
        }
        this.f45378i.f(true, kVar3);
    }

    public void k(String str) {
        mp.e eVar;
        mp.e eVar2;
        String strO = Strings.o(str);
        if (strO.equals("ECB")) {
            this.f45384o = 0;
            eVar = new mp.e(this.f45378i.d());
        } else if (strO.equals("CBC")) {
            this.f45384o = this.f45378i.d().c();
            eVar = new mp.e(new jp.c(this.f45378i.d()));
        } else if (strO.startsWith("OFB")) {
            this.f45384o = this.f45378i.d().c();
            if (strO.length() != 3) {
                eVar2 = new mp.e(new jp.x(this.f45378i.d(), Integer.parseInt(strO.substring(3))));
                this.f45378i = eVar2;
                return;
            }
            eVar = new mp.e(new jp.x(this.f45378i.d(), this.f45378i.b() * 8));
        } else {
            if (!strO.startsWith("CFB")) {
                throw new IllegalArgumentException("can't support mode " + str);
            }
            this.f45384o = this.f45378i.d().c();
            if (strO.length() != 3) {
                eVar2 = new mp.e(new jp.e(this.f45378i.d(), Integer.parseInt(strO.substring(3))));
                this.f45378i = eVar2;
                return;
            }
            eVar = new mp.e(new jp.e(this.f45378i.d(), this.f45378i.b() * 8));
        }
        this.f45378i = eVar;
    }

    public void l(String str) throws NoSuchPaddingException {
        org.bouncycastle.crypto.h eVar;
        String strO = Strings.o(str);
        if (strO.equals("NOPADDING")) {
            eVar = new org.bouncycastle.crypto.h(this.f45378i.d());
        } else if (strO.equals("PKCS5PADDING") || strO.equals("PKCS7PADDING") || strO.equals("ISO10126PADDING")) {
            eVar = new mp.e(this.f45378i.d());
        } else {
            if (!strO.equals("WITHCTS")) {
                throw new NoSuchPaddingException("Padding " + str + " unknown.");
            }
            eVar = new jp.f(this.f45378i.d());
        }
        this.f45378i = eVar;
    }

    public Key m(byte[] bArr, String str, int i10) throws InvalidKeyException {
        try {
            byte[] bArrB = b(bArr, 0, bArr.length);
            if (i10 == 3) {
                return new SecretKeySpec(bArrB, str);
            }
            try {
                KeyFactory keyFactory = KeyFactory.getInstance(str, BouncyCastleProvider.f45329b);
                if (i10 == 1) {
                    return keyFactory.generatePublic(new X509EncodedKeySpec(bArrB));
                }
                if (i10 == 2) {
                    return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrB));
                }
                throw new InvalidKeyException("Unknown key type " + i10);
            } catch (NoSuchAlgorithmException e10) {
                throw new InvalidKeyException("Unknown key type " + e10.getMessage());
            } catch (NoSuchProviderException e11) {
                throw new InvalidKeyException("Unknown key type " + e11.getMessage());
            } catch (InvalidKeySpecException e12) {
                throw new InvalidKeyException("Unknown key type " + e12.getMessage());
            }
        } catch (BadPaddingException e13) {
            throw new InvalidKeyException(e13.getMessage());
        } catch (IllegalBlockSizeException e14) {
            throw new InvalidKeyException(e14.getMessage());
        }
    }

    public int n(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        return this.f45378i.h(bArr, i10, i11, bArr2, i12);
    }

    public byte[] o(byte[] bArr, int i10, int i11) {
        int iE = this.f45378i.e(i11);
        if (iE <= 0) {
            this.f45378i.h(bArr, i10, i11, null, 0);
            return null;
        }
        byte[] bArr2 = new byte[iE];
        this.f45378i.h(bArr, i10, i11, bArr2, 0);
        return bArr2;
    }

    public byte[] p(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try {
            return b(encoded, 0, encoded.length);
        } catch (BadPaddingException e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        }
    }
}
