package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroidx/room/RoomDatabase;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "b", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "transactionDispatcher", "room-ktx_release"}, k = 2, mv = {1, 7, 1})
public final class k0 {
    @yt.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final CoroutineDispatcher a(@yt.k RoomDatabase roomDatabase) {
        kotlin.jvm.internal.f0.p(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.m();
        kotlin.jvm.internal.f0.o(backingFieldMap, "backingFieldMap");
        Object objC = backingFieldMap.get("QueryDispatcher");
        if (objC == null) {
            Executor queryExecutor = roomDatabase.q();
            kotlin.jvm.internal.f0.o(queryExecutor, "queryExecutor");
            objC = kotlinx.coroutines.r1.c(queryExecutor);
            backingFieldMap.put("QueryDispatcher", objC);
        }
        kotlin.jvm.internal.f0.n(objC, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) objC;
    }

    @yt.k
    public static final CoroutineDispatcher b(@yt.k RoomDatabase roomDatabase) {
        kotlin.jvm.internal.f0.p(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.m();
        kotlin.jvm.internal.f0.o(backingFieldMap, "backingFieldMap");
        Object objC = backingFieldMap.get("TransactionDispatcher");
        if (objC == null) {
            Executor transactionExecutor = roomDatabase.u();
            kotlin.jvm.internal.f0.o(transactionExecutor, "transactionExecutor");
            objC = kotlinx.coroutines.r1.c(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", objC);
        }
        kotlin.jvm.internal.f0.n(objC, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) objC;
    }
}
