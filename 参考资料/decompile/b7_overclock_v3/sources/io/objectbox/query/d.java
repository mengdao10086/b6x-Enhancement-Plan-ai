package io.objectbox.query;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0<T> f32866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0<T> f32867b;

    public static class a<T> extends d<T> {
        public a(i0<T> i0Var, i0<T> i0Var2) {
            super(i0Var, i0Var2);
        }

        @Override // io.objectbox.query.d
        public void e(QueryBuilder<T> queryBuilder, long j10, long j11) {
            queryBuilder.K(j10, j11);
        }
    }

    public static class b<T> extends d<T> {
        public b(i0<T> i0Var, i0<T> i0Var2) {
            super(i0Var, i0Var2);
        }

        @Override // io.objectbox.query.d
        public void e(QueryBuilder<T> queryBuilder, long j10, long j11) {
            queryBuilder.M(j10, j11);
        }
    }

    public d(i0<T> i0Var, i0<T> i0Var2) {
        this.f32866a = i0Var;
        this.f32867b = i0Var2;
    }

    @Override // io.objectbox.query.i0
    public void d(QueryBuilder<T> queryBuilder) {
        this.f32866a.d(queryBuilder);
        long jL = queryBuilder.L();
        this.f32867b.d(queryBuilder);
        e(queryBuilder, jL, queryBuilder.L());
    }

    public abstract void e(QueryBuilder<T> queryBuilder, long j10, long j11);
}
