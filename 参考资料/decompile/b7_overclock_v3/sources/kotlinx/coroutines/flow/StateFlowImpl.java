package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<w> implements j<T>, a<T>, kotlinx.coroutines.flow.internal.i<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38661f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");

    @yt.l
    @hk.v
    private volatile Object _state;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f38662e;

    public StateFlowImpl(@yt.k Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:38:0x00b3, B:40:0x00b9], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:40:0x00b9, B:38:0x00b3], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, kotlinx.coroutines.flow.w] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, kotlinx.coroutines.flow.f] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d8 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ea -> B:34:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.n, kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r11, @yt.k kotlin.coroutines.c<?> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.n
    @yt.k
    public List<T> b() {
        return kotlin.collections.s.k(getValue());
    }

    @Override // kotlinx.coroutines.flow.internal.i
    @yt.k
    public e<T> c(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return v.d(this, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.j
    public boolean compareAndSet(T t10, T t11) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.l.f38719a;
        }
        if (t11 == null) {
            t11 = (T) kotlinx.coroutines.flow.internal.l.f38719a;
        }
        return r(t10, t11);
    }

    @Override // kotlinx.coroutines.flow.i, kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        setValue(t10);
        return z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.j, kotlinx.coroutines.flow.u
    public T getValue() {
        o0 o0Var = kotlinx.coroutines.flow.internal.l.f38719a;
        T t10 = (T) f38661f.get(this);
        if (t10 == o0Var) {
            return null;
        }
        return t10;
    }

    @Override // kotlinx.coroutines.flow.i
    public void k() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @yt.k
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w h() {
        return new w();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @yt.k
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w[] i(int i10) {
        return new w[i10];
    }

    public final boolean r(Object obj, Object obj2) {
        int i10;
        w[] wVarArrN;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38661f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !f0.g(obj3, obj)) {
                return false;
            }
            if (f0.g(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f38662e;
            if ((i11 & 1) != 0) {
                this.f38662e = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f38662e = i12;
            w[] wVarArrN2 = n();
            z1 z1Var = z1.f38230a;
            while (true) {
                w[] wVarArr = wVarArrN2;
                if (wVarArr != null) {
                    for (w wVar : wVarArr) {
                        if (wVar != null) {
                            wVar.h();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.f38662e;
                    if (i10 == i12) {
                        this.f38662e = i12 + 1;
                        return true;
                    }
                    wVarArrN = n();
                    z1 z1Var2 = z1.f38230a;
                }
                wVarArrN2 = wVarArrN;
                i12 = i10;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.j
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.l.f38719a;
        }
        r(null, t10);
    }

    @Override // kotlinx.coroutines.flow.i
    public boolean z(T t10) {
        setValue(t10);
        return true;
    }
}
