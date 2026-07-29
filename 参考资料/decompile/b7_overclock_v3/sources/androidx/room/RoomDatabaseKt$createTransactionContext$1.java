package androidx.room;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", i = {0, 0}, l = {99}, m = "createTransactionContext", n = {"$this$createTransactionContext", "controlJob"}, s = {"L$0", "L$1"})
@kotlin.d0(k = 3, mv = {1, 7, 1}, xi = 48)
public final class RoomDatabaseKt$createTransactionContext$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public RoomDatabaseKt$createTransactionContext$1(kotlin.coroutines.c<? super RoomDatabaseKt$createTransactionContext$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.d(null, this);
    }
}
