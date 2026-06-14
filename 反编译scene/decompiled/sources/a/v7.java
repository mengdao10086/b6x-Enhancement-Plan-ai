package a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class v7 extends h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u7 f7664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MenuItem f3251a;
    public final int f;
    public final int g;

    public v7(Context context, boolean z) {
        super(context, z);
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
            this.f = 22;
            this.g = 21;
        } else {
            this.f = 21;
            this.g = 22;
        }
    }

    @Override // a.h7, android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.f7664a != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                adapter = headerViewListAdapter.getWrappedAdapter();
            } else {
                headersCount = 0;
            }
            h4 h4Var = (h4) adapter;
            l4 item = null;
            if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < h4Var.getCount()) {
                item = h4Var.getItem(i);
            }
            MenuItem menuItem = this.f3251a;
            if (menuItem != item) {
                i4 i4VarB = h4Var.b();
                if (menuItem != null) {
                    this.f7664a.m(i4VarB, menuItem);
                }
                this.f3251a = item;
                if (item != null) {
                    this.f7664a.h(i4VarB, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.f) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.g) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ((h4) getAdapter()).b().e(false);
        return true;
    }

    public void setHoverListener(u7 u7Var) {
        this.f7664a = u7Var;
    }

    @Override // a.h7, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
