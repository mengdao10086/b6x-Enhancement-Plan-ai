package a;

import android.view.MenuItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p4 implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r4 f7081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MenuItem.OnActionExpandListener f2384a;

    public p4(r4 r4Var, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f7081a = r4Var;
        this.f2384a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f2384a.onMenuItemActionCollapse(this.f7081a.e(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f2384a.onMenuItemActionExpand(this.f7081a.e(menuItem));
    }
}
