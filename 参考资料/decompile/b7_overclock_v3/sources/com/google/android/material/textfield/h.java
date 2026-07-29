package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class h extends le.j {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @n0
    public final RectF f20944k0;

    public h() {
        this(null);
    }

    public boolean P0() {
        return !this.f20944k0.isEmpty();
    }

    public void Q0() {
        R0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void R0(float f10, float f11, float f12, float f13) {
        RectF rectF = this.f20944k0;
        if (f10 == rectF.left && f11 == rectF.top && f12 == rectF.right && f13 == rectF.bottom) {
            return;
        }
        rectF.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    public void S0(@n0 RectF rectF) {
        R0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // le.j
    public void s(@n0 Canvas canvas) {
        if (this.f20944k0.isEmpty()) {
            super.s(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.f20944k0);
        } else {
            canvas.clipRect(this.f20944k0, Region.Op.DIFFERENCE);
        }
        super.s(canvas);
        canvas.restore();
    }

    public h(@p0 le.o oVar) {
        super(oVar == null ? new le.o() : oVar);
        this.f20944k0 = new RectF();
    }
}
