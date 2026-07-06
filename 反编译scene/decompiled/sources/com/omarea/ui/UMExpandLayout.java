package com.omarea.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class UMExpandLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4892a;
    public boolean b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UMExpandLayout.this.f8406a <= 0) {
                UMExpandLayout uMExpandLayout = UMExpandLayout.this;
                uMExpandLayout.f8406a = uMExpandLayout.f4892a.getMeasuredHeight();
            }
        }
    }

    public UMExpandLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UMExpandLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void d() {
        this.b = false;
        j();
    }

    public void e() {
        this.b = true;
        j();
    }

    public void f(boolean z) {
        this.b = z;
        if (z) {
            return;
        }
        j();
    }

    public final void g() {
        this.f4892a = this;
        this.b = true;
        i();
    }

    public boolean h() {
        return this.b;
    }

    public final void i() {
        this.f4892a.post(new a());
    }

    public final void j() {
        this.f4892a.getLayoutParams().height = this.b ? -2 : 0;
        this.f4892a.requestLayout();
    }

    public void k() {
        if (this.b) {
            d();
        } else {
            e();
        }
    }
}
