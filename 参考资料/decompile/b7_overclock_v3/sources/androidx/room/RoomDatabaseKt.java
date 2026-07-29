package androidx.room;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "e", "(Landroidx/room/RoomDatabase;Lik/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "d", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/c2;", "controlJob", "Lkotlin/coroutines/d;", "c", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/c2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1})
public final class RoomDatabaseKt {
    public static final Object c(Executor executor, final kotlinx.coroutines.c2 c2Var, kotlin.coroutines.c<? super kotlin.coroutines.d> cVar) {
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        pVar.B(new ik.l<Throwable, kotlin.z1>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$1
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                c2.a.b(c2Var, null, 1, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
                b(th2);
                return kotlin.z1.f38230a;
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1, reason: invalid class name */
                @zj.d(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabase.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
                @kotlin.d0(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super kotlin.z1>, Object> {
                    public final /* synthetic */ kotlinx.coroutines.o<kotlin.coroutines.d> $continuation;
                    public final /* synthetic */ kotlinx.coroutines.c2 $controlJob;
                    private /* synthetic */ Object L$0;
                    public int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(kotlinx.coroutines.o<? super kotlin.coroutines.d> oVar, kotlinx.coroutines.c2 c2Var, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
                        super(2, cVar);
                        this.$continuation = oVar;
                        this.$controlJob = c2Var;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @yt.k
                    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$continuation, this.$controlJob, cVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @yt.l
                    public final Object q0(@yt.k Object obj) throws Throwable {
                        Object objH = yj.b.h();
                        int i10 = this.label;
                        if (i10 == 0) {
                            kotlin.u0.n(obj);
                            kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.L$0;
                            kotlinx.coroutines.o<kotlin.coroutines.d> oVar = this.$continuation;
                            Result.a aVar = Result.f37633a;
                            CoroutineContext.a aVarC = o0Var.W().c(kotlin.coroutines.d.f37759u2);
                            kotlin.jvm.internal.f0.m(aVarC);
                            oVar.x(Result.b(aVarC));
                            kotlinx.coroutines.c2 c2Var = this.$controlJob;
                            this.label = 1;
                            if (c2Var.T(this) == objH) {
                                return objH;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.u0.n(obj);
                        }
                        return kotlin.z1.f38230a;
                    }

                    @Override // ik.p
                    @yt.l
                    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
                    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super kotlin.z1> cVar) {
                        return ((AnonymousClass1) M(o0Var, cVar)).q0(kotlin.z1.f38230a);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    kotlinx.coroutines.i.b(null, new AnonymousClass1(pVar, c2Var, null), 1, null);
                }
            });
        } catch (RejectedExecutionException e10) {
            pVar.d(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e10));
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(androidx.room.RoomDatabase r6, kotlin.coroutines.c<? super kotlin.coroutines.CoroutineContext> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$createTransactionContext$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = (androidx.room.RoomDatabaseKt$createTransactionContext$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = new androidx.room.RoomDatabaseKt$createTransactionContext$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.a0 r6 = (kotlinx.coroutines.a0) r6
            java.lang.Object r0 = r0.L$0
            androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
            kotlin.u0.n(r7)
            goto L71
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.u0.n(r7)
            r7 = 0
            kotlinx.coroutines.a0 r7 = kotlinx.coroutines.f2.c(r7, r3, r7)
            kotlin.coroutines.CoroutineContext r2 = r0.b()
            kotlinx.coroutines.c2$b r4 = kotlinx.coroutines.c2.f38296x2
            kotlin.coroutines.CoroutineContext$a r2 = r2.c(r4)
            kotlinx.coroutines.c2 r2 = (kotlinx.coroutines.c2) r2
            if (r2 == 0) goto L57
            androidx.room.RoomDatabaseKt$createTransactionContext$2 r4 = new androidx.room.RoomDatabaseKt$createTransactionContext$2
            r4.<init>()
            r2.L1(r4)
        L57:
            java.util.concurrent.Executor r2 = r6.u()
            java.lang.String r4 = "transactionExecutor"
            kotlin.jvm.internal.f0.o(r2, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = c(r2, r7, r0)
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L71:
            kotlin.coroutines.d r7 = (kotlin.coroutines.d) r7
            androidx.room.f3 r1 = new androidx.room.f3
            r1.<init>(r6, r7)
            java.lang.ThreadLocal r0 = r0.t()
            java.lang.String r2 = "suspendingTransactionId"
            kotlin.jvm.internal.f0.o(r0, r2)
            int r6 = java.lang.System.identityHashCode(r6)
            java.lang.Integer r6 = zj.a.f(r6)
            kotlinx.coroutines.c3 r6 = kotlinx.coroutines.d3.a(r0, r6)
            kotlin.coroutines.CoroutineContext r7 = r7.L(r1)
            kotlin.coroutines.CoroutineContext r6 = r7.L(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.d(androidx.room.RoomDatabase, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[PHI: r7
  0x007b: PHI (r7v11 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:26:0x0078, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object e(@yt.k androidx.room.RoomDatabase r5, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends java.lang.Object> r6, @yt.k kotlin.coroutines.c<? super R> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$withTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = (androidx.room.RoomDatabaseKt$withTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = new androidx.room.RoomDatabaseKt$withTransaction$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.u0.n(r7)
            goto L7b
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            ik.l r6 = (ik.l) r6
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.u0.n(r7)
            goto L66
        L41:
            kotlin.u0.n(r7)
            kotlin.coroutines.CoroutineContext r7 = r0.b()
            androidx.room.f3$a r2 = androidx.room.f3.f7376d
            kotlin.coroutines.CoroutineContext$a r7 = r7.c(r2)
            androidx.room.f3 r7 = (androidx.room.f3) r7
            if (r7 == 0) goto L59
            kotlin.coroutines.d r7 = r7.e()
            if (r7 == 0) goto L59
            goto L68
        L59:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = d(r5, r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
        L68:
            androidx.room.RoomDatabaseKt$withTransaction$2 r2 = new androidx.room.RoomDatabaseKt$withTransaction$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.h.h(r7, r2, r0)
            if (r7 != r1) goto L7b
            return r1
        L7b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.e(androidx.room.RoomDatabase, ik.l, kotlin.coroutines.c):java.lang.Object");
    }
}
