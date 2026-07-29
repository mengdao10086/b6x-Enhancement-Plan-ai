package io.objectbox.query;

import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.exception.DbException;
import io.objectbox.relation.RelationInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class QueryBuilder<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f32838k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f32839l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f32840m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f32841n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f32842o = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ii.a<T> f32843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f32845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f32846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f32847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Operator f32848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public List<a<T, ?>> f32849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public k0<T> f32850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Comparator<T> f32851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f32852j;

    public enum Operator {
        NONE,
        AND,
        OR
    }

    public enum StringOrder {
        CASE_INSENSITIVE,
        CASE_SENSITIVE
    }

    @li.c
    public QueryBuilder(ii.a<T> aVar, long j10, String str) {
        this.f32848f = Operator.NONE;
        this.f32843a = aVar;
        this.f32844b = j10;
        long jNativeCreate = nativeCreate(j10, str);
        this.f32845c = jNativeCreate;
        if (jNativeCreate == 0) {
            throw new DbException("Could not create native query builder");
        }
        this.f32852j = false;
    }

    private native long nativeBetween(long j10, int i10, double d10, double d11);

    private native long nativeBetween(long j10, int i10, long j11, long j12);

    private native long nativeBuild(long j10);

    private native long nativeCombine(long j10, long j11, long j12, boolean z10);

    private native long nativeContains(long j10, int i10, String str, boolean z10);

    private native long nativeContainsElement(long j10, int i10, String str, boolean z10);

    private native long nativeContainsKeyValue(long j10, int i10, String str, String str2, boolean z10);

    private native long nativeCreate(long j10, String str);

    private native void nativeDestroy(long j10);

    private native long nativeEndsWith(long j10, int i10, String str, boolean z10);

    private native long nativeEqual(long j10, int i10, long j11);

    private native long nativeEqual(long j10, int i10, String str, boolean z10);

    private native long nativeEqual(long j10, int i10, byte[] bArr);

    private native long nativeGreater(long j10, int i10, double d10, boolean z10);

    private native long nativeGreater(long j10, int i10, long j11, boolean z10);

    private native long nativeGreater(long j10, int i10, String str, boolean z10, boolean z11);

    private native long nativeGreater(long j10, int i10, byte[] bArr, boolean z10);

    private native long nativeIn(long j10, int i10, int[] iArr, boolean z10);

    private native long nativeIn(long j10, int i10, long[] jArr, boolean z10);

    private native long nativeIn(long j10, int i10, String[] strArr, boolean z10);

    private native long nativeLess(long j10, int i10, double d10, boolean z10);

    private native long nativeLess(long j10, int i10, long j11, boolean z10);

    private native long nativeLess(long j10, int i10, String str, boolean z10, boolean z11);

    private native long nativeLess(long j10, int i10, byte[] bArr, boolean z10);

    private native long nativeLink(long j10, long j11, int i10, int i11, int i12, int i13, boolean z10);

    private native long nativeNotEqual(long j10, int i10, long j11);

    private native long nativeNotEqual(long j10, int i10, String str, boolean z10);

    private native long nativeNotNull(long j10, int i10);

    private native long nativeNull(long j10, int i10);

    private native void nativeOrder(long j10, int i10, int i11);

    private native void nativeSetParameterAlias(long j10, String str);

    private native long nativeStartsWith(long j10, int i10, String str, boolean z10);

    public QueryBuilder<T> A(Property<T> property, Date date) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), date.getTime(), false));
        return this;
    }

    public QueryBuilder<T> B(Property<T> property, byte[] bArr) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), bArr, false));
        return this;
    }

    public QueryBuilder<T> C(Property<T> property, double d10) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), d10, true));
        return this;
    }

    public QueryBuilder<T> D(Property<T> property, long j10) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), j10, true));
        return this;
    }

    public QueryBuilder<T> E(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE, true));
        return this;
    }

    public QueryBuilder<T> F(Property<T> property, Date date) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), date.getTime(), true));
        return this;
    }

    public QueryBuilder<T> G(Property<T> property, byte[] bArr) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), bArr, true));
        return this;
    }

    public QueryBuilder<T> H(Property<T> property, int[] iArr) {
        o0();
        h(nativeIn(this.f32845c, property.C(), iArr, false));
        return this;
    }

    public QueryBuilder<T> I(Property<T> property, long[] jArr) {
        o0();
        h(nativeIn(this.f32845c, property.C(), jArr, false));
        return this;
    }

    public QueryBuilder<T> J(Property<T> property, String[] strArr, StringOrder stringOrder) {
        o0();
        h(nativeIn(this.f32845c, property.C(), strArr, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    @li.c
    public void K(long j10, long j11) {
        this.f32846d = nativeCombine(this.f32845c, j10, j11, false);
    }

    @li.c
    public long L() {
        return this.f32846d;
    }

    @li.c
    public void M(long j10, long j11) {
        this.f32846d = nativeCombine(this.f32845c, j10, j11, true);
    }

    public QueryBuilder<T> N(Property<T> property) {
        o0();
        h(nativeNull(this.f32845c, property.C()));
        return this;
    }

    public QueryBuilder<T> O(Property<T> property, double d10) {
        o0();
        h(nativeLess(this.f32845c, property.C(), d10, false));
        return this;
    }

    public QueryBuilder<T> P(Property<T> property, long j10) {
        o0();
        h(nativeLess(this.f32845c, property.C(), j10, false));
        return this;
    }

    public QueryBuilder<T> Q(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeLess(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE, false));
        return this;
    }

    public QueryBuilder<T> R(Property<T> property, Date date) {
        o0();
        h(nativeLess(this.f32845c, property.C(), date.getTime(), false));
        return this;
    }

    public QueryBuilder<T> S(Property<T> property, byte[] bArr) {
        o0();
        h(nativeLess(this.f32845c, property.C(), bArr, false));
        return this;
    }

    public QueryBuilder<T> T(Property<T> property, double d10) {
        o0();
        h(nativeLess(this.f32845c, property.C(), d10, true));
        return this;
    }

    public QueryBuilder<T> U(Property<T> property, long j10) {
        o0();
        h(nativeLess(this.f32845c, property.C(), j10, true));
        return this;
    }

    public QueryBuilder<T> V(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeLess(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE, true));
        return this;
    }

    public QueryBuilder<T> W(Property<T> property, Date date) {
        o0();
        h(nativeLess(this.f32845c, property.C(), date.getTime(), true));
        return this;
    }

    public QueryBuilder<T> X(Property<T> property, byte[] bArr) {
        o0();
        h(nativeLess(this.f32845c, property.C(), bArr, true));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TARGET> QueryBuilder<TARGET> Y(RelationInfo<?, TARGET> relationInfo) {
        boolean zA = relationInfo.a();
        return Z(relationInfo, zA ? relationInfo.targetInfo : relationInfo.sourceInfo, relationInfo.targetInfo, zA);
    }

    public final <TARGET> QueryBuilder<TARGET> Z(RelationInfo<?, ?> relationInfo, EntityInfo<?> entityInfo, EntityInfo<?> entityInfo2, boolean z10) {
        Property<?> property = relationInfo.targetIdProperty;
        int i10 = property != null ? property.f32643id : 0;
        int i11 = relationInfo.targetRelationId;
        return new QueryBuilder<>(this.f32844b, nativeLink(this.f32845c, this.f32844b, entityInfo.getEntityId(), entityInfo2.getEntityId(), i10, i11 != 0 ? i11 : relationInfo.relationId, z10));
    }

    public QueryBuilder<T> a() {
        j(Operator.AND);
        return this;
    }

    public QueryBuilder<T> a0(Property<T> property, long j10) {
        o0();
        h(nativeNotEqual(this.f32845c, property.C(), j10));
        return this;
    }

    @li.b
    public QueryBuilder<T> b(h0<T> h0Var) {
        ((i0) h0Var).d(this);
        return this;
    }

    public QueryBuilder<T> b0(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeNotEqual(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public <TARGET> QueryBuilder<TARGET> c(RelationInfo<TARGET, ?> relationInfo) {
        if (relationInfo.a()) {
            throw new IllegalArgumentException("Double backlink: The relation is already a backlink, please use a regular link on the original relation instead.");
        }
        EntityInfo<TARGET> entityInfo = relationInfo.sourceInfo;
        return Z(relationInfo, entityInfo, entityInfo, true);
    }

    public QueryBuilder<T> c0(Property<T> property, Date date) {
        o0();
        h(nativeNotEqual(this.f32845c, property.C(), date.getTime()));
        return this;
    }

    public QueryBuilder<T> d(Property<T> property, double d10, double d11) {
        o0();
        h(nativeBetween(this.f32845c, property.C(), d10, d11));
        return this;
    }

    public QueryBuilder<T> d0(Property<T> property, boolean z10) {
        o0();
        h(nativeNotEqual(this.f32845c, property.C(), z10 ? 1L : 0L));
        return this;
    }

    public QueryBuilder<T> e(Property<T> property, long j10, long j11) {
        o0();
        h(nativeBetween(this.f32845c, property.C(), j10, j11));
        return this;
    }

    public QueryBuilder<T> e0(Property<T> property, int[] iArr) {
        o0();
        h(nativeIn(this.f32845c, property.C(), iArr, true));
        return this;
    }

    public QueryBuilder<T> f(Property<T> property, Date date, Date date2) {
        o0();
        h(nativeBetween(this.f32845c, property.C(), date.getTime(), date2.getTime()));
        return this;
    }

    public QueryBuilder<T> f0(Property<T> property, long[] jArr) {
        o0();
        h(nativeIn(this.f32845c, property.C(), jArr, true));
        return this;
    }

    public void finalize() throws Throwable {
        i();
        super.finalize();
    }

    public Query<T> g() {
        p0();
        o0();
        if (this.f32848f != Operator.NONE) {
            throw new IllegalStateException("Incomplete logic condition. Use or()/and() between two conditions only.");
        }
        long jNativeBuild = nativeBuild(this.f32845c);
        if (jNativeBuild == 0) {
            throw new DbException("Could not create native query");
        }
        Query<T> query = new Query<>(this.f32843a, jNativeBuild, this.f32849g, this.f32850h, this.f32851i);
        i();
        return query;
    }

    public QueryBuilder<T> g0(Property<T> property) {
        o0();
        h(nativeNotNull(this.f32845c, property.C()));
        return this;
    }

    public final void h(long j10) {
        Operator operator = this.f32848f;
        Operator operator2 = Operator.NONE;
        if (operator != operator2) {
            this.f32846d = nativeCombine(this.f32845c, this.f32846d, j10, operator == Operator.OR);
            this.f32848f = operator2;
        } else {
            this.f32846d = j10;
        }
        this.f32847e = j10;
    }

    public QueryBuilder<T> h0() {
        j(Operator.OR);
        return this;
    }

    public synchronized void i() {
        long j10 = this.f32845c;
        if (j10 != 0) {
            this.f32845c = 0L;
            if (!this.f32852j) {
                nativeDestroy(j10);
            }
        }
    }

    public QueryBuilder<T> i0(Property<T> property) {
        return j0(property, 0);
    }

    public final void j(Operator operator) {
        o0();
        if (this.f32846d == 0) {
            throw new IllegalStateException("No previous condition. Use operators like and() and or() only between two conditions.");
        }
        if (this.f32848f != Operator.NONE) {
            throw new IllegalStateException("Another operator is pending. Use operators like and() and or() only between two conditions.");
        }
        this.f32848f = operator;
    }

    public QueryBuilder<T> j0(Property<T> property, int i10) {
        p0();
        o0();
        if (this.f32848f != Operator.NONE) {
            throw new IllegalStateException("An operator is pending. Use operators like and() and or() only between two conditions.");
        }
        nativeOrder(this.f32845c, property.C(), i10);
        return this;
    }

    public QueryBuilder<T> k(Property<T> property, String str, StringOrder stringOrder) {
        if (String[].class == property.type) {
            throw new UnsupportedOperationException("For String[] only containsElement() is supported at this time.");
        }
        o0();
        h(nativeContains(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public QueryBuilder<T> k0(Property<T> property) {
        return j0(property, 1);
    }

    public QueryBuilder<T> l(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeContainsElement(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public QueryBuilder<T> l0(String str) {
        o0();
        long j10 = this.f32847e;
        if (j10 == 0) {
            throw new IllegalStateException("No previous condition. Before you can assign an alias, you must first have a condition.");
        }
        nativeSetParameterAlias(j10, str);
        return this;
    }

    public QueryBuilder<T> m(Property<T> property, String str, String str2, StringOrder stringOrder) {
        o0();
        h(nativeContainsKeyValue(this.f32845c, property.C(), str, str2, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public QueryBuilder<T> m0(Comparator<T> comparator) {
        this.f32851i = comparator;
        return this;
    }

    public QueryBuilder<T> n(int i10, RelationInfo relationInfo, @Nullable RelationInfo... relationInfoArr) {
        p0();
        if (this.f32849g == null) {
            this.f32849g = new ArrayList();
        }
        this.f32849g.add(new a<>(i10, relationInfo));
        if (relationInfoArr != null) {
            for (RelationInfo relationInfo2 : relationInfoArr) {
                this.f32849g.add(new a<>(i10, relationInfo2));
            }
        }
        return this;
    }

    public QueryBuilder<T> n0(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeStartsWith(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public QueryBuilder<T> o(RelationInfo relationInfo, RelationInfo... relationInfoArr) {
        return n(0, relationInfo, relationInfoArr);
    }

    public final void o0() {
        if (this.f32845c == 0) {
            throw new IllegalStateException("This QueryBuilder has already been closed. Please use a new instance.");
        }
    }

    public QueryBuilder<T> p(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeEndsWith(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public final void p0() {
        if (this.f32852j) {
            throw new IllegalStateException("This call is not supported on sub query builders (links)");
        }
    }

    public QueryBuilder<T> q(Property<T> property, double d10, double d11) {
        return d(property, d10 - d11, d10 + d11);
    }

    public QueryBuilder<T> r(Property<T> property, long j10) {
        o0();
        h(nativeEqual(this.f32845c, property.C(), j10));
        return this;
    }

    public QueryBuilder<T> s(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeEqual(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE));
        return this;
    }

    public QueryBuilder<T> t(Property<T> property, Date date) {
        o0();
        h(nativeEqual(this.f32845c, property.C(), date.getTime()));
        return this;
    }

    public QueryBuilder<T> u(Property<T> property, boolean z10) {
        o0();
        h(nativeEqual(this.f32845c, property.C(), z10 ? 1L : 0L));
        return this;
    }

    public QueryBuilder<T> v(Property<T> property, byte[] bArr) {
        o0();
        h(nativeEqual(this.f32845c, property.C(), bArr));
        return this;
    }

    public QueryBuilder<T> w(k0<T> k0Var) {
        p0();
        if (this.f32850h != null) {
            throw new IllegalStateException("A filter was already defined, you can only assign one filter");
        }
        this.f32850h = k0Var;
        return this;
    }

    public QueryBuilder<T> x(Property<T> property, double d10) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), d10, false));
        return this;
    }

    public QueryBuilder<T> y(Property<T> property, long j10) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), j10, false));
        return this;
    }

    public QueryBuilder<T> z(Property<T> property, String str, StringOrder stringOrder) {
        o0();
        h(nativeGreater(this.f32845c, property.C(), str, stringOrder == StringOrder.CASE_SENSITIVE, false));
        return this;
    }

    public QueryBuilder(long j10, long j11) {
        this.f32848f = Operator.NONE;
        this.f32843a = null;
        this.f32844b = j10;
        this.f32845c = j11;
        this.f32852j = true;
    }
}
