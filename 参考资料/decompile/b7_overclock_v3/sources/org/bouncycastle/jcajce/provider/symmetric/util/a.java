package org.bouncycastle.jcajce.provider.symmetric.util;

import ar.f;
import ar.i;
import cp.v;
import cr.j;
import gm.f2;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import jp.a0;
import jp.c0;
import jp.m;
import jp.n;
import jp.o;
import jp.p;
import jp.r;
import jp.t;
import jp.w;
import jp.x;
import jp.z;
import mp.g;
import np.v1;
import np.x1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.h;
import org.bouncycastle.crypto.k;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.util.Strings;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class a extends BaseWrapCipher implements org.bouncycastle.jcajce.provider.symmetric.util.d {
    public static final int B = 512;
    public static final Class C = f.a(a.class, "javax.crypto.spec.GCMParameterSpec");
    public String A;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Class[] f45193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public org.bouncycastle.crypto.f f45194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ar.e f45195o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f45196p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v1 f45197q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public np.a f45198r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f45199s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f45200t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f45201u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f45202v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f45203w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f45204x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PBEParameterSpec f45205y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f45206z;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.symmetric.util.a$a, reason: collision with other inner class name */
    public static class C0510a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Constructor f45207b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public jp.b f45208a;

        static {
            Class clsA = f.a(a.class, "javax.crypto.AEADBadTagException");
            f45207b = clsA != null ? l(clsA) : null;
        }

        public C0510a(jp.b bVar) {
            this.f45208a = bVar;
        }

        public static Constructor l(Class cls) {
            try {
                return cls.getConstructor(String.class);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public void a(boolean z10, k kVar) throws IllegalArgumentException {
            this.f45208a.a(z10, kVar);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public String b() {
            jp.b bVar = this.f45208a;
            return bVar instanceof jp.a ? ((jp.a) bVar).f().b() : bVar.b();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int c(byte[] bArr, int i10) throws IllegalStateException, BadPaddingException {
            try {
                return this.f45208a.c(bArr, i10);
            } catch (InvalidCipherTextException e10) {
                Constructor constructor = f45207b;
                if (constructor != null) {
                    BadPaddingException badPaddingException = null;
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(e10.getMessage());
                    } catch (Exception unused) {
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e10.getMessage());
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public boolean d() {
            return false;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
            return this.f45208a.e(bArr, i10, i11, bArr2, i12);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public org.bouncycastle.crypto.f f() {
            jp.b bVar = this.f45208a;
            if (bVar instanceof jp.a) {
                return ((jp.a) bVar).f();
            }
            return null;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int g(int i10) {
            return this.f45208a.g(i10);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int h(int i10) {
            return this.f45208a.h(i10);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
            return this.f45208a.i(b10, bArr, i10);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public void j(byte[] bArr, int i10, int i11) {
            this.f45208a.k(bArr, i10, i11);
        }
    }

    public static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ep.a f45209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BaseWrapCipher.a f45210b = new BaseWrapCipher.a();

        public b(ep.a aVar) {
            this.f45209a = aVar;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public void a(boolean z10, k kVar) throws IllegalArgumentException {
            this.f45209a.d(z10, kVar);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public String b() {
            return this.f45209a.c();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int c(byte[] bArr, int i10) throws IllegalStateException, BadPaddingException {
            try {
                return this.f45209a.e(this.f45210b.c(), 0, this.f45210b.size(), bArr, i10);
            } finally {
                this.f45210b.a();
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public boolean d() {
            return false;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
            this.f45210b.write(bArr, i10, i11);
            return 0;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public org.bouncycastle.crypto.f f() {
            throw new IllegalStateException("not applicable for FPE");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int g(int i10) {
            return 0;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int h(int i10) {
            return this.f45210b.size() + i10;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
            this.f45210b.write(b10);
            return 0;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public void j(byte[] bArr, int i10, int i11) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }
    }

    public static class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f45211a;

        public c(org.bouncycastle.crypto.f fVar) {
            this.f45211a = new mp.e(fVar);
        }

        public c(org.bouncycastle.crypto.f fVar, mp.a aVar) {
            this.f45211a = new mp.e(fVar, aVar);
        }

        public c(h hVar) {
            this.f45211a = hVar;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public void a(boolean z10, k kVar) throws IllegalArgumentException {
            this.f45211a.f(z10, kVar);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public String b() {
            return this.f45211a.d().b();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int c(byte[] bArr, int i10) throws IllegalStateException, BadPaddingException {
            try {
                return this.f45211a.a(bArr, i10);
            } catch (InvalidCipherTextException e10) {
                throw new BadPaddingException(e10.getMessage());
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public boolean d() {
            return !(this.f45211a instanceof jp.f);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
            return this.f45211a.h(bArr, i10, i11, bArr2, i12);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public org.bouncycastle.crypto.f f() {
            return this.f45211a.d();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int g(int i10) {
            return this.f45211a.e(i10);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int h(int i10) {
            return this.f45211a.c(i10);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
            return this.f45211a.g(b10, bArr, i10);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.a.d
        public void j(byte[] bArr, int i10, int i11) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }
    }

    public interface d {
        void a(boolean z10, k kVar) throws IllegalArgumentException;

        String b();

        int c(byte[] bArr, int i10) throws IllegalStateException, BadPaddingException;

        boolean d();

        int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException;

        org.bouncycastle.crypto.f f();

        int g(int i10);

        int h(int i10);

        int i(byte b10, byte[] bArr, int i10) throws DataLengthException;

        void j(byte[] bArr, int i10, int i11);
    }

    public a(ar.e eVar) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45202v = 0;
        this.f45204x = true;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = eVar.get();
        this.f45195o = eVar;
        this.f45196p = new c(eVar.get());
    }

    public a(jp.a aVar) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45202v = 0;
        this.f45204x = true;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = aVar.f();
        this.f45202v = aVar.b().indexOf("GCM") >= 0 ? 12 : this.f45194n.c();
        this.f45196p = new C0510a(aVar);
    }

    public a(jp.a aVar, boolean z10, int i10) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45202v = 0;
        this.f45204x = true;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = aVar.f();
        this.f45204x = z10;
        this.f45202v = i10;
        this.f45196p = new C0510a(aVar);
    }

    public a(jp.b bVar, boolean z10, int i10) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = null;
        this.f45204x = z10;
        this.f45202v = i10;
        this.f45196p = new C0510a(bVar);
    }

    public a(org.bouncycastle.crypto.f fVar) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45202v = 0;
        this.f45204x = true;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = fVar;
        this.f45196p = new c(fVar);
    }

    public a(org.bouncycastle.crypto.f fVar, int i10) {
        this(fVar, true, i10);
    }

    public a(org.bouncycastle.crypto.f fVar, int i10, int i11, int i12, int i13) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45204x = true;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = fVar;
        this.f45200t = i10;
        this.f45201u = i11;
        this.f45199s = i12;
        this.f45202v = i13;
        this.f45196p = new c(fVar);
    }

    public a(org.bouncycastle.crypto.f fVar, boolean z10, int i10) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45202v = 0;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = fVar;
        this.f45204x = z10;
        this.f45196p = new c(fVar);
        this.f45202v = i10 / 8;
    }

    public a(h hVar, int i10) {
        this(hVar, true, i10);
    }

    public a(h hVar, boolean z10, int i10) {
        this.f45193m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, C, j.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45200t = -1;
        this.f45202v = 0;
        this.f45204x = true;
        this.f45205y = null;
        this.f45206z = null;
        this.A = null;
        this.f45194n = hVar.d();
        this.f45196p = new c(hVar);
        this.f45204x = z10;
        this.f45202v = i10 / 8;
    }

    public final k b(AlgorithmParameterSpec algorithmParameterSpec, k kVar) {
        k kVar2;
        v1 v1Var;
        if (kVar instanceof v1) {
            k kVarB = ((v1) kVar).b();
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                v1Var = new v1(kVarB, ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else {
                if (!(algorithmParameterSpec instanceof j)) {
                    return kVar;
                }
                j jVar = (j) algorithmParameterSpec;
                x1 x1Var = new x1(kVar, jVar.d());
                if (jVar.a() == null || this.f45202v == 0) {
                    return x1Var;
                }
                v1Var = new v1(kVarB, jVar.a());
            }
            this.f45197q = v1Var;
            return v1Var;
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            v1 v1Var2 = new v1(kVar, ((IvParameterSpec) algorithmParameterSpec).getIV());
            this.f45197q = v1Var2;
            kVar2 = v1Var2;
        } else {
            if (!(algorithmParameterSpec instanceof j)) {
                return kVar;
            }
            j jVar2 = (j) algorithmParameterSpec;
            x1 x1Var2 = new x1(kVar, jVar2.d());
            kVar2 = x1Var2;
            if (jVar2.a() != null) {
                kVar2 = x1Var2;
                if (this.f45202v != 0) {
                    return new v1(x1Var2, jVar2.a());
                }
            }
        }
        return kVar2;
    }

    public final boolean c(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str) || "GCM-SIV".equals(str) || "OCB".equals(str);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int iE;
        if (engineGetOutputSize(i11) + i12 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        if (i11 != 0) {
            try {
                iE = this.f45196p.e(bArr, i10, i11, bArr2, i12);
            } catch (OutputLengthException e10) {
                throw new IllegalBlockSizeException(e10.getMessage());
            } catch (DataLengthException e11) {
                throw new IllegalBlockSizeException(e11.getMessage());
            }
        } else {
            iE = 0;
        }
        return iE + this.f45196p.c(bArr2, i12 + iE);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        int iEngineGetOutputSize = engineGetOutputSize(i11);
        byte[] bArr2 = new byte[iEngineGetOutputSize];
        int iE = i11 != 0 ? this.f45196p.e(bArr, i10, i11, bArr2, 0) : 0;
        try {
            int iC = iE + this.f45196p.c(bArr2, iE);
            if (iC == iEngineGetOutputSize) {
                return bArr2;
            }
            if (iC > iEngineGetOutputSize) {
                throw new IllegalBlockSizeException("internal buffer overflow");
            }
            byte[] bArr3 = new byte[iC];
            System.arraycopy(bArr2, 0, bArr3, 0, iC);
            return bArr3;
        } catch (DataLengthException e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        org.bouncycastle.crypto.f fVar = this.f45194n;
        if (fVar == null) {
            return -1;
        }
        return fVar.c();
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        np.a aVar = this.f45198r;
        if (aVar != null) {
            return aVar.d();
        }
        v1 v1Var = this.f45197q;
        if (v1Var != null) {
            return v1Var.a();
        }
        return null;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        return this.f45196p.h(i10);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f45186f == null) {
            if (this.f45205y != null) {
                try {
                    AlgorithmParameters algorithmParametersA = a(this.f45206z);
                    this.f45186f = algorithmParametersA;
                    algorithmParametersA.init(this.f45205y);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.f45198r != null) {
                if (this.f45194n == null) {
                    try {
                        AlgorithmParameters algorithmParametersA2 = a(s.f46804f5.L());
                        this.f45186f = algorithmParametersA2;
                        algorithmParametersA2.init(new f2(this.f45198r.d()).getEncoded());
                    } catch (Exception e10) {
                        throw new RuntimeException(e10.toString());
                    }
                } else {
                    try {
                        AlgorithmParameters algorithmParametersA3 = a("GCM");
                        this.f45186f = algorithmParametersA3;
                        algorithmParametersA3.init(new cq.c(this.f45198r.d(), this.f45198r.c() / 8).getEncoded());
                    } catch (Exception e11) {
                        throw new RuntimeException(e11.toString());
                    }
                }
            } else if (this.f45197q != null) {
                String strB = this.f45196p.f().b();
                if (strB.indexOf(47) >= 0) {
                    strB = strB.substring(0, strB.indexOf(47));
                }
                try {
                    AlgorithmParameters algorithmParametersA4 = a(strB);
                    this.f45186f = algorithmParametersA4;
                    algorithmParametersA4.init(new IvParameterSpec(this.f45197q.a()));
                } catch (Exception e12) {
                    throw new RuntimeException(e12.toString());
                }
            }
        }
        return this.f45186f;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecA;
        if (algorithmParameters != null) {
            algorithmParameterSpecA = i.a(algorithmParameters, this.f45193m);
            if (algorithmParameterSpecA == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpecA = null;
        }
        engineInit(i10, key, algorithmParameterSpecA, secureRandom);
        this.f45186f = algorithmParameters;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidKeyException(e10.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:221:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04d3 A[Catch: Exception -> 0x0505, IllegalArgumentException -> 0x0510, TryCatch #3 {IllegalArgumentException -> 0x0510, Exception -> 0x0505, blocks: (B:246:0x04b0, B:247:0x04cb, B:248:0x04cc, B:250:0x04d8, B:252:0x04de, B:254:0x04e2, B:249:0x04d3), top: B:266:0x04a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[PHI: r5
  0x00ae: PHI (r5v36 org.bouncycastle.crypto.k) = 
  (r5v56 org.bouncycastle.crypto.k)
  (r5v57 org.bouncycastle.crypto.k)
  (r5v58 org.bouncycastle.crypto.k)
  (r5v59 org.bouncycastle.crypto.k)
 binds: [B:103:0x01fd, B:60:0x0145, B:49:0x00f9, B:34:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v14, types: [org.bouncycastle.jcajce.provider.symmetric.util.a$d] */
    /* JADX WARN: Type inference failed for: r0v21, types: [org.bouncycastle.jcajce.provider.symmetric.util.a$d] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10, types: [org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [np.b2, org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v18, types: [np.a2, org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [np.x1, org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v25, types: [np.v1] */
    /* JADX WARN: Type inference failed for: r5v28, types: [org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v29, types: [org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v30, types: [org.bouncycastle.crypto.k] */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33, types: [np.a] */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v70 */
    /* JADX WARN: Type inference failed for: r5v71 */
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
    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void engineInit(int r21, java.security.Key r22, java.security.spec.AlgorithmParameterSpec r23, java.security.SecureRandom r24) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 1315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.symmetric.util.a.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        d c0510a;
        c cVar;
        if (this.f45194n == null) {
            throw new NoSuchAlgorithmException("no mode supported for this algorithm");
        }
        String strO = Strings.o(str);
        this.A = strO;
        if (strO.equals("ECB")) {
            this.f45202v = 0;
            c0510a = new c(this.f45194n);
        } else if (this.A.equals("CBC")) {
            this.f45202v = this.f45194n.c();
            c0510a = new c(new jp.c(this.f45194n));
        } else if (this.A.startsWith("OFB")) {
            this.f45202v = this.f45194n.c();
            if (this.A.length() != 3) {
                cVar = new c(new x(this.f45194n, Integer.parseInt(this.A.substring(3))));
                this.f45196p = cVar;
                return;
            } else {
                org.bouncycastle.crypto.f fVar = this.f45194n;
                c0510a = new c(new x(fVar, fVar.c() * 8));
            }
        } else {
            if (!this.A.startsWith("CFB")) {
                if (this.A.startsWith("PGPCFB")) {
                    boolean zEquals = this.A.equals("PGPCFBWITHIV");
                    if (!zEquals && this.A.length() != 6) {
                        throw new NoSuchAlgorithmException("no mode support for " + this.A);
                    }
                    this.f45202v = this.f45194n.c();
                    cVar = new c(new a0(this.f45194n, zEquals));
                } else if (this.A.equals("OPENPGPCFB")) {
                    this.f45202v = 0;
                    c0510a = new c(new z(this.f45194n));
                } else if (this.A.equals("FF1")) {
                    this.f45202v = 0;
                    c0510a = new b(new ep.b(this.f45194n));
                } else if (this.A.equals("FF3-1")) {
                    this.f45202v = 0;
                    c0510a = new b(new ep.c(this.f45194n));
                } else if (this.A.equals("SIC")) {
                    int iC = this.f45194n.c();
                    this.f45202v = iC;
                    if (iC < 16) {
                        throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
                    }
                    this.f45204x = false;
                    c0510a = new c(new h(new c0(this.f45194n)));
                } else if (this.A.equals("CTR")) {
                    this.f45202v = this.f45194n.c();
                    this.f45204x = false;
                    org.bouncycastle.crypto.f fVar2 = this.f45194n;
                    cVar = fVar2 instanceof v ? new c(new h(new jp.s(fVar2))) : new c(new h(new c0(fVar2)));
                } else if (this.A.equals("GOFB")) {
                    this.f45202v = this.f45194n.c();
                    c0510a = new c(new h(new p(this.f45194n)));
                } else if (this.A.equals("GCFB")) {
                    this.f45202v = this.f45194n.c();
                    c0510a = new c(new h(new m(this.f45194n)));
                } else if (this.A.equals("CTS")) {
                    this.f45202v = this.f45194n.c();
                    c0510a = new c(new jp.f(new jp.c(this.f45194n)));
                } else if (this.A.equals("CCM")) {
                    this.f45202v = 12;
                    c0510a = this.f45194n instanceof v ? new C0510a(new r(this.f45194n)) : new C0510a(new jp.d(this.f45194n));
                } else if (this.A.equals("OCB")) {
                    if (this.f45195o == null) {
                        throw new NoSuchAlgorithmException("can't support mode " + str);
                    }
                    this.f45202v = 15;
                    c0510a = new C0510a(new w(this.f45194n, this.f45195o.get()));
                } else if (this.A.equals("EAX")) {
                    this.f45202v = this.f45194n.c();
                    c0510a = new C0510a(new jp.h(this.f45194n));
                } else if (this.A.equals("GCM-SIV")) {
                    this.f45202v = 12;
                    c0510a = new C0510a(new o(this.f45194n));
                } else {
                    if (!this.A.equals("GCM")) {
                        throw new NoSuchAlgorithmException("can't support mode " + str);
                    }
                    org.bouncycastle.crypto.f fVar3 = this.f45194n;
                    if (fVar3 instanceof v) {
                        this.f45202v = fVar3.c();
                        c0510a = new C0510a(new t(this.f45194n));
                    } else {
                        this.f45202v = 12;
                        c0510a = new C0510a(new n(this.f45194n));
                    }
                }
                this.f45196p = cVar;
                return;
            }
            this.f45202v = this.f45194n.c();
            if (this.A.length() != 3) {
                cVar = new c(new jp.e(this.f45194n, Integer.parseInt(this.A.substring(3))));
                this.f45196p = cVar;
                return;
            } else {
                org.bouncycastle.crypto.f fVar4 = this.f45194n;
                c0510a = new c(new jp.e(fVar4, fVar4.c() * 8));
            }
        }
        this.f45196p = c0510a;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        c cVar;
        if (this.f45194n == null) {
            throw new NoSuchPaddingException("no padding supported for this algorithm");
        }
        String strO = Strings.o(str);
        if (strO.equals("NOPADDING")) {
            if (!this.f45196p.d()) {
                return;
            } else {
                cVar = new c(new h(this.f45196p.f()));
            }
        } else if (strO.equals("WITHCTS") || strO.equals("CTSPADDING") || strO.equals("CS3PADDING")) {
            cVar = new c(new jp.f(this.f45196p.f()));
        } else {
            this.f45203w = true;
            if (c(this.A)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            }
            if (strO.equals("PKCS5PADDING") || strO.equals("PKCS7PADDING")) {
                cVar = new c(this.f45196p.f());
            } else if (strO.equals("ZEROBYTEPADDING")) {
                cVar = new c(this.f45196p.f(), new mp.h());
            } else if (strO.equals("ISO10126PADDING") || strO.equals("ISO10126-2PADDING")) {
                cVar = new c(this.f45196p.f(), new mp.b());
            } else if (strO.equals("X9.23PADDING") || strO.equals("X923PADDING")) {
                cVar = new c(this.f45196p.f(), new g());
            } else if (strO.equals("ISO7816-4PADDING") || strO.equals("ISO9797-1PADDING")) {
                cVar = new c(this.f45196p.f(), new mp.c());
            } else {
                if (!strO.equals("TBCPADDING")) {
                    throw new NoSuchPaddingException("Padding " + str + " unknown.");
                }
                cVar = new c(this.f45196p.f(), new mp.f());
            }
        }
        this.f45196p = cVar;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        if (this.f45196p.g(i11) + i12 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        try {
            return this.f45196p.e(bArr, i10, i11, bArr2, i12);
        } catch (DataLengthException e10) {
            throw new IllegalStateException(e10.toString());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        int iG = this.f45196p.g(i11);
        if (iG <= 0) {
            this.f45196p.e(bArr, i10, i11, null, 0);
            return null;
        }
        byte[] bArr2 = new byte[iG];
        int iE = this.f45196p.e(bArr, i10, i11, bArr2, 0);
        if (iE == 0) {
            return null;
        }
        if (iE == iG) {
            return bArr2;
        }
        byte[] bArr3 = new byte[iE];
        System.arraycopy(bArr2, 0, bArr3, 0, iE);
        return bArr3;
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining < 1) {
            return;
        }
        if (byteBuffer.hasArray()) {
            engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), iRemaining);
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        if (iRemaining <= 512) {
            byte[] bArr = new byte[iRemaining];
            byteBuffer.get(bArr);
            engineUpdateAAD(bArr, 0, iRemaining);
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
            return;
        }
        byte[] bArr2 = new byte[512];
        do {
            int iMin = Math.min(512, iRemaining);
            byteBuffer.get(bArr2, 0, iMin);
            engineUpdateAAD(bArr2, 0, iMin);
            iRemaining -= iMin;
        } while (iRemaining > 0);
        org.bouncycastle.util.a.d0(bArr2, (byte) 0);
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] bArr, int i10, int i11) {
        this.f45196p.j(bArr, i10, i11);
    }
}
