package kotlinx.coroutines.flow;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final o0 f38741a = new o0(HlsPlaylistParser.M);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final o0 f38742b = new o0("PENDING");

    @yt.k
    public static final <T> j<T> a(T t10) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.l.f38719a;
        }
        return new StateFlowImpl(t10);
    }

    @yt.k
    public static final <T> e<T> d(@yt.k u<? extends T> uVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 2) {
            z10 = true;
        }
        return ((z10 || i10 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) ? uVar : o.e(uVar, coroutineContext, i10, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    public static final <T> T e(@yt.k j<T> jVar, @yt.k ik.l<? super T, ? extends T> lVar) {
        ?? r02;
        do {
            r02 = (Object) jVar.getValue();
        } while (!jVar.compareAndSet(r02, lVar.i(r02)));
        return r02;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void f(@yt.k j<T> jVar, @yt.k ik.l<? super T, ? extends T> lVar) {
        a0.c cVar;
        do {
            cVar = (Object) jVar.getValue();
        } while (!jVar.compareAndSet(cVar, lVar.i(cVar)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T g(@yt.k j<T> jVar, @yt.k ik.l<? super T, ? extends T> lVar) {
        a0.c cVar;
        T tI;
        do {
            cVar = (Object) jVar.getValue();
            tI = lVar.i(cVar);
        } while (!jVar.compareAndSet(cVar, tI));
        return tI;
    }
}
