package a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w8 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w8 f7764a;
    public static w8 b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x8 f3405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f3406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f3407a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f3409b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3411b;
    public int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f3408a = new u8(this);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f3410b = new v8(this);

    public w8(View view, CharSequence charSequence) {
        this.f3406a = view;
        this.f3407a = charSequence;
        this.f3404a = fh.c(ViewConfiguration.get(view.getContext()));
        b();
        this.f3406a.setOnLongClickListener(this);
        this.f3406a.setOnHoverListener(this);
    }

    public static void e(w8 w8Var) {
        w8 w8Var2 = f7764a;
        if (w8Var2 != null) {
            w8Var2.a();
        }
        f7764a = w8Var;
        if (w8Var != null) {
            w8Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        w8 w8Var = f7764a;
        if (w8Var != null && w8Var.f3406a == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new w8(view, charSequence);
            return;
        }
        w8 w8Var2 = b;
        if (w8Var2 != null && w8Var2.f3406a == view) {
            w8Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void a() {
        this.f3406a.removeCallbacks(this.f3408a);
    }

    public final void b() {
        this.f3409b = Integer.MAX_VALUE;
        this.c = Integer.MAX_VALUE;
    }

    public void c() {
        if (b == this) {
            b = null;
            x8 x8Var = this.f3405a;
            if (x8Var != null) {
                x8Var.c();
                this.f3405a = null;
                b();
                this.f3406a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f7764a == this) {
            e(null);
        }
        this.f3406a.removeCallbacks(this.f3410b);
    }

    public final void d() {
        this.f3406a.postDelayed(this.f3408a, ViewConfiguration.getLongPressTimeout());
    }

    public void g(boolean z) {
        long longPressTimeout;
        if (eh.P(this.f3406a)) {
            e(null);
            w8 w8Var = b;
            if (w8Var != null) {
                w8Var.c();
            }
            b = this;
            this.f3411b = z;
            x8 x8Var = new x8(this.f3406a.getContext());
            this.f3405a = x8Var;
            x8Var.e(this.f3406a, this.f3409b, this.c, this.f3411b, this.f3407a);
            this.f3406a.addOnAttachStateChangeListener(this);
            if (this.f3411b) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((eh.J(this.f3406a) & 1) == 1 ? 3000L : 15000L) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f3406a.removeCallbacks(this.f3410b);
            this.f3406a.postDelayed(this.f3410b, longPressTimeout);
        }
    }

    public final boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f3409b) <= this.f3404a && Math.abs(y - this.c) <= this.f3404a) {
            return false;
        }
        this.f3409b = x;
        this.c = y;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f3405a != null && this.f3411b) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f3406a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f3406a.isEnabled() && this.f3405a == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f3409b = view.getWidth() / 2;
        this.c = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
