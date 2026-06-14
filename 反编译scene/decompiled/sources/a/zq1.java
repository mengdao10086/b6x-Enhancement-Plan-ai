package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zq1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gr1 f8090a;

    public zq1(gr1 gr1Var) {
        this.f8090a = gr1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        gr1 gr1Var = this.f8090a;
        cl clVarJ = gr1Var.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        gr1Var.H1(clVarJ);
    }
}
