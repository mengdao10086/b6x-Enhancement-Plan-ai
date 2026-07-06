package a;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zf implements wf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f8066a;

    public zf(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f8066a = new GestureDetector(context, onGestureListener, handler);
    }

    @Override // a.wf
    public boolean a(MotionEvent motionEvent) {
        return this.f8066a.onTouchEvent(motionEvent);
    }
}
