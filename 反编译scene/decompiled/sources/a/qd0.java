package a;

import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.RunnableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RunnableNode f2567a;

    public qd0(fe0 fe0Var, RunnableNode runnableNode) {
        this.f7200a = fe0Var;
        this.f2567a = runnableNode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7200a.t = false;
        fe0.B1(this.f7200a).c();
        KrScriptActionHandler krScriptActionHandler = this.f7200a.f890a;
        if (krScriptActionHandler != null) {
            krScriptActionHandler.onActionCompleted(this.f2567a);
        }
    }
}
