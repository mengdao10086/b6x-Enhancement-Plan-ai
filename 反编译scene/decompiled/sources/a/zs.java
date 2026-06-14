package a;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zs extends et {
    public static boolean c = true;

    @Override // a.et
    public void a(View view) {
    }

    @Override // a.et
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // a.et
    public void d(View view) {
    }

    @Override // a.et
    @SuppressLint({"NewApi"})
    public void f(View view, float f) {
        if (c) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
        view.setAlpha(f);
    }
}
