package androidx.room;

import androidx.room.h1;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
@kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/flow/f;", "Lhk/n;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements ik.p<kotlinx.coroutines.flow.f<R>, kotlin.coroutines.c<? super kotlin.z1>, Object> {
    public final /* synthetic */ Callable<R> $callable;
    public final /* synthetic */ RoomDatabase $db;
    public final /* synthetic */ boolean $inTransaction;
    public final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @zj.d(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    @kotlin.d0(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super kotlin.z1>, Object> {
        public final /* synthetic */ kotlinx.coroutines.flow.f<R> $$this$flow;
        public final /* synthetic */ Callable<R> $callable;
        public final /* synthetic */ RoomDatabase $db;
        public final /* synthetic */ boolean $inTransaction;
        public final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @zj.d(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {127, 129}, m = "invokeSuspend", n = {}, s = {})
        @kotlin.d0(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class C00661 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super kotlin.z1>, Object> {
            public final /* synthetic */ Callable<R> $callable;
            public final /* synthetic */ RoomDatabase $db;
            public final /* synthetic */ a $observer;
            public final /* synthetic */ kotlinx.coroutines.channels.g<kotlin.z1> $observerChannel;
            public final /* synthetic */ kotlinx.coroutines.channels.g<R> $resultChannel;
            public Object L$0;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00661(RoomDatabase roomDatabase, a aVar, kotlinx.coroutines.channels.g<kotlin.z1> gVar, Callable<R> callable, kotlinx.coroutines.channels.g<R> gVar2, kotlin.coroutines.c<? super C00661> cVar) {
                super(2, cVar);
                this.$db = roomDatabase;
                this.$observer = aVar;
                this.$observerChannel = gVar;
                this.$callable = callable;
                this.$resultChannel = gVar2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.k
            public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                return new C00661(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, cVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0054 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:17:0x003e, B:21:0x004c, B:23:0x0054), top: B:35:0x003e }] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006a -> B:35:0x003e). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object q0(@yt.k java.lang.Object r8) throws java.lang.Throwable {
                /*
                    r7 = this;
                    java.lang.Object r0 = yj.b.h()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L29
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r7.L$0
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    kotlin.u0.n(r8)     // Catch: java.lang.Throwable -> L7c
                    r8 = r1
                    goto L3d
                L17:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1f:
                    java.lang.Object r1 = r7.L$0
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    kotlin.u0.n(r8)     // Catch: java.lang.Throwable -> L7c
                    r4 = r1
                    r1 = r7
                    goto L4c
                L29:
                    kotlin.u0.n(r8)
                    androidx.room.RoomDatabase r8 = r7.$db
                    androidx.room.h1 r8 = r8.o()
                    androidx.room.CoroutinesRoom$Companion$createFlow$1$1$a r1 = r7.$observer
                    r8.a(r1)
                    kotlinx.coroutines.channels.g<kotlin.z1> r8 = r7.$observerChannel     // Catch: java.lang.Throwable -> L7c
                    kotlinx.coroutines.channels.ChannelIterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L7c
                L3d:
                    r1 = r7
                L3e:
                    r1.L$0 = r8     // Catch: java.lang.Throwable -> L7a
                    r1.label = r3     // Catch: java.lang.Throwable -> L7a
                    java.lang.Object r4 = r8.a(r1)     // Catch: java.lang.Throwable -> L7a
                    if (r4 != r0) goto L49
                    return r0
                L49:
                    r6 = r4
                    r4 = r8
                    r8 = r6
                L4c:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L7a
                    boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L7a
                    if (r8 == 0) goto L6c
                    r4.next()     // Catch: java.lang.Throwable -> L7a
                    java.util.concurrent.Callable<R> r8 = r1.$callable     // Catch: java.lang.Throwable -> L7a
                    java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L7a
                    kotlinx.coroutines.channels.g<R> r5 = r1.$resultChannel     // Catch: java.lang.Throwable -> L7a
                    r1.L$0 = r4     // Catch: java.lang.Throwable -> L7a
                    r1.label = r2     // Catch: java.lang.Throwable -> L7a
                    java.lang.Object r8 = r5.G(r8, r1)     // Catch: java.lang.Throwable -> L7a
                    if (r8 != r0) goto L6a
                    return r0
                L6a:
                    r8 = r4
                    goto L3e
                L6c:
                    androidx.room.RoomDatabase r8 = r1.$db
                    androidx.room.h1 r8 = r8.o()
                    androidx.room.CoroutinesRoom$Companion$createFlow$1$1$a r0 = r1.$observer
                    r8.m(r0)
                    kotlin.z1 r8 = kotlin.z1.f38230a
                    return r8
                L7a:
                    r8 = move-exception
                    goto L7e
                L7c:
                    r8 = move-exception
                    r1 = r7
                L7e:
                    androidx.room.RoomDatabase r0 = r1.$db
                    androidx.room.h1 r0 = r0.o()
                    androidx.room.CoroutinesRoom$Companion$createFlow$1$1$a r1 = r1.$observer
                    r0.m(r1)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.C00661.q0(java.lang.Object):java.lang.Object");
            }

            @Override // ik.p
            @yt.l
            /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
            public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super kotlin.z1> cVar) {
                return ((C00661) M(o0Var, cVar)).q0(kotlin.z1.f38230a);
            }
        }

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$a */
        @kotlin.d0(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"androidx/room/CoroutinesRoom$Companion$createFlow$1$1$a", "Landroidx/room/h1$c;", "", "", "tables", "Lkotlin/z1;", "b", "room-ktx_release"}, k = 1, mv = {1, 7, 1})
        public static final class a extends h1.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.g<kotlin.z1> f7245b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String[] strArr, kotlinx.coroutines.channels.g<kotlin.z1> gVar) {
                super(strArr);
                this.f7245b = gVar;
            }

            @Override // androidx.room.h1.c
            public void b(@yt.k Set<String> tables) {
                kotlin.jvm.internal.f0.p(tables, "tables");
                this.f7245b.F(kotlin.z1.f38230a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, RoomDatabase roomDatabase, kotlinx.coroutines.flow.f<R> fVar, String[] strArr, Callable<R> callable, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$inTransaction = z10;
            this.$db = roomDatabase;
            this.$$this$flow = fVar;
            this.$tableNames = strArr;
            this.$callable = callable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            kotlin.coroutines.d dVarB;
            Object objH = yj.b.h();
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.u0.n(obj);
                kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.L$0;
                kotlinx.coroutines.channels.g gVarD = kotlinx.coroutines.channels.i.d(-1, null, null, 6, null);
                a aVar = new a(this.$tableNames, gVarD);
                gVarD.F(kotlin.z1.f38230a);
                f3 f3Var = (f3) o0Var.W().c(f3.f7376d);
                if (f3Var == null || (dVarB = f3Var.e()) == null) {
                    dVarB = this.$inTransaction ? k0.b(this.$db) : k0.a(this.$db);
                }
                kotlinx.coroutines.channels.g gVarD2 = kotlinx.coroutines.channels.i.d(0, null, null, 7, null);
                kotlinx.coroutines.j.f(o0Var, dVarB, null, new C00661(this.$db, aVar, gVarD, this.$callable, gVarD2, null), 2, null);
                kotlinx.coroutines.flow.f<R> fVar = this.$$this$flow;
                this.label = 1;
                if (kotlinx.coroutines.flow.g.l0(fVar, gVarD2, this) == objH) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(boolean z10, RoomDatabase roomDatabase, String[] strArr, Callable<R> callable, kotlin.coroutines.c<? super CoroutinesRoom$Companion$createFlow$1> cVar) {
        super(2, cVar);
        this.$inTransaction = z10;
        this.$db = roomDatabase;
        this.$tableNames = strArr;
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, cVar);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$inTransaction, this.$db, (kotlinx.coroutines.flow.f) this.L$0, this.$tableNames, this.$callable, null);
            this.label = 1;
            if (kotlinx.coroutines.p0.g(anonymousClass1, this) == objH) {
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
    public final Object r0(@yt.k kotlinx.coroutines.flow.f<R> fVar, @yt.l kotlin.coroutines.c<? super kotlin.z1> cVar) {
        return ((CoroutinesRoom$Companion$createFlow$1) M(fVar, cVar)).q0(kotlin.z1.f38230a);
    }
}
