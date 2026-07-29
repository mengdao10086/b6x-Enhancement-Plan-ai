package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements me.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f20751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f20752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20753c;

    public SnackbarContentLayout(@n0 Context context) {
        this(context, null);
    }

    public static void d(@n0 View view, int i10, int i11) {
        if (u0.Y0(view)) {
            u0.d2(view, u0.k0(view), i10, u0.j0(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    @Override // me.a
    public void a(int i10, int i11) {
        this.f20751a.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.f20751a.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.f20752b.getVisibility() == 0) {
            this.f20752b.setAlpha(0.0f);
            this.f20752b.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    @Override // me.a
    public void b(int i10, int i11) {
        this.f20751a.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.f20751a.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.f20752b.getVisibility() == 0) {
            this.f20752b.setAlpha(1.0f);
            this.f20752b.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    public void c(float f10) {
        if (f10 != 1.0f) {
            this.f20752b.setTextColor(m.n(m.d(this, R.attr.colorSurface), this.f20752b.getCurrentTextColor(), f10));
        }
    }

    public final boolean e(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f20751a.getPaddingTop() == i11 && this.f20751a.getPaddingBottom() == i12) {
            return z10;
        }
        d(this.f20751a, i11, i12);
        return true;
    }

    public Button getActionView() {
        return this.f20752b;
    }

    public TextView getMessageView() {
        return this.f20751a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f20751a = (TextView) findViewById(R.id.snackbar_text);
        this.f20752b = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto Lb
            return
        Lb:
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            int r3 = com.google.android.material.R.dimen.design_snackbar_padding_vertical
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f20751a
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L30
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L30
            r3 = 1
            goto L31
        L30:
            r3 = 0
        L31:
            if (r3 == 0) goto L4a
            int r5 = r7.f20753c
            if (r5 <= 0) goto L4a
            android.widget.Button r5 = r7.f20752b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f20753c
            if (r5 <= r6) goto L4a
            int r2 = r0 - r2
            boolean r0 = r7.e(r1, r0, r2)
            if (r0 == 0) goto L55
            goto L56
        L4a:
            if (r3 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r2
        L4e:
            boolean r0 = r7.e(r4, r0, r0)
            if (r0 == 0) goto L55
            goto L56
        L55:
            r1 = 0
        L56:
            if (r1 == 0) goto L5b
            super.onMeasure(r8, r9)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f20753c = i10;
    }

    public SnackbarContentLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
