package a;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class zg {
    public static sh a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        sh shVarS = sh.s(rootWindowInsets);
        shVarS.p(shVarS);
        shVarS.d(view.getRootView());
        return shVarS;
    }
}
