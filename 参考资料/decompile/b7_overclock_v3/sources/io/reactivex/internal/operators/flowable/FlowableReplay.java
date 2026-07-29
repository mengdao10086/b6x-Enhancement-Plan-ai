package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableReplay<T> extends cj.a<T> implements fj.h<T>, ej.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Callable f33394f = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.j<T> f33395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<ReplaySubscriber<T>> f33396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<? extends d<T>> f33397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bu.c<T> f33398e;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements d<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public final void a() {
            Object objD = d(NotificationLite.complete());
            long j10 = this.index + 1;
            this.index = j10;
            b(new Node(objD, j10));
            t();
        }

        public final void b(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void c(Collection<? super T> collection) {
            Node nodeH = h();
            while (true) {
                nodeH = nodeH.get();
                if (nodeH == null) {
                    return;
                }
                Object objM = m(nodeH.value);
                if (NotificationLite.isComplete(objM) || NotificationLite.isError(objM)) {
                    return;
                } else {
                    collection.add((Object) NotificationLite.getValue(objM));
                }
            }
        }

        public Object d(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public final void e(Throwable th2) {
            Object objD = d(NotificationLite.error(th2));
            long j10 = this.index + 1;
            this.index = j10;
            b(new Node(objD, j10));
            t();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public final void f(T t10) {
            Object objD = d(NotificationLite.next(t10));
            long j10 = this.index + 1;
            this.index = j10;
            b(new Node(objD, j10));
            r();
        }

        public Node h() {
            return get();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public final void i(InnerSubscription<T> innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                while (!innerSubscription.isDisposed()) {
                    long j10 = innerSubscription.get();
                    boolean z10 = j10 == Long.MAX_VALUE;
                    Node nodeH = (Node) innerSubscription.a();
                    if (nodeH == null) {
                        nodeH = h();
                        innerSubscription.index = nodeH;
                        io.reactivex.internal.util.b.a(innerSubscription.totalRequested, nodeH.index);
                    }
                    long j11 = 0;
                    while (j10 != 0 && (node = nodeH.get()) != null) {
                        Object objM = m(node.value);
                        try {
                            if (NotificationLite.accept(objM, innerSubscription.child)) {
                                innerSubscription.index = null;
                                return;
                            }
                            j11++;
                            j10--;
                            if (innerSubscription.isDisposed()) {
                                innerSubscription.index = null;
                                return;
                            }
                            nodeH = node;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            innerSubscription.index = null;
                            innerSubscription.dispose();
                            if (NotificationLite.isError(objM) || NotificationLite.isComplete(objM)) {
                                return;
                            }
                            innerSubscription.child.onError(th2);
                            return;
                        }
                    }
                    if (j11 != 0) {
                        innerSubscription.index = nodeH;
                        if (!z10) {
                            innerSubscription.b(j11);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
                innerSubscription.index = null;
            }
        }

        public boolean k() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(m(obj));
        }

        public boolean l() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(m(obj));
        }

        public Object m(Object obj) {
            return obj;
        }

        public final void n() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            p(node);
        }

        public final void o(int i10) {
            Node node = get();
            while (i10 > 0) {
                node = node.get();
                i10--;
                this.size--;
            }
            p(node);
            Node node2 = get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        public final void p(Node node) {
            set(node);
        }

        public final void q() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public void r() {
        }

        public void t() {
            q();
        }
    }

    public static final class InnerSubscription<T> extends AtomicLong implements bu.e, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f33399a = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        public final bu.d<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final ReplaySubscriber<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public InnerSubscription(ReplaySubscriber<T> replaySubscriber, bu.d<? super T> dVar) {
            this.parent = replaySubscriber;
            this.child = dVar;
        }

        public <U> U a() {
            return (U) this.index;
        }

        public long b(long j10) {
            return io.reactivex.internal.util.b.f(this, j10);
        }

        @Override // bu.e
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.c(this);
                this.parent.b();
                this.index = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // bu.e
        public void request(long j10) {
            if (!SubscriptionHelper.validate(j10) || io.reactivex.internal.util.b.b(this, j10) == Long.MIN_VALUE) {
                return;
            }
            io.reactivex.internal.util.b.a(this.totalRequested, j10);
            this.parent.b();
            this.parent.buffer.i(this);
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public Node(Object obj, long j10) {
            this.value = obj;
            this.index = j10;
        }
    }

    public static final class ReplaySubscriber<T> extends AtomicReference<bu.e> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerSubscription[] f33400a = new InnerSubscription[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerSubscription[] f33401b = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        public final d<T> buffer;
        public boolean done;
        public long maxChildRequested;
        public long maxUpstreamRequested;
        public final AtomicInteger management = new AtomicInteger();
        public final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(f33400a);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplaySubscriber(d<T> dVar) {
            this.buffer = dVar;
        }

        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            Objects.requireNonNull(innerSubscription);
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == f33401b) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public void b() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (!isDisposed()) {
                InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                long j10 = this.maxChildRequested;
                long jMax = j10;
                for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                    jMax = Math.max(jMax, innerSubscription.totalRequested.get());
                }
                long j11 = this.maxUpstreamRequested;
                bu.e eVar = get();
                long j12 = jMax - j10;
                if (j12 != 0) {
                    this.maxChildRequested = jMax;
                    if (eVar == null) {
                        long j13 = j11 + j12;
                        if (j13 < 0) {
                            j13 = Long.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j13;
                    } else if (j11 != 0) {
                        this.maxUpstreamRequested = 0L;
                        eVar.request(j11 + j12);
                    } else {
                        eVar.request(j12);
                    }
                } else if (j11 != 0 && eVar != null) {
                    this.maxUpstreamRequested = 0L;
                    eVar.request(j11);
                }
                iAddAndGet = this.management.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public void c(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerSubscriptionArr[i11].equals(innerSubscription)) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = f33400a;
                } else {
                    InnerSubscription<T>[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i10);
                    System.arraycopy(innerSubscriptionArr, i10 + 1, innerSubscriptionArr3, i10, (length - i10) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.subscribers.set(f33401b);
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == f33401b;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.a();
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f33401b)) {
                this.buffer.i(innerSubscription);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.buffer.e(th2);
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f33401b)) {
                this.buffer.i(innerSubscription);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            this.buffer.f(t10);
            for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.i(innerSubscription);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this, eVar)) {
                b();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.i(innerSubscription);
                }
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAge;
        public final xi.h0 scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.scheduler = h0Var;
            this.limit = i10;
            this.maxAge = j10;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object d(Object obj) {
            return new lj.d(obj, this.scheduler.e(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Node h() {
            Node node;
            long jE = this.scheduler.e(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                lj.d dVar = (lj.d) node2.value;
                if (NotificationLite.isComplete(dVar.d()) || NotificationLite.isError(dVar.d()) || dVar.a() > jE) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public Object m(Object obj) {
            return ((lj.d) obj).d();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void r() {
            Node node;
            long jE = this.scheduler.e(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i10 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i11 = this.size;
                if (i11 > this.limit && i11 > 1) {
                    i10++;
                    this.size = i11 - 1;
                    node3 = node2.get();
                } else {
                    if (((lj.d) node2.value).a() > jE) {
                        break;
                    }
                    i10++;
                    this.size--;
                    node3 = node2.get();
                }
            }
            if (i10 != 0) {
                p(node);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void t() {
            Node node;
            long jE = this.scheduler.e(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i10 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.size <= 1 || ((lj.d) node2.value).a() > jE) {
                    break;
                }
                i10++;
                this.size--;
                node3 = node2.get();
            }
            if (i10 != 0) {
                p(node);
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i10) {
            this.limit = i10;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void r() {
            if (this.size > this.limit) {
                n();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements d<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i10) {
            super(i10);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public void a() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public void e(Throwable th2) {
            add(NotificationLite.error(th2));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public void f(T t10) {
            add(NotificationLite.next(t10));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.d
        public void i(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                bu.d<? super T> dVar = innerSubscription.child;
                while (!innerSubscription.isDisposed()) {
                    int i10 = this.size;
                    Integer num = (Integer) innerSubscription.a();
                    int iIntValue = num != null ? num.intValue() : 0;
                    long j10 = innerSubscription.get();
                    long j11 = j10;
                    long j12 = 0;
                    while (j11 != 0 && iIntValue < i10) {
                        Object obj = get(iIntValue);
                        try {
                            if (NotificationLite.accept(obj, dVar) || innerSubscription.isDisposed()) {
                                return;
                            }
                            iIntValue++;
                            j11--;
                            j12++;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            innerSubscription.dispose();
                            if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                                return;
                            }
                            dVar.onError(th2);
                            return;
                        }
                    }
                    if (j12 != 0) {
                        innerSubscription.index = Integer.valueOf(iIntValue);
                        if (j10 != Long.MAX_VALUE) {
                            innerSubscription.b(j12);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
            }
        }
    }

    public static final class a<T> extends cj.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cj.a<T> f33402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xi.j<T> f33403c;

        public a(cj.a<T> aVar, xi.j<T> jVar) {
            this.f33402b = aVar;
            this.f33403c = jVar;
        }

        @Override // cj.a
        public void Q8(dj.g<? super io.reactivex.disposables.b> gVar) {
            this.f33402b.Q8(gVar);
        }

        @Override // xi.j
        public void k6(bu.d<? super T> dVar) {
            this.f33403c.d(dVar);
        }
    }

    public static final class b implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static final class c<R, U> extends xi.j<R> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Callable<? extends cj.a<U>> f33404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.o<? super xi.j<U>, ? extends bu.c<R>> f33405c;

        public final class a implements dj.g<io.reactivex.disposables.b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SubscriberResourceWrapper<R> f33406a;

            public a(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.f33406a = subscriberResourceWrapper;
            }

            @Override // dj.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(io.reactivex.disposables.b bVar) {
                this.f33406a.a(bVar);
            }
        }

        public c(Callable<? extends cj.a<U>> callable, dj.o<? super xi.j<U>, ? extends bu.c<R>> oVar) {
            this.f33404b = callable;
            this.f33405c = oVar;
        }

        @Override // xi.j
        public void k6(bu.d<? super R> dVar) {
            try {
                cj.a aVar = (cj.a) io.reactivex.internal.functions.a.g(this.f33404b.call(), "The connectableFactory returned null");
                try {
                    bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.f33405c.apply(aVar), "The selector returned a null Publisher");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(dVar);
                    cVar.d(subscriberResourceWrapper);
                    aVar.Q8(new a(subscriberResourceWrapper));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    EmptySubscription.error(th2, dVar);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                EmptySubscription.error(th3, dVar);
            }
        }
    }

    public interface d<T> {
        void a();

        void e(Throwable th2);

        void f(T t10);

        void i(InnerSubscription<T> innerSubscription);
    }

    public static final class e<T> implements Callable<d<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33408a;

        public e(int i10) {
            this.f33408a = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d<T> call() {
            return new SizeBoundReplayBuffer(this.f33408a);
        }
    }

    public static final class f<T> implements bu.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<ReplaySubscriber<T>> f33409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Callable<? extends d<T>> f33410b;

        public f(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends d<T>> callable) {
            this.f33409a = atomicReference;
            this.f33410b = callable;
        }

        @Override // bu.c
        public void d(bu.d<? super T> dVar) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.f33409a.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.f33410b.call());
                    if (this.f33409a.compareAndSet(null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    EmptySubscription.error(th2, dVar);
                    return;
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, dVar);
            dVar.onSubscribe(innerSubscription);
            replaySubscriber.a(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.c(innerSubscription);
            } else {
                replaySubscriber.b();
                replaySubscriber.buffer.i(innerSubscription);
            }
        }
    }

    public static final class g<T> implements Callable<d<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f33413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final xi.h0 f33414d;

        public g(int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f33411a = i10;
            this.f33412b = j10;
            this.f33413c = timeUnit;
            this.f33414d = h0Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f33411a, this.f33412b, this.f33413c, this.f33414d);
        }
    }

    public FlowableReplay(bu.c<T> cVar, xi.j<T> jVar, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends d<T>> callable) {
        this.f33398e = cVar;
        this.f33395b = jVar;
        this.f33396c = atomicReference;
        this.f33397d = callable;
    }

    public static <T> cj.a<T> Y8(xi.j<T> jVar, int i10) {
        return i10 == Integer.MAX_VALUE ? c9(jVar) : b9(jVar, new e(i10));
    }

    public static <T> cj.a<T> Z8(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        return a9(jVar, j10, timeUnit, h0Var, Integer.MAX_VALUE);
    }

    public static <T> cj.a<T> a9(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10) {
        return b9(jVar, new g(i10, j10, timeUnit, h0Var));
    }

    public static <T> cj.a<T> b9(xi.j<T> jVar, Callable<? extends d<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return kj.a.O(new FlowableReplay(new f(atomicReference, callable), jVar, atomicReference, callable));
    }

    public static <T> cj.a<T> c9(xi.j<? extends T> jVar) {
        return b9(jVar, f33394f);
    }

    public static <U, R> xi.j<R> d9(Callable<? extends cj.a<U>> callable, dj.o<? super xi.j<U>, ? extends bu.c<R>> oVar) {
        return new c(callable, oVar);
    }

    public static <T> cj.a<T> e9(cj.a<T> aVar, xi.h0 h0Var) {
        return kj.a.O(new a(aVar, aVar.l4(h0Var)));
    }

    @Override // cj.a
    public void Q8(dj.g<? super io.reactivex.disposables.b> gVar) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.f33396c.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.f33397d.call());
                if (this.f33396c.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                io.reactivex.exceptions.a.b(th);
                RuntimeException runtimeExceptionF = ExceptionHelper.f(th);
            }
        }
        boolean z10 = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(replaySubscriber);
            if (z10) {
                this.f33395b.j6(replaySubscriber);
            }
        } catch (Throwable th2) {
            if (z10) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // ej.c
    public void e(io.reactivex.disposables.b bVar) {
        this.f33396c.compareAndSet((ReplaySubscriber) bVar, null);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33398e.d(dVar);
    }

    @Override // fj.h
    public bu.c<T> source() {
        return this.f33395b;
    }
}
