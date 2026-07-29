package io.objectbox.kotlin;

import io.objectbox.query.h0;
import io.objectbox.query.y;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004¨\u0006\u0006"}, d2 = {i1.a.f31577d5, "Lio/objectbox/query/y;", "", "name", "Lio/objectbox/query/h0;", "a", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class e {
    @k
    public static final <T> h0<T> a(@k y<T> yVar, @k String name) {
        f0.p(yVar, "<this>");
        f0.p(name, "name");
        h0<T> h0VarC = yVar.c(name);
        f0.o(h0VarC, "alias(name)");
        return h0VarC;
    }
}
