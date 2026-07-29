package io.objectbox.query;

import io.objectbox.query.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i0<T> implements h0<T> {
    @Override // io.objectbox.query.h0
    public h0<T> a(h0<T> h0Var) {
        return new d.a(this, (i0) h0Var);
    }

    @Override // io.objectbox.query.h0
    public h0<T> b(h0<T> h0Var) {
        return new d.b(this, (i0) h0Var);
    }

    public abstract void d(QueryBuilder<T> queryBuilder);
}
