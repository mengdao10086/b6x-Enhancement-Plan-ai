package io.objectbox.kotlin;

import io.objectbox.query.h0;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¨\u0006\u0005"}, d2 = {i1.a.f31577d5, "Lio/objectbox/query/h0;", "queryCondition", "a", "b", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class g {
    @k
    public static final <T> h0<T> a(@k h0<T> h0Var, @k h0<T> queryCondition) {
        f0.p(h0Var, "<this>");
        f0.p(queryCondition, "queryCondition");
        h0<T> h0VarA = h0Var.a(queryCondition);
        f0.o(h0VarA, "and(queryCondition)");
        return h0VarA;
    }

    @k
    public static final <T> h0<T> b(@k h0<T> h0Var, @k h0<T> queryCondition) {
        f0.p(h0Var, "<this>");
        f0.p(queryCondition, "queryCondition");
        h0<T> h0VarB = h0Var.b(queryCondition);
        f0.o(h0VarB, "or(queryCondition)");
        return h0VarB;
    }
}
