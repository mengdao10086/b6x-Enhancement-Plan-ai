package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3<R> extends SuspendLambda implements ik.p<f<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ e[] $flows;
    public final /* synthetic */ ik.s $transform$inlined;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1, reason: invalid class name */
    @t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n139#2,6:333\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.q<f<? super R>, Object[], kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ ik.s $transform$inlined;
        private /* synthetic */ Object L$0;
        public /* synthetic */ Object L$1;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(kotlin.coroutines.c cVar, ik.s sVar) {
            super(3, cVar);
            this.$transform$inlined = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            Object objH = yj.b.h();
            int i10 = this.label;
            if (i10 == 0) {
                u0.n(obj);
                f fVar = (f) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                ik.s sVar = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.label = 1;
                c0.e(6);
                Object objW0 = sVar.w0(fVar, obj2, obj3, obj4, this);
                c0.e(7);
                if (objW0 == objH) {
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
        public final Object A(@yt.k f<? super R> fVar, @yt.k Object[] objArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar, this.$transform$inlined);
            anonymousClass1.L$0 = fVar;
            anonymousClass1.L$1 = objArr;
            return anonymousClass1.q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(e[] eVarArr, kotlin.coroutines.c cVar, ik.s sVar) {
        super(2, cVar);
        this.$flows = eVarArr;
        this.$transform$inlined = sVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(this.$flows, cVar, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            f fVar = (f) this.L$0;
            e[] eVarArr = this.$flows;
            ik.a aVarR = FlowKt__ZipKt.r();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, this.$transform$inlined);
            this.label = 1;
            if (CombineKt.a(fVar, eVarArr, aVarR, anonymousClass1, this) == objH) {
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
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3) M(fVar, cVar)).q0(z1.f38230a);
    }
}
