package rg;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f48751b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f48752c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f48753d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (this.f48751b != iWidth || this.f48752c != iHeight) {
            this.f48753d.reset();
            float f10 = (iWidth * 30) / 225;
            float f11 = f10 * 0.70710677f;
            float f12 = f10 / 0.70710677f;
            float f13 = iWidth;
            float f14 = f13 / 2.0f;
            float f15 = iHeight;
            this.f48753d.moveTo(f14, f15);
            float f16 = f15 / 2.0f;
            this.f48753d.lineTo(0.0f, f16);
            float f17 = f16 - f11;
            this.f48753d.lineTo(f11, f17);
            float f18 = f10 / 2.0f;
            float f19 = f14 - f18;
            float f20 = (f15 - f12) - f18;
            this.f48753d.lineTo(f19, f20);
            this.f48753d.lineTo(f19, 0.0f);
            float f21 = f14 + f18;
            this.f48753d.lineTo(f21, 0.0f);
            this.f48753d.lineTo(f21, f20);
            this.f48753d.lineTo(f13 - f11, f17);
            this.f48753d.lineTo(f13, f16);
            this.f48753d.close();
            this.f48751b = iWidth;
            this.f48752c = iHeight;
        }
        canvas.drawPath(this.f48753d, this.f48773a);
    }
}
