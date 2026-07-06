package a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.omarea.model.SceneConfigInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fz0 extends SQLiteOpenHelper {
    public fz0(Context context) {
        super(context, "scene3_config", (SQLiteDatabase.CursorFactory) null, 6);
    }

    public SceneConfigInfo a(Cursor cursor) {
        SceneConfigInfo sceneConfigInfo = new SceneConfigInfo();
        sceneConfigInfo.packageName = cursor.getString(cursor.getColumnIndex("id"));
        sceneConfigInfo.aloneLight = cursor.getInt(cursor.getColumnIndex("alone_light")) == 1;
        sceneConfigInfo.aloneLightValue = cursor.getInt(cursor.getColumnIndex("light"));
        sceneConfigInfo.disNotice = cursor.getInt(cursor.getColumnIndex("dis_notice")) == 1;
        sceneConfigInfo.disButton = cursor.getInt(cursor.getColumnIndex("dis_button")) == 1;
        sceneConfigInfo.gpsOn = cursor.getInt(cursor.getColumnIndex("gps_on")) == 1;
        sceneConfigInfo.freeze = cursor.getInt(cursor.getColumnIndex("freeze")) == 1;
        sceneConfigInfo.screenOrientation = cursor.getInt(cursor.getColumnIndex("screen_orientation"));
        sceneConfigInfo.showMonitor = cursor.getInt(cursor.getColumnIndex("show_monitor")) == 1;
        return sceneConfigInfo;
    }

    public SceneConfigInfo b(String str) {
        if (!str.equals("standby")) {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor cursorRawQuery = readableDatabase.rawQuery("select * from scene_config3 where id = ?", new String[]{str});
                sceneConfigInfo = cursorRawQuery.moveToNext() ? a(cursorRawQuery) : null;
                cursorRawQuery.close();
                readableDatabase.close();
            } catch (Exception unused) {
                if (sceneConfigInfo == null) {
                    sceneConfigInfo = new SceneConfigInfo();
                    sceneConfigInfo.packageName = str;
                }
            } catch (Throwable th) {
                if (sceneConfigInfo == null) {
                    new SceneConfigInfo().packageName = str;
                }
                throw th;
            }
            if (sceneConfigInfo == null) {
                sceneConfigInfo = new SceneConfigInfo();
                sceneConfigInfo.packageName = str;
            }
        }
        return sceneConfigInfo;
    }

    public ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("select * from scene_config3 where freeze == 1", null);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(cursorRawQuery.getString(0));
            }
            cursorRawQuery.close();
            readableDatabase.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public ArrayList<String> d() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("select * from scene_config3 where gps_on == 1", null);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(cursorRawQuery.getString(0));
            }
            cursorRawQuery.close();
            readableDatabase.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public ArrayList<SceneConfigInfo> e(String str, String[] strArr) {
        ArrayList<SceneConfigInfo> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorQuery = readableDatabase.query("scene_config3", new String[]{"*"}, str, strArr, null, null, null);
            while (cursorQuery.moveToNext()) {
                arrayList.add(a(cursorQuery));
            }
            cursorQuery.close();
            readableDatabase.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public boolean f() {
        try {
            getWritableDatabase().execSQL("update scene_config3 set alone_light = 0, fg_cgroup_mem = '', screen_orientation = ?, bg_cgroup_mem = '', dynamic_boost_mem = 0, show_monitor = 0", new Object[]{-1});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean g(SceneConfigInfo sceneConfigInfo) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        getWritableDatabase().beginTransaction();
        try {
            writableDatabase.execSQL("delete from scene_config3 where id = ?", new String[]{sceneConfigInfo.packageName});
            Object[] objArr = new Object[9];
            objArr[0] = sceneConfigInfo.packageName;
            objArr[1] = Integer.valueOf(sceneConfigInfo.aloneLight ? 1 : 0);
            objArr[2] = Integer.valueOf(sceneConfigInfo.aloneLightValue);
            objArr[3] = Integer.valueOf(sceneConfigInfo.disNotice ? 1 : 0);
            objArr[4] = Integer.valueOf(sceneConfigInfo.disButton ? 1 : 0);
            objArr[5] = Integer.valueOf(sceneConfigInfo.gpsOn ? 1 : 0);
            objArr[6] = Integer.valueOf(sceneConfigInfo.freeze ? 1 : 0);
            objArr[7] = Integer.valueOf(sceneConfigInfo.screenOrientation);
            objArr[8] = Integer.valueOf(sceneConfigInfo.showMonitor ? 1 : 0);
            writableDatabase.execSQL("insert into scene_config3(id, alone_light, light, dis_notice, dis_button, gps_on, freeze, screen_orientation, show_monitor) values (?, ?, ?, ?, ?, ?, ?, ?, ?)", objArr);
            writableDatabase.setTransactionSuccessful();
            return true;
        } catch (Exception unused) {
            return false;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table scene_config3(id text primary key, alone_light int default(0), light int default(-1), dis_notice int default(0),dis_button int default(0),gps_on int default(0),freeze int default(0),screen_orientation int default(-1),fg_cgroup_mem text default(''),bg_cgroup_mem text default(''),dynamic_boost_mem int default(0),show_monitor int default(0))");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            try {
                sQLiteDatabase.execSQL("alter table scene_config3 add column screen_orientation int default(-1)");
            } catch (Exception unused) {
            }
        }
        if (i < 4) {
            try {
                sQLiteDatabase.execSQL("alter table scene_config3 add column fg_cgroup_mem text default('')");
                sQLiteDatabase.execSQL("alter table scene_config3 add column bg_cgroup_mem text default('')");
            } catch (Exception unused2) {
            }
        }
        if (i < 5) {
            try {
                sQLiteDatabase.execSQL("alter table scene_config3 add column dynamic_boost_mem text default(0)");
            } catch (Exception unused3) {
            }
        }
        if (i < 6) {
            try {
                sQLiteDatabase.execSQL("alter table scene_config3 add column show_monitor text default(0)");
            } catch (Exception unused4) {
            }
        }
    }
}
