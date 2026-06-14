package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pe0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ se0 f2423a;

    public pe0(se0 se0Var, n92 n92Var) {
        this.f2423a = se0Var;
        this.f7110a = n92Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Runnable runnable;
        if (this.f2423a.y && (runnable = (Runnable) this.f7110a.f6891a) != null) {
            runnable.run();
        }
        this.f2423a.O1();
    }
}
