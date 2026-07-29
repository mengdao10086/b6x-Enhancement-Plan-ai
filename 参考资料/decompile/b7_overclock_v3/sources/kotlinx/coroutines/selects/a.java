package kotlinx.coroutines.selects;

import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.s1;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @s1
    public static final <R> void a(@yt.k b<? super R> bVar, long j10, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        bVar.k(new OnTimeout(j10).b(), lVar);
    }

    @s1
    public static final <R> void b(@yt.k b<? super R> bVar, long j10, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        a(bVar, DelayKt.e(j10), lVar);
    }
}
