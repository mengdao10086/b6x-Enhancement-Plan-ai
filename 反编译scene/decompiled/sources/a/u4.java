package a;

import a.v4;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final i4 f3124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s4 f3125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f3126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f3128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PopupWindow.OnDismissListener f3129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3130a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final PopupWindow.OnDismissListener f3131b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3132b;
    public int c;

    public u4(Context context, i4 i4Var, View view, boolean z, int i) {
        this(context, i4Var, view, z, i, 0);
    }

    public u4(Context context, i4 i4Var, View view, boolean z, int i, int i2) {
        this.c = 8388611;
        this.f3131b = new t4(this);
        this.f3127a = context;
        this.f3124a = i4Var;
        this.f3128a = view;
        this.f3130a = z;
        this.f7563a = i;
        this.b = i2;
    }

    public final s4 a() {
        Display defaultDisplay = ((WindowManager) this.f3127a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        s4 e4Var = Math.min(point.x, point.y) >= this.f3127a.getResources().getDimensionPixelSize(w.abc_cascading_menus_min_smallest_width) ? new e4(this.f3127a, this.f3128a, this.f7563a, this.b, this.f3130a) : new b5(this.f3127a, this.f3124a, this.f3128a, this.f7563a, this.b, this.f3130a);
        e4Var.l(this.f3124a);
        e4Var.u(this.f3131b);
        e4Var.p(this.f3128a);
        e4Var.g(this.f3126a);
        e4Var.r(this.f3132b);
        e4Var.s(this.c);
        return e4Var;
    }

    public void b() {
        if (d()) {
            this.f3125a.dismiss();
        }
    }

    public s4 c() {
        if (this.f3125a == null) {
            this.f3125a = a();
        }
        return this.f3125a;
    }

    public boolean d() {
        s4 s4Var = this.f3125a;
        return s4Var != null && s4Var.a();
    }

    public void e() {
        this.f3125a = null;
        PopupWindow.OnDismissListener onDismissListener = this.f3129a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f3128a = view;
    }

    public void g(boolean z) {
        this.f3132b = z;
        s4 s4Var = this.f3125a;
        if (s4Var != null) {
            s4Var.r(z);
        }
    }

    public void h(int i) {
        this.c = i;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f3129a = onDismissListener;
    }

    public void j(v4.a aVar) {
        this.f3126a = aVar;
        s4 s4Var = this.f3125a;
        if (s4Var != null) {
            s4Var.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i, int i2, boolean z, boolean z2) {
        s4 s4VarC = c();
        s4VarC.v(z2);
        if (z) {
            if ((bg.b(this.c, eh.y(this.f3128a)) & 7) == 5) {
                i -= this.f3128a.getWidth();
            }
            s4VarC.t(i);
            s4VarC.w(i2);
            int i3 = (int) ((this.f3127a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            s4VarC.q(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        s4VarC.c();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f3128a == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i, int i2) {
        if (d()) {
            return true;
        }
        if (this.f3128a == null) {
            return false;
        }
        l(i, i2, true, true);
        return true;
    }
}
