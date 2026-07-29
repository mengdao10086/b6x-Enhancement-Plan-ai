package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import ft.w;
import g.j;
import g.p0;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f17539g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17540h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17541i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17542j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17543k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f17544l = new a(null, new long[0], null, 0, g.f56663b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Object f17545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f17547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0181a[] f17548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17550f;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.ads.a$a, reason: collision with other inner class name */
    public static final class C0181a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri[] f17552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f17553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f17554d;

        public C0181a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        @j
        public static long[] a(long[] jArr, int i10) {
            int length = jArr.length;
            int iMax = Math.max(i10, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, g.f56663b);
            return jArrCopyOf;
        }

        @j
        public static int[] b(int[] iArr, int i10) {
            int length = iArr.length;
            int iMax = Math.max(i10, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public int c() {
            return d(-1);
        }

        public int d(int i10) {
            int i11 = i10 + 1;
            while (true) {
                int[] iArr = this.f17553c;
                if (i11 >= iArr.length || iArr[i11] == 0 || iArr[i11] == 1) {
                    break;
                }
                i11++;
            }
            return i11;
        }

        public boolean e() {
            return this.f17551a == -1 || c() < this.f17551a;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0181a.class != obj.getClass()) {
                return false;
            }
            C0181a c0181a = (C0181a) obj;
            return this.f17551a == c0181a.f17551a && Arrays.equals(this.f17552b, c0181a.f17552b) && Arrays.equals(this.f17553c, c0181a.f17553c) && Arrays.equals(this.f17554d, c0181a.f17554d);
        }

        @j
        public C0181a f(int i10) {
            return new C0181a(i10, b(this.f17553c, i10), (Uri[]) Arrays.copyOf(this.f17552b, i10), a(this.f17554d, i10));
        }

        @j
        public C0181a g(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.f17552b;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            } else if (this.f17551a != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new C0181a(this.f17551a, this.f17553c, this.f17552b, jArr);
        }

        @j
        public C0181a h(int i10, int i11) {
            int i12 = this.f17551a;
            hd.a.a(i12 == -1 || i11 < i12);
            int[] iArrB = b(this.f17553c, i11 + 1);
            hd.a.a(iArrB[i11] == 0 || iArrB[i11] == 1 || iArrB[i11] == i10);
            long[] jArrA = this.f17554d;
            if (jArrA.length != iArrB.length) {
                jArrA = a(jArrA, iArrB.length);
            }
            Uri[] uriArr = this.f17552b;
            if (uriArr.length != iArrB.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, iArrB.length);
            }
            iArrB[i11] = i10;
            return new C0181a(this.f17551a, iArrB, uriArr, jArrA);
        }

        public int hashCode() {
            return (((((this.f17551a * 31) + Arrays.hashCode(this.f17552b)) * 31) + Arrays.hashCode(this.f17553c)) * 31) + Arrays.hashCode(this.f17554d);
        }

        @j
        public C0181a i(Uri uri, int i10) {
            int[] iArrB = b(this.f17553c, i10 + 1);
            long[] jArrA = this.f17554d;
            if (jArrA.length != iArrB.length) {
                jArrA = a(jArrA, iArrB.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.f17552b, iArrB.length);
            uriArr[i10] = uri;
            iArrB[i10] = 1;
            return new C0181a(this.f17551a, iArrB, uriArr, jArrA);
        }

        @j
        public C0181a j() {
            if (this.f17551a == -1) {
                return new C0181a(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.f17553c;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int i10 = 0; i10 < length; i10++) {
                if (iArrCopyOf[i10] == 1 || iArrCopyOf[i10] == 0) {
                    iArrCopyOf[i10] = 2;
                }
            }
            return new C0181a(length, iArrCopyOf, this.f17552b, this.f17554d);
        }

        public C0181a(int i10, int[] iArr, Uri[] uriArr, long[] jArr) {
            hd.a.a(iArr.length == uriArr.length);
            this.f17551a = i10;
            this.f17553c = iArr;
            this.f17552b = uriArr;
            this.f17554d = jArr;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public a(Object obj, long... jArr) {
        this(obj, jArr, null, 0L, g.f56663b);
    }

    public int a(long j10, long j11) {
        if (j10 == Long.MIN_VALUE) {
            return -1;
        }
        if (j11 != g.f56663b && j10 >= j11) {
            return -1;
        }
        int i10 = 0;
        while (true) {
            long[] jArr = this.f17547c;
            if (i10 >= jArr.length || jArr[i10] == Long.MIN_VALUE || (j10 < jArr[i10] && this.f17548d[i10].e())) {
                break;
            }
            i10++;
        }
        if (i10 < this.f17547c.length) {
            return i10;
        }
        return -1;
    }

    public int b(long j10, long j11) {
        int length = this.f17547c.length - 1;
        while (length >= 0 && d(j10, j11, length)) {
            length--;
        }
        if (length < 0 || !this.f17548d[length].e()) {
            return -1;
        }
        return length;
    }

    public boolean c(int i10, int i11) {
        C0181a c0181a;
        int i12;
        C0181a[] c0181aArr = this.f17548d;
        return i10 < c0181aArr.length && (i12 = (c0181a = c0181aArr[i10]).f17551a) != -1 && i11 < i12 && c0181a.f17553c[i11] == 4;
    }

    public final boolean d(long j10, long j11, int i10) {
        if (j10 == Long.MIN_VALUE) {
            return false;
        }
        long j12 = this.f17547c[i10];
        return j12 == Long.MIN_VALUE ? j11 == g.f56663b || j10 < j11 : j10 < j12;
    }

    @j
    public a e(int i10, int i11) {
        hd.a.a(i11 > 0);
        C0181a[] c0181aArr = this.f17548d;
        if (c0181aArr[i10].f17551a == i11) {
            return this;
        }
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        c0181aArr2[i10] = this.f17548d[i10].f(i11);
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return u0.c(this.f17545a, aVar.f17545a) && this.f17546b == aVar.f17546b && this.f17549e == aVar.f17549e && this.f17550f == aVar.f17550f && Arrays.equals(this.f17547c, aVar.f17547c) && Arrays.equals(this.f17548d, aVar.f17548d);
    }

    @j
    public a f(long[][] jArr) {
        C0181a[] c0181aArr = this.f17548d;
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        for (int i10 = 0; i10 < this.f17546b; i10++) {
            c0181aArr2[i10] = c0181aArr2[i10].g(jArr[i10]);
        }
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    @j
    public a g(int i10, int i11) {
        C0181a[] c0181aArr = this.f17548d;
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        c0181aArr2[i10] = c0181aArr2[i10].h(4, i11);
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    @j
    public a h(long j10) {
        return this.f17549e == j10 ? this : new a(this.f17545a, this.f17547c, this.f17548d, j10, this.f17550f);
    }

    public int hashCode() {
        int i10 = this.f17546b * 31;
        Object obj = this.f17545a;
        return ((((((((i10 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f17549e)) * 31) + ((int) this.f17550f)) * 31) + Arrays.hashCode(this.f17547c)) * 31) + Arrays.hashCode(this.f17548d);
    }

    @j
    public a i(int i10, int i11, Uri uri) {
        C0181a[] c0181aArr = this.f17548d;
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        c0181aArr2[i10] = c0181aArr2[i10].i(uri, i11);
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    @j
    public a j(long j10) {
        return this.f17550f == j10 ? this : new a(this.f17545a, this.f17547c, this.f17548d, this.f17549e, j10);
    }

    @j
    public a k(int i10, int i11) {
        C0181a[] c0181aArr = this.f17548d;
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        c0181aArr2[i10] = c0181aArr2[i10].h(3, i11);
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    @j
    public a l(int i10, int i11) {
        C0181a[] c0181aArr = this.f17548d;
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        c0181aArr2[i10] = c0181aArr2[i10].h(2, i11);
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    @j
    public a m(int i10) {
        C0181a[] c0181aArr = this.f17548d;
        C0181a[] c0181aArr2 = (C0181a[]) u0.V0(c0181aArr, c0181aArr.length);
        c0181aArr2[i10] = c0181aArr2[i10].j();
        return new a(this.f17545a, this.f17547c, c0181aArr2, this.f17549e, this.f17550f);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f17545a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f17549e);
        sb2.append(", adGroups=[");
        for (int i10 = 0; i10 < this.f17548d.length; i10++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f17547c[i10]);
            sb2.append(", ads=[");
            for (int i11 = 0; i11 < this.f17548d[i10].f17553c.length; i11++) {
                sb2.append("ad(state=");
                int i12 = this.f17548d[i10].f17553c[i11];
                if (i12 == 0) {
                    sb2.append('_');
                } else if (i12 == 1) {
                    sb2.append(w.f28818g);
                } else if (i12 == 2) {
                    sb2.append('S');
                } else if (i12 == 3) {
                    sb2.append('P');
                } else if (i12 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append(PublicSuffixDatabase.f43873i);
                }
                sb2.append(", durationUs=");
                sb2.append(this.f17548d[i10].f17554d[i11]);
                sb2.append(')');
                if (i11 < this.f17548d[i10].f17553c.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i10 < this.f17548d.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }

    public a(@p0 Object obj, long[] jArr, @p0 C0181a[] c0181aArr, long j10, long j11) {
        this.f17545a = obj;
        this.f17547c = jArr;
        this.f17549e = j10;
        this.f17550f = j11;
        int length = jArr.length;
        this.f17546b = length;
        if (c0181aArr == null) {
            c0181aArr = new C0181a[length];
            for (int i10 = 0; i10 < this.f17546b; i10++) {
                c0181aArr[i10] = new C0181a();
            }
        }
        this.f17548d = c0181aArr;
    }
}
