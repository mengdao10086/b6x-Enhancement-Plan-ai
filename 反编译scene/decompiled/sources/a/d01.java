package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d01 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f453a;

    public d01(zz0 zz0Var, int i) {
        this.f453a = zz0Var;
        this.f5844a = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        yz0 yz0Var = this.f453a.b;
        if (yz0Var != null) {
            f92.c(view, "it");
            yz0Var.a(view, this.f5844a);
        }
        return this.f453a.b != null;
    }
}
