package io.objectbox.query;

import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.io.Closeable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class Query<T> implements Closeable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f32829i = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ii.a<T> f32830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BoxStore f32831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0<T> f32832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final List<a<T, ?>> f32833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final k0<T> f32834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Comparator<T> f32835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f32836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f32837h;

    public Query(ii.a<T> aVar, long j10, @Nullable List<a<T, ?>> list, @Nullable k0<T> k0Var, @Nullable Comparator<T> comparator) {
        this.f32830a = aVar;
        BoxStore boxStoreW = aVar.w();
        this.f32831b = boxStoreW;
        this.f32836g = boxStoreW.k2();
        this.f32837h = j10;
        this.f32832c = new m0<>(this, aVar);
        this.f32833d = list;
        this.f32834e = k0Var;
        this.f32835f = comparator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void C1(j0 j0Var) {
        c cVar = new c(this.f32830a, F0(), false);
        int size = cVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = cVar.get(i10);
            if (obj == null) {
                throw new IllegalStateException("Internal error: data object was null");
            }
            k0<T> k0Var = this.f32834e;
            if (k0Var == null || k0Var.a((T) obj)) {
                if (this.f32833d != null) {
                    j2(obj, i10);
                }
                try {
                    j0Var.accept(obj);
                } catch (BreakForEach unused) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long L1(long j10) {
        return Long.valueOf(nativeRemove(this.f32837h, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long k1(long j10) {
        return Long.valueOf(nativeCount(this.f32837h, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List m1() throws Exception {
        List<T> listNativeFind = nativeFind(this.f32837h, z(), 0L, 0L);
        if (this.f32834e != null) {
            Iterator<T> it2 = listNativeFind.iterator();
            while (it2.hasNext()) {
                if (!this.f32834e.a(it2.next())) {
                    it2.remove();
                }
            }
        }
        k2(listNativeFind);
        Comparator<T> comparator = this.f32835f;
        if (comparator != null) {
            Collections.sort(listNativeFind, comparator);
        }
        return listNativeFind;
    }

    private native void nativeSetParameters(long j10, int i10, int i11, @Nullable String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List p1(long j10, long j11) throws Exception {
        List<T> listNativeFind = nativeFind(this.f32837h, z(), j10, j11);
        k2(listNativeFind);
        return listNativeFind;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object s1() throws Exception {
        Object objNativeFindFirst = nativeFindFirst(this.f32837h, z());
        h2(objNativeFindFirst);
        return objNativeFindFirst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long[] u1(long j10, long j11, long j12) {
        return nativeFindIds(this.f32837h, j12, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object z1() throws Exception {
        Object objNativeFindUnique = nativeFindUnique(this.f32837h, z());
        h2(objNativeFindUnique);
        return objNativeFindUnique;
    }

    public Query<T> A2(Property<?> property, int[] iArr) {
        n();
        nativeSetParameters(this.f32837h, property.getEntityId(), property.C(), (String) null, iArr);
        return this;
    }

    public Query<T> B2(Property<?> property, long[] jArr) {
        n();
        nativeSetParameters(this.f32837h, property.getEntityId(), property.C(), (String) null, jArr);
        return this;
    }

    public Query<T> C2(Property<?> property, String[] strArr) {
        n();
        nativeSetParameters(this.f32837h, property.getEntityId(), property.C(), (String) null, strArr);
        return this;
    }

    public Query<T> D2(String str, double d10, double d11) {
        n();
        nativeSetParameters(this.f32837h, 0, 0, str, d10, d11);
        return this;
    }

    public Query<T> E2(String str, long j10, long j11) {
        n();
        nativeSetParameters(this.f32837h, 0, 0, str, j10, j11);
        return this;
    }

    @Nonnull
    public long[] F0() {
        return G0(0L, 0L);
    }

    public Query<T> F2(String str, String str2, String str3) {
        n();
        nativeSetParameters(this.f32837h, 0, 0, str, str2, str3);
        return this;
    }

    @Nonnull
    public long[] G0(final long j10, final long j11) {
        n();
        return (long[]) this.f32830a.y(new ni.a() { // from class: io.objectbox.query.g0
            @Override // ni.a
            public final Object a(long j12) {
                return this.f32880a.u1(j10, j11, j12);
            }
        });
    }

    public Query<T> G2(String str, int[] iArr) {
        n();
        nativeSetParameters(this.f32837h, 0, 0, str, iArr);
        return this;
    }

    public Query<T> H2(String str, long[] jArr) {
        n();
        nativeSetParameters(this.f32837h, 0, 0, str, jArr);
        return this;
    }

    public String I() {
        n();
        return nativeToString(this.f32837h);
    }

    public Query<T> I2(String str, String[] strArr) {
        n();
        nativeSetParameters(this.f32837h, 0, 0, str, strArr);
        return this;
    }

    public pi.m<List<T>> J2() {
        n();
        return new pi.m<>(this.f32832c, null);
    }

    public pi.m<List<T>> K2(pi.f fVar) {
        pi.m<List<T>> mVarJ2 = J2();
        mVarJ2.e(fVar);
        return mVarJ2;
    }

    public String L() {
        n();
        return nativeDescribeParameters(this.f32837h);
    }

    public final void M() {
        if (this.f32835f != null) {
            throw new UnsupportedOperationException("Does not work with a sorting comparator. Only find() supports sorting with a comparator.");
        }
    }

    @Nonnull
    public c<T> M0() {
        T();
        return new c<>(this.f32830a, F0(), false);
    }

    public final void P() {
        if (this.f32834e != null) {
            throw new UnsupportedOperationException("Does not work with a filter. Only find() and forEach() support filters.");
        }
    }

    public final void T() {
        P();
        M();
    }

    public PropertyQuery V1(Property<T> property) {
        return new PropertyQuery(this, property);
    }

    @Nonnull
    public List<T> W() {
        return (List) m(new Callable() { // from class: io.objectbox.query.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32855a.m1();
            }
        });
    }

    public void Y1() {
        this.f32832c.f();
    }

    @Nonnull
    public List<T> Z(final long j10, final long j11) {
        T();
        return (List) m(new Callable() { // from class: io.objectbox.query.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32868a.p1(j10, j11);
            }
        });
    }

    @Nullable
    public T b0() {
        T();
        return (T) m(new Callable() { // from class: io.objectbox.query.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32857a.s1();
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f32837h != 0) {
            long j10 = this.f32837h;
            this.f32837h = 0L;
            nativeDestroy(j10);
        }
    }

    @Nonnull
    public c<T> d1() {
        T();
        return new c<>(this.f32830a, F0(), true);
    }

    public long f2() {
        n();
        P();
        return ((Long) this.f32830a.z(new ni.a() { // from class: io.objectbox.query.f0
            @Override // ni.a
            public final Object a(long j10) {
                return this.f32878a.L1(j10);
            }
        })).longValue();
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Nullable
    public T h1() {
        P();
        return (T) m(new Callable() { // from class: io.objectbox.query.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32865a.z1();
            }
        });
    }

    public void h2(@Nullable T t10) {
        List<a<T, ?>> list = this.f32833d;
        if (list == null || t10 == null) {
            return;
        }
        Iterator<a<T, ?>> it2 = list.iterator();
        while (it2.hasNext()) {
            i2(t10, it2.next());
        }
    }

    public void i1(final j0<T> j0Var) {
        M();
        n();
        this.f32830a.w().C2(new Runnable() { // from class: io.objectbox.query.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f32909a.C1(j0Var);
            }
        });
    }

    public void i2(@Nonnull T t10, a<T, ?> aVar) {
        if (this.f32833d != null) {
            RelationInfo<T, ?> relationInfo = aVar.f32854b;
            ToOneGetter<T> toOneGetter = relationInfo.toOneGetter;
            if (toOneGetter != null) {
                ToOne<TARGET> toOneJ0 = toOneGetter.j0(t10);
                if (toOneJ0 != 0) {
                    toOneJ0.h();
                    return;
                }
                return;
            }
            ToManyGetter<T> toManyGetter = relationInfo.toManyGetter;
            if (toManyGetter == null) {
                throw new IllegalStateException("Relation info without relation getter: " + relationInfo);
            }
            List<TARGET> listS = toManyGetter.s(t10);
            if (listS != 0) {
                listS.size();
            }
        }
    }

    public void j2(@Nonnull T t10, int i10) {
        for (a<T, ?> aVar : this.f32833d) {
            int i11 = aVar.f32853a;
            if (i11 == 0 || i10 < i11) {
                i2(t10, aVar);
            }
        }
    }

    public void k2(List<T> list) {
        if (this.f32833d != null) {
            int i10 = 0;
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                j2(it2.next(), i10);
                i10++;
            }
        }
    }

    public Query<T> l2(Property<?> property, double d10) {
        n();
        nativeSetParameter(this.f32837h, property.getEntityId(), property.C(), (String) null, d10);
        return this;
    }

    public <R> R m(Callable<R> callable) {
        n();
        return (R) this.f32831b.l(callable, this.f32836g, 10, true);
    }

    public Query<T> m2(Property<?> property, long j10) {
        n();
        nativeSetParameter(this.f32837h, property.getEntityId(), property.C(), (String) null, j10);
        return this;
    }

    public final void n() {
        if (this.f32837h == 0) {
            throw new IllegalStateException("This query is closed. Build and use a new one.");
        }
    }

    public Query<T> n2(Property<?> property, String str) {
        n();
        nativeSetParameter(this.f32837h, property.getEntityId(), property.C(), (String) null, str);
        return this;
    }

    public native long nativeCount(long j10, long j11);

    public native String nativeDescribeParameters(long j10);

    public native void nativeDestroy(long j10);

    public native List<T> nativeFind(long j10, long j11, long j12, long j13) throws Exception;

    public native Object nativeFindFirst(long j10, long j11);

    public native long[] nativeFindIds(long j10, long j11, long j12, long j13);

    public native Object nativeFindUnique(long j10, long j11);

    public native long nativeRemove(long j10, long j11);

    public native void nativeSetParameter(long j10, int i10, int i11, @Nullable String str, double d10);

    public native void nativeSetParameter(long j10, int i10, int i11, @Nullable String str, long j11);

    public native void nativeSetParameter(long j10, int i10, int i11, @Nullable String str, String str2);

    public native void nativeSetParameter(long j10, int i10, int i11, @Nullable String str, byte[] bArr);

    public native void nativeSetParameters(long j10, int i10, int i11, @Nullable String str, double d10, double d11);

    public native void nativeSetParameters(long j10, int i10, int i11, @Nullable String str, long j11, long j12);

    public native void nativeSetParameters(long j10, int i10, int i11, @Nullable String str, int[] iArr);

    public native void nativeSetParameters(long j10, int i10, int i11, @Nullable String str, long[] jArr);

    public native void nativeSetParameters(long j10, int i10, int i11, @Nullable String str, String[] strArr);

    public native String nativeToString(long j10);

    public Query<T> o2(Property<?> property, Date date) {
        return m2(property, date.getTime());
    }

    public Query<T> p2(Property<?> property, boolean z10) {
        return m2(property, z10 ? 1L : 0L);
    }

    public Query<T> q2(Property<?> property, byte[] bArr) {
        n();
        nativeSetParameter(this.f32837h, property.getEntityId(), property.C(), (String) null, bArr);
        return this;
    }

    public Query<T> r2(String str, double d10) {
        n();
        nativeSetParameter(this.f32837h, 0, 0, str, d10);
        return this;
    }

    public Query<T> s2(String str, long j10) {
        n();
        nativeSetParameter(this.f32837h, 0, 0, str, j10);
        return this;
    }

    public Query<T> t2(String str, String str2) {
        n();
        nativeSetParameter(this.f32837h, 0, 0, str, str2);
        return this;
    }

    public long u() {
        n();
        P();
        return ((Long) this.f32830a.y(new ni.a() { // from class: io.objectbox.query.e0
            @Override // ni.a
            public final Object a(long j10) {
                return this.f32876a.k1(j10);
            }
        })).longValue();
    }

    public Query<T> u2(String str, Date date) {
        return s2(str, date.getTime());
    }

    public Query<T> v2(String str, boolean z10) {
        return s2(str, z10 ? 1L : 0L);
    }

    public Query<T> w2(String str, byte[] bArr) {
        n();
        nativeSetParameter(this.f32837h, 0, 0, str, bArr);
        return this;
    }

    public Query<T> x2(Property<?> property, double d10, double d11) {
        n();
        nativeSetParameters(this.f32837h, property.getEntityId(), property.C(), (String) null, d10, d11);
        return this;
    }

    public Query<T> y2(Property<?> property, long j10, long j11) {
        n();
        nativeSetParameters(this.f32837h, property.getEntityId(), property.C(), (String) null, j10, j11);
        return this;
    }

    public long z() {
        return ii.i.e(this.f32830a);
    }

    public Query<T> z2(Property<?> property, String str, String str2) {
        n();
        nativeSetParameters(this.f32837h, property.getEntityId(), property.C(), (String) null, str, str2);
        return this;
    }
}
