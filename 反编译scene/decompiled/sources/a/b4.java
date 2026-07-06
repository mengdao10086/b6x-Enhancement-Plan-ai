package a;

import android.view.MenuItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c4 f5671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d4 f210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i4 f211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ MenuItem f212a;

    public b4(c4 c4Var, d4 d4Var, MenuItem menuItem, i4 i4Var) {
        this.f5671a = c4Var;
        this.f210a = d4Var;
        this.f212a = menuItem;
        this.f211a = i4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        d4 d4Var = this.f210a;
        if (d4Var != null) {
            this.f5671a.f5757a.f669g = true;
            d4Var.f476a.e(false);
            this.f5671a.f5757a.f669g = false;
        }
        if (this.f212a.isEnabled() && this.f212a.hasSubMenu()) {
            this.f211a.L(this.f212a, 4);
        }
    }
}
