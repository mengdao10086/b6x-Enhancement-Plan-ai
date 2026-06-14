package a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.omarea.model.ActivityCacheInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ix0 extends SQLiteOpenHelper {
    public ix0(Context context) {
        super(context, "scene_app_contents", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void a(ActivityInfo activityInfo, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", activityInfo.name);
        contentValues.put("package_name", activityInfo.packageName);
        contentValues.put("exported", Integer.valueOf(activityInfo.exported ? 1 : 0));
        contentValues.put("enabled", Integer.valueOf(activityInfo.isEnabled() ? 1 : 0));
        contentValues.put("label", str);
        getWritableDatabase().insert("activities", "name", contentValues);
    }

    public void b(ProviderInfo providerInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", providerInfo.name);
        contentValues.put("package_name", providerInfo.packageName);
        contentValues.put("exported", Integer.valueOf(providerInfo.exported ? 1 : 0));
        contentValues.put("enabled", Integer.valueOf(providerInfo.isEnabled() ? 1 : 0));
        contentValues.put("authority", providerInfo.authority);
        getWritableDatabase().insert("providers", "name", contentValues);
    }

    public void c(ActivityInfo activityInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", activityInfo.name);
        contentValues.put("package_name", activityInfo.packageName);
        contentValues.put("exported", Integer.valueOf(activityInfo.exported ? 1 : 0));
        contentValues.put("enabled", Integer.valueOf(activityInfo.isEnabled() ? 1 : 0));
        getWritableDatabase().insert("receivers", "name", contentValues);
    }

    public void d(ServiceInfo serviceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", serviceInfo.name);
        contentValues.put("package_name", serviceInfo.packageName);
        contentValues.put("exported", Integer.valueOf(serviceInfo.exported ? 1 : 0));
        contentValues.put("enabled", Integer.valueOf(serviceInfo.isEnabled() ? 1 : 0));
        getWritableDatabase().insert("services", "name", contentValues);
    }

    public void e() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("activities", "package_name NOT IN (SELECT package_name FROM apps)", new String[0]);
        writableDatabase.delete("providers", "package_name NOT IN (SELECT package_name FROM apps)", new String[0]);
        writableDatabase.delete("services", "package_name NOT IN (SELECT package_name FROM apps)", new String[0]);
        writableDatabase.delete("receivers", "package_name NOT IN (SELECT package_name FROM apps)", new String[0]);
    }

    public void f(String str) {
        getWritableDatabase().delete("activities", "package_name = ?", new String[]{str});
    }

    public void g(String str) {
        getWritableDatabase().delete("providers", "package_name = ?", new String[]{str});
    }

    public void h(String str) {
        getWritableDatabase().delete("receivers", "package_name = ?", new String[]{str});
    }

    public void i(String str) {
        getWritableDatabase().delete("services", "package_name = ?", new String[]{str});
    }

    public long j(String str) {
        try {
            Cursor cursorRawQuery = getWritableDatabase().rawQuery("select version from apps where package_name = ?", new String[]{str});
            j = cursorRawQuery.moveToNext() ? cursorRawQuery.getLong(0) : 0L;
            cursorRawQuery.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return j;
    }

    public ArrayList<ActivityCacheInfo> k(String str) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("select name, package_name, exported, enabled, label from activities where name like ? or package_name like ? or label like ?", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"});
        ArrayList<ActivityCacheInfo> arrayList = new ArrayList<>();
        while (cursorRawQuery.moveToNext()) {
            try {
                arrayList.add(new ex0(this, cursorRawQuery));
            } finally {
                cursorRawQuery.close();
            }
        }
        return arrayList;
    }

    public ArrayList<ActivityCacheInfo> l(String str, String str2) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("select name, package_name, exported, enabled, label from activities where package_name = ? and (name like ? or label like ?)", new String[]{str, "%" + str2 + "%", "%" + str2 + "%"});
        ArrayList<ActivityCacheInfo> arrayList = new ArrayList<>();
        while (cursorRawQuery.moveToNext()) {
            try {
                arrayList.add(new fx0(this, cursorRawQuery));
            } finally {
                cursorRawQuery.close();
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.omarea.model.ActivityCacheInfo> m(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = -987494927(0xffffffffc52405f1, float:-2624.3713)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -808719889(0xffffffffcfcbe9ef, float:-6.842212E9)
            if (r0 == r1) goto L21
            r1 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "service"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L35
            r7 = r3
            goto L36
        L21:
            java.lang.String r0 = "receiver"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L35
            r7 = r2
            goto L36
        L2b:
            java.lang.String r0 = "provider"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L35
            r7 = r4
            goto L36
        L35:
            r7 = -1
        L36:
            if (r7 == 0) goto L45
            if (r7 == r4) goto L42
            if (r7 == r3) goto L3f
            java.lang.String r7 = "activities"
            goto L47
        L3f:
            java.lang.String r7 = "services"
            goto L47
        L42:
            java.lang.String r7 = "providers"
            goto L47
        L45:
            java.lang.String r7 = "receivers"
        L47:
            android.database.sqlite.SQLiteDatabase r0 = r6.getReadableDatabase()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "%"
            r1.append(r5)
            r1.append(r8)
            r1.append(r5)
            java.lang.String r8 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "select name, package_name, exported, enabled from "
            r1.append(r5)
            r1.append(r7)
            java.lang.String r7 = " where name like ? or package_name like ?"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String[] r1 = new java.lang.String[r3]
            r1[r2] = r8
            r1[r4] = r8
            android.database.Cursor r7 = r0.rawQuery(r7, r1)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L84:
            boolean r0 = r7.moveToNext()     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L93
            a.gx0 r0 = new a.gx0     // Catch: java.lang.Throwable -> L97
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L97
            r8.add(r0)     // Catch: java.lang.Throwable -> L97
            goto L84
        L93:
            r7.close()
            return r8
        L97:
            r8 = move-exception
            r7.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ix0.m(java.lang.String, java.lang.String):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.omarea.model.ActivityCacheInfo> n(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.getReadableDatabase()
            int r1 = r7.hashCode()
            r2 = -987494927(0xffffffffc52405f1, float:-2624.3713)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L2f
            r2 = -808719889(0xffffffffcfcbe9ef, float:-6.842212E9)
            if (r1 == r2) goto L25
            r2 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r1 == r2) goto L1b
            goto L39
        L1b:
            java.lang.String r1 = "service"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L39
            r7 = r4
            goto L3a
        L25:
            java.lang.String r1 = "receiver"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L39
            r7 = r3
            goto L3a
        L2f:
            java.lang.String r1 = "provider"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L39
            r7 = r5
            goto L3a
        L39:
            r7 = -1
        L3a:
            if (r7 == 0) goto L49
            if (r7 == r5) goto L46
            if (r7 == r4) goto L43
            java.lang.String r7 = "activities"
            goto L4b
        L43:
            java.lang.String r7 = "services"
            goto L4b
        L46:
            java.lang.String r7 = "providers"
            goto L4b
        L49:
            java.lang.String r7 = "receivers"
        L4b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "select name, package_name, exported, enabled from "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = " where package_name = ? and name like ?"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String[] r1 = new java.lang.String[r4]
            r1[r3] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "%"
            r8.append(r2)
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r1[r5] = r8
            android.database.Cursor r7 = r0.rawQuery(r7, r1)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L84:
            boolean r9 = r7.moveToNext()     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L98
            if (r9 == 0) goto L98
            a.hx0 r9 = new a.hx0     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L98
            r9.<init>(r6, r7)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L98
            r8.add(r9)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L98
            goto L84
        L93:
            r8 = move-exception
            r7.close()
            throw r8
        L98:
            r7.close()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ix0.n(java.lang.String, java.lang.String, java.lang.String):java.util.ArrayList");
    }

    public void o(PackageInfo packageInfo) {
        getWritableDatabase().delete("apps", "package_name = ?", new String[]{packageInfo.packageName});
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", packageInfo.packageName);
        contentValues.put("version", Long.valueOf(Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode));
        getWritableDatabase().insert("apps", "", contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table apps(id INTEGER primary key AUTOINCREMENT, package_name text COLLATE NOCASE, version bigint)");
            sQLiteDatabase.execSQL("create table activities(id INTEGER primary key AUTOINCREMENT, package_name text COLLATE NOCASE, name text COLLATE NOCASE, exported REAL,enabled REAL,label text COLLATE NOCASE)");
            sQLiteDatabase.execSQL("create table services(id INTEGER primary key AUTOINCREMENT, package_name text COLLATE NOCASE, name text COLLATE NOCASE, exported REAL,enabled REAL)");
            sQLiteDatabase.execSQL("create table providers(id INTEGER primary key AUTOINCREMENT, package_name text COLLATE NOCASE, name text COLLATE NOCASE, exported REAL,enabled REAL,authority text COLLATE NOCASE)");
            sQLiteDatabase.execSQL("create table receivers(id INTEGER primary key AUTOINCREMENT, package_name text COLLATE NOCASE, name text COLLATE NOCASE, exported REAL,enabled REAL)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("alter table apps add column version bigint");
    }
}
