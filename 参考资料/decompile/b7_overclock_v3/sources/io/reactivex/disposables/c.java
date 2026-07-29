package io.reactivex.disposables;

import bj.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public c() {
        throw new IllegalStateException("No instances!");
    }

    @e
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    @e
    public static b b() {
        return f(Functions.f32980b);
    }

    @e
    public static b c(@e dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "run is null");
        return new ActionDisposable(aVar);
    }

    @e
    public static b d(@e Future<?> future) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        return e(future, true);
    }

    @e
    public static b e(@e Future<?> future, boolean z10) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        return new FutureDisposable(future, z10);
    }

    @e
    public static b f(@e Runnable runnable) {
        io.reactivex.internal.functions.a.g(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    @e
    public static b g(@e bu.e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "subscription is null");
        return new SubscriptionDisposable(eVar);
    }
}
