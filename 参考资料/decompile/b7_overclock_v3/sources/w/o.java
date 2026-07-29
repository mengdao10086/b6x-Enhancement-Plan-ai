package w;

import androidx.constraintlayout.core.motion.CustomAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import w.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f53547f = "SplineSet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w.b f53548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f53549b = new int[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f53550c = new float[10];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f53552e;

    public static class a extends o {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f53553g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f53554h;

        public a(String str, long j10) {
            this.f53553g = str;
            this.f53554h = j10;
        }

        @Override // w.o
        public void h(w wVar, float f10) {
            wVar.b(wVar.e(this.f53553g), a(f10));
        }
    }

    public static class b extends o {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f53555g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public i.a f53556h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f53557i;

        public b(String str, i.a aVar) {
            this.f53555g = str.split(ag.c.f654g)[1];
            this.f53556h = aVar;
        }

        @Override // w.o
        public void g(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // w.o
        public void j(int i10) {
            int iF = this.f53556h.f();
            int iH = this.f53556h.g(0).h();
            double[] dArr = new double[iF];
            this.f53557i = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, iF, iH);
            for (int i11 = 0; i11 < iF; i11++) {
                int iD = this.f53556h.d(i11);
                CustomAttribute customAttributeG = this.f53556h.g(i11);
                dArr[i11] = ((double) iD) * 0.01d;
                customAttributeG.e(this.f53557i);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f53557i.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.f53548a = w.b.a(i10, dArr, dArr2);
        }

        public void k(int i10, CustomAttribute customAttribute) {
            this.f53556h.a(i10, customAttribute);
        }

        public void l(androidx.constraintlayout.core.state.o oVar, float f10) {
            this.f53548a.e(f10, this.f53557i);
            oVar.z(this.f53556h.g(0), this.f53557i);
        }
    }

    public static class c extends o {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f53558g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public i.b f53559h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f53560i;

        public c(String str, i.b bVar) {
            this.f53558g = str.split(ag.c.f654g)[1];
            this.f53559h = bVar;
        }

        @Override // w.o
        public void g(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // w.o
        public void h(w wVar, float f10) {
            l((t.e) wVar, f10);
        }

        @Override // w.o
        public void j(int i10) {
            int iF = this.f53559h.f();
            int iR = this.f53559h.g(0).r();
            double[] dArr = new double[iF];
            this.f53560i = new float[iR];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, iF, iR);
            for (int i11 = 0; i11 < iF; i11++) {
                int iD = this.f53559h.d(i11);
                t.a aVarG = this.f53559h.g(i11);
                dArr[i11] = ((double) iD) * 0.01d;
                aVarG.o(this.f53560i);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f53560i.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.f53548a = w.b.a(i10, dArr, dArr2);
        }

        public void k(int i10, t.a aVar) {
            this.f53559h.a(i10, aVar);
        }

        public void l(t.e eVar, float f10) {
            this.f53548a.e(f10, this.f53560i);
            this.f53559h.g(0).w(eVar, this.f53560i);
        }
    }

    public static class d {
        public static void a(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = i12 - 1;
                int i14 = iArr2[i13];
                i12 = i13 - 1;
                int i15 = iArr2[i12];
                if (i14 < i15) {
                    int iB = b(iArr, fArr, i14, i15);
                    int i16 = i12 + 1;
                    iArr2[i12] = iB - 1;
                    int i17 = i16 + 1;
                    iArr2[i16] = i14;
                    int i18 = i17 + 1;
                    iArr2[i17] = i15;
                    i12 = i18 + 1;
                    iArr2[i18] = iB + 1;
                }
            }
        }

        public static int b(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            c(iArr, fArr, i13, i11);
            return i13;
        }

        public static void c(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    public static o d(String str, i.a aVar) {
        return new b(str, aVar);
    }

    public static o e(String str, i.b bVar) {
        return new c(str, bVar);
    }

    public static o f(String str, long j10) {
        return new a(str, j10);
    }

    public float a(float f10) {
        return (float) this.f53548a.c(f10, 0);
    }

    public w.b b() {
        return this.f53548a;
    }

    public float c(float f10) {
        return (float) this.f53548a.f(f10, 0);
    }

    public void g(int i10, float f10) {
        int[] iArr = this.f53549b;
        if (iArr.length < this.f53551d + 1) {
            this.f53549b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f53550c;
            this.f53550c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f53549b;
        int i11 = this.f53551d;
        iArr2[i11] = i10;
        this.f53550c[i11] = f10;
        this.f53551d = i11 + 1;
    }

    public void h(w wVar, float f10) {
        wVar.b(v.a(this.f53552e), a(f10));
    }

    public void i(String str) {
        this.f53552e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(int r10) {
        /*
            r9 = this;
            int r0 = r9.f53551d
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r9.f53549b
            float[] r2 = r9.f53550c
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            w.o.d.a(r1, r2, r4, r0)
            r0 = 1
            r1 = 1
        L11:
            int r2 = r9.f53551d
            if (r0 >= r2) goto L24
            int[] r2 = r9.f53549b
            int r5 = r0 + (-1)
            r5 = r2[r5]
            r2 = r2[r0]
            if (r5 == r2) goto L21
            int r1 = r1 + 1
        L21:
            int r0 = r0 + 1
            goto L11
        L24:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r2 = new int[r2]
            r2[r3] = r3
            r2[r4] = r1
            java.lang.Class<double> r1 = double.class
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            double[][] r1 = (double[][]) r1
            r2 = 0
            r3 = 0
        L37:
            int r5 = r9.f53551d
            if (r2 >= r5) goto L64
            if (r2 <= 0) goto L48
            int[] r5 = r9.f53549b
            r6 = r5[r2]
            int r7 = r2 + (-1)
            r5 = r5[r7]
            if (r6 != r5) goto L48
            goto L61
        L48:
            int[] r5 = r9.f53549b
            r5 = r5[r2]
            double r5 = (double) r5
            r7 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r5 = r5 * r7
            r0[r3] = r5
            r5 = r1[r3]
            float[] r6 = r9.f53550c
            r6 = r6[r2]
            double r6 = (double) r6
            r5[r4] = r6
            int r3 = r3 + 1
        L61:
            int r2 = r2 + 1
            goto L37
        L64:
            w.b r10 = w.b.a(r10, r0, r1)
            r9.f53548a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w.o.j(int):void");
    }

    public String toString() {
        String str = this.f53552e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f53551d; i10++) {
            str = str + "[" + this.f53549b[i10] + " , " + decimalFormat.format(this.f53550c[i10]) + "] ";
        }
        return str;
    }
}
