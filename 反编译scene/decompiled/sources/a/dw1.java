package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dw1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f5943a;

    public dw1(bx1 bx1Var) {
        this.f5943a = bx1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cl clVarJ = this.f5943a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        new vk1(clVarJ).b();
    }
}
