package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kr1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rr1 f6634a;

    public kr1(rr1 rr1Var) {
        this.f6634a = rr1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        rr1 rr1Var = this.f6634a;
        cl clVarJ = rr1Var.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        rr1Var.I1(clVarJ);
    }
}
