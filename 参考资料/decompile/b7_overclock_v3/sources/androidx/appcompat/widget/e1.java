package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class e1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f2442k = "TooltipCompatHandler";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f2443l = 2500;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f2444m = 15000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f2445n = 3000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static e1 f2446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static e1 f2447p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f2448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f2449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f2451d = new Runnable() { // from class: androidx.appcompat.widget.d1
        @Override // java.lang.Runnable
        public final void run() {
            this.f2413a.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f2452e = new Runnable() { // from class: androidx.appcompat.widget.c1
        @Override // java.lang.Runnable
        public final void run() {
            this.f2399a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f1 f2455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2457j;

    public e1(View view, CharSequence charSequence) {
        this.f2448a = view;
        this.f2449b = charSequence;
        this.f2450c = androidx.core.view.w0.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    public static void g(e1 e1Var) {
        e1 e1Var2 = f2446o;
        if (e1Var2 != null) {
            e1Var2.b();
        }
        f2446o = e1Var;
        if (e1Var != null) {
            e1Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        e1 e1Var = f2446o;
        if (e1Var != null && e1Var.f2448a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new e1(view, charSequence);
            return;
        }
        e1 e1Var2 = f2447p;
        if (e1Var2 != null && e1Var2.f2448a == view) {
            e1Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f2448a.removeCallbacks(this.f2451d);
    }

    public final void c() {
        this.f2457j = true;
    }

    public void d() {
        if (f2447p == this) {
            f2447p = null;
            f1 f1Var = this.f2455h;
            if (f1Var != null) {
                f1Var.c();
                this.f2455h = null;
                c();
                this.f2448a.removeOnAttachStateChangeListener(this);
            }
        }
        if (f2446o == this) {
            g(null);
        }
        this.f2448a.removeCallbacks(this.f2452e);
    }

    public final void f() {
        this.f2448a.postDelayed(this.f2451d, ViewConfiguration.getLongPressTimeout());
    }

    public void i(boolean z10) {
        long j10;
        int longPressTimeout;
        long j11;
        if (androidx.core.view.u0.O0(this.f2448a)) {
            g(null);
            e1 e1Var = f2447p;
            if (e1Var != null) {
                e1Var.d();
            }
            f2447p = this;
            this.f2456i = z10;
            f1 f1Var = new f1(this.f2448a.getContext());
            this.f2455h = f1Var;
            f1Var.e(this.f2448a, this.f2453f, this.f2454g, this.f2456i, this.f2449b);
            this.f2448a.addOnAttachStateChangeListener(this);
            if (this.f2456i) {
                j11 = f2443l;
            } else {
                if ((androidx.core.view.u0.C0(this.f2448a) & 1) == 1) {
                    j10 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j10 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j11 = j10 - ((long) longPressTimeout);
            }
            this.f2448a.removeCallbacks(this.f2452e);
            this.f2448a.postDelayed(this.f2452e, j11);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f2457j && Math.abs(x10 - this.f2453f) <= this.f2450c && Math.abs(y10 - this.f2454g) <= this.f2450c) {
            return false;
        }
        this.f2453f = x10;
        this.f2454g = y10;
        this.f2457j = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2455h != null && this.f2456i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2448a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f2448a.isEnabled() && this.f2455h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f2453f = view.getWidth() / 2;
        this.f2454g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
