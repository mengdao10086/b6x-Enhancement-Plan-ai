package g2;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes2.dex */
public class l<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Property<T, PointF> f28963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PathMeasure f28964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f28965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f28966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f28967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f28968f;

    public l(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f28966d = new float[2];
        this.f28967e = new PointF();
        this.f28963a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f28964b = pathMeasure;
        this.f28965c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t10) {
        return Float.valueOf(this.f28968f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t10, Float f10) {
        this.f28968f = f10.floatValue();
        this.f28964b.getPosTan(this.f28965c * f10.floatValue(), this.f28966d, null);
        PointF pointF = this.f28967e;
        float[] fArr = this.f28966d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f28963a.set(t10, pointF);
    }
}
