package w;

import androidx.constraintlayout.core.motion.CustomAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import w.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f53591k = "SplineSet";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f53592l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f53593m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f53594n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static float f53595o = 6.2831855f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w.b f53596a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f53600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53601f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f53604i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53597b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f53598c = new int[10];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[][] f53599d = (float[][]) Array.newInstance((Class<?>) float.class, 10, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f53602g = new float[3];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f53603h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f53605j = Float.NaN;

    public static class a extends t {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f53606p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public i.a f53607q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public i.c f53608r = new i.c();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float[] f53609s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float[] f53610t;

        public a(String str, i.a aVar) {
            this.f53606p = str.split(ag.c.f654g)[1];
            this.f53607q = aVar;
        }

        @Override // w.t
        public void c(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // w.t
        public void f(int i10) {
            int iF = this.f53607q.f();
            int iH = this.f53607q.g(0).h();
            double[] dArr = new double[iF];
            int i11 = iH + 2;
            this.f53609s = new float[i11];
            this.f53610t = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, iF, i11);
            for (int i12 = 0; i12 < iF; i12++) {
                int iD = this.f53607q.d(i12);
                CustomAttribute customAttributeG = this.f53607q.g(i12);
                float[] fArrG = this.f53608r.g(i12);
                dArr[i12] = ((double) iD) * 0.01d;
                customAttributeG.e(this.f53609s);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f53609s.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                dArr2[i12][iH] = fArrG[0];
                dArr2[i12][iH + 1] = fArrG[1];
            }
            this.f53596a = w.b.a(i10, dArr, dArr2);
        }

        public void g(int i10, CustomAttribute customAttribute, float f10, int i11, float f11) {
            this.f53607q.a(i10, customAttribute);
            this.f53608r.a(i10, new float[]{f10, f11});
            this.f53597b = Math.max(this.f53597b, i11);
        }

        public boolean h(t.e eVar, float f10, long j10, g gVar) {
            this.f53596a.e(f10, this.f53609s);
            float[] fArr = this.f53609s;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.f53604i;
            if (Float.isNaN(this.f53605j)) {
                float fA = gVar.a(eVar, this.f53606p, 0);
                this.f53605j = fA;
                if (Float.isNaN(fA)) {
                    this.f53605j = 0.0f;
                }
            }
            float f13 = (float) ((((double) this.f53605j) + ((j11 * 1.0E-9d) * ((double) f11))) % 1.0d);
            this.f53605j = f13;
            this.f53604i = j10;
            float fA2 = a(f13);
            this.f53603h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f53610t;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.f53603h;
                float[] fArr3 = this.f53609s;
                this.f53603h = z10 | (((double) fArr3[i10]) != 0.0d);
                fArr2[i10] = (fArr3[i10] * fA2) + f12;
                i10++;
            }
            eVar.M(this.f53607q.g(0), this.f53610t);
            if (f11 != 0.0f) {
                this.f53603h = true;
            }
            return this.f53603h;
        }
    }

    public static class b extends t {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f53611p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public i.b f53612q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public i.c f53613r = new i.c();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float[] f53614s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float[] f53615t;

        public b(String str, i.b bVar) {
            this.f53611p = str.split(ag.c.f654g)[1];
            this.f53612q = bVar;
        }

        @Override // w.t
        public void c(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // w.t
        public void f(int i10) {
            int iF = this.f53612q.f();
            int iR = this.f53612q.g(0).r();
            double[] dArr = new double[iF];
            int i11 = iR + 2;
            this.f53614s = new float[i11];
            this.f53615t = new float[iR];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, iF, i11);
            for (int i12 = 0; i12 < iF; i12++) {
                int iD = this.f53612q.d(i12);
                t.a aVarG = this.f53612q.g(i12);
                float[] fArrG = this.f53613r.g(i12);
                dArr[i12] = ((double) iD) * 0.01d;
                aVarG.o(this.f53614s);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f53614s.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                dArr2[i12][iR] = fArrG[0];
                dArr2[i12][iR + 1] = fArrG[1];
            }
            this.f53596a = w.b.a(i10, dArr, dArr2);
        }

        public void g(int i10, t.a aVar, float f10, int i11, float f11) {
            this.f53612q.a(i10, aVar);
            this.f53613r.a(i10, new float[]{f10, f11});
            this.f53597b = Math.max(this.f53597b, i11);
        }

        public boolean h(t.e eVar, float f10, long j10, g gVar) {
            this.f53596a.e(f10, this.f53614s);
            float[] fArr = this.f53614s;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.f53604i;
            if (Float.isNaN(this.f53605j)) {
                float fA = gVar.a(eVar, this.f53611p, 0);
                this.f53605j = fA;
                if (Float.isNaN(fA)) {
                    this.f53605j = 0.0f;
                }
            }
            float f13 = (float) ((((double) this.f53605j) + ((j11 * 1.0E-9d) * ((double) f11))) % 1.0d);
            this.f53605j = f13;
            this.f53604i = j10;
            float fA2 = a(f13);
            this.f53603h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f53615t;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.f53603h;
                float[] fArr3 = this.f53614s;
                this.f53603h = z10 | (((double) fArr3[i10]) != 0.0d);
                fArr2[i10] = (fArr3[i10] * fA2) + f12;
                i10++;
            }
            this.f53612q.g(0).w(eVar, this.f53615t);
            if (f11 != 0.0f) {
                this.f53603h = true;
            }
            return this.f53603h;
        }
    }

    public static class c {
        public static void a(int[] iArr, float[][] fArr, int i10, int i11) {
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

        public static int b(int[] iArr, float[][] fArr, int i10, int i11) {
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

        public static void c(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float[] fArr2 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = fArr2;
        }
    }

    public float a(float f10) {
        float fAbs;
        switch (this.f53597b) {
            case 1:
                return Math.signum(f10 * f53595o);
            case 2:
                fAbs = Math.abs(f10);
                break;
            case 3:
                return (((f10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f10 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f10 * f53595o);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f10 * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f10 * f53595o);
        }
        return 1.0f - fAbs;
    }

    public w.b b() {
        return this.f53596a;
    }

    public void c(int i10, float f10, float f11, int i11, float f12) {
        int[] iArr = this.f53598c;
        int i12 = this.f53600e;
        iArr[i12] = i10;
        float[][] fArr = this.f53599d;
        fArr[i12][0] = f10;
        fArr[i12][1] = f11;
        fArr[i12][2] = f12;
        this.f53597b = Math.max(this.f53597b, i11);
        this.f53600e++;
    }

    public void d(long j10) {
        this.f53604i = j10;
    }

    public void e(String str) {
        this.f53601f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(int r12) {
        /*
            r11 = this;
            int r0 = r11.f53600e
            if (r0 != 0) goto L1d
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error no points added to "
            r0.append(r1)
            java.lang.String r1 = r11.f53601f
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.println(r0)
            return
        L1d:
            int[] r1 = r11.f53598c
            float[][] r2 = r11.f53599d
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            w.t.c.a(r1, r2, r4, r0)
            r0 = 1
            r1 = 0
        L29:
            int[] r2 = r11.f53598c
            int r5 = r2.length
            if (r0 >= r5) goto L3b
            r5 = r2[r0]
            int r6 = r0 + (-1)
            r2 = r2[r6]
            if (r5 == r2) goto L38
            int r1 = r1 + 1
        L38:
            int r0 = r0 + 1
            goto L29
        L3b:
            if (r1 != 0) goto L3e
            r1 = 1
        L3e:
            double[] r0 = new double[r1]
            r2 = 3
            r5 = 2
            int[] r6 = new int[r5]
            r6[r3] = r2
            r6[r4] = r1
            java.lang.Class<double> r1 = double.class
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r6)
            double[][] r1 = (double[][]) r1
            r2 = 0
            r6 = 0
        L52:
            int r7 = r11.f53600e
            if (r2 >= r7) goto L93
            if (r2 <= 0) goto L63
            int[] r7 = r11.f53598c
            r8 = r7[r2]
            int r9 = r2 + (-1)
            r7 = r7[r9]
            if (r8 != r7) goto L63
            goto L90
        L63:
            int[] r7 = r11.f53598c
            r7 = r7[r2]
            double r7 = (double) r7
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r7 = r7 * r9
            r0[r6] = r7
            r7 = r1[r6]
            float[][] r8 = r11.f53599d
            r9 = r8[r2]
            r9 = r9[r4]
            double r9 = (double) r9
            r7[r4] = r9
            r7 = r1[r6]
            r9 = r8[r2]
            r9 = r9[r3]
            double r9 = (double) r9
            r7[r3] = r9
            r7 = r1[r6]
            r8 = r8[r2]
            r8 = r8[r5]
            double r8 = (double) r8
            r7[r5] = r8
            int r6 = r6 + 1
        L90:
            int r2 = r2 + 1
            goto L52
        L93:
            w.b r12 = w.b.a(r12, r0, r1)
            r11.f53596a = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w.t.f(int):void");
    }

    public String toString() {
        String str = this.f53601f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f53600e; i10++) {
            str = str + "[" + this.f53598c[i10] + " , " + decimalFormat.format(this.f53599d[i10]) + "] ";
        }
        return str;
    }
}
