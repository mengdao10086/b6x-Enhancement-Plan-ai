package ni;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public interface b<T> {
    Cursor<T> createCursor(Transaction transaction, long j10, @Nullable BoxStore boxStore);
}
