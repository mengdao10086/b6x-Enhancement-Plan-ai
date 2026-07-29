package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n330#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n*L\n101#1:105,6\n*E\n"})
public final class x0<K, V> implements w0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Map<K, V> f37748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<K, V> f37749b;

    /* JADX WARN: Multi-variable type inference failed */
    public x0(@yt.k Map<K, V> map, @yt.k ik.l<? super K, ? extends V> lVar) {
        kotlin.jvm.internal.f0.p(map, "map");
        kotlin.jvm.internal.f0.p(lVar, "default");
        this.f37748a = map;
        this.f37749b = lVar;
    }

    @yt.k
    public Set<Map.Entry<K, V>> a() {
        return f().entrySet();
    }

    @yt.k
    public Set<K> b() {
        return f().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        f().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return f().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return f().containsValue(obj);
    }

    public int d() {
        return f().size();
    }

    @yt.k
    public Collection<V> e() {
        return f().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@yt.l Object obj) {
        return f().equals(obj);
    }

    @Override // kotlin.collections.w0, kotlin.collections.n0
    @yt.k
    public Map<K, V> f() {
        return this.f37748a;
    }

    @Override // java.util.Map
    @yt.l
    public V get(Object obj) {
        return f().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return f().hashCode();
    }

    @Override // kotlin.collections.n0
    public V i(K k10) {
        Map<K, V> mapF = f();
        V v10 = mapF.get(k10);
        return (v10 != null || mapF.containsKey(k10)) ? v10 : this.f37749b.i(k10);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return f().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return b();
    }

    @Override // java.util.Map
    @yt.l
    public V put(K k10, V v10) {
        return f().put(k10, v10);
    }

    @Override // java.util.Map
    public void putAll(@yt.k Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.f0.p(from, "from");
        f().putAll(from);
    }

    @Override // java.util.Map
    @yt.l
    public V remove(Object obj) {
        return f().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @yt.k
    public String toString() {
        return f().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }
}
