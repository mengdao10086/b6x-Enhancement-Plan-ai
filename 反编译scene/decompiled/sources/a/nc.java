package a;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class nc {
    public static Handler c(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    public final void a(int i, Handler handler) {
        c(handler).post(new mc(this, i));
    }

    public final void b(Typeface typeface, Handler handler) {
        c(handler).post(new lc(this, typeface));
    }

    public abstract void d(int i);

    public abstract void e(Typeface typeface);
}
