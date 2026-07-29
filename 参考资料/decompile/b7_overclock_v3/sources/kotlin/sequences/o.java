package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.coroutines.g
@v0(version = "1.3")
public abstract class o<T> {
    @yt.l
    public abstract Object a(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar);

    @yt.l
    public final Object e(@yt.k Iterable<? extends T> iterable, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objG;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objG = g(iterable.iterator(), cVar)) == yj.b.h()) ? objG : z1.f38230a;
    }

    @yt.l
    public abstract Object g(@yt.k Iterator<? extends T> it2, @yt.k kotlin.coroutines.c<? super z1> cVar);

    @yt.l
    public final Object h(@yt.k m<? extends T> mVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objG = g(mVar.iterator(), cVar);
        return objG == yj.b.h() ? objG : z1.f38230a;
    }
}
