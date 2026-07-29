package androidx.room;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabase.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
@kotlin.d0(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/o0;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class RoomDatabaseKt$withTransaction$2<R> extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super R>, Object> {
    public final /* synthetic */ ik.l<kotlin.coroutines.c<? super R>, Object> $block;
    public final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$withTransaction$2(RoomDatabase roomDatabase, ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar, kotlin.coroutines.c<? super RoomDatabaseKt$withTransaction$2> cVar) {
        super(2, cVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(this.$this_withTransaction, this.$block, cVar);
        roomDatabaseKt$withTransaction$2.L$0 = obj;
        return roomDatabaseKt$withTransaction$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Throwable th2;
        f3 f3Var;
        f3 f3VarH = yj.b.h();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.u0.n(obj);
                CoroutineContext.a aVarC = ((kotlinx.coroutines.o0) this.L$0).W().c(f3.f7376d);
                kotlin.jvm.internal.f0.m(aVarC);
                f3 f3Var2 = (f3) aVarC;
                f3Var2.b();
                try {
                    this.$this_withTransaction.e();
                    try {
                        ik.l<kotlin.coroutines.c<? super R>, Object> lVar = this.$block;
                        this.L$0 = f3Var2;
                        this.label = 1;
                        Object objI = lVar.i(this);
                        if (objI == f3VarH) {
                            return f3VarH;
                        }
                        f3Var = f3Var2;
                        obj = objI;
                    } catch (Throwable th3) {
                        th2 = th3;
                        this.$this_withTransaction.k();
                        throw th2;
                    }
                } catch (Throwable th4) {
                    f3VarH = f3Var2;
                    th = th4;
                    f3VarH.g();
                    throw th;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f3Var = (f3) this.L$0;
                try {
                    kotlin.u0.n(obj);
                } catch (Throwable th5) {
                    th2 = th5;
                    this.$this_withTransaction.k();
                    throw th2;
                }
            }
            this.$this_withTransaction.K();
            this.$this_withTransaction.k();
            f3Var.g();
            return obj;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super R> cVar) {
        return ((RoomDatabaseKt$withTransaction$2) M(o0Var, cVar)).q0(kotlin.z1.f38230a);
    }
}
