package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f01 f1300a;

    public i01(f01 f01Var, int i) {
        this.f1300a = f01Var;
        this.f6362a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e01 e01Var = this.f1300a.f6058a;
        if (e01Var != null) {
            f92.c(view, "it");
            e01Var.a(view, this.f6362a);
        }
    }
}
