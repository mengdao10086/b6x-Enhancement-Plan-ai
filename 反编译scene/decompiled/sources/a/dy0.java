package a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dy0 extends SQLiteOpenHelper {
    public dy0(Context context) {
        super(context, "magisk_modules", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final boolean a() {
        try {
            getWritableDatabase().delete("modules", " 1 = 1", new String[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean b(cy0 cy0Var) {
        f92.d(cy0Var, "magiskModule");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            writableDatabase.delete("modules", " id = ?", new String[]{cy0Var.getId()});
            writableDatabase.execSQL("insert into modules(id, last_update, prop_url, zip_url, notes_url, name, version_name, version_code, author, description, support, donate, template) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{cy0Var.getId(), Long.valueOf(cy0Var.getLastUpdate()), cy0Var.getPropUrl(), cy0Var.getZipUrl(), cy0Var.getNotesUrl(), cy0Var.getName(), cy0Var.getVersionName(), cy0Var.getVersionCode(), cy0Var.getAuthor(), cy0Var.getDescription(), cy0Var.getSupport(), cy0Var.getDonate(), cy0Var.getTemplate()});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final ArrayList<cy0> c() {
        ArrayList<cy0> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursorRawQuery = readableDatabase.rawQuery("select id, name, description, version_name, version_code, author, prop_url, zip_url, notes_url from modules", new String[0]);
            while (cursorRawQuery.moveToNext()) {
                cy0 cy0Var = new cy0();
                String string = cursorRawQuery.getString(0);
                f92.c(string, "cursor.getString(0)");
                cy0Var.setId(string);
                cy0Var.setName(cursorRawQuery.getString(1));
                cy0Var.setDescription(cursorRawQuery.getString(2));
                cy0Var.setVersionName(cursorRawQuery.getString(3));
                cy0Var.setVersionCode(cursorRawQuery.getString(4));
                cy0Var.setAuthor(cursorRawQuery.getString(5));
                String string2 = cursorRawQuery.getString(6);
                f92.c(string2, "cursor.getString(6)");
                cy0Var.setPropUrl(string2);
                String string3 = cursorRawQuery.getString(7);
                f92.c(string3, "cursor.getString(7)");
                cy0Var.setZipUrl(string3);
                String string4 = cursorRawQuery.getString(8);
                f92.c(string4, "cursor.getString(8)");
                cy0Var.setNotesUrl(string4);
                arrayList.add(cy0Var);
            }
            cursorRawQuery.close();
            readableDatabase.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f92.d(sQLiteDatabase, "db");
        try {
            sQLiteDatabase.execSQL("create table modules(id text primary key, last_update REAL default(-1), prop_url int default(-1),zip_url text,notes_url text,name text,version_name text,version_code text,author text,description text,support text,donate text,template text)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f92.d(sQLiteDatabase, "db");
    }
}
