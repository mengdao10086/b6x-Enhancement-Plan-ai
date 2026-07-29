package io.reactivex.internal.operators.maybe;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> extends xi.q<R> implements fj.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33914a;

    public a(xi.w<T> wVar) {
        this.f33914a = wVar;
    }

    @Override // fj.f
    public final xi.w<T> source() {
        return this.f33914a;
    }
}
