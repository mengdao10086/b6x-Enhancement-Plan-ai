package a0;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends w.o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f15g = "ViewSpline";

    public static class a extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setAlpha(a(t10));
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f17i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f18j;

        public b(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.f16h = attribute.split(ag.c.f654g)[1];
            this.f17i = attrList;
        }

        @Override // w.o
        public void g(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // w.o
        public void j(int curveType) {
            int size = this.f17i.size();
            int iP = this.f17i.valueAt(0).p();
            double[] dArr = new double[size];
            this.f18j = new float[iP];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, iP);
            for (int i10 = 0; i10 < size; i10++) {
                int iKeyAt = this.f17i.keyAt(i10);
                ConstraintAttribute constraintAttributeValueAt = this.f17i.valueAt(i10);
                dArr[i10] = ((double) iKeyAt) * 0.01d;
                constraintAttributeValueAt.l(this.f18j);
                int i11 = 0;
                while (true) {
                    if (i11 < this.f18j.length) {
                        dArr2[i10][i11] = r6[i11];
                        i11++;
                    }
                }
            }
            this.f53548a = w.b.a(curveType, dArr, dArr2);
        }

        @Override // a0.d
        public void m(View view, float t10) {
            this.f53548a.e(t10, this.f18j);
            a0.a.b(this.f17i.valueAt(0), view, this.f18j);
        }

        public void n(int position, ConstraintAttribute value) {
            this.f17i.append(position, value);
        }
    }

    public static class c extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setElevation(a(t10));
        }
    }

    /* JADX INFO: renamed from: a0.d$d, reason: collision with other inner class name */
    public static class C0002d extends d {
        @Override // a0.d
        public void m(View view, float t10) {
        }

        public void n(View view, float t10, double dx, double dy) {
            view.setRotation(a(t10) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    public static class e extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setPivotX(a(t10));
        }
    }

    public static class f extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setPivotY(a(t10));
        }
    }

    public static class g extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19h = false;

        @Override // a0.d
        public void m(View view, float t10) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(t10));
                return;
            }
            if (this.f19h) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f19h = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(t10)));
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
        }
    }

    public static class h extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setRotation(a(t10));
        }
    }

    public static class i extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setRotationX(a(t10));
        }
    }

    public static class j extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setRotationY(a(t10));
        }
    }

    public static class k extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setScaleX(a(t10));
        }
    }

    public static class l extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setScaleY(a(t10));
        }
    }

    public static class m extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setTranslationX(a(t10));
        }
    }

    public static class n extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setTranslationY(a(t10));
        }
    }

    public static class o extends d {
        @Override // a0.d
        public void m(View view, float t10) {
            view.setTranslationZ(a(t10));
        }
    }

    public static d k(String str, SparseArray<ConstraintAttribute> attrList) {
        return new b(str, attrList);
    }

    public static d l(String str) {
        str.hashCode();
        switch (str) {
        }
        return new a();
    }

    public abstract void m(View view, float t10);
}
