package a;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dz1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ iz1 f633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f634a = new Rect();
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f635b;

    public dz1(iz1 iz1Var) {
        this.f633a = iz1Var;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view != null) {
                    view.getWindowVisibleDisplayFrame(this.f634a);
                }
                this.f5951a = motionEvent.getX();
                this.b = motionEvent.getY();
                motionEvent.getRawX();
                motionEvent.getRawY();
                this.f635b = true;
            } else if (action == 1) {
                this.f633a.f1478a.edit().putInt("thread_x", this.f633a.f1481a.x).putInt("thread_y", this.f633a.f1481a.y).apply();
            } else if (action != 2) {
                if (action == 3 || action == 4) {
                    this.f635b = false;
                }
            } else if (this.f635b) {
                this.f633a.f1481a.x = (int) ((motionEvent.getRawX() - this.f5951a) - this.f634a.left);
                this.f633a.f1481a.y = (int) ((motionEvent.getRawY() - this.b) - this.f634a.top);
                this.f633a.f1482a.updateViewLayout(view, this.f633a.f1481a);
            }
        }
        return false;
    }
}
