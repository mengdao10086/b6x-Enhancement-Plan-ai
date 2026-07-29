package fd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.database.DatabaseIOException;
import g.j1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f28039c = "ExoPlayerCacheFileMetadata";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28040d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f28041e = "name";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f28044h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f28045i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f28046j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f28047k = "name = ?";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f28049m = "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final db.a f28050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f28051b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f28042f = "length";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f28043g = "last_touch_timestamp";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f28048l = {"name", f28042f, f28043g};

    public c(db.a aVar) {
        this.f28050a = aVar;
    }

    @j1
    public static void a(db.a aVar, long j10) throws DatabaseIOException {
        String hexString = Long.toHexString(j10);
        try {
            String strE = e(hexString);
            SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                db.d.c(writableDatabase, 2, hexString);
                b(writableDatabase, strE);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    public static void b(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public static String e(String str) {
        return f28039c + str;
    }

    @j1
    public Map<String, b> c() throws DatabaseIOException {
        try {
            Cursor cursorD = d();
            try {
                HashMap map = new HashMap(cursorD.getCount());
                while (cursorD.moveToNext()) {
                    map.put(cursorD.getString(0), new b(cursorD.getLong(1), cursorD.getLong(2)));
                }
                cursorD.close();
                return map;
            } finally {
            }
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    public final Cursor d() {
        hd.a.g(this.f28051b);
        return this.f28050a.getReadableDatabase().query(this.f28051b, f28048l, null, null, null, null, null);
    }

    @j1
    public void f(long j10) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j10);
            this.f28051b = e(hexString);
            if (db.d.b(this.f28050a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f28050a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    db.d.d(writableDatabase, 2, hexString, 1);
                    b(writableDatabase, this.f28051b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f28051b + i0.f11861z + f28049m);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            }
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @j1
    public void g(String str) throws DatabaseIOException {
        hd.a.g(this.f28051b);
        try {
            this.f28050a.getWritableDatabase().delete(this.f28051b, f28047k, new String[]{str});
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @j1
    public void h(Set<String> set) throws DatabaseIOException {
        hd.a.g(this.f28051b);
        try {
            SQLiteDatabase writableDatabase = this.f28050a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it2 = set.iterator();
                while (it2.hasNext()) {
                    writableDatabase.delete(this.f28051b, f28047k, new String[]{it2.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }

    @j1
    public void i(String str, long j10, long j11) throws DatabaseIOException {
        hd.a.g(this.f28051b);
        try {
            SQLiteDatabase writableDatabase = this.f28050a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put(f28042f, Long.valueOf(j10));
            contentValues.put(f28043g, Long.valueOf(j11));
            writableDatabase.replaceOrThrow(this.f28051b, null, contentValues);
        } catch (SQLException e10) {
            throw new DatabaseIOException(e10);
        }
    }
}
