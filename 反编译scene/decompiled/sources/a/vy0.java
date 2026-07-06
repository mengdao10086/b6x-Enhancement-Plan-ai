package a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vy0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uy0 f7734a = new uy0(null);
    public static final String b = "com.miui.powerkeeper";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3313a;

    public vy0(Context context, String str) {
        this.f3312a = context;
        this.f3313a = str;
    }

    public /* synthetic */ vy0(Context context, String str, b92 b92Var) {
        this(context, str);
    }

    public final void b() {
        d(c(), "xo_temp_threshold", "80");
        d(c(), "xo_temp_thresholdclr", "68");
        d(c(), "allowed_kill_some_back_pro_battery_temp_threshold", "53");
        d(c(), "allowed_kill_all_back_pro_battery_temp_threshold", "55");
        d(c(), "allowed_show_dialog_temp_threshhold", "53");
        d(c(), "allowed_show_benchmark_dialog_temp_threshhold", "50");
        d(c(), "exit_foreground_app_enable", "false");
        d(c(), "kill_some_back_pro_enable", "false");
        d(c(), "kill_all_back_pro_enable", "false");
        d(c(), "enable", "false");
        d(c(), "allowed_kill_battery_temp_threshhold", "55");
        d(c(), "key_thermal_enable", "false");
        d(c(), "key_temp_threshold", "60");
        d(c(), "key_temp_threshold_xo_thermal", "68");
        d(c(), "key_temp_threshold_bl_thermal", "80");
        d(c(), "txpower", "false");
        d(c(), "thermal_IECtest_config_enable", "false");
        d(c(), "thermal_sptm_config_enable", "false");
        File databasePath = this.f3312a.getDatabasePath(this.f3313a);
        f92.c(databasePath, "context.getDatabasePath(dbName)");
        String absolutePath = databasePath.getAbsolutePath();
        f92.c(absolutePath, "targetPath");
        String packageName = this.f3312a.getPackageName();
        f92.c(packageName, "context.packageName");
        String strT = bc2.t(absolutePath, packageName, b, false, 4, null);
        s60.f7366a.a("cp -f " + absolutePath + ' ' + strT + "\nchmod 0660 " + strT + "\nrestorecon -DFR " + strT + "\nchown system:system " + strT + "\nam force-stop " + b);
    }

    public final SQLiteDatabase c() {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = this.f3312a.openOrCreateDatabase(this.f3313a, 0, null);
        f92.c(sQLiteDatabaseOpenOrCreateDatabase, "context.openOrCreateData…ntext.MODE_PRIVATE, null)");
        return sQLiteDatabaseOpenOrCreateDatabase;
    }

    public final void d(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("value", str2);
        long jInsert = sQLiteDatabase.insert("misc", null, contentValues);
        if (jInsert == -1) {
            Log.e("Database", "插入失败: " + str);
            return;
        }
        Log.d("Database", "成功插入: " + str + ", ID: " + jInsert);
    }
}
