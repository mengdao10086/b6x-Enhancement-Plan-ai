package w;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f53462h = "KeyCycleOscillator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w.b f53463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f53464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f53465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53466d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f53467e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53468f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<g> f53469g = new ArrayList<>();

    public class a implements Comparator<g> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            return Integer.compare(gVar.f53493a, gVar2.f53493a);
        }
    }

    public static class b extends h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f53471i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f53472j;

        public b(String str) {
            this.f53471i = str;
            this.f53472j = y.a(str);
        }

        @Override // w.h
        public void h(t.e eVar, float f10) {
            eVar.b(this.f53472j, a(f10));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f53473q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f53474r = "CycleOscillator";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l f53476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f53477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f53478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f53479e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float[] f53480f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double[] f53481g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f53482h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float[] f53483i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f53484j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float[] f53485k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f53486l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public w.b f53487m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double[] f53488n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double[] f53489o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f53490p;

        public c(int i10, String str, int i11, int i12) {
            l lVar = new l();
            this.f53476b = lVar;
            this.f53477c = 0;
            this.f53478d = 1;
            this.f53479e = 2;
            this.f53486l = i10;
            this.f53475a = i11;
            lVar.g(i10, str);
            this.f53480f = new float[i12];
            this.f53481g = new double[i12];
            this.f53482h = new float[i12];
            this.f53483i = new float[i12];
            this.f53484j = new float[i12];
            this.f53485k = new float[i12];
        }

        public double a() {
            return this.f53488n[1];
        }

        public double b(float f10) {
            w.b bVar = this.f53487m;
            if (bVar != null) {
                double d10 = f10;
                bVar.g(d10, this.f53489o);
                this.f53487m.d(d10, this.f53488n);
            } else {
                double[] dArr = this.f53489o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d11 = f10;
            double dE = this.f53476b.e(d11, this.f53488n[1]);
            double d12 = this.f53476b.d(d11, this.f53488n[1], this.f53489o[1]);
            double[] dArr2 = this.f53489o;
            return dArr2[0] + (dE * dArr2[2]) + (d12 * this.f53488n[2]);
        }

        public double c(float f10) {
            w.b bVar = this.f53487m;
            if (bVar != null) {
                bVar.d(f10, this.f53488n);
            } else {
                double[] dArr = this.f53488n;
                dArr[0] = this.f53483i[0];
                dArr[1] = this.f53484j[0];
                dArr[2] = this.f53480f[0];
            }
            double[] dArr2 = this.f53488n;
            return dArr2[0] + (this.f53476b.e(f10, dArr2[1]) * this.f53488n[2]);
        }

        public void d(int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f53481g[i10] = ((double) i11) / 100.0d;
            this.f53482h[i10] = f10;
            this.f53483i[i10] = f11;
            this.f53484j[i10] = f12;
            this.f53480f[i10] = f13;
        }

        public void e(float f10) {
            this.f53490p = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, this.f53481g.length, 3);
            float[] fArr = this.f53480f;
            this.f53488n = new double[fArr.length + 2];
            this.f53489o = new double[fArr.length + 2];
            if (this.f53481g[0] > 0.0d) {
                this.f53476b.a(0.0d, this.f53482h[0]);
            }
            double[] dArr2 = this.f53481g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f53476b.a(1.0d, this.f53482h[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                dArr[i10][0] = this.f53483i[i10];
                dArr[i10][1] = this.f53484j[i10];
                dArr[i10][2] = this.f53480f[i10];
                this.f53476b.a(this.f53481g[i10], this.f53482h[i10]);
            }
            this.f53476b.f();
            double[] dArr3 = this.f53481g;
            if (dArr3.length > 1) {
                this.f53487m = w.b.a(0, dArr3, dArr);
            } else {
                this.f53487m = null;
            }
        }
    }

    public static class d {
        public static int a(int[] iArr, float[] fArr, int i10, int i11) {
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

        public static void b(int[] iArr, float[] fArr, int i10, int i11) {
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
                    int iA = a(iArr, fArr, i14, i15);
                    int i16 = i12 + 1;
                    iArr2[i12] = iA - 1;
                    int i17 = i16 + 1;
                    iArr2[i16] = i14;
                    int i18 = i17 + 1;
                    iArr2[i17] = i15;
                    i12 = i18 + 1;
                    iArr2[i18] = iA + 1;
                }
            }
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

    public static class e {
        public static int a(int[] iArr, float[] fArr, float[] fArr2, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    c(iArr, fArr, fArr2, i13, i10);
                    i13++;
                }
                i10++;
            }
            c(iArr, fArr, fArr2, i13, i11);
            return i13;
        }

        public static void b(int[] iArr, float[] fArr, float[] fArr2, int i10, int i11) {
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
                    int iA = a(iArr, fArr, fArr2, i14, i15);
                    int i16 = i12 + 1;
                    iArr2[i12] = iA - 1;
                    int i17 = i16 + 1;
                    iArr2[i16] = i14;
                    int i18 = i17 + 1;
                    iArr2[i17] = i15;
                    i12 = i18 + 1;
                    iArr2[i18] = iA + 1;
                }
            }
        }

        public static void c(int[] iArr, float[] fArr, float[] fArr2, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
            float f11 = fArr2[i10];
            fArr2[i10] = fArr2[i11];
            fArr2[i11] = f11;
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f53491i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f53492j;

        public f(String str) {
            this.f53491i = str;
            this.f53492j = y.a(str);
        }

        @Override // w.h
        public void h(t.e eVar, float f10) {
            eVar.b(this.f53492j, a(f10));
        }

        public void l(t.e eVar, float f10, double d10, double d11) {
            eVar.R(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f53493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f53494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f53495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f53496d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f53497e;

        public g(int i10, float f10, float f11, float f12, float f13) {
            this.f53493a = i10;
            this.f53494b = f13;
            this.f53495c = f11;
            this.f53496d = f10;
            this.f53497e = f12;
        }
    }

    public static h d(String str) {
        return str.equals("pathRotate") ? new f(str) : new b(str);
    }

    public float a(float f10) {
        return (float) this.f53464b.c(f10);
    }

    public w.b b() {
        return this.f53463a;
    }

    public float c(float f10) {
        return (float) this.f53464b.b(f10);
    }

    public void e(Object obj) {
    }

    public void f(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13) {
        this.f53469g.add(new g(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.f53468f = i12;
        }
        this.f53466d = i11;
        this.f53467e = str;
    }

    public void g(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13, Object obj) {
        this.f53469g.add(new g(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.f53468f = i12;
        }
        this.f53466d = i11;
        e(obj);
        this.f53467e = str;
    }

    public void h(t.e eVar, float f10) {
    }

    public void i(String str) {
        this.f53465c = str;
    }

    public void j(float f10) {
        int size = this.f53469g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f53469g, new a());
        double[] dArr = new double[size];
        char c10 = 0;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, 3);
        this.f53464b = new c(this.f53466d, this.f53467e, this.f53468f, size);
        int i10 = 0;
        for (g gVar : this.f53469g) {
            float f11 = gVar.f53496d;
            dArr[i10] = ((double) f11) * 0.01d;
            double[] dArr3 = dArr2[i10];
            float f12 = gVar.f53494b;
            dArr3[c10] = f12;
            double[] dArr4 = dArr2[i10];
            float f13 = gVar.f53495c;
            dArr4[1] = f13;
            double[] dArr5 = dArr2[i10];
            float f14 = gVar.f53497e;
            dArr5[2] = f14;
            this.f53464b.d(i10, gVar.f53493a, f11, f13, f14, f12);
            i10++;
            c10 = 0;
        }
        this.f53464b.e(f10);
        this.f53463a = w.b.a(0, dArr, dArr2);
    }

    public boolean k() {
        return this.f53468f == 1;
    }

    public String toString() {
        String str = this.f53465c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<g> it2 = this.f53469g.iterator();
        while (it2.hasNext()) {
            str = str + "[" + it2.next().f53493a + " , " + decimalFormat.format(r3.f53494b) + "] ";
        }
        return str;
    }
}
