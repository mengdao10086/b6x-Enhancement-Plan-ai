package a;

import android.app.Activity;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mk0 {
    public mk0() {
    }

    public /* synthetic */ mk0(b92 b92Var) {
        this();
    }

    public final void a(Activity activity) {
        f92.d(activity, "activity");
        if (sk0.f7408a.a().c()) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            f92.c(layoutInflater, "activity.layoutInflater");
            layoutInflater.setFactory2(new nk0(activity, sk0.f7408a.a()));
        }
    }
}
