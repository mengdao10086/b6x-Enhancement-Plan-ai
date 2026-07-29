package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final u f4674a = new u();

    @g.u
    @hk.m
    @yt.k
    public static final PersistableBundle a(int i10) {
        return new PersistableBundle(i10);
    }

    @g.u
    @hk.m
    public static final void b(@yt.k PersistableBundle persistableBundle, @yt.l String str, @yt.l Object obj) {
        f0.p(persistableBundle, "persistableBundle");
        if (obj == null) {
            persistableBundle.putString(str, null);
            return;
        }
        if (obj instanceof Boolean) {
            if (Build.VERSION.SDK_INT >= 22) {
                v.a(persistableBundle, str, ((Boolean) obj).booleanValue());
                return;
            }
            throw new IllegalArgumentException("Illegal value type boolean for key \"" + str + kotlin.text.y.f38188b);
        }
        if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            persistableBundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            if (Build.VERSION.SDK_INT >= 22) {
                v.b(persistableBundle, str, (boolean[]) obj);
                return;
            }
            throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + str + kotlin.text.y.f38188b);
        }
        if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
            return;
        }
        if (!(obj instanceof Object[])) {
            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str + kotlin.text.y.f38188b);
        }
        Class<?> componentType = obj.getClass().getComponentType();
        f0.m(componentType);
        if (String.class.isAssignableFrom(componentType)) {
            f0.n(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            persistableBundle.putStringArray(str, (String[]) obj);
            return;
        }
        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + kotlin.text.y.f38188b);
    }
}
