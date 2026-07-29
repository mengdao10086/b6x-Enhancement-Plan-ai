package hd;

import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f30966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30968c;

    public c0() {
        this.f30966a = u0.f31159f;
    }

    @g.p0
    public String A() {
        return l((char) 0);
    }

    public String B(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.f30967b;
        int i12 = (i11 + i10) - 1;
        String strK = u0.K(this.f30966a, i11, (i12 >= this.f30968c || this.f30966a[i12] != 0) ? i10 : i10 - 1);
        this.f30967b += i10;
        return strK;
    }

    public short C() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f30967b = i11 + 1;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public String D(int i10) {
        return E(i10, Charsets.UTF_8);
    }

    public String E(int i10, Charset charset) {
        String str = new String(this.f30966a, this.f30967b, i10, charset);
        this.f30967b += i10;
        return str;
    }

    public int F() {
        return (G() << 21) | (G() << 14) | (G() << 7) | G();
    }

    public int G() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        this.f30967b = i10 + 1;
        return bArr[i10] & 255;
    }

    public int H() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = (bArr[i11] & 255) | i12;
        this.f30967b = i13 + 2;
        return i14;
    }

    public long I() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        long j10 = (((long) bArr[i10]) & 255) << 24;
        int i12 = i11 + 1;
        this.f30967b = i12;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 16);
        int i13 = i12 + 1;
        this.f30967b = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 8);
        this.f30967b = i13 + 1;
        return j12 | (((long) bArr[i13]) & 255);
    }

    public int J() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = (bArr[i10] & 255) << 16;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.f30967b = i13 + 1;
        return (bArr[i13] & 255) | i14;
    }

    public int K() {
        int iO = o();
        if (iO >= 0) {
            return iO;
        }
        throw new IllegalStateException("Top bit not zero: " + iO);
    }

    public long L() {
        long jZ = z();
        if (jZ >= 0) {
            return jZ;
        }
        throw new IllegalStateException("Top bit not zero: " + jZ);
    }

    public int M() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f30967b = i11 + 1;
        return (bArr[i11] & 255) | i12;
    }

    public long N() {
        int i10;
        int i11;
        long j10 = this.f30966a[this.f30967b];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            int i13 = 1 << i12;
            if ((((long) i13) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= (long) (i13 - 1);
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j10);
        }
        for (i10 = 1; i10 < i11; i10++) {
            byte b10 = this.f30966a[this.f30967b + i10];
            if ((b10 & i1.a.f31667o7) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j10);
            }
            j10 = (j10 << 6) | ((long) (b10 & okio.w0.f44229a));
        }
        this.f30967b += i11;
        return j10;
    }

    public void O(int i10) {
        Q(b() < i10 ? new byte[i10] : this.f30966a, i10);
    }

    public void P(byte[] bArr) {
        Q(bArr, bArr.length);
    }

    public void Q(byte[] bArr, int i10) {
        this.f30966a = bArr;
        this.f30968c = i10;
        this.f30967b = 0;
    }

    public void R(int i10) {
        a.a(i10 >= 0 && i10 <= this.f30966a.length);
        this.f30968c = i10;
    }

    public void S(int i10) {
        a.a(i10 >= 0 && i10 <= this.f30968c);
        this.f30967b = i10;
    }

    public void T(int i10) {
        S(this.f30967b + i10);
    }

    public int a() {
        return this.f30968c - this.f30967b;
    }

    public int b() {
        return this.f30966a.length;
    }

    public void c(int i10) {
        if (i10 > b()) {
            this.f30966a = Arrays.copyOf(this.f30966a, i10);
        }
    }

    public byte[] d() {
        return this.f30966a;
    }

    public int e() {
        return this.f30967b;
    }

    public int f() {
        return this.f30968c;
    }

    public char g() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        return (char) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public int h() {
        return this.f30966a[this.f30967b] & 255;
    }

    public void i(b0 b0Var, int i10) {
        k(b0Var.f30961a, 0, i10);
        b0Var.q(0);
    }

    public void j(ByteBuffer byteBuffer, int i10) {
        byteBuffer.put(this.f30966a, this.f30967b, i10);
        this.f30967b += i10;
    }

    public void k(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.f30966a, this.f30967b, bArr, i10, i11);
        this.f30967b += i11;
    }

    @g.p0
    public String l(char c10) {
        if (a() == 0) {
            return null;
        }
        int i10 = this.f30967b;
        while (i10 < this.f30968c && this.f30966a[i10] != c10) {
            i10++;
        }
        byte[] bArr = this.f30966a;
        int i11 = this.f30967b;
        String strK = u0.K(bArr, i11, i10 - i11);
        this.f30967b = i10;
        if (i10 < this.f30968c) {
            this.f30967b = i10 + 1;
        }
        return strK;
    }

    public double m() {
        return Double.longBitsToDouble(z());
    }

    public float n() {
        return Float.intBitsToFloat(o());
    }

    public int o() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = (bArr[i10] & 255) << 24;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 16);
        int i15 = i13 + 1;
        this.f30967b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        this.f30967b = i15 + 1;
        return (bArr[i15] & 255) | i16;
    }

    public int p() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = ((bArr[i10] & 255) << 24) >> 8;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.f30967b = i13 + 1;
        return (bArr[i13] & 255) | i14;
    }

    @g.p0
    public String q() {
        if (a() == 0) {
            return null;
        }
        int i10 = this.f30967b;
        while (i10 < this.f30968c && !u0.F0(this.f30966a[i10])) {
            i10++;
        }
        int i11 = this.f30967b;
        if (i10 - i11 >= 3) {
            byte[] bArr = this.f30966a;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.f30967b = i11 + 3;
            }
        }
        byte[] bArr2 = this.f30966a;
        int i12 = this.f30967b;
        String strK = u0.K(bArr2, i12, i10 - i12);
        this.f30967b = i10;
        int i13 = this.f30968c;
        if (i10 == i13) {
            return strK;
        }
        byte[] bArr3 = this.f30966a;
        if (bArr3[i10] == 13) {
            int i14 = i10 + 1;
            this.f30967b = i14;
            if (i14 == i13) {
                return strK;
            }
        }
        int i15 = this.f30967b;
        if (bArr3[i15] == 10) {
            this.f30967b = i15 + 1;
        }
        return strK;
    }

    public int r() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        int i15 = i13 + 1;
        this.f30967b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.f30967b = i15 + 1;
        return ((bArr[i15] & 255) << 24) | i16;
    }

    public int s() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.f30967b = i13 + 1;
        return ((bArr[i13] & 255) << 16) | i14;
    }

    public long t() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        long j10 = ((long) bArr[i10]) & 255;
        int i12 = i11 + 1;
        this.f30967b = i12;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 8);
        int i13 = i12 + 1;
        this.f30967b = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 16);
        int i14 = i13 + 1;
        this.f30967b = i14;
        long j13 = j12 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i14 + 1;
        this.f30967b = i15;
        long j14 = j13 | ((((long) bArr[i14]) & 255) << 32);
        int i16 = i15 + 1;
        this.f30967b = i16;
        long j15 = j14 | ((((long) bArr[i15]) & 255) << 40);
        int i17 = i16 + 1;
        this.f30967b = i17;
        long j16 = j15 | ((((long) bArr[i16]) & 255) << 48);
        this.f30967b = i17 + 1;
        return j16 | ((((long) bArr[i17]) & 255) << 56);
    }

    public short u() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = bArr[i10] & 255;
        this.f30967b = i11 + 1;
        return (short) (((bArr[i11] & 255) << 8) | i12);
    }

    public long v() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        long j10 = ((long) bArr[i10]) & 255;
        int i12 = i11 + 1;
        this.f30967b = i12;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 8);
        int i13 = i12 + 1;
        this.f30967b = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 16);
        this.f30967b = i13 + 1;
        return j12 | ((((long) bArr[i13]) & 255) << 24);
    }

    public int w() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        this.f30967b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.f30967b = i13 + 1;
        return ((bArr[i13] & 255) << 16) | i14;
    }

    public int x() {
        int iR = r();
        if (iR >= 0) {
            return iR;
        }
        throw new IllegalStateException("Top bit not zero: " + iR);
    }

    public int y() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        int i12 = bArr[i10] & 255;
        this.f30967b = i11 + 1;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public long z() {
        byte[] bArr = this.f30966a;
        int i10 = this.f30967b;
        int i11 = i10 + 1;
        this.f30967b = i11;
        long j10 = (((long) bArr[i10]) & 255) << 56;
        int i12 = i11 + 1;
        this.f30967b = i12;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 48);
        int i13 = i12 + 1;
        this.f30967b = i13;
        long j12 = j11 | ((((long) bArr[i12]) & 255) << 40);
        int i14 = i13 + 1;
        this.f30967b = i14;
        long j13 = j12 | ((((long) bArr[i13]) & 255) << 32);
        int i15 = i14 + 1;
        this.f30967b = i15;
        long j14 = j13 | ((((long) bArr[i14]) & 255) << 24);
        int i16 = i15 + 1;
        this.f30967b = i16;
        long j15 = j14 | ((((long) bArr[i15]) & 255) << 16);
        int i17 = i16 + 1;
        this.f30967b = i17;
        long j16 = j15 | ((((long) bArr[i16]) & 255) << 8);
        this.f30967b = i17 + 1;
        return j16 | (((long) bArr[i17]) & 255);
    }

    public c0(int i10) {
        this.f30966a = new byte[i10];
        this.f30968c = i10;
    }

    public c0(byte[] bArr) {
        this.f30966a = bArr;
        this.f30968c = bArr.length;
    }

    public c0(byte[] bArr, int i10) {
        this.f30966a = bArr;
        this.f30968c = i10;
    }
}
