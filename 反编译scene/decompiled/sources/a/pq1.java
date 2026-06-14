package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pq1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wq1 f7140a;

    public pq1(wq1 wq1Var) {
        this.f7140a = wq1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        wq1 wq1Var = this.f7140a;
        cl clVarJ = wq1Var.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        wq1Var.H1(clVarJ);
    }
}
