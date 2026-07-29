package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.channels.q;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements p<q<? super Object>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.e<T2> $flow2;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q<Object> f38700a;

        public AnonymousClass1(q<Object> qVar) {
            this.f38700a = qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.f
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(T2 r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = yj.b.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.u0.n(r6)
                goto L47
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.u0.n(r6)
                kotlinx.coroutines.channels.q<java.lang.Object> r6 = r4.f38700a
                kotlinx.coroutines.channels.s r6 = r6.i()
                if (r5 != 0) goto L3e
                kotlinx.coroutines.internal.o0 r5 = kotlinx.coroutines.flow.internal.l.f38719a
            L3e:
                r0.label = r3
                java.lang.Object r5 = r6.G(r5, r0)
                if (r5 != r1) goto L47
                return r1
            L47:
                kotlin.z1 r5 = kotlin.z1.f38230a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1.AnonymousClass1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1(kotlinx.coroutines.flow.e<? extends T2> eVar, kotlin.coroutines.c<? super CombineKt$zipImpl$1$1$second$1> cVar) {
        super(2, cVar);
        this.$flow2 = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, cVar);
        combineKt$zipImpl$1$1$second$1.L$0 = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 for r4v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.u0.n(r5)
            goto L2e
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L17:
            kotlin.u0.n(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
            kotlinx.coroutines.flow.e<T2> r1 = r4.$flow2
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1 r3 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1
            r3.<init>(r5)
            r4.label = r2
            java.lang.Object r5 = r1.a(r3, r4)
            if (r5 != r0) goto L2e
            return r0
        L2e:
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k q<Object> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((CombineKt$zipImpl$1$1$second$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
