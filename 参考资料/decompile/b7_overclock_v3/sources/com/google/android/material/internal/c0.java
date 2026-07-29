package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c0 extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20411a;

    public c0(Context context) {
        this(context, null);
    }

    public final void a(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f20411a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f20411a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        a(i10, true);
    }

    public c0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20411a = getVisibility();
    }
}
