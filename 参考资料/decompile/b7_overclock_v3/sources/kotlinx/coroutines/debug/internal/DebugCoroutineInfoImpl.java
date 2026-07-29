package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.q;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
public final class DebugCoroutineInfoImpl {

    @l
    private volatile WeakReference<zj.c> _lastObservedFrame;

    @k
    private volatile String _state = d.f38454a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final i f38418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public final long f38419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final WeakReference<CoroutineContext> f38420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f38421d;

    @hk.e
    @l
    public volatile Thread lastObservedThread;

    public DebugCoroutineInfoImpl(@l CoroutineContext coroutineContext, @l i iVar, long j10) {
        this.f38418a = iVar;
        this.f38419b = j10;
        this.f38420c = new WeakReference<>(coroutineContext);
    }

    public final List<StackTraceElement> b() {
        i iVar = this.f38418a;
        return iVar == null ? CollectionsKt__CollectionsKt.E() : SequencesKt___SequencesKt.c3(q.b(new DebugCoroutineInfoImpl$creationStackTrace$1(this, iVar, null)));
    }

    @l
    public final CoroutineContext c() {
        return this.f38420c.get();
    }

    @l
    public final i d() {
        return this.f38418a;
    }

    @k
    public final List<StackTraceElement> e() {
        return b();
    }

    @l
    public final zj.c f() {
        WeakReference<zj.c> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @k
    public final String g() {
        return this._state;
    }

    @k
    public final List<StackTraceElement> h() {
        zj.c cVarF = f();
        if (cVarF == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        while (cVarF != null) {
            StackTraceElement stackTraceElementD = cVarF.D();
            if (stackTraceElementD != null) {
                arrayList.add(stackTraceElementD);
            }
            cVarF = cVarF.r();
        }
        return arrayList;
    }

    public final void i(@l zj.c cVar) {
        this._lastObservedFrame = cVar != null ? new WeakReference<>(cVar) : null;
    }

    public final synchronized void j(@k String str, @k kotlin.coroutines.c<?> cVar, boolean z10) {
        if (f0.g(this._state, d.f38455b) && f0.g(str, d.f38455b) && z10) {
            this.f38421d++;
        } else if (this.f38421d > 0 && f0.g(str, d.f38456c)) {
            this.f38421d--;
            return;
        }
        if (f0.g(this._state, str) && f0.g(str, d.f38456c) && f() != null) {
            return;
        }
        this._state = str;
        i(cVar instanceof zj.c ? (zj.c) cVar : null);
        this.lastObservedThread = f0.g(str, d.f38455b) ? Thread.currentThread() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004a -> B:25:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005b -> B:24:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(kotlin.sequences.o<? super java.lang.StackTraceElement> r6, zj.c r7, kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            zj.c r6 = (zj.c) r6
            java.lang.Object r7 = r0.L$1
            kotlin.sequences.o r7 = (kotlin.sequences.o) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.u0.n(r8)
            goto L5e
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.u0.n(r8)
            r2 = r5
        L41:
            if (r7 != 0) goto L46
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        L46:
            java.lang.StackTraceElement r8 = r7.D()
            if (r8 == 0) goto L61
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            r4 = r7
            r7 = r6
            r6 = r4
        L5e:
            r4 = r7
            r7 = r6
            r6 = r4
        L61:
            zj.c r7 = r7.r()
            if (r7 == 0) goto L68
            goto L41
        L68:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.k(kotlin.sequences.o, zj.c, kotlin.coroutines.c):java.lang.Object");
    }

    @k
    public String toString() {
        return "DebugCoroutineInfo(state=" + g() + ",context=" + c() + ')';
    }
}
