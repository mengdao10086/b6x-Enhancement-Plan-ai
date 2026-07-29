package io.reactivex.internal.operators.observable;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes5.dex */
public final class j {
    public j() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(xi.e0<? extends T> e0Var) {
        io.reactivex.internal.util.d dVar = new io.reactivex.internal.util.d();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.h(), dVar, dVar, Functions.h());
        e0Var.c(lambdaObserver);
        io.reactivex.internal.util.c.a(dVar, lambdaObserver);
        Throwable th2 = dVar.f35255a;
        if (th2 != null) {
            throw ExceptionHelper.f(th2);
        }
    }

    public static <T> void b(xi.e0<? extends T> e0Var, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        c(e0Var, new LambdaObserver(gVar, gVar2, aVar, Functions.h()));
    }

    public static <T> void c(xi.e0<? extends T> e0Var, xi.g0<? super T> g0Var) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        g0Var.onSubscribe(blockingObserver);
        e0Var.c(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e10) {
                    blockingObserver.dispose();
                    g0Var.onError(e10);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || objPoll == BlockingObserver.f33021a || NotificationLite.acceptFull(objPoll, g0Var)) {
                return;
            }
        }
    }
}
