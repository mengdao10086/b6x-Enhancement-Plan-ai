package se;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import se.l;

/* JADX INFO: loaded from: classes7.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f49722a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f49723b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f49724c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final le.p f49725d = le.p.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public le.o f49726e;

    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f49722a);
        } else {
            canvas.clipPath(this.f49723b);
            canvas.clipPath(this.f49724c, Region.Op.UNION);
        }
    }

    public void b(float f10, le.o oVar, le.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        le.o oVarO = u.o(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f10);
        this.f49726e = oVarO;
        this.f49725d.d(oVarO, 1.0f, rectF2, this.f49723b);
        this.f49725d.d(this.f49726e, 1.0f, rectF3, this.f49724c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f49722a.op(this.f49723b, this.f49724c, Path.Op.UNION);
        }
    }

    public le.o c() {
        return this.f49726e;
    }

    public Path d() {
        return this.f49722a;
    }
}
