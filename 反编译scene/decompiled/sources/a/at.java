package a;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class at extends zs {
    public static boolean d = true;
    public static boolean e = true;

    @Override // a.et
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                d = false;
            }
        }
    }

    @Override // a.et
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }
}
