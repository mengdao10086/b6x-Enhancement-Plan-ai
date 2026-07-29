package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f21315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f21318d;

    public e(CharSequence charSequence, int i10, int i11) {
        this.f21315a = charSequence;
        this.f21317c = i10;
        this.f21316b = i11;
        byte[] bArr = new byte[i10 * i11];
        this.f21318d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final void a(int i10) {
        i(this.f21316b - 1, 0, i10, 1);
        i(this.f21316b - 1, 1, i10, 2);
        i(this.f21316b - 1, 2, i10, 3);
        i(0, this.f21317c - 2, i10, 4);
        i(0, this.f21317c - 1, i10, 5);
        i(1, this.f21317c - 1, i10, 6);
        i(2, this.f21317c - 1, i10, 7);
        i(3, this.f21317c - 1, i10, 8);
    }

    public final void b(int i10) {
        i(this.f21316b - 3, 0, i10, 1);
        i(this.f21316b - 2, 0, i10, 2);
        i(this.f21316b - 1, 0, i10, 3);
        i(0, this.f21317c - 4, i10, 4);
        i(0, this.f21317c - 3, i10, 5);
        i(0, this.f21317c - 2, i10, 6);
        i(0, this.f21317c - 1, i10, 7);
        i(1, this.f21317c - 1, i10, 8);
    }

    public final void c(int i10) {
        i(this.f21316b - 3, 0, i10, 1);
        i(this.f21316b - 2, 0, i10, 2);
        i(this.f21316b - 1, 0, i10, 3);
        i(0, this.f21317c - 2, i10, 4);
        i(0, this.f21317c - 1, i10, 5);
        i(1, this.f21317c - 1, i10, 6);
        i(2, this.f21317c - 1, i10, 7);
        i(3, this.f21317c - 1, i10, 8);
    }

    public final void d(int i10) {
        i(this.f21316b - 1, 0, i10, 1);
        i(this.f21316b - 1, this.f21317c - 1, i10, 2);
        i(0, this.f21317c - 3, i10, 3);
        i(0, this.f21317c - 2, i10, 4);
        i(0, this.f21317c - 1, i10, 5);
        i(1, this.f21317c - 3, i10, 6);
        i(1, this.f21317c - 2, i10, 7);
        i(1, this.f21317c - 1, i10, 8);
    }

    public final boolean e(int i10, int i11) {
        return this.f21318d[(i11 * this.f21317c) + i10] == 1;
    }

    public final byte[] f() {
        return this.f21318d;
    }

    public final int g() {
        return this.f21317c;
    }

    public final int h() {
        return this.f21316b;
    }

    public final void i(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            int i14 = this.f21316b;
            i10 += i14;
            i11 += 4 - ((i14 + 4) % 8);
        }
        if (i11 < 0) {
            int i15 = this.f21317c;
            i11 += i15;
            i10 += 4 - ((i15 + 4) % 8);
        }
        l(i11, i10, (this.f21315a.charAt(i12) & (1 << (8 - i13))) != 0);
    }

    public final boolean j(int i10, int i11) {
        return this.f21318d[(i11 * this.f21317c) + i10] < 0;
    }

    public final void k() {
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 0;
        int i14 = 4;
        while (true) {
            if (i14 == this.f21316b && i12 == 0) {
                a(i13);
                i13++;
            }
            if (i14 == this.f21316b - 2 && i12 == 0 && this.f21317c % 4 != 0) {
                b(i13);
                i13++;
            }
            if (i14 == this.f21316b - 2 && i12 == 0 && this.f21317c % 8 == 4) {
                c(i13);
                i13++;
            }
            if (i14 == this.f21316b + 4 && i12 == 2 && this.f21317c % 8 == 0) {
                d(i13);
                i13++;
            }
            do {
                if (i14 < this.f21316b && i12 >= 0 && j(i12, i14)) {
                    m(i14, i12, i13);
                    i13++;
                }
                i14 -= 2;
                i12 += 2;
                if (i14 < 0) {
                    break;
                }
            } while (i12 < this.f21317c);
            int i15 = i14 + 1;
            int i16 = i12 + 3;
            do {
                if (i15 >= 0 && i16 < this.f21317c && j(i16, i15)) {
                    m(i15, i16, i13);
                    i13++;
                }
                i15 += 2;
                i16 -= 2;
                i10 = this.f21316b;
                if (i15 >= i10) {
                    break;
                }
            } while (i16 >= 0);
            i14 = i15 + 3;
            i12 = i16 + 1;
            if (i14 >= i10 && i12 >= (i11 = this.f21317c)) {
                break;
            }
        }
        if (j(i11 - 1, i10 - 1)) {
            l(this.f21317c - 1, this.f21316b - 1, true);
            l(this.f21317c - 2, this.f21316b - 2, true);
        }
    }

    public final void l(int i10, int i11, boolean z10) {
        this.f21318d[(i11 * this.f21317c) + i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public final void m(int i10, int i11, int i12) {
        int i13 = i10 - 2;
        int i14 = i11 - 2;
        i(i13, i14, i12, 1);
        int i15 = i11 - 1;
        i(i13, i15, i12, 2);
        int i16 = i10 - 1;
        i(i16, i14, i12, 3);
        i(i16, i15, i12, 4);
        i(i16, i11, i12, 5);
        i(i10, i14, i12, 6);
        i(i10, i15, i12, 7);
        i(i10, i11, i12, 8);
    }
}
