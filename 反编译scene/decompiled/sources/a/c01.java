package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f315a;

    public c01(zz0 zz0Var, int i) {
        this.f315a = zz0Var;
        this.f5746a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        yz0 yz0Var = this.f315a.f3912a;
        if (yz0Var != null) {
            f92.c(view, "it");
            yz0Var.a(view, this.f5746a);
        }
    }
}
