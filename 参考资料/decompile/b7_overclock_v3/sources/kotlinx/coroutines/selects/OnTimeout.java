package kotlinx.coroutines.selects;

import ik.q;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.w0;
import kotlin.z1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nOnTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,66:1\n17#2:67\n*S KotlinDebug\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n56#1:67\n*E\n"})
public final class OnTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f38992a;

    @t0({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,18:1\n57#2,2:19\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f38993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnTimeout f38994b;

        public a(j jVar, OnTimeout onTimeout) {
            this.f38993a = jVar;
            this.f38994b = onTimeout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f38993a.n(this.f38994b, z1.f38230a);
        }
    }

    public OnTimeout(long j10) {
        this.f38992a = j10;
    }

    public static /* synthetic */ void c() {
    }

    @yt.k
    public final c b() {
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.f38995c;
        f0.n(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new d(this, (q) w0.q(onTimeout$selectClause$1, 3), null, 4, null);
    }

    public final void d(j<?> jVar, Object obj) {
        if (this.f38992a <= 0) {
            jVar.r(z1.f38230a);
            return;
        }
        a aVar = new a(jVar, this);
        f0.n(jVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        CoroutineContext coroutineContextB = jVar.b();
        jVar.d(DelayKt.d(coroutineContextB).h1(this.f38992a, aVar, coroutineContextB));
    }
}
