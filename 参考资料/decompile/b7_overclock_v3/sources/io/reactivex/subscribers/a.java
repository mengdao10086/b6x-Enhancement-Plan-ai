package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.f;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> implements o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bu.e f35450a;

    public final void a() {
        bu.e eVar = this.f35450a;
        this.f35450a = SubscriptionHelper.CANCELLED;
        eVar.cancel();
    }

    public void b() {
        c(Long.MAX_VALUE);
    }

    public final void c(long j10) {
        bu.e eVar = this.f35450a;
        if (eVar != null) {
            eVar.request(j10);
        }
    }

    @Override // xi.o, bu.d
    public final void onSubscribe(bu.e eVar) {
        if (f.e(this.f35450a, eVar, getClass())) {
            this.f35450a = eVar;
            b();
        }
    }
}
