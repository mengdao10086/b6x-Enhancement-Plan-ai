package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class r<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.y<R>> f33735c;

    public static final class a<T, R> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super R> f33736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.y<R>> f33737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f33738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33739d;

        public a(bu.d<? super R> dVar, dj.o<? super T, ? extends xi.y<R>> oVar) {
            this.f33736a = dVar;
            this.f33737b = oVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33739d.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33738c) {
                return;
            }
            this.f33738c = true;
            this.f33736a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33738c) {
                kj.a.Y(th2);
            } else {
                this.f33738c = true;
                this.f33736a.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33738c) {
                if (t10 instanceof xi.y) {
                    xi.y yVar = (xi.y) t10;
                    if (yVar.g()) {
                        kj.a.Y(yVar.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                xi.y yVar2 = (xi.y) io.reactivex.internal.functions.a.g(this.f33737b.apply(t10), "The selector returned a null Notification");
                if (yVar2.g()) {
                    this.f33739d.cancel();
                    onError(yVar2.d());
                } else if (!yVar2.f()) {
                    this.f33736a.onNext((Object) yVar2.e());
                } else {
                    this.f33739d.cancel();
                    onComplete();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33739d.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33739d, eVar)) {
                this.f33739d = eVar;
                this.f33736a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33739d.request(j10);
        }
    }

    public r(xi.j<T> jVar, dj.o<? super T, ? extends xi.y<R>> oVar) {
        super(jVar);
        this.f33735c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f33524b.j6(new a(dVar, this.f33735c));
    }
}
