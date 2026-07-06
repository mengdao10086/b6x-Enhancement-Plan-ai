package a;

import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ph {
    public static ki a(Window window) {
        WindowInsetsController insetsController = window.getInsetsController();
        if (insetsController != null) {
            return ki.c(insetsController);
        }
        return null;
    }
}
