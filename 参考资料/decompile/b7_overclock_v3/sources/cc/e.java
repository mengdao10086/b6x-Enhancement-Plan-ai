package cc;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends Closeable {
    c D1();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getCount();

    int getPosition();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i10);

    boolean moveToPrevious();
}
