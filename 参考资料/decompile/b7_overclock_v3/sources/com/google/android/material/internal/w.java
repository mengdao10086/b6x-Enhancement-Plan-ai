package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public class w implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f20498a;

    public w(@n0 ViewGroup viewGroup) {
        this.f20498a = viewGroup.getOverlay();
    }

    @Override // com.google.android.material.internal.a0
    public void a(@n0 Drawable drawable) {
        this.f20498a.add(drawable);
    }

    @Override // com.google.android.material.internal.a0
    public void b(@n0 Drawable drawable) {
        this.f20498a.remove(drawable);
    }

    @Override // com.google.android.material.internal.x
    public void c(@n0 View view) {
        this.f20498a.add(view);
    }

    @Override // com.google.android.material.internal.x
    public void d(@n0 View view) {
        this.f20498a.remove(view);
    }
}
