package a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kp extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ np f6627a;
    public boolean b = true;

    public kp(np npVar) {
        this.f6627a = npVar;
    }

    public void a() {
        this.b = false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View viewS;
        RecyclerView.d0 d0VarF0;
        if (!this.b || (viewS = this.f6627a.s(motionEvent)) == null || (d0VarF0 = this.f6627a.f2141a.f0(viewS)) == null) {
            return;
        }
        np npVar = this.f6627a;
        if (npVar.f2133a.o(npVar.f2141a, d0VarF0)) {
            int pointerId = motionEvent.getPointerId(0);
            int i = this.f6627a.f2130a;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                np npVar2 = this.f6627a;
                npVar2.f6939a = x;
                npVar2.b = y;
                npVar2.f = 0.0f;
                npVar2.e = 0.0f;
                if (npVar2.f2133a.r()) {
                    this.f6627a.E(d0VarF0, 2);
                }
            }
        }
    }
}
