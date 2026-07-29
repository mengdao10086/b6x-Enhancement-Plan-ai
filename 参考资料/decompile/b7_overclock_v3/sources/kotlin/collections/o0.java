package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n330#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapWithDefaultImpl\n*L\n80#1:105,6\n*E\n"})
public final class o0<K, V> implements n0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Map<K, V> f37736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<K, V> f37737b;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(@yt.k Map<K, ? extends V> map, @yt.k ik.l<? super K, ? extends V> lVar) {
        kotlin.jvm.internal.f0.p(map, "map");
        kotlin.jvm.internal.f0.p(lVar, "default");
        this.f37736a = map;
        this.f37737b = lVar;
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
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @Override // kotlin.collections.n0
    @yt.k
    public Map<K, V> f() {
        return this.f37736a;
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
        return (v10 != null || mapF.containsKey(k10)) ? v10 : this.f37737b.i(k10);
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
    public V put(K k10, V v10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
