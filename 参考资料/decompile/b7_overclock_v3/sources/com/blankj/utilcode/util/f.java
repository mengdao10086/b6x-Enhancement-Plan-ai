package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11758a = "TAG_STATUS_BAR";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11759b = "TAG_OFFSET";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11760c = -123;

    public f() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void A(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B(activity.getWindow(), z10);
    }

    public static void B(@g.n0 Window window, boolean z10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            int id2 = childAt.getId();
            if (id2 != -1 && "navigationBarBackground".equals(j(id2))) {
                childAt.setVisibility(z10 ? 0 : 4);
            }
        }
        if (z10) {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4611));
        } else {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    @g.y0("android.permission.EXPAND_STATUS_BAR")
    public static void C(boolean z10) {
        n(z10 ? "expandNotificationsPanel" : "collapsePanels");
    }

    public static View D(@g.n0 Activity activity, @g.l int i10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return E(activity, i10, false);
    }

    public static View E(@g.n0 Activity activity, @g.l int i10, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(activity);
        return c(activity, i10, z10);
    }

    public static View F(@g.n0 Window window, @g.l int i10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return G(window, i10, false);
    }

    public static View G(@g.n0 Window window, @g.l int i10, boolean z10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T(window);
        return d(window, i10, z10);
    }

    public static void H(@g.n0 View view, @g.l int i10) {
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Activity activityI = l1.I(view.getContext());
        if (activityI == null) {
            return;
        }
        S(activityI);
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = k();
        view.setBackgroundColor(i10);
    }

    public static void I(@g.n0 DrawerLayout drawerLayout, @g.n0 View view, @g.l int i10) {
        Objects.requireNonNull(drawerLayout, "Argument 'drawer' of type DrawerLayout (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        J(drawerLayout, view, i10, false);
    }

    public static void J(@g.n0 DrawerLayout drawerLayout, @g.n0 View view, @g.l int i10, boolean z10) {
        Objects.requireNonNull(drawerLayout, "Argument 'drawer' of type DrawerLayout (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Activity activityI = l1.I(view.getContext());
        if (activityI == null) {
            return;
        }
        S(activityI);
        drawerLayout.setFitsSystemWindows(false);
        H(view, i10);
        int childCount = drawerLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            drawerLayout.getChildAt(i11).setFitsSystemWindows(false);
        }
        if (z10) {
            l(activityI);
        } else {
            E(activityI, i10, false);
        }
    }

    public static void K(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Activity activityI = l1.I(view.getContext());
        if (activityI == null) {
            return;
        }
        S(activityI);
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, k()));
        } else {
            layoutParams.width = -1;
            layoutParams.height = k();
        }
    }

    public static void L(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        M(activity.getWindow(), z10);
    }

    public static void M(@g.n0 Window window, boolean z10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z10 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void N(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        O(activity.getWindow(), z10);
    }

    public static void O(@g.n0 Window window, boolean z10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            window.clearFlags(1024);
            P(window);
            b(window);
        } else {
            window.addFlags(1024);
            m(window);
            R(window);
        }
    }

    public static void P(Window window) {
        View viewFindViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(f11758a);
        if (viewFindViewWithTag == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(0);
    }

    public static void Q(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Object tag = view.getTag(f11760c);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - k(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setTag(f11760c, Boolean.FALSE);
    }

    public static void R(Window window) {
        View viewFindViewWithTag = window.getDecorView().findViewWithTag(f11759b);
        if (viewFindViewWithTag == null) {
            return;
        }
        Q(viewFindViewWithTag);
    }

    public static void S(Activity activity) {
        T(activity.getWindow());
    }

    public static void T(Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }

    public static void a(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        view.setTag(f11759b);
        Object tag = view.getTag(f11760c);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + k(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(f11760c, Boolean.TRUE);
        }
    }

    public static void b(Window window) {
        View viewFindViewWithTag = window.getDecorView().findViewWithTag(f11759b);
        if (viewFindViewWithTag == null) {
            return;
        }
        a(viewFindViewWithTag);
    }

    public static View c(Activity activity, int i10, boolean z10) {
        return d(activity.getWindow(), i10, z10);
    }

    public static View d(Window window, int i10, boolean z10) {
        ViewGroup viewGroup = z10 ? (ViewGroup) window.getDecorView() : (ViewGroup) window.findViewById(R.id.content);
        View viewFindViewWithTag = viewGroup.findViewWithTag(f11758a);
        if (viewFindViewWithTag == null) {
            View viewE = e(window.getContext(), i10);
            viewGroup.addView(viewE);
            return viewE;
        }
        if (viewFindViewWithTag.getVisibility() == 8) {
            viewFindViewWithTag.setVisibility(0);
        }
        viewFindViewWithTag.setBackgroundColor(i10);
        return viewFindViewWithTag;
    }

    public static View e(Context context, int i10) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, k()));
        view.setBackgroundColor(i10);
        view.setTag(f11758a);
        return view;
    }

    public static int f() {
        TypedValue typedValue = new TypedValue();
        if (j1.a().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, j1.a().getResources().getDisplayMetrics());
        }
        return 0;
    }

    @g.v0(21)
    public static int g(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(activity.getWindow());
    }

    @g.v0(21)
    public static int h(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return window.getNavigationBarColor();
    }

    public static int i() {
        Resources resources = j1.a().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", l4.f.f39447b);
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String j(int i10) {
        try {
            return j1.a().getResources().getResourceEntryName(i10);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k() {
        Resources resources = j1.a().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", l4.f.f39447b));
    }

    public static void l(Activity activity) {
        m(activity.getWindow());
    }

    public static void m(Window window) {
        View viewFindViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(f11758a);
        if (viewFindViewWithTag == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(8);
    }

    public static void n(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(j1.a().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean o(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return p(activity.getWindow());
    }

    public static boolean p(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Build.VERSION.SDK_INT >= 26 && (window.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    public static boolean q(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return r(activity.getWindow());
    }

    public static boolean r(@g.n0 Window window) {
        boolean z10;
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                z10 = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i10);
            int id2 = childAt.getId();
            if (id2 != -1 && "navigationBarBackground".equals(j(id2)) && childAt.getVisibility() == 0) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return z10;
        }
        if (l1.A0() && Build.VERSION.SDK_INT < 29) {
            try {
                return Settings.Global.getInt(j1.a().getContentResolver(), "navigationbar_hide_bar_enabled") == 0;
            } catch (Exception unused) {
            }
        }
        return (viewGroup.getSystemUiVisibility() & 2) == 0;
    }

    public static boolean s(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(activity.getWindow());
    }

    public static boolean t(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Build.VERSION.SDK_INT >= 23 && (window.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public static boolean u(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (activity.getWindow().getAttributes().flags & 1024) == 0;
    }

    public static boolean v() {
        WindowManager windowManager = (WindowManager) j1.a().getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.y == point.y && point2.x == point.x) ? false : true;
    }

    @g.v0(21)
    public static void w(@g.n0 Activity activity, @g.l int i10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        x(activity.getWindow(), i10);
    }

    @g.v0(21)
    public static void x(@g.n0 Window window, @g.l int i10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i10);
    }

    public static void y(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        z(activity.getWindow(), z10);
    }

    public static void z(@g.n0 Window window, boolean z10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z10 ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }
}
