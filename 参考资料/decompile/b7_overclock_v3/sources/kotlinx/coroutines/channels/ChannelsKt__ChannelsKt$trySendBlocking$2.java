package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super j<? extends z1>>, Object> {
    public final /* synthetic */ E $element;
    public final /* synthetic */ s<E> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(s<? super E> sVar, E e10, kotlin.coroutines.c<? super ChannelsKt__ChannelsKt$trySendBlocking$2> cVar) {
        super(2, cVar);
        this.$this_trySendBlocking = sVar;
        this.$element = e10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, cVar);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

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
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objB;
        Object objH = yj.b.h();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                u0.n(obj);
                s<E> sVar = this.$this_trySendBlocking;
                E e10 = this.$element;
                Result.a aVar = Result.f37633a;
                this.label = 1;
                if (sVar.G(e10, this) == objH) {
                    return objH;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u0.n(obj);
            }
            objB = Result.b(z1.f38230a);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(u0.a(th2));
        }
        return j.b(Result.m(objB) ? j.f38377b.c(z1.f38230a) : j.f38377b.a(Result.f(objB)));
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super j<z1>> cVar) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
