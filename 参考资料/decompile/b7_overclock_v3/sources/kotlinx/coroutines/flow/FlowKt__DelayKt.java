package kotlinx.coroutines.flow;

import kotlin.jvm.internal.t0;
import kotlin.m0;
import kotlin.z1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,405:1\n1#2:406\n*E\n"})
public final /* synthetic */ class FlowKt__DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    @t1
    public static final <T> e<T> a(@yt.k e<? extends T> eVar, final long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? eVar : e(eVar, new ik.l<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // ik.l
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Long i(T t10) {
                    return Long.valueOf(j10);
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @m0
    @yt.k
    @t1
    public static final <T> e<T> b(@yt.k e<? extends T> eVar, @yt.k ik.l<? super T, Long> lVar) {
        return e(eVar, lVar);
    }

    @yt.k
    @t1
    public static final <T> e<T> c(@yt.k e<? extends T> eVar, long j10) {
        return g.a0(eVar, DelayKt.e(j10));
    }

    @hk.h(name = "debounceDuration")
    @m0
    @t1
    @yt.k
    public static final <T> e<T> d(@yt.k e<? extends T> eVar, @yt.k final ik.l<? super T, uk.e> lVar) {
        return e(eVar, new ik.l<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Long i(T t10) {
                return Long.valueOf(DelayKt.e(lVar.i(t10).y0()));
            }
        });
    }

    public static final <T> e<T> e(e<? extends T> eVar, ik.l<? super T, Long> lVar) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(lVar, eVar, null));
    }

    @yt.k
    public static final ReceiveChannel<z1> f(@yt.k o0 o0Var, long j10, long j11) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j10 + " ms").toString());
        }
        if (j11 >= 0) {
            return ProduceKt.f(o0Var, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j11, j10, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel g(o0 o0Var, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        return g.y0(o0Var, j10, j11);
    }

    @yt.k
    @t1
    public static final <T> e<T> h(@yt.k e<? extends T> eVar, long j10) {
        if (j10 > 0) {
            return FlowCoroutineKt.b(new FlowKt__DelayKt$sample$2(j10, eVar, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @yt.k
    @t1
    public static final <T> e<T> i(@yt.k e<? extends T> eVar, long j10) {
        return g.B1(eVar, DelayKt.e(j10));
    }

    @yt.k
    @t1
    public static final <T> e<T> j(@yt.k e<? extends T> eVar, long j10) {
        return k(eVar, j10);
    }

    public static final <T> e<T> k(e<? extends T> eVar, long j10) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$timeoutInternal$1(j10, eVar, null));
    }
}
