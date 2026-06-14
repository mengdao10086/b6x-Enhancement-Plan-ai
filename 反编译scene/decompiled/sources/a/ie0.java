package a;

import com.omarea.krscript.model.RunnableNode;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ie0 {
    public ie0() {
    }

    public /* synthetic */ ie0(b92 b92Var) {
        this();
    }

    public final se0 a(RunnableNode runnableNode, Runnable runnable, Runnable runnable2, String str, HashMap<String, String> map, boolean z) {
        f92.d(runnableNode, "nodeInfo");
        f92.d(runnable, "onExit");
        f92.d(runnable2, "onDismiss");
        f92.d(str, "script");
        se0 se0Var = new se0();
        se0Var.f2882a = runnableNode;
        se0Var.b = runnable;
        se0Var.d = str;
        se0Var.f2883a = map;
        se0Var.i = z ? pb0.kr_full_screen_dialog_dark : pb0.kr_full_screen_dialog_light;
        se0Var.f2885c = runnable2;
        return se0Var;
    }
}
