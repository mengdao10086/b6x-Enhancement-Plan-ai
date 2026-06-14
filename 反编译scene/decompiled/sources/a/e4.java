package a;

import a.v4;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e4 extends s4 implements v4, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int i = z.abc_cascading_menu_item_layout;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewTreeObserver f659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PopupWindow.OnDismissListener f660a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f662b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f664b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f665c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f666d;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f668f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f669g;
    public int h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<i4> f661a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<d4> f663b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewTreeObserver.OnGlobalLayoutListener f658a = new z3(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnAttachStateChangeListener f656a = new a4(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u7 f652a = new c4(this);
    public int d = 0;
    public int e = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f667e = false;
    public int f = D();

    public e4(Context context, View view, int i2, int i3, boolean z) {
        this.f654a = context;
        this.f657a = view;
        this.b = i2;
        this.c = i3;
        this.f664b = z;
        Resources resources = context.getResources();
        this.f5963a = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(w.abc_config_prefDialogWidth));
        this.f655a = new Handler();
    }

    public final int A(i4 i4Var) {
        int size = this.f663b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i4Var == this.f663b.get(i2).f476a) {
                return i2;
            }
        }
        return -1;
    }

    public final MenuItem B(i4 i4Var, i4 i4Var2) {
        int size = i4Var.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = i4Var.getItem(i2);
            if (item.hasSubMenu() && i4Var2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View C(d4 d4Var, i4 i4Var) {
        h4 h4Var;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(d4Var.f476a, i4Var);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = d4Var.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            h4Var = (h4) headerViewListAdapter.getWrappedAdapter();
        } else {
            h4Var = (h4) adapter;
            headersCount = 0;
        }
        int count = h4Var.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (menuItemB == h4Var.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int D() {
        return eh.y(this.f657a) == 1 ? 0 : 1;
    }

    public final int E(int i2) {
        List<d4> list = this.f663b;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f662b.getWindowVisibleDisplayFrame(rect);
        return this.f == 1 ? (iArr[0] + listViewA.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    public final void F(i4 i4Var) {
        d4 d4Var;
        View viewC;
        int i2;
        int i3;
        int i4;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f654a);
        h4 h4Var = new h4(i4Var, layoutInflaterFrom, this.f664b, i);
        if (!a() && this.f667e) {
            h4Var.d(true);
        } else if (a()) {
            h4Var.d(s4.x(i4Var));
        }
        int iO = s4.o(h4Var, null, this.f654a, this.f5963a);
        w7 w7VarZ = z();
        w7VarZ.n(h4Var);
        w7VarZ.F(iO);
        w7VarZ.G(this.e);
        if (this.f663b.size() > 0) {
            List<d4> list = this.f663b;
            d4Var = list.get(list.size() - 1);
            viewC = C(d4Var, i4Var);
        } else {
            d4Var = null;
            viewC = null;
        }
        if (viewC != null) {
            w7VarZ.U(false);
            w7VarZ.R(null);
            int iE = E(iO);
            boolean z = iE == 1;
            this.f = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                w7VarZ.D(viewC);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.f657a.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.e & 7) == 5) {
                    iArr[0] = iArr[0] + this.f657a.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.e & 5) == 5) {
                if (!z) {
                    iO = viewC.getWidth();
                    i4 = i2 - iO;
                }
                i4 = i2 + iO;
            } else {
                if (z) {
                    iO = viewC.getWidth();
                    i4 = i2 + iO;
                }
                i4 = i2 - iO;
            }
            w7VarZ.l(i4);
            w7VarZ.M(true);
            w7VarZ.d(i3);
        } else {
            if (this.f665c) {
                w7VarZ.l(this.g);
            }
            if (this.f666d) {
                w7VarZ.d(this.h);
            }
            w7VarZ.H(n());
        }
        this.f663b.add(new d4(w7VarZ, i4Var, this.f));
        w7VarZ.c();
        ListView listViewE = w7VarZ.e();
        listViewE.setOnKeyListener(this);
        if (d4Var == null && this.f668f && i4Var.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(z.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(i4Var.x());
            listViewE.addHeaderView(frameLayout, null, false);
            w7VarZ.c();
        }
    }

    @Override // a.y4
    public boolean a() {
        return this.f663b.size() > 0 && this.f663b.get(0).f477a.a();
    }

    @Override // a.v4
    public void b(i4 i4Var, boolean z) {
        int iA = A(i4Var);
        if (iA < 0) {
            return;
        }
        int i2 = iA + 1;
        if (i2 < this.f663b.size()) {
            this.f663b.get(i2).f476a.e(false);
        }
        d4 d4VarRemove = this.f663b.remove(iA);
        d4VarRemove.f476a.O(this);
        if (this.f669g) {
            d4VarRemove.f477a.S(null);
            d4VarRemove.f477a.E(0);
        }
        d4VarRemove.f477a.dismiss();
        int size = this.f663b.size();
        this.f = size > 0 ? this.f663b.get(size - 1).f5857a : D();
        if (size != 0) {
            if (z) {
                this.f663b.get(0).f476a.e(false);
                return;
            }
            return;
        }
        dismiss();
        v4.a aVar = this.f653a;
        if (aVar != null) {
            aVar.b(i4Var, true);
        }
        ViewTreeObserver viewTreeObserver = this.f659a;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f659a.removeGlobalOnLayoutListener(this.f658a);
            }
            this.f659a = null;
        }
        this.f662b.removeOnAttachStateChangeListener(this.f656a);
        this.f660a.onDismiss();
    }

    @Override // a.y4
    public void c() {
        if (a()) {
            return;
        }
        Iterator<i4> it = this.f661a.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f661a.clear();
        View view = this.f657a;
        this.f662b = view;
        if (view != null) {
            boolean z = this.f659a == null;
            ViewTreeObserver viewTreeObserver = this.f662b.getViewTreeObserver();
            this.f659a = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f658a);
            }
            this.f662b.addOnAttachStateChangeListener(this.f656a);
        }
    }

    @Override // a.y4
    public void dismiss() {
        int size = this.f663b.size();
        if (size > 0) {
            d4[] d4VarArr = (d4[]) this.f663b.toArray(new d4[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d4 d4Var = d4VarArr[i2];
                if (d4Var.f477a.a()) {
                    d4Var.f477a.dismiss();
                }
            }
        }
    }

    @Override // a.y4
    public ListView e() {
        if (this.f663b.isEmpty()) {
            return null;
        }
        return this.f663b.get(r0.size() - 1).a();
    }

    @Override // a.v4
    public void g(v4.a aVar) {
        this.f653a = aVar;
    }

    @Override // a.v4
    public boolean h() {
        return false;
    }

    @Override // a.v4
    public void i(boolean z) {
        Iterator<d4> it = this.f663b.iterator();
        while (it.hasNext()) {
            s4.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // a.v4
    public boolean j(c5 c5Var) {
        for (d4 d4Var : this.f663b) {
            if (c5Var == d4Var.f476a) {
                d4Var.a().requestFocus();
                return true;
            }
        }
        if (!c5Var.hasVisibleItems()) {
            return false;
        }
        l(c5Var);
        v4.a aVar = this.f653a;
        if (aVar != null) {
            aVar.c(c5Var);
        }
        return true;
    }

    @Override // a.s4
    public void l(i4 i4Var) {
        i4Var.c(this, this.f654a);
        if (a()) {
            F(i4Var);
        } else {
            this.f661a.add(i4Var);
        }
    }

    @Override // a.s4
    public boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d4 d4Var;
        int size = this.f663b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                d4Var = null;
                break;
            }
            d4Var = this.f663b.get(i2);
            if (!d4Var.f477a.a()) {
                break;
            } else {
                i2++;
            }
        }
        if (d4Var != null) {
            d4Var.f476a.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // a.s4
    public void p(View view) {
        if (this.f657a != view) {
            this.f657a = view;
            this.e = bg.b(this.d, eh.y(view));
        }
    }

    @Override // a.s4
    public void r(boolean z) {
        this.f667e = z;
    }

    @Override // a.s4
    public void s(int i2) {
        if (this.d != i2) {
            this.d = i2;
            this.e = bg.b(i2, eh.y(this.f657a));
        }
    }

    @Override // a.s4
    public void t(int i2) {
        this.f665c = true;
        this.g = i2;
    }

    @Override // a.s4
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f660a = onDismissListener;
    }

    @Override // a.s4
    public void v(boolean z) {
        this.f668f = z;
    }

    @Override // a.s4
    public void w(int i2) {
        this.f666d = true;
        this.h = i2;
    }

    public final w7 z() {
        w7 w7Var = new w7(this.f654a, null, this.b, this.c);
        w7Var.T(this.f652a);
        w7Var.L(this);
        w7Var.K(this);
        w7Var.D(this.f657a);
        w7Var.G(this.e);
        w7Var.J(true);
        w7Var.I(2);
        return w7Var;
    }
}
