package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class w<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super T> f33777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.g<? super Throwable> f33778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.a f33779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.a f33780f;

    public static final class a<T> extends hj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.g<? super T> f33781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.g<? super Throwable> f33782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final dj.a f33783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final dj.a f33784i;

        public a(fj.a<? super T> aVar, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar2, dj.a aVar3) {
            super(aVar);
            this.f33781f = gVar;
            this.f33782g = gVar2;
            this.f33783h = aVar2;
            this.f33784i = aVar3;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            if (this.f31300d) {
                return false;
            }
            try {
                this.f33781f.accept(t10);
                return this.f31297a.m((Object) t10);
            } catch (Throwable th2) {
                c(th2);
                return false;
            }
        }

        @Override // hj.a, bu.d
        public void onComplete() {
            if (this.f31300d) {
                return;
            }
            try {
                this.f33783h.run();
                this.f31300d = true;
                this.f31297a.onComplete();
                try {
                    this.f33784i.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            } catch (Throwable th3) {
                c(th3);
            }
        }

        @Override // hj.a, bu.d
        public void onError(Throwable th2) {
            if (this.f31300d) {
                kj.a.Y(th2);
                return;
            }
            boolean z10 = true;
            this.f31300d = true;
            try {
                this.f33782g.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f31297a.onError(new CompositeException(th2, th3));
                z10 = false;
            }
            if (z10) {
                this.f31297a.onError(th2);
            }
            try {
                this.f33784i.run();
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                kj.a.Y(th4);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f31300d) {
                return;
            }
            if (this.f31301e != 0) {
                this.f31297a.onNext(null);
                return;
            }
            try {
                this.f33781f.accept(t10);
                this.f31297a.onNext((Object) t10);
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            try {
                T tPoll = this.f31299c.poll();
                if (tPoll != null) {
                    try {
                        this.f33781f.accept(tPoll);
                    } catch (Throwable th2) {
                        try {
                            io.reactivex.exceptions.a.b(th2);
                            try {
                                this.f33782g.accept(th2);
                                throw ExceptionHelper.d(th2);
                            } catch (Throwable th3) {
                                throw new CompositeException(th2, th3);
                            }
                        } finally {
                            this.f33784i.run();
                        }
                    }
                } else if (this.f31301e == 1) {
                    this.f33783h.run();
                }
                return tPoll;
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                try {
                    this.f33782g.accept(th4);
                    throw ExceptionHelper.d(th4);
                } catch (Throwable th5) {
                    throw new CompositeException(th4, th5);
                }
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public static final class b<T> extends hj.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.g<? super T> f33785f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.g<? super Throwable> f33786g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final dj.a f33787h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final dj.a f33788i;

        public b(bu.d<? super T> dVar, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2) {
            super(dVar);
            this.f33785f = gVar;
            this.f33786g = gVar2;
            this.f33787h = aVar;
            this.f33788i = aVar2;
        }

        @Override // hj.b, bu.d
        public void onComplete() {
            if (this.f31305d) {
                return;
            }
            try {
                this.f33787h.run();
                this.f31305d = true;
                this.f31302a.onComplete();
                try {
                    this.f33788i.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            } catch (Throwable th3) {
                c(th3);
            }
        }

        @Override // hj.b, bu.d
        public void onError(Throwable th2) {
            if (this.f31305d) {
                kj.a.Y(th2);
                return;
            }
            boolean z10 = true;
            this.f31305d = true;
            try {
                this.f33786g.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f31302a.onError(new CompositeException(th2, th3));
                z10 = false;
            }
            if (z10) {
                this.f31302a.onError(th2);
            }
            try {
                this.f33788i.run();
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                kj.a.Y(th4);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f31305d) {
                return;
            }
            if (this.f31306e != 0) {
                this.f31302a.onNext(null);
                return;
            }
            try {
                this.f33785f.accept(t10);
                this.f31302a.onNext((Object) t10);
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            try {
                T tPoll = this.f31304c.poll();
                if (tPoll != null) {
                    try {
                        this.f33785f.accept(tPoll);
                    } catch (Throwable th2) {
                        try {
                            io.reactivex.exceptions.a.b(th2);
                            try {
                                this.f33786g.accept(th2);
                                throw ExceptionHelper.d(th2);
                            } catch (Throwable th3) {
                                throw new CompositeException(th2, th3);
                            }
                        } finally {
                            this.f33788i.run();
                        }
                    }
                } else if (this.f31306e == 1) {
                    this.f33787h.run();
                }
                return tPoll;
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                try {
                    this.f33786g.accept(th4);
                    throw ExceptionHelper.d(th4);
                } catch (Throwable th5) {
                    throw new CompositeException(th4, th5);
                }
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public w(xi.j<T> jVar, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2) {
        super(jVar);
        this.f33777c = gVar;
        this.f33778d = gVar2;
        this.f33779e = aVar;
        this.f33780f = aVar2;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new a((fj.a) dVar, this.f33777c, this.f33778d, this.f33779e, this.f33780f));
        } else {
            this.f33524b.j6(new b(dVar, this.f33777c, this.f33778d, this.f33779e, this.f33780f));
        }
    }
}
