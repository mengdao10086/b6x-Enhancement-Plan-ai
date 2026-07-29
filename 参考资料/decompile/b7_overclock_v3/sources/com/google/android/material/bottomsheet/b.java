package com.google.android.material.bottomsheet;

import a1.d;
import a1.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class b extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f19803m = R.style.Widget_Material3_BottomSheet_DragHandle;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final AccessibilityManager f19804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public BottomSheetBehavior<?> f19805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f19809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f19810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f19811k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BottomSheetBehavior.f f19812l;

    public class a extends BottomSheetBehavior.f {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@n0 View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@n0 View view, int i10) {
            b.this.k(i10);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    public class C0203b extends androidx.core.view.a {
        public C0203b() {
        }

        @Override // androidx.core.view.a
        public void h(View view, @n0 AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                b.this.g();
            }
        }
    }

    public b(@n0 Context context) {
        this(context, null);
    }

    @p0
    public static View i(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean j(View view, g.a aVar) {
        return g();
    }

    private void setBottomSheetBehavior(@p0 BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior<?> bottomSheetBehavior2 = this.f19805e;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.E0(this.f19812l);
        }
        this.f19805e = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            k(bottomSheetBehavior.v0());
            this.f19805e.Y(this.f19812l);
        }
        l();
    }

    public final void f(String str) {
        if (this.f19804d == null) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.getText().add(str);
        this.f19804d.sendAccessibilityEvent(accessibilityEventObtain);
    }

    public final boolean g() {
        boolean z10 = false;
        if (!this.f19807g) {
            return false;
        }
        f(this.f19811k);
        if (!this.f19805e.z0() && !this.f19805e.f1()) {
            z10 = true;
        }
        int iV0 = this.f19805e.v0();
        int i10 = 6;
        if (iV0 == 4) {
            if (!z10) {
                i10 = 3;
            }
        } else if (iV0 != 3) {
            i10 = this.f19808h ? 3 : 4;
        } else if (!z10) {
            i10 = 4;
        }
        this.f19805e.Y0(i10);
        return true;
    }

    @p0
    public final BottomSheetBehavior<?> h() {
        View viewI = this;
        while (true) {
            viewI = i(viewI);
            if (viewI == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = viewI.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.g) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) layoutParams).f();
                if (cVarF instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) cVarF;
                }
            }
        }
    }

    public final void k(int i10) {
        if (i10 == 4) {
            this.f19808h = true;
        } else if (i10 == 3) {
            this.f19808h = false;
        }
        u0.u1(this, d.a.f110j, this.f19808h ? this.f19809i : this.f19810j, new g() { // from class: od.a
            @Override // a1.g
            public final boolean a(View view, g.a aVar) {
                return this.f43319a.j(view, aVar);
            }
        });
    }

    public final void l() {
        this.f19807g = this.f19806f && this.f19805e != null;
        u0.R1(this, this.f19805e == null ? 2 : 1);
        setClickable(this.f19807g);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z10) {
        this.f19806f = z10;
        l();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(h());
        AccessibilityManager accessibilityManager = this.f19804d;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.f19804d.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f19804d;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    public b(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetDragHandleStyle);
    }

    public b(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(pe.a.c(context, attributeSet, i10, f19803m), attributeSet, i10);
        this.f19809i = getResources().getString(R.string.bottomsheet_action_expand);
        this.f19810j = getResources().getString(R.string.bottomsheet_action_collapse);
        this.f19811k = getResources().getString(R.string.bottomsheet_drag_handle_clicked);
        this.f19812l = new a();
        this.f19804d = (AccessibilityManager) getContext().getSystemService("accessibility");
        l();
        u0.B1(this, new C0203b());
    }
}
