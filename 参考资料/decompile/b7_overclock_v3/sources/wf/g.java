package wf;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes7.dex */
public class g {
    public static void a(Context context) {
        c(context).edit().clear().apply();
    }

    public static Object b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferencesC = c(context);
        if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return Integer.valueOf(sharedPreferencesC.getInt(str, ((Integer) obj).intValue()));
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return Float.valueOf(sharedPreferencesC.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferencesC.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferencesC.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof String) {
            return sharedPreferencesC.getString(str, (String) obj);
        }
        return null;
    }

    public static SharedPreferences c(Context context) {
        return context.getSharedPreferences("app_config", 0);
    }

    public static void d(Context context, String str, Object obj) {
        SharedPreferences.Editor editorEdit = c(context).edit();
        if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            editorEdit.putInt(str, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            editorEdit.putInt(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            editorEdit.putFloat(str, (float) ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        }
        editorEdit.commit();
    }

    public static void e(Context context, String str) {
        c(context).edit().remove(str).commit();
    }
}
