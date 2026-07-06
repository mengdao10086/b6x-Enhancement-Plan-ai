package a;

import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h5 extends ActionMenuItemView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f6275a;

    public h5(n5 n5Var) {
        this.f6275a = n5Var;
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
    public y4 a() {
        g5 g5Var = this.f6275a.f6875a;
        if (g5Var != null) {
            return g5Var.c();
        }
        return null;
    }
}
