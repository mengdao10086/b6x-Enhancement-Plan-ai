package a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7144a = true;

    public static os a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new ns(viewGroup) : ms.g(viewGroup);
    }

    @SuppressLint({"NewApi"})
    public static void b(ViewGroup viewGroup, boolean z) {
        if (f7144a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f7144a = false;
            }
        }
    }

    public static void c(ViewGroup viewGroup, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            viewGroup.suppressLayout(z);
        } else if (i >= 18) {
            b(viewGroup, z);
        } else {
            rs.b(viewGroup, z);
        }
    }
}
