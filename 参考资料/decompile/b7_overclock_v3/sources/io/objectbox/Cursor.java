package io.objectbox;

import io.objectbox.relation.ToMany;
import java.io.Closeable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import li.a;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
@c
@NotThreadSafe
@a
public abstract class Cursor<T> implements Closeable {

    @c
    public static boolean LOG_READ_NOT_CLOSED = false;
    public static final int PUT_FLAG_COMPLETE = 2;
    public static final int PUT_FLAG_FIRST = 1;

    @c
    public static boolean TRACK_CREATION_STACK;
    public final BoxStore boxStoreForEntities;
    public boolean closed;
    private final Throwable creationThrowable;
    public final long cursor;
    public final EntityInfo<T> entityInfo;
    public final boolean readOnly;
    public final Transaction tx;

    public Cursor(Transaction transaction, long j10, EntityInfo<T> entityInfo, BoxStore boxStore) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction is null");
        }
        this.tx = transaction;
        this.readOnly = transaction.e0();
        this.cursor = j10;
        this.entityInfo = entityInfo;
        this.boxStoreForEntities = boxStore;
        for (Property<T> property : entityInfo.getAllProperties()) {
            if (!property.Z()) {
                property.b1(getPropertyId(property.dbName));
            }
        }
        this.creationThrowable = TRACK_CREATION_STACK ? new Throwable() : null;
        nativeSetBoxStoreForEntities(j10, boxStore);
    }

    public static native long collect002033(long j10, long j11, int i10, int i11, long j12, int i12, long j13, int i13, float f10, int i14, float f11, int i15, float f12, int i16, double d10, int i17, double d11, int i18, double d12);

    public static native long collect004000(long j10, long j11, int i10, int i11, long j12, int i12, long j13, int i13, long j14, int i14, long j15);

    public static native long collect313311(long j10, long j11, int i10, int i11, @Nullable String str, int i12, @Nullable String str2, int i13, @Nullable String str3, int i14, @Nullable byte[] bArr, int i15, long j12, int i16, long j13, int i17, long j14, int i18, int i19, int i20, int i21, int i22, int i23, int i24, float f10, int i25, double d10);

    public static native long collect400000(long j10, long j11, int i10, int i11, @Nullable String str, int i12, @Nullable String str2, int i13, @Nullable String str3, int i14, @Nullable String str4);

    public static native long collect430000(long j10, long j11, int i10, int i11, @Nullable String str, int i12, @Nullable String str2, int i13, @Nullable String str3, int i14, @Nullable String str4, int i15, @Nullable byte[] bArr, int i16, @Nullable byte[] bArr2, int i17, @Nullable byte[] bArr3);

    public static native long collectStringArray(long j10, long j11, int i10, int i11, @Nullable String[] strArr);

    public static native long collectStringList(long j10, long j11, int i10, int i11, @Nullable List<String> list);

    public static native boolean nativeDeleteEntity(long j10, long j11);

    public static native Object nativeFirstEntity(long j10);

    public static native Object nativeGetEntity(long j10, long j11);

    public static native long nativeLookupKeyUsingIndex(long j10, int i10, String str);

    public static native Object nativeNextEntity(long j10);

    public static native boolean nativeSeek(long j10, long j11);

    public <TARGET> void checkApplyToManyToDb(List<TARGET> list, Class<TARGET> cls) {
        if (list instanceof ToMany) {
            ToMany toMany = (ToMany) list;
            if (toMany.z()) {
                Cursor<TARGET> relationTargetCursor = getRelationTargetCursor(cls);
                try {
                    toMany.y(this, relationTargetCursor);
                    if (relationTargetCursor != null) {
                        relationTargetCursor.close();
                    }
                } catch (Throwable th2) {
                    if (relationTargetCursor != null) {
                        try {
                            relationTargetCursor.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            Transaction transaction = this.tx;
            if (transaction != null && !transaction.k().isClosed()) {
                nativeDestroy(this.cursor);
            }
        }
    }

    public long count(long j10) {
        return nativeCount(this.cursor, j10);
    }

    public void deleteAll() {
        nativeDeleteAll(this.cursor);
    }

    public boolean deleteEntity(long j10) {
        return nativeDeleteEntity(this.cursor, j10);
    }

    public void finalize() throws Throwable {
        if (this.closed) {
            return;
        }
        if (!this.readOnly || LOG_READ_NOT_CLOSED) {
            System.err.println("Cursor was not closed.");
            if (this.creationThrowable != null) {
                System.err.println("Cursor was initially created here:");
                this.creationThrowable.printStackTrace();
            }
            System.err.flush();
        }
        close();
        super.finalize();
    }

    public T first() {
        return (T) nativeFirstEntity(this.cursor);
    }

    public T get(long j10) {
        return (T) nativeGetEntity(this.cursor, j10);
    }

    public List<T> getAll() {
        return nativeGetAllEntities(this.cursor);
    }

    @c
    public List<T> getBacklinkEntities(int i10, Property<?> property, long j10) {
        try {
            return nativeGetBacklinkEntities(this.cursor, i10, property.C(), j10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Please check if the given property belongs to a valid @Relation: " + property, e10);
        }
    }

    @c
    public long[] getBacklinkIds(int i10, Property<?> property, long j10) {
        try {
            return nativeGetBacklinkIds(this.cursor, i10, property.C(), j10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Please check if the given property belongs to a valid @Relation: " + property, e10);
        }
    }

    public EntityInfo<T> getEntityInfo() {
        return this.entityInfo;
    }

    public abstract long getId(T t10);

    public int getPropertyId(String str) {
        return nativePropertyId(this.cursor, str);
    }

    @c
    public List<T> getRelationEntities(int i10, int i11, long j10, boolean z10) {
        return nativeGetRelationEntities(this.cursor, i10, i11, j10, z10);
    }

    @c
    public long[] getRelationIds(int i10, int i11, long j10, boolean z10) {
        return nativeGetRelationIds(this.cursor, i10, i11, j10, z10);
    }

    public <TARGET> Cursor<TARGET> getRelationTargetCursor(Class<TARGET> cls) {
        EntityInfo<T> entityInfoP1 = this.boxStoreForEntities.p1(cls);
        return entityInfoP1.getCursorFactory().createCursor(this.tx, nativeGetCursorFor(this.cursor, entityInfoP1.getEntityId()), this.boxStoreForEntities);
    }

    public Transaction getTx() {
        return this.tx;
    }

    @c
    public long internalHandle() {
        return this.cursor;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isObsolete() {
        return this.tx.n();
    }

    public long lookupKeyUsingIndex(int i10, String str) {
        return nativeLookupKeyUsingIndex(this.cursor, i10, str);
    }

    @c
    public void modifyRelations(int i10, long j10, long[] jArr, boolean z10) {
        nativeModifyRelations(this.cursor, i10, j10, jArr, z10);
    }

    @c
    public void modifyRelationsSingle(int i10, long j10, long j11, boolean z10) {
        nativeModifyRelationsSingle(this.cursor, i10, j10, j11, z10);
    }

    public native long nativeCount(long j10, long j11);

    public native void nativeDeleteAll(long j10);

    public native void nativeDestroy(long j10);

    public native List<T> nativeGetAllEntities(long j10);

    public native List<T> nativeGetBacklinkEntities(long j10, int i10, int i11, long j11);

    public native long[] nativeGetBacklinkIds(long j10, int i10, int i11, long j11);

    public native long nativeGetCursorFor(long j10, int i10);

    public native List<T> nativeGetRelationEntities(long j10, int i10, int i11, long j11, boolean z10);

    public native long[] nativeGetRelationIds(long j10, int i10, int i11, long j11, boolean z10);

    public native void nativeModifyRelations(long j10, int i10, long j11, long[] jArr, boolean z10);

    public native void nativeModifyRelationsSingle(long j10, int i10, long j11, long j12, boolean z10);

    public native int nativePropertyId(long j10, String str);

    public native long nativeRenew(long j10);

    public native void nativeSetBoxStoreForEntities(long j10, Object obj);

    public T next() {
        return (T) nativeNextEntity(this.cursor);
    }

    public abstract long put(T t10);

    public void renew() {
        nativeRenew(this.cursor);
    }

    public boolean seek(long j10) {
        return nativeSeek(this.cursor, j10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cursor ");
        sb2.append(Long.toString(this.cursor, 16));
        sb2.append(isClosed() ? "(closed)" : "");
        return sb2.toString();
    }
}
