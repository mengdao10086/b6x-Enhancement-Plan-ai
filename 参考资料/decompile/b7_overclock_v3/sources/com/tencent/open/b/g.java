package com.tencent.open.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class g extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f22681a = {"key"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f22682b;

    public g(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized g a() {
        if (f22682b == null) {
            f22682b = new g(com.tencent.open.utils.f.a());
        }
        return f22682b;
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
            } catch (Exception e10) {
                SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e10);
            }
            return;
        } finally {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    public synchronized List<Serializable> a(String str) {
        ObjectInputStream objectInputStream;
        Serializable serializable;
        List<Serializable> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        if (TextUtils.isEmpty(str)) {
            return listSynchronizedList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return listSynchronizedList;
        }
        Cursor cursor = null;
        ObjectInputStream objectInputStream2 = null;
        cursor = null;
        try {
            try {
                Cursor cursorQuery = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            do {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursorQuery.getBlob(cursorQuery.getColumnIndex("blob")));
                                try {
                                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                    try {
                                        serializable = (Serializable) objectInputStream.readObject();
                                        try {
                                            objectInputStream.close();
                                        } catch (IOException unused) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                    } catch (Exception unused3) {
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                            } catch (IOException unused4) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                        serializable = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        objectInputStream2 = objectInputStream;
                                        if (objectInputStream2 != null) {
                                            try {
                                                objectInputStream2.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (IOException unused7) {
                                            throw th;
                                        }
                                    }
                                } catch (Exception unused8) {
                                    objectInputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                if (serializable != null) {
                                    listSynchronizedList.add(serializable);
                                }
                            } while (cursorQuery.moveToNext());
                        }
                    } catch (Exception e10) {
                        e = e10;
                        cursor = cursorQuery;
                        SLog.e("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        readableDatabase.close();
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e11) {
                e = e11;
            }
            readableDatabase.close();
            return listSynchronizedList;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.beginTransaction();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                for (int i10 = 0; i10 < size; i10++) {
                    Serializable serializable = list.get(i10);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                objectOutputStream.writeObject(serializable);
                                try {
                                    objectOutputStream.close();
                                } catch (IOException unused) {
                                }
                            } catch (IOException unused2) {
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException unused4) {
                                    throw th;
                                }
                            }
                        } catch (IOException unused5) {
                            objectOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                        }
                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                        writableDatabase.insert("via_cgi_report", null, contentValues);
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th4) {
                writableDatabase.endTransaction();
                writableDatabase.close();
                throw th4;
            }
        } catch (Exception unused7) {
            SLog.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
            writableDatabase.endTransaction();
        }
        writableDatabase.close();
    }
}
