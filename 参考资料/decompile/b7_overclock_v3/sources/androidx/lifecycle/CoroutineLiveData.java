package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.b3;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineLiveData<T> extends h0<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.l
    public BlockRunner<T> f6065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.l
    public EmittedSource f6066o;

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j10, ik.p pVar, int i10, kotlin.jvm.internal.u uVar) {
        this((i10 & 1) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i10 & 2) != 0 ? 5000L : j10, pVar);
    }

    @Override // androidx.lifecycle.h0, androidx.lifecycle.LiveData
    public void m() {
        super.m();
        BlockRunner<T> blockRunner = this.f6065n;
        if (blockRunner != null) {
            blockRunner.h();
        }
    }

    @Override // androidx.lifecycle.h0, androidx.lifecycle.LiveData
    public void n() {
        super.n();
        BlockRunner<T> blockRunner = this.f6065n;
        if (blockRunner != null) {
            blockRunner.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(@yt.k kotlin.coroutines.c<? super kotlin.z1> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r0 = (androidx.lifecycle.CoroutineLiveData) r0
            kotlin.u0.n(r5)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.u0.n(r5)
            androidx.lifecycle.EmittedSource r5 = r4.f6066o
            if (r5 == 0) goto L47
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            r0 = r4
        L48:
            r5 = 0
            r0.f6066o = r5
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.v(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(@yt.k androidx.lifecycle.LiveData<T> r6, @yt.k kotlin.coroutines.c<? super kotlinx.coroutines.g1> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.lifecycle.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r6 = (androidx.lifecycle.CoroutineLiveData) r6
            kotlin.u0.n(r7)
            goto L66
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$1
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            java.lang.Object r2 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r2 = (androidx.lifecycle.CoroutineLiveData) r2
            kotlin.u0.n(r7)
            r7 = r6
            r6 = r2
            goto L58
        L46:
            kotlin.u0.n(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.v(r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r7 = r6
            r6 = r5
        L58:
            r0.L$0 = r6
            r2 = 0
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = androidx.lifecycle.CoroutineLiveDataKt.a(r6, r7, r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            androidx.lifecycle.EmittedSource r7 = (androidx.lifecycle.EmittedSource) r7
            r6.f6066o = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.w(androidx.lifecycle.LiveData, kotlin.coroutines.c):java.lang.Object");
    }

    public CoroutineLiveData(@yt.k CoroutineContext context, long j10, @yt.k ik.p<? super g0<T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> block) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(block, "block");
        this.f6065n = new BlockRunner<>(this, block, j10, kotlinx.coroutines.p0.a(kotlinx.coroutines.d1.e().m2().L(context).L(b3.a((c2) context.c(c2.f38296x2)))), new ik.a<z1>(this) { // from class: androidx.lifecycle.CoroutineLiveData.1
            public final /* synthetic */ CoroutineLiveData<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public final void b() {
                this.this$0.f6065n = null;
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }
}
