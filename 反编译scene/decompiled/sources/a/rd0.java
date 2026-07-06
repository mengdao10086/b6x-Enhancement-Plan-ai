package a;

import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.RunnableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RunnableNode f2730a;

    public rd0(fe0 fe0Var, RunnableNode runnableNode) {
        this.f7289a = fe0Var;
        this.f2730a = runnableNode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KrScriptActionHandler krScriptActionHandler = this.f7289a.f890a;
        if (krScriptActionHandler != null) {
            krScriptActionHandler.onActionCompleted(this.f2730a);
        }
    }
}
