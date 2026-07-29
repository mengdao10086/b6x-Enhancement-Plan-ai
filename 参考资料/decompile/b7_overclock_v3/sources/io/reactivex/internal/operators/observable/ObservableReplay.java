package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableReplay<T> extends ij.a<T> implements fj.g<T>, ej.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f34283e = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<ReplayObserver<T>> f34285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<T> f34286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.e0<T> f34287d;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements e<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void a() {
            c(new Node(h(NotificationLite.complete())));
            t();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void b(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                Node nodeI = (Node) innerDisposable.a();
                if (nodeI == null) {
                    nodeI = i();
                    innerDisposable.index = nodeI;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node = nodeI.get();
                    if (node == null) {
                        innerDisposable.index = nodeI;
                        iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                    } else {
                        if (NotificationLite.accept(m(node.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        nodeI = node;
                    }
                }
                innerDisposable.index = null;
                return;
            } while (iAddAndGet != 0);
        }

        public final void c(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void d(Collection<? super T> collection) {
            Node nodeI = i();
            while (true) {
                nodeI = nodeI.get();
                if (nodeI == null) {
                    return;
                }
                Object objM = m(nodeI.value);
                if (NotificationLite.isComplete(objM) || NotificationLite.isError(objM)) {
                    return;
                } else {
                    collection.add((Object) NotificationLite.getValue(objM));
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void e(Throwable th2) {
            c(new Node(h(NotificationLite.error(th2))));
            t();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void f(T t10) {
            c(new Node(h(NotificationLite.next(t10))));
            r();
        }

        public Object h(Object obj) {
            return obj;
        }

        public Node i() {
            return get();
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
            this.size--;
            p(get().get());
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
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void r();

        public void t() {
            q();
        }
    }

    public static final class InnerDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2728361546769921047L;
        public volatile boolean cancelled;
        public final xi.g0<? super T> child;
        public Object index;
        public final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> replayObserver, xi.g0<? super T> g0Var) {
            this.parent = replayObserver;
            this.child = g0Var;
        }

        public <U> U a() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.b(this);
            this.index = null;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final Object value;

        public Node(Object obj) {
            this.value = obj;
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerDisposable[] f34288a = new InnerDisposable[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerDisposable[] f34289b = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        public final e<T> buffer;
        public boolean done;
        public final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(f34288a);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplayObserver(e<T> eVar) {
            this.buffer = eVar;
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == f34289b) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i11].equals(innerDisposable)) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f34288a;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i10);
                    System.arraycopy(innerDisposableArr, i10 + 1, innerDisposableArr3, i10, (length - i10) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        public void c() {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.b(innerDisposable);
            }
        }

        public void d() {
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(f34289b)) {
                this.buffer.b(innerDisposable);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observers.set(f34289b);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.observers.get() == f34289b;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.a();
            d();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.buffer.e(th2);
            d();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            this.buffer.f(t10);
            c();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                c();
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object h(Object obj) {
            return new lj.d(obj, this.scheduler.e(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Node i() {
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object m(Object obj) {
            return ((lj.d) obj).d();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
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

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void r() {
            if (this.size > this.limit) {
                n();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i10) {
            super(i10);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void a() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void b(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            xi.g0<? super T> g0Var = innerDisposable.child;
            int iAddAndGet = 1;
            while (!innerDisposable.isDisposed()) {
                int i10 = this.size;
                Integer num = (Integer) innerDisposable.a();
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i10) {
                    if (NotificationLite.accept(get(iIntValue), g0Var) || innerDisposable.isDisposed()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                innerDisposable.index = Integer.valueOf(iIntValue);
                iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void e(Throwable th2) {
            add(NotificationLite.error(th2));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void f(T t10) {
            add(NotificationLite.next(t10));
            this.size++;
        }
    }

    public interface a<T> {
        e<T> call();
    }

    public static final class b<R> implements dj.g<io.reactivex.disposables.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObserverResourceWrapper<R> f34290a;

        public b(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f34290a = observerResourceWrapper;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.disposables.b bVar) {
            this.f34290a.a(bVar);
        }
    }

    public static final class c<R, U> extends xi.z<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Callable<? extends ij.a<U>> f34291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super xi.z<U>, ? extends xi.e0<R>> f34292b;

        public c(Callable<? extends ij.a<U>> callable, dj.o<? super xi.z<U>, ? extends xi.e0<R>> oVar) {
            this.f34291a = callable;
            this.f34292b = oVar;
        }

        @Override // xi.z
        public void I5(xi.g0<? super R> g0Var) {
            try {
                ij.a aVar = (ij.a) io.reactivex.internal.functions.a.g(this.f34291a.call(), "The connectableFactory returned a null ConnectableObservable");
                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.f34292b.apply(aVar), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(g0Var);
                e0Var.c(observerResourceWrapper);
                aVar.m8(new b(observerResourceWrapper));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, g0Var);
            }
        }
    }

    public static final class d<T> extends ij.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ij.a<T> f34293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.z<T> f34294b;

        public d(ij.a<T> aVar, xi.z<T> zVar) {
            this.f34293a = aVar;
            this.f34294b = zVar;
        }

        @Override // xi.z
        public void I5(xi.g0<? super T> g0Var) {
            this.f34294b.c(g0Var);
        }

        @Override // ij.a
        public void m8(dj.g<? super io.reactivex.disposables.b> gVar) {
            this.f34293a.m8(gVar);
        }
    }

    public interface e<T> {
        void a();

        void b(InnerDisposable<T> innerDisposable);

        void e(Throwable th2);

        void f(T t10);
    }

    public static final class f<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34295a;

        public f(int i10) {
            this.f34295a = i10;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<T> call() {
            return new SizeBoundReplayBuffer(this.f34295a);
        }
    }

    public static final class g<T> implements xi.e0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<ReplayObserver<T>> f34296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<T> f34297b;

        public g(AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
            this.f34296a = atomicReference;
            this.f34297b = aVar;
        }

        @Override // xi.e0
        public void c(xi.g0<? super T> g0Var) {
            ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.f34296a.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f34297b.call());
                if (this.f34296a.compareAndSet(null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, g0Var);
            g0Var.onSubscribe(innerDisposable);
            replayObserver.a(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.b(innerDisposable);
            } else {
                replayObserver.buffer.b(innerDisposable);
            }
        }
    }

    public static final class h<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f34300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final xi.h0 f34301d;

        public h(int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f34298a = i10;
            this.f34299b = j10;
            this.f34300c = timeUnit;
            this.f34301d = h0Var;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f34298a, this.f34299b, this.f34300c, this.f34301d);
        }
    }

    public static final class i implements a<Object> {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public ObservableReplay(xi.e0<T> e0Var, xi.e0<T> e0Var2, AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
        this.f34287d = e0Var;
        this.f34284a = e0Var2;
        this.f34285b = atomicReference;
        this.f34286c = aVar;
    }

    public static <T> ij.a<T> A8(ij.a<T> aVar, xi.h0 h0Var) {
        return kj.a.P(new d(aVar, aVar.b4(h0Var)));
    }

    public static <T> ij.a<T> u8(xi.e0<T> e0Var, int i10) {
        return i10 == Integer.MAX_VALUE ? y8(e0Var) : x8(e0Var, new f(i10));
    }

    public static <T> ij.a<T> v8(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        return w8(e0Var, j10, timeUnit, h0Var, Integer.MAX_VALUE);
    }

    public static <T> ij.a<T> w8(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10) {
        return x8(e0Var, new h(i10, j10, timeUnit, h0Var));
    }

    public static <T> ij.a<T> x8(xi.e0<T> e0Var, a<T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        return kj.a.P(new ObservableReplay(new g(atomicReference, aVar), e0Var, atomicReference, aVar));
    }

    public static <T> ij.a<T> y8(xi.e0<? extends T> e0Var) {
        return x8(e0Var, f34283e);
    }

    public static <U, R> xi.z<R> z8(Callable<? extends ij.a<U>> callable, dj.o<? super xi.z<U>, ? extends xi.e0<R>> oVar) {
        return kj.a.U(new c(callable, oVar));
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34287d.c(g0Var);
    }

    @Override // ej.c
    public void e(io.reactivex.disposables.b bVar) {
        this.f34285b.compareAndSet((ReplayObserver) bVar, null);
    }

    @Override // ij.a
    public void m8(dj.g<? super io.reactivex.disposables.b> gVar) {
        ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.f34285b.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f34286c.call());
            if (this.f34285b.compareAndSet(replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z10 = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(replayObserver);
            if (z10) {
                this.f34284a.c(replayObserver);
            }
        } catch (Throwable th2) {
            if (z10) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // fj.g
    public xi.e0<T> source() {
        return this.f34284a;
    }
}
