package a;

import a.v4;
import android.R;
import android.content.Context;
import android.content.res.Resources;
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

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b5 extends s4 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, v4, View.OnKeyListener {
    public static final int f = z.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h4 f215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final i4 f216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final w7 f218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewTreeObserver f223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PopupWindow.OnDismissListener f224a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f225b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f226b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f227c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f228d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f229e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewTreeObserver.OnGlobalLayoutListener f222a = new z4(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnAttachStateChangeListener f220a = new a5(this);
    public int e = 0;

    public b5(Context context, i4 i4Var, View view, int i, int i2, boolean z) {
        this.f219a = context;
        this.f216a = i4Var;
        this.f226b = z;
        this.f215a = new h4(i4Var, LayoutInflater.from(context), this.f226b, f);
        this.b = i;
        this.c = i2;
        Resources resources = context.getResources();
        this.f5673a = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(w.abc_config_prefDialogWidth));
        this.f221a = view;
        this.f218a = new w7(this.f219a, null, this.b, this.c);
        i4Var.c(this, context);
    }

    @Override // a.y4
    public boolean a() {
        return !this.f227c && this.f218a.a();
    }

    @Override // a.v4
    public void b(i4 i4Var, boolean z) {
        if (i4Var != this.f216a) {
            return;
        }
        dismiss();
        v4.a aVar = this.f217a;
        if (aVar != null) {
            aVar.b(i4Var, z);
        }
    }

    @Override // a.y4
    public void c() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // a.y4
    public void dismiss() {
        if (a()) {
            this.f218a.dismiss();
        }
    }

    @Override // a.y4
    public ListView e() {
        return this.f218a.e();
    }

    @Override // a.v4
    public void g(v4.a aVar) {
        this.f217a = aVar;
    }

    @Override // a.v4
    public boolean h() {
        return false;
    }

    @Override // a.v4
    public void i(boolean z) {
        this.f228d = false;
        h4 h4Var = this.f215a;
        if (h4Var != null) {
            h4Var.notifyDataSetChanged();
        }
    }

    @Override // a.v4
    public boolean j(c5 c5Var) {
        if (c5Var.hasVisibleItems()) {
            u4 u4Var = new u4(this.f219a, c5Var, this.f225b, this.f226b, this.b, this.c);
            u4Var.j(this.f217a);
            u4Var.g(s4.x(c5Var));
            u4Var.i(this.f224a);
            this.f224a = null;
            this.f216a.e(false);
            int i = this.f218a.i();
            int iK = this.f218a.k();
            if ((Gravity.getAbsoluteGravity(this.e, eh.y(this.f221a)) & 7) == 5) {
                i += this.f221a.getWidth();
            }
            if (u4Var.n(i, iK)) {
                v4.a aVar = this.f217a;
                if (aVar == null) {
                    return true;
                }
                aVar.c(c5Var);
                return true;
            }
        }
        return false;
    }

    @Override // a.s4
    public void l(i4 i4Var) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f227c = true;
        this.f216a.close();
        ViewTreeObserver viewTreeObserver = this.f223a;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f223a = this.f225b.getViewTreeObserver();
            }
            this.f223a.removeGlobalOnLayoutListener(this.f222a);
            this.f223a = null;
        }
        this.f225b.removeOnAttachStateChangeListener(this.f220a);
        PopupWindow.OnDismissListener onDismissListener = this.f224a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // a.s4
    public void p(View view) {
        this.f221a = view;
    }

    @Override // a.s4
    public void r(boolean z) {
        this.f215a.d(z);
    }

    @Override // a.s4
    public void s(int i) {
        this.e = i;
    }

    @Override // a.s4
    public void t(int i) {
        this.f218a.l(i);
    }

    @Override // a.s4
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f224a = onDismissListener;
    }

    @Override // a.s4
    public void v(boolean z) {
        this.f229e = z;
    }

    @Override // a.s4
    public void w(int i) {
        this.f218a.d(i);
    }

    public final boolean z() {
        View view;
        if (a()) {
            return true;
        }
        if (this.f227c || (view = this.f221a) == null) {
            return false;
        }
        this.f225b = view;
        this.f218a.K(this);
        this.f218a.L(this);
        this.f218a.J(true);
        View view2 = this.f225b;
        boolean z = this.f223a == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f223a = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f222a);
        }
        view2.addOnAttachStateChangeListener(this.f220a);
        this.f218a.D(view2);
        this.f218a.G(this.e);
        if (!this.f228d) {
            this.d = s4.o(this.f215a, null, this.f219a, this.f5673a);
            this.f228d = true;
        }
        this.f218a.F(this.d);
        this.f218a.I(2);
        this.f218a.H(n());
        this.f218a.c();
        ListView listViewE = this.f218a.e();
        listViewE.setOnKeyListener(this);
        if (this.f229e && this.f216a.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f219a).inflate(z.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f216a.x());
            }
            frameLayout.setEnabled(false);
            listViewE.addHeaderView(frameLayout, null, false);
        }
        this.f218a.n(this.f215a);
        this.f218a.c();
        return true;
    }
}
