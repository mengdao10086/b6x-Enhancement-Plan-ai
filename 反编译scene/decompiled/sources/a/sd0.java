package a;

import com.omarea.krscript.model.ActionNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionNode f2876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f2877a;

    public sd0(fe0 fe0Var, ActionNode actionNode, Runnable runnable) {
        this.f7385a = fe0Var;
        this.f2876a = actionNode;
        this.f2877a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7385a.I1(this.f2876a, this.f2877a);
    }
}
