package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1747#2,3:154\n1726#2,3:157\n288#2,2:160\n*S KotlinDebug\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n*L\n28#1:154,3\n60#1:157,3\n141#1:160,2\n*E\n"})
@kotlin.v0(version = "1.1")
public abstract class AbstractMap<K, V> implements Map<K, V>, jk.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f37637c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public volatile Set<? extends K> f37638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public volatile Collection<? extends V> f37639b;

    @kotlin.jvm.internal.t0({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final boolean a(@yt.k Map.Entry<?, ?> e10, @yt.l Object obj) {
            kotlin.jvm.internal.f0.p(e10, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return kotlin.jvm.internal.f0.g(e10.getKey(), entry.getKey()) && kotlin.jvm.internal.f0.g(e10.getValue(), entry.getValue());
        }

        public final int b(@yt.k Map.Entry<?, ?> e10) {
            kotlin.jvm.internal.f0.p(e10, "e");
            Object key = e10.getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = e10.getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @yt.k
        public final String c(@yt.k Map.Entry<?, ?> e10) {
            kotlin.jvm.internal.f0.p(e10, "e");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e10.getKey());
            sb2.append('=');
            sb2.append(e10.getValue());
            return sb2.toString();
        }
    }

    public static final class b extends g<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractMap<K, V> f37640b;

        public static final class a implements Iterator<K>, jk.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator<Map.Entry<K, V>> f37641a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it2) {
                this.f37641a = it2;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f37641a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f37641a.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(AbstractMap<K, ? extends V> abstractMap) {
            this.f37640b = abstractMap;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.f37640b.size();
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f37640b.containsKey(obj);
        }

        @Override // kotlin.collections.g, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @yt.k
        public Iterator<K> iterator() {
            return new a(this.f37640b.entrySet().iterator());
        }
    }

    public static final class c extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractMap<K, V> f37642a;

        public static final class a implements Iterator<V>, jk.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator<Map.Entry<K, V>> f37643a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it2) {
                this.f37643a = it2;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f37643a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f37643a.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(AbstractMap<K, ? extends V> abstractMap) {
            this.f37642a = abstractMap;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.f37642a.size();
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f37642a.containsValue(obj);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @yt.k
        public Iterator<V> iterator() {
            return new a(this.f37642a.entrySet().iterator());
        }
    }

    public final boolean b(@yt.l Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v10 = get(key);
        if (!kotlin.jvm.internal.f0.g(value, v10)) {
            return false;
        }
        if (v10 != null) {
            return true;
        }
        kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return j(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            if (kotlin.jvm.internal.f0.g(((Map.Entry) it2.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Set d();

    @yt.k
    public Set<K> e() {
        if (this.f37638a == null) {
            this.f37638a = new b(this);
        }
        Set<? extends K> set = this.f37638a;
        kotlin.jvm.internal.f0.m(set);
        return set;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(@yt.l Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            if (!b((Map.Entry) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public int g() {
        return entrySet().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @yt.l
    public V get(Object obj) {
        Map.Entry<K, V> entryJ = j(obj);
        if (entryJ != null) {
            return entryJ.getValue();
        }
        return null;
    }

    @yt.k
    public Collection<V> h() {
        if (this.f37639b == null) {
            this.f37639b = new c(this);
        }
        Collection<? extends V> collection = this.f37639b;
        kotlin.jvm.internal.f0.m(collection);
        return collection;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map.Entry<K, V> j(K k10) {
        Object next;
        Iterator<T> it2 = entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (kotlin.jvm.internal.f0.g(((Map.Entry) next).getKey(), k10)) {
                break;
            }
        }
        return (Map.Entry) next;
    }

    public final String k(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return e();
    }

    public final String l(Map.Entry<? extends K, ? extends V> entry) {
        return k(entry.getKey()) + '=' + k(entry.getValue());
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
        return g();
    }

    @yt.k
    public String toString() {
        return CollectionsKt___CollectionsKt.h3(entrySet(), ", ", zc.a.f58316d, zc.a.f58317e, 0, null, new ik.l<Map.Entry<? extends K, ? extends V>, CharSequence>(this) { // from class: kotlin.collections.AbstractMap.toString.1
            public final /* synthetic */ AbstractMap<K, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence i(@yt.k Map.Entry<? extends K, ? extends V> it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return this.this$0.l(it2);
            }
        }, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return h();
    }
}
