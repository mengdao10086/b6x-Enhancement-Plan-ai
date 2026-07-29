package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
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
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l0;
import androidx.core.view.u0;
import g.d1;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends m.d implements j, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = R.layout.abc_cascading_menu_item_layout;
    public static final int C = 0;
    public static final int D = 1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f1878k0 = 200;
    public boolean A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f1884g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f1892o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f1893p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1896s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1897t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1898u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1900w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j.a f1901x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f1902y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1903z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<androidx.appcompat.view.menu.e> f1885h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<d> f1886i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1887j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1888k = new ViewOnAttachStateChangeListenerC0032b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k0 f1889l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1890m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1891n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1899v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1894q = G();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.d() || b.this.f1886i.size() <= 0 || b.this.f1886i.get(0).f1911a.L()) {
                return;
            }
            View view = b.this.f1893p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator<d> it2 = b.this.f1886i.iterator();
            while (it2.hasNext()) {
                it2.next().f1911a.a();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0032b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0032b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f1902y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f1902y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f1902y.removeGlobalOnLayoutListener(bVar.f1887j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements k0 {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f1907a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f1908b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ androidx.appcompat.view.menu.e f1909c;

            public a(d dVar, MenuItem menuItem, androidx.appcompat.view.menu.e eVar) {
                this.f1907a = dVar;
                this.f1908b = menuItem;
                this.f1909c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f1907a;
                if (dVar != null) {
                    b.this.A = true;
                    dVar.f1912b.f(false);
                    b.this.A = false;
                }
                if (this.f1908b.isEnabled() && this.f1908b.hasSubMenu()) {
                    this.f1909c.O(this.f1908b, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.k0
        public void b(@n0 androidx.appcompat.view.menu.e eVar, @n0 MenuItem menuItem) {
            b.this.f1884g.removeCallbacksAndMessages(null);
            int size = b.this.f1886i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (eVar == b.this.f1886i.get(i10).f1912b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            b.this.f1884g.postAtTime(new a(i11 < b.this.f1886i.size() ? b.this.f1886i.get(i11) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.k0
        public void h(@n0 androidx.appcompat.view.menu.e eVar, @n0 MenuItem menuItem) {
            b.this.f1884g.removeCallbacksAndMessages(eVar);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f1911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.appcompat.view.menu.e f1912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1913c;

        public d(@n0 l0 l0Var, @n0 androidx.appcompat.view.menu.e eVar, int i10) {
            this.f1911a = l0Var;
            this.f1912b = eVar;
            this.f1913c = i10;
        }

        public ListView a() {
            return this.f1911a.k();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public b(@n0 Context context, @n0 View view, @g.f int i10, @d1 int i11, boolean z10) {
        this.f1879b = context;
        this.f1892o = view;
        this.f1881d = i10;
        this.f1882e = i11;
        this.f1883f = z10;
        Resources resources = context.getResources();
        this.f1880c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1884g = new Handler();
    }

    public final l0 C() {
        l0 l0Var = new l0(this.f1879b, null, this.f1881d, this.f1882e);
        l0Var.r0(this.f1889l);
        l0Var.f0(this);
        l0Var.e0(this);
        l0Var.S(this.f1892o);
        l0Var.W(this.f1891n);
        l0Var.d0(true);
        l0Var.a0(2);
        return l0Var;
    }

    public final int D(@n0 androidx.appcompat.view.menu.e eVar) {
        int size = this.f1886i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (eVar == this.f1886i.get(i10).f1912b) {
                return i10;
            }
        }
        return -1;
    }

    public final MenuItem E(@n0 androidx.appcompat.view.menu.e eVar, @n0 androidx.appcompat.view.menu.e eVar2) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @p0
    public final View F(@n0 d dVar, @n0 androidx.appcompat.view.menu.e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemE = E(dVar.f1912b, eVar);
        if (menuItemE == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i10 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i10 >= count) {
                i10 = -1;
                break;
            }
            if (menuItemE == dVar2.getItem(i10)) {
                break;
            }
            i10++;
        }
        if (i10 != -1 && (firstVisiblePosition = (i10 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int G() {
        return u0.Z(this.f1892o) == 1 ? 0 : 1;
    }

    public final int H(int i10) {
        List<d> list = this.f1886i;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1893p.getWindowVisibleDisplayFrame(rect);
        return this.f1894q == 1 ? (iArr[0] + listViewA.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    public final void I(@n0 androidx.appcompat.view.menu.e eVar) {
        d dVar;
        View viewF;
        int i10;
        int i11;
        int i12;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1879b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f1883f, B);
        if (!d() && this.f1899v) {
            dVar2.e(true);
        } else if (d()) {
            dVar2.e(m.d.A(eVar));
        }
        int iR = m.d.r(dVar2, null, this.f1879b, this.f1880c);
        l0 l0VarC = C();
        l0VarC.q(dVar2);
        l0VarC.U(iR);
        l0VarC.W(this.f1891n);
        if (this.f1886i.size() > 0) {
            List<d> list = this.f1886i;
            dVar = list.get(list.size() - 1);
            viewF = F(dVar, eVar);
        } else {
            dVar = null;
            viewF = null;
        }
        if (viewF != null) {
            l0VarC.s0(false);
            l0VarC.p0(null);
            int iH = H(iR);
            boolean z10 = iH == 1;
            this.f1894q = iH;
            if (Build.VERSION.SDK_INT >= 26) {
                l0VarC.S(viewF);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1892o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewF.getLocationOnScreen(iArr2);
                if ((this.f1891n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1892o.getWidth();
                    iArr2[0] = iArr2[0] + viewF.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f1891n & 5) == 5) {
                if (!z10) {
                    iR = viewF.getWidth();
                    i12 = i10 - iR;
                }
                i12 = i10 + iR;
            } else {
                if (z10) {
                    iR = viewF.getWidth();
                    i12 = i10 + iR;
                }
                i12 = i10 - iR;
            }
            l0VarC.f(i12);
            l0VarC.h0(true);
            l0VarC.l(i11);
        } else {
            if (this.f1895r) {
                l0VarC.f(this.f1897t);
            }
            if (this.f1896s) {
                l0VarC.l(this.f1898u);
            }
            l0VarC.X(q());
        }
        this.f1886i.add(new d(l0VarC, eVar, this.f1894q));
        l0VarC.a();
        ListView listViewK = l0VarC.k();
        listViewK.setOnKeyListener(this);
        if (dVar == null && this.f1900w && eVar.A() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.A());
            listViewK.addHeaderView(frameLayout, null, false);
            l0VarC.a();
        }
    }

    @Override // m.f
    public void a() {
        if (d()) {
            return;
        }
        Iterator<androidx.appcompat.view.menu.e> it2 = this.f1885h.iterator();
        while (it2.hasNext()) {
            I(it2.next());
        }
        this.f1885h.clear();
        View view = this.f1892o;
        this.f1893p = view;
        if (view != null) {
            boolean z10 = this.f1902y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1902y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1887j);
            }
            this.f1893p.addOnAttachStateChangeListener(this.f1888k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(androidx.appcompat.view.menu.e eVar, boolean z10) {
        int iD = D(eVar);
        if (iD < 0) {
            return;
        }
        int i10 = iD + 1;
        if (i10 < this.f1886i.size()) {
            this.f1886i.get(i10).f1912b.f(false);
        }
        d dVarRemove = this.f1886i.remove(iD);
        dVarRemove.f1912b.S(this);
        if (this.A) {
            dVarRemove.f1911a.q0(null);
            dVarRemove.f1911a.T(0);
        }
        dVarRemove.f1911a.dismiss();
        int size = this.f1886i.size();
        if (size > 0) {
            this.f1894q = this.f1886i.get(size - 1).f1913c;
        } else {
            this.f1894q = G();
        }
        if (size != 0) {
            if (z10) {
                this.f1886i.get(0).f1912b.f(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f1901x;
        if (aVar != null) {
            aVar.b(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1902y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1902y.removeGlobalOnLayoutListener(this.f1887j);
            }
            this.f1902y = null;
        }
        this.f1893p.removeOnAttachStateChangeListener(this.f1888k);
        this.f1903z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        Iterator<d> it2 = this.f1886i.iterator();
        while (it2.hasNext()) {
            m.d.B(it2.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // m.f
    public boolean d() {
        return this.f1886i.size() > 0 && this.f1886i.get(0).f1911a.d();
    }

    @Override // m.f
    public void dismiss() {
        int size = this.f1886i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f1886i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f1911a.d()) {
                    dVar.f1911a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1901x = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
    }

    @Override // m.f
    public ListView k() {
        if (this.f1886i.isEmpty()) {
            return null;
        }
        return this.f1886i.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        for (d dVar : this.f1886i) {
            if (mVar == dVar.f1912b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        o(mVar);
        j.a aVar = this.f1901x;
        if (aVar != null) {
            aVar.c(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable n() {
        return null;
    }

    @Override // m.d
    public void o(androidx.appcompat.view.menu.e eVar) {
        eVar.c(this, this.f1879b);
        if (d()) {
            I(eVar);
        } else {
            this.f1885h.add(eVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f1886i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f1886i.get(i10);
            if (!dVar.f1911a.d()) {
                break;
            } else {
                i10++;
            }
        }
        if (dVar != null) {
            dVar.f1912b.f(false);
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
    public boolean p() {
        return false;
    }

    @Override // m.d
    public void s(@n0 View view) {
        if (this.f1892o != view) {
            this.f1892o = view;
            this.f1891n = androidx.core.view.m.d(this.f1890m, u0.Z(view));
        }
    }

    @Override // m.d
    public void u(boolean z10) {
        this.f1899v = z10;
    }

    @Override // m.d
    public void v(int i10) {
        if (this.f1890m != i10) {
            this.f1890m = i10;
            this.f1891n = androidx.core.view.m.d(i10, u0.Z(this.f1892o));
        }
    }

    @Override // m.d
    public void w(int i10) {
        this.f1895r = true;
        this.f1897t = i10;
    }

    @Override // m.d
    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f1903z = onDismissListener;
    }

    @Override // m.d
    public void y(boolean z10) {
        this.f1900w = z10;
    }

    @Override // m.d
    public void z(int i10) {
        this.f1896s = true;
        this.f1898u = i10;
    }
}
