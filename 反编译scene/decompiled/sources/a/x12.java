package a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x12 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d22 f3508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SharedPreferences f3509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f3510a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WindowManager.LayoutParams f3511a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3512b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3513b;
    public float c;
    public float d;

    public x12(d22 d22Var, WindowManager.LayoutParams layoutParams, SharedPreferences sharedPreferences) {
        this.f3508a = d22Var;
        this.f3511a = layoutParams;
        this.f3509a = sharedPreferences;
    }

    public final void a() {
        try {
            if (System.currentTimeMillis() - this.f3512b < 300) {
                this.f3508a.f();
            } else {
                this.f3512b = System.currentTimeMillis();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view != null) {
                    view.getWindowVisibleDisplayFrame(this.f3510a);
                }
                this.f7845a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.f3513b = true;
                this.f3507a = System.currentTimeMillis();
            } else if (action == 1) {
                if (System.currentTimeMillis() - this.f3507a < 180) {
                    float f = 15;
                    if (Math.abs(motionEvent.getRawX() - this.c) >= f || Math.abs(motionEvent.getRawY() - this.d) >= f) {
                        this.f3509a.edit().putInt("temperature_x", this.f3511a.x).putInt("temperature_y", this.f3511a.y).apply();
                    } else {
                        a();
                    }
                }
                this.f3513b = false;
                float f2 = 15;
                if (Math.abs(motionEvent.getRawX() - this.c) > f2 || Math.abs(motionEvent.getRawY() - this.d) > f2) {
                    return true;
                }
            } else if (action != 2) {
                if (action == 3 || action == 4) {
                    this.f3513b = false;
                }
            } else if (this.f3513b) {
                this.f3511a.x = (int) ((motionEvent.getRawX() - this.f7845a) - this.f3510a.left);
                this.f3511a.y = (int) ((motionEvent.getRawY() - this.b) - this.f3510a.top);
                WindowManager windowManager = d22.f457a;
                f92.b(windowManager);
                windowManager.updateViewLayout(view, this.f3511a);
            }
        }
        return false;
    }
}
