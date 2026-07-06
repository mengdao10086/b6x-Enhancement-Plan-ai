package a;

import android.content.Context;
import android.os.Bundle;
import com.omarea.krscript.model.RunnableNode;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hb0 {
    public hb0() {
    }

    public /* synthetic */ hb0(b92 b92Var) {
        this();
    }

    public final void a(Context context, String str, HashMap<String, String> map, RunnableNode runnableNode, Runnable runnable, Runnable runnable2) {
        f92.d(context, "context");
        f92.d(str, "script");
        f92.d(runnableNode, "nodeInfo");
        f92.d(runnable, "onExit");
        f92.d(runnable2, "onDismiss");
        Context applicationContext = context.getApplicationContext();
        jb0.f6494a++;
        f92.c(applicationContext, "applicationContext");
        new bd0().a(context, runnableNode, str, new gb0(runnable, runnable2), map, new ib0(applicationContext));
        Bundle bundle = new Bundle();
        if (map != null) {
            bundle.putSerializable("params", map);
        }
    }
}
