package ma;

import android.annotation.TargetApi;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: ma.a$a, reason: collision with other inner class name */
    public class C0453a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f40970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f40971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f40972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f40973d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f40974e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f40975f;

        public C0453a(float f10, float f11, float f12, float f13) {
            this.f40973d = f10 - f12;
            this.f40974e = f11 - f13;
            this.f40971b = f10 * f13;
            this.f40972c = f12 * f11;
            this.f40975f = (float) Math.sqrt((r3 * r3) + (r0 * r0));
            this.f40970a = new float[]{f10, f11, f12, f13};
        }

        public float a(float f10, float f11) {
            return Math.abs((((this.f40974e * f10) - (this.f40973d * f11)) + this.f40971b) - this.f40972c) / this.f40975f;
        }

        public float[] b() {
            return this.f40970a;
        }
    }

    public float[] a(float[]... fArr) {
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int i10 = 0;
        for (float[] fArr4 : fArr) {
            for (float f10 : fArr4) {
                fArr3[i10] = f10;
                i10++;
            }
        }
        return fArr3;
    }

    @TargetApi(9)
    public float[] b(float[] fArr, float f10) {
        C0453a c0453a = new C0453a(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1]);
        float f11 = 0.0f;
        int i10 = 0;
        for (int i11 = 2; i11 < fArr.length - 2; i11 += 2) {
            float fA = c0453a.a(fArr[i11], fArr[i11 + 1]);
            if (fA > f11) {
                i10 = i11;
                f11 = fA;
            }
        }
        if (f11 <= f10) {
            return c0453a.b();
        }
        float[] fArrB = b(Arrays.copyOfRange(fArr, 0, i10 + 2), f10);
        float[] fArrB2 = b(Arrays.copyOfRange(fArr, i10, fArr.length), f10);
        return a(fArrB, Arrays.copyOfRange(fArrB2, 2, fArrB2.length));
    }
}
