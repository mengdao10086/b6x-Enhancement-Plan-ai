package androidx.work;

import android.content.Context;
import androidx.work.ListenableFutureKt;
import androidx.work.ListenableWorker;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.umeng.analytics.pro.an;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0013\u0010\u0005\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J\u0006\u0010\u0012\u001a\u00020\u000bR\u001a\u0010\u0018\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR \u0010&\u001a\u00020\u001f8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$a;", "w", "y", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/work/g;", "B", "Landroidx/work/d;", "data", "Lkotlin/z1;", "G", "(Landroidx/work/d;Lkotlin/coroutines/c;)Ljava/lang/Object;", "foregroundInfo", "F", "(Landroidx/work/g;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", SsManifestParser.e.J, "Lkotlinx/coroutines/a0;", "f", "Lkotlinx/coroutines/a0;", i1.a.S4, "()Lkotlinx/coroutines/a0;", "job", "Landroidx/work/impl/utils/futures/a;", "g", "Landroidx/work/impl/utils/futures/a;", "D", "()Landroidx/work/impl/utils/futures/a;", "future", "Lkotlinx/coroutines/CoroutineDispatcher;", "h", "Lkotlinx/coroutines/CoroutineDispatcher;", an.aD, "()Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "()V", "coroutineContext", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", IOptionConstant.params, "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime-ktx_release"}, k = 1, mv = {1, 5, 1})
public abstract class CoroutineWorker extends ListenableWorker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final a0 f8271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final androidx.work.impl.utils.futures.a<ListenableWorker.a> f8272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final CoroutineDispatcher f8273h;

    @d0(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.D().isCancelled()) {
                c2.a.b(CoroutineWorker.this.E(), null, 1, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@yt.k Context appContext, @yt.k WorkerParameters params) {
        super(appContext, params);
        f0.p(appContext, "appContext");
        f0.p(params, "params");
        this.f8271f = h2.c(null, 1, null);
        androidx.work.impl.utils.futures.a<ListenableWorker.a> aVarU = androidx.work.impl.utils.futures.a.u();
        f0.o(aVarU, "create()");
        this.f8272g = aVarU;
        aVarU.addListener(new a(), k().d());
        this.f8273h = d1.a();
    }

    @kotlin.k(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ Object C(CoroutineWorker coroutineWorker, kotlin.coroutines.c cVar) {
        throw new IllegalStateException("Not implemented");
    }

    @yt.l
    public Object B(@yt.k kotlin.coroutines.c<? super g> cVar) {
        return C(this, cVar);
    }

    @yt.k
    public final androidx.work.impl.utils.futures.a<ListenableWorker.a> D() {
        return this.f8272g;
    }

    @yt.k
    public final a0 E() {
        return this.f8271f;
    }

    @yt.l
    public final Object F(@yt.k g gVar, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objC;
        ListenableFuture<Void> listenableFutureS = s(gVar);
        f0.o(listenableFutureS, "setForegroundAsync(foregroundInfo)");
        if (listenableFutureS.isDone()) {
            try {
                objC = listenableFutureS.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        } else {
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            pVar.Q();
            listenableFutureS.addListener(new ListenableFutureKt.a(pVar, listenableFutureS), DirectExecutor.INSTANCE);
            pVar.B(new ListenableFutureKt$await$2$2(listenableFutureS));
            objC = pVar.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
        }
        return objC == yj.b.h() ? objC : z1.f38230a;
    }

    @yt.l
    public final Object G(@yt.k d dVar, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objC;
        ListenableFuture<Void> listenableFutureT = t(dVar);
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
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            pVar.Q();
            listenableFutureT.addListener(new ListenableFutureKt.a(pVar, listenableFutureT), DirectExecutor.INSTANCE);
            pVar.B(new ListenableFutureKt$await$2$2(listenableFutureT));
            objC = pVar.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
        }
        return objC == yj.b.h() ? objC : z1.f38230a;
    }

    @Override // androidx.work.ListenableWorker
    @yt.k
    public final ListenableFuture<g> d() {
        a0 a0VarC = h2.c(null, 1, null);
        o0 o0VarA = p0.a(z().L(a0VarC));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(a0VarC, null, 2, null);
        kotlinx.coroutines.j.f(o0VarA, null, null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final void r() {
        super.r();
        this.f8272g.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    @yt.k
    public final ListenableFuture<ListenableWorker.a> w() {
        kotlinx.coroutines.j.f(p0.a(z().L(this.f8271f)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.f8272g;
    }

    @yt.l
    public abstract Object y(@yt.k kotlin.coroutines.c<? super ListenableWorker.a> cVar);

    @yt.k
    public CoroutineDispatcher z() {
        return this.f8273h;
    }
}
