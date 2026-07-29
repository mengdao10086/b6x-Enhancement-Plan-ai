package ii;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class i {
    public static <T> void a(a<T> aVar, Cursor<T> cursor) {
        aVar.c(cursor);
    }

    public static void b() {
        Transaction.f32644g = true;
        Cursor.TRACK_CREATION_STACK = true;
    }

    public static Transaction c(BoxStore boxStore) {
        Transaction transaction = boxStore.f32631p.get();
        if (transaction == null) {
            throw new IllegalStateException("No active transaction");
        }
        transaction.c();
        return transaction;
    }

    public static <T> Cursor<T> d(a<T> aVar) {
        return aVar.j();
    }

    public static <T> long e(a<T> aVar) {
        return aVar.j().internalHandle();
    }

    public static long f(BoxStore boxStore) {
        return boxStore.j2();
    }

    public static long g(Cursor cursor) {
        return cursor.internalHandle();
    }

    public static long h(Transaction transaction) {
        return transaction.l();
    }

    public static <T> Cursor<T> i(a<T> aVar) {
        return aVar.q();
    }

    public static <T> Cursor<T> j(a<T> aVar) {
        return aVar.x();
    }

    public static <T> void k(a<T> aVar, Cursor<T> cursor) {
        aVar.O(cursor);
    }

    public static <T> void l(a<T> aVar, Cursor<T> cursor) {
        aVar.P(cursor);
    }

    public static void m(BoxStore boxStore, @Nullable si.e eVar) {
        boxStore.I2(eVar);
    }
}
