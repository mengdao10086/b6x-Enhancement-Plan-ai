package a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ct extends bt {
    public static boolean g = true;

    @Override // a.et
    @SuppressLint({"NewApi"})
    public void g(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i);
        } else if (g) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
