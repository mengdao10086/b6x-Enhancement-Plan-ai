package a;

import android.content.Context;
import com.omarea.vtools.AccessibilitySceneMode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zg0 {
    public final boolean a(Context context) {
        f92.d(context, "context");
        return new ah0().a(context, "AccessibilitySceneMode");
    }

    public final void b(Context context) {
        f92.d(context, "context");
        new zk0().a(context.getPackageName() + '/' + AccessibilitySceneMode.class.getName());
        new ah0().b(context, "AccessibilitySceneMode");
    }

    public final void c(Context context, Runnable runnable) {
        f92.d(context, "context");
        f92.d(runnable, "next");
        qc2.d(xd2.a(qe2.b()), null, null, new yg0(this, context, runnable, null), 3, null);
    }
}
