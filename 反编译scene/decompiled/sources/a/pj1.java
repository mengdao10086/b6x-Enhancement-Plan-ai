package a;

import a.p80;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityApplications;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f7124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityApplications.a f2432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AppInfo> f2434a;
    public String b;

    public pj1(Activity activity, ArrayList<AppInfo> arrayList, ActivityApplications.a aVar) {
        f92.d(activity, "context");
        f92.d(arrayList, "apps");
        f92.d(aVar, "handler");
        this.f7124a = activity;
        this.f2434a = arrayList;
        this.f2432a = aVar;
        this.f2433a = g61.f6176a.a();
        this.b = "";
        File filesDir = this.f7124a.getFilesDir();
        f92.c(filesDir, "context.filesDir");
        String absolutePath = filesDir.getAbsolutePath();
        f92.c(absolutePath, "context.filesDir.absolutePath");
        this.b = absolutePath;
        String packageName = this.f7124a.getPackageName();
        f92.c(packageName, "context.packageName");
        int iN = ec2.N(absolutePath, packageName, 0, false, 6, null) - 1;
        if (absolutePath == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = absolutePath.substring(0, iN);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        this.b = strSubstring;
    }

    public final void A(StringBuilder sb) {
        f92.d(sb, "sb");
        View viewInflate = LayoutInflater.from(this.f7124a).inflate(nb0.dialog_loading, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362341);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        ((TextView) viewFindViewById).setText(this.f7124a.getText(u61.please_wait));
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "dialog");
        ki1 ki1Var = new ki1(this.f7124a, viewInflate, aVar.r(activity, viewInflate, false), this.f2432a);
        String string = sb.toString();
        f92.c(string, "sb.toString()");
        q60 q60Var = new q60(ki1Var, string);
        q60Var.a();
        q60Var.d();
    }

    public final Activity B() {
        return this.f7124a;
    }

    public final boolean C() {
        String strA = s60.f7366a.a("su -v");
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strA.toUpperCase(locale);
        f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return ec2.C(upperCase, "MAGISKSU", false, 2, null);
    }

    public final boolean D(String str) {
        f92.d(str, "dir");
        String strA = s60.f7366a.a("df | grep tmpfs | grep \"" + str + '\"');
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strA.toUpperCase(locale);
        f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        if (upperCase != null) {
            return ec2.r0(upperCase).toString().length() > 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final void E() {
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558500, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        q92 q92Var = q92.f7191a;
        String string = this.f7124a.getString(u61.apps_op_frozen_confirm);
        f92.c(string, "context.getString(R.string.apps_op_frozen_confirm)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById).setText(str);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.disable_suspend);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.disable_freeze);
        CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.disable_hide);
        if (Build.VERSION.SDK_INT < 28) {
            f92.c(compoundButton, "switchSuspend");
            compoundButton.setEnabled(false);
        }
        f92.c(compoundButton, "switchSuspend");
        ArrayList<AppInfo> arrayList = this.f2434a;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Boolean bool = ((AppInfo) obj).suspended;
            f92.c(bool, "it.suspended");
            if (bool.booleanValue()) {
                arrayList2.add(obj);
            }
        }
        compoundButton.setChecked(arrayList2.size() == this.f2434a.size());
        f92.c(compoundButton2, "switchFreeze");
        ArrayList<AppInfo> arrayList3 = this.f2434a;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!((AppInfo) obj2).enabled.booleanValue()) {
                arrayList4.add(obj2);
            }
        }
        compoundButton2.setChecked(arrayList4.size() == this.f2434a.size());
        if (f92.a(e50.f677a.y0(), "adb")) {
            f92.c(compoundButton3, "switchHide");
            compoundButton3.setEnabled(false);
        }
        viewInflate.findViewById(2131362070).setOnClickListener(new ui1(this, bVarT, compoundButton, compoundButton2, compoundButton3));
        viewInflate.findViewById(2131362069).setOnClickListener(new vi1(bVarT));
    }

    public final void F() {
        String string = this.f7124a.getString(u61.apps_op_restore);
        f92.c(string, "context.getString(R.string.apps_op_restore)");
        q92 q92Var = q92.f7191a;
        String string2 = this.f7124a.getString(u61.apps_op_restore_confirm);
        f92.c(string2, "context.getString(R.stri….apps_op_restore_confirm)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        u(string, str, new wi1(this));
    }

    public final void G() {
        Object obj = null;
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558504, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        View viewFindViewById = viewInflate.findViewById(t61.app_install);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new xi1(this, bVarT));
        }
        Iterator<T> it = this.f2434a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (s(((AppInfo) next).getPackageName())) {
                obj = next;
                break;
            }
        }
        boolean z = obj != null;
        View viewFindViewById2 = viewInflate.findViewById(t61.app_restore_full);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(z ? 0 : 8);
            viewFindViewById2.setOnClickListener(new yi1(this, z, bVarT));
        }
        View viewFindViewById3 = viewInflate.findViewById(t61.app_restore_data);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(z ? 0 : 8);
            viewFindViewById3.setOnClickListener(new zi1(this, z, bVarT));
        }
        View viewFindViewById4 = viewInflate.findViewById(t61.app_delete_backup);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(new aj1(this, bVarT));
        }
    }

    public final void H() {
        int i;
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558502, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "dialogView");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        View viewFindViewById = viewInflate.findViewById(t61.app_options_single_only);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = viewInflate.findViewById(t61.app_options_clear);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new cj1(this, bVarT));
        }
        View viewFindViewById3 = viewInflate.findViewById(t61.app_options_uninstall_user);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new dj1(this, bVarT));
        }
        View viewFindViewById4 = viewInflate.findViewById(t61.app_options_dex2oat);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(new ej1(this, bVarT));
        }
        View viewFindViewById5 = viewInflate.findViewById(t61.app_options_delete);
        if (viewFindViewById5 != null) {
            if (f92.a(e50.f677a.y0(), "root")) {
                viewFindViewById5.setOnClickListener(new bj1(this, bVarT));
                i = 0;
            } else {
                i = 8;
            }
            viewFindViewById5.setVisibility(i);
        }
        View viewFindViewById6 = viewInflate.findViewById(t61.app_options_uninstall);
        if (viewFindViewById6 != null) {
            viewFindViewById6.setVisibility(8);
        }
        TextView textView = (TextView) viewInflate.findViewById(t61.app_options_title);
        if (textView != null) {
            textView.setText(this.f7124a.getString(u61.make_choice));
        }
        View viewFindViewById7 = viewInflate.findViewById(t61.app_options_app_freeze);
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(new fj1(this, bVarT));
        }
    }

    public final void I() {
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558503, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "dialogView");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        View viewFindViewById = viewInflate.findViewById(t61.app_options_single_only);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = viewInflate.findViewById(t61.app_options_clear);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new gj1(this, bVarT));
        }
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            View viewFindViewById3 = viewInflate.findViewById(t61.app_options_backup_apk);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setOnClickListener(new hj1(this, bVarT));
            }
        } else {
            View viewFindViewById4 = viewInflate.findViewById(t61.app_options_backup_apk);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(8);
            }
        }
        View viewFindViewById5 = viewInflate.findViewById(t61.app_options_uninstall);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(new ij1(this, bVarT));
        }
        View viewFindViewById6 = viewInflate.findViewById(t61.app_options_dex2oat);
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(new jj1(this, bVarT));
        }
        View viewFindViewById7 = viewInflate.findViewById(t61.app_options_title);
        f92.c(viewFindViewById7, "dialogView.findViewById<…>(R.id.app_options_title)");
        ((TextView) viewFindViewById7).setText(this.f7124a.getString(u61.make_choice));
        View viewFindViewById8 = viewInflate.findViewById(t61.app_options_app_freeze);
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(new kj1(this, bVarT));
        }
    }

    public final void J() {
        if (f92.a(e50.f677a.y0(), "basic")) {
            Uri uri = Uri.parse("package:" + ((AppInfo) i52.A(this.f2434a)).getPackageName());
            f92.c(uri, "Uri.parse(\"package:$packageName\")");
            this.f7124a.startActivityForResult(new Intent("android.intent.action.DELETE", uri), 0);
            return;
        }
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558507, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        q92 q92Var = q92.f7191a;
        String string = this.f7124a.getString(u61.apps_op_uninstall_confirm);
        f92.c(string, "context.getString(R.stri…pps_op_uninstall_confirm)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById).setText(str);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.uninstall_user_only);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.uninstall_keep_data);
        viewInflate.findViewById(2131362069).setOnClickListener(new lj1(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new mj1(this, bVarT, compoundButton, compoundButton2));
    }

    public final void K(boolean z) {
        if (f92.a(e50.f677a.y0(), "basic")) {
            Uri uri = Uri.parse("package:" + ((AppInfo) i52.A(this.f2434a)).getPackageName());
            f92.c(uri, "Uri.parse(\"package:$packageName\")");
            this.f7124a.startActivityForResult(new Intent("android.intent.action.DELETE", uri), 0);
            return;
        }
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558507, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        q92 q92Var = q92.f7191a;
        String string = this.f7124a.getString(u61.apps_op_uninstall_updated_confirm);
        f92.c(string, "context.getString(R.stri…ninstall_updated_confirm)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById).setText(str);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.uninstall_user_only);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.uninstall_keep_data);
        f92.c(compoundButton, "userOnly");
        compoundButton.setEnabled(false);
        compoundButton.setEnabled(false);
        if (z) {
            f92.c(compoundButton2, "keepData");
            compoundButton2.setEnabled(false);
            compoundButton.setChecked(false);
            compoundButton2.setChecked(false);
        } else {
            compoundButton.setChecked(true);
        }
        viewInflate.findViewById(2131362069).setOnClickListener(new nj1(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new oj1(this, bVarT, compoundButton, compoundButton2));
    }

    public final void a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("backup_path=\"" + g61.f6176a.a() + "\"\n");
        sb.append("mkdir -p ${backup_path}\n");
        sb.append("\n");
        sb.append("\n");
        for (AppInfo appInfo : this.f2434a) {
            String string = appInfo.getPackageName().toString();
            String string2 = appInfo.path.toString();
            sb.append("rm -f ${backup_path}" + string + ".apk\n");
            sb.append("\n");
            sb.append("echo '[copy " + string + ".apk]'\n");
            sb.append("busybox cp -f " + string2 + " ${backup_path}" + string + ".apk\n");
            if (z) {
                sb.append("rm ${backup_path}" + string + ".appops 2>&1 > /dev/null\n");
                sb.append("appops get " + string + " | grep -v '.*:.*:.*' | cut -f1 -d ';' | while read op; do\n");
                sb.append("  echo $op | sed 's/[[:space:]]//g' >> ${backup_path}" + string + ".appops\n");
                sb.append("done\n");
                sb.append("sed -i s/MIUIOP\\(// ${backup_path}" + string + ".appops\n");
                sb.append("sed -i s/\\)// ${backup_path}" + string + ".appops\n");
                sb.append("sed -i s/mode=// ${backup_path}" + string + ".appops\n");
            }
            sb.append("\n");
        }
        sb.append("cd ${backup_path}\n");
        sb.append("chown sdcard_rw:sdcard_rw *\n");
        sb.append("chmod 777 *\n");
        sb.append("echo '[operation completed]'\n");
        A(sb);
    }

    public final void b(boolean z) {
        StringBuilder sb;
        UserManager userManager = (UserManager) this.f7124a.getSystemService("user");
        UserHandle userHandleMyUserHandle = Process.myUserHandle();
        if (userManager == null) {
            Activity activity = this.f7124a;
            Toast.makeText(activity, activity.getString(u61.apps_userid_none), 0).show();
            return;
        }
        long serialNumberForUser = userManager.getSerialNumberForUser(userHandleMyUserHandle);
        StringBuilder sb2 = new StringBuilder();
        for (AppInfo appInfo : this.f2434a) {
            String string = appInfo.getPackageName().toString();
            sb2.append("echo '[clear " + appInfo.getAppName() + "]'\n");
            if (z) {
                sb = new StringBuilder();
                sb.append("pm clear --user ");
                sb.append(serialNumberForUser);
                sb.append(' ');
            } else {
                sb = new StringBuilder();
                sb.append("pm clear ");
            }
            sb.append(string);
            sb.append('\n');
            sb2.append(sb.toString());
        }
        sb2.append("echo '[operation completed]'\n");
        A(sb2);
    }

    public final void c() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (AppInfo appInfo : this.f2434a) {
            String packageName = appInfo.getPackageName();
            sb.append("echo '[disable " + appInfo.getAppName() + "]'\n");
            sb.append("pm disable " + packageName + '\n');
            sb.append("echo '[delete " + appInfo.getAppName() + "]'\n");
            if (e60.m()) {
                e60.f698a.c(appInfo.path.toString());
                z = true;
            } else {
                String string = appInfo.dir.toString();
                sb.append("busybox mount -o rw,remount / 2>/dev/null\nmount -o rw,remount /system 2>/dev/null\nbusybox mount -o rw,remount / 2>/dev/null\nmount -o rw,remount /system 2>/dev/null\nbusybox mount -o remount,rw /dev/block/bootdevice/by-name/system /system 2>/dev/null\nmount -o remount,rw /dev/block/bootdevice/by-name/system /system 2>/dev/null\nbusybox mount -o rw,remount /vendor 2>/dev/null\nmount -o rw,remount /vendor 2>/dev/null\n");
                sb.append("rm -rf " + string + "/oat\n");
                sb.append("rm -rf " + string + "/lib\n");
                sb.append("rm -rf '" + appInfo.path + "'\n");
            }
        }
        sb.append("echo '[operation completed]'\n");
        A(sb);
        if (z) {
            p80.a aVar = p80.f2403a;
            Activity activity = this.f7124a;
            String string2 = activity.getString(u61.apps_op_magisk_reboot);
            f92.c(string2, "context.getString(R.string.apps_op_magisk_reboot)");
            p80.a.B(aVar, activity, string2, "", null, 8, null);
        }
    }

    public final void d() {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        for (AppInfo appInfo : this.f2434a) {
            String packageName = appInfo.getPackageName();
            sb2.append("echo '[delete " + appInfo.getAppName() + "]'\n");
            if (appInfo.path != null) {
                sb2.append("rm -rf '" + appInfo.path + "'\n");
                if (f92.a(appInfo.path, this.f2433a + packageName + ".apk")) {
                    sb = new StringBuilder();
                }
            } else {
                sb2.append("rm -rf " + this.f2433a + packageName + ".apk\n");
                sb = new StringBuilder();
            }
            sb.append("rm -rf ");
            sb.append(this.f2433a);
            sb.append(packageName);
            sb.append(".tar.gz\n");
            sb2.append(sb.toString());
        }
        sb2.append("echo '[operation completed]'\n");
        A(sb2);
    }

    public final void e(boolean z, boolean z2, boolean z3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        boolean z4 = Build.VERSION.SDK_INT >= 28;
        StringBuilder sb3 = new StringBuilder();
        boolean zA = f92.a(e50.f677a.y0(), "adb");
        for (AppInfo appInfo : this.f2434a) {
            String packageName = appInfo.getPackageName();
            if (z) {
                if (!appInfo.suspended.booleanValue()) {
                    sb3.append("echo '[suspend " + appInfo.getAppName() + "]'\n");
                    sb = new StringBuilder();
                    sb.append("pm suspend ");
                    sb.append(packageName);
                    sb.append('\n');
                    sb3.append(sb.toString());
                }
            } else if (z4) {
                Boolean bool = appInfo.suspended;
                f92.c(bool, "item.suspended");
                if (bool.booleanValue()) {
                    sb3.append("echo '[unsuspend " + appInfo.getAppName() + "]'\n");
                    sb3.append("am kill " + packageName + " 2>/dev/null\n");
                    sb3.append("pm unsuspend " + packageName + '\n');
                    sb = new StringBuilder();
                    sb.append("su 1000 -c 'pm unsuspend ");
                    sb.append(packageName);
                    sb.append("' 2>/dev/null\n");
                    sb3.append(sb.toString());
                }
            }
            Boolean bool2 = appInfo.enabled;
            if (z2) {
                f92.c(bool2, "item.enabled");
                if (bool2.booleanValue()) {
                    sb3.append("echo '[disable " + appInfo.getAppName() + "]'\n");
                    if (zA) {
                        sb2 = new StringBuilder();
                        str = "pm disable-user ";
                    } else {
                        sb2 = new StringBuilder();
                        str = "pm disable ";
                    }
                    sb2.append(str);
                    sb2.append(packageName);
                    sb2.append('\n');
                    sb3.append(sb2.toString());
                }
            } else if (!bool2.booleanValue()) {
                sb3.append("echo '[enable " + appInfo.getAppName() + "]'\n");
                sb2 = new StringBuilder();
                str = "pm enable ";
                sb2.append(str);
                sb2.append(packageName);
                sb2.append('\n');
                sb3.append(sb2.toString());
            }
            if (z3) {
                sb3.append("echo '[hide " + appInfo.getAppName() + "]'\n");
                sb3.append("pm hide " + packageName + '\n');
            }
        }
        sb3.append("echo '[operation completed]'\n");
        A(sb3);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x019d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.pj1.f():void");
    }

    public final void g(boolean z, boolean z2) {
        StringBuilder sb;
        String str;
        if (z) {
            UserManager userManager = (UserManager) this.f7124a.getSystemService("user");
            UserHandle userHandleMyUserHandle = Process.myUserHandle();
            if (userManager != null) {
                h(userManager.getSerialNumberForUser(userHandleMyUserHandle), z2);
                return;
            } else {
                Toast.makeText(this.f7124a, "获取用户ID失败！", 0).show();
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (AppInfo appInfo : this.f2434a) {
            String packageName = appInfo.getPackageName();
            sb2.append("echo '[uninstall " + appInfo.getAppName() + "]'\n");
            if (z2) {
                sb = new StringBuilder();
                str = "pm uninstall -k ";
            } else {
                sb = new StringBuilder();
                str = "pm uninstall ";
            }
            sb.append(str);
            sb.append(packageName);
            sb.append('\n');
            sb2.append(sb.toString());
        }
        sb2.append("echo '[operation completed]'\n");
        A(sb2);
    }

    public final void h(long j, boolean z) {
        StringBuilder sb;
        String str;
        StringBuilder sb2 = new StringBuilder();
        for (AppInfo appInfo : this.f2434a) {
            String packageName = appInfo.getPackageName();
            sb2.append("echo '[uninstall " + appInfo.getAppName() + "]'\n");
            if (z) {
                sb = new StringBuilder();
                str = "pm uninstall -k --user ";
            } else {
                sb = new StringBuilder();
                str = "pm uninstall --user ";
            }
            sb.append(str);
            sb.append(j);
            sb.append(' ');
            sb.append(packageName);
            sb.append('\n');
            sb2.append(sb.toString());
        }
        sb2.append("echo '[operation completed]'\n");
        A(sb2);
    }

    public final void r() {
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558496, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        q92 q92Var = q92.f7191a;
        String string = this.f7124a.getString(u61.apps_op_backup_confirm);
        f92.c(string, "context.getString(R.string.apps_op_backup_confirm)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById).setText(str);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.backup_permissions);
        viewInflate.findViewById(2131362069).setOnClickListener(new li1(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new mi1(this, bVarT, compoundButton));
    }

    public final boolean s(String str) {
        f92.d(str, "packageName");
        return new File(this.f2433a + str + ".tar.gz").exists();
    }

    public final void t() {
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558498, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        q92 q92Var = q92.f7191a;
        String string = this.f7124a.getString(u61.apps_op_frozen_confirm);
        f92.c(string, "context.getString(R.string.apps_op_frozen_confirm)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById).setText(str);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.clear_user_only);
        viewInflate.findViewById(2131362069).setOnClickListener(new ni1(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new oi1(this, bVarT, compoundButton));
    }

    public final void u(String str, String str2, Runnable runnable) {
        f92.d(str, "title");
        f92.d(str2, "msg");
        p80.f2403a.o(this.f7124a, (16 & 2) != 0 ? "" : str, (16 & 4) != 0 ? "" : str2, (16 & 8) != 0 ? null : runnable, (16 & 16) != 0 ? null : null);
    }

    public final void v() {
        String string = this.f7124a.getString(u61.apps_op_delete);
        f92.c(string, "context.getString(R.string.apps_op_delete)");
        q92 q92Var = q92.f7191a;
        String string2 = this.f7124a.getString(u61.apps_op_delete_confirm);
        f92.c(string2, "context.getString(R.string.apps_op_delete_confirm)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        u(string, str, new qi1(this));
    }

    public final void w() {
        String string = this.f7124a.getString(u61.apps_op_delete_backup);
        f92.c(string, "context.getString(R.string.apps_op_delete_backup)");
        String string2 = this.f7124a.getString(u61.apps_op_delete_backup_confirm);
        f92.c(string2, "context.getString(R.stri…op_delete_backup_confirm)");
        u(string, string2, new ri1(this));
    }

    public final void x() {
        View viewInflate = this.f7124a.getLayoutInflater().inflate(2131558499, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(2131362213);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.confirm_message)");
        q92 q92Var = q92.f7191a;
        String string = this.f7124a.getString(u61.apps_op_dex2oat_confirm);
        f92.c(string, "context.getString(R.stri….apps_op_dex2oat_confirm)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f2434a.size())}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById).setText(str);
        CompoundButton[] compoundButtonArr = new CompoundButton[3];
        View viewFindViewById2 = viewInflate.findViewById(t61.dex2oat_speed);
        f92.c(viewFindViewById2, "view.findViewById(R.id.dex2oat_speed)");
        compoundButtonArr[0] = (CompoundButton) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(t61.dex2oat_everything);
        f92.c(viewFindViewById3, "view.findViewById(R.id.dex2oat_everything)");
        compoundButtonArr[1] = (CompoundButton) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(t61.dex2oat_compact);
        CompoundButton compoundButton = (CompoundButton) viewFindViewById4;
        if (Build.VERSION.SDK_INT < 33) {
            compoundButton.setEnabled(false);
        }
        m42 m42Var = m42.f6769a;
        f92.c(viewFindViewById4, "view.findViewById<Compou…          }\n            }");
        compoundButtonArr[2] = compoundButton;
        fj0 fj0Var = new fj0(compoundButtonArr);
        fj0Var.h(0);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.dex2oat_force);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7124a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        viewInflate.findViewById(2131362069).setOnClickListener(new si1(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new ti1(this, bVarT, fj0Var, compoundButton2));
    }

    public final void y(String str, boolean z) {
        StringBuilder sb;
        String str2;
        if (Build.VERSION.SDK_INT < 24) {
            Activity activity = this.f7124a;
            Toast.makeText(activity, activity.getString(u61.apps_op_android_n), 0).show();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (AppInfo appInfo : this.f2434a) {
            String string = appInfo.getPackageName().toString();
            sb2.append("echo '[compile " + appInfo.getAppName() + "]'\n");
            if (z) {
                sb = new StringBuilder();
                str2 = "cmd package compile -f -m ";
            } else {
                sb = new StringBuilder();
                str2 = "cmd package compile -m ";
            }
            sb.append(str2);
            sb.append(str);
            sb.append(' ');
            sb.append(string);
            sb.append("\n\n");
            sb2.append(sb.toString());
        }
        sb2.append("echo '[operation completed]'\n\n");
        A(sb2);
    }

    public final void z() {
        StringBuilder sb = new StringBuilder();
        for (AppInfo appInfo : this.f2434a) {
            String string = appInfo.getPackageName().toString();
            sb.append("echo '[compact " + appInfo.getAppName() + "]'\n");
            sb.append("pm delete-dexopt " + string + "\n\n");
        }
        sb.append("echo '[operation completed]'\n\n");
        A(sb);
    }
}
