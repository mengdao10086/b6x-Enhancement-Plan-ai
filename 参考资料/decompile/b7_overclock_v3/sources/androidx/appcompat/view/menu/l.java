package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.l0;
import androidx.core.view.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends m.d implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, j, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f1983v = R.layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f1985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f1986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l0 f1991i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1994l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f1995m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f1996n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j.a f1997o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f1998p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1999q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2000r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2001s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2003u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1992j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1993k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2002t = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.d() || l.this.f1991i.L()) {
                return;
            }
            View view = l.this.f1996n;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f1991i.a();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f1998p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f1998p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f1998p.removeGlobalOnLayoutListener(lVar.f1992j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i10, int i11, boolean z10) {
        this.f1984b = context;
        this.f1985c = eVar;
        this.f1987e = z10;
        this.f1986d = new d(eVar, LayoutInflater.from(context), z10, f1983v);
        this.f1989g = i10;
        this.f1990h = i11;
        Resources resources = context.getResources();
        this.f1988f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1995m = view;
        this.f1991i = new l0(context, null, i10, i11);
        eVar.c(this, context);
    }

    public final boolean C() {
        View view;
        if (d()) {
            return true;
        }
        if (this.f1999q || (view = this.f1995m) == null) {
            return false;
        }
        this.f1996n = view;
        this.f1991i.e0(this);
        this.f1991i.f0(this);
        this.f1991i.d0(true);
        View view2 = this.f1996n;
        boolean z10 = this.f1998p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1998p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1992j);
        }
        view2.addOnAttachStateChangeListener(this.f1993k);
        this.f1991i.S(view2);
        this.f1991i.W(this.f2002t);
        if (!this.f2000r) {
            this.f2001s = m.d.r(this.f1986d, null, this.f1984b, this.f1988f);
            this.f2000r = true;
        }
        this.f1991i.U(this.f2001s);
        this.f1991i.a0(2);
        this.f1991i.X(q());
        this.f1991i.a();
        ListView listViewK = this.f1991i.k();
        listViewK.setOnKeyListener(this);
        if (this.f2003u && this.f1985c.A() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1984b).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f1985c.A());
            }
            frameLayout.setEnabled(false);
            listViewK.addHeaderView(frameLayout, null, false);
        }
        this.f1991i.q(this.f1986d);
        this.f1991i.a();
        return true;
    }

    @Override // m.f
    public void a() {
        if (!C()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z10) {
        if (eVar != this.f1985c) {
            return;
        }
        dismiss();
        j.a aVar = this.f1997o;
        if (aVar != null) {
            aVar.b(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        this.f2000r = false;
        d dVar = this.f1986d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // m.f
    public boolean d() {
        return !this.f1999q && this.f1991i.d();
    }

    @Override // m.f
    public void dismiss() {
        if (d()) {
            this.f1991i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1997o = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
    }

    @Override // m.f
    public ListView k() {
        return this.f1991i.k();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f1984b, mVar, this.f1996n, this.f1987e, this.f1989g, this.f1990h);
            iVar.a(this.f1997o);
            iVar.i(m.d.A(mVar));
            iVar.k(this.f1994l);
            this.f1994l = null;
            this.f1985c.f(false);
            int iE = this.f1991i.e();
            int iO = this.f1991i.o();
            if ((Gravity.getAbsoluteGravity(this.f2002t, u0.Z(this.f1995m)) & 7) == 5) {
                iE += this.f1995m.getWidth();
            }
            if (iVar.p(iE, iO)) {
                j.a aVar = this.f1997o;
                if (aVar == null) {
                    return true;
                }
                aVar.c(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable n() {
        return null;
    }

    @Override // m.d
    public void o(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1999q = true;
        this.f1985c.close();
        ViewTreeObserver viewTreeObserver = this.f1998p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1998p = this.f1996n.getViewTreeObserver();
            }
            this.f1998p.removeGlobalOnLayoutListener(this.f1992j);
            this.f1998p = null;
        }
        this.f1996n.removeOnAttachStateChangeListener(this.f1993k);
        PopupWindow.OnDismissListener onDismissListener = this.f1994l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // m.d
    public void s(View view) {
        this.f1995m = view;
    }

    @Override // m.d
    public void u(boolean z10) {
        this.f1986d.e(z10);
    }

    @Override // m.d
    public void v(int i10) {
        this.f2002t = i10;
    }

    @Override // m.d
    public void w(int i10) {
        this.f1991i.f(i10);
    }

    @Override // m.d
    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f1994l = onDismissListener;
    }

    @Override // m.d
    public void y(boolean z10) {
        this.f2003u = z10;
    }

    @Override // m.d
    public void z(int i10) {
        this.f1991i.l(i10);
    }
}
