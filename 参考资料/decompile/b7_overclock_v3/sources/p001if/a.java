package p001if;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.q;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f32342g = 0.2f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f32343h = 0.45f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f32344i = 0.7916667f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f32345j = 0.89285713f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f32347b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f32350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f32351f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f32346a = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f32348c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f32349d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f32347b = iArr;
        this.f32350e = new int[iArr.length / 2];
        this.f32351f = new int[iArr.length / 2];
    }

    @Deprecated
    public static int h(int[] iArr) {
        return bf.a.d(iArr);
    }

    public static void i(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (fArr[i11] < f10) {
                f10 = fArr[i11];
                i10 = i11;
            }
        }
        iArr[i10] = iArr[i10] - 1;
    }

    public static void p(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (fArr[i11] > f10) {
                f10 = fArr[i11];
                i10 = i11;
            }
        }
        iArr[i10] = iArr[i10] + 1;
    }

    public static boolean q(int[] iArr) {
        float f10 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f10 < 0.7916667f || f10 > 0.89285713f) {
            return false;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 : iArr) {
            if (i12 > i11) {
                i11 = i12;
            }
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return i11 < i10 * 10;
    }

    public static int r(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            if (q.e(iArr, iArr2[i10], 0.45f) < 0.2f) {
                return i10;
            }
        }
        throw NotFoundException.b();
    }

    public final int[] j() {
        return this.f32347b;
    }

    public final int[] k() {
        return this.f32346a;
    }

    public final int[] l() {
        return this.f32351f;
    }

    public final float[] m() {
        return this.f32349d;
    }

    public final int[] n() {
        return this.f32350e;
    }

    public final float[] o() {
        return this.f32348c;
    }
}
