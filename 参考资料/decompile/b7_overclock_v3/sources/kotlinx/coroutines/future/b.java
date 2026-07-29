package kotlinx.coroutines.future;

import hk.e;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.u0;
import kotlin.z1;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> implements BiFunction<T, Throwable, z1> {

    @e
    @l
    public volatile kotlin.coroutines.c<? super T> cont;

    public b(@l kotlin.coroutines.c<? super T> cVar) {
        this.cont = cVar;
    }

    public void a(@l T t10, @l Throwable th2) {
        Throwable cause;
        kotlin.coroutines.c<? super T> cVar = this.cont;
        if (cVar == null) {
            return;
        }
        if (th2 == null) {
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(t10));
            return;
        }
        CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
        if (completionException != null && (cause = completionException.getCause()) != null) {
            th2 = cause;
        }
        Result.a aVar2 = Result.f37633a;
        cVar.x(Result.b(u0.a(th2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ z1 apply(Object obj, Throwable th2) {
        a(obj, th2);
        return z1.f38230a;
    }
}
