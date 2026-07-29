package w;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f53377g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f53378h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f53379i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f53380j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f53381k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f53382l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f53383m = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double[] f53384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0629a[] f53385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f53386f = true;

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    public static class C0629a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f53387s = "Arc";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static double[] f53388t = new double[91];

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final double f53389u = 0.001d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double[] f53390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f53391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f53392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f53393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f53394e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f53395f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f53396g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f53397h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f53398i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f53399j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public double f53400k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public double f53401l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public double f53402m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double f53403n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double f53404o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f53405p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f53406q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f53407r;

        public C0629a(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            this.f53407r = false;
            this.f53406q = i10 == 1;
            this.f53392c = d10;
            this.f53393d = d11;
            this.f53398i = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.f53407r = true;
            }
            double d16 = d14 - d12;
            double d17 = d15 - d13;
            if (!this.f53407r && Math.abs(d16) >= 0.001d && Math.abs(d17) >= 0.001d) {
                this.f53390a = new double[101];
                boolean z10 = this.f53406q;
                this.f53399j = d16 * ((double) (z10 ? -1 : 1));
                this.f53400k = d17 * ((double) (z10 ? 1 : -1));
                this.f53401l = z10 ? d14 : d12;
                this.f53402m = z10 ? d13 : d15;
                a(d12, d13, d14, d15);
                this.f53403n = this.f53391b * this.f53398i;
                return;
            }
            this.f53407r = true;
            this.f53394e = d12;
            this.f53395f = d14;
            this.f53396g = d13;
            this.f53397h = d15;
            double dHypot = Math.hypot(d17, d16);
            this.f53391b = dHypot;
            this.f53403n = dHypot * this.f53398i;
            double d18 = this.f53393d;
            double d19 = this.f53392c;
            this.f53401l = d16 / (d18 - d19);
            this.f53402m = d17 / (d18 - d19);
        }

        public final void a(double d10, double d11, double d12, double d13) {
            double dHypot;
            double d14 = d12 - d10;
            double d15 = d11 - d13;
            int i10 = 0;
            double d16 = 0.0d;
            double d17 = 0.0d;
            double d18 = 0.0d;
            while (true) {
                if (i10 >= f53388t.length) {
                    break;
                }
                double d19 = d16;
                double radians = Math.toRadians((((double) i10) * 90.0d) / ((double) (r15.length - 1)));
                double dSin = Math.sin(radians) * d14;
                double dCos = Math.cos(radians) * d15;
                if (i10 > 0) {
                    dHypot = Math.hypot(dSin - d17, dCos - d18) + d19;
                    f53388t[i10] = dHypot;
                } else {
                    dHypot = d19;
                }
                i10++;
                d18 = dCos;
                d16 = dHypot;
                d17 = dSin;
            }
            double d20 = d16;
            this.f53391b = d20;
            int i11 = 0;
            while (true) {
                double[] dArr = f53388t;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] / d20;
                i11++;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= this.f53390a.length) {
                    return;
                }
                double length = ((double) i12) / ((double) (r1.length - 1));
                int iBinarySearch = Arrays.binarySearch(f53388t, length);
                if (iBinarySearch >= 0) {
                    this.f53390a[i12] = ((double) iBinarySearch) / ((double) (f53388t.length - 1));
                } else if (iBinarySearch == -1) {
                    this.f53390a[i12] = 0.0d;
                } else {
                    int i13 = -iBinarySearch;
                    int i14 = i13 - 2;
                    double[] dArr2 = f53388t;
                    this.f53390a[i12] = (((double) i14) + ((length - dArr2[i14]) / (dArr2[i13 - 1] - dArr2[i14]))) / ((double) (dArr2.length - 1));
                }
                i12++;
            }
        }

        public double b() {
            double d10 = this.f53399j * this.f53405p;
            double dHypot = this.f53403n / Math.hypot(d10, (-this.f53400k) * this.f53404o);
            if (this.f53406q) {
                d10 = -d10;
            }
            return d10 * dHypot;
        }

        public double c() {
            double d10 = this.f53399j * this.f53405p;
            double d11 = (-this.f53400k) * this.f53404o;
            double dHypot = this.f53403n / Math.hypot(d10, d11);
            return this.f53406q ? (-d11) * dHypot : d11 * dHypot;
        }

        public double d(double d10) {
            return this.f53401l;
        }

        public double e(double d10) {
            return this.f53402m;
        }

        public double f(double d10) {
            double d11 = (d10 - this.f53392c) * this.f53398i;
            double d12 = this.f53394e;
            return d12 + (d11 * (this.f53395f - d12));
        }

        public double g(double d10) {
            double d11 = (d10 - this.f53392c) * this.f53398i;
            double d12 = this.f53396g;
            return d12 + (d11 * (this.f53397h - d12));
        }

        public double h() {
            return this.f53401l + (this.f53399j * this.f53404o);
        }

        public double i() {
            return this.f53402m + (this.f53400k * this.f53405p);
        }

        public double j(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f53390a;
            double length = d10 * ((double) (dArr.length - 1));
            int i10 = (int) length;
            return dArr[i10] + ((length - ((double) i10)) * (dArr[i10 + 1] - dArr[i10]));
        }

        public void k(double d10) {
            double dJ = j((this.f53406q ? this.f53393d - d10 : d10 - this.f53392c) * this.f53398i) * 1.5707963267948966d;
            this.f53404o = Math.sin(dJ);
            this.f53405p = Math.cos(dJ);
        }
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.f53384d = dArr;
        this.f53385e = new C0629a[dArr.length - 1];
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            C0629a[] c0629aArr = this.f53385e;
            if (i10 >= c0629aArr.length) {
                return;
            }
            int i13 = iArr[i10];
            if (i13 == 0) {
                i12 = 3;
            } else if (i13 == 1) {
                i11 = 1;
                i12 = 1;
            } else if (i13 == 2) {
                i11 = 2;
                i12 = 2;
            } else if (i13 == 3) {
                i11 = i11 == 1 ? 2 : 1;
                i12 = i11;
            }
            int i14 = i10 + 1;
            c0629aArr[i10] = new C0629a(i12, dArr[i10], dArr[i14], dArr2[i10][0], dArr2[i10][1], dArr2[i14][0], dArr2[i14][1]);
            i10 = i14;
        }
    }

    @Override // w.b
    public double c(double d10, int i10) {
        double d11;
        double dG;
        double dE;
        double dI;
        double dC;
        int i11 = 0;
        if (this.f53386f) {
            C0629a[] c0629aArr = this.f53385e;
            if (d10 < c0629aArr[0].f53392c) {
                double d12 = c0629aArr[0].f53392c;
                d11 = d10 - c0629aArr[0].f53392c;
                if (!c0629aArr[0].f53407r) {
                    c0629aArr[0].k(d12);
                    if (i10 == 0) {
                        dI = this.f53385e[0].h();
                        dC = this.f53385e[0].b();
                    } else {
                        dI = this.f53385e[0].i();
                        dC = this.f53385e[0].c();
                    }
                    return dI + (d11 * dC);
                }
                if (i10 == 0) {
                    dG = c0629aArr[0].f(d12);
                    dE = this.f53385e[0].d(d12);
                } else {
                    dG = c0629aArr[0].g(d12);
                    dE = this.f53385e[0].e(d12);
                }
            } else if (d10 > c0629aArr[c0629aArr.length - 1].f53393d) {
                double d13 = c0629aArr[c0629aArr.length - 1].f53393d;
                d11 = d10 - d13;
                int length = c0629aArr.length - 1;
                if (i10 == 0) {
                    dG = c0629aArr[length].f(d13);
                    dE = this.f53385e[length].d(d13);
                } else {
                    dG = c0629aArr[length].g(d13);
                    dE = this.f53385e[length].e(d13);
                }
            }
            return dG + (d11 * dE);
        }
        C0629a[] c0629aArr2 = this.f53385e;
        if (d10 < c0629aArr2[0].f53392c) {
            d10 = c0629aArr2[0].f53392c;
        } else if (d10 > c0629aArr2[c0629aArr2.length - 1].f53393d) {
            d10 = c0629aArr2[c0629aArr2.length - 1].f53393d;
        }
        while (true) {
            C0629a[] c0629aArr3 = this.f53385e;
            if (i11 >= c0629aArr3.length) {
                return Double.NaN;
            }
            if (d10 <= c0629aArr3[i11].f53393d) {
                if (c0629aArr3[i11].f53407r) {
                    return i10 == 0 ? c0629aArr3[i11].f(d10) : c0629aArr3[i11].g(d10);
                }
                c0629aArr3[i11].k(d10);
                return i10 == 0 ? this.f53385e[i11].h() : this.f53385e[i11].i();
            }
            i11++;
        }
    }

    @Override // w.b
    public void d(double d10, double[] dArr) {
        if (this.f53386f) {
            C0629a[] c0629aArr = this.f53385e;
            if (d10 < c0629aArr[0].f53392c) {
                double d11 = c0629aArr[0].f53392c;
                double d12 = d10 - c0629aArr[0].f53392c;
                if (c0629aArr[0].f53407r) {
                    dArr[0] = c0629aArr[0].f(d11) + (this.f53385e[0].d(d11) * d12);
                    dArr[1] = this.f53385e[0].g(d11) + (d12 * this.f53385e[0].e(d11));
                    return;
                } else {
                    c0629aArr[0].k(d11);
                    dArr[0] = this.f53385e[0].h() + (this.f53385e[0].b() * d12);
                    dArr[1] = this.f53385e[0].i() + (d12 * this.f53385e[0].c());
                    return;
                }
            }
            if (d10 > c0629aArr[c0629aArr.length - 1].f53393d) {
                double d13 = c0629aArr[c0629aArr.length - 1].f53393d;
                double d14 = d10 - d13;
                int length = c0629aArr.length - 1;
                if (c0629aArr[length].f53407r) {
                    dArr[0] = c0629aArr[length].f(d13) + (this.f53385e[length].d(d13) * d14);
                    dArr[1] = this.f53385e[length].g(d13) + (d14 * this.f53385e[length].e(d13));
                    return;
                } else {
                    c0629aArr[length].k(d10);
                    dArr[0] = this.f53385e[length].h() + (this.f53385e[length].b() * d14);
                    dArr[1] = this.f53385e[length].i() + (d14 * this.f53385e[length].c());
                    return;
                }
            }
        } else {
            C0629a[] c0629aArr2 = this.f53385e;
            if (d10 < c0629aArr2[0].f53392c) {
                d10 = c0629aArr2[0].f53392c;
            }
            if (d10 > c0629aArr2[c0629aArr2.length - 1].f53393d) {
                d10 = c0629aArr2[c0629aArr2.length - 1].f53393d;
            }
        }
        int i10 = 0;
        while (true) {
            C0629a[] c0629aArr3 = this.f53385e;
            if (i10 >= c0629aArr3.length) {
                return;
            }
            if (d10 <= c0629aArr3[i10].f53393d) {
                if (c0629aArr3[i10].f53407r) {
                    dArr[0] = c0629aArr3[i10].f(d10);
                    dArr[1] = this.f53385e[i10].g(d10);
                    return;
                } else {
                    c0629aArr3[i10].k(d10);
                    dArr[0] = this.f53385e[i10].h();
                    dArr[1] = this.f53385e[i10].i();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // w.b
    public void e(double d10, float[] fArr) {
        if (this.f53386f) {
            C0629a[] c0629aArr = this.f53385e;
            if (d10 < c0629aArr[0].f53392c) {
                double d11 = c0629aArr[0].f53392c;
                double d12 = d10 - c0629aArr[0].f53392c;
                if (c0629aArr[0].f53407r) {
                    fArr[0] = (float) (c0629aArr[0].f(d11) + (this.f53385e[0].d(d11) * d12));
                    fArr[1] = (float) (this.f53385e[0].g(d11) + (d12 * this.f53385e[0].e(d11)));
                    return;
                } else {
                    c0629aArr[0].k(d11);
                    fArr[0] = (float) (this.f53385e[0].h() + (this.f53385e[0].b() * d12));
                    fArr[1] = (float) (this.f53385e[0].i() + (d12 * this.f53385e[0].c()));
                    return;
                }
            }
            if (d10 > c0629aArr[c0629aArr.length - 1].f53393d) {
                double d13 = c0629aArr[c0629aArr.length - 1].f53393d;
                double d14 = d10 - d13;
                int length = c0629aArr.length - 1;
                if (c0629aArr[length].f53407r) {
                    fArr[0] = (float) (c0629aArr[length].f(d13) + (this.f53385e[length].d(d13) * d14));
                    fArr[1] = (float) (this.f53385e[length].g(d13) + (d14 * this.f53385e[length].e(d13)));
                    return;
                } else {
                    c0629aArr[length].k(d10);
                    fArr[0] = (float) this.f53385e[length].h();
                    fArr[1] = (float) this.f53385e[length].i();
                    return;
                }
            }
        } else {
            C0629a[] c0629aArr2 = this.f53385e;
            if (d10 < c0629aArr2[0].f53392c) {
                d10 = c0629aArr2[0].f53392c;
            } else if (d10 > c0629aArr2[c0629aArr2.length - 1].f53393d) {
                d10 = c0629aArr2[c0629aArr2.length - 1].f53393d;
            }
        }
        int i10 = 0;
        while (true) {
            C0629a[] c0629aArr3 = this.f53385e;
            if (i10 >= c0629aArr3.length) {
                return;
            }
            if (d10 <= c0629aArr3[i10].f53393d) {
                if (c0629aArr3[i10].f53407r) {
                    fArr[0] = (float) c0629aArr3[i10].f(d10);
                    fArr[1] = (float) this.f53385e[i10].g(d10);
                    return;
                } else {
                    c0629aArr3[i10].k(d10);
                    fArr[0] = (float) this.f53385e[i10].h();
                    fArr[1] = (float) this.f53385e[i10].i();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // w.b
    public double f(double d10, int i10) {
        C0629a[] c0629aArr = this.f53385e;
        int i11 = 0;
        if (d10 < c0629aArr[0].f53392c) {
            d10 = c0629aArr[0].f53392c;
        }
        if (d10 > c0629aArr[c0629aArr.length - 1].f53393d) {
            d10 = c0629aArr[c0629aArr.length - 1].f53393d;
        }
        while (true) {
            C0629a[] c0629aArr2 = this.f53385e;
            if (i11 >= c0629aArr2.length) {
                return Double.NaN;
            }
            if (d10 <= c0629aArr2[i11].f53393d) {
                if (c0629aArr2[i11].f53407r) {
                    return i10 == 0 ? c0629aArr2[i11].d(d10) : c0629aArr2[i11].e(d10);
                }
                c0629aArr2[i11].k(d10);
                return i10 == 0 ? this.f53385e[i11].b() : this.f53385e[i11].c();
            }
            i11++;
        }
    }

    @Override // w.b
    public void g(double d10, double[] dArr) {
        C0629a[] c0629aArr = this.f53385e;
        if (d10 < c0629aArr[0].f53392c) {
            d10 = c0629aArr[0].f53392c;
        } else if (d10 > c0629aArr[c0629aArr.length - 1].f53393d) {
            d10 = c0629aArr[c0629aArr.length - 1].f53393d;
        }
        int i10 = 0;
        while (true) {
            C0629a[] c0629aArr2 = this.f53385e;
            if (i10 >= c0629aArr2.length) {
                return;
            }
            if (d10 <= c0629aArr2[i10].f53393d) {
                if (c0629aArr2[i10].f53407r) {
                    dArr[0] = c0629aArr2[i10].d(d10);
                    dArr[1] = this.f53385e[i10].e(d10);
                    return;
                } else {
                    c0629aArr2[i10].k(d10);
                    dArr[0] = this.f53385e[i10].b();
                    dArr[1] = this.f53385e[i10].c();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // w.b
    public double[] h() {
        return this.f53384d;
    }
}
