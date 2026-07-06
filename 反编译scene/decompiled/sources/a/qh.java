package a;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class qh {
    public static ki a(Window window, View view) {
        return Build.VERSION.SDK_INT >= 30 ? ph.a(window) : new ki(window, view);
    }
}
