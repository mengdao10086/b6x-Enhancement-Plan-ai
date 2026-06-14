package com.omarea.ui;

import a.f92;
import a.r31;
import a.y42;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ScreenTest extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f8400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f4886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<a> f4887a;

    public enum a {
        SOLID_RED,
        SOLID_GREEN,
        SOLID_BLUE,
        SOLID_WHITE,
        SOLID_BLACK,
        SOLID_GREY,
        SOLID_GREY_DARK,
        LINEAR_GRADIENT_GREY_H,
        LINEAR_GRADIENT_GREY_H_R,
        LINEAR_GRADIENT_GREY_V,
        LINEAR_GRADIENT_GREY_V_R
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenTest(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4887a = y42.c(a.SOLID_RED, a.SOLID_GREEN, a.SOLID_BLUE, a.SOLID_WHITE, a.SOLID_BLACK, a.SOLID_GREY, a.SOLID_GREY_DARK, a.LINEAR_GRADIENT_GREY_H, a.LINEAR_GRADIENT_GREY_H_R, a.LINEAR_GRADIENT_GREY_V, a.LINEAR_GRADIENT_GREY_V_R);
        this.f4886a = a.SOLID_RED;
        this.f8400a = new Paint();
    }

    public final void a() {
        a aVar = this.f4887a.get((this.f4887a.indexOf(this.f4886a) + 1) % this.f4887a.size());
        f92.c(aVar, "steps[index]");
        this.f4886a = aVar;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint;
        int iArgb;
        LinearGradient linearGradient;
        if (canvas != null) {
            this.f8400a.reset();
            switch (r31.f7267a[this.f4886a.ordinal()]) {
                case 1:
                    paint = this.f8400a;
                    iArgb = -65536;
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 2:
                    paint = this.f8400a;
                    iArgb = -16711936;
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 3:
                    paint = this.f8400a;
                    iArgb = -16776961;
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 4:
                    paint = this.f8400a;
                    iArgb = -1;
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 5:
                    paint = this.f8400a;
                    iArgb = -16777216;
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 6:
                    paint = this.f8400a;
                    iArgb = -7829368;
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 7:
                    paint = this.f8400a;
                    iArgb = Color.argb(255, 40, 40, 40);
                    paint.setColor(iArgb);
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
                case 8:
                    linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, canvas.getHeight(), new int[]{-1, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
                    break;
                case 9:
                    linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, canvas.getHeight(), new int[]{-16777216, -1}, (float[]) null, Shader.TileMode.CLAMP);
                    break;
                case 10:
                    linearGradient = new LinearGradient(0.0f, 0.0f, canvas.getWidth(), 0.0f, new int[]{-1, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
                    break;
                case 11:
                    linearGradient = new LinearGradient(0.0f, 0.0f, canvas.getWidth(), 0.0f, new int[]{-16777216, -1}, (float[]) null, Shader.TileMode.CLAMP);
                    break;
                default:
                    canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
            }
            this.f8400a.setShader(linearGradient);
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f8400a);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            a();
        }
        return super.onTouchEvent(motionEvent);
    }
}
