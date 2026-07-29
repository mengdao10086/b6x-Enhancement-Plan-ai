package m0;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n1#1,158:1\n71#1,3:159\n35#1,3:162\n44#1,3:165\n*S KotlinDebug\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n79#1:159,3\n84#1:162,3\n89#1:165,3\n*E\n"})
public final class u {

    public static final class a implements Iterator<Rect>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final RegionIterator f40575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final Rect f40576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f40577c;

        public a(Region region) {
            RegionIterator regionIterator = new RegionIterator(region);
            this.f40575a = regionIterator;
            Rect rect = new Rect();
            this.f40576b = rect;
            this.f40577c = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect next() {
            if (!this.f40577c) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.f40576b);
            this.f40577c = this.f40575a.next(this.f40576b);
            return rect;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f40577c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @yt.k
    public static final Region a(@yt.k Region region, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.INTERSECT);
        return region2;
    }

    @yt.k
    public static final Region b(@yt.k Region region, @yt.k Region r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean c(@yt.k Region region, @yt.k Point p10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        return region.contains(p10.x, p10.y);
    }

    public static final void d(@yt.k Region region, @yt.k ik.l<? super Rect, z1> action) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                action.i(rect);
            }
        }
    }

    @yt.k
    public static final Iterator<Rect> e(@yt.k Region region) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        return new a(region);
    }

    @yt.k
    public static final Region f(@yt.k Region region, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.DIFFERENCE);
        return region2;
    }

    @yt.k
    public static final Region g(@yt.k Region region, @yt.k Region r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.DIFFERENCE);
        return region2;
    }

    @yt.k
    public static final Region h(@yt.k Region region) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @yt.k
    public static final Region i(@yt.k Region region, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.union(r10);
        return region2;
    }

    @yt.k
    public static final Region j(@yt.k Region region, @yt.k Region r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.UNION);
        return region2;
    }

    @yt.k
    public static final Region k(@yt.k Region region, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.union(r10);
        return region2;
    }

    @yt.k
    public static final Region l(@yt.k Region region, @yt.k Region r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.UNION);
        return region2;
    }

    @yt.k
    public static final Region m(@yt.k Region region) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @yt.k
    public static final Region n(@yt.k Region region, @yt.k Rect r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.XOR);
        return region2;
    }

    @yt.k
    public static final Region o(@yt.k Region region, @yt.k Region r10) {
        kotlin.jvm.internal.f0.p(region, "<this>");
        kotlin.jvm.internal.f0.p(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.XOR);
        return region2;
    }
}
