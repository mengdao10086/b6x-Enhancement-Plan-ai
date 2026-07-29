package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.w0;
import qk.v;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,217:1\n1#2:218\n17#3:219\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n147#1:219\n*E\n"})
public final class HandlerContext extends d implements w0 {

    @l
    private volatile HandlerContext _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final Handler f38269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final String f38270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f38271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final HandlerContext f38272f;

    @t0({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n148#2:19\n149#2:21\n1#3:20\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f38273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HandlerContext f38274b;

        public a(o oVar, HandlerContext handlerContext) {
            this.f38273a = oVar;
            this.f38274b = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f38273a.O(this.f38274b, z1.f38230a);
        }
    }

    public HandlerContext(Handler handler, String str, boolean z10) {
        super(null);
        this.f38269c = handler;
        this.f38270d = str;
        this.f38271e = z10;
        this._immediate = z10 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f38272f = handlerContext;
    }

    public static final void t2(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f38269c.removeCallbacks(runnable);
    }

    public boolean equals(@l Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f38269c == this.f38269c;
    }

    @Override // kotlinx.coroutines.android.d, kotlinx.coroutines.w0
    @k
    public g1 h1(long j10, @k final Runnable runnable, @k CoroutineContext coroutineContext) {
        if (this.f38269c.postDelayed(runnable, v.C(j10, 4611686018427387903L))) {
            return new g1() { // from class: kotlinx.coroutines.android.c
                @Override // kotlinx.coroutines.g1
                public final void dispose() {
                    HandlerContext.t2(this.f38275a, runnable);
                }
            };
        }
        r2(coroutineContext, runnable);
        return p2.f38929a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@k CoroutineContext coroutineContext, @k Runnable runnable) {
        if (this.f38269c.post(runnable)) {
            return;
        }
        r2(coroutineContext, runnable);
    }

    public int hashCode() {
        return System.identityHashCode(this.f38269c);
    }

    @Override // kotlinx.coroutines.w0
    public void i(long j10, @k o<? super z1> oVar) {
        final a aVar = new a(oVar, this);
        if (this.f38269c.postDelayed(aVar, v.C(j10, 4611686018427387903L))) {
            oVar.B(new ik.l<Throwable, z1>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(@l Throwable th2) {
                    this.this$0.f38269c.removeCallbacks(aVar);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            });
        } else {
            r2(oVar.b(), aVar);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean j2(@k CoroutineContext coroutineContext) {
        return (this.f38271e && f0.g(Looper.myLooper(), this.f38269c.getLooper())) ? false : true;
    }

    public final void r2(CoroutineContext coroutineContext, Runnable runnable) {
        f2.f(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        d1.c().h2(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.android.d
    @k
    /* JADX INFO: renamed from: s2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public HandlerContext o2() {
        return this.f38272f;
    }

    @Override // kotlinx.coroutines.m2, kotlinx.coroutines.CoroutineDispatcher
    @k
    public String toString() {
        String strN2 = n2();
        if (strN2 != null) {
            return strN2;
        }
        String string = this.f38270d;
        if (string == null) {
            string = this.f38269c.toString();
        }
        if (!this.f38271e) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i10, u uVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public HandlerContext(@k Handler handler, @l String str) {
        this(handler, str, false);
    }
}
