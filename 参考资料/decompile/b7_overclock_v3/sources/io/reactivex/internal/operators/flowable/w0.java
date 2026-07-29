package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class w0 {

    public static final class a<T, R> extends xi.j<R> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f33789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.o<? super T, ? extends bu.c<? extends R>> f33790c;

        public a(T t10, dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
            this.f33789b = t10;
            this.f33790c = oVar;
        }

        @Override // xi.j
        public void k6(bu.d<? super R> dVar) {
            try {
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.f33790c.apply(this.f33789b), "The mapper returned a null Publisher");
                if (!(cVar instanceof Callable)) {
                    cVar.d(dVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) cVar).call();
                    if (objCall == null) {
                        EmptySubscription.complete(dVar);
                    } else {
                        dVar.onSubscribe(new ScalarSubscription(dVar, objCall));
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    EmptySubscription.error(th2, dVar);
                }
            } catch (Throwable th3) {
                EmptySubscription.error(th3, dVar);
            }
        }
    }

    public w0() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> xi.j<U> a(T t10, dj.o<? super T, ? extends bu.c<? extends U>> oVar) {
        return kj.a.S(new a(t10, oVar));
    }

    public static <T, R> boolean b(bu.c<T> cVar, bu.d<? super R> dVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        if (!(cVar instanceof Callable)) {
            return false;
        }
        try {
            a0.b bVar = (Object) ((Callable) cVar).call();
            if (bVar == null) {
                EmptySubscription.complete(dVar);
                return true;
            }
            try {
                bu.c cVar2 = (bu.c) io.reactivex.internal.functions.a.g(oVar.apply(bVar), "The mapper returned a null Publisher");
                if (cVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) cVar2).call();
                        if (objCall == null) {
                            EmptySubscription.complete(dVar);
                            return true;
                        }
                        dVar.onSubscribe(new ScalarSubscription(dVar, objCall));
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        EmptySubscription.error(th2, dVar);
                        return true;
                    }
                } else {
                    cVar2.d(dVar);
                }
                return true;
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                EmptySubscription.error(th3, dVar);
                return true;
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            EmptySubscription.error(th4, dVar);
            return true;
        }
    }
}
