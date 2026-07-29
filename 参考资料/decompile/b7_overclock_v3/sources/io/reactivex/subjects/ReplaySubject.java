package io.reactivex.subjects;

import bj.e;
import bj.f;
import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplaySubject<T> extends c<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReplayDisposable[] f35401d = new ReplayDisposable[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReplayDisposable[] f35402e = new ReplayDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f35403f = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f35404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<ReplayDisposable<T>[]> f35405b = new AtomicReference<>(f35401d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35406c;

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t10) {
            this.value = t10;
        }
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 466549804534799122L;
        public volatile boolean cancelled;
        public final g0<? super T> downstream;
        public Object index;
        public final ReplaySubject<T> state;

        public ReplayDisposable(g0<? super T> g0Var, ReplaySubject<T> replaySubject) {
            this.downstream = g0Var;
            this.state = replaySubject;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.A8(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        public volatile boolean done;
        public volatile TimedNode<Object> head;
        public final long maxAge;
        public final int maxSize;
        public final h0 scheduler;
        public int size;
        public TimedNode<Object> tail;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
            this.maxSize = io.reactivex.internal.functions.a.h(i10, "maxSize");
            this.maxAge = io.reactivex.internal.functions.a.i(j10, "maxAge");
            this.unit = (TimeUnit) io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
            this.scheduler = (h0) io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void a(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            k();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T t10) {
            TimedNode<Object> timedNode = new TimedNode<>(t10, this.scheduler.e(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            i();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void b() {
            TimedNode<Object> timedNode = this.head;
            if (timedNode.value != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0L);
                timedNode2.lazySet(timedNode.get());
                this.head = timedNode2;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public T[] c(T[] tArr) {
            TimedNode<T> timedNodeF = f();
            int iH = h(timedNodeF);
            if (iH != 0) {
                if (tArr.length < iH) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iH));
                }
                for (int i10 = 0; i10 != iH; i10++) {
                    timedNodeF = timedNodeF.get();
                    tArr[i10] = timedNodeF.value;
                }
                if (tArr.length > iH) {
                    tArr[iH] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void d(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            g0<? super T> g0Var = replayDisposable.downstream;
            TimedNode<Object> timedNodeF = (TimedNode) replayDisposable.index;
            if (timedNodeF == null) {
                timedNodeF = f();
            }
            int iAddAndGet = 1;
            while (!replayDisposable.cancelled) {
                while (!replayDisposable.cancelled) {
                    TimedNode<T> timedNode = timedNodeF.get();
                    if (timedNode != null) {
                        T t10 = timedNode.value;
                        if (this.done && timedNode.get() == null) {
                            if (NotificationLite.isComplete(t10)) {
                                g0Var.onComplete();
                            } else {
                                g0Var.onError(NotificationLite.getError(t10));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        g0Var.onNext(t10);
                        timedNodeF = timedNode;
                    } else if (timedNodeF.get() == null) {
                        replayDisposable.index = timedNodeF;
                        iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
                return;
            }
            replayDisposable.index = null;
        }

        public TimedNode<Object> f() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.head;
            long jE = this.scheduler.e(this.unit) - this.maxAge;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > jE) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        @f
        public T getValue() {
            T t10;
            TimedNode<Object> timedNode = this.head;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.time >= this.scheduler.e(this.unit) - this.maxAge && (t10 = (T) timedNode.value) != null) {
                return (NotificationLite.isComplete(t10) || NotificationLite.isError(t10)) ? (T) timedNode2.value : t10;
            }
            return null;
        }

        public int h(TimedNode<Object> timedNode) {
            int i10 = 0;
            while (i10 != Integer.MAX_VALUE) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    Object obj = timedNode.value;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i10 - 1 : i10;
                }
                i10++;
                timedNode = timedNode2;
            }
            return i10;
        }

        public void i() {
            int i10 = this.size;
            if (i10 > this.maxSize) {
                this.size = i10 - 1;
                this.head = this.head.get();
            }
            long jE = this.scheduler.e(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > jE) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        public void k() {
            long jE = this.scheduler.e(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.value == null) {
                        this.head = timedNode;
                        return;
                    }
                    TimedNode<Object> timedNode3 = new TimedNode<>(null, 0L);
                    timedNode3.lazySet(timedNode.get());
                    this.head = timedNode3;
                    return;
                }
                if (timedNode2.time > jE) {
                    if (timedNode.value == null) {
                        this.head = timedNode;
                        return;
                    }
                    TimedNode<Object> timedNode4 = new TimedNode<>(null, 0L);
                    timedNode4.lazySet(timedNode.get());
                    this.head = timedNode4;
                    return;
                }
                timedNode = timedNode2;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public int size() {
            return h(f());
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        public volatile boolean done;
        public volatile Node<Object> head;
        public final int maxSize;
        public int size;
        public Node<Object> tail;

        public SizeBoundReplayBuffer(int i10) {
            this.maxSize = io.reactivex.internal.functions.a.h(i10, "maxSize");
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void a(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            b();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T t10) {
            Node<Object> node = new Node<>(t10);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            f();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void b() {
            Node<Object> node = this.head;
            if (node.value != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.head = node2;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public T[] c(T[] tArr) {
            Node<T> node = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i10 = 0; i10 != size; i10++) {
                    node = node.get();
                    tArr[i10] = node.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void d(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            g0<? super T> g0Var = replayDisposable.downstream;
            Node<Object> node = (Node) replayDisposable.index;
            if (node == null) {
                node = this.head;
            }
            int iAddAndGet = 1;
            while (!replayDisposable.cancelled) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    T t10 = node2.value;
                    if (this.done && node2.get() == null) {
                        if (NotificationLite.isComplete(t10)) {
                            g0Var.onComplete();
                        } else {
                            g0Var.onError(NotificationLite.getError(t10));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    g0Var.onNext(t10);
                    node = node2;
                } else if (node.get() != null) {
                    continue;
                } else {
                    replayDisposable.index = node;
                    iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        public void f() {
            int i10 = this.size;
            if (i10 > this.maxSize) {
                this.size = i10 - 1;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        @f
        public T getValue() {
            Node<Object> node = this.head;
            Node<Object> node2 = null;
            while (true) {
                Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t10 = (T) node.value;
            if (t10 == null) {
                return null;
            }
            return (NotificationLite.isComplete(t10) || NotificationLite.isError(t10)) ? (T) node2.value : t10;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public int size() {
            Node<Object> node = this.head;
            int i10 = 0;
            while (i10 != Integer.MAX_VALUE) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    Object obj = node.value;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i10 - 1 : i10;
                }
                i10++;
                node = node2;
            }
            return i10;
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final long time;
        public final T value;

        public TimedNode(T t10, long j10) {
            this.value = t10;
            this.time = j10;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -733876083048047795L;
        public final List<Object> buffer;
        public volatile boolean done;
        public volatile int size;

        public UnboundedReplayBuffer(int i10) {
            this.buffer = new ArrayList(io.reactivex.internal.functions.a.h(i10, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void a(Object obj) {
            this.buffer.add(obj);
            b();
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T t10) {
            this.buffer.add(t10);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void b() {
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public T[] c(T[] tArr) {
            int i10 = this.size;
            if (i10 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i10 - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i10 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i10) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
            }
            for (int i11 = 0; i11 < i10; i11++) {
                tArr[i11] = list.get(i11);
            }
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void d(ReplayDisposable<T> replayDisposable) {
            int i10;
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.buffer;
            g0<? super T> g0Var = replayDisposable.downstream;
            Integer num = (Integer) replayDisposable.index;
            int iIntValue = 0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                replayDisposable.index = 0;
            }
            int iAddAndGet = 1;
            while (!replayDisposable.cancelled) {
                int i11 = this.size;
                while (i11 != iIntValue) {
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    }
                    Object obj = list.get(iIntValue);
                    if (this.done && (i10 = iIntValue + 1) == i11 && i10 == (i11 = this.size)) {
                        if (NotificationLite.isComplete(obj)) {
                            g0Var.onComplete();
                        } else {
                            g0Var.onError(NotificationLite.getError(obj));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    g0Var.onNext(obj);
                    iIntValue++;
                }
                if (iIntValue == this.size) {
                    replayDisposable.index = Integer.valueOf(iIntValue);
                    iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        @f
        public T getValue() {
            int i10 = this.size;
            if (i10 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t10 = (T) list.get(i10 - 1);
            if (!NotificationLite.isComplete(t10) && !NotificationLite.isError(t10)) {
                return t10;
            }
            if (i10 == 1) {
                return null;
            }
            return (T) list.get(i10 - 2);
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public int size() {
            int i10 = this.size;
            if (i10 == 0) {
                return 0;
            }
            int i11 = i10 - 1;
            Object obj = this.buffer.get(i11);
            return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i11 : i10;
        }
    }

    public interface a<T> {
        void a(Object obj);

        void add(T t10);

        void b();

        T[] c(T[] tArr);

        boolean compareAndSet(Object obj, Object obj2);

        void d(ReplayDisposable<T> replayDisposable);

        Object get();

        @f
        T getValue();

        int size();
    }

    public ReplaySubject(a<T> aVar) {
        this.f35404a = aVar;
    }

    @bj.c
    @e
    public static <T> ReplaySubject<T> p8() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    @bj.c
    @e
    public static <T> ReplaySubject<T> q8(int i10) {
        return new ReplaySubject<>(new UnboundedReplayBuffer(i10));
    }

    public static <T> ReplaySubject<T> r8() {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @bj.c
    @e
    public static <T> ReplaySubject<T> s8(int i10) {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(i10));
    }

    @bj.c
    @e
    public static <T> ReplaySubject<T> t8(long j10, TimeUnit timeUnit, h0 h0Var) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j10, timeUnit, h0Var));
    }

    @bj.c
    @e
    public static <T> ReplaySubject<T> u8(long j10, TimeUnit timeUnit, h0 h0Var, int i10) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i10, j10, timeUnit, h0Var));
    }

    public void A8(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.f35405b.get();
            if (replayDisposableArr == f35402e || replayDisposableArr == f35401d) {
                return;
            }
            int length = replayDisposableArr.length;
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (replayDisposableArr[i11] == replayDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = f35401d;
            } else {
                ReplayDisposable<T>[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i10);
                System.arraycopy(replayDisposableArr, i10 + 1, replayDisposableArr3, i10, (length - i10) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!this.f35405b.compareAndSet(replayDisposableArr, replayDisposableArr2));
    }

    public int B8() {
        return this.f35404a.size();
    }

    public ReplayDisposable<T>[] C8(Object obj) {
        return this.f35404a.compareAndSet(null, obj) ? this.f35405b.getAndSet(f35402e) : f35402e;
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(g0Var, this);
        g0Var.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (n8(replayDisposable) && replayDisposable.cancelled) {
            A8(replayDisposable);
        } else {
            this.f35404a.d(replayDisposable);
        }
    }

    @Override // io.reactivex.subjects.c
    @f
    public Throwable i8() {
        Object obj = this.f35404a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Override // io.reactivex.subjects.c
    public boolean j8() {
        return NotificationLite.isComplete(this.f35404a.get());
    }

    @Override // io.reactivex.subjects.c
    public boolean k8() {
        return this.f35405b.get().length != 0;
    }

    @Override // io.reactivex.subjects.c
    public boolean l8() {
        return NotificationLite.isError(this.f35404a.get());
    }

    public boolean n8(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.f35405b.get();
            if (replayDisposableArr == f35402e) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!this.f35405b.compareAndSet(replayDisposableArr, replayDisposableArr2));
        return true;
    }

    public void o8() {
        this.f35404a.b();
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f35406c) {
            return;
        }
        this.f35406c = true;
        Object objComplete = NotificationLite.complete();
        a<T> aVar = this.f35404a;
        aVar.a(objComplete);
        for (ReplayDisposable<T> replayDisposable : C8(objComplete)) {
            aVar.d(replayDisposable);
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35406c) {
            kj.a.Y(th2);
            return;
        }
        this.f35406c = true;
        Object objError = NotificationLite.error(th2);
        a<T> aVar = this.f35404a;
        aVar.a(objError);
        for (ReplayDisposable<T> replayDisposable : C8(objError)) {
            aVar.d(replayDisposable);
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35406c) {
            return;
        }
        a<T> aVar = this.f35404a;
        aVar.add(t10);
        for (ReplayDisposable<T> replayDisposable : this.f35405b.get()) {
            aVar.d(replayDisposable);
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35406c) {
            bVar.dispose();
        }
    }

    @f
    public T v8() {
        return this.f35404a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] w8() {
        Object[] objArr = f35403f;
        Object[] objArrX8 = x8(objArr);
        return objArrX8 == objArr ? new Object[0] : objArrX8;
    }

    public T[] x8(T[] tArr) {
        return this.f35404a.c(tArr);
    }

    public boolean y8() {
        return this.f35404a.size() != 0;
    }

    public int z8() {
        return this.f35405b.get().length;
    }
}
