package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import g.i1;
import hk.h;
import hk.i;
import java.lang.reflect.InvocationTargetException;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import w.w;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n314#2,11:218\n314#2,9:229\n323#2,2:239\n17#3:238\n1#4:241\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n189#1:218,11\n197#1:229,9\n197#1:239,2\n201#1:238\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f38278a = 4611686018427387903L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @l
    public static final d f38279b;

    @l
    private static volatile Choreographer choreographer;

    @t0({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n1#1,18:1\n202#2,2:19\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f38280a;

        public a(o oVar) {
            this.f38280a = oVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.n(this.f38280a);
        }
    }

    static {
        Object objB;
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(new HandlerContext(e(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(u0.a(th2));
        }
        f38279b = (d) (Result.l(objB) ? null : objB);
    }

    @i1
    @k
    public static final Handler e(@k Looper looper, boolean z10) throws IllegalAccessException, InvocationTargetException {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        f0.n(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }

    @l
    public static final Object f(@k kotlin.coroutines.c<? super Long> cVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            return g(cVar);
        }
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        l(choreographer2, pVar);
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    public static final Object g(kotlin.coroutines.c<? super Long> cVar) {
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n(pVar);
        } else {
            d1.e().h2(pVar.b(), new a(pVar));
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    @h(name = w.h.f53783c)
    @i
    @k
    public static final d h(@k Handler handler) {
        return j(handler, null, 1, null);
    }

    @h(name = w.h.f53783c)
    @i
    @k
    public static final d i(@k Handler handler, @l String str) {
        return new HandlerContext(handler, str);
    }

    public static /* synthetic */ d j(Handler handler, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return i(handler, str);
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void k() {
    }

    public static final void l(Choreographer choreographer2, final o<? super Long> oVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.e
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                f.m(oVar, j10);
            }
        });
    }

    public static final void m(o oVar, long j10) {
        oVar.O(d1.e(), Long.valueOf(j10));
    }

    public static final void n(o<? super Long> oVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            f0.m(choreographer2);
            choreographer = choreographer2;
        }
        l(choreographer2, oVar);
    }
}
