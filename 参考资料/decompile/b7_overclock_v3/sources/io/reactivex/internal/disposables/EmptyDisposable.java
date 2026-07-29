package io.reactivex.internal.disposables;

import bj.f;
import fj.j;
import xi.d;
import xi.g0;
import xi.l0;
import xi.t;

/* JADX INFO: loaded from: classes5.dex */
public enum EmptyDisposable implements j<Object> {
    INSTANCE,
    NEVER;

    public static void complete(g0<?> g0Var) {
        g0Var.onSubscribe(INSTANCE);
        g0Var.onComplete();
    }

    public static void error(Throwable th2, g0<?> g0Var) {
        g0Var.onSubscribe(INSTANCE);
        g0Var.onError(th2);
    }

    @Override // fj.o
    public void clear() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // fj.o
    public boolean isEmpty() {
        return true;
    }

    @Override // fj.o
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // fj.o
    @f
    public Object poll() throws Exception {
        return null;
    }

    @Override // fj.k
    public int requestFusion(int i10) {
        return i10 & 2;
    }

    @Override // fj.o
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(t<?> tVar) {
        tVar.onSubscribe(INSTANCE);
        tVar.onComplete();
    }

    public static void error(Throwable th2, d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onError(th2);
    }

    public static void complete(d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    public static void error(Throwable th2, l0<?> l0Var) {
        l0Var.onSubscribe(INSTANCE);
        l0Var.onError(th2);
    }

    public static void error(Throwable th2, t<?> tVar) {
        tVar.onSubscribe(INSTANCE);
        tVar.onError(th2);
    }
}
