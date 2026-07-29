package a0;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends w.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f11i = "ViewOscillator";

    public static class a extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setAlpha(a(t10));
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f12j = new float[1];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ConstraintAttribute f13k;

        @Override // w.h
        public void e(Object custom) {
            this.f13k = (ConstraintAttribute) custom;
        }

        @Override // a0.c
        public void m(View view, float t10) {
            this.f12j[0] = a(t10);
            a0.a.b(this.f13k, view, this.f12j);
        }
    }

    /* JADX INFO: renamed from: a0.c$c, reason: collision with other inner class name */
    public static class C0001c extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setElevation(a(t10));
        }
    }

    public static class d extends c {
        @Override // a0.c
        public void m(View view, float t10) {
        }

        public void n(View view, float t10, double dx, double dy) {
            view.setRotation(a(t10) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    public static class e extends c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f14j = false;

        @Override // a0.c
        public void m(View view, float t10) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(t10));
                return;
            }
            if (this.f14j) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f14j = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(t10)));
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
        }
    }

    public static class f extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setRotation(a(t10));
        }
    }

    public static class g extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setRotationX(a(t10));
        }
    }

    public static class h extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setRotationY(a(t10));
        }
    }

    public static class i extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setScaleX(a(t10));
        }
    }

    public static class j extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setScaleY(a(t10));
        }
    }

    public static class k extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setTranslationX(a(t10));
        }
    }

    public static class l extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setTranslationY(a(t10));
        }
    }

    public static class m extends c {
        @Override // a0.c
        public void m(View view, float t10) {
            view.setTranslationZ(a(t10));
        }
    }

    public static c l(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
        switch (str) {
            case "rotationX":
                return new g();
            case "rotationY":
                return new h();
            case "translationX":
                return new k();
            case "translationY":
                return new l();
            case "translationZ":
                return new m();
            case "progress":
                return new e();
            case "scaleX":
                return new i();
            case "scaleY":
                return new j();
            case "waveVariesBy":
                return new a();
            case "rotation":
                return new f();
            case "elevation":
                return new C0001c();
            case "transitionPathRotate":
                return new d();
            case "alpha":
                return new a();
            case "waveOffset":
                return new a();
            default:
                return null;
        }
    }

    public abstract void m(View view, float t10);
}
