package tg;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.e0;
import androidx.core.view.i0;
import androidx.core.view.q0;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public class b implements Interpolator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f51276b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f51277c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static float f51278d = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f51279e = 8.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f51280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f51281g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51282a;

    static {
        float fL = 1.0f / l(1.0f);
        f51280f = fL;
        f51281g = 1.0f - (fL * l(1.0f));
    }

    public b(int i10) {
        this.f51282a = i10;
    }

    public static boolean a(@n0 View view, PointF pointF, boolean z10) {
        if (c(view, 1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !g(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (h(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ("fixed".equals(childAt.getTag()) || "fixed-top".equals(childAt.getTag())) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zA = a(childAt, pointF, z10);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zA;
                }
            }
        }
        return z10 || c(view, -1);
    }

    public static boolean b(@n0 View view, PointF pointF) {
        if (c(view, -1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (h(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                if ("fixed".equals(childAt.getTag()) || "fixed-bottom".equals(childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zB = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zB;
            }
        }
        return true;
    }

    public static boolean c(@n0 View view, int i10) {
        return view.canScrollVertically(i10);
    }

    public static int d(float f10) {
        return (int) ((f10 * f51278d) + 0.5f);
    }

    public static void e(View view, int i10) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i10);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i10);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i10);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).s(i10);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).m0(0, i10);
        }
    }

    public static boolean f(View view) {
        return g(view) || (view instanceof ViewPager) || (view instanceof i0);
    }

    public static boolean g(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof q0) || (view instanceof WebView) || (view instanceof e0);
    }

    public static boolean h(@n0 View view, @n0 View view2, float f10, float f11, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f10, f11};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z10 = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z10 && pointF != null) {
            pointF.set(fArr[0] - f10, fArr[1] - f11);
        }
        return z10;
    }

    public static int i(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i10 = layoutParams.height;
        view.measure(childMeasureSpec, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static float j(int i10) {
        return i10 / f51278d;
    }

    public static void k(@n0 AbsListView absListView, int i10) {
        absListView.scrollListBy(i10);
    }

    public static float l(float f10) {
        float f11 = f10 * 8.0f;
        return f11 < 1.0f ? f11 - (1.0f - ((float) Math.exp(-f11))) : ((1.0f - ((float) Math.exp(1.0f - f11))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (this.f51282a == f51277c) {
            float f11 = 1.0f - f10;
            return 1.0f - (f11 * f11);
        }
        float fL = f51280f * l(f10);
        return fL > 0.0f ? fL + f51281g : fL;
    }
}
