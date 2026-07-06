package a;

import a.p80;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityApplications;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class iq1 extends pj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppInfo f6436a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iq1(Activity activity, AppInfo appInfo, ActivityApplications.a aVar) {
        super(activity, y42.c(appInfo), aVar);
        f92.d(activity, "context");
        f92.d(appInfo, "app");
        f92.d(aVar, "handler");
        this.f6436a = appInfo;
    }

    public final void S() {
        Object systemService = B().getSystemService("clipboard");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ((ClipboardManager) systemService).setText(this.f6436a.path);
        Toast.makeText(B(), B().getString(u61.apps_op_copied) + this.f6436a.path, 1).show();
    }

    public final void T() {
        Object systemService = B().getSystemService("clipboard");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ((ClipboardManager) systemService).setText(this.f6436a.getPackageName());
        Toast.makeText(B(), B().getString(u61.apps_op_copied) + this.f6436a.getPackageName(), 1).show();
    }

    public final AppInfo U() {
        return this.f6436a;
    }

    public final Drawable V(AppInfo appInfo) {
        try {
            return B().getPackageManager().getPackageInfo(appInfo.getPackageName().toString(), 0).applicationInfo.loadIcon(B().getPackageManager());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void W() {
        boolean zJ = e60.f698a.j();
        if (!zJ && C() && D("/system/app")) {
            p80.a aVar = p80.f2403a;
            Activity activityB = B();
            String string = B().getString(u61.apps_op_magisk_clash);
            f92.c(string, "context.getString(R.string.apps_op_magisk_clash)");
            String string2 = B().getString(u61.apps_op_magisk_clash_desc);
            f92.c(string2, "context.getString(R.stri…pps_op_magisk_clash_desc)");
            p80.a.B(aVar, activityB, string, string2, null, 8, null);
            return;
        }
        View viewInflate = B().getLayoutInflater().inflate(2131558506, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        ((TextView) viewFindViewById).setText(B().getString(u61.apps_op_transfer_warning));
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.trans_create_module);
        compoundButton.setEnabled(zJ);
        compoundButton.setChecked(zJ);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.trans_system_app);
        CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.trans_priv_app);
        f92.c(compoundButton2, "systemApp");
        f92.c(compoundButton3, "privApp");
        fj0 fj0Var = new fj0(compoundButton2, compoundButton3);
        p80.a aVar2 = p80.f2403a;
        Activity activityB2 = B();
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar2, activityB2, viewInflate, false, 4, null);
        viewInflate.findViewById(2131362070).setOnClickListener(new fp1(this, bVarT, fj0Var, compoundButton, zJ));
        viewInflate.findViewById(2131362069).setOnClickListener(new gp1(bVarT));
    }

    public final void X(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("busybox mount -o rw,remount / 2>/dev/null\nmount -o rw,remount /system 2>/dev/null\nbusybox mount -o rw,remount / 2>/dev/null\nmount -o rw,remount /system 2>/dev/null\nbusybox mount -o remount,rw /dev/block/bootdevice/by-name/system /system 2>/dev/null\nmount -o remount,rw /dev/block/bootdevice/by-name/system /system 2>/dev/null\nbusybox mount -o rw,remount /vendor 2>/dev/null\nmount -o rw,remount /vendor 2>/dev/null\n");
        String parent = new File(this.f6436a.path.toString()).getParent();
        if (f92.a(parent, "/data/app")) {
            String str3 = "/system/app/" + new File(this.f6436a.path.toString()).getName();
            sb.append("busybox cp '" + this.f6436a.path + "' '" + str3 + "'\n");
            sb.append("chmod 0755 '" + str3 + "'\n");
            sb.append("chown -R system:system '" + str3 + "'\n");
            sb.append("busybox chown -R system:system '" + str3 + "'\n");
            str2 = "if [[ ! -e '" + str3 + "' ]]\n then exit 1\n else rm -f '" + this.f6436a.path + "'\n fi\n\n";
        } else {
            String str4 = "/system/" + str + '/' + new File(parent).getName();
            sb.append("busybox cp -pdrf '" + parent + "' '/system/" + str + "/'\n");
            sb.append("chmod -R 0755 '" + str4 + "'\n");
            sb.append("chown -R system:system '" + str4 + "'\n");
            sb.append("busybox chown -R system:system '" + str4 + "'\n");
            str2 = "if [[ ! -e '" + str4 + "' ]]\n then exit 1\n exit 1\n else exit 0\n fi\n\n";
        }
        sb.append(str2);
        sb.append("sync\n");
        sb.append("sleep 1\n");
        sb.append("echo '[operation completed]'\n");
        A(sb);
    }

    public final void Y(String str) throws IOException {
        boolean zT;
        if (e60.f698a.b()) {
            String parent = new File(this.f6436a.path.toString()).getParent();
            if (f92.a(parent, "/data/app")) {
                String str2 = "/system/" + str + '/';
                e60 e60Var = e60.f698a;
                Activity activityB = B();
                String string = this.f6436a.path.toString();
                String packageName = this.f6436a.getPackageName();
                String appName = this.f6436a.getAppName();
                AppInfo appInfo = this.f6436a;
                zT = e60Var.t(activityB, str2, string, packageName, appName, appInfo.versionName, appInfo.versionCode);
            } else {
                String str3 = "/system/" + str + '/' + this.f6436a.getPackageName();
                e60 e60Var2 = e60.f698a;
                Activity activityB2 = B();
                f92.c(parent, "appDir");
                String packageName2 = this.f6436a.getPackageName();
                String appName2 = this.f6436a.getAppName();
                AppInfo appInfo2 = this.f6436a;
                zT = e60Var2.t(activityB2, str3, parent, packageName2, appName2, appInfo2.versionName, appInfo2.versionCode);
            }
        } else {
            String strD = c60.f5764a.d(B(), "module.zip");
            f60 f60Var = new f60(B(), strD);
            e60 e60Var3 = e60.f698a;
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("id", this.f6436a.getPackageName());
            linkedHashMap.put("name", this.f6436a.getAppName());
            String str4 = this.f6436a.versionName;
            if (str4 == null) {
                str4 = "";
            }
            linkedHashMap.put("version", str4);
            linkedHashMap.put("versionCode", "" + this.f6436a.versionCode);
            linkedHashMap.put("author", "嘟嘟ski(SCENE)");
            linkedHashMap.put("description", "用于将第三方应用转换成系统应用的模块，由Scene创建并添加");
            m42 m42Var = m42.f6769a;
            String strO = e60Var3.o(linkedHashMap);
            f60Var.c("/system/" + str + '/' + this.f6436a.getPackageName() + ".apk", this.f6436a.path.toString());
            f60Var.b("module.prop", strO);
            if (f60Var.e()) {
                zT = true;
            } else {
                y60.f7952a.a(strD, c60.f5764a.e() + "/[Magisk]" + this.f6436a.getAppName() + this.f6436a.versionName + ".zip");
                new File(strD).delete();
                zT = false;
            }
        }
        if (zT) {
            p80.a aVar = p80.f2403a;
            Activity activityB3 = B();
            String string2 = B().getString(u61.apps_op_magisk_reboot);
            f92.c(string2, "context.getString(R.string.apps_op_magisk_reboot)");
            p80.a.B(aVar, activityB3, string2, "", null, 8, null);
            return;
        }
        p80.a aVar2 = p80.f2403a;
        Activity activityB4 = B();
        String string3 = B().getString(u61.apps_op_magisk_fail);
        f92.c(string3, "context.getString(R.string.apps_op_magisk_fail)");
        p80.a.B(aVar2, activityB4, string3, "", null, 8, null);
    }

    public final void Z() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f6436a.getPackageName().toString(), null));
        B().startActivity(intent);
    }

    public final void a0() {
        View viewInflate = B().getLayoutInflater().inflate(2131558504, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activityB = B();
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activityB, viewInflate, false, 4, null);
        viewInflate.findViewById(t61.app_install).setOnClickListener(new hp1(this));
        boolean zS = s(this.f6436a.getPackageName());
        View viewFindViewById = viewInflate.findViewById(t61.app_restore_full);
        viewFindViewById.setVisibility((zS && (f92.a(e50.f677a.y0(), "basic") ^ true)) ? 0 : 8);
        viewFindViewById.setOnClickListener(new ip1(this, zS, bVarT));
        View viewFindViewById2 = viewInflate.findViewById(t61.app_restore_data);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility((zS && (f92.a(e50.f677a.y0(), "basic") ^ true)) ? 0 : 8);
            viewFindViewById2.setOnClickListener(new jp1(this, zS, bVarT));
        }
        viewInflate.findViewById(t61.app_copy_name).setOnClickListener(new kp1(this, bVarT));
        viewInflate.findViewById(t61.app_go_store).setOnClickListener(new lp1(this, bVarT));
        viewInflate.findViewById(t61.app_delete_backup).setOnClickListener(new mp1(this, bVarT));
    }

    public final void b0() {
        String str = "market://details?id=" + this.f6436a.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        B().startActivity(intent);
    }

    public final void c0() {
        AppInfo.AppType appType = this.f6436a.appType;
        if (appType != null) {
            int i = ep1.f6029a[appType.ordinal()];
            if (i == 1) {
                e0();
                return;
            } else if (i == 2) {
                d0();
                return;
            } else if (i == 3) {
                a0();
                return;
            }
        }
        Toast.makeText(B(), "UNSupport！", 0).show();
    }

    public final void d0() {
        View viewInflate = B().getLayoutInflater().inflate(f92.a(e50.f677a.y0(), "basic") ? 2131558501 : 2131558502, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activityB = B();
        f92.c(viewInflate, "dialogView");
        p80.b bVarT = p80.a.t(aVar, activityB, viewInflate, false, 4, null);
        View viewFindViewById = viewInflate.findViewById(t61.app_target_sdk);
        f92.c(viewFindViewById, "dialogView.findViewById<…iew>(R.id.app_target_sdk)");
        ((TextView) viewFindViewById).setText("SDK" + String.valueOf(this.f6436a.targetSdkVersion));
        View viewFindViewById2 = viewInflate.findViewById(t61.app_min_sdk);
        f92.c(viewFindViewById2, "dialogView.findViewById<…xtView>(R.id.app_min_sdk)");
        ((TextView) viewFindViewById2).setText("SDK" + String.valueOf(this.f6436a.minSdkVersion));
        View viewFindViewById3 = viewInflate.findViewById(t61.app_version_name);
        f92.c(viewFindViewById3, "dialogView.findViewById<…w>(R.id.app_version_name)");
        ((TextView) viewFindViewById3).setText("Version Name: " + this.f6436a.versionName);
        View viewFindViewById4 = viewInflate.findViewById(t61.app_version_code);
        f92.c(viewFindViewById4, "dialogView.findViewById<…w>(R.id.app_version_code)");
        ((TextView) viewFindViewById4).setText("Version Code: " + this.f6436a.versionCode);
        ((ImageView) viewInflate.findViewById(t61.app_logo)).setImageDrawable(V(this.f6436a));
        View viewFindViewById5 = viewInflate.findViewById(t61.app_options_single_only);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setVisibility(0);
        }
        View viewFindViewById6 = viewInflate.findViewById(t61.app_options_backup_apk);
        if (viewFindViewById6 != null) {
            Boolean bool = this.f6436a.updated;
            f92.c(bool, "app.updated");
            viewFindViewById6.setVisibility(bool.booleanValue() ? 0 : 8);
            Boolean bool2 = this.f6436a.updated;
            f92.c(bool2, "app.updated");
            if (bool2.booleanValue()) {
                viewFindViewById6.setOnClickListener(new np1(this, bVarT));
            }
        }
        viewInflate.findViewById(t61.app_options_copay_package).setOnClickListener(new qp1(this, bVarT));
        ((TextView) viewInflate.findViewById(t61.app_package_name)).setText(this.f6436a.getPackageName());
        viewInflate.findViewById(t61.app_options_copay_path).setOnClickListener(new rp1(this, bVarT));
        ((TextView) viewInflate.findViewById(t61.app_install_path)).setText(this.f6436a.path);
        viewInflate.findViewById(t61.app_options_open_detail).setOnClickListener(new sp1(this, bVarT));
        viewInflate.findViewById(t61.app_options_app_store).setOnClickListener(new tp1(this, bVarT));
        View viewFindViewById7 = viewInflate.findViewById(t61.app_options_clear);
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(new up1(this, bVarT));
        }
        Boolean bool3 = this.f6436a.updated;
        f92.c(bool3, "app.updated");
        if (bool3.booleanValue()) {
            View viewFindViewById8 = viewInflate.findViewById(t61.app_options_uninstall_user);
            if (viewFindViewById8 != null) {
                viewFindViewById8.setVisibility(8);
            }
        } else {
            View viewFindViewById9 = viewInflate.findViewById(t61.app_options_uninstall_user);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setOnClickListener(new vp1(this, bVarT));
            }
        }
        View viewFindViewById10 = viewInflate.findViewById(t61.app_options_dex2oat);
        if (viewFindViewById10 != null) {
            viewFindViewById10.setOnClickListener(new wp1(this, bVarT));
        }
        Boolean bool4 = this.f6436a.updated;
        f92.c(bool4, "app.updated");
        if (bool4.booleanValue()) {
            View viewFindViewById11 = viewInflate.findViewById(t61.app_options_delete);
            if (viewFindViewById11 != null) {
                viewFindViewById11.setVisibility(8);
            }
            View viewFindViewById12 = viewInflate.findViewById(t61.app_options_uninstall);
            if (viewFindViewById12 != null) {
                viewFindViewById12.setOnClickListener(new xp1(this, bVarT));
            }
        } else {
            View viewFindViewById13 = viewInflate.findViewById(t61.app_options_delete);
            if (viewFindViewById13 != null) {
                if (f92.a(e50.f677a.y0(), "root")) {
                    viewFindViewById13.setOnClickListener(new op1(this, bVarT));
                } else {
                    viewFindViewById13.setVisibility(8);
                }
            }
            View viewFindViewById14 = viewInflate.findViewById(t61.app_options_uninstall);
            if (viewFindViewById14 != null) {
                viewFindViewById14.setVisibility(8);
            }
        }
        TextView textView = (TextView) viewInflate.findViewById(t61.app_options_title);
        if (textView != null) {
            textView.setText(this.f6436a.getAppName());
        }
        View viewFindViewById15 = viewInflate.findViewById(t61.app_options_app_freeze);
        if (viewFindViewById15 != null) {
            viewFindViewById15.setOnClickListener(new pp1(this, bVarT));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x018d A[PHI: r2
  0x018d: PHI (r2v6 android.view.View) = (r2v5 android.view.View), (r2v18 android.view.View) binds: [B:25:0x018b, B:18:0x0178] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0() {
        /*
            Method dump skipped, instruction units count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.iq1.e0():void");
    }
}
