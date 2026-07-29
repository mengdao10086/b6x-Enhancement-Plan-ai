package io.reactivex.processors;

import bj.c;
import bj.f;
import bu.d;
import bu.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public final class BehaviorProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object[] f35313i = new Object[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BehaviorSubscription[] f35314j = new BehaviorSubscription[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final BehaviorSubscription[] f35315k = new BehaviorSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<BehaviorSubscription<T>[]> f35316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadWriteLock f35317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lock f35318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lock f35319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<Object> f35320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<Throwable> f35321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35322h;

    public static final class BehaviorSubscription<T> extends AtomicLong implements e, a.InterfaceC0399a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        public volatile boolean cancelled;
        public final d<? super T> downstream;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public io.reactivex.internal.util.a<Object> queue;
        public final BehaviorProcessor<T> state;

        public BehaviorSubscription(d<? super T> dVar, BehaviorProcessor<T> behaviorProcessor) {
            this.downstream = dVar;
            this.state = behaviorProcessor;
        }

        @Override // io.reactivex.internal.util.a.InterfaceC0399a, dj.r
        public boolean a(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.downstream.onComplete();
                return true;
            }
            if (NotificationLite.isError(obj)) {
                this.downstream.onError(NotificationLite.getError(obj));
                return true;
            }
            long j10 = get();
            if (j10 == 0) {
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
            this.downstream.onNext((Object) NotificationLite.getValue(obj));
            if (j10 == Long.MAX_VALUE) {
                return false;
            }
            decrementAndGet();
            return false;
        }

        public void b() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorProcessor<T> behaviorProcessor = this.state;
                Lock lock = behaviorProcessor.f35318d;
                lock.lock();
                this.index = behaviorProcessor.f35322h;
                Object obj = behaviorProcessor.f35320f.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || a(obj)) {
                    return;
                }
                c();
            }
        }

        public void c() {
            io.reactivex.internal.util.a<Object> aVar;
            while (!this.cancelled) {
                synchronized (this) {
                    aVar = this.queue;
                    if (aVar == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                aVar.d(this);
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.Z8(this);
        }

        public void d(Object obj, long j10) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j10) {
                        return;
                    }
                    if (this.emitting) {
                        io.reactivex.internal.util.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.c(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            a(obj);
        }

        public boolean f() {
            return get() == 0;
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }
    }

    public BehaviorProcessor() {
        this.f35320f = new AtomicReference<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f35317c = reentrantReadWriteLock;
        this.f35318d = reentrantReadWriteLock.readLock();
        this.f35319e = reentrantReadWriteLock.writeLock();
        this.f35316b = new AtomicReference<>(f35314j);
        this.f35321g = new AtomicReference<>();
    }

    @c
    @bj.e
    public static <T> BehaviorProcessor<T> S8() {
        return new BehaviorProcessor<>();
    }

    @c
    @bj.e
    public static <T> BehaviorProcessor<T> T8(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultValue is null");
        return new BehaviorProcessor<>(t10);
    }

    @Override // io.reactivex.processors.a
    @f
    public Throwable M8() {
        Object obj = this.f35320f.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        return NotificationLite.isComplete(this.f35320f.get());
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35316b.get().length != 0;
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        return NotificationLite.isError(this.f35320f.get());
    }

    public boolean R8(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.f35316b.get();
            if (behaviorSubscriptionArr == f35315k) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!this.f35316b.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    @f
    public T U8() {
        Object obj = this.f35320f.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] V8() {
        Object[] objArr = f35313i;
        Object[] objArrW8 = W8(objArr);
        return objArrW8 == objArr ? new Object[0] : objArrW8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public T[] W8(T[] tArr) {
        Object obj = this.f35320f.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        Object value = NotificationLite.getValue(obj);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        tArr[0] = value;
        if (tArr.length == 1) {
            return tArr;
        }
        tArr[1] = 0;
        return tArr;
    }

    public boolean X8() {
        Object obj = this.f35320f.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    public boolean Y8(T t10) {
        if (t10 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        BehaviorSubscription<T>[] behaviorSubscriptionArr = this.f35316b.get();
        for (BehaviorSubscription<T> behaviorSubscription : behaviorSubscriptionArr) {
            if (behaviorSubscription.f()) {
                return false;
            }
        }
        Object next = NotificationLite.next(t10);
        a9(next);
        for (BehaviorSubscription<T> behaviorSubscription2 : behaviorSubscriptionArr) {
            behaviorSubscription2.d(next, this.f35322h);
        }
        return true;
    }

    public void Z8(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.f35316b.get();
            int length = behaviorSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (behaviorSubscriptionArr[i11] == behaviorSubscription) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                behaviorSubscriptionArr2 = f35314j;
            } else {
                BehaviorSubscription<T>[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i10);
                System.arraycopy(behaviorSubscriptionArr, i10 + 1, behaviorSubscriptionArr3, i10, (length - i10) - 1);
                behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
            }
        } while (!this.f35316b.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    public void a9(Object obj) {
        Lock lock = this.f35319e;
        lock.lock();
        this.f35322h++;
        this.f35320f.lazySet(obj);
        lock.unlock();
    }

    public int b9() {
        return this.f35316b.get().length;
    }

    public BehaviorSubscription<T>[] c9(Object obj) {
        BehaviorSubscription<T>[] andSet = this.f35316b.get();
        BehaviorSubscription<T>[] behaviorSubscriptionArr = f35315k;
        if (andSet != behaviorSubscriptionArr && (andSet = this.f35316b.getAndSet(behaviorSubscriptionArr)) != behaviorSubscriptionArr) {
            a9(obj);
        }
        return andSet;
    }

    @Override // xi.j
    public void k6(d<? super T> dVar) {
        BehaviorSubscription<T> behaviorSubscription = new BehaviorSubscription<>(dVar, this);
        dVar.onSubscribe(behaviorSubscription);
        if (R8(behaviorSubscription)) {
            if (behaviorSubscription.cancelled) {
                Z8(behaviorSubscription);
                return;
            } else {
                behaviorSubscription.b();
                return;
            }
        }
        Throwable th2 = this.f35321g.get();
        if (th2 == ExceptionHelper.f35249a) {
            dVar.onComplete();
        } else {
            dVar.onError(th2);
        }
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35321g.compareAndSet(null, ExceptionHelper.f35249a)) {
            Object objComplete = NotificationLite.complete();
            for (BehaviorSubscription<T> behaviorSubscription : c9(objComplete)) {
                behaviorSubscription.d(objComplete, this.f35322h);
            }
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f35321g.compareAndSet(null, th2)) {
            kj.a.Y(th2);
            return;
        }
        Object objError = NotificationLite.error(th2);
        for (BehaviorSubscription<T> behaviorSubscription : c9(objError)) {
            behaviorSubscription.d(objError, this.f35322h);
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35321g.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t10);
        a9(next);
        for (BehaviorSubscription<T> behaviorSubscription : this.f35316b.get()) {
            behaviorSubscription.d(next, this.f35322h);
        }
    }

    @Override // bu.d
    public void onSubscribe(e eVar) {
        if (this.f35321g.get() != null) {
            eVar.cancel();
        } else {
            eVar.request(Long.MAX_VALUE);
        }
    }

    public BehaviorProcessor(T t10) {
        this();
        this.f35320f.lazySet(io.reactivex.internal.functions.a.g(t10, "defaultValue is null"));
    }
}
