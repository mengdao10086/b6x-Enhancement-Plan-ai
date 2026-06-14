package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class is1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f6439a;

    public is1(zs1 zs1Var) {
        this.f6439a = zs1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        nl1 nl1Var = new nl1();
        Context contextP = this.f6439a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        nl1Var.d(contextP);
    }
}
