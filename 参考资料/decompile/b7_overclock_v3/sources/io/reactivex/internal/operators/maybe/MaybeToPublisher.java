package io.reactivex.internal.operators.maybe;

/* JADX INFO: loaded from: classes5.dex */
public enum MaybeToPublisher implements dj.o<xi.w<Object>, bu.c<Object>> {
    INSTANCE;

    public static <T> dj.o<xi.w<T>, bu.c<T>> instance() {
        return INSTANCE;
    }

    @Override // dj.o
    public bu.c<Object> apply(xi.w<Object> wVar) throws Exception {
        return new MaybeToFlowable(wVar);
    }
}
