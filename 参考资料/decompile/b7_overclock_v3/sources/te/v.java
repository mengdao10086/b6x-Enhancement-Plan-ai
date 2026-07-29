package te;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import com.google.common.collect.LinkedHashMultimap;
import g.d0;
import g.n0;
import g.p0;
import g.v0;
import g.x;
import le.o;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f51238a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.f
    public static final int f51239b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f51240c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51241d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RectF f51242e = new RectF();

    public class a implements o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RectF f51243a;

        public a(RectF rectF) {
            this.f51243a = rectF;
        }

        @Override // le.o.c
        @n0
        public le.d a(@n0 le.d dVar) {
            return dVar instanceof le.m ? dVar : new le.m(dVar.a(this.f51243a) / this.f51243a.height());
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RectF f51244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RectF f51245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f51246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f51247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f51248e;

        public b(RectF rectF, RectF rectF2, float f10, float f11, float f12) {
            this.f51244a = rectF;
            this.f51245b = rectF2;
            this.f51246c = f10;
            this.f51247d = f11;
            this.f51248e = f12;
        }

        @Override // te.v.d
        @n0
        public le.d a(@n0 le.d dVar, @n0 le.d dVar2) {
            return new le.a(v.l(dVar.a(this.f51244a), dVar2.a(this.f51245b), this.f51246c, this.f51247d, this.f51248e));
        }
    }

    public interface c {
        void a(Canvas canvas);
    }

    public interface d {
        @n0
        le.d a(@n0 le.d dVar, @n0 le.d dVar2);
    }

    public static float a(@n0 RectF rectF) {
        return rectF.width() * rectF.height();
    }

    public static le.o b(le.o oVar, RectF rectF) {
        return oVar.y(new a(rectF));
    }

    public static Shader c(@g.l int i10) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i10, i10, Shader.TileMode.CLAMP);
    }

    @n0
    public static <T> T d(@p0 T t10, @n0 T t11) {
        return t10 != null ? t10 : t11;
    }

    public static View e(View view, @d0 int i10) {
        String resourceName = view.getResources().getResourceName(i10);
        while (view != null) {
            if (view.getId() != i10) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    public static View f(View view, @d0 int i10) {
        View viewFindViewById = view.findViewById(i10);
        return viewFindViewById != null ? viewFindViewById : e(view, i10);
    }

    public static RectF g(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    public static RectF h(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public static Rect i(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public static boolean j(le.o oVar, RectF rectF) {
        return (oVar.r().a(rectF) == 0.0f && oVar.t().a(rectF) == 0.0f && oVar.l().a(rectF) == 0.0f && oVar.j().a(rectF) == 0.0f) ? false : true;
    }

    public static float k(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static float l(float f10, float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f13, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f14) {
        return m(f10, f11, f12, f13, f14, false);
    }

    public static float m(float f10, float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f13, @x(from = 0.0d) float f14, boolean z10) {
        return (!z10 || (f14 >= 0.0f && f14 <= 1.0f)) ? f14 < f12 ? f10 : f14 > f13 ? f11 : k(f10, f11, (f14 - f12) / (f13 - f12)) : k(f10, f11, f14);
    }

    public static int n(int i10, int i11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12) {
        return f12 < f10 ? i10 : f12 > f11 ? i11 : (int) k(i10, i11, (f12 - f10) / (f11 - f10));
    }

    public static le.o o(le.o oVar, le.o oVar2, RectF rectF, RectF rectF2, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12) {
        return f12 < f10 ? oVar : f12 > f11 ? oVar2 : x(oVar, oVar2, rectF, new b(rectF, rectF2, f10, f11, f12));
    }

    public static void p(TransitionSet transitionSet, @p0 Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    public static boolean q(Transition transition, Context context, @g.f int i10) {
        int iF;
        if (i10 == 0 || transition.getDuration() != -1 || (iF = ee.a.f(context, i10, -1)) == -1) {
            return false;
        }
        transition.setDuration(iF);
        return true;
    }

    public static boolean r(Transition transition, Context context, @g.f int i10, TimeInterpolator timeInterpolator) {
        if (i10 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(ee.a.g(context, i10, timeInterpolator));
        return true;
    }

    public static boolean s(Transition transition, Context context, @g.f int i10) {
        PathMotion pathMotionU;
        if (i10 == 0 || (pathMotionU = u(context, i10)) == null) {
            return false;
        }
        transition.setPathMotion(pathMotionU);
        return true;
    }

    public static void t(TransitionSet transitionSet, @p0 Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    @p0
    public static PathMotion u(Context context, @g.f int i10) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.type;
        if (i11 != 16) {
            if (i11 == 3) {
                return new PatternPathMotion(m0.n.e(String.valueOf(typedValue.string)));
            }
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
        int i12 = typedValue.data;
        if (i12 == 0) {
            return null;
        }
        if (i12 == 1) {
            return new k();
        }
        throw new IllegalArgumentException("Invalid motion path type: " + i12);
    }

    public static int v(Canvas canvas, Rect rect, int i10) {
        RectF rectF = f51242e;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i10);
    }

    public static void w(Canvas canvas, Rect rect, float f10, float f11, float f12, int i10, c cVar) {
        if (i10 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f10, f11);
        canvas.scale(f12, f12);
        if (i10 < 255) {
            v(canvas, rect, i10);
        }
        cVar.a(canvas);
        canvas.restoreToCount(iSave);
    }

    public static le.o x(le.o oVar, le.o oVar2, RectF rectF, d dVar) {
        return (j(oVar, rectF) ? oVar : oVar2).v().L(dVar.a(oVar.r(), oVar2.r())).Q(dVar.a(oVar.t(), oVar2.t())).y(dVar.a(oVar.j(), oVar2.j())).D(dVar.a(oVar.l(), oVar2.l())).m();
    }
}
