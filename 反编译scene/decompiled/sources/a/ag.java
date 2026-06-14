package a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wf f5603a;

    public ag(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public ag(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f5603a = Build.VERSION.SDK_INT > 17 ? new zf(context, onGestureListener, handler) : new yf(context, onGestureListener, handler);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f5603a.a(motionEvent);
    }
}
