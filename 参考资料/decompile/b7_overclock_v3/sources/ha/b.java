package ha;

import android.animation.TimeInterpolator;
import g.v0;

/* JADX INFO: loaded from: classes3.dex */
@v0(11)
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f30746a = 6.2831855f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f30747b = new k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f30748c = new u();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f30749d = new v();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f30750e = new w();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0 f30751f = new x();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c0 f30752g = new y();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c0 f30753h = new z();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c0 f30754i = new a0();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c0 f30755j = new b0();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c0 f30756k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c0 f30757l = new C0366b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c0 f30758m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c0 f30759n = new d();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c0 f30760o = new e();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c0 f30761p = new f();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c0 f30762q = new g();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c0 f30763r = new h();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c0 f30764s = new i();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c0 f30765t = new j();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c0 f30766u = new l();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c0 f30767v = new m();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c0 f30768w = new n();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c0 f30769x = new o();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c0 f30770y = new p();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c0 f30771z = new q();
    public static final c0 A = new r();
    public static final c0 B = new s();
    public static final c0 C = new t();

    public static class a implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 * 2.0f;
            return f11 < 1.0f ? ((float) Math.pow(f11, 4.0d)) * 0.5f : (((float) Math.pow(f11 - 2.0f, 4.0d)) - 2.0f) * (-0.5f);
        }
    }

    public static class a0 implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) Math.pow(f10, 4.0d);
        }
    }

    /* JADX INFO: renamed from: ha.b$b, reason: collision with other inner class name */
    public static class C0366b implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (-((float) Math.cos(((double) f10) * 1.5707963267948966d))) + 1.0f;
        }
    }

    public static class b0 implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return -(((float) Math.pow(f10 - 1.0f, 4.0d)) - 1.0f);
        }
    }

    public static class c implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) Math.sin(((double) f10) * 1.5707963267948966d);
        }
    }

    public interface c0 extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f10);
    }

    public static class d implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (((float) Math.cos(((double) f10) * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    }

    public static class e implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f10 - 1.0f) * 10.0f);
        }
    }

    public static class f implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f10 + 1.0f) * (-10.0f)));
        }
    }

    public static class g implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            if (f10 == 1.0f) {
                return 1.0f;
            }
            return (f10 * 2.0f < 1.0f ? (float) Math.pow(2.0d, (r8 - 1.0f) * 10.0f) : (-((float) Math.pow(2.0d, (r8 - 1.0f) * (-10.0f)))) + 2.0f) * 0.5f;
        }
    }

    public static class h implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return -(((float) Math.sqrt(1.0f - (f10 * f10))) - 1.0f);
        }
    }

    public static class i implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (float) Math.sqrt(1.0f - (f11 * f11));
        }
    }

    public static class j implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 * 2.0f;
            if (f11 < 1.0f) {
                return (((float) Math.sqrt(1.0f - (f11 * f11))) - 1.0f) * (-0.5f);
            }
            float f12 = f11 - 2.0f;
            return (((float) Math.sqrt(1.0f - (f12 * f12))) + 1.0f) * 0.5f;
        }
    }

    public static class k implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return f10;
        }
    }

    public static class l implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            if (f10 == 1.0f) {
                return 1.0f;
            }
            float f11 = f10 - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f11)) * ((float) Math.sin(((f11 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    }

    public static class m implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            if (f10 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f10)) * ((float) Math.sin(((f10 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    }

    public static class n implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            float f11 = f10 * 2.0f;
            if (f11 == 2.0f) {
                return 1.0f;
            }
            float fAsin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f11 < 1.0f) {
                float f12 = f11 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f12)) * ((float) Math.sin(((f12 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f13 = f11 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f13)) * 0.5f * ((float) Math.sin(((f13 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    }

    public static class o implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return f10 * f10 * ((f10 * 2.70158f) - 1.70158f);
        }
    }

    public static class p implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * ((f11 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    }

    public static class q implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 * 2.0f;
            if (f11 < 1.0f) {
                return f11 * f11 * ((3.5949094f * f11) - 2.5949094f) * 0.5f;
            }
            float f12 = f11 - 2.0f;
            return ((f12 * f12 * ((3.5949094f * f12) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    }

    public static class r implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return 1.0f - b.B.getInterpolation(1.0f - f10);
        }
    }

    public static class s implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            if (f10 < 0.36363637f) {
                return 7.5625f * f10 * f10;
            }
            if (f10 < 0.72727275f) {
                float f11 = f10 - 0.54545456f;
                return (7.5625f * f11 * f11) + 0.75f;
            }
            if (f10 < 0.90909094f) {
                float f12 = f10 - 0.8181818f;
                return (7.5625f * f12 * f12) + 0.9375f;
            }
            float f13 = f10 - 0.95454544f;
            return (7.5625f * f13 * f13) + 0.984375f;
        }
    }

    public static class t implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return f10 < 0.5f ? b.A.getInterpolation(f10 * 2.0f) * 0.5f : (b.B.getInterpolation((f10 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    }

    public static class u implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return f10 * f10;
        }
    }

    public static class v implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (-f10) * (f10 - 2.0f);
        }
    }

    public static class w implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 * 2.0f;
            if (f11 < 1.0f) {
                return 0.5f * f11 * f11;
            }
            float f12 = f11 - 1.0f;
            return ((f12 * (f12 - 2.0f)) - 1.0f) * (-0.5f);
        }
    }

    public static class x implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) Math.pow(f10, 3.0d);
        }
    }

    public static class y implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return ((float) Math.pow(f10 - 1.0f, 3.0d)) + 1.0f;
        }
    }

    public static class z implements c0 {
        @Override // ha.b.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 * 2.0f;
            return (f11 < 1.0f ? (float) Math.pow(f11, 3.0d) : ((float) Math.pow(f11 - 2.0f, 3.0d)) + 2.0f) * 0.5f;
        }
    }
}
