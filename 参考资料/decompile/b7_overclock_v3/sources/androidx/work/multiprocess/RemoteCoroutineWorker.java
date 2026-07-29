package androidx.work.multiprocess;

import android.content.Context;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.p0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\tR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/work/multiprocess/RemoteCoroutineWorker;", "Landroidx/work/multiprocess/RemoteListenableWorker;", "Landroidx/work/ListenableWorker$a;", "B", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/google/common/util/concurrent/ListenableFuture;", "y", "Landroidx/work/d;", "data", "Lkotlin/z1;", "C", "(Landroidx/work/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", SsManifestParser.e.J, "Lkotlinx/coroutines/a0;", "o", "Lkotlinx/coroutines/a0;", "job", "Landroidx/work/impl/utils/futures/a;", "p", "Landroidx/work/impl/utils/futures/a;", "future", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-multiprocess_release"}, k = 1, mv = {1, 5, 1})
public abstract class RemoteCoroutineWorker extends RemoteListenableWorker {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public final a0 f8570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public final androidx.work.impl.utils.futures.a<ListenableWorker.a> f8571p;

    @d0(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (RemoteCoroutineWorker.this.f8571p.isCancelled()) {
                c2.a.b(RemoteCoroutineWorker.this.f8570o, null, 1, null);
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¨\u0006\u0002"}, d2 = {"R", "Lkotlin/z1;", "androidx/work/ListenableFutureKt$a", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f8573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8574b;

        public b(o oVar, ListenableFuture listenableFuture) {
            this.f8573a = oVar;
            this.f8574b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o oVar = this.f8573a;
                V v10 = this.f8574b.get();
                Result.a aVar = Result.f37633a;
                oVar.x(Result.b(v10));
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    cause = th2;
                }
                if (th2 instanceof CancellationException) {
                    this.f8573a.d(cause);
                    return;
                }
                o oVar2 = this.f8573a;
                Result.a aVar2 = Result.f37633a;
                oVar2.x(Result.b(u0.a(cause)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteCoroutineWorker(@yt.k Context context, @yt.k WorkerParameters parameters) {
        super(context, parameters);
        f0.p(context, "context");
        f0.p(parameters, "parameters");
        this.f8570o = h2.c(null, 1, null);
        androidx.work.impl.utils.futures.a<ListenableWorker.a> aVarU = androidx.work.impl.utils.futures.a.u();
        f0.o(aVarU, "create()");
        this.f8571p = aVarU;
        aVarU.addListener(new a(), k().d());
    }

    @yt.l
    public abstract Object B(@yt.k kotlin.coroutines.c<? super ListenableWorker.a> cVar);

    @yt.l
    public final Object C(@yt.k androidx.work.d dVar, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objC;
        final ListenableFuture<Void> listenableFutureT = t(dVar);
        f0.o(listenableFutureT, "setProgressAsync(data)");
        if (listenableFutureT.isDone()) {
            try {
                objC = listenableFutureT.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        } else {
            p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            pVar.Q();
            listenableFutureT.addListener(new b(pVar, listenableFutureT), DirectExecutor.INSTANCE);
            pVar.B(new ik.l<Throwable, z1>() { // from class: androidx.work.multiprocess.RemoteCoroutineWorker$setProgress$$inlined$await$2
                {
                    super(1);
                }

                public final void b(@yt.l Throwable th2) {
                    listenableFutureT.cancel(false);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            });
            objC = pVar.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
        }
        return objC == yj.b.h() ? objC : z1.f38230a;
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker, androidx.work.ListenableWorker
    public final void r() {
        super.r();
        this.f8571p.cancel(true);
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker
    @yt.k
    public ListenableFuture<ListenableWorker.a> y() {
        kotlinx.coroutines.j.f(p0.a(d1.a().L(this.f8570o)), null, null, new RemoteCoroutineWorker$startRemoteWork$1(this, null), 3, null);
        return this.f8571p;
    }
}
