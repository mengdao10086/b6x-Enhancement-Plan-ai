package tj;

import bk.f;
import hk.h;
import java.util.Map;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.w0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "CollectionsJDK8Kt")
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @f
    @v0(version = "1.2")
    public static final <K, V> V a(Map<? extends K, ? extends V> map, K k10, V v10) {
        f0.p(map, "<this>");
        return map.getOrDefault(k10, v10);
    }

    @f
    @v0(version = "1.2")
    public static final <K, V> boolean b(Map<? extends K, ? extends V> map, K k10, V v10) {
        f0.p(map, "<this>");
        return w0.k(map).remove(k10, v10);
    }
}
