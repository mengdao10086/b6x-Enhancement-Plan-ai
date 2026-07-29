package a0;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import w.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends t {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25p = "ViewTimeCycle";

    public static class a extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setAlpha(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f26q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f27r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public SparseArray<float[]> f28s = new SparseArray<>();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float[] f29t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float[] f30u;

        public b(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.f26q = attribute.split(ag.c.f654g)[1];
            this.f27r = attrList;
        }

        @Override // w.t
        public void c(int position, float value, float period, int shape, float offset) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // w.t
        public void f(int curveType) {
            int size = this.f27r.size();
            int iP = this.f27r.valueAt(0).p();
            double[] dArr = new double[size];
            int i10 = iP + 2;
            this.f29t = new float[i10];
            this.f30u = new float[iP];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, i10);
            for (int i11 = 0; i11 < size; i11++) {
                int iKeyAt = this.f27r.keyAt(i11);
                ConstraintAttribute constraintAttributeValueAt = this.f27r.valueAt(i11);
                float[] fArrValueAt = this.f28s.valueAt(i11);
                dArr[i11] = ((double) iKeyAt) * 0.01d;
                constraintAttributeValueAt.l(this.f29t);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f29t.length) {
                        dArr2[i11][i12] = r8[i12];
                        i12++;
                    }
                }
                dArr2[i11][iP] = fArrValueAt[0];
                dArr2[i11][iP + 1] = fArrValueAt[1];
            }
            this.f53596a = w.b.a(curveType, dArr, dArr2);
        }

        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            this.f53596a.e(t10, this.f29t);
            float[] fArr = this.f29t;
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            long j10 = time - this.f53604i;
            if (Float.isNaN(this.f53605j)) {
                float fA = cache.a(view, this.f26q, 0);
                this.f53605j = fA;
                if (Float.isNaN(fA)) {
                    this.f53605j = 0.0f;
                }
            }
            float f12 = (float) ((((double) this.f53605j) + ((j10 * 1.0E-9d) * ((double) f10))) % 1.0d);
            this.f53605j = f12;
            this.f53604i = time;
            float fA2 = a(f12);
            this.f53603h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f30u;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.f53603h;
                float[] fArr3 = this.f29t;
                this.f53603h = z10 | (((double) fArr3[i10]) != 0.0d);
                fArr2[i10] = (fArr3[i10] * fA2) + f11;
                i10++;
            }
            a0.a.b(this.f27r.valueAt(0), view, this.f30u);
            if (f10 != 0.0f) {
                this.f53603h = true;
            }
            return this.f53603h;
        }

        public void k(int position, ConstraintAttribute value, float period, int shape, float offset) {
            this.f27r.append(position, value);
            this.f28s.append(position, new float[]{period, offset});
            this.f53597b = Math.max(this.f53597b, shape);
        }
    }

    public static class c extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setElevation(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class d extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            return this.f53603h;
        }

        public boolean k(View view, w.g cache, float t10, long time, double dx, double dy) {
            view.setRotation(g(t10, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.f53603h;
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f31q = false;

        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(g(t10, time, view, cache));
            } else {
                if (this.f31q) {
                    return false;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f31q = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(g(t10, time, view, cache)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.f53603h;
        }
    }

    /* JADX INFO: renamed from: a0.f$f, reason: collision with other inner class name */
    public static class C0003f extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setRotation(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class g extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setRotationX(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class h extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setRotationY(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class i extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setScaleX(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class j extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setScaleY(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class k extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setTranslationX(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class l extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setTranslationY(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static class m extends f {
        @Override // a0.f
        public boolean j(View view, float t10, long time, w.g cache) {
            view.setTranslationZ(g(t10, time, view, cache));
            return this.f53603h;
        }
    }

    public static f h(String str, SparseArray<ConstraintAttribute> attrList) {
        return new b(str, attrList);
    }

    public static f i(String str, long currentTime) {
        f gVar;
        str.hashCode();
        switch (str) {
            case "rotationX":
                gVar = new g();
                break;
            case "rotationY":
                gVar = new h();
                break;
            case "translationX":
                gVar = new k();
                break;
            case "translationY":
                gVar = new l();
                break;
            case "translationZ":
                gVar = new m();
                break;
            case "progress":
                gVar = new e();
                break;
            case "scaleX":
                gVar = new i();
                break;
            case "scaleY":
                gVar = new j();
                break;
            case "rotation":
                gVar = new C0003f();
                break;
            case "elevation":
                gVar = new c();
                break;
            case "transitionPathRotate":
                gVar = new d();
                break;
            case "alpha":
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.d(currentTime);
        return gVar;
    }

    public float g(float pos, long time, View view, w.g cache) {
        this.f53596a.e(pos, this.f53602g);
        float[] fArr = this.f53602g;
        float f10 = fArr[1];
        if (f10 == 0.0f) {
            this.f53603h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f53605j)) {
            float fA = cache.a(view, this.f53601f, 0);
            this.f53605j = fA;
            if (Float.isNaN(fA)) {
                this.f53605j = 0.0f;
            }
        }
        float f11 = (float) ((((double) this.f53605j) + (((time - this.f53604i) * 1.0E-9d) * ((double) f10))) % 1.0d);
        this.f53605j = f11;
        cache.b(view, this.f53601f, 0, f11);
        this.f53604i = time;
        float f12 = this.f53602g[0];
        float fA2 = (a(this.f53605j) * f12) + this.f53602g[2];
        this.f53603h = (f12 == 0.0f && f10 == 0.0f) ? false : true;
        return fA2;
    }

    public abstract boolean j(View view, float t10, long time, w.g cache);
}
