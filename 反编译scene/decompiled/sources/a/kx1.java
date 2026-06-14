package a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kx1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SharedPreferences f1695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f1696a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WindowManager.LayoutParams f1697a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1698b;
    public float c;
    public float d;

    public kx1(WindowManager.LayoutParams layoutParams, SharedPreferences sharedPreferences) {
        this.f1697a = layoutParams;
        this.f1695a = sharedPreferences;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view != null) {
                    view.getWindowVisibleDisplayFrame(this.f1696a);
                }
                this.f6652a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.f1698b = true;
            } else if (action == 1) {
                this.f1698b = false;
                float f = 15;
                if (Math.abs(motionEvent.getRawX() - this.c) > f || Math.abs(motionEvent.getRawY() - this.d) > f) {
                    this.f1695a.edit().putInt("basic_x", this.f1697a.x).putInt("basic_y", this.f1697a.y).apply();
                    return true;
                }
            } else if (action != 2) {
                if (action == 3 || action == 4) {
                    this.f1698b = false;
                }
            } else if (this.f1698b) {
                this.f1697a.x = (int) ((motionEvent.getRawX() - this.f6652a) - this.f1696a.left);
                this.f1697a.y = (int) ((motionEvent.getRawY() - this.b) - this.f1696a.top);
                WindowManager windowManager = ox1.f2311a;
                f92.b(windowManager);
                windowManager.updateViewLayout(view, this.f1697a);
            }
        }
        return false;
    }
}
