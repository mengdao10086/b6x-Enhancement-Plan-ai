package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import c2.b;
import java.util.concurrent.Callable;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@kotlin.d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "<init>", "()V", "a", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1})
public final class CoroutinesRoom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final Companion f7244a = new Companion(null);

    @kotlin.d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ?\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJL\u0010\u0014\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00130\u0012\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "c", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "b", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "", "tableNames", "Lkotlinx/coroutines/flow/e;", "Lhk/n;", "a", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/e;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final <R> kotlinx.coroutines.flow.e<R> a(@yt.k RoomDatabase db2, boolean z10, @yt.k String[] tableNames, @yt.k Callable<R> callable) {
            kotlin.jvm.internal.f0.p(db2, "db");
            kotlin.jvm.internal.f0.p(tableNames, "tableNames");
            kotlin.jvm.internal.f0.p(callable, "callable");
            return kotlinx.coroutines.flow.g.J0(new CoroutinesRoom$Companion$createFlow$1(z10, db2, tableNames, callable, null));
        }

        @hk.m
        @yt.l
        public final <R> Object b(@yt.k RoomDatabase roomDatabase, boolean z10, @yt.k final CancellationSignal cancellationSignal, @yt.k Callable<R> callable, @yt.k kotlin.coroutines.c<? super R> cVar) {
            kotlin.coroutines.d dVarB;
            if (roomDatabase.C() && roomDatabase.w()) {
                return callable.call();
            }
            f3 f3Var = (f3) cVar.b().c(f3.f7376d);
            if (f3Var == null || (dVarB = f3Var.e()) == null) {
                dVarB = z10 ? k0.b(roomDatabase) : k0.a(roomDatabase);
            }
            kotlin.coroutines.d dVar = dVarB;
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            pVar.Q();
            final kotlinx.coroutines.c2 c2VarF = kotlinx.coroutines.j.f(kotlinx.coroutines.u1.f39074a, dVar, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, pVar, null), 2, null);
            pVar.B(new ik.l<Throwable, kotlin.z1>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(@yt.l Throwable th2) {
                    b.a.a(cancellationSignal);
                    c2.a.b(c2VarF, null, 1, null);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
                    b(th2);
                    return kotlin.z1.f38230a;
                }
            });
            Object objC = pVar.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
            return objC;
        }

        @hk.m
        @yt.l
        public final <R> Object c(@yt.k RoomDatabase roomDatabase, boolean z10, @yt.k Callable<R> callable, @yt.k kotlin.coroutines.c<? super R> cVar) {
            kotlin.coroutines.d dVarB;
            if (roomDatabase.C() && roomDatabase.w()) {
                return callable.call();
            }
            f3 f3Var = (f3) cVar.b().c(f3.f7376d);
            if (f3Var == null || (dVarB = f3Var.e()) == null) {
                dVarB = z10 ? k0.b(roomDatabase) : k0.a(roomDatabase);
            }
            return kotlinx.coroutines.h.h(dVarB, new CoroutinesRoom$Companion$execute$2(callable, null), cVar);
        }
    }

    @hk.m
    @yt.k
    public static final <R> kotlinx.coroutines.flow.e<R> a(@yt.k RoomDatabase roomDatabase, boolean z10, @yt.k String[] strArr, @yt.k Callable<R> callable) {
        return f7244a.a(roomDatabase, z10, strArr, callable);
    }

    @hk.m
    @yt.l
    public static final <R> Object b(@yt.k RoomDatabase roomDatabase, boolean z10, @yt.k CancellationSignal cancellationSignal, @yt.k Callable<R> callable, @yt.k kotlin.coroutines.c<? super R> cVar) {
        return f7244a.b(roomDatabase, z10, cancellationSignal, callable, cVar);
    }

    @hk.m
    @yt.l
    public static final <R> Object c(@yt.k RoomDatabase roomDatabase, boolean z10, @yt.k Callable<R> callable, @yt.k kotlin.coroutines.c<? super R> cVar) {
        return f7244a.c(roomDatabase, z10, callable, cVar);
    }
}
