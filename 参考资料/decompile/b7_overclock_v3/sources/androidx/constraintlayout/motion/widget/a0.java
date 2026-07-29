package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.t;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    public static final String A = "ConstraintOverride";
    public static final String B = "CustomAttribute";
    public static final String C = "CustomMethod";
    public static final int D = -1;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int I = 5;
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = -1;
    public static final int N = -2;
    public static final int O = 0;
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int U = 6;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f3581x = "ViewTransition";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f3582y = "ViewTransition";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f3583z = "KeyFrameSet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.widget.d f3584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3585b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f3590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d.a f3591h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3594k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3595l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Context f3599p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3586c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3587d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3588e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3592i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3593j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3596m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3597n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3598o = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3600q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3601r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3602s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3603t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3604u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3605v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3606w = -1;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w.d f3607a;

        public a(final a0 this$0, final w.d val$easing) {
            this.f3607a = val$easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float v10) {
            return (float) this.f3607a.a(v10);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o f3611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3613f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b0 f3615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Interpolator f3616i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f3618k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f3619l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f3620m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f3622o;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public w.g f3614g = new w.g();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f3617j = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Rect f3621n = new Rect();

        public b(b0 controller, o motionController, int duration, int upDuration, int mode, Interpolator interpolator, int setTag, int clearTag) {
            this.f3622o = false;
            this.f3615h = controller;
            this.f3611d = motionController;
            this.f3612e = duration;
            this.f3613f = upDuration;
            long jNanoTime = System.nanoTime();
            this.f3610c = jNanoTime;
            this.f3620m = jNanoTime;
            this.f3615h.c(this);
            this.f3616i = interpolator;
            this.f3608a = setTag;
            this.f3609b = clearTag;
            if (mode == 3) {
                this.f3622o = true;
            }
            this.f3619l = duration == 0 ? Float.MAX_VALUE : 1.0f / duration;
            a();
        }

        public void a() {
            if (this.f3617j) {
                c();
            } else {
                b();
            }
        }

        public void b() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.f3620m;
            this.f3620m = jNanoTime;
            float f10 = this.f3618k + (((float) (j10 * 1.0E-6d)) * this.f3619l);
            this.f3618k = f10;
            if (f10 >= 1.0f) {
                this.f3618k = 1.0f;
            }
            Interpolator interpolator = this.f3616i;
            float interpolation = interpolator == null ? this.f3618k : interpolator.getInterpolation(this.f3618k);
            o oVar = this.f3611d;
            boolean zL = oVar.L(oVar.f3844b, interpolation, jNanoTime, this.f3614g);
            if (this.f3618k >= 1.0f) {
                if (this.f3608a != -1) {
                    this.f3611d.J().setTag(this.f3608a, Long.valueOf(System.nanoTime()));
                }
                if (this.f3609b != -1) {
                    this.f3611d.J().setTag(this.f3609b, null);
                }
                if (!this.f3622o) {
                    this.f3615h.k(this);
                }
            }
            if (this.f3618k < 1.0f || zL) {
                this.f3615h.g();
            }
        }

        public void c() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.f3620m;
            this.f3620m = jNanoTime;
            float f10 = this.f3618k - (((float) (j10 * 1.0E-6d)) * this.f3619l);
            this.f3618k = f10;
            if (f10 < 0.0f) {
                this.f3618k = 0.0f;
            }
            Interpolator interpolator = this.f3616i;
            float interpolation = interpolator == null ? this.f3618k : interpolator.getInterpolation(this.f3618k);
            o oVar = this.f3611d;
            boolean zL = oVar.L(oVar.f3844b, interpolation, jNanoTime, this.f3614g);
            if (this.f3618k <= 0.0f) {
                if (this.f3608a != -1) {
                    this.f3611d.J().setTag(this.f3608a, Long.valueOf(System.nanoTime()));
                }
                if (this.f3609b != -1) {
                    this.f3611d.J().setTag(this.f3609b, null);
                }
                this.f3615h.k(this);
            }
            if (this.f3618k > 0.0f || zL) {
                this.f3615h.g();
            }
        }

        public void d(int action, float x10, float y10) {
            if (action == 1) {
                if (this.f3617j) {
                    return;
                }
                e(true);
            } else {
                if (action != 2) {
                    return;
                }
                this.f3611d.J().getHitRect(this.f3621n);
                if (this.f3621n.contains((int) x10, (int) y10) || this.f3617j) {
                    return;
                }
                e(true);
            }
        }

        public void e(boolean dir) {
            int i10;
            this.f3617j = dir;
            if (dir && (i10 = this.f3613f) != -1) {
                this.f3619l = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            }
            this.f3615h.g();
            this.f3620m = System.nanoTime();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a0(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.a0.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View[] viewArr) {
        if (this.f3600q != -1) {
            for (View view : viewArr) {
                view.setTag(this.f3600q, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f3601r != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f3601r, null);
            }
        }
    }

    public void b(b0 controller, MotionLayout motionLayout, View view) {
        o oVar = new o(view);
        oVar.R(view);
        this.f3590g.a(oVar);
        oVar.a0(motionLayout.getWidth(), motionLayout.getHeight(), this.f3592i, System.nanoTime());
        new b(controller, oVar, this.f3592i, this.f3593j, this.f3586c, f(motionLayout.getContext()), this.f3600q, this.f3601r);
    }

    public void c(b0 controller, MotionLayout layout, int fromId, androidx.constraintlayout.widget.d current, final View... views) {
        if (this.f3587d) {
            return;
        }
        int i10 = this.f3589f;
        if (i10 == 2) {
            b(controller, layout, views[0]);
            return;
        }
        if (i10 == 1) {
            for (int i11 : layout.getConstraintSetIds()) {
                if (i11 != fromId) {
                    androidx.constraintlayout.widget.d dVarH0 = layout.H0(i11);
                    for (View view : views) {
                        d.a aVarK0 = dVarH0.k0(view.getId());
                        d.a aVar = this.f3591h;
                        if (aVar != null) {
                            aVar.h(aVarK0);
                            aVarK0.f4297g.putAll(this.f3591h.f4297g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.I(current);
        for (View view2 : views) {
            d.a aVarK02 = dVar.k0(view2.getId());
            d.a aVar2 = this.f3591h;
            if (aVar2 != null) {
                aVar2.h(aVarK02);
                aVarK02.f4297g.putAll(this.f3591h.f4297g);
            }
        }
        layout.r1(fromId, dVar);
        int i12 = R.id.view_transition;
        layout.r1(i12, current);
        layout.I(i12, -1, -1);
        t.b bVar = new t.b(-1, layout.C1, i12, fromId);
        for (View view3 : views) {
            v(bVar, view3);
        }
        layout.setTransition(bVar);
        layout.k1(new Runnable() { // from class: androidx.constraintlayout.motion.widget.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f4019a.l(views);
            }
        });
    }

    public boolean d(View view) {
        int i10 = this.f3602s;
        boolean z10 = i10 == -1 || view.getTag(i10) != null;
        int i11 = this.f3603t;
        return z10 && (i11 == -1 || view.getTag(i11) == null);
    }

    public int e() {
        return this.f3585b;
    }

    public Interpolator f(Context context) {
        int i10 = this.f3596m;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f3598o);
        }
        if (i10 == -1) {
            return new a(this, w.d.c(this.f3597n));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f3604u;
    }

    public int h() {
        return this.f3606w;
    }

    public int i() {
        return this.f3605v;
    }

    public int j() {
        return this.f3586c;
    }

    public boolean k() {
        return !this.f3587d;
    }

    public boolean m(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f3594k == -1 && this.f3595l == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f3594k) {
            return true;
        }
        return this.f3595l != null && (view.getLayoutParams() instanceof ConstraintLayout.b) && (str = ((ConstraintLayout.b) view.getLayoutParams()).f4078c0) != null && str.matches(this.f3595l);
    }

    public final void n(Context context, XmlPullParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f3585b = typedArrayObtainStyledAttributes.getResourceId(index, this.f3585b);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.f3495k9) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f3594k);
                    this.f3594k = resourceId;
                    if (resourceId == -1) {
                        this.f3595l = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f3595l = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f3594k = typedArrayObtainStyledAttributes.getResourceId(index, this.f3594k);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.f3586c = typedArrayObtainStyledAttributes.getInt(index, this.f3586c);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.f3587d = typedArrayObtainStyledAttributes.getBoolean(index, this.f3587d);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.f3588e = typedArrayObtainStyledAttributes.getInt(index, this.f3588e);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.f3592i = typedArrayObtainStyledAttributes.getInt(index, this.f3592i);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.f3593j = typedArrayObtainStyledAttributes.getInt(index, this.f3593j);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f3589f = typedArrayObtainStyledAttributes.getInt(index, this.f3589f);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f3598o = resourceId2;
                    if (resourceId2 != -1) {
                        this.f3596m = -2;
                    }
                } else if (i11 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f3597n = string;
                    if (string == null || string.indexOf(fh.a.f28350w) <= 0) {
                        this.f3596m = -1;
                    } else {
                        this.f3598o = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f3596m = -2;
                    }
                } else {
                    this.f3596m = typedArrayObtainStyledAttributes.getInteger(index, this.f3596m);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.f3600q = typedArrayObtainStyledAttributes.getResourceId(index, this.f3600q);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.f3601r = typedArrayObtainStyledAttributes.getResourceId(index, this.f3601r);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.f3602s = typedArrayObtainStyledAttributes.getResourceId(index, this.f3602s);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.f3603t = typedArrayObtainStyledAttributes.getResourceId(index, this.f3603t);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.f3605v = typedArrayObtainStyledAttributes.getResourceId(index, this.f3605v);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.f3604u = typedArrayObtainStyledAttributes.getInteger(index, this.f3604u);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void o(boolean enable) {
        this.f3587d = !enable;
    }

    public void p(int id2) {
        this.f3585b = id2;
    }

    public void q(int sharedValue) {
        this.f3604u = sharedValue;
    }

    public void r(int sharedValueCurrent) {
        this.f3606w = sharedValueCurrent;
    }

    public void s(int sharedValueID) {
        this.f3605v = sharedValueID;
    }

    public void t(int stateTransition) {
        this.f3586c = stateTransition;
    }

    public String toString() {
        return "ViewTransition(" + c.i(this.f3599p, this.f3585b) + ee.a.f26979d;
    }

    public boolean u(int action) {
        int i10 = this.f3586c;
        return i10 == 1 ? action == 0 : i10 == 2 ? action == 1 : i10 == 3 && action == 0;
    }

    public final void v(t.b transition, View view) {
        int i10 = this.f3592i;
        if (i10 != -1) {
            transition.O(i10);
        }
        transition.V(this.f3588e);
        transition.R(this.f3596m, this.f3597n, this.f3598o);
        int id2 = view.getId();
        i iVar = this.f3590g;
        if (iVar != null) {
            ArrayList<f> arrayListD = iVar.d(-1);
            i iVar2 = new i();
            Iterator<f> it2 = arrayListD.iterator();
            while (it2.hasNext()) {
                iVar2.c(it2.next().clone().k(id2));
            }
            transition.t(iVar2);
        }
    }
}
