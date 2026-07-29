package io.objectbox.kotlin;

import ik.l;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {i1.a.f31577d5, "Lii/a;", "Lkotlin/Function1;", "Lio/objectbox/query/QueryBuilder;", "Lkotlin/z1;", "Lkotlin/t;", "block", "Lio/objectbox/query/Query;", "a", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class a {
    @k
    public static final <T> Query<T> a(@k ii.a<T> aVar, @k l<? super QueryBuilder<T>, z1> block) {
        f0.p(aVar, "<this>");
        f0.p(block, "block");
        QueryBuilder<T> builder = aVar.L();
        f0.o(builder, "builder");
        block.i(builder);
        Query<T> queryG = builder.g();
        f0.o(queryG, "builder.build()");
        return queryG;
    }
}
