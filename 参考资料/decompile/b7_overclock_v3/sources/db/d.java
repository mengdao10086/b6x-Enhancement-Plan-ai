package db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f26131a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f26132b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f26133c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f26134d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26135e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f26136f = "ExoPlayerVersions";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f26137g = "feature";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f26138h = "instance_uid";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f26139i = "version";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f26140j = "feature = ? AND instance_uid = ?";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f26141k = "PRIMARY KEY (feature, instance_uid)";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f26142l = "CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))";

    public static String[] a(int i10, String str) {
        return new String[]{Integer.toString(i10), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i10, String str) throws DatabaseIOException {
        try {
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
        if (!u0.s1(sQLiteDatabase, f26136f)) {
            return -1;
        }
        Cursor cursorQuery = sQLiteDatabase.query(f26136f, new String[]{f26139i}, f26140j, a(i10, str), null, null, null);
        try {
            if (cursorQuery.getCount() == 0) {
                cursorQuery.close();
                return -1;
            }
            cursorQuery.moveToNext();
            int i11 = cursorQuery.getInt(0);
            cursorQuery.close();
            return i11;
        } finally {
        }
        throw new DatabaseIOException(e10);
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i10, String str) throws DatabaseIOException {
        try {
            if (u0.s1(sQLiteDatabase, f26136f)) {
                sQLiteDatabase.delete(f26136f, f26140j, a(i10, str));
            }
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i10, String str, int i11) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL(f26142l);
            ContentValues contentValues = new ContentValues();
            contentValues.put(f26137g, Integer.valueOf(i10));
            contentValues.put(f26138h, str);
            contentValues.put(f26139i, Integer.valueOf(i11));
            sQLiteDatabase.replaceOrThrow(f26136f, null, contentValues);
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }
}
