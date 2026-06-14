package a;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class fb {
    public static IBinder a(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : eb.a(bundle, str);
    }
}
