package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public interface t {

    public static class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Random f18436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f18437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f18438c;

        public a(int i10) {
            this(i10, new Random());
        }

        public static int[] h(int i10, Random random) {
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                int iNextInt = random.nextInt(i12);
                iArr[i11] = iArr[iNextInt];
                iArr[iNextInt] = i11;
                i11 = i12;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.t
        public t a(int i10, int i11) {
            int i12 = i11 - i10;
            int[] iArr = new int[this.f18437b.length - i12];
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int[] iArr2 = this.f18437b;
                if (i13 >= iArr2.length) {
                    return new a(iArr, new Random(this.f18436a.nextLong()));
                }
                if (iArr2[i13] < i10 || iArr2[i13] >= i11) {
                    iArr[i13 - i14] = iArr2[i13] >= i10 ? iArr2[i13] - i12 : iArr2[i13];
                } else {
                    i14++;
                }
                i13++;
            }
        }

        @Override // com.google.android.exoplayer2.source.t
        public int b() {
            int[] iArr = this.f18437b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public int c(int i10) {
            int i11 = this.f18438c[i10] - 1;
            if (i11 >= 0) {
                return this.f18437b[i11];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public int d(int i10) {
            int i11 = this.f18438c[i10] + 1;
            int[] iArr = this.f18437b;
            if (i11 < iArr.length) {
                return iArr[i11];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public t e(int i10, int i11) {
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int i12 = 0;
            int i13 = 0;
            while (i13 < i11) {
                iArr[i13] = this.f18436a.nextInt(this.f18437b.length + 1);
                int i14 = i13 + 1;
                int iNextInt = this.f18436a.nextInt(i14);
                iArr2[i13] = iArr2[iNextInt];
                iArr2[iNextInt] = i13 + i10;
                i13 = i14;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f18437b.length + i11];
            int i15 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f18437b;
                if (i12 >= iArr4.length + i11) {
                    return new a(iArr3, new Random(this.f18436a.nextLong()));
                }
                if (i15 >= i11 || i16 != iArr[i15]) {
                    int i17 = i16 + 1;
                    iArr3[i12] = iArr4[i16];
                    if (iArr3[i12] >= i10) {
                        iArr3[i12] = iArr3[i12] + i11;
                    }
                    i16 = i17;
                } else {
                    iArr3[i12] = iArr2[i15];
                    i15++;
                }
                i12++;
            }
        }

        @Override // com.google.android.exoplayer2.source.t
        public int f() {
            int[] iArr = this.f18437b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public t g() {
            return new a(0, new Random(this.f18436a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.t
        public int getLength() {
            return this.f18437b.length;
        }

        public a(int i10, long j10) {
            this(i10, new Random(j10));
        }

        public a(int[] iArr, long j10) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j10));
        }

        public a(int i10, Random random) {
            this(h(i10, random), random);
        }

        public a(int[] iArr, Random random) {
            this.f18437b = iArr;
            this.f18436a = random;
            this.f18438c = new int[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                this.f18438c[iArr[i10]] = i10;
            }
        }
    }

    public static final class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18439a;

        public b(int i10) {
            this.f18439a = i10;
        }

        @Override // com.google.android.exoplayer2.source.t
        public t a(int i10, int i11) {
            return new b((this.f18439a - i11) + i10);
        }

        @Override // com.google.android.exoplayer2.source.t
        public int b() {
            return this.f18439a > 0 ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public int c(int i10) {
            int i11 = i10 - 1;
            if (i11 >= 0) {
                return i11;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public int d(int i10) {
            int i11 = i10 + 1;
            if (i11 < this.f18439a) {
                return i11;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public t e(int i10, int i11) {
            return new b(this.f18439a + i11);
        }

        @Override // com.google.android.exoplayer2.source.t
        public int f() {
            int i10 = this.f18439a;
            if (i10 > 0) {
                return i10 - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.t
        public t g() {
            return new b(0);
        }

        @Override // com.google.android.exoplayer2.source.t
        public int getLength() {
            return this.f18439a;
        }
    }

    t a(int i10, int i11);

    int b();

    int c(int i10);

    int d(int i10);

    t e(int i10, int i11);

    int f();

    t g();

    int getLength();
}
