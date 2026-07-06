package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j01 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f01 f1485a;

    public j01(f01 f01Var, int i) {
        this.f1485a = f01Var;
        this.f6459a = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        e01 e01Var = this.f1485a.b;
        if (e01Var != null) {
            f92.c(view, "it");
            e01Var.a(view, this.f6459a);
        }
        return this.f1485a.b != null;
    }
}
