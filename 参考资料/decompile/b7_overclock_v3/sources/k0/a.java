package k0;

import android.database.Cursor;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @l
    public static final byte[] a(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    @l
    public static final Double b(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i10));
    }

    @l
    public static final Float c(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i10));
    }

    @l
    public static final Integer d(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i10));
    }

    @l
    public static final Long e(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i10));
    }

    @l
    public static final Short f(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i10));
    }

    @l
    public static final String g(@k Cursor cursor, int i10) {
        f0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getString(i10);
    }
}
