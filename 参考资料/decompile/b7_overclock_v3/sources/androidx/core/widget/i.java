package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import g.h1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends ProgressBar {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5245g = 500;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5246h = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f5251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f5252f;

    public i(@n0 Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f5248b = false;
        this.f5247a = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f5249c = false;
        if (this.f5250d) {
            return;
        }
        this.f5247a = System.currentTimeMillis();
        setVisibility(0);
    }

    public void e() {
        post(new Runnable() { // from class: androidx.core.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f5242a.f();
            }
        });
    }

    @h1
    public final void f() {
        this.f5250d = true;
        removeCallbacks(this.f5252f);
        this.f5249c = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.f5247a;
        long j11 = jCurrentTimeMillis - j10;
        if (j11 >= 500 || j10 == -1) {
            setVisibility(8);
        } else {
            if (this.f5248b) {
                return;
            }
            postDelayed(this.f5251e, 500 - j11);
            this.f5248b = true;
        }
    }

    public final void i() {
        removeCallbacks(this.f5251e);
        removeCallbacks(this.f5252f);
    }

    public void j() {
        post(new Runnable() { // from class: androidx.core.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f5244a.k();
            }
        });
    }

    @h1
    public final void k() {
        this.f5247a = -1L;
        this.f5250d = false;
        removeCallbacks(this.f5251e);
        this.f5248b = false;
        if (this.f5249c) {
            return;
        }
        postDelayed(this.f5252f, 500L);
        this.f5249c = true;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public i(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f5247a = -1L;
        this.f5248b = false;
        this.f5249c = false;
        this.f5250d = false;
        this.f5251e = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f5241a.g();
            }
        };
        this.f5252f = new Runnable() { // from class: androidx.core.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f5243a.h();
            }
        };
    }
}
