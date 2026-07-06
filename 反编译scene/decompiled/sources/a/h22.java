package a;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h22 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PackageManager f6268a;

    public void b(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (Build.VERSION.SDK_INT >= 28) {
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass(Instrumentation.class.getName(), loadPackageParam.classLoader), "execStartActivity", new Object[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class, new g22(this)});
        }
    }

    public final void c(Context context, String str) {
        String str2;
        try {
            if (this.f6268a == null) {
                this.f6268a = context.getApplicationContext().getPackageManager();
            }
            if (((Boolean) this.f6268a.getClass().getMethod("isPackageSuspended", String.class).invoke(this.f6268a, str)).booleanValue()) {
                if (d(context, str)) {
                    str2 = context.getString(u61.freeze_thawed_by_scene) + str;
                } else {
                    str2 = "Fail to unfreeze: " + str;
                }
                Toast.makeText(context, str2, 0).show();
            }
        } catch (Exception unused) {
        }
    }

    public final boolean d(Context context, String str) {
        try {
            Uri uri = Uri.parse("content://com.omarea.vtools.SceneFreezeProvider");
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("packageName", str);
            return contentResolver.insert(uri, contentValues) != null;
        } catch (Exception e) {
            XposedBridge.log(e);
            return false;
        }
    }
}
