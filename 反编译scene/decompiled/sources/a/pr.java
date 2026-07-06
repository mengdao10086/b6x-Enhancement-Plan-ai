package a;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pr<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PathMeasure f2449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PointF f2450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Property<T, PointF> f2451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f2452a;
    public float b;

    public pr(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2452a = new float[2];
        this.f2450a = new PointF();
        this.f2451a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f2449a = pathMeasure;
        this.f7141a = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.b);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.b = f.floatValue();
        this.f2449a.getPosTan(this.f7141a * f.floatValue(), this.f2452a, null);
        PointF pointF = this.f2450a;
        float[] fArr = this.f2452a;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f2451a.set(t, pointF);
    }
}
