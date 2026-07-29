package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;

/* JADX INFO: loaded from: classes5.dex */
class f extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f23590b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23591a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f23592a = new f(f.f23590b, h.b(f.f23590b), e.f23524b, null, 2);

        private a() {
        }
    }

    public static f a(Context context) {
        if (f23590b == null) {
            f23590b = context.getApplicationContext();
        }
        return a.f23592a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23591a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23591a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.f23565a, "__av")) {
            h.a(sQLiteDatabase, e.d.f23565a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f23565a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f23565a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f23565a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f23539a, "__av")) {
            h.a(sQLiteDatabase, e.b.f23539a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f23539a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f23528a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f23528a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f23528a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.f23565a);
        a(sQLiteDatabase, e.b.f23539a);
        a(sQLiteDatabase, e.a.f23528a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th2) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(f23590b);
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
                return;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused4) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i11 <= i10 || i10 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            e(sQLiteDatabase);
        }
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        this(new c(context, str), str2, cursorFactory, i10);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23591a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, TextUtils.isEmpty(str) ? e.f23524b : str, cursorFactory, i10);
        this.f23591a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f23565a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f23552a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f23539a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f23528a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23591a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
