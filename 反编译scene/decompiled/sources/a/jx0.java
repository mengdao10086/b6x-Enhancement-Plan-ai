package a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jx0 extends SQLiteOpenHelper {
    public jx0(Context context) {
        super(context, "auto_skip_config", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public boolean a(String str, String str2) {
        try {
            getWritableDatabase().execSQL("insert into auto_skip_ids(activity, viewId) values (?, ?)", new Object[]{str, str2});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean b() {
        try {
            getWritableDatabase().execSQL("delete from auto_skip_ids", new String[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String c(String str) {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("select viewId from auto_skip_ids where activity = ?", new String[]{str});
            try {
                if (cursorRawQuery.moveToNext()) {
                    return cursorRawQuery.getString(0);
                }
                cursorRawQuery.close();
                readableDatabase.close();
                return null;
            } finally {
                cursorRawQuery.close();
                readableDatabase.close();
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table auto_skip_ids(activity text primary key, viewId text)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
