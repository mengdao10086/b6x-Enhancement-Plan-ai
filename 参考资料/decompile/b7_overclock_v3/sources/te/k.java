package te;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class k extends PathMotion {
    public static PointF a(float f10, float f11, float f12, float f13) {
        return f11 > f13 ? new PointF(f12, f11) : new PointF(f10, f13);
    }

    @Override // android.transition.PathMotion
    @n0
    public Path getPath(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(f10, f11);
        PointF pointFA = a(f10, f11, f12, f13);
        path.quadTo(pointFA.x, pointFA.y, f12, f13);
        return path;
    }
}
