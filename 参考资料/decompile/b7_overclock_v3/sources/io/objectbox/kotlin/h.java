package io.objectbox.kotlin;

import ik.l;
import io.objectbox.relation.ToMany;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {i1.a.f31577d5, "Lio/objectbox/relation/ToMany;", "", "resetFirst", "Lkotlin/Function1;", "Lkotlin/z1;", "Lkotlin/t;", "body", "a", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class h {
    public static final <T> void a(@k ToMany<T> toMany, boolean z10, @k l<? super ToMany<T>, z1> body) {
        f0.p(toMany, "<this>");
        f0.p(body, "body");
        if (z10) {
            toMany.H();
        }
        body.i(toMany);
        toMany.f();
    }

    public static /* synthetic */ void b(ToMany toMany, boolean z10, l body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        f0.p(toMany, "<this>");
        f0.p(body, "body");
        if (z10) {
            toMany.H();
        }
        body.i(toMany);
        toMany.f();
    }
}
