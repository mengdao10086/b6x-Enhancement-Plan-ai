package a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zo0 {
    public static /* synthetic */ void d(zo0 zo0Var, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 6;
        }
        zo0Var.c(context, i);
    }

    public final void c(Context context, int i) {
        f92.d(context, "context");
        new Thread(new xo0(this, i, context, new Handler(Looper.getMainLooper()))).start();
    }

    public final int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final void f(Context context, g30 g30Var) {
        p80.f2403a.i(context, (16 & 2) != 0 ? "" : "下载新版本" + g30Var.i("versionName") + " ？", (16 & 4) != 0 ? "" : "更新内容：\n\n" + g30Var.i("message"), (16 & 8) != 0 ? null : new yo0(g30Var, context), (16 & 16) != 0 ? null : null).i(false);
    }
}
