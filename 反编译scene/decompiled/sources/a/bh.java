package a;

import android.view.View;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class bh {
    public static ki a(View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return ki.c(windowInsetsController);
        }
        return null;
    }
}
