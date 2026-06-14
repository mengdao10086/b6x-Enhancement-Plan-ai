package a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7899a;

    public xk0(Context context) {
        f92.d(context, "context");
        this.f7899a = context;
    }

    public final boolean a(String str) {
        return ac.b(this.f7899a, str) == 0;
    }

    public final void b() {
        String string;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        ArrayList<String> arrayListC = y42.c("android.permission.CHANGE_CONFIGURATION", "android.permission.WRITE_SECURE_SETTINGS", "android.permission.SYSTEM_ALERT_WINDOW");
        if (new w20(this.f7899a).c()) {
            wg0 wg0Var = new wg0(this.f7899a);
            String packageName = this.f7899a.getPackageName();
            f92.c(packageName, "context.packageName");
            String[] strArrD = wg0Var.d(packageName);
            String str = null;
            if (strArrD != null) {
                int length = strArrD.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArrD[i];
                    if (f92.a(str2, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                        str = str2;
                        break;
                    }
                    i++;
                }
            }
            if (str != null) {
                arrayListC.add("android.permission.MANAGE_EXTERNAL_STORAGE");
            }
        }
        for (String str3 : arrayListC) {
            if (!f92.a(str3, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                if (f92.a(str3, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (Settings.canDrawOverlays(this.f7899a)) {
                            continue;
                        } else {
                            if (str3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            String strSubstring = str3.substring(19);
                            f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            sb = new StringBuilder();
                            sb.append("appops set ");
                            sb.append(this.f7899a.getPackageName());
                            sb.append(' ');
                            sb.append(strSubstring);
                            sb.append(" allow\n");
                        }
                    } else if (a(str3)) {
                        continue;
                    } else {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (str3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            String strSubstring2 = str3.substring(19);
                            f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                            sb2.append("appops set " + this.f7899a.getPackageName() + ' ' + strSubstring2 + " allow\n");
                        }
                        sb = new StringBuilder();
                        sb.append("pm grant ");
                        sb.append(this.f7899a.getPackageName());
                        sb.append(' ');
                        sb.append(str3);
                        sb.append('\n');
                    }
                } else if (a(str3)) {
                    continue;
                } else {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (str3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String strSubstring3 = str3.substring(19);
                        f92.c(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                        sb2.append("appops set " + this.f7899a.getPackageName() + ' ' + strSubstring3 + " allow\n");
                    }
                    sb = new StringBuilder();
                    sb.append("pm grant ");
                    sb.append(this.f7899a.getPackageName());
                    sb.append(' ');
                    sb.append(str3);
                    sb.append('\n');
                }
                string = sb.toString();
                sb2.append(string);
            } else if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
                string = "appops set --uid " + this.f7899a.getPackageName() + " MANAGE_EXTERNAL_STORAGE allow\n";
                sb2.append(string);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && !a("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
            sb2.append("dumpsys deviceidle whitelist +" + this.f7899a.getPackageName() + ";\n");
        }
        if (sb2.length() > 0) {
            s60 s60Var = s60.f7366a;
            String string2 = sb2.toString();
            f92.c(string2, "shellStr.toString()");
            s60Var.b(string2);
        }
    }
}
