package com.google.android.material.timepicker;

import a1.d;
import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class a extends androidx.core.view.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d.a f21120d;

    public a(Context context, int i10) {
        this.f21120d = new d.a(16, context.getString(i10));
    }

    @Override // androidx.core.view.a
    public void g(View view, a1.d dVar) {
        super.g(view, dVar);
        dVar.b(this.f21120d);
    }
}
