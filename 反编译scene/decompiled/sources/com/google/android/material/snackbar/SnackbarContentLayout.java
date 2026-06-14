package com.google.android.material.snackbar;

import a.dv;
import a.eh;
import a.iw;
import a.jv;
import a.x00;
import a.zu;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class SnackbarContentLayout extends LinearLayout implements x00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Button f4675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f4676a;
    public int b;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.SnackbarLayout);
        this.f8320a = typedArrayObtainStyledAttributes.getDimensionPixelSize(jv.SnackbarLayout_android_maxWidth, -1);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(jv.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void d(View view, int i, int i2) {
        if (eh.S(view)) {
            eh.w0(view, eh.D(view), i, eh.C(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    @Override // a.x00
    public void a(int i, int i2) {
        this.f4676a.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.f4676a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f4675a.getVisibility() == 0) {
            this.f4675a.setAlpha(1.0f);
            this.f4675a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // a.x00
    public void b(int i, int i2) {
        this.f4676a.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.f4676a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f4675a.getVisibility() == 0) {
            this.f4675a.setAlpha(0.0f);
            this.f4675a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public void c(float f) {
        if (f != 1.0f) {
            this.f4675a.setTextColor(iw.f(iw.c(this, zu.colorSurface), this.f4675a.getCurrentTextColor(), f));
        }
    }

    public final boolean e(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f4676a.getPaddingTop() == i2 && this.f4676a.getPaddingBottom() == i3) {
            return z;
        }
        d(this.f4676a, i2, i3);
        return true;
    }

    public Button getActionView() {
        return this.f4675a;
    }

    public TextView getMessageView() {
        return this.f4676a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f4676a = (TextView) findViewById(dv.snackbar_text);
        this.f4675a = (Button) findViewById(dv.snackbar_action);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f8320a
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f8320a
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = a.bv.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = a.bv.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f4676a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = r4
            goto L3d
        L3c:
            r2 = r3
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.b
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f4675a
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.b
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.e(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L60
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.e(r3, r0, r0)
            if (r0 == 0) goto L61
        L60:
            r3 = r4
        L61:
            if (r3 == 0) goto L66
            super.onMeasure(r8, r9)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i) {
        this.b = i;
    }
}
