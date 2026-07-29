package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import kotlin.d0;
import kotlin.jvm.internal.Lambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"R", "", "it", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ListenableFutureKt$await$2$2 extends Lambda implements ik.l<Throwable, z1> {
    public final /* synthetic */ ListenableFuture<R> $this_await;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$2$2(ListenableFuture<R> listenableFuture) {
        super(1);
        this.$this_await = listenableFuture;
    }

    public final void b(@yt.l Throwable th2) {
        this.$this_await.cancel(false);
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
        b(th2);
        return z1.f38230a;
    }
}
