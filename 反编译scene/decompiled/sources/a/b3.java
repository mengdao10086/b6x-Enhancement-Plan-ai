package a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b3 implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable.Callback f5669a;

    public Drawable.Callback a() {
        Drawable.Callback callback = this.f5669a;
        this.f5669a = null;
        return callback;
    }

    public b3 b(Drawable.Callback callback) {
        this.f5669a = callback;
        return this;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = this.f5669a;
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = this.f5669a;
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
