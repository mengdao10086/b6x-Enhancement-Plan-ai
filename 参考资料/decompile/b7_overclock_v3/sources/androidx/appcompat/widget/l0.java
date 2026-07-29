package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class l0 extends j0 implements k0 {
    public static final String L7 = "MenuPopupWindow";
    public static Method M7;
    public k0 K7;

    @g.v0(23)
    public static class a {
        @g.u
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        @g.u
        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    @g.v0(29)
    public static class b {
        @g.u
        public static void a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class c extends e0 {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f2582q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f2583r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public k0 f2584s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public MenuItem f2585t;

        @g.v0(17)
        public static class a {
            @g.u
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z10) {
            super(context, z10);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f2582q = 21;
                this.f2583r = 22;
            } else {
                this.f2582q = 22;
                this.f2583r = 21;
            }
        }

        @Override // androidx.appcompat.widget.e0
        public /* bridge */ /* synthetic */ int d(int i10, boolean z10) {
            return super.d(i10, z10);
        }

        @Override // androidx.appcompat.widget.e0
        public /* bridge */ /* synthetic */ int e(int i10, int i11, int i12, int i13, int i14) {
            return super.e(i10, i11, i12, i13, i14);
        }

        @Override // androidx.appcompat.widget.e0
        public /* bridge */ /* synthetic */ boolean f(MotionEvent motionEvent, int i10) {
            return super.f(motionEvent, i10);
        }

        @Override // androidx.appcompat.widget.e0, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.e0, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.e0, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.e0, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public void m() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.e0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.d dVar;
            int iPointToPosition;
            int i10;
            if (this.f2584s != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                }
                androidx.appcompat.view.menu.h item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i10 = iPointToPosition - headersCount) >= 0 && i10 < dVar.getCount()) {
                    item = dVar.getItem(i10);
                }
                MenuItem menuItem = this.f2585t;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = dVar.b();
                    if (menuItem != null) {
                        this.f2584s.h(eVarB, menuItem);
                    }
                    this.f2585t = item;
                    if (item != null) {
                        this.f2584s.b(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f2582q) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i10 != this.f2583r) {
                return super.onKeyDown(i10, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) adapter).b().f(false);
            return true;
        }

        @Override // androidx.appcompat.widget.e0, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(k0 k0Var) {
            this.f2584s = k0Var;
        }

        @Override // androidx.appcompat.widget.e0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                M7 = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public l0(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.appcompat.widget.k0
    public void b(@g.n0 androidx.appcompat.view.menu.e eVar, @g.n0 MenuItem menuItem) {
        k0 k0Var = this.K7;
        if (k0Var != null) {
            k0Var.b(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void h(@g.n0 androidx.appcompat.view.menu.e eVar, @g.n0 MenuItem menuItem) {
        k0 k0Var = this.K7;
        if (k0Var != null) {
            k0Var.h(eVar, menuItem);
        }
    }

    public void p0(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.K0, (Transition) obj);
        }
    }

    public void q0(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.K0, (Transition) obj);
        }
    }

    public void r0(k0 k0Var) {
        this.K7 = k0Var;
    }

    public void s0(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.K0, z10);
            return;
        }
        Method method = M7;
        if (method != null) {
            try {
                method.invoke(this.K0, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.widget.j0
    @g.n0
    public e0 u(Context context, boolean z10) {
        c cVar = new c(context, z10);
        cVar.setHoverListener(this);
        return cVar;
    }
}
