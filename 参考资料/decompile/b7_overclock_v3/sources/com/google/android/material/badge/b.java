package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.u;
import g.d0;
import g.i1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@md.a
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f19607a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f19608b = "BadgeUtils";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f19609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.badge.a f19611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f19612d;

        public a(Toolbar toolbar, int i10, com.google.android.material.badge.a aVar, FrameLayout frameLayout) {
            this.f19609a = toolbar;
            this.f19610b = i10;
            this.f19611c = aVar;
            this.f19612d = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView actionMenuItemViewA = u.a(this.f19609a, this.f19610b);
            if (actionMenuItemViewA != null) {
                b.n(this.f19611c, this.f19609a.getResources());
                b.d(this.f19611c, actionMenuItemViewA, this.f19612d);
                b.b(this.f19611c, actionMenuItemViewA);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.badge.b$b, reason: collision with other inner class name */
    public class C0201b extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.badge.a f19613d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0201b(View.AccessibilityDelegate accessibilityDelegate, com.google.android.material.badge.a aVar) {
            super(accessibilityDelegate);
            this.f19613d = aVar;
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(this.f19613d.o());
        }
    }

    public class c extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.badge.a f19614d;

        public c(com.google.android.material.badge.a aVar) {
            this.f19614d = aVar;
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(this.f19614d.o());
        }
    }

    public class d extends androidx.core.view.a {
        public d(View.AccessibilityDelegate accessibilityDelegate) {
            super(accessibilityDelegate);
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(null);
        }
    }

    public static void b(@n0 com.google.android.material.badge.a aVar, @n0 View view) {
        if (Build.VERSION.SDK_INT < 29 || !u0.G0(view)) {
            u0.B1(view, new c(aVar));
        } else {
            u0.B1(view, new C0201b(view.getAccessibilityDelegate(), aVar));
        }
    }

    public static void c(@n0 com.google.android.material.badge.a aVar, @n0 View view) {
        d(aVar, view, null);
    }

    public static void d(@n0 com.google.android.material.badge.a aVar, @n0 View view, @p0 FrameLayout frameLayout) {
        m(aVar, view, frameLayout);
        if (aVar.p() != null) {
            aVar.p().setForeground(aVar);
        } else {
            if (f19607a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(aVar);
        }
    }

    public static void e(@n0 com.google.android.material.badge.a aVar, @n0 Toolbar toolbar, @d0 int i10) {
        f(aVar, toolbar, i10, null);
    }

    public static void f(@n0 com.google.android.material.badge.a aVar, @n0 Toolbar toolbar, @d0 int i10, @p0 FrameLayout frameLayout) {
        toolbar.post(new a(toolbar, i10, aVar, frameLayout));
    }

    @n0
    public static SparseArray<com.google.android.material.badge.a> g(Context context, @n0 ParcelableSparseArray parcelableSparseArray) {
        SparseArray<com.google.android.material.badge.a> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i10 = 0; i10 < parcelableSparseArray.size(); i10++) {
            int iKeyAt = parcelableSparseArray.keyAt(i10);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i10);
            if (state == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(iKeyAt, com.google.android.material.badge.a.f(context, state));
        }
        return sparseArray;
    }

    @n0
    public static ParcelableSparseArray h(@n0 SparseArray<com.google.android.material.badge.a> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int iKeyAt = sparseArray.keyAt(i10);
            com.google.android.material.badge.a aVarValueAt = sparseArray.valueAt(i10);
            if (aVarValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, aVarValueAt.v());
        }
        return parcelableSparseArray;
    }

    public static void i(@n0 View view) {
        if (Build.VERSION.SDK_INT < 29 || !u0.G0(view)) {
            u0.B1(view, null);
        } else {
            u0.B1(view, new d(view.getAccessibilityDelegate()));
        }
    }

    public static void j(@p0 com.google.android.material.badge.a aVar, @n0 View view) {
        if (aVar == null) {
            return;
        }
        if (f19607a || aVar.p() != null) {
            aVar.p().setForeground(null);
        } else {
            view.getOverlay().remove(aVar);
        }
    }

    public static void k(@p0 com.google.android.material.badge.a aVar, @n0 Toolbar toolbar, @d0 int i10) {
        if (aVar == null) {
            return;
        }
        ActionMenuItemView actionMenuItemViewA = u.a(toolbar, i10);
        if (actionMenuItemViewA != null) {
            l(aVar);
            j(aVar, actionMenuItemViewA);
            i(actionMenuItemViewA);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to remove badge from a null menuItemView: ");
            sb2.append(i10);
        }
    }

    @i1
    public static void l(com.google.android.material.badge.a aVar) {
        aVar.K(0);
        aVar.L(0);
    }

    public static void m(@n0 com.google.android.material.badge.a aVar, @n0 View view, @p0 FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.i0(view, frameLayout);
    }

    @i1
    public static void n(com.google.android.material.badge.a aVar, Resources resources) {
        aVar.K(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        aVar.L(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void o(@n0 Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
