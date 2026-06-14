package a;

import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ od0 f6303a;

    public hd0(od0 od0Var) {
        this.f6303a = od0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarB1 = fe0.B1(this.f6303a.f7008a);
        Context contextP = this.f6303a.f7008a.p();
        f92.b(contextP);
        String string = contextP.getString(ob0.kr_params_render);
        f92.c(string, "this.context!!.getString….string.kr_params_render)");
        u90VarB1.d(string);
    }
}
