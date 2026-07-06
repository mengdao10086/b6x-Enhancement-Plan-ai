package a;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7115a;

    public pg(Object obj) {
        this.f7115a = obj;
    }

    public static pg b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new pg(PointerIcon.getSystemIcon(context, i)) : new pg(null);
    }

    public Object a() {
        return this.f7115a;
    }
}
