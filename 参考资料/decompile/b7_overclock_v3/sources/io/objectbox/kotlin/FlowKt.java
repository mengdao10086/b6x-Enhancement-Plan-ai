package io.objectbox.kotlin;

import io.objectbox.BoxStore;
import io.objectbox.query.Query;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.s1;
import pi.m;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a,\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0007\u001a$\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¨\u0006\u000b"}, d2 = {i1.a.f31577d5, "Lpi/m;", "Lkotlinx/coroutines/flow/e;", "c", "Lio/objectbox/BoxStore;", "Ljava/lang/Class;", "forClass", "a", "Lio/objectbox/query/Query;", "", "b", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class FlowKt {
    @s1
    @k
    public static final <T> kotlinx.coroutines.flow.e<Class<T>> a(@k BoxStore boxStore, @k Class<T> forClass) {
        f0.p(boxStore, "<this>");
        f0.p(forClass, "forClass");
        m<Class<T>> mVarP2 = boxStore.P2(forClass);
        f0.o(mVarP2, "this.subscribe(forClass)");
        return c(mVarP2);
    }

    @s1
    @k
    public static final <T> kotlinx.coroutines.flow.e<List<T>> b(@k Query<T> query) {
        f0.p(query, "<this>");
        m<List<T>> mVarJ2 = query.J2();
        f0.o(mVarJ2, "this@flow.subscribe()");
        return c(mVarJ2);
    }

    @s1
    @k
    public static final <T> kotlinx.coroutines.flow.e<T> c(@k m<T> mVar) {
        f0.p(mVar, "<this>");
        return kotlinx.coroutines.flow.g.s(new FlowKt$toFlow$1(mVar, null));
    }
}
