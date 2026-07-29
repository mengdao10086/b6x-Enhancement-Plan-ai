package com.flydigi.base.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends FrameLayout implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f13343b;

    public i(@n0 Context context) {
        this(context, null);
    }

    @Override // com.flydigi.base.common.z
    public void a() {
    }

    @Override // com.flydigi.base.common.z
    public void b() {
    }

    @Override // com.flydigi.base.common.z
    public void c() {
    }

    @Override // com.flydigi.base.common.z
    public void d() {
    }

    public final void e(Context context, @p0 AttributeSet attributeSet) {
        this.f13342a = context;
        this.f13343b = LayoutInflater.from(context);
        try {
            if (getLayoutId() != -1) {
                this.f13343b.inflate(getLayoutId(), (ViewGroup) this, true);
                f(attributeSet);
            }
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
    }

    public abstract void f(AttributeSet attributeSet);

    public void g() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    public abstract int getLayoutId();

    public void h() {
        tt.c.f().A(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public i(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        e(context, attributeSet);
    }

    @v0(api = 21)
    public i(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        e(context, attributeSet);
    }
}
