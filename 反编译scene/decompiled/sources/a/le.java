package a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class le {
    public static Typeface a(Context context, be beVar, int i, boolean z, int i2, Handler handler, ke keVar) {
        xd xdVar = new xd(keVar, handler);
        return z ? he.e(context, beVar, xdVar, i, i2) : he.d(context, beVar, i, null, xdVar);
    }
}
