package kd;

import android.graphics.drawable.Drawable;
import android.util.Property;
import g.n0;
import g.p0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class e extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f37173b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f37174a;

    public e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f37174a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @p0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(@n0 Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@n0 Drawable drawable, @n0 Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
