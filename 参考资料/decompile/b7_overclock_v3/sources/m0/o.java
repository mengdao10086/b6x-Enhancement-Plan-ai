package m0;

import android.graphics.PointF;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f40571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f40572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f40573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f40574d;

    public o(@n0 PointF pointF, float f10, @n0 PointF pointF2, float f11) {
        this.f40571a = (PointF) androidx.core.util.o.m(pointF, "start == null");
        this.f40572b = f10;
        this.f40573c = (PointF) androidx.core.util.o.m(pointF2, "end == null");
        this.f40574d = f11;
    }

    @n0
    public PointF a() {
        return this.f40573c;
    }

    public float b() {
        return this.f40574d;
    }

    @n0
    public PointF c() {
        return this.f40571a;
    }

    public float d() {
        return this.f40572b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Float.compare(this.f40572b, oVar.f40572b) == 0 && Float.compare(this.f40574d, oVar.f40574d) == 0 && this.f40571a.equals(oVar.f40571a) && this.f40573c.equals(oVar.f40573c);
    }

    public int hashCode() {
        int iHashCode = this.f40571a.hashCode() * 31;
        float f10 = this.f40572b;
        int iFloatToIntBits = (((iHashCode + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31) + this.f40573c.hashCode()) * 31;
        float f11 = this.f40574d;
        return iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
    }

    public String toString() {
        return "PathSegment{start=" + this.f40571a + ", startFraction=" + this.f40572b + ", end=" + this.f40573c + ", endFraction=" + this.f40574d + '}';
    }
}
