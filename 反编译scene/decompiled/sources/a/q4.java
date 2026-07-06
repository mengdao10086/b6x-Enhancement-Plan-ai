package a;

import android.view.MenuItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q4 implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r4 f7176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MenuItem.OnMenuItemClickListener f2542a;

    public q4(r4 r4Var, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f7176a = r4Var;
        this.f2542a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f2542a.onMenuItemClick(this.f7176a.e(menuItem));
    }
}
