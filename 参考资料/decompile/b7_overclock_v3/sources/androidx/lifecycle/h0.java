package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class h0<T> extends j0<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o.b<LiveData<?>, a<?>> f6204m;

    public static class a<V> implements k0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveData<V> f6205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k0<? super V> f6206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6207c = -1;

        public a(LiveData<V> liveData, k0<? super V> k0Var) {
            this.f6205a = liveData;
            this.f6206b = k0Var;
        }

        public void a() {
            this.f6205a.l(this);
        }

        @Override // androidx.lifecycle.k0
        public void b(@g.p0 V v10) {
            if (this.f6207c != this.f6205a.g()) {
                this.f6207c = this.f6205a.g();
                this.f6206b.b(v10);
            }
        }

        public void c() {
            this.f6205a.p(this);
        }
    }

    public h0() {
        this.f6204m = new o.b<>();
    }

    @Override // androidx.lifecycle.LiveData
    @g.i
    public void m() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it2 = this.f6204m.iterator();
        while (it2.hasNext()) {
            it2.next().getValue().a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @g.i
    public void n() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it2 = this.f6204m.iterator();
        while (it2.hasNext()) {
            it2.next().getValue().c();
        }
    }

    @g.k0
    public <S> void s(@g.n0 LiveData<S> liveData, @g.n0 k0<? super S> k0Var) {
        Objects.requireNonNull(liveData, "source cannot be null");
        a<?> aVar = new a<>(liveData, k0Var);
        a<?> aVarG = this.f6204m.g(liveData, aVar);
        if (aVarG != null && aVarG.f6206b != k0Var) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVarG == null && h()) {
            aVar.a();
        }
    }

    @g.k0
    public <S> void t(@g.n0 LiveData<S> liveData) {
        a<?> aVarI = this.f6204m.i(liveData);
        if (aVarI != null) {
            aVarI.c();
        }
    }

    public h0(T t10) {
        super(t10);
        this.f6204m = new o.b<>();
    }
}
