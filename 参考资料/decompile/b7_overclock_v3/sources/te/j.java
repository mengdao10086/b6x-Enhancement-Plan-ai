package te;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import g.v0;
import te.l;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f51113a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f51114b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f51115c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final le.p f51116d = le.p.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public le.o f51117e;

    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f51113a);
        } else {
            canvas.clipPath(this.f51114b);
            canvas.clipPath(this.f51115c, Region.Op.UNION);
        }
    }

    public void b(float f10, le.o oVar, le.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        le.o oVarO = v.o(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f10);
        this.f51117e = oVarO;
        this.f51116d.d(oVarO, 1.0f, rectF2, this.f51114b);
        this.f51116d.d(this.f51117e, 1.0f, rectF3, this.f51115c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f51113a.op(this.f51114b, this.f51115c, Path.Op.UNION);
        }
    }

    public le.o c() {
        return this.f51117e;
    }

    public Path d() {
        return this.f51113a;
    }
}
