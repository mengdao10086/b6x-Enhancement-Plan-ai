package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
public final class TickerChannelsKt$ticker$3 extends SuspendLambda implements ik.p<q<? super z1>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ long $delayMillis;
    public final /* synthetic */ long $initialDelayMillis;
    public final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    public int label;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38363a;

        static {
            int[] iArr = new int[TickerMode.values().length];
            try {
                iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f38363a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TickerChannelsKt$ticker$3(TickerMode tickerMode, long j10, long j11, kotlin.coroutines.c<? super TickerChannelsKt$ticker$3> cVar) {
        super(2, cVar);
        this.$mode = tickerMode;
        this.$delayMillis = j10;
        this.$initialDelayMillis = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, cVar);
        tickerChannelsKt$ticker$3.L$0 = obj;
        return tickerChannelsKt$ticker$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            q qVar = (q) this.L$0;
            int i11 = a.f38363a[this.$mode.ordinal()];
            if (i11 == 1) {
                long j10 = this.$delayMillis;
                long j11 = this.$initialDelayMillis;
                s sVarI = qVar.i();
                this.label = 1;
                if (TickerChannelsKt.d(j10, j11, sVarI, this) == objH) {
                    return objH;
                }
            } else if (i11 == 2) {
                long j12 = this.$delayMillis;
                long j13 = this.$initialDelayMillis;
                s sVarI2 = qVar.i();
                this.label = 2;
                if (TickerChannelsKt.c(j12, j13, sVarI2, this) == objH) {
                    return objH;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<? super z1> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((TickerChannelsKt$ticker$3) M(qVar, cVar)).q0(z1.f38230a);
    }
}
