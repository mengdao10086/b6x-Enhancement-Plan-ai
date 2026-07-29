package kotlinx.coroutines.debug.internal;

import hk.v;
import ik.p;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jk.g;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
public final class ConcurrentWeakMap<K, V> extends kotlin.collections.e<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final AtomicIntegerFieldUpdater f38397b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final AtomicReferenceFieldUpdater f38398c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");

    @v
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final ReferenceQueue<K> f38399a;

    @l
    @v
    private volatile Object core;

    public final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public static final AtomicIntegerFieldUpdater f38400g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f38402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f38403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @k
        public final AtomicReferenceArray f38404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @k
        public final AtomicReferenceArray f38405e;

        @v
        private volatile int load;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        @t0({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        public final class C0435a<E> implements Iterator<E>, jk.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @k
            public final p<K, V, E> f38407a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f38408b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public K f38409c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public V f38410d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0435a(@k p<? super K, ? super V, ? extends E> pVar) {
                this.f38407a = pVar;
                a();
            }

            public final void a() {
                K k10;
                while (true) {
                    int i10 = this.f38408b + 1;
                    this.f38408b = i10;
                    if (i10 >= a.this.f38401a) {
                        return;
                    }
                    g gVar = (g) a.this.f38404d.get(this.f38408b);
                    if (gVar != null && (k10 = (K) gVar.get()) != null) {
                        this.f38409c = k10;
                        Object obj = (V) a.this.f38405e.get(this.f38408b);
                        if (obj instanceof h) {
                            obj = (V) ((h) obj).f38458a;
                        }
                        if (obj != null) {
                            this.f38410d = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.b.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38408b < a.this.f38401a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.Iterator
            public E next() {
                if (this.f38408b >= a.this.f38401a) {
                    throw new NoSuchElementException();
                }
                p<K, V, E> pVar = this.f38407a;
                K k10 = this.f38409c;
                if (k10 == false) {
                    f0.S("key");
                    k10 = (K) z1.f38230a;
                }
                V v10 = this.f38410d;
                if (v10 == false) {
                    f0.S("value");
                    v10 = (V) z1.f38230a;
                }
                E e10 = (E) pVar.r0(k10, v10);
                a();
                return e10;
            }
        }

        public a(int i10) {
            this.f38401a = i10;
            this.f38402b = Integer.numberOfLeadingZeros(i10) + 1;
            this.f38403c = (i10 * 2) / 3;
            this.f38404d = new AtomicReferenceArray(i10);
            this.f38405e = new AtomicReferenceArray(i10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object i(a aVar, Object obj, Object obj2, g gVar, int i10, Object obj3) {
            if ((i10 & 4) != 0) {
                gVar = null;
            }
            return aVar.h(obj, obj2, gVar);
        }

        public final void d(@k g<?> gVar) {
            int iF = f(gVar.f38457a);
            while (true) {
                g<?> gVar2 = (g) this.f38404d.get(iF);
                if (gVar2 == null) {
                    return;
                }
                if (gVar2 == gVar) {
                    k(iF);
                    return;
                } else {
                    if (iF == 0) {
                        iF = this.f38401a;
                    }
                    iF--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @l
        public final V e(@k K k10) {
            int iF = f(k10.hashCode());
            while (true) {
                g gVar = (g) this.f38404d.get(iF);
                if (gVar == null) {
                    return null;
                }
                T t10 = gVar.get();
                if (f0.g(k10, t10)) {
                    V v10 = (V) this.f38405e.get(iF);
                    return v10 instanceof h ? (V) ((h) v10).f38458a : v10;
                }
                if (t10 == 0) {
                    k(iF);
                }
                if (iF == 0) {
                    iF = this.f38401a;
                }
                iF--;
            }
        }

        public final int f(int i10) {
            return (i10 * (-1640531527)) >>> this.f38402b;
        }

        @k
        public final <E> Iterator<E> g(@k p<? super K, ? super V, ? extends E> pVar) {
            return new C0435a(pVar);
        }

        @l
        public final Object h(@k K k10, @l V v10, @l g<K> gVar) {
            int i10;
            Object obj;
            int iF = f(k10.hashCode());
            boolean z10 = false;
            while (true) {
                g gVar2 = (g) this.f38404d.get(iF);
                if (gVar2 != null) {
                    T t10 = gVar2.get();
                    if (!f0.g(k10, t10)) {
                        if (t10 == 0) {
                            k(iF);
                        }
                        if (iF == 0) {
                            iF = this.f38401a;
                        }
                        iF--;
                    } else if (z10) {
                        f38400g.decrementAndGet(this);
                    }
                } else if (v10 != null) {
                    if (!z10) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38400g;
                        do {
                            i10 = atomicIntegerFieldUpdater.get(this);
                            if (i10 >= this.f38403c) {
                                return kotlinx.coroutines.debug.internal.b.f38443c;
                            }
                        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1));
                        z10 = true;
                    }
                    if (gVar == null) {
                        gVar = new g<>(k10, ConcurrentWeakMap.this.f38399a);
                    }
                    if (this.f38404d.compareAndSet(iF, null, gVar)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj = this.f38405e.get(iF);
                if (obj instanceof h) {
                    return kotlinx.coroutines.debug.internal.b.f38443c;
                }
            } while (!this.f38405e.compareAndSet(iF, obj, v10));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @k
        public final ConcurrentWeakMap<K, V>.a j() {
            int i10;
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = (ConcurrentWeakMap<K, V>.a) ConcurrentWeakMap.this.new a(Integer.highestOneBit(qk.v.u(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i11 = this.f38401a;
                while (i10 < i11) {
                    g gVar = (g) this.f38404d.get(i10);
                    Object obj2 = gVar != null ? gVar.get() : null;
                    if (gVar != null && obj2 == null) {
                        k(i10);
                    }
                    while (true) {
                        obj = this.f38405e.get(i10);
                        if (obj instanceof h) {
                            obj = ((h) obj).f38458a;
                            break;
                        }
                        if (this.f38405e.compareAndSet(i10, obj, kotlinx.coroutines.debug.internal.b.d(obj))) {
                            break;
                        }
                    }
                    i10 = (obj2 == null || obj == null || aVar.h(obj2, obj, gVar) != kotlinx.coroutines.debug.internal.b.f38443c) ? i10 + 1 : 0;
                }
                return aVar;
            }
        }

        public final void k(int i10) {
            Object obj;
            do {
                obj = this.f38405e.get(i10);
                if (obj == null || (obj instanceof h)) {
                    return;
                }
            } while (!this.f38405e.compareAndSet(i10, obj, null));
            ConcurrentWeakMap.this.l();
        }

        public final void l(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ik.l<? super Integer, Integer> lVar, Object obj) {
            int i10;
            do {
                i10 = atomicIntegerFieldUpdater.get(obj);
            } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i10, lVar.i(Integer.valueOf(i10)).intValue()));
        }
    }

    public static final class b<K, V> implements Map.Entry<K, V>, g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f38413b;

        public b(K k10, V v10) {
            this.f38412a = k10;
            this.f38413b = v10;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f38412a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f38413b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            kotlinx.coroutines.debug.internal.b.e();
            throw new KotlinNothingValueException();
        }
    }

    public final class c<E> extends kotlin.collections.f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final p<K, V, E> f38414a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@k p<? super K, ? super V, ? extends E> pVar) {
            this.f38414a = pVar;
        }

        @Override // kotlin.collections.f
        public int a() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // kotlin.collections.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e10) {
            kotlinx.coroutines.debug.internal.b.e();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @k
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.f38398c.get(ConcurrentWeakMap.this)).g(this.f38414a);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z10, int i10, u uVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    @Override // kotlin.collections.e
    @k
    public Set<Map.Entry<K, V>> a() {
        return new c(new p<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            @Override // ik.p
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Map.Entry<K, V> r0(@k K k10, @k V v10) {
                return new ConcurrentWeakMap.b(k10, v10);
            }
        });
    }

    @Override // kotlin.collections.e
    @k
    public Set<K> b() {
        return new c(new p<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // ik.p
            @k
            public final K r0(@k K k10, @k V v10) {
                return k10;
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it2 = keySet().iterator();
        while (it2.hasNext()) {
            remove(it2.next());
        }
    }

    @Override // kotlin.collections.e
    public int d() {
        return f38397b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @l
    public V get(@l Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) f38398c.get(this)).e(obj);
    }

    public final void k(g<?> gVar) {
        ((a) f38398c.get(this)).d(gVar);
    }

    public final void l() {
        f38397b.decrementAndGet(this);
    }

    public final synchronized V m(K k10, V v10) {
        V v11;
        a aVarJ = (a) f38398c.get(this);
        while (true) {
            v11 = (V) a.i(aVarJ, k10, v10, null, 4, null);
            if (v11 == kotlinx.coroutines.debug.internal.b.f38443c) {
                aVarJ = aVarJ.j();
                f38398c.set(this, aVarJ);
            }
        }
        return v11;
    }

    public final void n() {
        if (!(this.f38399a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> referenceRemove = this.f38399a.remove();
                f0.n(referenceRemove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                k((g) referenceRemove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override // kotlin.collections.e, java.util.AbstractMap, java.util.Map
    @l
    public V put(@k K k10, @k V v10) {
        V vM = (V) a.i((a) f38398c.get(this), k10, v10, null, 4, null);
        if (vM == kotlinx.coroutines.debug.internal.b.f38443c) {
            vM = m(k10, v10);
        }
        if (vM == null) {
            f38397b.incrementAndGet(this);
        }
        return vM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @l
    public V remove(@l Object obj) {
        if (obj == 0) {
            return null;
        }
        V vM = (V) a.i((a) f38398c.get(this), obj, null, null, 4, null);
        if (vM == kotlinx.coroutines.debug.internal.b.f38443c) {
            vM = m(obj, null);
        }
        if (vM != null) {
            f38397b.decrementAndGet(this);
        }
        return vM;
    }

    public ConcurrentWeakMap(boolean z10) {
        this.core = new a(16);
        this.f38399a = z10 ? new ReferenceQueue<>() : null;
    }
}
