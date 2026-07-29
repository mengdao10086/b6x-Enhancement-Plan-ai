package io.reactivex.processors;

import bj.c;
import bj.f;
import bu.d;
import bu.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class PublishProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PublishSubscription[] f35337d = new PublishSubscription[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PublishSubscription[] f35338e = new PublishSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<PublishSubscription<T>[]> f35339b = new AtomicReference<>(f35338e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f35340c;

    public static final class PublishSubscription<T> extends AtomicLong implements e {
        private static final long serialVersionUID = 3562861878281475070L;
        public final d<? super T> downstream;
        public final PublishProcessor<T> parent;

        public PublishSubscription(d<? super T> dVar, PublishProcessor<T> publishProcessor) {
            this.downstream = dVar;
            this.parent = publishProcessor;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        public boolean b() {
            return get() == 0;
        }

        public void c() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        @Override // bu.e
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.U8(this);
            }
        }

        public void d(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th2);
            } else {
                kj.a.Y(th2);
            }
        }

        public void f(T t10) {
            long j10 = get();
            if (j10 == Long.MIN_VALUE) {
                return;
            }
            if (j10 != 0) {
                this.downstream.onNext(t10);
                io.reactivex.internal.util.b.f(this, 1L);
            } else {
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.b(this, j10);
            }
        }
    }

    @c
    @bj.e
    public static <T> PublishProcessor<T> S8() {
        return new PublishProcessor<>();
    }

    @Override // io.reactivex.processors.a
    @f
    public Throwable M8() {
        if (this.f35339b.get() == f35337d) {
            return this.f35340c;
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        return this.f35339b.get() == f35337d && this.f35340c == null;
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35339b.get().length != 0;
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        return this.f35339b.get() == f35337d && this.f35340c != null;
    }

    public boolean R8(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription<T>[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.f35339b.get();
            if (publishSubscriptionArr == f35337d) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[length + 1];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!this.f35339b.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    public boolean T8(T t10) {
        if (t10 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        PublishSubscription<T>[] publishSubscriptionArr = this.f35339b.get();
        for (PublishSubscription<T> publishSubscription : publishSubscriptionArr) {
            if (publishSubscription.b()) {
                return false;
            }
        }
        for (PublishSubscription<T> publishSubscription2 : publishSubscriptionArr) {
            publishSubscription2.f(t10);
        }
        return true;
    }

    public void U8(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription<T>[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.f35339b.get();
            if (publishSubscriptionArr == f35337d || publishSubscriptionArr == f35338e) {
                return;
            }
            int length = publishSubscriptionArr.length;
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (publishSubscriptionArr[i11] == publishSubscription) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                publishSubscriptionArr2 = f35338e;
            } else {
                PublishSubscription<T>[] publishSubscriptionArr3 = new PublishSubscription[length - 1];
                System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i10);
                System.arraycopy(publishSubscriptionArr, i10 + 1, publishSubscriptionArr3, i10, (length - i10) - 1);
                publishSubscriptionArr2 = publishSubscriptionArr3;
            }
        } while (!this.f35339b.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
    }

    @Override // xi.j
    public void k6(d<? super T> dVar) {
        PublishSubscription<T> publishSubscription = new PublishSubscription<>(dVar, this);
        dVar.onSubscribe(publishSubscription);
        if (R8(publishSubscription)) {
            if (publishSubscription.a()) {
                U8(publishSubscription);
            }
        } else {
            Throwable th2 = this.f35340c;
            if (th2 != null) {
                dVar.onError(th2);
            } else {
                dVar.onComplete();
            }
        }
    }

    @Override // bu.d
    public void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.f35339b.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f35337d;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            return;
        }
        for (PublishSubscription<T> publishSubscription : this.f35339b.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.c();
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArr = this.f35339b.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f35337d;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            kj.a.Y(th2);
            return;
        }
        this.f35340c = th2;
        for (PublishSubscription<T> publishSubscription : this.f35339b.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.d(th2);
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubscription<T> publishSubscription : this.f35339b.get()) {
            publishSubscription.f(t10);
        }
    }

    @Override // bu.d
    public void onSubscribe(e eVar) {
        if (this.f35339b.get() == f35337d) {
            eVar.cancel();
        } else {
            eVar.request(Long.MAX_VALUE);
        }
    }
}
