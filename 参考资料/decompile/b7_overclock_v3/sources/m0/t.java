package m0;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
public final class t {
    @yt.k
    public static final Rect A(@yt.k Rect rect, int i10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.top *= i10;
        rect2.left *= i10;
        rect2.right *= i10;
        rect2.bottom *= i10;
        return rect2;
    }

    @yt.k
    public static final RectF B(@yt.k RectF rectF, float f10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @yt.k
    public static final RectF C(@yt.k RectF rectF, int i10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        float f10 = i10;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @yt.k
    public static final Rect D(@yt.k RectF rectF) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @yt.k
    public static final RectF E(@yt.k Rect rect) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        return new RectF(rect);
    }

    @yt.k
    public static final Region F(@yt.k Rect rect) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        return new Region(rect);
    }

    @yt.k
    public static final Region G(@yt.k RectF rectF) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @yt.k
    public static final RectF H(@yt.k RectF rectF, @yt.k Matrix m10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(m10, "m");
        m10.mapRect(rectF);
        return rectF;
    }

    @yt.k
    public static final Region I(@yt.k Rect rect, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region = new Region(rect);
        region.op(r10, Region.Op.XOR);
        return region;
    }

    @yt.k
    public static final Region J(@yt.k RectF rectF, @yt.k RectF r10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r10.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @yt.k
    @SuppressLint({"CheckResult"})
    public static final Rect a(@yt.k Rect rect, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Rect rect2 = new Rect(rect);
        rect2.intersect(r10);
        return rect2;
    }

    @yt.k
    @SuppressLint({"CheckResult"})
    public static final RectF b(@yt.k RectF rectF, @yt.k RectF r10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.intersect(r10);
        return rectF2;
    }

    public static final float c(@yt.k RectF rectF) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        return rectF.left;
    }

    public static final int d(@yt.k Rect rect) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        return rect.left;
    }

    public static final float e(@yt.k RectF rectF) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        return rectF.top;
    }

    public static final int f(@yt.k Rect rect) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        return rect.top;
    }

    public static final float g(@yt.k RectF rectF) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        return rectF.right;
    }

    public static final int h(@yt.k Rect rect) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        return rect.right;
    }

    public static final float i(@yt.k RectF rectF) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        return rectF.bottom;
    }

    public static final int j(@yt.k Rect rect) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean k(@yt.k Rect rect, @yt.k Point p10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        return rect.contains(p10.x, p10.y);
    }

    public static final boolean l(@yt.k RectF rectF, @yt.k PointF p10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        return rectF.contains(p10.x, p10.y);
    }

    @yt.k
    public static final Rect m(@yt.k Rect rect, int i10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        int i11 = -i10;
        rect2.offset(i11, i11);
        return rect2;
    }

    @yt.k
    public static final Rect n(@yt.k Rect rect, @yt.k Point xy) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-xy.x, -xy.y);
        return rect2;
    }

    @yt.k
    public static final RectF o(@yt.k RectF rectF, float f10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f11 = -f10;
        rectF2.offset(f11, f11);
        return rectF2;
    }

    @yt.k
    public static final RectF p(@yt.k RectF rectF, @yt.k PointF xy) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-xy.x, -xy.y);
        return rectF2;
    }

    @yt.k
    public static final Region q(@yt.k Rect rect, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region = new Region(rect);
        region.op(r10, Region.Op.DIFFERENCE);
        return region;
    }

    @yt.k
    public static final Region r(@yt.k RectF rectF, @yt.k RectF r10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r10.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @yt.k
    public static final Rect s(@yt.k Rect rect, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r10);
        return rect2;
    }

    @yt.k
    public static final RectF t(@yt.k RectF rectF, @yt.k RectF r10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r10);
        return rectF2;
    }

    @yt.k
    public static final Rect u(@yt.k Rect rect, int i10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.offset(i10, i10);
        return rect2;
    }

    @yt.k
    public static final Rect v(@yt.k Rect rect, @yt.k Point xy) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(xy.x, xy.y);
        return rect2;
    }

    @yt.k
    public static final Rect w(@yt.k Rect rect, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(rect, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r10);
        return rect2;
    }

    @yt.k
    public static final RectF x(@yt.k RectF rectF, float f10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f10, f10);
        return rectF2;
    }

    @yt.k
    public static final RectF y(@yt.k RectF rectF, @yt.k PointF xy) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(xy.x, xy.y);
        return rectF2;
    }

    @yt.k
    public static final RectF z(@yt.k RectF rectF, @yt.k RectF r10) {
        kotlin.jvm.internal.f0.p(rectF, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r10);
        return rectF2;
    }
}
