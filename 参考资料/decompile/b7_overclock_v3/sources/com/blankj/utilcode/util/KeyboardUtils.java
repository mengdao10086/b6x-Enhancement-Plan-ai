package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyboardUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11457a = -8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f11458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11459c;

    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f11460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f11461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f11462c;

        public a(Window window, int[] iArr, c cVar) {
            this.f11460a = window;
            this.f11461b = iArr;
            this.f11462c = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i10 = KeyboardUtils.i(this.f11460a);
            if (this.f11461b[0] != i10) {
                this.f11462c.a(i10);
                this.f11461b[0] = i10;
            }
        }
    }

    public static class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f11463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f11464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f11465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11466d;

        public b(Window window, int[] iArr, View view, int i10) {
            this.f11463a = window;
            this.f11464b = iArr;
            this.f11465c = view;
            this.f11466d = i10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iH = KeyboardUtils.h(this.f11463a);
            if (this.f11464b[0] != iH) {
                View view = this.f11465c;
                view.setPadding(view.getPaddingLeft(), this.f11465c.getPaddingTop(), this.f11465c.getPaddingRight(), this.f11466d + KeyboardUtils.i(this.f11463a));
                this.f11464b[0] = iH;
            }
        }
    }

    public interface c {
        void a(int i10);
    }

    public KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void c() {
    }

    public static void d(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        e(activity.getWindow());
    }

    public static void e(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        window.setSoftInputMode(window.getAttributes().softInputMode & (-17));
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        View childAt = frameLayout.getChildAt(0);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b(window, new int[]{h(window)}, childAt, childAt.getPaddingBottom()));
    }

    public static void f(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        g(activity.getWindow());
    }

    public static void g(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        InputMethodManager inputMethodManager = (InputMethodManager) j1.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i10]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int h(Window window) {
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById == null) {
            return 0;
        }
        Rect rect = new Rect();
        viewFindViewById.getWindowVisibleDisplayFrame(rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getContentViewInvisibleHeight: ");
        sb2.append(viewFindViewById.getBottom() - rect.bottom);
        int iAbs = Math.abs(viewFindViewById.getBottom() - rect.bottom);
        if (iAbs <= l1.e0() + l1.a0()) {
            return 0;
        }
        return iAbs;
    }

    public static int i(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDecorViewInvisibleHeight: ");
        sb2.append(decorView.getBottom() - rect.bottom);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs > l1.a0() + l1.e0()) {
            return iAbs - f11459c;
        }
        f11459c = iAbs;
        return 0;
    }

    public static void j(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l(activity.getWindow());
    }

    public static void k(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        InputMethodManager inputMethodManager = (InputMethodManager) j1.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void l(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            View decorView = window.getDecorView();
            View viewFindViewWithTag = decorView.findViewWithTag("keyboardTagView");
            if (viewFindViewWithTag == null) {
                viewFindViewWithTag = new EditText(window.getContext());
                viewFindViewWithTag.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(viewFindViewWithTag, 0, 0);
            }
            currentFocus = viewFindViewWithTag;
            currentFocus.requestFocus();
        }
        k(currentFocus);
    }

    public static void m(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(jElapsedRealtime - f11458b) > 500 && n(activity)) {
            u();
        }
        f11458b = jElapsedRealtime;
    }

    public static boolean n(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return i(activity.getWindow()) > 0;
    }

    public static void o(@g.n0 Activity activity, @g.n0 c cVar) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cVar, "Argument 'listener' of type OnSoftInputChangedListener (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        p(activity.getWindow(), cVar);
    }

    public static void p(@g.n0 Window window, @g.n0 c cVar) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cVar, "Argument 'listener' of type OnSoftInputChangedListener (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        a aVar = new a(window, new int[]{i(window)}, cVar);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        frameLayout.setTag(-8, aVar);
    }

    public static void q() {
        InputMethodManager inputMethodManager = (InputMethodManager) j1.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void r(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (n(activity)) {
            return;
        }
        u();
    }

    public static void s(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t(view, 0);
    }

    public static void t(@g.n0 View view, int i10) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        InputMethodManager inputMethodManager = (InputMethodManager) j1.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i10, new ResultReceiver(new Handler()) { // from class: com.blankj.utilcode.util.KeyboardUtils.1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i11, Bundle bundle) {
                if (i11 == 1 || i11 == 3) {
                    KeyboardUtils.u();
                }
            }
        });
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void u() {
        InputMethodManager inputMethodManager = (InputMethodManager) j1.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }

    public static void v(@g.n0 Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById == null) {
            return;
        }
        Object tag = viewFindViewById.getTag(-8);
        if (tag instanceof ViewTreeObserver.OnGlobalLayoutListener) {
            viewFindViewById.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
        }
    }
}
