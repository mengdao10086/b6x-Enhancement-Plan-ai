package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6\n*L\n1#1,332:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", i = {}, l = {mb.e.f41067u1}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combineTransform$6<R> extends SuspendLambda implements ik.p<f<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ e<T>[] $flows;
    public final /* synthetic */ ik.q<f<? super R>, T[], kotlin.coroutines.c<? super z1>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1, reason: invalid class name */
    @t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$1\n*L\n1#1,332:1\n*E\n"})
    public static final class AnonymousClass1<T> extends Lambda implements ik.a<T[]> {
        public final /* synthetic */ e<T>[] $flows;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(e<? extends T>[] eVarArr) {
            super(0);
            this.$flows = eVarArr;
        }

        @Override // ik.a
        @yt.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T[] o() {
            int length = this.$flows.length;
            f0.y(0, "T?");
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2, reason: invalid class name */
    @t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$2\n*L\n1#1,332:1\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", i = {}, l = {mb.e.f41067u1}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<T> extends SuspendLambda implements ik.q<f<? super R>, T[], kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ ik.q<f<? super R>, T[], kotlin.coroutines.c<? super z1>, Object> $transform;
        private /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ik.q<? super f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(3, cVar);
            this.$transform = qVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @yt.l
        public final Object F0(@yt.k Object obj) {
            this.$transform.A((f) this.L$0, (Object[]) this.L$1, this);
            return z1.f38230a;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
            Object objH = yj.b.h();
            int i10 = this.label;
            if (i10 == 0) {
                u0.n(obj);
                f<? super R> fVar = (f) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                ik.q<f<? super R>, T[], kotlin.coroutines.c<? super z1>, Object> qVar = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (qVar.A(fVar, objArr, this) == objH) {
                    return objH;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u0.n(obj);
            }
            return z1.f38230a;
        }

        @Override // ik.q
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object A(@yt.k f<? super R> fVar, @yt.k T[] tArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            f0.w();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, cVar);
            anonymousClass2.L$0 = fVar;
            anonymousClass2.L$1 = tArr;
            return anonymousClass2.q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransform$6(e<? extends T>[] eVarArr, ik.q<? super f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, kotlin.coroutines.c<? super FlowKt__ZipKt$combineTransform$6> cVar) {
        super(2, cVar);
        this.$flows = eVarArr;
        this.$transform = qVar;
    }

    @yt.l
    public final Object F0(@yt.k Object obj) {
        f fVar = (f) this.L$0;
        e<T>[] eVarArr = this.$flows;
        f0.w();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flows);
        f0.w();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
        c0.e(0);
        CombineKt.a(fVar, eVarArr, anonymousClass1, anonymousClass2, this);
        c0.e(1);
        return z1.f38230a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.$flows, this.$transform, cVar);
        flowKt__ZipKt$combineTransform$6.L$0 = obj;
        return flowKt__ZipKt$combineTransform$6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            f fVar = (f) this.L$0;
            e<T>[] eVarArr = this.$flows;
            f0.w();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flows);
            f0.w();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            this.label = 1;
            if (CombineKt.a(fVar, eVarArr, anonymousClass1, anonymousClass2, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k f<? super R> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__ZipKt$combineTransform$6) M(fVar, cVar)).q0(z1.f38230a);
    }
}
