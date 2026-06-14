package a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xp0 {
    public final boolean a(Context context) {
        f92.d(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return Settings.System.canWrite(context);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void b(Context context) {
        f92.d(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Toast.makeText(context, "请为Scene授予“修改系统设置”权限，以确保“调节”功能能正常运行！", 1).show();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        s60.f7366a.c("pm grant " + context.getPackageName() + " android.permission.WRITE_SETTINGS");
    }

    public final void c(Context context) {
        s60 s60Var;
        StringBuilder sb;
        String str;
        f92.d(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            s60Var = s60.f7366a;
            sb = new StringBuilder();
            sb.append("appops set ");
            sb.append(context.getPackageName());
            sb.append(" ACCESS_RESTRICTED_SETTINGS allow;appops set ");
            sb.append(context.getPackageName());
            str = " WRITE_SETTINGS allow";
        } else {
            s60Var = s60.f7366a;
            sb = new StringBuilder();
            sb.append("pm grant ");
            sb.append(context.getPackageName());
            str = " android.permission.WRITE_SETTINGS";
        }
        sb.append(str);
        s60Var.c(sb.toString());
    }
}
