package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
final class EmptyMap implements Map, Serializable, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final EmptyMap f37668a = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    private EmptyMap() {
    }

    private final Object readResolve() {
        return f37668a;
    }

    public boolean a(@yt.k Void value) {
        kotlin.jvm.internal.f0.p(value, "value");
        return false;
    }

    @Override // java.util.Map
    @yt.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void get(@yt.l Object obj) {
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(@yt.l Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    @yt.k
    public Set<Map.Entry> d() {
        return EmptySet.f37669a;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(@yt.l Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @yt.k
    public Set<Object> h() {
        return EmptySet.f37669a;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    public int k() {
        return 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return h();
    }

    @yt.k
    public Collection l() {
        return EmptyList.f37667a;
    }

    public Void m(Object obj, Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return k();
    }

    @yt.k
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return l();
    }
}
