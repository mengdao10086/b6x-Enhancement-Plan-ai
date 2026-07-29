package com.arialyy.aria.orm;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.arialyy.aria.util.CommonUtil;
import fh.a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class DatabaseContext extends ContextWrapper {
    public DatabaseContext(Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        String str2 = CommonUtil.getAppPath(getBaseContext()) + "DB";
        String str3 = str2 + a.f28350w + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean zCreateNewFile = false;
        File file2 = new File(str3);
        if (file2.exists()) {
            zCreateNewFile = true;
        } else {
            try {
                zCreateNewFile = file2.createNewFile();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        if (zCreateNewFile) {
            return file2;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
    }
}
