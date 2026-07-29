package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.c2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class a<T> extends kotlinx.coroutines.a<T> implements BiFunction<T, Throwable, z1> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final CompletableFuture<T> f38745d;

    public a(@k CoroutineContext coroutineContext, @k CompletableFuture<T> completableFuture) {
        super(coroutineContext, true, true);
        this.f38745d = completableFuture;
    }

    @Override // kotlinx.coroutines.a
    public void G1(@k Throwable th2, boolean z10) {
        this.f38745d.completeExceptionally(th2);
    }

    @Override // kotlinx.coroutines.a
    public void H1(T t10) {
        this.f38745d.complete(t10);
    }

    public void J1(@l T t10, @l Throwable th2) {
        c2.a.b(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ z1 apply(Object obj, Throwable th2) {
        J1(obj, th2);
        return z1.f38230a;
    }
}
