package kotlin.collections;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "MapAccessorsKt")
public final class m0 {
    @bk.f
    public static final <V, V1 extends V> V1 a(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return (V1) q0.a(map, property.getName());
    }

    @hk.h(name = "getVar")
    @bk.f
    public static final <V, V1 extends V> V1 b(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return (V1) q0.a(map, property.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <V> void c(Map<? super String, ? super V> map, Object obj, kotlin.reflect.n<?> property, V v10) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        map.put(property.getName(), v10);
    }
}
