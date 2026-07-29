package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes5.dex */
public final class h {
    public h() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(bu.c<? extends T> cVar) {
        io.reactivex.internal.util.d dVar = new io.reactivex.internal.util.d();
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.h(), dVar, dVar, Functions.f32990l);
        cVar.d(lambdaSubscriber);
        io.reactivex.internal.util.c.a(dVar, lambdaSubscriber);
        Throwable th2 = dVar.f35255a;
        if (th2 != null) {
            throw ExceptionHelper.f(th2);
        }
    }

    public static <T> void b(bu.c<? extends T> cVar, bu.d<? super T> dVar) {
        Object objPoll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        cVar.d(blockingSubscriber);
        do {
            try {
                if (blockingSubscriber.a()) {
                    return;
                }
                objPoll = linkedBlockingQueue.poll();
                if (objPoll == null) {
                    if (blockingSubscriber.a()) {
                        return;
                    }
                    io.reactivex.internal.util.c.b();
                    objPoll = linkedBlockingQueue.take();
                }
                if (blockingSubscriber.a() || objPoll == BlockingSubscriber.f35235a) {
                    return;
                }
            } catch (InterruptedException e10) {
                blockingSubscriber.cancel();
                dVar.onError(e10);
                return;
            }
        } while (!NotificationLite.acceptFull(objPoll, dVar));
    }

    public static <T> void c(bu.c<? extends T> cVar, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        b(cVar, new LambdaSubscriber(gVar, gVar2, aVar, Functions.f32990l));
    }

    public static <T> void d(bu.c<? extends T> cVar, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, int i10) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.h(i10, "number > 0 required");
        b(cVar, new BoundedSubscriber(gVar, gVar2, aVar, Functions.d(i10), i10));
    }
}
