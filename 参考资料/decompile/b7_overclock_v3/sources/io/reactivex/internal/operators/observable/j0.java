package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class j0<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f34557a;

    public static final class a<T> extends gj.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T[] f34559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f34560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f34562e;

        public a(xi.g0<? super T> g0Var, T[] tArr) {
            this.f34558a = g0Var;
            this.f34559b = tArr;
        }

        public void a() {
            T[] tArr = this.f34559b;
            int length = tArr.length;
            for (int i10 = 0; i10 < length && !isDisposed(); i10++) {
                T t10 = tArr[i10];
                if (t10 == null) {
                    this.f34558a.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                this.f34558a.onNext(t10);
            }
            if (isDisposed()) {
                return;
            }
            this.f34558a.onComplete();
        }

        @Override // fj.o
        public void clear() {
            this.f34560c = this.f34559b.length;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34562e = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34562e;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f34560c == this.f34559b.length;
        }

        @Override // fj.o
        @bj.f
        public T poll() {
            int i10 = this.f34560c;
            T[] tArr = this.f34559b;
            if (i10 == tArr.length) {
                return null;
            }
            this.f34560c = i10 + 1;
            return (T) io.reactivex.internal.functions.a.g(tArr[i10], "The array element is null");
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f34561d = true;
            return 1;
        }
    }

    public j0(T[] tArr) {
        this.f34557a = tArr;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        a aVar = new a(g0Var, this.f34557a);
        g0Var.onSubscribe(aVar);
        if (aVar.f34561d) {
            return;
        }
        aVar.a();
    }
}
