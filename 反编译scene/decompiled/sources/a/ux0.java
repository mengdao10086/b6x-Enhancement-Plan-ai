package a;

import android.database.Cursor;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ux0 {
    public static final int a(Cursor cursor, String str) {
        f92.d(cursor, "$this$getInt");
        f92.d(str, "key");
        return cursor.getInt(cursor.getColumnIndexOrThrow(str));
    }

    public static final long b(Cursor cursor, String str) {
        f92.d(cursor, "$this$getLong");
        f92.d(str, "key");
        return cursor.getLong(cursor.getColumnIndexOrThrow(str));
    }

    public static final String c(Cursor cursor, String str) {
        f92.d(cursor, "$this$getString");
        f92.d(str, "key");
        String string = cursor.getString(cursor.getColumnIndexOrThrow(str));
        return string != null ? string : "";
    }
}
