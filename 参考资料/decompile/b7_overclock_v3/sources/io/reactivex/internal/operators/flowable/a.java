package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> extends xi.j<R> implements fj.h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.j<T> f33524b;

    public a(xi.j<T> jVar) {
        this.f33524b = (xi.j) io.reactivex.internal.functions.a.g(jVar, "source is null");
    }

    @Override // fj.h
    public final bu.c<T> source() {
        return this.f33524b;
    }
}
