package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;
import com.app.hubert.guide.model.HighLight;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class c implements HighLight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HighLight.Shape f11425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f11427d;

    public c(@n0 RectF rectF, @n0 HighLight.Shape shape, int i10) {
        this.f11424a = rectF;
        this.f11425b = shape;
        this.f11426c = i10;
    }

    public void a(b bVar) {
        this.f11427d = bVar;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public float b() {
        return Math.min(this.f11424a.width() / 2.0f, this.f11424a.height() / 2.0f);
    }

    @Override // com.app.hubert.guide.model.HighLight
    public RectF c(View view) {
        return this.f11424a;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public b d() {
        return this.f11427d;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public HighLight.Shape e() {
        return this.f11425b;
    }

    @Override // com.app.hubert.guide.model.HighLight
    public int f() {
        return this.f11426c;
    }
}
