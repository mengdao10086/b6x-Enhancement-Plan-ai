package a;

import a.p80;
import android.content.Context;
import android.os.Bundle;
import com.omarea.krscript.model.RunnableNode;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bb0 {
    public bb0() {
    }

    public /* synthetic */ bb0(b92 b92Var) {
        this();
    }

    public final void a(Context context, String str, HashMap<String, String> map, RunnableNode runnableNode, Runnable runnable, Runnable runnable2) {
        f92.d(context, "context");
        f92.d(str, "script");
        f92.d(runnableNode, "nodeInfo");
        f92.d(runnable, "onExit");
        f92.d(runnable2, "onDismiss");
        Context applicationContext = context.getApplicationContext();
        eb0.f5986a++;
        f92.c(applicationContext, "applicationContext");
        new bd0().a(context, runnableNode, str, new ab0(runnable, runnable2), map, new db0(applicationContext, runnableNode, eb0.f5986a));
        Bundle bundle = new Bundle();
        if (map != null) {
            bundle.putSerializable("params", map);
        }
        p80.a aVar = p80.f2403a;
        String string = context.getString(ob0.kr_bg_task_start);
        f92.c(string, "context.getString(R.string.kr_bg_task_start)");
        String string2 = context.getString(ob0.kr_bg_task_start_desc);
        f92.c(string2, "context.getString(R.string.kr_bg_task_start_desc)");
        p80.a.B(aVar, context, string, string2, null, 8, null);
    }
}
