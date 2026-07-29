package androidx.lifecycle;

import androidx.lifecycle.CoroutineLiveDataKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutineLiveDataKt$addDisposableSource$2 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super EmittedSource>, Object> {
    public final /* synthetic */ LiveData<T> $source;
    public final /* synthetic */ h0<T> $this_addDisposableSource;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveDataKt$addDisposableSource$2(h0<T> h0Var, LiveData<T> liveData, kotlin.coroutines.c<? super CoroutineLiveDataKt$addDisposableSource$2> cVar) {
        super(2, cVar);
        this.$this_addDisposableSource = h0Var;
        this.$source = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new CoroutineLiveDataKt$addDisposableSource$2(this.$this_addDisposableSource, this.$source, cVar);
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
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.u0.n(obj);
        final h0<T> h0Var = this.$this_addDisposableSource;
        h0Var.s(this.$source, new CoroutineLiveDataKt.a(new ik.l<T, z1>() { // from class: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(T t10) {
                h0Var.r(t10);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Object obj2) {
                b(obj2);
                return z1.f38230a;
            }
        }));
        return new EmittedSource(this.$source, this.$this_addDisposableSource);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super EmittedSource> cVar) {
        return ((CoroutineLiveDataKt$addDisposableSource$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
