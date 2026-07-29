package m0;

import android.graphics.Point;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final float a(@yt.k PointF pointF) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        return pointF.x;
    }

    public static final int b(@yt.k Point point) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        return point.x;
    }

    public static final float c(@yt.k PointF pointF) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        return pointF.y;
    }

    public static final int d(@yt.k Point point) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        return point.y;
    }

    @yt.k
    public static final Point e(@yt.k Point point, float f10) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        return new Point(Math.round(point.x / f10), Math.round(point.y / f10));
    }

    @yt.k
    public static final PointF f(@yt.k PointF pointF, float f10) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        return new PointF(pointF.x / f10, pointF.y / f10);
    }

    @yt.k
    public static final Point g(@yt.k Point point, int i10) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i11 = -i10;
        point2.offset(i11, i11);
        return point2;
    }

    @yt.k
    public static final Point h(@yt.k Point point, @yt.k Point p10) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(-p10.x, -p10.y);
        return point2;
    }

    @yt.k
    public static final PointF i(@yt.k PointF pointF, float f10) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f11 = -f10;
        pointF2.offset(f11, f11);
        return pointF2;
    }

    @yt.k
    public static final PointF j(@yt.k PointF pointF, @yt.k PointF p10) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(-p10.x, -p10.y);
        return pointF2;
    }

    @yt.k
    public static final Point k(@yt.k Point point, int i10) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i10, i10);
        return point2;
    }

    @yt.k
    public static final Point l(@yt.k Point point, @yt.k Point p10) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(p10.x, p10.y);
        return point2;
    }

    @yt.k
    public static final PointF m(@yt.k PointF pointF, float f10) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f10, f10);
        return pointF2;
    }

    @yt.k
    public static final PointF n(@yt.k PointF pointF, @yt.k PointF p10) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(p10.x, p10.y);
        return pointF2;
    }

    @yt.k
    public static final Point o(@yt.k Point point, float f10) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        return new Point(Math.round(point.x * f10), Math.round(point.y * f10));
    }

    @yt.k
    public static final PointF p(@yt.k PointF pointF, float f10) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        return new PointF(pointF.x * f10, pointF.y * f10);
    }

    @yt.k
    public static final Point q(@yt.k PointF pointF) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @yt.k
    public static final PointF r(@yt.k Point point) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        return new PointF(point);
    }

    @yt.k
    public static final Point s(@yt.k Point point) {
        kotlin.jvm.internal.f0.p(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    @yt.k
    public static final PointF t(@yt.k PointF pointF) {
        kotlin.jvm.internal.f0.p(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }
}
