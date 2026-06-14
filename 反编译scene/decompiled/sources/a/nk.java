package a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class nk {
    public static boolean a(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String strD = d(context, uri);
        int iE = e(context, uri, "flags", 0);
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        if ((iE & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(strD) || (iE & 8) == 0) {
            return (TextUtils.isEmpty(strD) || (iE & 2) == 0) ? false : true;
        }
        return true;
    }

    public static void b(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static String c(Context context, Uri uri) {
        return g(context, uri, "_display_name", null);
    }

    public static String d(Context context, Uri uri) {
        return g(context, uri, "mime_type", null);
    }

    public static int e(Context context, Uri uri, String str, int i) {
        return (int) f(context, uri, str, i);
    }

    public static long f(Context context, Uri uri, String str, long j) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) ? j : cursorQuery.getLong(0);
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return j;
        } finally {
            b(cursorQuery);
        }
        b(cursorQuery);
    }

    public static String g(Context context, Uri uri, String str, String str2) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) ? str2 : cursorQuery.getString(0);
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return str2;
        } finally {
            b(cursorQuery);
        }
        b(cursorQuery);
    }
}
