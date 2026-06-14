package a;

import com.omarea.krscript.model.KrScriptActionHandler;
import com.omarea.krscript.model.RunnableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RunnableNode f2420a;

    public pd0(fe0 fe0Var, RunnableNode runnableNode) {
        this.f7106a = fe0Var;
        this.f2420a = runnableNode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KrScriptActionHandler krScriptActionHandler = this.f7106a.f890a;
        if (krScriptActionHandler != null) {
            krScriptActionHandler.onActionCompleted(this.f2420a);
        }
    }
}
