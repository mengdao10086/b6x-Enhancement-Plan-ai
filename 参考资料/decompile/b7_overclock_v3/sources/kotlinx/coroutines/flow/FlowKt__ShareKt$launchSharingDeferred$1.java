package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ kotlinx.coroutines.x<u<T>> $result;
    public final /* synthetic */ e<T> $upstream;
    private /* synthetic */ Object L$0;
    public int label;

    @t0({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
    public static final class a<T> implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<j<T>> f38583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o0 f38584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.x<u<T>> f38585c;

        public a(Ref.ObjectRef<j<T>> objectRef, o0 o0Var, kotlinx.coroutines.x<u<T>> xVar) {
            this.f38583a = objectRef;
            this.f38584b = o0Var;
            this.f38585c = xVar;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.j, kotlinx.coroutines.flow.u] */
        @Override // kotlinx.coroutines.flow.f
        @yt.l
        public final Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            z1 z1Var;
            j<T> jVar = this.f38583a.element;
            if (jVar != null) {
                jVar.setValue(t10);
                z1Var = z1.f38230a;
            } else {
                z1Var = null;
            }
            if (z1Var == null) {
                o0 o0Var = this.f38584b;
                Ref.ObjectRef<j<T>> objectRef = this.f38583a;
                kotlinx.coroutines.x<u<T>> xVar = this.f38585c;
                ?? r42 = (T) v.a(t10);
                xVar.u1(new l(r42, f2.B(o0Var.W())));
                objectRef.element = r42;
            }
            return z1.f38230a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharingDeferred$1(e<? extends T> eVar, kotlinx.coroutines.x<u<T>> xVar, kotlin.coroutines.c<? super FlowKt__ShareKt$launchSharingDeferred$1> cVar) {
        super(2, cVar);
        this.$upstream = eVar;
        this.$result = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, cVar);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1 for r6v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            kotlin.u0.n(r7)     // Catch: java.lang.Throwable -> Lf
            goto L37
        Lf:
            r7 = move-exception
            goto L3a
        L11:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L19:
            kotlin.u0.n(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.o0 r7 = (kotlinx.coroutines.o0) r7
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> Lf
            r1.<init>()     // Catch: java.lang.Throwable -> Lf
            kotlinx.coroutines.flow.e<T> r3 = r6.$upstream     // Catch: java.lang.Throwable -> Lf
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1$a r4 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1$a     // Catch: java.lang.Throwable -> Lf
            kotlinx.coroutines.x<kotlinx.coroutines.flow.u<T>> r5 = r6.$result     // Catch: java.lang.Throwable -> Lf
            r4.<init>(r1, r7, r5)     // Catch: java.lang.Throwable -> Lf
            r6.label = r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r7 = r3.a(r4, r6)     // Catch: java.lang.Throwable -> Lf
            if (r7 != r0) goto L37
            return r0
        L37:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L3a:
            kotlinx.coroutines.x<kotlinx.coroutines.flow.u<T>> r0 = r6.$result
            r0.l(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
