package a;

import a.i4;
import android.view.MenuItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f2 implements i4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f6065a;

    public f2(h2 h2Var) {
        this.f6065a = h2Var;
    }

    @Override // a.i4.a
    public void a(i4 i4Var) {
        h2 h2Var = this.f6065a;
        if (h2Var.f1096a != null) {
            if (h2Var.f6265a.d()) {
                this.f6065a.f1096a.onPanelClosed(108, i4Var);
            } else if (this.f6065a.f1096a.onPreparePanel(0, null, i4Var)) {
                this.f6065a.f1096a.onMenuOpened(108, i4Var);
            }
        }
    }

    @Override // a.i4.a
    public boolean b(i4 i4Var, MenuItem menuItem) {
        return false;
    }
}
