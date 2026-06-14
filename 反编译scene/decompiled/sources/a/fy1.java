package a;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fy1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f950a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WindowManager.LayoutParams f951a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f952b;
    public float c;
    public float d;

    public fy1(WindowManager.LayoutParams layoutParams) {
        this.f951a = layoutParams;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view != null) {
                    view.getWindowVisibleDisplayFrame(this.f950a);
                }
                this.f6149a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.f952b = true;
            } else if (action == 1) {
                float f = 15;
                if (Math.abs(motionEvent.getRawX() - this.c) > f || Math.abs(motionEvent.getRawY() - this.d) > f) {
                    return true;
                }
            } else if (action != 2) {
                if (action == 3 || action == 4) {
                    this.f952b = false;
                }
            } else if (this.f952b) {
                WindowManager.LayoutParams layoutParams = this.f951a;
                layoutParams.gravity = 8388659;
                layoutParams.x = (int) ((motionEvent.getRawX() - this.f6149a) - this.f950a.left);
                this.f951a.y = (int) ((motionEvent.getRawY() - this.b) - this.f950a.top);
                WindowManager windowManager = py1.f2461a;
                if (windowManager != null) {
                    windowManager.updateViewLayout(view, this.f951a);
                }
            }
        }
        return false;
    }
}
