package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.core.view.u0;
import g.d1;
import g.n0;
import g.p0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class i implements g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f1969m = 48;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f1971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f1975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j.a f1978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m.d f1979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f1981l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.g();
        }
    }

    @v0(17)
    public static class b {
        @u
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public i(@n0 Context context, @n0 e eVar) {
        this(context, eVar, null, false, R.attr.popupMenuStyle, 0);
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(@p0 j.a aVar) {
        this.f1978i = aVar;
        m.d dVar = this.f1979j;
        if (dVar != null) {
            dVar.h(aVar);
        }
    }

    @n0
    public final m.d b() {
        Display defaultDisplay = ((WindowManager) this.f1970a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        b.a(defaultDisplay, point);
        m.d bVar = Math.min(point.x, point.y) >= this.f1970a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new androidx.appcompat.view.menu.b(this.f1970a, this.f1975f, this.f1973d, this.f1974e, this.f1972c) : new l(this.f1970a, this.f1971b, this.f1975f, this.f1973d, this.f1974e, this.f1972c);
        bVar.o(this.f1971b);
        bVar.x(this.f1981l);
        bVar.s(this.f1975f);
        bVar.h(this.f1978i);
        bVar.u(this.f1977h);
        bVar.v(this.f1976g);
        return bVar;
    }

    public int c() {
        return this.f1976g;
    }

    public ListView d() {
        return e().k();
    }

    @Override // androidx.appcompat.view.menu.g
    public void dismiss() {
        if (f()) {
            this.f1979j.dismiss();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public m.d e() {
        if (this.f1979j == null) {
            this.f1979j = b();
        }
        return this.f1979j;
    }

    public boolean f() {
        m.d dVar = this.f1979j;
        return dVar != null && dVar.d();
    }

    public void g() {
        this.f1979j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1980k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void h(@n0 View view) {
        this.f1975f = view;
    }

    public void i(boolean z10) {
        this.f1977h = z10;
        m.d dVar = this.f1979j;
        if (dVar != null) {
            dVar.u(z10);
        }
    }

    public void j(int i10) {
        this.f1976g = i10;
    }

    public void k(@p0 PopupWindow.OnDismissListener onDismissListener) {
        this.f1980k = onDismissListener;
    }

    public void l() {
        if (!o()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m(int i10, int i11) {
        if (!p(i10, i11)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void n(int i10, int i11, boolean z10, boolean z11) {
        m.d dVarE = e();
        dVarE.y(z11);
        if (z10) {
            if ((androidx.core.view.m.d(this.f1976g, u0.Z(this.f1975f)) & 7) == 5) {
                i10 -= this.f1975f.getWidth();
            }
            dVarE.w(i10);
            dVarE.z(i11);
            int i12 = (int) ((this.f1970a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            dVarE.t(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        dVarE.a();
    }

    public boolean o() {
        if (f()) {
            return true;
        }
        if (this.f1975f == null) {
            return false;
        }
        n(0, 0, false, false);
        return true;
    }

    public boolean p(int i10, int i11) {
        if (f()) {
            return true;
        }
        if (this.f1975f == null) {
            return false;
        }
        n(i10, i11, true, true);
        return true;
    }

    public i(@n0 Context context, @n0 e eVar, @n0 View view) {
        this(context, eVar, view, false, R.attr.popupMenuStyle, 0);
    }

    public i(@n0 Context context, @n0 e eVar, @n0 View view, boolean z10, @g.f int i10) {
        this(context, eVar, view, z10, i10, 0);
    }

    public i(@n0 Context context, @n0 e eVar, @n0 View view, boolean z10, @g.f int i10, @d1 int i11) {
        this.f1976g = androidx.core.view.m.f5025b;
        this.f1981l = new a();
        this.f1970a = context;
        this.f1971b = eVar;
        this.f1975f = view;
        this.f1972c = z10;
        this.f1973d = i10;
        this.f1974e = i11;
    }
}
