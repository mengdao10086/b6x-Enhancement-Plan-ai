package a;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class jz {
    public static cz a(int i) {
        return i != 0 ? i != 1 ? b() : new dz() : new lz();
    }

    public static cz b() {
        return new lz();
    }

    public static ez c() {
        return new ez();
    }

    public static void d(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof iz) {
            ((iz) background).T(f);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof iz) {
            f(view, (iz) background);
        }
    }

    public static void f(View view, iz izVar) {
        if (izVar.M()) {
            izVar.X(gy.c(view));
        }
    }
}
