package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ou1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7056a;

    public ou1(kv1 kv1Var) {
        this.f7056a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cl clVarJ = this.f7056a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        new dp1(clVarJ).h();
    }
}
