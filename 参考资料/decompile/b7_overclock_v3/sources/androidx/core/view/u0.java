package androidx.core.view;

import a1.d;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.a;
import androidx.core.view.g1;
import androidx.core.view.j1;
import com.google.common.collect.LinkedHashMultimap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class u0 {
    public static final int A = 1;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 4;
    public static final int E = 8;
    public static final int F = 16;
    public static final int G = 32;
    public static Field I = null;
    public static boolean J = false;
    public static Field K = null;
    public static boolean L = false;
    public static Method M = null;
    public static Method N = null;
    public static boolean O = false;
    public static WeakHashMap<View, String> P = null;
    public static Method R = null;
    public static Field S = null;
    public static ThreadLocal<Rect> U = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5089a = "ViewCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f5090b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f5091c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f5092d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5093e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5094f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5095g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5096h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5097i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5098j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5099k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final int f5100l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final int f5101m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final int f5102n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5103o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5104p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5105q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5106r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    public static final int f5107s = 16777215;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Deprecated
    public static final int f5108t = -16777216;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Deprecated
    public static final int f5109u = 16;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Deprecated
    public static final int f5110v = 16777216;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5111w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5112x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5113y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f5114z = 0;
    public static final AtomicInteger H = new AtomicInteger(1);
    public static WeakHashMap<View, b1> Q = null;
    public static boolean T = false;
    public static final int[] V = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final m0 W = new m0() { // from class: androidx.core.view.t0
        @Override // androidx.core.view.m0
        public final e a(e eVar) {
            return u0.c1(eVar);
        }
    };
    public static final e X = new e();

    public class a extends f<Boolean> {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // androidx.core.view.u0.f
        @g.v0(28)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(@g.n0 View view) {
            return Boolean.valueOf(q.d(view));
        }

        @Override // androidx.core.view.u0.f
        @g.v0(28)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(@g.n0 View view, Boolean bool) {
            q.i(view, bool.booleanValue());
        }

        @Override // androidx.core.view.u0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface a0 {
    }

    public class b extends f<CharSequence> {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // androidx.core.view.u0.f
        @g.v0(28)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return q.b(view);
        }

        @Override // androidx.core.view.u0.f
        @g.v0(28)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            q.h(view, charSequence);
        }

        @Override // androidx.core.view.u0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface b0 {
    }

    public class c extends f<CharSequence> {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // androidx.core.view.u0.f
        @g.v0(30)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return s.a(view);
        }

        @Override // androidx.core.view.u0.f
        @g.v0(30)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            s.c(view, charSequence);
        }

        @Override // androidx.core.view.u0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public static class c0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f5115d = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.p0
        public WeakHashMap<View, Boolean> f5116a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f5117b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<KeyEvent> f5118c = null;

        public static c0 a(View view) {
            int i10 = R.id.tag_unhandled_key_event_manager;
            c0 c0Var = (c0) view.getTag(i10);
            if (c0Var != null) {
                return c0Var;
            }
            c0 c0Var2 = new c0();
            view.setTag(i10, c0Var2);
            return c0Var2;
        }

        public static void h(View view) {
            ArrayList<WeakReference<View>> arrayList = f5115d;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (it2.next().get() == view) {
                        return;
                    }
                }
                f5115d.add(new WeakReference<>(view));
            }
        }

        public static void i(View view) {
            synchronized (f5115d) {
                int i10 = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = f5115d;
                    if (i10 >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i10).get() == view) {
                        arrayList.remove(i10);
                        return;
                    }
                    i10++;
                }
            }
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(viewC));
                }
            }
            return viewC != null;
        }

        @g.p0
        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f5116a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray<WeakReference<View>> d() {
            if (this.f5117b == null) {
                this.f5117b = new SparseArray<>();
            }
            return this.f5117b;
        }

        public final boolean e(@g.n0 View view, @g.n0 KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((z) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        public boolean f(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f5118c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f5118c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayD = d();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && u0.O0(view)) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f5116a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f5115d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f5116a == null) {
                    this.f5116a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f5115d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f5116a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f5116a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    public class d extends f<Boolean> {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // androidx.core.view.u0.f
        @g.v0(28)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(q.c(view));
        }

        @Override // androidx.core.view.u0.f
        @g.v0(28)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            q.g(view, bool.booleanValue());
        }

        @Override // androidx.core.view.u0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f5119a = new WeakHashMap<>();

        @g.v0(19)
        public void a(View view) {
            this.f5119a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                c(view);
            }
        }

        @g.v0(19)
        public final void b(View view, boolean z10) {
            boolean z11 = view.isShown() && view.getWindowVisibility() == 0;
            if (z10 != z11) {
                u0.d1(view, z11 ? 16 : 32);
                this.f5119a.put(view, Boolean.valueOf(z11));
            }
        }

        @g.v0(19)
        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @g.v0(19)
        public void d(View view) {
            this.f5119a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @g.v0(19)
        public final void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @g.v0(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f5119a.entrySet()) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @g.v0(19)
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f5121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5123d;

        public f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return true;
        }

        public final boolean c() {
            return Build.VERSION.SDK_INT >= this.f5122c;
        }

        public abstract T d(View view);

        public abstract void e(View view, T t10);

        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t10 = (T) view.getTag(this.f5120a);
            if (this.f5121b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        public void g(View view, T t10) {
            if (c()) {
                e(view, t10);
            } else if (b() && h(f(view), t10)) {
                u0.C(view);
                view.setTag(this.f5120a, t10);
                u0.d1(view, this.f5123d);
            }
        }

        public boolean h(T t10, T t11) {
            return !t11.equals(t10);
        }

        public f(int i10, Class<T> cls, int i11, int i12) {
            this.f5120a = i10;
            this.f5121b = cls;
            this.f5123d = i11;
            this.f5122c = i12;
        }
    }

    @g.v0(15)
    public static class g {
        private g() {
        }

        @g.u
        public static boolean a(@g.n0 View view) {
            return view.hasOnClickListeners();
        }
    }

    @g.v0(16)
    public static class h {
        private h() {
        }

        @g.u
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        @g.u
        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        @g.u
        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        @g.u
        public static int d(View view) {
            return view.getMinimumHeight();
        }

        @g.u
        public static int e(View view) {
            return view.getMinimumWidth();
        }

        @g.u
        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        @g.u
        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @g.u
        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        @g.u
        public static boolean i(View view) {
            return view.hasTransientState();
        }

        @g.u
        public static boolean j(View view, int i10, Bundle bundle) {
            return view.performAccessibilityAction(i10, bundle);
        }

        @g.u
        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        @g.u
        public static void l(View view, int i10, int i11, int i12, int i13) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        }

        @g.u
        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @g.u
        public static void n(View view, Runnable runnable, long j10) {
            view.postOnAnimationDelayed(runnable, j10);
        }

        @g.u
        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @g.u
        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        @g.u
        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @g.u
        public static void r(View view, boolean z10) {
            view.setHasTransientState(z10);
        }

        @g.u
        public static void s(View view, int i10) {
            view.setImportantForAccessibility(i10);
        }
    }

    @g.v0(17)
    public static class i {
        private i() {
        }

        @g.u
        public static int a() {
            return View.generateViewId();
        }

        @g.u
        public static Display b(@g.n0 View view) {
            return view.getDisplay();
        }

        @g.u
        public static int c(View view) {
            return view.getLabelFor();
        }

        @g.u
        public static int d(View view) {
            return view.getLayoutDirection();
        }

        @g.u
        public static int e(View view) {
            return view.getPaddingEnd();
        }

        @g.u
        public static int f(View view) {
            return view.getPaddingStart();
        }

        @g.u
        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        @g.u
        public static void h(View view, int i10) {
            view.setLabelFor(i10);
        }

        @g.u
        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        @g.u
        public static void j(View view, int i10) {
            view.setLayoutDirection(i10);
        }

        @g.u
        public static void k(View view, int i10, int i11, int i12, int i13) {
            view.setPaddingRelative(i10, i11, i12, i13);
        }
    }

    @g.v0(18)
    public static class j {
        private j() {
        }

        @g.u
        public static Rect a(@g.n0 View view) {
            return view.getClipBounds();
        }

        @g.u
        public static boolean b(@g.n0 View view) {
            return view.isInLayout();
        }

        @g.u
        public static void c(@g.n0 View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    @g.v0(19)
    public static class k {
        private k() {
        }

        @g.u
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        @g.u
        public static boolean b(@g.n0 View view) {
            return view.isAttachedToWindow();
        }

        @g.u
        public static boolean c(@g.n0 View view) {
            return view.isLaidOut();
        }

        @g.u
        public static boolean d(@g.n0 View view) {
            return view.isLayoutDirectionResolved();
        }

        @g.u
        public static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }

        @g.u
        public static void f(View view, int i10) {
            view.setAccessibilityLiveRegion(i10);
        }

        @g.u
        public static void g(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    @g.v0(20)
    public static class l {
        private l() {
        }

        @g.u
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @g.u
        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @g.u
        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @g.v0(21)
    public static class m {

        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public j1 f5124a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f5125b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ k0 f5126c;

            public a(View view, k0 k0Var) {
                this.f5125b = view;
                this.f5126c = k0Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                j1 j1VarL = j1.L(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    m.a(windowInsets, this.f5125b);
                    if (j1VarL.equals(this.f5124a)) {
                        return this.f5126c.a(view, j1VarL).J();
                    }
                }
                this.f5124a = j1VarL;
                j1 j1VarA = this.f5126c.a(view, j1VarL);
                if (i10 >= 30) {
                    return j1VarA.J();
                }
                u0.v1(view);
                return j1VarA.J();
            }
        }

        private m() {
        }

        @g.u
        public static void a(@g.n0 WindowInsets windowInsets, @g.n0 View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @g.u
        public static j1 b(@g.n0 View view, @g.n0 j1 j1Var, @g.n0 Rect rect) {
            WindowInsets windowInsetsJ = j1Var.J();
            if (windowInsetsJ != null) {
                return j1.L(view.computeSystemWindowInsets(windowInsetsJ, rect), view);
            }
            rect.setEmpty();
            return j1Var;
        }

        @g.u
        public static boolean c(@g.n0 View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        @g.u
        public static boolean d(@g.n0 View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        @g.u
        public static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        @g.u
        public static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        @g.u
        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @g.u
        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @g.u
        public static float i(View view) {
            return view.getElevation();
        }

        @g.u
        @g.p0
        public static j1 j(@g.n0 View view) {
            return j1.a.a(view);
        }

        @g.u
        public static String k(View view) {
            return view.getTransitionName();
        }

        @g.u
        public static float l(View view) {
            return view.getTranslationZ();
        }

        @g.u
        public static float m(@g.n0 View view) {
            return view.getZ();
        }

        @g.u
        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        @g.u
        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        @g.u
        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        @g.u
        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @g.u
        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @g.u
        public static void s(View view, float f10) {
            view.setElevation(f10);
        }

        @g.u
        public static void t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        @g.u
        public static void u(@g.n0 View view, @g.p0 k0 k0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, k0Var);
            }
            if (k0Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, k0Var));
            }
        }

        @g.u
        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        @g.u
        public static void w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        @g.u
        public static void x(@g.n0 View view, float f10) {
            view.setZ(f10);
        }

        @g.u
        public static boolean y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        @g.u
        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    @g.v0(23)
    public static class n {
        private n() {
        }

        @g.p0
        public static j1 a(@g.n0 View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            j1 j1VarK = j1.K(rootWindowInsets);
            j1VarK.H(j1VarK);
            j1VarK.d(view.getRootView());
            return j1VarK;
        }

        @g.u
        public static int b(@g.n0 View view) {
            return view.getScrollIndicators();
        }

        @g.u
        public static void c(@g.n0 View view, int i10) {
            view.setScrollIndicators(i10);
        }

        @g.u
        public static void d(@g.n0 View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    @g.v0(24)
    public static class o {
        private o() {
        }

        @g.u
        public static void a(@g.n0 View view) {
            view.cancelDragAndDrop();
        }

        @g.u
        public static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @g.u
        public static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @g.u
        public static void d(@g.n0 View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        @g.u
        public static boolean e(@g.n0 View view, @g.p0 ClipData clipData, @g.n0 View.DragShadowBuilder dragShadowBuilder, @g.p0 Object obj, int i10) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
        }

        @g.u
        public static void f(@g.n0 View view, @g.n0 View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @g.v0(26)
    public static class p {
        private p() {
        }

        @g.u
        public static void a(@g.n0 View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        @g.u
        public static int b(View view) {
            return view.getImportantForAutofill();
        }

        @g.u
        public static int c(@g.n0 View view) {
            return view.getNextClusterForwardId();
        }

        @g.u
        public static boolean d(@g.n0 View view) {
            return view.hasExplicitFocusable();
        }

        @g.u
        public static boolean e(@g.n0 View view) {
            return view.isFocusedByDefault();
        }

        @g.u
        public static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        @g.u
        public static boolean g(@g.n0 View view) {
            return view.isKeyboardNavigationCluster();
        }

        @g.u
        public static View h(@g.n0 View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        @g.u
        public static boolean i(@g.n0 View view) {
            return view.restoreDefaultFocus();
        }

        @g.u
        public static void j(@g.n0 View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @g.u
        public static void k(@g.n0 View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        @g.u
        public static void l(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        @g.u
        public static void m(@g.n0 View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        @g.u
        public static void n(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        @g.u
        public static void o(@g.n0 View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    @g.v0(28)
    public static class q {
        private q() {
        }

        @g.u
        public static void a(@g.n0 View view, @g.n0 final z zVar) {
            int i10 = R.id.tag_unhandled_key_listeners;
            androidx.collection.l lVar = (androidx.collection.l) view.getTag(i10);
            if (lVar == null) {
                lVar = new androidx.collection.l();
                view.setTag(i10, lVar);
            }
            Objects.requireNonNull(zVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.v0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return zVar.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            lVar.put(zVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        @g.u
        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @g.u
        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @g.u
        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @g.u
        public static void e(@g.n0 View view, @g.n0 z zVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            androidx.collection.l lVar = (androidx.collection.l) view.getTag(R.id.tag_unhandled_key_listeners);
            if (lVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) lVar.get(zVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        @g.u
        public static <T> T f(View view, int i10) {
            return (T) view.requireViewById(i10);
        }

        @g.u
        public static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        @g.u
        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @g.u
        public static void i(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    @g.v0(29)
    public static class r {
        private r() {
        }

        @g.u
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @g.u
        public static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @g.u
        public static void c(@g.n0 View view, @g.n0 Context context, @g.n0 int[] iArr, @g.p0 AttributeSet attributeSet, @g.n0 TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        @g.u
        public static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    @g.v0(30)
    public static class s {
        private s() {
        }

        @g.u
        public static CharSequence a(View view) {
            return view.getStateDescription();
        }

        @g.p0
        public static l1 b(@g.n0 View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return l1.l(windowInsetsController);
            }
            return null;
        }

        @g.u
        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @g.v0(31)
    public static final class t {
        private t() {
        }

        @g.u
        @g.p0
        public static String[] a(@g.n0 View view) {
            return view.getReceiveContentMimeTypes();
        }

        @g.u
        @g.p0
        public static androidx.core.view.e b(@g.n0 View view, @g.n0 androidx.core.view.e eVar) {
            ContentInfo contentInfoL = eVar.l();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoL);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoL ? eVar : androidx.core.view.e.m(contentInfoPerformReceiveContent);
        }

        @g.u
        public static void c(@g.n0 View view, @g.p0 String[] strArr, @g.p0 l0 l0Var) {
            if (l0Var == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new y(l0Var));
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface u {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface v {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface w {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface x {
    }

    @g.v0(31)
    public static final class y implements OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final l0 f5127a;

        public y(@g.n0 l0 l0Var) {
            this.f5127a = l0Var;
        }

        @Override // android.view.OnReceiveContentListener
        @g.p0
        public ContentInfo onReceiveContent(@g.n0 View view, @g.n0 ContentInfo contentInfo) {
            androidx.core.view.e eVarM = androidx.core.view.e.m(contentInfo);
            androidx.core.view.e eVarA = this.f5127a.a(view, eVarM);
            if (eVarA == null) {
                return null;
            }
            return eVarA == eVarM ? contentInfo : eVarA.l();
        }
    }

    public interface z {
        boolean onUnhandledKeyEvent(@g.n0 View view, @g.n0 KeyEvent keyEvent);
    }

    @Deprecated
    public u0() {
    }

    @g.h1
    public static boolean A(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c0.a(view).f(keyEvent);
    }

    public static float A0(@g.n0 View view) {
        return m.l(view);
    }

    public static f<Boolean> A1() {
        return new a(R.id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    @Deprecated
    public static void A2(View view, float f10) {
        view.setY(f10);
    }

    public static void B(@g.n0 View view) {
        C(view);
    }

    @g.p0
    @Deprecated
    public static l1 B0(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return s.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return f1.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void B1(@g.n0 View view, @g.p0 androidx.core.view.a aVar) {
        if (aVar == null && (F(view) instanceof a.C0041a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void B2(@g.n0 View view, float f10) {
        m.x(view, f10);
    }

    public static void C(@g.n0 View view) {
        androidx.core.view.a aVarE = E(view);
        if (aVarE == null) {
            aVarE = new androidx.core.view.a();
        }
        B1(view, aVarE);
    }

    @Deprecated
    public static int C0(@g.n0 View view) {
        return h.g(view);
    }

    @g.h1
    public static void C1(@g.n0 View view, boolean z10) {
        b().g(view, Boolean.valueOf(z10));
    }

    public static boolean C2(@g.n0 View view, @g.p0 ClipData clipData, @g.n0 View.DragShadowBuilder dragShadowBuilder, @g.p0 Object obj, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? o.e(view, clipData, dragShadowBuilder, obj, i10) : view.startDrag(clipData, dragShadowBuilder, obj, i10);
    }

    public static int D() {
        return i.a();
    }

    @Deprecated
    public static float D0(View view) {
        return view.getX();
    }

    public static void D1(@g.n0 View view, int i10) {
        k.f(view, i10);
    }

    public static boolean D2(@g.n0 View view, int i10) {
        return m.y(view, i10);
    }

    @g.p0
    public static androidx.core.view.a E(@g.n0 View view) {
        View.AccessibilityDelegate accessibilityDelegateF = F(view);
        if (accessibilityDelegateF == null) {
            return null;
        }
        return accessibilityDelegateF instanceof a.C0041a ? ((a.C0041a) accessibilityDelegateF).f4798a : new androidx.core.view.a(accessibilityDelegateF);
    }

    @Deprecated
    public static float E0(View view) {
        return view.getY();
    }

    @g.h1
    public static void E1(@g.n0 View view, @g.p0 CharSequence charSequence) {
        k1().g(view, charSequence);
        if (charSequence != null) {
            X.a(view);
        } else {
            X.d(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean E2(@g.n0 View view, int i10, int i11) {
        if (view instanceof androidx.core.view.c0) {
            return ((androidx.core.view.c0) view).f(i10, i11);
        }
        if (i11 == 0) {
            return D2(view, i10);
        }
        return false;
    }

    @g.p0
    public static View.AccessibilityDelegate F(@g.n0 View view) {
        return Build.VERSION.SDK_INT >= 29 ? r.a(view) : G(view);
    }

    public static float F0(@g.n0 View view) {
        return m.m(view);
    }

    @Deprecated
    public static void F1(View view, boolean z10) {
        view.setActivated(z10);
    }

    public static f<CharSequence> F2() {
        return new c(R.id.tag_state_description, CharSequence.class, 64, 30);
    }

    @g.p0
    public static View.AccessibilityDelegate G(@g.n0 View view) {
        if (T) {
            return null;
        }
        if (S == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                S = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                T = true;
                return null;
            }
        }
        try {
            Object obj = S.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            T = true;
            return null;
        }
    }

    public static boolean G0(@g.n0 View view) {
        return F(view) != null;
    }

    @Deprecated
    public static void G1(View view, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        view.setAlpha(f10);
    }

    public static void G2(@g.n0 View view) {
        m.z(view);
    }

    public static int H(@g.n0 View view) {
        return k.a(view);
    }

    public static boolean H0(@g.n0 View view) {
        return Build.VERSION.SDK_INT >= 26 ? p.d(view) : view.hasFocusable();
    }

    public static void H1(@g.n0 View view, @g.p0 String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.j(view, strArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void H2(@g.n0 View view, int i10) {
        if (view instanceof androidx.core.view.c0) {
            ((androidx.core.view.c0) view).g(i10);
        } else if (i10 == 0) {
            G2(view);
        }
    }

    @g.p0
    public static a1.e I(@g.n0 View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = h.a(view);
        if (accessibilityNodeProviderA != null) {
            return new a1.e(accessibilityNodeProviderA);
        }
        return null;
    }

    public static boolean I0(@g.n0 View view) {
        return m.n(view);
    }

    public static void I1(@g.n0 View view, @g.p0 Drawable drawable) {
        h.q(view, drawable);
    }

    public static void I2(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    @g.h1
    @g.p0
    public static CharSequence J(@g.n0 View view) {
        return k1().f(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean J0(@g.n0 View view, int i10) {
        if (view instanceof androidx.core.view.c0) {
            ((androidx.core.view.c0) view).d(i10);
            return false;
        }
        if (i10 == 0) {
            return I0(view);
        }
        return false;
    }

    public static void J1(@g.n0 View view, @g.p0 ColorStateList colorStateList) {
        int i10 = Build.VERSION.SDK_INT;
        m.q(view, colorStateList);
        if (i10 == 21) {
            Drawable background = view.getBackground();
            boolean z10 = (m.g(view) == null && m.h(view) == null) ? false : true;
            if (background == null || !z10) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            h.q(view, background);
        }
    }

    public static void J2(@g.n0 View view, @g.n0 View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.f(view, dragShadowBuilder);
        }
    }

    public static List<d.a> K(View view) {
        int i10 = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    public static boolean K0(@g.n0 View view) {
        return g.a(view);
    }

    public static void K1(@g.n0 View view, @g.p0 PorterDuff.Mode mode) {
        int i10 = Build.VERSION.SDK_INT;
        m.r(view, mode);
        if (i10 == 21) {
            Drawable background = view.getBackground();
            boolean z10 = (m.g(view) == null && m.h(view) == null) ? false : true;
            if (background == null || !z10) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            h.q(view, background);
        }
    }

    @Deprecated
    public static float L(View view) {
        return view.getAlpha();
    }

    public static boolean L0(@g.n0 View view) {
        return h.h(view);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void L1(ViewGroup viewGroup, boolean z10) {
        if (R == null) {
            try {
                R = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            R.setAccessible(true);
        }
        try {
            R.invoke(viewGroup, Boolean.valueOf(z10));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
        }
    }

    public static int M(View view, @g.n0 CharSequence charSequence) {
        List<d.a> listK = K(view);
        for (int i10 = 0; i10 < listK.size(); i10++) {
            if (TextUtils.equals(charSequence, listK.get(i10).c())) {
                return listK.get(i10).b();
            }
        }
        int i11 = 0;
        int i12 = -1;
        while (true) {
            int[] iArr = V;
            if (i11 >= iArr.length || i12 != -1) {
                break;
            }
            int i13 = iArr[i11];
            boolean z10 = true;
            for (int i14 = 0; i14 < listK.size(); i14++) {
                z10 &= listK.get(i14).b() != i13;
            }
            if (z10) {
                i12 = i13;
            }
            i11++;
        }
        return i12;
    }

    public static boolean M0(@g.n0 View view) {
        return h.i(view);
    }

    public static void M1(@g.n0 View view, @g.p0 Rect rect) {
        j.c(view, rect);
    }

    @g.p0
    public static ColorStateList N(@g.n0 View view) {
        return m.g(view);
    }

    @g.h1
    public static boolean N0(@g.n0 View view) {
        Boolean boolF = b().f(view);
        return boolF != null && boolF.booleanValue();
    }

    public static void N1(@g.n0 View view, float f10) {
        m.s(view, f10);
    }

    @g.p0
    public static PorterDuff.Mode O(@g.n0 View view) {
        return m.h(view);
    }

    public static boolean O0(@g.n0 View view) {
        return k.b(view);
    }

    @Deprecated
    public static void O1(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    @g.p0
    public static Rect P(@g.n0 View view) {
        return j.a(view);
    }

    public static boolean P0(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.e(view);
        }
        return false;
    }

    public static void P1(@g.n0 View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.k(view, z10);
        }
    }

    @g.p0
    public static Display Q(@g.n0 View view) {
        return i.b(view);
    }

    public static boolean Q0(@g.n0 View view) {
        return m.o(view);
    }

    public static void Q1(@g.n0 View view, boolean z10) {
        h.r(view, z10);
    }

    public static float R(@g.n0 View view) {
        return m.i(view);
    }

    public static boolean R0(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.f(view);
        }
        return true;
    }

    @g.h1
    public static void R1(@g.n0 View view, int i10) {
        h.s(view, i10);
    }

    public static Rect S() {
        if (U == null) {
            U = new ThreadLocal<>();
        }
        Rect rect = U.get();
        if (rect == null) {
            rect = new Rect();
            U.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean S0(@g.n0 View view) {
        return j.b(view);
    }

    public static void S1(@g.n0 View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.l(view, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static m0 T(@g.n0 View view) {
        return view instanceof m0 ? (m0) view : W;
    }

    public static boolean T0(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.g(view);
        }
        return false;
    }

    public static void T1(@g.n0 View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.m(view, z10);
        }
    }

    public static boolean U(@g.n0 View view) {
        return h.b(view);
    }

    public static boolean U0(@g.n0 View view) {
        return k.c(view);
    }

    public static void U1(@g.n0 View view, @g.d0 int i10) {
        i.h(view, i10);
    }

    public static int V(@g.n0 View view) {
        return h.c(view);
    }

    public static boolean V0(@g.n0 View view) {
        return k.d(view);
    }

    public static void V1(@g.n0 View view, @g.p0 Paint paint) {
        i.i(view, paint);
    }

    @SuppressLint({"InlinedApi"})
    public static int W(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.b(view);
        }
        return 0;
    }

    public static boolean W0(@g.n0 View view) {
        return m.p(view);
    }

    @Deprecated
    public static void W1(View view, int i10, Paint paint) {
        view.setLayerType(i10, paint);
    }

    public static int X(@g.n0 View view) {
        return i.c(view);
    }

    @Deprecated
    public static boolean X0(View view) {
        return view.isOpaque();
    }

    public static void X1(@g.n0 View view, int i10) {
        i.j(view, i10);
    }

    @Deprecated
    public static int Y(View view) {
        return view.getLayerType();
    }

    public static boolean Y0(@g.n0 View view) {
        return i.g(view);
    }

    public static void Y1(@g.n0 View view, boolean z10) {
        m.t(view, z10);
    }

    public static int Z(@g.n0 View view) {
        return i.d(view);
    }

    @g.h1
    public static boolean Z0(@g.n0 View view) {
        Boolean boolF = A1().f(view);
        return boolF != null && boolF.booleanValue();
    }

    public static void Z1(@g.n0 View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.n(view, i10);
        }
    }

    @g.p0
    @Deprecated
    public static Matrix a0(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static void a1(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void a2(@g.n0 View view, @g.p0 k0 k0Var) {
        m.u(view, k0Var);
    }

    public static f<Boolean> b() {
        return new d(R.id.tag_accessibility_heading, Boolean.class, 28);
    }

    @Deprecated
    public static int b0(View view) {
        return view.getMeasuredHeightAndState();
    }

    @g.p0
    public static View b1(@g.n0 View view, @g.p0 View view2, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.h(view, view2, i10);
        }
        return null;
    }

    public static void b2(@g.n0 View view, @g.p0 String[] strArr, @g.p0 l0 l0Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            t.c(view, strArr, l0Var);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z10 = false;
        if (l0Var != null) {
            androidx.core.util.o.b(strArr != null, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (strArr[i10].startsWith("*")) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            androidx.core.util.o.b(!z10, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, l0Var);
    }

    public static int c(@g.n0 View view, @g.n0 CharSequence charSequence, @g.n0 a1.g gVar) {
        int iM = M(view, charSequence);
        if (iM != -1) {
            d(view, new d.a(iM, charSequence, gVar));
        }
        return iM;
    }

    @Deprecated
    public static int c0(View view) {
        return view.getMeasuredState();
    }

    public static /* synthetic */ androidx.core.view.e c1(androidx.core.view.e eVar) {
        return eVar;
    }

    @Deprecated
    public static void c2(View view, int i10) {
        view.setOverScrollMode(i10);
    }

    public static void d(@g.n0 View view, @g.n0 d.a aVar) {
        C(view);
        s1(aVar.b(), view);
        K(view).add(aVar);
        d1(view, 0);
    }

    @Deprecated
    public static int d0(View view) {
        return view.getMeasuredWidthAndState();
    }

    @g.v0(19)
    public static void d1(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = J(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (H(view) != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                k.g(accessibilityEventObtain, i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(J(view));
                    x2(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 != 32) {
                if (view.getParent() != null) {
                    try {
                        k.e(view.getParent(), view, view, i10);
                        return;
                    } catch (AbstractMethodError unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(view.getParent().getClass().getSimpleName());
                        sb2.append(" does not fully implement ViewParent");
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            k.g(accessibilityEventObtain2, i10);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(J(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void d2(@g.n0 View view, @g.t0 int i10, @g.t0 int i11, @g.t0 int i12, @g.t0 int i13) {
        i.k(view, i10, i11, i12, i13);
    }

    public static void e(@g.n0 View view, @g.n0 Collection<View> collection, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.a(view, collection, i10);
        }
    }

    public static int e0(@g.n0 View view) {
        return h.d(view);
    }

    public static void e1(@g.n0 View view, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i10);
            return;
        }
        Rect rectS = S();
        boolean z10 = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectS.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !rectS.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        m(view, i10);
        if (z10 && rectS.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectS);
        }
    }

    @Deprecated
    public static void e2(View view, float f10) {
        view.setPivotX(f10);
    }

    public static void f(@g.n0 View view, @g.n0 z zVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            q.a(view, zVar);
            return;
        }
        int i10 = R.id.tag_unhandled_key_listeners;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(i10, arrayList);
        }
        arrayList.add(zVar);
        if (arrayList.size() == 1) {
            c0.h(view);
        }
    }

    public static int f0(@g.n0 View view) {
        return h.e(view);
    }

    public static void f1(@g.n0 View view, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i10);
            return;
        }
        Rect rectS = S();
        boolean z10 = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectS.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !rectS.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        n(view, i10);
        if (z10 && rectS.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectS);
        }
    }

    @Deprecated
    public static void f2(View view, float f10) {
        view.setPivotY(f10);
    }

    @g.n0
    public static b1 g(@g.n0 View view) {
        if (Q == null) {
            Q = new WeakHashMap<>();
        }
        b1 b1Var = Q.get(view);
        if (b1Var != null) {
            return b1Var;
        }
        b1 b1Var2 = new b1(view);
        Q.put(view, b1Var2);
        return b1Var2;
    }

    public static int g0(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.c(view);
        }
        return -1;
    }

    @g.n0
    public static j1 g1(@g.n0 View view, @g.n0 j1 j1Var) {
        WindowInsets windowInsetsJ = j1Var.J();
        if (windowInsetsJ != null) {
            WindowInsets windowInsetsB = l.b(view, windowInsetsJ);
            if (!windowInsetsB.equals(windowInsetsJ)) {
                return j1.L(windowInsetsB, view);
            }
        }
        return j1Var;
    }

    public static void g2(@g.n0 View view, @g.p0 o0 o0Var) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.d(view, (PointerIcon) (o0Var != null ? o0Var.b() : null));
        }
    }

    public static void h() {
        try {
            M = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            N = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException unused) {
        }
        O = true;
    }

    @g.p0
    public static String[] h0(@g.n0 View view) {
        return Build.VERSION.SDK_INT >= 31 ? t.a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static void h1(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void h2(View view, float f10) {
        view.setRotation(f10);
    }

    @Deprecated
    public static boolean i(View view, int i10) {
        return view.canScrollHorizontally(i10);
    }

    @Deprecated
    public static int i0(View view) {
        return view.getOverScrollMode();
    }

    public static void i1(@g.n0 View view, @g.n0 a1.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.f2());
    }

    @Deprecated
    public static void i2(View view, float f10) {
        view.setRotationX(f10);
    }

    @Deprecated
    public static boolean j(View view, int i10) {
        return view.canScrollVertically(i10);
    }

    @g.t0
    public static int j0(@g.n0 View view) {
        return i.e(view);
    }

    @Deprecated
    public static void j1(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void j2(View view, float f10) {
        view.setRotationY(f10);
    }

    public static void k(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.a(view);
        }
    }

    @g.t0
    public static int k0(@g.n0 View view) {
        return i.f(view);
    }

    public static f<CharSequence> k1() {
        return new b(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    @Deprecated
    public static void k2(View view, boolean z10) {
        view.setSaveFromParentEnabled(z10);
    }

    @Deprecated
    public static int l(int i10, int i11) {
        return View.combineMeasuredStates(i10, i11);
    }

    @g.p0
    public static ViewParent l0(@g.n0 View view) {
        return h.f(view);
    }

    public static boolean l1(@g.n0 View view, int i10, @g.p0 Bundle bundle) {
        return h.j(view, i10, bundle);
    }

    @Deprecated
    public static void l2(View view, float f10) {
        view.setScaleX(f10);
    }

    public static void m(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            I2(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                I2((View) parent);
            }
        }
    }

    @Deprecated
    public static float m0(View view) {
        return view.getPivotX();
    }

    @g.p0
    public static androidx.core.view.e m1(@g.n0 View view, @g.n0 androidx.core.view.e eVar) {
        if (Log.isLoggable(f5089a, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("performReceiveContent: ");
            sb2.append(eVar);
            sb2.append(", view=");
            sb2.append(view.getClass().getSimpleName());
            sb2.append("[");
            sb2.append(view.getId());
            sb2.append("]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return t.b(view, eVar);
        }
        l0 l0Var = (l0) view.getTag(R.id.tag_on_receive_content_listener);
        if (l0Var == null) {
            return T(view).a(eVar);
        }
        androidx.core.view.e eVarA = l0Var.a(view, eVar);
        if (eVarA == null) {
            return null;
        }
        return T(view).a(eVarA);
    }

    @Deprecated
    public static void m2(View view, float f10) {
        view.setScaleY(f10);
    }

    public static void n(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            I2(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                I2((View) parent);
            }
        }
    }

    @Deprecated
    public static float n0(View view) {
        return view.getPivotY();
    }

    public static void n1(@g.n0 View view) {
        h.k(view);
    }

    @g.h1
    public static void n2(@g.n0 View view, boolean z10) {
        A1().g(view, Boolean.valueOf(z10));
    }

    @g.n0
    public static j1 o(@g.n0 View view, @g.n0 j1 j1Var, @g.n0 Rect rect) {
        return m.b(view, j1Var, rect);
    }

    @g.p0
    public static j1 o0(@g.n0 View view) {
        return Build.VERSION.SDK_INT >= 23 ? n.a(view) : m.j(view);
    }

    public static void o1(@g.n0 View view, int i10, int i11, int i12, int i13) {
        h.l(view, i10, i11, i12, i13);
    }

    public static void o2(@g.n0 View view, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            n.c(view, i10);
        }
    }

    @g.n0
    public static j1 p(@g.n0 View view, @g.n0 j1 j1Var) {
        WindowInsets windowInsetsJ = j1Var.J();
        if (windowInsetsJ != null) {
            WindowInsets windowInsetsA = l.a(view, windowInsetsJ);
            if (!windowInsetsA.equals(windowInsetsJ)) {
                return j1.L(windowInsetsA, view);
            }
        }
        return j1Var;
    }

    @Deprecated
    public static float p0(View view) {
        return view.getRotation();
    }

    public static void p1(@g.n0 View view, @g.n0 Runnable runnable) {
        h.m(view, runnable);
    }

    public static void p2(@g.n0 View view, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            n.d(view, i10, i11);
        }
    }

    public static void q(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.b(view);
            return;
        }
        if (!O) {
            h();
        }
        Method method = N;
        if (method == null) {
            view.onFinishTemporaryDetach();
        } else {
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static float q0(View view) {
        return view.getRotationX();
    }

    @SuppressLint({"LambdaLast"})
    public static void q1(@g.n0 View view, @g.n0 Runnable runnable, long j10) {
        h.n(view, runnable, j10);
    }

    @g.h1
    public static void q2(@g.n0 View view, @g.p0 CharSequence charSequence) {
        F2().g(view, charSequence);
    }

    public static boolean r(@g.n0 View view, float f10, float f11, boolean z10) {
        return m.c(view, f10, f11, z10);
    }

    @Deprecated
    public static float r0(View view) {
        return view.getRotationY();
    }

    public static void r1(@g.n0 View view, int i10) {
        s1(i10, view);
        d1(view, 0);
    }

    public static void r2(@g.n0 View view, @g.n0 List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.d(view, list);
        }
    }

    public static boolean s(@g.n0 View view, float f10, float f11) {
        return m.d(view, f10, f11);
    }

    @Deprecated
    public static float s0(View view) {
        return view.getScaleX();
    }

    public static void s1(int i10, View view) {
        List<d.a> listK = K(view);
        for (int i11 = 0; i11 < listK.size(); i11++) {
            if (listK.get(i11).b() == i10) {
                listK.remove(i11);
                return;
            }
        }
    }

    public static void s2(@g.n0 View view, @g.p0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.o(view, charSequence);
        }
    }

    public static boolean t(@g.n0 View view, int i10, int i11, @g.p0 int[] iArr, @g.p0 int[] iArr2) {
        return m.e(view, i10, i11, iArr, iArr2);
    }

    @Deprecated
    public static float t0(View view) {
        return view.getScaleY();
    }

    public static void t1(@g.n0 View view, @g.n0 z zVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            q.e(view, zVar);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(zVar);
            if (arrayList.size() == 0) {
                c0.i(view);
            }
        }
    }

    public static void t2(@g.n0 View view, @g.p0 String str) {
        m.v(view, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean u(@g.n0 View view, int i10, int i11, @g.p0 int[] iArr, @g.p0 int[] iArr2, int i12) {
        if (view instanceof androidx.core.view.c0) {
            return ((androidx.core.view.c0) view).b(i10, i11, iArr, iArr2, i12);
        }
        if (i12 == 0) {
            return t(view, i10, i11, iArr, iArr2);
        }
        return false;
    }

    public static int u0(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return n.b(view);
        }
        return 0;
    }

    public static void u1(@g.n0 View view, @g.n0 d.a aVar, @g.p0 CharSequence charSequence, @g.p0 a1.g gVar) {
        if (gVar == null && charSequence == null) {
            r1(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, gVar));
        }
    }

    @Deprecated
    public static void u2(View view, float f10) {
        view.setTranslationX(f10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void v(@g.n0 View view, int i10, int i11, int i12, int i13, @g.p0 int[] iArr, int i14, @g.n0 int[] iArr2) {
        if (view instanceof d0) {
            ((d0) view).c(i10, i11, i12, i13, iArr, i14, iArr2);
        } else {
            x(view, i10, i11, i12, i13, iArr, i14);
        }
    }

    @g.h1
    @g.p0
    public static CharSequence v0(@g.n0 View view) {
        return F2().f(view);
    }

    public static void v1(@g.n0 View view) {
        l.c(view);
    }

    @Deprecated
    public static void v2(View view, float f10) {
        view.setTranslationY(f10);
    }

    public static boolean w(@g.n0 View view, int i10, int i11, int i12, int i13, @g.p0 int[] iArr) {
        return m.f(view, i10, i11, i12, i13, iArr);
    }

    @g.n0
    public static List<Rect> w0(@g.n0 View view) {
        return Build.VERSION.SDK_INT >= 29 ? r.b(view) : Collections.emptyList();
    }

    @g.n0
    public static <T extends View> T w1(@g.n0 View view, @g.d0 int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) q.f(view, i10);
        }
        T t10 = (T) view.findViewById(i10);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public static void w2(@g.n0 View view, float f10) {
        m.w(view, f10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean x(@g.n0 View view, int i10, int i11, int i12, int i13, @g.p0 int[] iArr, int i14) {
        if (view instanceof androidx.core.view.c0) {
            return ((androidx.core.view.c0) view).a(i10, i11, i12, i13, iArr, i14);
        }
        if (i14 == 0) {
            return w(view, i10, i11, i12, i13, iArr);
        }
        return false;
    }

    @g.p0
    public static String x0(@g.n0 View view) {
        return m.k(view);
    }

    @Deprecated
    public static int x1(int i10, int i11, int i12) {
        return View.resolveSizeAndState(i10, i11, i12);
    }

    public static void x2(View view) {
        if (V(view) == 0) {
            R1(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (V((View) parent) == 4) {
                R1(view, 2);
                return;
            }
        }
    }

    public static void y(@g.n0 View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.c(view);
            return;
        }
        if (!O) {
            h();
        }
        Method method = M;
        if (method == null) {
            view.onStartTemporaryDetach();
        } else {
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static float y0(View view) {
        return view.getTranslationX();
    }

    public static boolean y1(@g.n0 View view) {
        return Build.VERSION.SDK_INT >= 26 ? p.i(view) : view.requestFocus();
    }

    public static void y2(@g.n0 View view, @g.p0 g1.b bVar) {
        g1.h(view, bVar);
    }

    @g.h1
    public static boolean z(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c0.a(view).b(view, keyEvent);
    }

    @Deprecated
    public static float z0(View view) {
        return view.getTranslationY();
    }

    public static void z1(@g.n0 View view, @SuppressLint({"ContextFirst"}) @g.n0 Context context, @g.n0 int[] iArr, @g.p0 AttributeSet attributeSet, @g.n0 TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.c(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    @Deprecated
    public static void z2(View view, float f10) {
        view.setX(f10);
    }
}
