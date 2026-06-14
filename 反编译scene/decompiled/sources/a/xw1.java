package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xw1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yw1 f7925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3626a;

    public xw1(yw1 yw1Var, View view, String str) {
        this.f7925a = yw1Var;
        this.f3625a = view;
        this.f3626a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cl clVarJ = this.f7925a.f8016a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        new sn1(clVarJ, new ww1(this)).d();
    }
}
