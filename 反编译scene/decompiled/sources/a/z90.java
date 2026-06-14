package a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z90 f8048a = new z90();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ArrayList<ha0> f3818a = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(z90 z90Var, aa0 aa0Var, HashMap map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        z90Var.a(aa0Var, map);
    }

    public final void a(aa0 aa0Var, HashMap<String, Object> map) {
        if (f3818a.size() > 0) {
            for (ha0 ha0Var : new ArrayList(f3818a)) {
                try {
                    f92.b(aa0Var);
                    if (ha0Var.eventFilter(aa0Var)) {
                        if (ha0Var.isAsync()) {
                            f92.c(ha0Var, "eventReceiver");
                            new y90(ha0Var, aa0Var, map).start();
                        } else {
                            ha0Var.onReceive(aa0Var, map);
                        }
                    }
                } catch (Exception e) {
                    Log.e("SceneEventBus", "" + e.getMessage());
                }
            }
        }
    }

    public final void c(ha0 ha0Var) {
        f92.d(ha0Var, "eventReceiver");
        if (f3818a.contains(ha0Var)) {
            return;
        }
        f3818a.add(ha0Var);
        ha0Var.onSubscribe();
    }

    public final void d(ha0 ha0Var) {
        f92.d(ha0Var, "eventReceiver");
        if (f3818a.contains(ha0Var)) {
            f3818a.remove(ha0Var);
            ha0Var.onUnsubscribe();
        }
    }
}
