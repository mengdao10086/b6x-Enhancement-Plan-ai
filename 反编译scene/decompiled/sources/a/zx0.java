package a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yx0 f8105a = new yx0(null);
    public static final String d = "com.xiaomi.joyose";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3903a;
    public final String b;
    public final String c;

    public zx0(Context context, String str) {
        this.f3902a = context;
        this.c = str;
        this.f3903a = "booster_config";
        this.b = "common_config";
    }

    public /* synthetic */ zx0(Context context, String str, b92 b92Var) {
        this(context, str);
    }

    public static /* synthetic */ g30 d(zx0 zx0Var, g30 g30Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return zx0Var.c(g30Var, z);
    }

    public final g30 b(String str, boolean z) {
        try {
            g30 g30Var = new g30(str);
            g30 g30VarG = f92.a(this.c, "SmartP.db") ? g30Var : f92.a(this.c, "default_cloud.db") ? g30Var.g(this.f3903a).g("params") : g30Var.g("params");
            f92.c(g30VarG, "params");
            l(g30VarG, new String[]{"game_booster", "dynamic_fps_global"});
            if (g30VarG.j("game_booster")) {
                g30 g30VarG2 = g30VarG.g("game_booster");
                if (g30VarG2.j(this.f3903a)) {
                    g30 g30VarG3 = g30VarG2.g(this.f3903a);
                    f92.c(g30VarG2, "gb");
                    q(g30VarG2, new String[]{"cgame_enable"}, Boolean.FALSE);
                    String str2 = g30VarG3.j("ovrride_config") ? "ovrride_config" : "scene_config";
                    if (g30VarG3.j(str2)) {
                        if (z) {
                            g30VarG3.x("ovrride_config", new d30());
                            p(g30VarG2, "migl_config", new d30());
                            p(g30VarG2, "support_scale_app_list", new d30());
                            p(g30VarG2, "force_scale_app_list", new d30());
                            p(g30VarG2, "support_highfps_app", new d30());
                            p(g30VarG2, "migt", new d30());
                            p(g30VarG2, "booster_enable", Boolean.FALSE);
                            p(g30VarG2, "cpuset_enable", Boolean.FALSE);
                            p(g30VarG2, "affinity_enable", Boolean.FALSE);
                            p(g30VarG2, "tuner_enable", Boolean.FALSE);
                            p(g30VarG2, "scale_app_enable", Boolean.FALSE);
                            p(g30VarG2, "migl_enable", Boolean.FALSE);
                            p(g30VarG2, "game_identify", Boolean.FALSE);
                            if (g30VarG2.j("monitor")) {
                                g30 g30VarG4 = g30VarG2.g("monitor");
                                g30VarG4.y("monitor_enable", false);
                                g30VarG4.y("analytics_enable", false);
                            }
                        } else {
                            d30 d30VarF = g30VarG3.f(str2);
                            int iG = d30VarF.g();
                            for (int i = 0; i < iG; i++) {
                                g30 g30VarD = d30VarF.d(i);
                                g30VarD.z("dynamic_targetfps");
                                g30VarD.z("dynamic_targetfps_M");
                                g30VarD.z("dynamic_fps");
                                g30VarD.z("dynamic_fps_M");
                                g30VarD.z("dynamicfps_by_battery_T");
                                g30VarD.z("dynamicfps_by_battery_M");
                                g30VarD.z("execute_cmd_by_temp_T");
                                g30VarD.z("execute_cmd_by_temp_M");
                            }
                        }
                    }
                }
            }
            return g30Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public final g30 c(g30 g30Var, boolean z) {
        f92.d(g30Var, "originData");
        return e(this.f3903a, g30Var, z);
    }

    public final g30 e(String str, g30 g30Var, boolean z) {
        if (!f92.a(str, this.f3903a)) {
            return g30Var;
        }
        String string = g30Var.toString();
        f92.c(string, "originData.toString()");
        return b(string, z);
    }

    public final String f() {
        return h(this.f3903a);
    }

    public final String g() {
        return h(this.b);
    }

    public final String h(String str) {
        StringBuilder sb;
        String str2;
        String string;
        String str3 = "";
        if (f92.a(this.c, "default_cloud.db")) {
            String strB = new ay0().b();
            f92.c(strB, "JoyoseConfig().decryptCfg()");
            return strB;
        }
        SQLiteDatabase sQLiteDatabaseI = i();
        if (f92.a(this.c, "SmartP.db")) {
            sb = new StringBuilder();
            sb.append("select params from cloud_config where config_name = '");
            sb.append(str);
            str2 = "' limit 0,1";
        } else {
            sb = new StringBuilder();
            sb.append("select rule_content from rules where rule_module = '");
            sb.append(str);
            str2 = "' order by rule_version desc limit 0,1";
        }
        sb.append(str2);
        Cursor cursorRawQuery = sQLiteDatabaseI.rawQuery(sb.toString(), new String[0]);
        if (cursorRawQuery.moveToNext()) {
            do {
                string = cursorRawQuery.getString(0);
                f92.c(string, "cursor.getString(0)");
                try {
                } catch (Exception unused) {
                    str3 = string;
                }
            } while (cursorRawQuery.moveToNext());
            str3 = string;
            cursorRawQuery.close();
            sQLiteDatabaseI.close();
        } else {
            cursorRawQuery.close();
            sQLiteDatabaseI.close();
        }
        return str3;
    }

    public final SQLiteDatabase i() {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = this.f3902a.openOrCreateDatabase(this.c, 0, null);
        f92.c(sQLiteDatabaseOpenOrCreateDatabase, "context.openOrCreateData…ntext.MODE_PRIVATE, null)");
        return sQLiteDatabaseOpenOrCreateDatabase;
    }

    public final String j() {
        return this.c;
    }

    public final String k() {
        return this.f3903a;
    }

    public final void l(g30 g30Var, String[] strArr) {
        if (strArr.length <= 1) {
            if (g30Var.j(strArr[0])) {
                g30Var.z(strArr[0]);
            }
        } else if (g30Var.j(strArr[0])) {
            Object objB = g30Var.b(strArr[0]);
            if (objB instanceof g30) {
                l((g30) objB, (String[]) u42.D(strArr, new ea2(1, strArr.length - 1)));
            }
        }
    }

    public final boolean m(g30 g30Var) {
        f92.d(g30Var, "data");
        return o(this.f3903a, g30Var);
    }

    public final boolean n(g30 g30Var) {
        f92.d(g30Var, "data");
        return o(this.b, g30Var);
    }

    public final boolean o(String str, g30 g30Var) {
        StringBuilder sb;
        String str2;
        if (f92.a(this.c, "default_cloud.db")) {
            if (e60.m()) {
                byte[] bArrD = new ay0().d(g30Var.toString());
                String strD = c60.f5764a.d(this.f3902a, "default_cloud.json");
                c60 c60Var = c60.f5764a;
                f92.c(bArrD, "bytes");
                if (c60Var.l(bArrD, "default_cloud.json", this.f3902a)) {
                    e60 e60Var = e60.f698a;
                    String str3 = ay0.f5653a;
                    f92.c(str3, "JoyoseConfig.PATH");
                    if (e60Var.p(str3, strD)) {
                        new File(strD).delete();
                        return true;
                    }
                }
            }
            return false;
        }
        if (f92.a(this.c, "SmartP.db")) {
            sb = new StringBuilder();
            str2 = "update cloud_config set params = ? where config_name = '";
        } else {
            sb = new StringBuilder();
            str2 = "update rules set rule_content = ? where rule_module = '";
        }
        sb.append(str2);
        sb.append(str);
        sb.append('\'');
        String string = sb.toString();
        try {
            SQLiteDatabase sQLiteDatabaseI = i();
            sQLiteDatabaseI.execSQL(string, new String[]{g30Var.toString()});
            sQLiteDatabaseI.close();
            File databasePath = this.f3902a.getDatabasePath(this.c);
            f92.c(databasePath, "context.getDatabasePath(dbName)");
            String absolutePath = databasePath.getAbsolutePath();
            f92.c(absolutePath, "targetPath");
            String packageName = this.f3902a.getPackageName();
            f92.c(packageName, "context.packageName");
            String strT = bc2.t(absolutePath, packageName, d, false, 4, null);
            s60.f7366a.a("cp -f " + absolutePath + ' ' + strT + "\nchmod 0660 " + strT + "\nrestorecon -DFR " + strT + "\nchown system:system " + strT + "\nam force-stop " + d);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void p(g30 g30Var, String str, Object obj) {
        if (g30Var.j(str)) {
            g30Var.x(str, obj);
        }
    }

    public final void q(g30 g30Var, String[] strArr, Object obj) {
        if (strArr.length <= 1) {
            if (g30Var.j(strArr[0])) {
                g30Var.x(strArr[0], obj);
            }
        } else if (g30Var.j(strArr[0])) {
            Object objB = g30Var.b(strArr[0]);
            if (objB instanceof g30) {
                q((g30) objB, (String[]) u42.D(strArr, new ea2(1, strArr.length - 1)), obj);
            }
        }
    }
}
