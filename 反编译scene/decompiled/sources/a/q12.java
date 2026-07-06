package a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q12 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SharedPreferences f2530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f2531a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WindowManager.LayoutParams f2532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WindowManager f2533a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2534b;

    public q12(WindowManager.LayoutParams layoutParams, WindowManager windowManager, SharedPreferences sharedPreferences) {
        this.f2532a = layoutParams;
        this.f2533a = windowManager;
        this.f2530a = sharedPreferences;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!u12.f3110a && motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view != null) {
                    view.getWindowVisibleDisplayFrame(this.f2531a);
                }
                this.f7169a = motionEvent.getX();
                this.b = motionEvent.getY();
                motionEvent.getRawX();
                motionEvent.getRawY();
                this.f2534b = true;
            } else if (action == 1) {
                this.f2530a.edit().putInt("process_x", this.f2532a.x).putInt("process_y", this.f2532a.y).apply();
            } else if (action != 2) {
                if (action == 3 || action == 4) {
                    this.f2534b = false;
                }
            } else if (this.f2534b) {
                this.f2532a.x = (int) ((motionEvent.getRawX() - this.f7169a) - this.f2531a.left);
                this.f2532a.y = (int) ((motionEvent.getRawY() - this.b) - this.f2531a.top);
                this.f2533a.updateViewLayout(view, this.f2532a);
            }
        }
        return false;
    }
}
