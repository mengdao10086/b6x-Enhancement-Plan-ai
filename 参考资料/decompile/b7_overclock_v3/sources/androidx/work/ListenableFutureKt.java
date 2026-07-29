package androidx.work;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d0;
import kotlin.jvm.internal.c0;
import kotlin.u0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087Hø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"R", "Lcom/google/common/util/concurrent/ListenableFuture;", "a", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/c;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 5, 1})
public final class ListenableFutureKt {

    @d0(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"R", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.o<R> f8277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture<R> f8278b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlinx.coroutines.o<? super R> oVar, ListenableFuture<R> listenableFuture) {
            this.f8277a = oVar;
            this.f8278b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                kotlin.coroutines.c cVar = this.f8277a;
                Object obj = this.f8278b.get();
                Result.a aVar = Result.f37633a;
                cVar.x(Result.b(obj));
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    cause = th2;
                }
                if (th2 instanceof CancellationException) {
                    this.f8277a.d(cause);
                    return;
                }
                kotlin.coroutines.c cVar2 = this.f8277a;
                Result.a aVar2 = Result.f37633a;
                cVar2.x(Result.b(u0.a(cause)));
            }
        }
    }

    @yt.l
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object a(@yt.k ListenableFuture<R> listenableFuture, @yt.k kotlin.coroutines.c<? super R> cVar) throws Throwable {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        }
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        listenableFuture.addListener(new a(pVar, listenableFuture), DirectExecutor.INSTANCE);
        pVar.B(new ListenableFutureKt$await$2$2(listenableFuture));
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object b(ListenableFuture<R> listenableFuture, kotlin.coroutines.c<? super R> cVar) throws Throwable {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        }
        c0.e(0);
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        listenableFuture.addListener(new a(pVar, listenableFuture), DirectExecutor.INSTANCE);
        pVar.B(new ListenableFutureKt$await$2$2(listenableFuture));
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        c0.e(1);
        return objC;
    }
}
