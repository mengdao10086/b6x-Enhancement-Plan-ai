package io.reactivex.internal.subscriptions;

import bu.e;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class SubscriptionArbiter extends AtomicInteger implements e {
    private static final long serialVersionUID = -2189523197179400958L;
    public e actual;
    public final boolean cancelOnReplace;
    public volatile boolean cancelled;
    public long requested;
    public boolean unbounded;
    public final AtomicReference<e> missedSubscription = new AtomicReference<>();
    public final AtomicLong missedRequested = new AtomicLong();
    public final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean z10) {
        this.cancelOnReplace = z10;
    }

    final void c() {
        if (getAndIncrement() != 0) {
            return;
        }
        d();
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        c();
    }

    final void d() {
        int iAddAndGet = 1;
        e eVar = null;
        long jC = 0;
        do {
            e andSet = this.missedSubscription.get();
            if (andSet != null) {
                andSet = this.missedSubscription.getAndSet(null);
            }
            long andSet2 = this.missedRequested.get();
            if (andSet2 != 0) {
                andSet2 = this.missedRequested.getAndSet(0L);
            }
            long andSet3 = this.missedProduced.get();
            if (andSet3 != 0) {
                andSet3 = this.missedProduced.getAndSet(0L);
            }
            e eVar2 = this.actual;
            if (this.cancelled) {
                if (eVar2 != null) {
                    eVar2.cancel();
                    this.actual = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
            } else {
                long jC2 = this.requested;
                if (jC2 != Long.MAX_VALUE) {
                    jC2 = b.c(jC2, andSet2);
                    if (jC2 != Long.MAX_VALUE) {
                        jC2 -= andSet3;
                        if (jC2 < 0) {
                            SubscriptionHelper.reportMoreProduced(jC2);
                            jC2 = 0;
                        }
                    }
                    this.requested = jC2;
                }
                if (andSet != null) {
                    if (eVar2 != null && this.cancelOnReplace) {
                        eVar2.cancel();
                    }
                    this.actual = andSet;
                    if (jC2 != 0) {
                        jC = b.c(jC, jC2);
                        eVar = andSet;
                    }
                } else if (eVar2 != null && andSet2 != 0) {
                    jC = b.c(jC, andSet2);
                    eVar = eVar2;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jC != 0) {
            eVar.request(jC);
        }
    }

    public final boolean f() {
        return this.cancelled;
    }

    public final boolean h() {
        return this.unbounded;
    }

    public final void i(long j10) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            b.a(this.missedProduced, j10);
            c();
            return;
        }
        long j11 = this.requested;
        if (j11 != Long.MAX_VALUE) {
            long j12 = j11 - j10;
            if (j12 < 0) {
                SubscriptionHelper.reportMoreProduced(j12);
                j12 = 0;
            }
            this.requested = j12;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        d();
    }

    public final void k(e eVar) {
        if (this.cancelled) {
            eVar.cancel();
            return;
        }
        a.g(eVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            e andSet = this.missedSubscription.getAndSet(eVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            c();
            return;
        }
        e eVar2 = this.actual;
        if (eVar2 != null && this.cancelOnReplace) {
            eVar2.cancel();
        }
        this.actual = eVar;
        long j10 = this.requested;
        if (decrementAndGet() != 0) {
            d();
        }
        if (j10 != 0) {
            eVar.request(j10);
        }
    }

    @Override // bu.e
    public final void request(long j10) {
        if (!SubscriptionHelper.validate(j10) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            b.a(this.missedRequested, j10);
            c();
            return;
        }
        long j11 = this.requested;
        if (j11 != Long.MAX_VALUE) {
            long jC = b.c(j11, j10);
            this.requested = jC;
            if (jC == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        e eVar = this.actual;
        if (decrementAndGet() != 0) {
            d();
        }
        if (eVar != null) {
            eVar.request(j10);
        }
    }
}
