package m;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements f, j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f40513a;

    public static boolean A(androidx.appcompat.view.menu.e eVar) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static androidx.appcompat.view.menu.d B(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) listAdapter;
    }

    public static int r(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i10) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i13, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(androidx.appcompat.view.menu.e eVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(androidx.appcompat.view.menu.e eVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(@n0 Context context, @p0 androidx.appcompat.view.menu.e eVar) {
    }

    @Override // androidx.appcompat.view.menu.j
    public k m(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    public abstract void o(androidx.appcompat.view.menu.e eVar);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        B(listAdapter).f1928a.P((MenuItem) listAdapter.getItem(i10), this, p() ? 0 : 4);
    }

    public boolean p() {
        return true;
    }

    public Rect q() {
        return this.f40513a;
    }

    public abstract void s(View view);

    public void t(Rect rect) {
        this.f40513a = rect;
    }

    public abstract void u(boolean z10);

    public abstract void v(int i10);

    public abstract void w(int i10);

    public abstract void x(PopupWindow.OnDismissListener onDismissListener);

    public abstract void y(boolean z10);

    public abstract void z(int i10);
}
