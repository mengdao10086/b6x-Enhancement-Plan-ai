package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.f1;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g.d1;
import g.i0;
import g.n0;
import g.p0;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
public class a extends j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f19783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f19784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CoordinatorLayout f19785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f19786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f19791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public BottomSheetBehavior.f f19793p;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    public class C0202a implements k0 {
        public C0202a() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            if (a.this.f19791n != null) {
                a.this.f19783f.E0(a.this.f19791n);
            }
            if (j1Var != null) {
                a aVar = a.this;
                aVar.f19791n = new f(aVar.f19786i, j1Var, null);
                a.this.f19791n.e(a.this.getWindow());
                a.this.f19783f.Y(a.this.f19791n);
            }
            return j1Var;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f19788k && aVar.isShowing() && a.this.x()) {
                a.this.cancel();
            }
        }
    }

    public class c extends androidx.core.view.a {
        public c() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            if (!a.this.f19788k) {
                dVar.i1(false);
            } else {
                dVar.a(1048576);
                dVar.i1(true);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                a aVar = a.this;
                if (aVar.f19788k) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i10, bundle);
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class e extends BottomSheetBehavior.f {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@n0 View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@n0 View view, int i10) {
            if (i10 == 5) {
                a.this.cancel();
            }
        }
    }

    public static class f extends BottomSheetBehavior.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final Boolean f19799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final j1 f19800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Window f19801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19802d;

        public /* synthetic */ f(View view, j1 j1Var, C0202a c0202a) {
            this(view, j1Var);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@n0 View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@n0 View view, float f10) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@n0 View view, int i10) {
            d(view);
        }

        public final void d(View view) {
            if (view.getTop() < this.f19800b.r()) {
                Window window = this.f19801c;
                if (window != null) {
                    Boolean bool = this.f19799a;
                    com.google.android.material.internal.e.g(window, bool == null ? this.f19802d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f19800b.r() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f19801c;
                if (window2 != null) {
                    com.google.android.material.internal.e.g(window2, this.f19802d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void e(@p0 Window window) {
            if (this.f19801c == window) {
                return;
            }
            this.f19801c = window;
            if (window != null) {
                this.f19802d = f1.a(window, window.getDecorView()).f();
            }
        }

        public f(@n0 View view, @n0 j1 j1Var) {
            this.f19800b = j1Var;
            le.j jVarO0 = BottomSheetBehavior.i0(view).o0();
            ColorStateList colorStateListY = jVarO0 != null ? jVarO0.y() : u0.N(view);
            if (colorStateListY != null) {
                this.f19799a = Boolean.valueOf(m.l(colorStateListY.getDefaultColor()));
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f19799a = Boolean.valueOf(m.l(((ColorDrawable) view.getBackground()).getColor()));
            } else {
                this.f19799a = null;
            }
        }
    }

    public a(@n0 Context context) {
        this(context, 0);
        this.f19792o = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public static int i(@n0 Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
    }

    @Deprecated
    public static void w(@n0 View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z10 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorQ = q();
        if (!this.f19787j || bottomSheetBehaviorQ.v0() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorQ.Y0(5);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z10 = this.f19792o && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f19784g;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f19785h;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            f1.c(window, !z10);
            f fVar = this.f19791n;
            if (fVar != null) {
                fVar.e(window);
            }
        }
    }

    @Override // androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i10 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i10 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.f19791n;
        if (fVar != null) {
            fVar.e(null);
        }
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f19783f;
        if (bottomSheetBehavior == null || bottomSheetBehavior.v0() != 5) {
            return;
        }
        this.f19783f.Y0(4);
    }

    public final FrameLayout p() {
        if (this.f19784g == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f19784g = frameLayout;
            this.f19785h = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f19784g.findViewById(R.id.design_bottom_sheet);
            this.f19786i = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorI0 = BottomSheetBehavior.i0(frameLayout2);
            this.f19783f = bottomSheetBehaviorI0;
            bottomSheetBehaviorI0.Y(this.f19793p);
            this.f19783f.Q0(this.f19788k);
        }
        return this.f19784g;
    }

    @n0
    public BottomSheetBehavior<FrameLayout> q() {
        if (this.f19783f == null) {
            p();
        }
        return this.f19783f;
    }

    public boolean r() {
        return this.f19787j;
    }

    public boolean s() {
        return this.f19792o;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f19788k != z10) {
            this.f19788k = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f19783f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.Q0(z10);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f19788k) {
            this.f19788k = true;
        }
        this.f19789l = z10;
        this.f19790m = true;
    }

    @Override // androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void setContentView(@i0 int i10) {
        super.setContentView(y(i10, null, null));
    }

    public void u() {
        this.f19783f.E0(this.f19793p);
    }

    public void v(boolean z10) {
        this.f19787j = z10;
    }

    public boolean x() {
        if (!this.f19790m) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.f19789l = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f19790m = true;
        }
        return this.f19789l;
    }

    public final View y(int i10, @p0 View view, @p0 ViewGroup.LayoutParams layoutParams) {
        p();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f19784g.findViewById(R.id.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f19792o) {
            u0.a2(this.f19786i, new C0202a());
        }
        this.f19786i.removeAllViews();
        if (layoutParams == null) {
            this.f19786i.addView(view);
        } else {
            this.f19786i.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
        u0.B1(this.f19786i, new c());
        this.f19786i.setOnTouchListener(new d());
        return this.f19784g;
    }

    @Override // androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(y(0, view, null));
    }

    @Override // androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(y(0, view, layoutParams));
    }

    public a(@n0 Context context, @d1 int i10) {
        super(context, i(context, i10));
        this.f19788k = true;
        this.f19789l = true;
        this.f19793p = new e();
        k(1);
        this.f19792o = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public a(@n0 Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        this.f19788k = true;
        this.f19789l = true;
        this.f19793p = new e();
        k(1);
        this.f19788k = z10;
        this.f19792o = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
