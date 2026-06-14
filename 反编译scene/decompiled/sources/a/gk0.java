package a;

import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class gk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6215a;
    public String b;
    public String c;

    public static void a(ViewGroup viewGroup, ck0 ck0Var) {
        if (viewGroup == null || ck0Var == null) {
            return;
        }
        fk0 fk0Var = new fk0(viewGroup, ck0Var);
        viewGroup.removeAllViews();
        viewGroup.addView(fk0Var);
    }
}
