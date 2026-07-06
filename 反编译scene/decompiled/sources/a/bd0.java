package a;

import android.content.Context;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class bd0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f261a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5695a = "pio_" + System.currentTimeMillis();

    public void a(Context context, RunnableNode runnableNode, String str, Runnable runnable, HashMap<String, String> map, ShellHandlerBase shellHandlerBase) {
        if (this.f261a) {
            return;
        }
        this.f261a = yc0.e(context, new ad0(context, shellHandlerBase, runnable, runnableNode.getInterruptable() || runnableNode.getShell().equals(RunnableNode.Companion.getShellModeBgTask())), str, map, runnableNode, this.f5695a);
    }
}
