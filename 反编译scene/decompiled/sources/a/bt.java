package a;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class bt extends at {
    public static boolean f = true;

    @Override // a.et
    @SuppressLint({"NewApi"})
    public void e(View view, int i, int i2, int i3, int i4) {
        if (f) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
