package ku;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;
import l4.f;

/* JADX INFO: loaded from: classes6.dex */
@TargetApi(21)
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ValueAnimator f39258a;

    public static class a implements k0 {
        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            return j1Var;
        }
    }

    public static class b implements AppBarLayout.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f39259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CollapsingToolbarLayout f39260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f39261c;

        public b(WeakReference weakReference, CollapsingToolbarLayout collapsingToolbarLayout, int i10) {
            this.f39259a = weakReference;
            this.f39260b = collapsingToolbarLayout;
            this.f39261c = i10;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.h, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i10) {
            Window window = (Window) this.f39259a.get();
            if (window != null) {
                if (Math.abs(i10) > appBarLayout.getHeight() - this.f39260b.getScrimVisibleHeightTrigger()) {
                    if (window.getStatusBarColor() != this.f39261c) {
                        d.e(window.getStatusBarColor(), this.f39261c, this.f39260b.getScrimAnimationDuration(), this.f39259a);
                    }
                } else if (window.getStatusBarColor() != 0) {
                    d.e(window.getStatusBarColor(), 0, this.f39260b.getScrimAnimationDuration(), this.f39259a);
                }
            }
        }
    }

    public static class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f39262a;

        public c(WeakReference weakReference) {
            this.f39262a = weakReference;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Window window = (Window) this.f39262a.get();
            if (window != null) {
                window.setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", f.f39447b);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    public static void c(Activity activity, int i10) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i10);
        window.getDecorView().setSystemUiVisibility(0);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            u0.O1(childAt, false);
            u0.v1(childAt);
        }
    }

    public static void d(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, int i10) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(0);
        u0.a2(collapsingToolbarLayout, new a());
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            u0.O1(childAt, false);
            u0.v1(childAt);
        }
        ((View) appBarLayout.getParent()).setFitsSystemWindows(false);
        appBarLayout.setFitsSystemWindows(false);
        toolbar.setFitsSystemWindows(false);
        if (toolbar.getTag() == null) {
            CollapsingToolbarLayout.c cVar = (CollapsingToolbarLayout.c) toolbar.getLayoutParams();
            int iB = b(activity);
            ((FrameLayout.LayoutParams) cVar).height += iB;
            toolbar.setLayoutParams(cVar);
            toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + iB, toolbar.getPaddingRight(), toolbar.getPaddingBottom());
            toolbar.setTag(Boolean.TRUE);
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) appBarLayout.getLayoutParams()).f();
        if (cVarF == null || !(cVarF instanceof AppBarLayout.Behavior) || Math.abs(((AppBarLayout.Behavior) cVarF).H()) <= appBarLayout.getHeight() - collapsingToolbarLayout.getScrimVisibleHeightTrigger()) {
            window.setStatusBarColor(0);
        } else {
            window.setStatusBarColor(i10);
        }
        collapsingToolbarLayout.setFitsSystemWindows(false);
        appBarLayout.e(new b(new WeakReference(window), collapsingToolbarLayout, i10));
        collapsingToolbarLayout.getChildAt(0).setFitsSystemWindows(false);
        collapsingToolbarLayout.setStatusBarScrimColor(i10);
    }

    public static void e(int i10, int i11, long j10, WeakReference<Window> weakReference) {
        ValueAnimator valueAnimator = f39258a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator duration = ValueAnimator.ofArgb(i10, i11).setDuration(j10);
        f39258a = duration;
        duration.addUpdateListener(new c(weakReference));
        f39258a.start();
    }

    public static void f(Activity activity, boolean z10) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z10) {
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } else {
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(0);
        }
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            u0.O1(childAt, false);
            u0.v1(childAt);
        }
    }
}
