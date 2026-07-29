package io.objectbox.kotlin;

import androidx.lifecycle.r0;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\b\u001a7\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0086\b\u001aL\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a7\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\b\u001a?\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0086\b\u001a7\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u001aH\u0086\b\u001a7\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u001aH\u0086\b\u001a7\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u001aH\u0086\b\u001a7\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u001aH\u0086\b\u001a7\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u001aH\u0086\b\u001a7\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\u001aH\u0086\b\u001a?\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u001aH\u0086\b\u001a?\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0086\b\u001a7\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\"H\u0086\b\u001a7\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\"H\u0086\b\u001a7\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\"H\u0086\b\u001a7\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\"H\u0086\b\u001a?\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0017\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\"H\u0086\b¨\u0006*"}, d2 = {i1.a.f31577d5, "Lio/objectbox/query/QueryBuilder;", "Lio/objectbox/Property;", "property", "", r0.f6236g, "n", "", k.f40564b, "", "", "Lio/objectbox/query/QueryBuilder$StringOrder;", "stringOrder", "o", "(Lio/objectbox/query/QueryBuilder;Lio/objectbox/Property;[Ljava/lang/String;Lio/objectbox/query/QueryBuilder$StringOrder;)Lio/objectbox/query/QueryBuilder;", "", "value", "f", "w", SsManifestParser.e.J, "u", "i", l.f16298a, "value1", "value2", "c", "", "e", "v", "q", "t", "h", "k", "b", "", "tolerance", "d", "p", an.aB, "g", j.f55230b, "a", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class f {
    public static final /* synthetic */ <T> QueryBuilder<T> a(QueryBuilder<T> queryBuilder, Property<T> property, float f10, float f11) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderD = queryBuilder.d(property, f10, f11);
        f0.o(queryBuilderD, "between(property, value1…ble(), value2.toDouble())");
        return queryBuilderD;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> b(QueryBuilder<T> queryBuilder, Property<T> property, int i10, int i11) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderE = queryBuilder.e(property, i10, i11);
        f0.o(queryBuilderE, "between(property, value1…oLong(), value2.toLong())");
        return queryBuilderE;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> c(QueryBuilder<T> queryBuilder, Property<T> property, short s10, short s11) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderE = queryBuilder.e(property, s10, s11);
        f0.o(queryBuilderE, "between(property, value1…oLong(), value2.toLong())");
        return queryBuilderE;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> d(QueryBuilder<T> queryBuilder, Property<T> property, float f10, float f11) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderQ = queryBuilder.q(property, f10, f11);
        f0.o(queryBuilderQ, "equal(property, value.to…(), tolerance.toDouble())");
        return queryBuilderQ;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> e(QueryBuilder<T> queryBuilder, Property<T> property, int i10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderR = queryBuilder.r(property, i10);
        f0.o(queryBuilderR, "equal(property, value.toLong())");
        return queryBuilderR;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> f(QueryBuilder<T> queryBuilder, Property<T> property, short s10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderR = queryBuilder.r(property, s10);
        f0.o(queryBuilderR, "equal(property, value.toLong())");
        return queryBuilderR;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> g(QueryBuilder<T> queryBuilder, Property<T> property, float f10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderX = queryBuilder.x(property, f10);
        f0.o(queryBuilderX, "greater(property, value.toDouble())");
        return queryBuilderX;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> h(QueryBuilder<T> queryBuilder, Property<T> property, int i10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderY = queryBuilder.y(property, i10);
        f0.o(queryBuilderY, "greater(property, value.toLong())");
        return queryBuilderY;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> i(QueryBuilder<T> queryBuilder, Property<T> property, short s10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderY = queryBuilder.y(property, s10);
        f0.o(queryBuilderY, "greater(property, value.toLong())");
        return queryBuilderY;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> j(QueryBuilder<T> queryBuilder, Property<T> property, float f10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderC = queryBuilder.C(property, f10);
        f0.o(queryBuilderC, "greaterOrEqual(property, value.toDouble())");
        return queryBuilderC;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> k(QueryBuilder<T> queryBuilder, Property<T> property, int i10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderD = queryBuilder.D(property, i10);
        f0.o(queryBuilderD, "greaterOrEqual(property, value.toLong())");
        return queryBuilderD;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> l(QueryBuilder<T> queryBuilder, Property<T> property, short s10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderD = queryBuilder.D(property, s10);
        f0.o(queryBuilderD, "greaterOrEqual(property, value.toLong())");
        return queryBuilderD;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> m(QueryBuilder<T> queryBuilder, Property<T> property, int[] values) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        f0.p(values, "values");
        QueryBuilder<T> queryBuilderH = queryBuilder.H(property, values);
        f0.o(queryBuilderH, "`in`(property, values)");
        return queryBuilderH;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> n(QueryBuilder<T> queryBuilder, Property<T> property, long[] values) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        f0.p(values, "values");
        QueryBuilder<T> queryBuilderI = queryBuilder.I(property, values);
        f0.o(queryBuilderI, "`in`(property, values)");
        return queryBuilderI;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> o(QueryBuilder<T> queryBuilder, Property<T> property, String[] values, QueryBuilder.StringOrder stringOrder) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        f0.p(values, "values");
        f0.p(stringOrder, "stringOrder");
        QueryBuilder<T> queryBuilderJ = queryBuilder.J(property, values, stringOrder);
        f0.o(queryBuilderJ, "`in`(property, values, stringOrder)");
        return queryBuilderJ;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> p(QueryBuilder<T> queryBuilder, Property<T> property, float f10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderO = queryBuilder.O(property, f10);
        f0.o(queryBuilderO, "less(property, value.toDouble())");
        return queryBuilderO;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> q(QueryBuilder<T> queryBuilder, Property<T> property, int i10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderP = queryBuilder.P(property, i10);
        f0.o(queryBuilderP, "less(property, value.toLong())");
        return queryBuilderP;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> r(QueryBuilder<T> queryBuilder, Property<T> property, short s10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderP = queryBuilder.P(property, s10);
        f0.o(queryBuilderP, "less(property, value.toLong())");
        return queryBuilderP;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> s(QueryBuilder<T> queryBuilder, Property<T> property, float f10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderT = queryBuilder.T(property, f10);
        f0.o(queryBuilderT, "lessOrEqual(property, value.toDouble())");
        return queryBuilderT;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> t(QueryBuilder<T> queryBuilder, Property<T> property, int i10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderU = queryBuilder.U(property, i10);
        f0.o(queryBuilderU, "lessOrEqual(property, value.toLong())");
        return queryBuilderU;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> u(QueryBuilder<T> queryBuilder, Property<T> property, short s10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderU = queryBuilder.U(property, s10);
        f0.o(queryBuilderU, "lessOrEqual(property, value.toLong())");
        return queryBuilderU;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> v(QueryBuilder<T> queryBuilder, Property<T> property, int i10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderA0 = queryBuilder.a0(property, i10);
        f0.o(queryBuilderA0, "notEqual(property, value.toLong())");
        return queryBuilderA0;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> w(QueryBuilder<T> queryBuilder, Property<T> property, short s10) {
        f0.p(queryBuilder, "<this>");
        f0.p(property, "property");
        QueryBuilder<T> queryBuilderA0 = queryBuilder.a0(property, s10);
        f0.o(queryBuilderA0, "notEqual(property, value.toLong())");
        return queryBuilderA0;
    }
}
