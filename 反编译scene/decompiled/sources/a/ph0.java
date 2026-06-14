package a;

import a.p80;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ph0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x90 f7118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2429a;

    public ph0(Context context, x90 x90Var) {
        f92.d(context, "context");
        f92.d(x90Var, "themeMode");
        this.f2429a = context;
        this.f7118a = x90Var;
    }

    public static /* synthetic */ void c(ph0 ph0Var, View view, String str, Runnable runnable, int i, Object obj) {
        if ((i & 4) != 0) {
            runnable = null;
        }
        ph0Var.b(view, str, runnable);
    }

    public final void b(View view, String str, Runnable runnable) {
        f92.d(view, "view");
        f92.d(str, "fileName");
        if (yb.a(this.f2429a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            Scene.c cVar = Scene.f4798a;
            String string = this.f2429a.getString(u61.kr_write_external_storage);
            f92.c(string, "context.getString(R.stri…r_write_external_storage)");
            Scene.c.p(cVar, string, 0, 2, null);
            return;
        }
        d41.f480a.i(true);
        p80.b bVarG = p80.a.G(p80.f2403a, this.f2429a, null, 2, null);
        view.setBackground(this.f7118a.a() ? new ColorDrawable(Color.rgb(30, 30, 30)) : new ColorDrawable(Color.rgb(240, 240, 240)));
        qc2.d(xd2.a(qe2.b()), null, null, new oh0(this, view, str, runnable, bVarG, null), 3, null);
    }
}
