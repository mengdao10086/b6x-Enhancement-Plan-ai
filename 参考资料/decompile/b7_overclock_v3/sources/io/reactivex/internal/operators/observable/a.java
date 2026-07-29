package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, U> extends xi.z<U> implements fj.g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34421a;

    public a(xi.e0<T> e0Var) {
        this.f34421a = e0Var;
    }

    @Override // fj.g
    public final xi.e0<T> source() {
        return this.f34421a;
    }
}
