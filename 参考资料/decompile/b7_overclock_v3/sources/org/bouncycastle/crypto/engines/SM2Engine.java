package org.bouncycastle.crypto.engines;

import ir.f;
import ir.h;
import ir.i;
import ir.k;
import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.j0;
import np.l0;
import np.m0;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.b;
import org.bouncycastle.util.m;
import org.bouncycastle.util.o;
import zo.k0;

/* JADX INFO: loaded from: classes5.dex */
public class SM2Engine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f44670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Mode f44671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j0 f44673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g0 f44674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f44675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f44676g;

    public enum Mode {
        C1C2C3,
        C1C3C2
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44677a;

        static {
            int[] iArr = new int[Mode.values().length];
            f44677a = iArr;
            try {
                iArr[Mode.C1C3C2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public SM2Engine() {
        this(new k0());
    }

    public SM2Engine(Mode mode) {
        this(new k0(), mode);
    }

    public SM2Engine(s sVar) {
        this(sVar, Mode.C1C2C3);
    }

    public SM2Engine(s sVar, Mode mode) {
        if (mode == null) {
            throw new IllegalArgumentException("mode cannot be NULL");
        }
        this.f44670a = sVar;
        this.f44671b = mode;
    }

    public final void a(s sVar, f fVar) {
        byte[] bArrB = b.b(this.f44675f, fVar.v());
        sVar.update(bArrB, 0, bArrB.length);
    }

    public h b() {
        return new k();
    }

    public final byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        int i12;
        int i13 = (this.f44675f * 2) + 1;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i10, bArr2, 0, i13);
        i iVarK = this.f44674e.a().k(bArr2);
        if (iVarK.z(this.f44674e.c()).v()) {
            throw new InvalidCipherTextException("[h]C1 at infinity");
        }
        i iVarB = iVarK.z(((l0) this.f44673d).e()).B();
        int iH = this.f44670a.h();
        int i14 = (i11 - i13) - iH;
        byte[] bArr3 = new byte[i14];
        Mode mode = this.f44671b;
        Mode mode2 = Mode.C1C3C2;
        if (mode == mode2) {
            System.arraycopy(bArr, i10 + i13 + iH, bArr3, 0, i14);
        } else {
            System.arraycopy(bArr, i10 + i13, bArr3, 0, i14);
        }
        g(this.f44670a, iVarB, bArr3);
        int iH2 = this.f44670a.h();
        byte[] bArr4 = new byte[iH2];
        a(this.f44670a, iVarB.f());
        this.f44670a.update(bArr3, 0, i14);
        a(this.f44670a, iVarB.g());
        this.f44670a.c(bArr4, 0);
        if (this.f44671b == mode2) {
            i12 = 0;
            for (int i15 = 0; i15 != iH2; i15++) {
                i12 |= bArr4[i15] ^ bArr[(i10 + i13) + i15];
            }
        } else {
            i12 = 0;
            for (int i16 = 0; i16 != iH2; i16++) {
                i12 |= bArr4[i16] ^ bArr[((i10 + i13) + i14) + i16];
            }
        }
        org.bouncycastle.util.a.d0(bArr2, (byte) 0);
        org.bouncycastle.util.a.d0(bArr4, (byte) 0);
        if (i12 == 0) {
            return bArr3;
        }
        org.bouncycastle.util.a.d0(bArr3, (byte) 0);
        throw new InvalidCipherTextException("invalid cipher text");
    }

    public final byte[] d(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArrL;
        i iVarB;
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        h hVarB = b();
        do {
            BigInteger bigIntegerH = h();
            bArrL = hVarB.a(this.f44674e.b(), bigIntegerH).B().l(false);
            iVarB = ((m0) this.f44673d).e().z(bigIntegerH).B();
            g(this.f44670a, iVarB, bArr2);
        } while (i(bArr2, bArr, i10));
        byte[] bArr3 = new byte[this.f44670a.h()];
        a(this.f44670a, iVarB.f());
        this.f44670a.update(bArr, i10, i11);
        a(this.f44670a, iVarB.g());
        this.f44670a.c(bArr3, 0);
        return a.f44677a[this.f44671b.ordinal()] != 1 ? org.bouncycastle.util.a.C(bArrL, bArr2, bArr3) : org.bouncycastle.util.a.C(bArrL, bArr3, bArr2);
    }

    public int e(int i10) {
        return (this.f44675f * 2) + 1 + i10 + this.f44670a.h();
    }

    public void f(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f44672c = z10;
        if (z10) {
            w1 w1Var = (w1) kVar;
            j0 j0Var = (j0) w1Var.a();
            this.f44673d = j0Var;
            this.f44674e = j0Var.d();
            if (((m0) this.f44673d).e().z(this.f44674e.c()).v()) {
                throw new IllegalArgumentException("invalid key: [h]Q at infinity");
            }
            this.f44676g = w1Var.b();
        } else {
            j0 j0Var2 = (j0) kVar;
            this.f44673d = j0Var2;
            this.f44674e = j0Var2.d();
        }
        this.f44675f = (this.f44674e.a().v() + 7) / 8;
    }

    public final void g(s sVar, i iVar, byte[] bArr) {
        m mVarD;
        int iH = sVar.h();
        byte[] bArr2 = new byte[Math.max(4, iH)];
        m mVar = null;
        if (sVar instanceof m) {
            a(sVar, iVar.f());
            a(sVar, iVar.g());
            mVar = (m) sVar;
            mVarD = mVar.d();
        } else {
            mVarD = null;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            if (mVar != null) {
                mVar.i(mVarD);
            } else {
                a(sVar, iVar.f());
                a(sVar, iVar.g());
            }
            i11++;
            o.h(i11, bArr2, 0);
            sVar.update(bArr2, 0, 4);
            sVar.c(bArr2, 0);
            int iMin = Math.min(iH, bArr.length - i10);
            k(bArr, bArr2, i10, iMin);
            i10 += iMin;
        }
    }

    public final BigInteger h() {
        int iBitLength = this.f44674e.e().bitLength();
        while (true) {
            BigInteger bigIntegerF = b.f(iBitLength, this.f44676g);
            if (!bigIntegerF.equals(b.f46032a) && bigIntegerF.compareTo(this.f44674e.e()) < 0) {
                return bigIntegerF;
            }
        }
    }

    public final boolean i(byte[] bArr, byte[] bArr2, int i10) {
        for (int i11 = 0; i11 != bArr.length; i11++) {
            if (bArr[i11] != bArr2[i10 + i11]) {
                return false;
            }
        }
        return true;
    }

    public byte[] j(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.f44672c ? d(bArr, i10, i11) : c(bArr, i10, i11);
    }

    public final void k(byte[] bArr, byte[] bArr2, int i10, int i11) {
        for (int i12 = 0; i12 != i11; i12++) {
            int i13 = i10 + i12;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i12]);
        }
    }
}
