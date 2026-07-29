package ku;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import l4.f;

/* JADX INFO: loaded from: classes6.dex */
@TargetApi(19)
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f39254a = "statusBarView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39255b = "marginAdded";

    public static class a implements AppBarLayout.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CollapsingToolbarLayout f39256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f39257b;

        public a(CollapsingToolbarLayout collapsingToolbarLayout, View view) {
            this.f39256a = collapsingToolbarLayout;
            this.f39257b = view;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.h, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i10) {
            if (Math.abs(i10) > appBarLayout.getHeight() - this.f39256a.getScrimVisibleHeightTrigger()) {
                if (this.f39257b.getAlpha() == 0.0f) {
                    this.f39257b.animate().cancel();
                    this.f39257b.animate().alpha(1.0f).setDuration(this.f39256a.getScrimAnimationDuration()).start();
                    return;
                }
                return;
            }
            if (this.f39257b.getAlpha() == 1.0f) {
                this.f39257b.animate().cancel();
                this.f39257b.animate().alpha(0.0f).setDuration(this.f39256a.getScrimAnimationDuration()).start();
            }
        }
    }

    public static View a(Activity activity, int i10, int i11) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i11);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i10);
        view.setTag(f39254a);
        viewGroup.addView(view);
        return view;
    }

    public static void b(View view, int i10) {
        if (view == null || f39255b.equals(view.getTag())) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin += i10;
        view.setLayoutParams(layoutParams);
        view.setTag(f39255b);
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", f.f39447b);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    public static void d(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View viewFindViewWithTag = viewGroup.findViewWithTag(f39254a);
        if (viewFindViewWithTag != null) {
            viewGroup.removeView(viewFindViewWithTag);
        }
    }

    public static void e(View view, int i10) {
        if (view != null && f39255b.equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i10;
            view.setLayoutParams(layoutParams);
            view.setTag(null);
        }
    }

    public static void f(Activity activity, int i10) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        int iC = c(activity);
        d(activity);
        a(activity, i10, iC);
        b(childAt, iC);
        if (childAt != null) {
            u0.O1(childAt, false);
        }
    }

    public static void g(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, int i10) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        childAt.setFitsSystemWindows(false);
        ((View) appBarLayout.getParent()).setFitsSystemWindows(false);
        appBarLayout.setFitsSystemWindows(false);
        collapsingToolbarLayout.setFitsSystemWindows(false);
        collapsingToolbarLayout.getChildAt(0).setFitsSystemWindows(false);
        toolbar.setFitsSystemWindows(false);
        if (toolbar.getTag() == null) {
            CollapsingToolbarLayout.c cVar = (CollapsingToolbarLayout.c) toolbar.getLayoutParams();
            int iC = c(activity);
            ((FrameLayout.LayoutParams) cVar).height += iC;
            toolbar.setLayoutParams(cVar);
            toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + iC, toolbar.getPaddingRight(), toolbar.getPaddingBottom());
            toolbar.setTag(Boolean.TRUE);
        }
        int iC2 = c(activity);
        d(activity);
        e(childAt, iC2);
        View viewA = a(activity, i10, iC2);
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) appBarLayout.getLayoutParams()).f();
        if (cVarF == null || !(cVarF instanceof AppBarLayout.Behavior) || Math.abs(((AppBarLayout.Behavior) cVarF).H()) <= appBarLayout.getHeight() - collapsingToolbarLayout.getScrimVisibleHeightTrigger()) {
            viewA.setAlpha(0.0f);
        } else {
            viewA.setAlpha(1.0f);
        }
        appBarLayout.e(new a(collapsingToolbarLayout, viewA));
    }

    public static void h(Activity activity) {
        activity.getWindow().addFlags(67108864);
        View childAt = ((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0);
        d(activity);
        e(childAt, c(activity));
        if (childAt != null) {
            u0.O1(childAt, false);
        }
    }
}
