package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public class z implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f20506a;

    public z(@n0 View view) {
        this.f20506a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.a0
    public void a(@n0 Drawable drawable) {
        this.f20506a.add(drawable);
    }

    @Override // com.google.android.material.internal.a0
    public void b(@n0 Drawable drawable) {
        this.f20506a.remove(drawable);
    }
}
