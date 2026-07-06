package a;

import a.ni;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public abstract class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ThreadLocal<Rect> f6002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WeakHashMap<View, String> f730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f731a;
    public static Field b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static WeakHashMap<View, lh> f732b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f733b;
    public static Field c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f734c;

    static {
        new AtomicInteger(1);
        f732b = null;
        f734c = false;
        new vg();
    }

    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f731a) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f729a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f731a = true;
        }
        Field field = f729a;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void A0(View view) {
        if (w(view) == 0) {
            t0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (w((View) parent) == 4) {
                t0(view, 2);
                return;
            }
        }
    }

    public static rf B(View view) {
        rf rfVarJ = j(view);
        if (rfVarJ == null) {
            rfVarJ = new rf();
        }
        k0(view, rfVarJ);
        return rfVarJ;
    }

    public static wg<CharSequence> B0() {
        return new tg(ra.tag_state_description, CharSequence.class, 64, 30);
    }

    public static int C(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void C0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof hg) {
            ((hg) view).stopNestedScroll();
        }
    }

    public static int D(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static void D0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static ViewParent E(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static sh F(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return zg.a(view);
        }
        if (i >= 21) {
            return yg.c(view);
        }
        return null;
    }

    public static final CharSequence G(View view) {
        return B0().d(view);
    }

    public static String H(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f730a;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static ki I(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return bh.a(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return qh.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static int J(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean L(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean M(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean O(View view) {
        Boolean boolD = a().d(view);
        if (boolD == null) {
            return false;
        }
        return boolD.booleanValue();
    }

    public static boolean P(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean Q(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean R(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof hg) {
            return ((hg) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean T(View view) {
        Boolean boolD = j0().d(view);
        if (boolD == null) {
            return false;
        }
        return boolD.booleanValue();
    }

    public static void U(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = n(view) != null && view.getVisibility() == 0;
            if (m(view) != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(n(view));
                    A0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(n(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    public static void V(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        if (i2 < 21) {
            d(view, i);
            return;
        }
        Rect rectU = u();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectU.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectU.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        d(view, i);
        if (z && rectU.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectU);
        }
    }

    public static void W(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        if (i2 < 21) {
            e(view, i);
            return;
        }
        Rect rectU = u();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectU.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectU.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        e(view, i);
        if (z && rectU.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectU);
        }
    }

    public static sh X(View view, sh shVar) {
        WindowInsets windowInsetsR;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsR = shVar.r()) != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsR);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsR)) {
                return sh.t(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return shVar;
    }

    public static void Y(View view, ni niVar) {
        view.onInitializeAccessibilityNodeInfo(niVar.C0());
    }

    public static wg<CharSequence> Z() {
        return new sg(ra.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static wg<Boolean> a() {
        return new ug(ra.tag_accessibility_heading, Boolean.class, 28);
    }

    public static boolean a0(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    public static void b(View view, ni.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            B(view);
            f0(aVar.b(), view);
            o(view).add(aVar);
            U(view, 0);
        }
    }

    public static void b0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static lh c(View view) {
        if (f732b == null) {
            f732b = new WeakHashMap<>();
        }
        lh lhVar = f732b.get(view);
        if (lhVar != null) {
            return lhVar;
        }
        lh lhVar2 = new lh(view);
        f732b.put(view, lhVar2);
        return lhVar2;
    }

    public static void c0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void d(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            D0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                D0((View) parent);
            }
        }
    }

    public static void d0(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static void e(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            D0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                D0((View) parent);
            }
        }
    }

    public static void e0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            f0(i, view);
            U(view, 0);
        }
    }

    public static sh f(View view, sh shVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? yg.b(view, shVar, rect) : shVar;
    }

    public static void f0(int i, View view) {
        List<ni.a> listO = o(view);
        for (int i2 = 0; i2 < listO.size(); i2++) {
            if (listO.get(i2).b() == i) {
                listO.remove(i2);
                return;
            }
        }
    }

    public static sh g(View view, sh shVar) {
        WindowInsets windowInsetsR;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsR = shVar.r()) != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsR);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsR)) {
                return sh.t(windowInsetsDispatchApplyWindowInsets, view);
            }
        }
        return shVar;
    }

    public static void g0(View view, ni.a aVar, CharSequence charSequence, bj bjVar) {
        if (bjVar == null && charSequence == null) {
            e0(view, aVar.b());
        } else {
            b(view, aVar.a(charSequence, bjVar));
        }
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return dh.a(view).b(view, keyEvent);
    }

    public static void h0(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return dh.a(view).f(keyEvent);
    }

    public static void i0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            ah.a(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static rf j(View view) {
        View.AccessibilityDelegate accessibilityDelegateK = k(view);
        if (accessibilityDelegateK == null) {
            return null;
        }
        return accessibilityDelegateK instanceof qf ? ((qf) accessibilityDelegateK).f7206a : new rf(accessibilityDelegateK);
    }

    public static wg<Boolean> j0() {
        return new rg(ra.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static View.AccessibilityDelegate k(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : l(view);
    }

    public static void k0(View view, rf rfVar) {
        if (rfVar == null && (k(view) instanceof qf)) {
            rfVar = new rf();
        }
        view.setAccessibilityDelegate(rfVar == null ? null : rfVar.d());
    }

    public static View.AccessibilityDelegate l(View view) {
        if (f734c) {
            return null;
        }
        if (c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f734c = true;
                return null;
            }
        }
        try {
            Object obj = c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f734c = true;
            return null;
        }
    }

    public static void l0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void m0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static CharSequence n(View view) {
        return Z().d(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n0(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof qg) {
                ((qg) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static List<ni.a> o(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(ra.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(ra.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o0(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof qg) {
                ((qg) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof qg) {
            return ((qg) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void p0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof qg) {
            return ((qg) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void q0(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    public static Rect r(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    @Deprecated
    public static void r0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static Display s(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (P(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void s0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static float t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void t0(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            if (i2 < 16) {
                return;
            }
            if (i == 4) {
                i = 2;
            }
        }
        view.setImportantForAccessibility(i);
    }

    public static Rect u() {
        if (f6002a == null) {
            f6002a = new ThreadLocal<>();
        }
        Rect rect = f6002a.get();
        if (rect == null) {
            rect = new Rect();
            f6002a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void u0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void v0(View view, ng ngVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            yg.d(view, ngVar);
        }
    }

    public static int w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void w0(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int x(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void x0(View view, pg pgVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pgVar != null ? pgVar.a() : null));
        }
    }

    public static int y(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void y0(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f733b) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f733b = true;
        }
        Field field = b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void z0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f730a == null) {
            f730a = new WeakHashMap<>();
        }
        f730a.put(view, str);
    }
}
