package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;
import com.app.hubert.guide.model.HighLight;

/* JADX INFO: loaded from: classes2.dex */
public class d implements HighLight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f11428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HighLight.Shape f11429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f11432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f11433f;

    public d(View view, HighLight.Shape shape, int i10, int i11) {
        this.f11428a = view;
        this.f11429b = shape;
        this.f11430c = i10;
        this.f11431d = i11;
    }

    public final RectF a(View view) {
        RectF rectF = new RectF();
        int i10 = t3.c.a(view, this.f11428a).left;
        int i11 = this.f11431d;
        rectF.left = i10 - i11;
        rectF.top = r4.top - i11;
        rectF.right = r4.right + i11;
        rectF.bottom = r4.bottom + i11;
        return rectF;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public float b() {
        if (this.f11428a != null) {
            return Math.max(r0.getWidth() / 2, this.f11428a.getHeight() / 2) + this.f11431d;
        }
        throw new IllegalArgumentException("the highlight view is null!");
    }

    @Override // com.app.hubert.guide.model.HighLight
    public RectF c(View view) {
        if (this.f11428a == null) {
            throw new IllegalArgumentException("the highlight view is null!");
        }
        if (this.f11433f == null) {
            this.f11433f = a(view);
        } else {
            b bVar = this.f11432e;
            if (bVar != null && bVar.f11422d) {
                this.f11433f = a(view);
            }
        }
        t3.a.f(this.f11428a.getClass().getSimpleName() + "'s location:" + this.f11433f);
        return this.f11433f;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public b d() {
        return this.f11432e;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public HighLight.Shape e() {
        return this.f11429b;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public int f() {
        return this.f11430c;
    }

    public void g(b bVar) {
        this.f11432e = bVar;
    }
}
