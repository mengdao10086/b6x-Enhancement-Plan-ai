package le;

import android.graphics.RectF;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.x;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f39662a;

    public m(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f39662a = f10;
    }

    @Override // le.d
    public float a(@n0 RectF rectF) {
        return this.f39662a * rectF.height();
    }

    @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float b() {
        return this.f39662a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.f39662a == ((m) obj).f39662a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f39662a)});
    }
}
