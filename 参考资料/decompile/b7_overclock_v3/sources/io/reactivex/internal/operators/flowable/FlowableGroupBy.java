package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableGroupBy<T, K, V> extends io.reactivex.internal.operators.flowable.a<T, cj.b<K, V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends K> f33259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super T, ? extends V> f33260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final dj.o<? super dj.g<Object>, ? extends Map<K, Object>> f33263g;

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<cj.b<K, V>> implements xi.o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f33264a = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        public final int bufferSize;
        public final boolean delayError;
        public boolean done;
        public final bu.d<? super cj.b<K, V>> downstream;
        public Throwable error;
        public final Queue<b<K, V>> evictedGroups;
        public volatile boolean finished;
        public final Map<Object, b<K, V>> groups;
        public final dj.o<? super T, ? extends K> keySelector;
        public boolean outputFused;
        public final io.reactivex.internal.queue.a<cj.b<K, V>> queue;
        public bu.e upstream;
        public final dj.o<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger groupCount = new AtomicInteger(1);

        public GroupBySubscriber(bu.d<? super cj.b<K, V>> dVar, dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, int i10, boolean z10, Map<Object, b<K, V>> map, Queue<b<K, V>> queue) {
            this.downstream = dVar;
            this.keySelector = oVar;
            this.valueSelector = oVar2;
            this.bufferSize = i10;
            this.delayError = z10;
            this.groups = map;
            this.evictedGroups = queue;
            this.queue = new io.reactivex.internal.queue.a<>(i10);
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                n();
            } else {
                o();
            }
        }

        public void c(K k10) {
            if (k10 == null) {
                k10 = (K) f33264a;
            }
            this.groups.remove(k10);
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                if (this.outputFused || getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                k();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        @Override // fj.o
        public void clear() {
            this.queue.clear();
        }

        public boolean h(boolean z10, boolean z11, bu.d<?> dVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled.get()) {
                aVar.clear();
                return true;
            }
            if (this.delayError) {
                if (!z10 || !z11) {
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    dVar.onError(th2);
                } else {
                    dVar.onComplete();
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th3 = this.error;
            if (th3 != null) {
                aVar.clear();
                dVar.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public final void k() {
            if (this.evictedGroups != null) {
                int i10 = 0;
                while (true) {
                    b<K, V> bVarPoll = this.evictedGroups.poll();
                    if (bVarPoll == null) {
                        break;
                    }
                    bVarPoll.onComplete();
                    i10++;
                }
                if (i10 != 0) {
                    this.groupCount.addAndGet(-i10);
                }
            }
        }

        public void n() {
            Throwable th2;
            io.reactivex.internal.queue.a<cj.b<K, V>> aVar = this.queue;
            bu.d<? super cj.b<K, V>> dVar = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled.get()) {
                boolean z10 = this.finished;
                if (z10 && !this.delayError && (th2 = this.error) != null) {
                    aVar.clear();
                    dVar.onError(th2);
                    return;
                }
                dVar.onNext(null);
                if (z10) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        dVar.onError(th3);
                        return;
                    } else {
                        dVar.onComplete();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void o() {
            io.reactivex.internal.queue.a<cj.b<K, V>> aVar = this.queue;
            bu.d<? super cj.b<K, V>> dVar = this.downstream;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    boolean z10 = this.finished;
                    cj.b<K, V> bVarPoll = aVar.poll();
                    boolean z11 = bVarPoll == null;
                    if (h(z10, z11, dVar, aVar)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(bVarPoll);
                    j11++;
                }
                if (j11 == j10 && h(this.finished, aVar.isEmpty(), dVar, aVar)) {
                    return;
                }
                if (j11 != 0) {
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j11);
                    }
                    this.upstream.request(j11);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<b<K, V>> it2 = this.groups.values().iterator();
            while (it2.hasNext()) {
                it2.next().onComplete();
            }
            this.groups.clear();
            Queue<b<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.finished = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            Iterator<b<K, V>> it2 = this.groups.values().iterator();
            while (it2.hasNext()) {
                it2.next().onError(th2);
            }
            this.groups.clear();
            Queue<b<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.error = th2;
            this.finished = true;
            b();
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            io.reactivex.internal.queue.a<cj.b<K, V>> aVar = this.queue;
            try {
                K kApply = this.keySelector.apply(t10);
                boolean z10 = false;
                Object obj = kApply != null ? kApply : f33264a;
                b<K, V> bVar = this.groups.get(obj);
                b bVar2 = bVar;
                if (bVar == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    b bVarN8 = b.N8(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, bVarN8);
                    this.groupCount.getAndIncrement();
                    z10 = true;
                    bVar2 = bVarN8;
                }
                try {
                    bVar2.onNext(io.reactivex.internal.functions.a.g(this.valueSelector.apply(t10), "The valueSelector returned null"));
                    k();
                    if (z10) {
                        aVar.offer(bVar2);
                        b();
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(this.bufferSize);
            }
        }

        @Override // fj.o
        @bj.f
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public cj.b<K, V> poll() {
            return this.queue.poll();
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements bu.c<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public boolean outputFused;
        public final GroupBySubscriber<?, K, T> parent;
        public int produced;
        public final io.reactivex.internal.queue.a<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicReference<bu.d<? super T>> actual = new AtomicReference<>();
        public final AtomicBoolean once = new AtomicBoolean();

        public State(int i10, GroupBySubscriber<?, K, T> groupBySubscriber, K k10, boolean z10) {
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.parent = groupBySubscriber;
            this.key = k10;
            this.delayError = z10;
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                h();
            } else {
                k();
            }
        }

        public boolean c(boolean z10, boolean z11, bu.d<? super T> dVar, boolean z12, long j10) {
            if (this.cancelled.get()) {
                while (this.queue.poll() != null) {
                    j10++;
                }
                if (j10 != 0) {
                    this.parent.upstream.request(j10);
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            if (z12) {
                if (!z11) {
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    dVar.onError(th2);
                } else {
                    dVar.onComplete();
                }
                return true;
            }
            Throwable th3 = this.error;
            if (th3 != null) {
                this.queue.clear();
                dVar.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.c(this.key);
                b();
            }
        }

        @Override // fj.o
        public void clear() {
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            while (aVar.poll() != null) {
                this.produced++;
            }
            n();
        }

        @Override // bu.c
        public void d(bu.d<? super T> dVar) {
            if (!this.once.compareAndSet(false, true)) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), dVar);
                return;
            }
            dVar.onSubscribe(this);
            this.actual.lazySet(dVar);
            b();
        }

        public void h() {
            Throwable th2;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            bu.d<? super T> dVar = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (dVar != null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && !this.delayError && (th2 = this.error) != null) {
                        aVar.clear();
                        dVar.onError(th2);
                        return;
                    }
                    dVar.onNext(null);
                    if (z10) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            dVar.onError(th3);
                            return;
                        } else {
                            dVar.onComplete();
                            return;
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (dVar == null) {
                    dVar = this.actual.get();
                }
            }
        }

        @Override // fj.o
        public boolean isEmpty() {
            if (!this.queue.isEmpty()) {
                return false;
            }
            n();
            return true;
        }

        public void k() {
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            boolean z10 = this.delayError;
            bu.d<? super T> dVar = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (dVar != null) {
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (true) {
                        if (j11 == j10) {
                            break;
                        }
                        boolean z11 = this.done;
                        T tPoll = aVar.poll();
                        boolean z12 = tPoll == null;
                        long j12 = j11;
                        if (c(z11, z12, dVar, z10, j11)) {
                            return;
                        }
                        if (z12) {
                            j11 = j12;
                            break;
                        } else {
                            dVar.onNext(tPoll);
                            j11 = j12 + 1;
                        }
                    }
                    if (j11 == j10) {
                        long j13 = j11;
                        if (c(this.done, aVar.isEmpty(), dVar, z10, j11)) {
                            return;
                        } else {
                            j11 = j13;
                        }
                    }
                    if (j11 != 0) {
                        if (j10 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j11);
                        }
                        this.parent.upstream.request(j11);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (dVar == null) {
                    dVar = this.actual.get();
                }
            }
        }

        public void n() {
            int i10 = this.produced;
            if (i10 != 0) {
                this.produced = 0;
                this.parent.upstream.request(i10);
            }
        }

        public void onComplete() {
            this.done = true;
            b();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        public void onNext(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // fj.o
        @bj.f
        public T poll() {
            T tPoll = this.queue.poll();
            if (tPoll != null) {
                this.produced++;
                return tPoll;
            }
            n();
            return null;
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public static final class a<K, V> implements dj.g<b<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<b<K, V>> f33265a;

        public a(Queue<b<K, V>> queue) {
            this.f33265a = queue;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(b<K, V> bVar) {
            this.f33265a.offer(bVar);
        }
    }

    public static final class b<K, T> extends cj.b<K, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final State<T, K> f33266c;

        public b(K k10, State<T, K> state) {
            super(k10);
            this.f33266c = state;
        }

        public static <T, K> b<K, T> N8(K k10, int i10, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z10) {
            return new b<>(k10, new State(i10, groupBySubscriber, k10, z10));
        }

        @Override // xi.j
        public void k6(bu.d<? super T> dVar) {
            this.f33266c.d(dVar);
        }

        public void onComplete() {
            this.f33266c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f33266c.onError(th2);
        }

        public void onNext(T t10) {
            this.f33266c.onNext(t10);
        }
    }

    public FlowableGroupBy(xi.j<T> jVar, dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, int i10, boolean z10, dj.o<? super dj.g<Object>, ? extends Map<K, Object>> oVar3) {
        super(jVar);
        this.f33259c = oVar;
        this.f33260d = oVar2;
        this.f33261e = i10;
        this.f33262f = z10;
        this.f33263g = oVar3;
    }

    @Override // xi.j
    public void k6(bu.d<? super cj.b<K, V>> dVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> mapApply;
        try {
            if (this.f33263g == null) {
                concurrentLinkedQueue = null;
                mapApply = new ConcurrentHashMap<>();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                mapApply = this.f33263g.apply(new a(concurrentLinkedQueue));
            }
            this.f33524b.j6(new GroupBySubscriber(dVar, this.f33259c, this.f33260d, this.f33261e, this.f33262f, mapApply, concurrentLinkedQueue));
        } catch (Exception e10) {
            io.reactivex.exceptions.a.b(e10);
            dVar.onSubscribe(EmptyComponent.INSTANCE);
            dVar.onError(e10);
        }
    }
}
