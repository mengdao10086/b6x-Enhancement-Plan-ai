package a;

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

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class s4 implements y4, v4, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f7360a;

    public static int o(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean x(i4 i4Var) {
        int size = i4Var.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = i4Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static h4 y(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (h4) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (h4) listAdapter;
    }

    @Override // a.v4
    public boolean d(i4 i4Var, l4 l4Var) {
        return false;
    }

    @Override // a.v4
    public void f(Context context, i4 i4Var) {
    }

    @Override // a.v4
    public boolean k(i4 i4Var, l4 l4Var) {
        return false;
    }

    public abstract void l(i4 i4Var);

    public boolean m() {
        return true;
    }

    public Rect n() {
        return this.f7360a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        y(listAdapter).f1119a.M((MenuItem) listAdapter.getItem(i), this, m() ? 0 : 4);
    }

    public abstract void p(View view);

    public void q(Rect rect) {
        this.f7360a = rect;
    }

    public abstract void r(boolean z);

    public abstract void s(int i);

    public abstract void t(int i);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z);

    public abstract void w(int i);
}
