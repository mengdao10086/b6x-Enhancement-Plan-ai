package g2;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
    }
}
