package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b0 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f20400a;

        public a(View view) {
            this.f20400a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f20400a.getContext().getSystemService("input_method")).showSoftInput(this.f20400a, 1);
        }
    }

    public class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f20403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f20404d;

        public b(boolean z10, boolean z11, boolean z12, e eVar) {
            this.f20401a = z10;
            this.f20402b = z11;
            this.f20403c = z12;
            this.f20404d = eVar;
        }

        @Override // com.google.android.material.internal.b0.e
        @n0
        public j1 a(View view, @n0 j1 j1Var, @n0 f fVar) {
            if (this.f20401a) {
                fVar.f20410d += j1Var.o();
            }
            boolean zL = b0.l(view);
            if (this.f20402b) {
                if (zL) {
                    fVar.f20409c += j1Var.p();
                } else {
                    fVar.f20407a += j1Var.p();
                }
            }
            if (this.f20403c) {
                if (zL) {
                    fVar.f20407a += j1Var.q();
                } else {
                    fVar.f20409c += j1Var.q();
                }
            }
            fVar.a(view);
            e eVar = this.f20404d;
            return eVar != null ? eVar.a(view, j1Var, fVar) : j1Var;
        }
    }

    public class c implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f20405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f20406b;

        public c(e eVar, f fVar) {
            this.f20405a = eVar;
            this.f20406b = fVar;
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            return this.f20405a.a(view, j1Var, new f(this.f20406b));
        }
    }

    public class d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@n0 View view) {
            view.removeOnAttachStateChangeListener(this);
            u0.v1(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface e {
        j1 a(View view, j1 j1Var, f fVar);
    }

    public static void a(@p0 View view, @n0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void b(@n0 View view, @p0 AttributeSet attributeSet, int i10, int i11) {
        c(view, attributeSet, i10, i11, null);
    }

    public static void c(@n0 View view, @p0 AttributeSet attributeSet, int i10, int i11, @p0 e eVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i10, i11);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        d(view, new b(z10, z11, z12, eVar));
    }

    public static void d(@n0 View view, @n0 e eVar) {
        u0.a2(view, new c(eVar, new f(u0.k0(view), view.getPaddingTop(), u0.j0(view), view.getPaddingBottom())));
        p(view);
    }

    public static float e(@n0 Context context, @g.r(unit = 0) int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    @p0
    public static Integer f(@n0 View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    @p0
    public static ViewGroup g(@p0 View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @p0
    public static a0 h(@n0 View view) {
        return i(g(view));
    }

    @p0
    public static a0 i(@p0 View view) {
        if (view == null) {
            return null;
        }
        return new z(view);
    }

    public static float j(@n0 View view) {
        float fR = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fR += u0.R((View) parent);
        }
        return fR;
    }

    public static void k(@n0 View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) h0.d.o(view.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean l(View view) {
        return u0.Z(view) == 1;
    }

    public static PorterDuff.Mode m(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void n(@p0 View view, @n0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            o(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void o(@n0 ViewTreeObserver viewTreeObserver, @n0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void p(@n0 View view) {
        if (u0.O0(view)) {
            u0.v1(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void q(@n0 View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20410d;

        public f(int i10, int i11, int i12, int i13) {
            this.f20407a = i10;
            this.f20408b = i11;
            this.f20409c = i12;
            this.f20410d = i13;
        }

        public void a(View view) {
            u0.d2(view, this.f20407a, this.f20408b, this.f20409c, this.f20410d);
        }

        public f(@n0 f fVar) {
            this.f20407a = fVar.f20407a;
            this.f20408b = fVar.f20408b;
            this.f20409c = fVar.f20409c;
            this.f20410d = fVar.f20410d;
        }
    }
}
