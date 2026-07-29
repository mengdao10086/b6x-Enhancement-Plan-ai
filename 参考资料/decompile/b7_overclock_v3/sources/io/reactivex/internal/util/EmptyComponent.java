package io.reactivex.internal.util;

import xi.g0;
import xi.l0;
import xi.t;

/* JADX INFO: loaded from: classes5.dex */
public enum EmptyComponent implements xi.o<Object>, g0<Object>, t<Object>, l0<Object>, xi.d, bu.e, io.reactivex.disposables.b {
    INSTANCE;

    public static <T> g0<T> asObserver() {
        return INSTANCE;
    }

    public static <T> bu.d<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // bu.e
    public void cancel() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }

    @Override // bu.d
    public void onComplete() {
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        kj.a.Y(th2);
    }

    @Override // bu.d
    public void onNext(Object obj) {
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        bVar.dispose();
    }

    @Override // xi.t
    public void onSuccess(Object obj) {
    }

    @Override // bu.e
    public void request(long j10) {
    }

    @Override // xi.o, bu.d
    public void onSubscribe(bu.e eVar) {
        eVar.cancel();
    }
}
