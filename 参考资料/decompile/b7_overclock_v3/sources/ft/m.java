package ft;

import android.support.v4.media.session.PlaybackStateCompat;
import com.blankj.utilcode.util.i0;
import com.google.common.math.DoubleUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import lr.a1;
import lr.a2;
import lr.e2;
import lr.g1;
import lr.k2;
import lr.u1;

/* JADX INFO: loaded from: classes6.dex */
public class m extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f28780f = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, PlaybackStateCompat.C, PlaybackStateCompat.D, 262144, PlaybackStateCompat.K0, 1048576, 2097152, 4194304, pp.l.f46971i, dm.e.B, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, DoubleUtils.IMPLICIT_BIT, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, kotlinx.coroutines.internal.x.f38853p, kotlinx.coroutines.internal.x.f38855r, 4611686018427387904L, Long.MIN_VALUE};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f28781g = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, dm.g.f26388t, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, k2.f40271a, or.b.f44439a, e2.f40194a, 268435455, 536870911, kotlinx.coroutines.internal.x.f38849l, 2147483647L, 4294967295L, 8589934591L, 17179869183L, g1.f40213a, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, u1.f40382a, 4398046511103L, 8796093022207L, a1.f40140b, 35184372088831L, 70368744177663L, a2.f40142a, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, DoubleUtils.SIGNIFICAND_MASK, 9007199254740991L, 18014398509481983L, g1.f40214b, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Long.MAX_VALUE, -1};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f28782h = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f28783i = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f28784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f28786e;

    public m(m mVar) {
        l lVar = mVar.f28773a;
        this.f28773a = lVar;
        this.f28774b = lVar.d();
        this.f28784c = ((n) this.f28773a).l();
        this.f28785d = ((n) this.f28773a).k();
        this.f28786e = new long[this.f28784c];
        D(mVar.E());
    }

    public m(n nVar, BigInteger bigInteger) {
        this.f28773a = nVar;
        this.f28774b = nVar.d();
        this.f28784c = nVar.l();
        this.f28785d = nVar.k();
        this.f28786e = new long[this.f28784c];
        B(bigInteger);
    }

    public m(n nVar, SecureRandom secureRandom) {
        this.f28773a = nVar;
        this.f28774b = nVar.d();
        this.f28784c = nVar.l();
        this.f28785d = nVar.k();
        int i10 = this.f28784c;
        long[] jArr = new long[i10];
        this.f28786e = jArr;
        if (i10 <= 1) {
            jArr[0] = secureRandom.nextLong();
            long[] jArr2 = this.f28786e;
            jArr2[0] = jArr2[0] >>> (64 - this.f28785d);
        } else {
            for (int i11 = 0; i11 < this.f28784c - 1; i11++) {
                this.f28786e[i11] = secureRandom.nextLong();
            }
            this.f28786e[this.f28784c - 1] = secureRandom.nextLong() >>> (64 - this.f28785d);
        }
    }

    public m(n nVar, byte[] bArr) {
        this.f28773a = nVar;
        this.f28774b = nVar.d();
        this.f28784c = nVar.l();
        this.f28785d = nVar.k();
        this.f28786e = new long[this.f28784c];
        C(bArr);
    }

    public m(n nVar, long[] jArr) {
        this.f28773a = nVar;
        this.f28774b = nVar.d();
        this.f28784c = nVar.l();
        this.f28785d = nVar.k();
        this.f28786e = jArr;
    }

    public static m A(n nVar) {
        return new m(nVar, new long[nVar.l()]);
    }

    public static m z(n nVar) {
        int iL = nVar.l();
        long[] jArr = new long[iL];
        int i10 = 0;
        while (true) {
            int i11 = iL - 1;
            if (i10 >= i11) {
                jArr[i11] = f28781g[nVar.k() - 1];
                return new m(nVar, jArr);
            }
            jArr[i10] = -1;
            i10++;
        }
    }

    public final void B(BigInteger bigInteger) {
        C(bigInteger.toByteArray());
    }

    public final void C(byte[] bArr) {
        this.f28786e = new long[this.f28784c];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            long[] jArr = this.f28786e;
            int i11 = i10 >>> 3;
            jArr[i11] = jArr[i11] | ((((long) bArr[(bArr.length - 1) - i10]) & 255) << ((i10 & 7) << 3));
        }
    }

    public final void D(long[] jArr) {
        System.arraycopy(jArr, 0, this.f28786e, 0, this.f28784c);
    }

    public final long[] E() {
        long[] jArr = this.f28786e;
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    public final long[] F() {
        long[] jArr = new long[this.f28786e.length];
        int i10 = 0;
        while (true) {
            if (i10 >= this.f28774b) {
                return jArr;
            }
            if (w((r2 - i10) - 1)) {
                int i11 = i10 >>> 6;
                jArr[i11] = jArr[i11] | f28780f[i10 & 63];
            }
            i10++;
        }
    }

    public void G() throws ArithmeticException {
        if (e()) {
            throw new ArithmeticException();
        }
        int i10 = 31;
        boolean z10 = false;
        while (!z10 && i10 >= 0) {
            if ((((long) (this.f28774b - 1)) & f28780f[i10]) != 0) {
                z10 = true;
            }
            i10--;
        }
        A((n) this.f28773a);
        m mVar = new m(this);
        int i11 = 1;
        for (int i12 = (i10 + 1) - 1; i12 >= 0; i12--) {
            k kVar = (k) mVar.clone();
            for (int i13 = 1; i13 <= i11; i13++) {
                kVar.v();
            }
            mVar.a(kVar);
            i11 <<= 1;
            if ((((long) (this.f28774b - 1)) & f28780f[i12]) != 0) {
                mVar.v();
                mVar.a(this);
                i11++;
            }
        }
        mVar.v();
    }

    public void H() {
        this.f28786e = F();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[PHI: r15
  0x0096: PHI (r15v2 boolean) = (r15v1 boolean), (r15v4 boolean) binds: [B:16:0x0065, B:21:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // ft.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(ft.r r27) throws java.lang.RuntimeException {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ft.m.a(ft.r):void");
    }

    @Override // ft.r
    public r b(r rVar) throws RuntimeException {
        m mVar = new m(this);
        mVar.a(rVar);
        return mVar;
    }

    @Override // ft.k, ft.r
    public Object clone() {
        return new m(this);
    }

    @Override // ft.r
    public r d(r rVar) throws RuntimeException {
        m mVar = new m(this);
        mVar.k(rVar);
        return mVar;
    }

    @Override // ft.r
    public boolean e() {
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f28784c && z10; i10++) {
            z10 = z10 && (this.f28786e[i10] & (-1)) == 0;
        }
        return z10;
    }

    @Override // ft.r
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        for (int i10 = 0; i10 < this.f28784c; i10++) {
            if (this.f28786e[i10] != mVar.f28786e[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // ft.r
    public r f() throws ArithmeticException {
        m mVar = new m(this);
        mVar.G();
        return mVar;
    }

    @Override // ft.r
    public boolean g() {
        int i10;
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = true;
        while (true) {
            i10 = this.f28784c;
            if (i11 >= i10 - 1 || !z11) {
                break;
            }
            z11 = z11 && (this.f28786e[i11] & (-1)) == -1;
            i11++;
        }
        if (!z11) {
            return z11;
        }
        if (z11) {
            long j10 = this.f28786e[i10 - 1];
            long[] jArr = f28781g;
            int i12 = this.f28785d;
            if ((j10 & jArr[i12 - 1]) == jArr[i12 - 1]) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // ft.r
    public int hashCode() {
        return org.bouncycastle.util.a.x0(this.f28786e);
    }

    @Override // ft.r
    public String i(int i10) {
        StringBuilder sb2;
        long[] jArrE = E();
        int i11 = this.f28785d;
        String string = "";
        if (i10 == 2) {
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                }
                string = (jArrE[jArrE.length - 1] & (1 << i11)) == 0 ? string + "0" : string + "1";
            }
            for (int length = jArrE.length - 2; length >= 0; length--) {
                for (int i12 = 63; i12 >= 0; i12--) {
                    if ((jArrE[length] & f28780f[i12]) == 0) {
                        sb2 = new StringBuilder();
                        sb2.append(string);
                        sb2.append("0");
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(string);
                        sb2.append("1");
                    }
                    string = sb2.toString();
                }
            }
        } else if (i10 == 16) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int length2 = jArrE.length - 1; length2 >= 0; length2--) {
                string = ((((((((((((((((string + cArr[((int) (jArrE[length2] >>> 60)) & 15]) + cArr[((int) (jArrE[length2] >>> 56)) & 15]) + cArr[((int) (jArrE[length2] >>> 52)) & 15]) + cArr[((int) (jArrE[length2] >>> 48)) & 15]) + cArr[((int) (jArrE[length2] >>> 44)) & 15]) + cArr[((int) (jArrE[length2] >>> 40)) & 15]) + cArr[((int) (jArrE[length2] >>> 36)) & 15]) + cArr[((int) (jArrE[length2] >>> 32)) & 15]) + cArr[((int) (jArrE[length2] >>> 28)) & 15]) + cArr[((int) (jArrE[length2] >>> 24)) & 15]) + cArr[((int) (jArrE[length2] >>> 20)) & 15]) + cArr[((int) (jArrE[length2] >>> 16)) & 15]) + cArr[((int) (jArrE[length2] >>> 12)) & 15]) + cArr[((int) (jArrE[length2] >>> 8)) & 15]) + cArr[((int) (jArrE[length2] >>> 4)) & 15]) + cArr[((int) jArrE[length2]) & 15]) + i0.f11861z;
            }
        }
        return string;
    }

    @Override // ft.r
    public BigInteger j() {
        return new BigInteger(1, toByteArray());
    }

    @Override // ft.r
    public void k(r rVar) throws RuntimeException {
        if (!(rVar instanceof m)) {
            throw new RuntimeException();
        }
        m mVar = (m) rVar;
        if (!this.f28773a.equals(mVar.f28773a)) {
            throw new RuntimeException();
        }
        for (int i10 = 0; i10 < this.f28784c; i10++) {
            long[] jArr = this.f28786e;
            jArr[i10] = jArr[i10] ^ mVar.f28786e[i10];
        }
    }

    @Override // ft.k
    public void l() {
        int i10 = 0;
        while (true) {
            int i11 = this.f28784c;
            if (i10 >= i11 - 1) {
                this.f28786e[i11 - 1] = f28781g[this.f28785d - 1];
                return;
            } else {
                this.f28786e[i10] = -1;
                i10++;
            }
        }
    }

    @Override // ft.k
    public void m() {
        this.f28786e = new long[this.f28784c];
    }

    @Override // ft.k
    public k p() {
        m mVar = new m(this);
        mVar.q();
        return mVar;
    }

    @Override // ft.k
    public void q() {
        k(z((n) this.f28773a));
    }

    @Override // ft.k
    public k r() throws RuntimeException {
        int i10;
        if (y() == 1) {
            throw new RuntimeException();
        }
        long j10 = f28780f[63];
        long[] jArr = new long[this.f28784c];
        int i11 = 0;
        long j11 = 0;
        while (true) {
            i10 = this.f28784c;
            if (i11 >= i10 - 1) {
                break;
            }
            for (int i12 = 1; i12 < 64; i12++) {
                long[] jArr2 = f28780f;
                long j12 = jArr2[i12];
                long[] jArr3 = this.f28786e;
                if (((j12 & jArr3[i11]) == 0 || (jArr2[i12 - 1] & j11) == 0) && ((jArr3[i11] & jArr2[i12]) != 0 || (jArr2[i12 - 1] & j11) != 0)) {
                    j11 ^= jArr2[i12];
                }
            }
            jArr[i11] = j11;
            long j13 = j11 & j10;
            j11 = ((j13 == 0 || (1 & this.f28786e[i11 + 1]) != 1) && !(j13 == 0 && (this.f28786e[i11 + 1] & 1) == 0)) ? 1L : 0L;
            i11++;
        }
        int i13 = this.f28774b & 63;
        long j14 = this.f28786e[i10 - 1];
        for (int i14 = 1; i14 < i13; i14++) {
            long[] jArr4 = f28780f;
            if (((jArr4[i14] & j14) == 0 || (jArr4[i14 - 1] & j11) == 0) && ((jArr4[i14] & j14) != 0 || (jArr4[i14 - 1] & j11) != 0)) {
                j11 ^= jArr4[i14];
            }
        }
        jArr[this.f28784c - 1] = j11;
        return new m((n) this.f28773a, jArr);
    }

    @Override // ft.k
    public k s() {
        m mVar = new m(this);
        mVar.v();
        return mVar;
    }

    @Override // ft.k
    public k t() {
        m mVar = new m(this);
        mVar.u();
        return mVar;
    }

    @Override // ft.r
    public byte[] toByteArray() {
        int i10 = ((this.f28774b - 1) >> 3) + 1;
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = (i11 & 7) << 3;
            bArr[(i10 - i11) - 1] = (byte) ((this.f28786e[i11 >>> 3] & (255 << i12)) >>> i12);
        }
        return bArr;
    }

    @Override // ft.r
    public String toString() {
        return i(16);
    }

    @Override // ft.k
    public void u() {
        long[] jArrE = E();
        int i10 = this.f28784c - 1;
        int i11 = this.f28785d - 1;
        long j10 = f28780f[63];
        boolean z10 = (jArrE[0] & 1) != 0;
        int i12 = i10;
        while (i12 >= 0) {
            boolean z11 = (jArrE[i12] & 1) != 0;
            jArrE[i12] = jArrE[i12] >>> 1;
            if (z10) {
                if (i12 == i10) {
                    jArrE[i12] = jArrE[i12] ^ f28780f[i11];
                } else {
                    jArrE[i12] = jArrE[i12] ^ j10;
                }
            }
            i12--;
            z10 = z11;
        }
        D(jArrE);
    }

    @Override // ft.k
    public void v() {
        long[] jArrE = E();
        int i10 = this.f28784c - 1;
        int i11 = this.f28785d - 1;
        long[] jArr = f28780f;
        long j10 = jArr[63];
        boolean z10 = (jArrE[i10] & jArr[i11]) != 0;
        int i12 = 0;
        while (i12 < i10) {
            boolean z11 = (jArrE[i12] & j10) != 0;
            jArrE[i12] = jArrE[i12] << 1;
            if (z10) {
                jArrE[i12] = 1 ^ jArrE[i12];
            }
            i12++;
            z10 = z11;
        }
        long j11 = jArrE[i10];
        long[] jArr2 = f28780f;
        boolean z12 = (j11 & jArr2[i11]) != 0;
        jArrE[i10] = jArrE[i10] << 1;
        if (z10) {
            jArrE[i10] = jArrE[i10] ^ 1;
        }
        if (z12) {
            jArrE[i10] = jArr2[i11 + 1] ^ jArrE[i10];
        }
        D(jArrE);
    }

    @Override // ft.k
    public boolean w(int i10) {
        return i10 >= 0 && i10 <= this.f28774b && (this.f28786e[i10 >>> 6] & f28780f[i10 & 63]) != 0;
    }

    @Override // ft.k
    public boolean x() {
        return (this.f28786e[this.f28784c - 1] & f28780f[this.f28785d - 1]) != 0;
    }

    @Override // ft.k
    public int y() {
        int i10 = this.f28784c - 1;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            for (int i13 = 0; i13 < 64; i13++) {
                if ((this.f28786e[i12] & f28780f[i13]) != 0) {
                    i11 ^= 1;
                }
            }
        }
        int i14 = this.f28785d;
        for (int i15 = 0; i15 < i14; i15++) {
            if ((this.f28786e[i10] & f28780f[i15]) != 0) {
                i11 ^= 1;
            }
        }
        return i11;
    }
}
