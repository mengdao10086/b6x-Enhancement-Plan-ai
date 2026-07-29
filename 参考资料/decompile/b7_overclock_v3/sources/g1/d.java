package g1;

import android.util.FloatProperty;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28912a;

    public static class a extends d<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatProperty f28913b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, FloatProperty floatProperty) {
            super(str);
            this.f28913b = floatProperty;
        }

        @Override // g1.d
        public float b(T t10) {
            return ((Float) this.f28913b.get(t10)).floatValue();
        }

        @Override // g1.d
        public void c(T t10, float f10) {
            this.f28913b.setValue(t10, f10);
        }
    }

    public d(String str) {
        this.f28912a = str;
    }

    @v0(24)
    public static <T> d<T> a(FloatProperty<T> floatProperty) {
        return new a(floatProperty.getName(), floatProperty);
    }

    public abstract float b(T t10);

    public abstract void c(T t10, float f10);
}
