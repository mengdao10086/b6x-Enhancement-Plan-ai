package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: loaded from: classes5.dex */
public class ap extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f23301b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ap f23302c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f23303d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f23304e = "DROP TABLE IF EXISTS stf";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f23305f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f23306a;

    private ap(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
        this.f23306a = context;
    }

    public static final int a() {
        return 1;
    }

    public static ap a(Context context) {
        ap apVar;
        synchronized (f23301b) {
            if (f23302c == null) {
                f23302c = new ap(context, ar.f23314b, null, 1);
            }
            apVar = f23302c;
        }
        return apVar;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f23303d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th2) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th2.getMessage());
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f23305f);
            } catch (Throwable unused) {
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public boolean c() {
        return !b(ar.f23315c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f23304e);
            sQLiteDatabase.execSQL(f23303d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        cursorQuery = writableDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase == null) {
                        return false;
                    }
                }
            }
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        writableDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public aq a(String str) {
        Cursor cursorA;
        aq aqVar = null;
        try {
            cursorA = a(str, new String[]{ar.f23321i, ar.f23317e, ar.f23318f, ar.f23319g, ar.f23322j, ar.f23323k}, null, null, null, null, null, "1");
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        aq aqVar2 = new aq();
                        try {
                            aqVar2.f23307a = cursorA.getString(0);
                            aqVar2.f23308b = cursorA.getString(1);
                            String string = cursorA.getString(2);
                            String string2 = cursorA.getString(3);
                            aqVar2.f23309c = i.a(this.f23306a).d(string);
                            aqVar2.f23310d = i.a(this.f23306a).d(string2);
                            aqVar2.f23311e = cursorA.getString(4);
                            aqVar2.f23312f = cursorA.getString(5);
                            aqVar = aqVar2;
                        } catch (Throwable unused) {
                            aqVar = aqVar2;
                            try {
                                d();
                                if (cursorA != null) {
                                }
                                return aqVar;
                            } finally {
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursorA = null;
        }
        if (cursorA != null) {
            cursorA.close();
        }
        return aqVar;
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
