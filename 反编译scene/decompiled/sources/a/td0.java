package a;

import com.omarea.krscript.model.ActionNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class td0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionNode f3012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3013a;

    public td0(fe0 fe0Var, ActionNode actionNode, Runnable runnable) {
        this.f7489a = fe0Var;
        this.f3012a = actionNode;
        this.f3013a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7489a.I1(this.f3012a, this.f3013a);
    }
}
