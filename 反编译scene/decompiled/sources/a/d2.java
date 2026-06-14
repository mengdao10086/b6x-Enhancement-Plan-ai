package a;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class d2 implements Toolbar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f5850a;

    public d2(h2 h2Var) {
        this.f5850a = h2Var;
    }

    @Override // androidx.appcompat.widget.Toolbar.f
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f5850a.f1096a.onMenuItemSelected(0, menuItem);
    }
}
