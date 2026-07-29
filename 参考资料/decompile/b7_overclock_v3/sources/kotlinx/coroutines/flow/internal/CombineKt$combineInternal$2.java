package kotlinx.coroutines.flow.internal;

import ik.p;
import ik.q;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, 76, 79}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
public final class CombineKt$combineInternal$2 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.a<T[]> $arrayFactory;
    public final /* synthetic */ kotlinx.coroutines.flow.e<T>[] $flows;
    public final /* synthetic */ kotlinx.coroutines.flow.f<R> $this_combineInternal;
    public final /* synthetic */ q<kotlinx.coroutines.flow.f<? super R>, T[], kotlin.coroutines.c<? super z1>, Object> $transform;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @zj.d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ kotlinx.coroutines.flow.e<T>[] $flows;
        public final /* synthetic */ int $i;
        public final /* synthetic */ AtomicInteger $nonClosed;
        public final /* synthetic */ kotlinx.coroutines.channels.g<h0<Object>> $resultChannel;
        public int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04361<T> implements kotlinx.coroutines.flow.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.g<h0<Object>> f38693a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f38694b;

            public C04361(kotlinx.coroutines.channels.g<h0<Object>> gVar, int i10) {
                this.f38693a = gVar;
                this.f38694b = i10;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.f
            @yt.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object f(T r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = yj.b.h()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L38
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.u0.n(r8)
                    goto L56
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    kotlin.u0.n(r8)
                    goto L4d
                L38:
                    kotlin.u0.n(r8)
                    kotlinx.coroutines.channels.g<kotlin.collections.h0<java.lang.Object>> r8 = r6.f38693a
                    kotlin.collections.h0 r2 = new kotlin.collections.h0
                    int r5 = r6.f38694b
                    r2.<init>(r5, r7)
                    r0.label = r4
                    java.lang.Object r7 = r8.G(r2, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    r0.label = r3
                    java.lang.Object r7 = kotlinx.coroutines.o3.a(r0)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    kotlin.z1 r7 = kotlin.z1.f38230a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C04361.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.e<? extends T>[] eVarArr, int i10, AtomicInteger atomicInteger, kotlinx.coroutines.channels.g<h0<Object>> gVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$flows = eVarArr;
            this.$i = i10;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            AtomicInteger atomicInteger;
            Object objH = yj.b.h();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u0.n(obj);
                    kotlinx.coroutines.flow.e[] eVarArr = this.$flows;
                    int i11 = this.$i;
                    kotlinx.coroutines.flow.e eVar = eVarArr[i11];
                    C04361 c04361 = new C04361(this.$resultChannel, i11);
                    this.label = 1;
                    if (eVar.a(c04361, this) == objH) {
                        return objH;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u0.n(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    s.a.a(this.$resultChannel, null, 1, null);
                }
                return z1.f38230a;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    s.a.a(this.$resultChannel, null, 1, null);
                }
            }
        }

        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.e<? extends T>[] eVarArr, ik.a<T[]> aVar, q<? super kotlinx.coroutines.flow.f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, kotlinx.coroutines.flow.f<? super R> fVar, kotlin.coroutines.c<? super CombineKt$combineInternal$2> cVar) {
        super(2, cVar);
        this.$flows = eVarArr;
        this.$arrayFactory = aVar;
        this.$transform = qVar;
        this.$this_combineInternal = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, cVar);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec A[LOOP:0: B:28:0x00ec->B:51:?, LOOP_START, PHI: r3 r10
  0x00ec: PHI (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:25:0x00e7, B:51:?] A[DONT_GENERATE, DONT_INLINE]
  0x00ec: PHI (r10v5 kotlin.collections.h0) = (r10v4 kotlin.collections.h0), (r10v18 kotlin.collections.h0) binds: [B:25:0x00e7, B:51:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0134 -> B:20:0x00c7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((CombineKt$combineInternal$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
