package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMaterialize<T> extends a<T, xi.y<T>> {

    public static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, xi.y<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        public MaterializeSubscriber(bu.d<? super xi.y<T>> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(xi.y<T> yVar) {
            if (yVar.g()) {
                kj.a.Y(yVar.d());
            }
        }

        @Override // bu.d
        public void onComplete() {
            a(xi.y.a());
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            a(xi.y.b(th2));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            this.produced++;
            this.downstream.onNext(xi.y.c(t10));
        }
    }

    public FlowableMaterialize(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super xi.y<T>> dVar) {
        this.f33524b.j6(new MaterializeSubscriber(dVar));
    }
}
