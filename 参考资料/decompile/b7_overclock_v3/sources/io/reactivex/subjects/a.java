package io.reactivex.subjects;

import bj.e;
import bj.f;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class a<T> extends c<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f35423h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0400a[] f35424i = new C0400a[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0400a[] f35425j = new C0400a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Object> f35426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<C0400a<T>[]> f35427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadWriteLock f35428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lock f35429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lock f35430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<Throwable> f35431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f35432g;

    /* JADX INFO: renamed from: io.reactivex.subjects.a$a, reason: collision with other inner class name */
    public static final class C0400a<T> implements io.reactivex.disposables.b, a.InterfaceC0399a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0<? super T> f35433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<T> f35434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f35435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f35436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.internal.util.a<Object> f35437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f35438f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f35439g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f35440h;

        public C0400a(g0<? super T> g0Var, a<T> aVar) {
            this.f35433a = g0Var;
            this.f35434b = aVar;
        }

        @Override // io.reactivex.internal.util.a.InterfaceC0399a, dj.r
        public boolean a(Object obj) {
            return this.f35439g || NotificationLite.accept(obj, this.f35433a);
        }

        public void b() {
            if (this.f35439g) {
                return;
            }
            synchronized (this) {
                if (this.f35439g) {
                    return;
                }
                if (this.f35435c) {
                    return;
                }
                a<T> aVar = this.f35434b;
                Lock lock = aVar.f35429d;
                lock.lock();
                this.f35440h = aVar.f35432g;
                Object obj = aVar.f35426a.get();
                lock.unlock();
                this.f35436d = obj != null;
                this.f35435c = true;
                if (obj == null || a(obj)) {
                    return;
                }
                c();
            }
        }

        public void c() {
            io.reactivex.internal.util.a<Object> aVar;
            while (!this.f35439g) {
                synchronized (this) {
                    aVar = this.f35437e;
                    if (aVar == null) {
                        this.f35436d = false;
                        return;
                    }
                    this.f35437e = null;
                }
                aVar.d(this);
            }
        }

        public void d(Object obj, long j10) {
            if (this.f35439g) {
                return;
            }
            if (!this.f35438f) {
                synchronized (this) {
                    if (this.f35439g) {
                        return;
                    }
                    if (this.f35440h == j10) {
                        return;
                    }
                    if (this.f35436d) {
                        io.reactivex.internal.util.a<Object> aVar = this.f35437e;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f35437e = aVar;
                        }
                        aVar.c(obj);
                        return;
                    }
                    this.f35435c = true;
                    this.f35438f = true;
                }
            }
            a(obj);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f35439g) {
                return;
            }
            this.f35439g = true;
            this.f35434b.u8(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35439g;
        }
    }

    public a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f35428c = reentrantReadWriteLock;
        this.f35429d = reentrantReadWriteLock.readLock();
        this.f35430e = reentrantReadWriteLock.writeLock();
        this.f35427b = new AtomicReference<>(f35424i);
        this.f35426a = new AtomicReference<>();
        this.f35431f = new AtomicReference<>();
    }

    @bj.c
    @e
    public static <T> a<T> o8() {
        return new a<>();
    }

    @bj.c
    @e
    public static <T> a<T> p8(T t10) {
        return new a<>(t10);
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        C0400a<T> c0400a = new C0400a<>(g0Var, this);
        g0Var.onSubscribe(c0400a);
        if (n8(c0400a)) {
            if (c0400a.f35439g) {
                u8(c0400a);
                return;
            } else {
                c0400a.b();
                return;
            }
        }
        Throwable th2 = this.f35431f.get();
        if (th2 == ExceptionHelper.f35249a) {
            g0Var.onComplete();
        } else {
            g0Var.onError(th2);
        }
    }

    @Override // io.reactivex.subjects.c
    @f
    public Throwable i8() {
        Object obj = this.f35426a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Override // io.reactivex.subjects.c
    public boolean j8() {
        return NotificationLite.isComplete(this.f35426a.get());
    }

    @Override // io.reactivex.subjects.c
    public boolean k8() {
        return this.f35427b.get().length != 0;
    }

    @Override // io.reactivex.subjects.c
    public boolean l8() {
        return NotificationLite.isError(this.f35426a.get());
    }

    public boolean n8(C0400a<T> c0400a) {
        C0400a<T>[] c0400aArr;
        C0400a<T>[] c0400aArr2;
        do {
            c0400aArr = this.f35427b.get();
            if (c0400aArr == f35425j) {
                return false;
            }
            int length = c0400aArr.length;
            c0400aArr2 = new C0400a[length + 1];
            System.arraycopy(c0400aArr, 0, c0400aArr2, 0, length);
            c0400aArr2[length] = c0400a;
        } while (!this.f35427b.compareAndSet(c0400aArr, c0400aArr2));
        return true;
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f35431f.compareAndSet(null, ExceptionHelper.f35249a)) {
            Object objComplete = NotificationLite.complete();
            for (C0400a<T> c0400a : x8(objComplete)) {
                c0400a.d(objComplete, this.f35432g);
            }
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f35431f.compareAndSet(null, th2)) {
            kj.a.Y(th2);
            return;
        }
        Object objError = NotificationLite.error(th2);
        for (C0400a<T> c0400a : x8(objError)) {
            c0400a.d(objError, this.f35432g);
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35431f.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t10);
        v8(next);
        for (C0400a<T> c0400a : this.f35427b.get()) {
            c0400a.d(next, this.f35432g);
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35431f.get() != null) {
            bVar.dispose();
        }
    }

    @f
    public T q8() {
        Object obj = this.f35426a.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] r8() {
        Object[] objArr = f35423h;
        Object[] objArrS8 = s8(objArr);
        return objArrS8 == objArr ? new Object[0] : objArrS8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public T[] s8(T[] tArr) {
        Object obj = this.f35426a.get();
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

    public boolean t8() {
        Object obj = this.f35426a.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    public void u8(C0400a<T> c0400a) {
        C0400a<T>[] c0400aArr;
        C0400a<T>[] c0400aArr2;
        do {
            c0400aArr = this.f35427b.get();
            int length = c0400aArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (c0400aArr[i11] == c0400a) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                c0400aArr2 = f35424i;
            } else {
                C0400a<T>[] c0400aArr3 = new C0400a[length - 1];
                System.arraycopy(c0400aArr, 0, c0400aArr3, 0, i10);
                System.arraycopy(c0400aArr, i10 + 1, c0400aArr3, i10, (length - i10) - 1);
                c0400aArr2 = c0400aArr3;
            }
        } while (!this.f35427b.compareAndSet(c0400aArr, c0400aArr2));
    }

    public void v8(Object obj) {
        this.f35430e.lock();
        this.f35432g++;
        this.f35426a.lazySet(obj);
        this.f35430e.unlock();
    }

    public int w8() {
        return this.f35427b.get().length;
    }

    public C0400a<T>[] x8(Object obj) {
        AtomicReference<C0400a<T>[]> atomicReference = this.f35427b;
        C0400a<T>[] c0400aArr = f35425j;
        C0400a<T>[] andSet = atomicReference.getAndSet(c0400aArr);
        if (andSet != c0400aArr) {
            v8(obj);
        }
        return andSet;
    }

    public a(T t10) {
        this();
        this.f35426a.lazySet(io.reactivex.internal.functions.a.g(t10, "defaultValue is null"));
    }
}
