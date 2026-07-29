package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRange extends xi.z<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34270b;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        public final xi.g0<? super Integer> downstream;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(xi.g0<? super Integer> g0Var, long j10, long j11) {
            this.downstream = g0Var;
            this.index = j10;
            this.end = j11;
        }

        @Override // fj.o
        @bj.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer poll() throws Exception {
            long j10 = this.index;
            if (j10 != this.end) {
                this.index = 1 + j10;
                return Integer.valueOf((int) j10);
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
            xi.g0<? super Integer> g0Var = this.downstream;
            long j10 = this.end;
            for (long j11 = this.index; j11 != j10 && get() == 0; j11++) {
                g0Var.onNext(Integer.valueOf((int) j11));
            }
            if (get() == 0) {
                lazySet(1);
                g0Var.onComplete();
            }
        }
    }

    public ObservableRange(int i10, int i11) {
        this.f34269a = i10;
        this.f34270b = ((long) i10) + ((long) i11);
    }

    @Override // xi.z
    public void I5(xi.g0<? super Integer> g0Var) {
        RangeDisposable rangeDisposable = new RangeDisposable(g0Var, this.f34269a, this.f34270b);
        g0Var.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
