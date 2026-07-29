package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
public final class StartedLazily$command$1 extends SuspendLambda implements ik.p<f<? super SharingCommand>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ u<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f38657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f<SharingCommand> f38658b;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.BooleanRef booleanRef, f<? super SharingCommand> fVar) {
            this.f38657a = booleanRef;
            this.f38658b = fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(int r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = yj.b.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.u0.n(r6)
                goto L4b
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.u0.n(r6)
                if (r5 <= 0) goto L4e
                kotlin.jvm.internal.Ref$BooleanRef r5 = r4.f38657a
                boolean r6 = r5.element
                if (r6 != 0) goto L4e
                r5.element = r3
                kotlinx.coroutines.flow.f<kotlinx.coroutines.flow.SharingCommand> r5 = r4.f38658b
                kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
                r0.label = r3
                java.lang.Object r5 = r5.f(r6, r0)
                if (r5 != r1) goto L4b
                return r1
            L4b:
                kotlin.z1 r5 = kotlin.z1.f38230a
                return r5
            L4e:
                kotlin.z1 r5 = kotlin.z1.f38230a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1.AnonymousClass1.a(int, kotlin.coroutines.c):java.lang.Object");
        }

        @Override // kotlinx.coroutines.flow.f
        public /* bridge */ /* synthetic */ Object f(Object obj, kotlin.coroutines.c cVar) {
            return a(((Number) obj).intValue(), cVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(u<Integer> uVar, kotlin.coroutines.c<? super StartedLazily$command$1> cVar) {
        super(2, cVar);
        this.$subscriptionCount = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, cVar);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            f fVar = (f) this.L$0;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            u<Integer> uVar = this.$subscriptionCount;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanRef, fVar);
            this.label = 1;
            if (uVar.a(anonymousClass1, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k f<? super SharingCommand> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((StartedLazily$command$1) M(fVar, cVar)).q0(z1.f38230a);
    }
}
