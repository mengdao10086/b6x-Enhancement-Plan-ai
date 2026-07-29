package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> implements o<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<bu.e> f35452a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ej.b f35453b = new ej.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f35454c = new AtomicLong();

    public final void a(io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "resource is null");
        this.f35453b.b(bVar);
    }

    public void b() {
        c(Long.MAX_VALUE);
    }

    public final void c(long j10) {
        SubscriptionHelper.deferredRequest(this.f35452a, this.f35454c, j10);
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (SubscriptionHelper.cancel(this.f35452a)) {
            this.f35453b.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f35452a.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // xi.o, bu.d
    public final void onSubscribe(bu.e eVar) {
        if (f.c(this.f35452a, eVar, getClass())) {
            long andSet = this.f35454c.getAndSet(0L);
            if (andSet != 0) {
                eVar.request(andSet);
            }
            b();
        }
    }
}
