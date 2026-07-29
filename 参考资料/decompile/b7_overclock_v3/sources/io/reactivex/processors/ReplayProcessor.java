package io.reactivex.processors;

import bj.f;
import bu.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayProcessor<T> extends io.reactivex.processors.a<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f35341e = new Object[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReplaySubscription[] f35342f = new ReplaySubscription[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReplaySubscription[] f35343g = new ReplaySubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<T> f35344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<ReplaySubscription<T>[]> f35346d = new AtomicReference<>(f35342f);

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t10) {
            this.value = t10;
        }
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements e {
        private static final long serialVersionUID = 466549804534799122L;
        public volatile boolean cancelled;
        public final bu.d<? super T> downstream;
        public long emitted;
        public Object index;
        public final AtomicLong requested = new AtomicLong();
        public final ReplayProcessor<T> state;

        public ReplaySubscription(bu.d<? super T> dVar, ReplayProcessor<T> replayProcessor) {
            this.downstream = dVar;
            this.state = replayProcessor;
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.d9(this);
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                this.state.f35344b.g(this);
            }
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

    public interface a<T> {
        void a();

        void b();

        T[] c(T[] tArr);

        Throwable d();

        void e(Throwable th2);

        void f(T t10);

        void g(ReplaySubscription<T> replaySubscription);

        @f
        T getValue();

        boolean isDone();

        int size();
    }

    public static final class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f35349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0 f35350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f35351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile TimedNode<T> f35352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TimedNode<T> f35353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Throwable f35354h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f35355i;

        public b(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
            this.f35347a = io.reactivex.internal.functions.a.h(i10, "maxSize");
            this.f35348b = io.reactivex.internal.functions.a.i(j10, "maxAge");
            this.f35349c = (TimeUnit) io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
            this.f35350d = (h0) io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.f35353g = timedNode;
            this.f35352f = timedNode;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void a() {
            k();
            this.f35355i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void b() {
            if (this.f35352f.value != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0L);
                timedNode.lazySet(this.f35352f.get());
                this.f35352f = timedNode;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public T[] c(T[] tArr) {
            TimedNode<T> timedNodeH = h();
            int i10 = i(timedNodeH);
            if (i10 != 0) {
                if (tArr.length < i10) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
                }
                for (int i11 = 0; i11 != i10; i11++) {
                    timedNodeH = timedNodeH.get();
                    tArr[i11] = timedNodeH.value;
                }
                if (tArr.length > i10) {
                    tArr[i10] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public Throwable d() {
            return this.f35354h;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void e(Throwable th2) {
            k();
            this.f35354h = th2;
            this.f35355i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void f(T t10) {
            TimedNode<T> timedNode = new TimedNode<>(t10, this.f35350d.e(this.f35349c));
            TimedNode<T> timedNode2 = this.f35353g;
            this.f35353g = timedNode;
            this.f35351e++;
            timedNode2.set(timedNode);
            j();
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void g(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            bu.d<? super T> dVar = replaySubscription.downstream;
            TimedNode<T> timedNodeH = (TimedNode) replaySubscription.index;
            if (timedNodeH == null) {
                timedNodeH = h();
            }
            long j10 = replaySubscription.emitted;
            int iAddAndGet = 1;
            do {
                long j11 = replaySubscription.requested.get();
                while (j10 != j11) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z10 = this.f35355i;
                    TimedNode<T> timedNode = timedNodeH.get();
                    boolean z11 = timedNode == null;
                    if (z10 && z11) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.f35354h;
                        if (th2 == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(th2);
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(timedNode.value);
                    j10++;
                    timedNodeH = timedNode;
                }
                if (j10 == j11) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    if (this.f35355i && timedNodeH.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th3 = this.f35354h;
                        if (th3 == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(th3);
                            return;
                        }
                    }
                }
                replaySubscription.index = timedNodeH;
                replaySubscription.emitted = j10;
                iAddAndGet = replaySubscription.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        @f
        public T getValue() {
            TimedNode<T> timedNode = this.f35352f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.f35350d.e(this.f35349c) - this.f35348b) {
                return null;
            }
            return timedNode.value;
        }

        public TimedNode<T> h() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f35352f;
            long jE = this.f35350d.e(this.f35349c) - this.f35348b;
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

        public int i(TimedNode<T> timedNode) {
            int i10 = 0;
            while (i10 != Integer.MAX_VALUE && (timedNode = timedNode.get()) != null) {
                i10++;
            }
            return i10;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public boolean isDone() {
            return this.f35355i;
        }

        public void j() {
            int i10 = this.f35351e;
            if (i10 > this.f35347a) {
                this.f35351e = i10 - 1;
                this.f35352f = this.f35352f.get();
            }
            long jE = this.f35350d.e(this.f35349c) - this.f35348b;
            TimedNode<T> timedNode = this.f35352f;
            while (this.f35351e > 1) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.f35352f = timedNode;
                    return;
                } else if (timedNode2.time > jE) {
                    this.f35352f = timedNode;
                    return;
                } else {
                    this.f35351e--;
                    timedNode = timedNode2;
                }
            }
            this.f35352f = timedNode;
        }

        public void k() {
            long jE = this.f35350d.e(this.f35349c) - this.f35348b;
            TimedNode<T> timedNode = this.f35352f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.value != null) {
                        this.f35352f = new TimedNode<>(null, 0L);
                        return;
                    } else {
                        this.f35352f = timedNode;
                        return;
                    }
                }
                if (timedNode2.time > jE) {
                    if (timedNode.value == null) {
                        this.f35352f = timedNode;
                        return;
                    }
                    TimedNode<T> timedNode3 = new TimedNode<>(null, 0L);
                    timedNode3.lazySet(timedNode.get());
                    this.f35352f = timedNode3;
                    return;
                }
                timedNode = timedNode2;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public int size() {
            return i(h());
        }
    }

    public static final class c<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f35357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile Node<T> f35358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Node<T> f35359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Throwable f35360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f35361f;

        public c(int i10) {
            this.f35356a = io.reactivex.internal.functions.a.h(i10, "maxSize");
            Node<T> node = new Node<>(null);
            this.f35359d = node;
            this.f35358c = node;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void a() {
            b();
            this.f35361f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void b() {
            if (this.f35358c.value != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.f35358c.get());
                this.f35358c = node;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public T[] c(T[] tArr) {
            Node<T> node = this.f35358c;
            Node<T> node2 = node;
            int i10 = 0;
            while (true) {
                node2 = node2.get();
                if (node2 == null) {
                    break;
                }
                i10++;
            }
            if (tArr.length < i10) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
            }
            for (int i11 = 0; i11 < i10; i11++) {
                node = node.get();
                tArr[i11] = node.value;
            }
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public Throwable d() {
            return this.f35360e;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void e(Throwable th2) {
            this.f35360e = th2;
            b();
            this.f35361f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void f(T t10) {
            Node<T> node = new Node<>(t10);
            Node<T> node2 = this.f35359d;
            this.f35359d = node;
            this.f35357b++;
            node2.set(node);
            h();
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void g(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            bu.d<? super T> dVar = replaySubscription.downstream;
            Node<T> node = (Node) replaySubscription.index;
            if (node == null) {
                node = this.f35358c;
            }
            long j10 = replaySubscription.emitted;
            int iAddAndGet = 1;
            do {
                long j11 = replaySubscription.requested.get();
                while (j10 != j11) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z10 = this.f35361f;
                    Node<T> node2 = node.get();
                    boolean z11 = node2 == null;
                    if (z10 && z11) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.f35360e;
                        if (th2 == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(th2);
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(node2.value);
                    j10++;
                    node = node2;
                }
                if (j10 == j11) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    if (this.f35361f && node.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th3 = this.f35360e;
                        if (th3 == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(th3);
                            return;
                        }
                    }
                }
                replaySubscription.index = node;
                replaySubscription.emitted = j10;
                iAddAndGet = replaySubscription.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public T getValue() {
            Node<T> node = this.f35358c;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        public void h() {
            int i10 = this.f35357b;
            if (i10 > this.f35356a) {
                this.f35357b = i10 - 1;
                this.f35358c = this.f35358c.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public boolean isDone() {
            return this.f35361f;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public int size() {
            Node<T> node = this.f35358c;
            int i10 = 0;
            while (i10 != Integer.MAX_VALUE && (node = node.get()) != null) {
                i10++;
            }
            return i10;
        }
    }

    public static final class d<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f35362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Throwable f35363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f35364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile int f35365d;

        public d(int i10) {
            this.f35362a = new ArrayList(io.reactivex.internal.functions.a.h(i10, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void a() {
            this.f35364c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void b() {
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public T[] c(T[] tArr) {
            int i10 = this.f35365d;
            if (i10 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.f35362a;
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

        @Override // io.reactivex.processors.ReplayProcessor.a
        public Throwable d() {
            return this.f35363b;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void e(Throwable th2) {
            this.f35363b = th2;
            this.f35364c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void f(T t10) {
            this.f35362a.add(t10);
            this.f35365d++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public void g(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.f35362a;
            bu.d<? super T> dVar = replaySubscription.downstream;
            Integer num = (Integer) replaySubscription.index;
            int iIntValue = 0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                replaySubscription.index = 0;
            }
            long j10 = replaySubscription.emitted;
            int iAddAndGet = 1;
            do {
                long j11 = replaySubscription.requested.get();
                while (j10 != j11) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z10 = this.f35364c;
                    int i10 = this.f35365d;
                    if (z10 && iIntValue == i10) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th2 = this.f35363b;
                        if (th2 == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(th2);
                            return;
                        }
                    }
                    if (iIntValue == i10) {
                        break;
                    }
                    dVar.onNext(list.get(iIntValue));
                    iIntValue++;
                    j10++;
                }
                if (j10 == j11) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z11 = this.f35364c;
                    int i11 = this.f35365d;
                    if (z11 && iIntValue == i11) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        Throwable th3 = this.f35363b;
                        if (th3 == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(th3);
                            return;
                        }
                    }
                }
                replaySubscription.index = Integer.valueOf(iIntValue);
                replaySubscription.emitted = j10;
                iAddAndGet = replaySubscription.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        @f
        public T getValue() {
            int i10 = this.f35365d;
            if (i10 == 0) {
                return null;
            }
            return this.f35362a.get(i10 - 1);
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public boolean isDone() {
            return this.f35364c;
        }

        @Override // io.reactivex.processors.ReplayProcessor.a
        public int size() {
            return this.f35365d;
        }
    }

    public ReplayProcessor(a<T> aVar) {
        this.f35344b = aVar;
    }

    @bj.c
    @bj.e
    public static <T> ReplayProcessor<T> T8() {
        return new ReplayProcessor<>(new d(16));
    }

    @bj.c
    @bj.e
    public static <T> ReplayProcessor<T> U8(int i10) {
        return new ReplayProcessor<>(new d(i10));
    }

    public static <T> ReplayProcessor<T> V8() {
        return new ReplayProcessor<>(new c(Integer.MAX_VALUE));
    }

    @bj.c
    @bj.e
    public static <T> ReplayProcessor<T> W8(int i10) {
        return new ReplayProcessor<>(new c(i10));
    }

    @bj.c
    @bj.e
    public static <T> ReplayProcessor<T> X8(long j10, TimeUnit timeUnit, h0 h0Var) {
        return new ReplayProcessor<>(new b(Integer.MAX_VALUE, j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.e
    public static <T> ReplayProcessor<T> Y8(long j10, TimeUnit timeUnit, h0 h0Var, int i10) {
        return new ReplayProcessor<>(new b(i10, j10, timeUnit, h0Var));
    }

    @Override // io.reactivex.processors.a
    @f
    public Throwable M8() {
        a<T> aVar = this.f35344b;
        if (aVar.isDone()) {
            return aVar.d();
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        a<T> aVar = this.f35344b;
        return aVar.isDone() && aVar.d() == null;
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35346d.get().length != 0;
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        a<T> aVar = this.f35344b;
        return aVar.isDone() && aVar.d() != null;
    }

    public boolean R8(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.f35346d.get();
            if (replaySubscriptionArr == f35343g) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!this.f35346d.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    public void S8() {
        this.f35344b.b();
    }

    public T Z8() {
        return this.f35344b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] a9() {
        Object[] objArr = f35341e;
        Object[] objArrB9 = b9(objArr);
        return objArrB9 == objArr ? new Object[0] : objArrB9;
    }

    public T[] b9(T[] tArr) {
        return this.f35344b.c(tArr);
    }

    public boolean c9() {
        return this.f35344b.size() != 0;
    }

    public void d9(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.f35346d.get();
            if (replaySubscriptionArr == f35343g || replaySubscriptionArr == f35342f) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (replaySubscriptionArr[i11] == replaySubscription) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = f35342f;
            } else {
                ReplaySubscription<T>[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i10);
                System.arraycopy(replaySubscriptionArr, i10 + 1, replaySubscriptionArr3, i10, (length - i10) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!this.f35346d.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
    }

    public int e9() {
        return this.f35344b.size();
    }

    public int f9() {
        return this.f35346d.get().length;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(dVar, this);
        dVar.onSubscribe(replaySubscription);
        if (R8(replaySubscription) && replaySubscription.cancelled) {
            d9(replaySubscription);
        } else {
            this.f35344b.g(replaySubscription);
        }
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35345c) {
            return;
        }
        this.f35345c = true;
        a<T> aVar = this.f35344b;
        aVar.a();
        for (ReplaySubscription<T> replaySubscription : this.f35346d.getAndSet(f35343g)) {
            aVar.g(replaySubscription);
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35345c) {
            kj.a.Y(th2);
            return;
        }
        this.f35345c = true;
        a<T> aVar = this.f35344b;
        aVar.e(th2);
        for (ReplaySubscription<T> replaySubscription : this.f35346d.getAndSet(f35343g)) {
            aVar.g(replaySubscription);
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35345c) {
            return;
        }
        a<T> aVar = this.f35344b;
        aVar.f(t10);
        for (ReplaySubscription<T> replaySubscription : this.f35346d.get()) {
            aVar.g(replaySubscription);
        }
    }

    @Override // bu.d
    public void onSubscribe(e eVar) {
        if (this.f35345c) {
            eVar.cancel();
        } else {
            eVar.request(Long.MAX_VALUE);
        }
    }
}
