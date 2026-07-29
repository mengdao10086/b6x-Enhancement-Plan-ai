package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRangeLong extends xi.z<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34272b;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        public final xi.g0<? super Long> downstream;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(xi.g0<? super Long> g0Var, long j10, long j11) {
            this.downstream = g0Var;
            this.index = j10;
            this.end = j11;
        }

        @Override // fj.o
        @bj.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long poll() throws Exception {
            long j10 = this.index;
            if (j10 != this.end) {
                this.index = 1 + j10;
                return Long.valueOf(j10);
            }
            lazySet(1);
            return null;
        }

        @Override // fj.o
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        public void run() {
            if (this.fused) {
                return;
            }
            xi.g0<? super Long> g0Var = this.downstream;
            long j10 = this.end;
            for (long j11 = this.index; j11 != j10 && get() == 0; j11++) {
                g0Var.onNext(Long.valueOf(j11));
            }
            if (get() == 0) {
                lazySet(1);
                g0Var.onComplete();
            }
        }
    }

    public ObservableRangeLong(long j10, long j11) {
        this.f34271a = j10;
        this.f34272b = j11;
    }

    @Override // xi.z
    public void I5(xi.g0<? super Long> g0Var) {
        long j10 = this.f34271a;
        RangeDisposable rangeDisposable = new RangeDisposable(g0Var, j10, j10 + this.f34272b);
        g0Var.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
