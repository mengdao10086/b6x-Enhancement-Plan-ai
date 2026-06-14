package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import com.omarea.krscript.model.NodeInfoBase;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class yc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s60 f7968a = s60.f7366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f3676a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f3677a = false;
    public static String b = "";

    public static boolean a() {
        return e50.f677a.y0().equals("root");
    }

    public static String b(Context context, String str) {
        String str2 = "kr-script/cache/" + n(str) + ".sh";
        if (new File(str2).exists()) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#!/system/bin/sh\n\n");
        sb.append(str);
        return c60.f5764a.l(sb.toString().replaceAll("\r\n", "\n").replaceAll("\r\t", "\t").replaceAll("\r", "\n").getBytes(), str2, context) ? c60.f5764a.d(context, str2) : "";
    }

    public static String c(Context context, String str, NodeInfoBase nodeInfoBase) {
        if (!f3677a) {
            k(context);
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        String strTrim = str.trim();
        String strF = strTrim.startsWith("file:///android_asset/") ? f(context, strTrim) : b(context, str);
        if (!f3677a) {
            k(context);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        if (nodeInfoBase == null || nodeInfoBase.getCurrentPageConfigPath().isEmpty()) {
            sb.append("export PAGE_CONFIG_DIR=''\n");
            sb.append("export PAGE_CONFIG_FILE=''\n");
            sb.append("export PAGE_WORK_DIR=''\n");
            sb.append("export PAGE_WORK_DIR=''\n");
        } else {
            String pageConfigDir = nodeInfoBase.getPageConfigDir();
            String currentPageConfigPath = nodeInfoBase.getCurrentPageConfigPath();
            sb.append("export PAGE_CONFIG_DIR='");
            sb.append(pageConfigDir);
            sb.append("'\n");
            sb.append("export PAGE_CONFIG_FILE='");
            sb.append(currentPageConfigPath);
            sb.append("'\n");
            boolean zStartsWith = currentPageConfigPath.startsWith("file:///android_asset/");
            sb.append("export PAGE_WORK_DIR='");
            if (zStartsWith) {
                sb.append(new wc0(context).j(pageConfigDir, pageConfigDir));
                sb.append("'\n");
                sb.append("export PAGE_WORK_FILE='");
                sb.append(new wc0(context).j(currentPageConfigPath, currentPageConfigPath));
            } else {
                sb.append(pageConfigDir);
                sb.append("'\n");
                sb.append("export PAGE_WORK_FILE='");
                sb.append(currentPageConfigPath);
            }
            sb.append("'\n");
        }
        sb.append("\n\n");
        sb.append(f3676a + " \"" + strF + "\"");
        return f7968a.a(sb.toString());
    }

    public static void d(Context context, DataOutputStream dataOutputStream, String str, HashMap<String, String> map, NodeInfoBase nodeInfoBase, String str2) {
        String currentPageConfigPath;
        if (map == null) {
            map = new HashMap<>();
        }
        if (nodeInfoBase != null) {
            String pageConfigDir = nodeInfoBase.getPageConfigDir();
            currentPageConfigPath = nodeInfoBase.getCurrentPageConfigPath();
            map.put("PAGE_CONFIG_DIR", pageConfigDir);
            map.put("PAGE_CONFIG_FILE", currentPageConfigPath);
            if (currentPageConfigPath.startsWith("file:///android_asset/")) {
                map.put("PAGE_WORK_DIR", new wc0(context).j(pageConfigDir, pageConfigDir));
                currentPageConfigPath = new wc0(context).j(currentPageConfigPath, currentPageConfigPath);
            } else {
                map.put("PAGE_WORK_DIR", pageConfigDir);
            }
        } else {
            currentPageConfigPath = "";
            map.put("PAGE_CONFIG_DIR", "");
            map.put("PAGE_CONFIG_FILE", "");
            map.put("PAGE_WORK_DIR", "");
        }
        map.put("PAGE_WORK_FILE", currentPageConfigPath);
        ArrayList<String> arrayListJ = j(map);
        StringBuilder sb = new StringBuilder();
        if (arrayListJ.size() > 0) {
            for (String str3 : arrayListJ) {
                sb.append("export ");
                sb.append(str3);
                sb.append("\n");
            }
        }
        try {
            dataOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            dataOutputStream.write(h(context, str, str2).getBytes(StandardCharsets.UTF_8));
            dataOutputStream.writeBytes("\n\n");
            dataOutputStream.writeBytes("sleep 0.2;\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
        } catch (Exception unused) {
        }
    }

    public static boolean e(Context context, i50 i50Var, String str, HashMap<String, String> map, NodeInfoBase nodeInfoBase, String str2) {
        boolean z;
        String str3;
        if (map == null) {
            map = new HashMap<>();
        }
        if (nodeInfoBase != null) {
            String pageConfigDir = nodeInfoBase.getPageConfigDir();
            String currentPageConfigPath = nodeInfoBase.getCurrentPageConfigPath();
            map.put("PAGE_CONFIG_DIR", pageConfigDir);
            map.put("PAGE_CONFIG_FILE", currentPageConfigPath);
            if (currentPageConfigPath.startsWith("file:///android_asset/")) {
                map.put("PAGE_WORK_DIR", new wc0(context).j(pageConfigDir, pageConfigDir));
                str3 = "PAGE_WORK_FILE";
                currentPageConfigPath = new wc0(context).j(currentPageConfigPath, currentPageConfigPath);
            } else {
                map.put("PAGE_WORK_DIR", pageConfigDir);
                str3 = "PAGE_WORK_FILE";
            }
            map.put(str3, currentPageConfigPath);
        } else {
            map.put("PAGE_CONFIG_DIR", "");
            map.put("PAGE_CONFIG_FILE", "");
            map.put("PAGE_WORK_DIR", "");
            map.put("PAGE_WORK_FILE", "");
        }
        ArrayList<String> arrayListJ = j(map);
        StringBuilder sb = new StringBuilder();
        if (arrayListJ.size() > 0) {
            for (String str4 : arrayListJ) {
                sb.append("export ");
                sb.append(str4);
                sb.append("\n");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) sb);
        sb2.append(h(context, str, str2));
        sb2.append("\nexit\nexit\n");
        boolean[] zArr = new boolean[1];
        new Thread(new xc0(zArr, sb2, i50Var)).start();
        synchronized (i50Var) {
            try {
                i50Var.wait();
            } catch (Exception unused) {
            }
            z = zArr[0];
        }
        return z;
    }

    public static String f(Context context, String str) {
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        return c60.f5764a.m(str, str, context);
    }

    public static HashMap<String, String> g(Context context) {
        StringBuilder sb;
        HashMap<String, String> map = new HashMap<>();
        map.put("TOOLKIT", b);
        if (e60.m()) {
            String strG = e60.f698a.g();
            if (strG.endsWith("/")) {
                strG = strG.substring(0, strG.length() - 1);
            }
            map.put("MAGISK_PATH", strG);
        } else {
            map.put("MAGISK_PATH", "");
        }
        map.put("START_DIR", i(context));
        if (e60.a()) {
            map.put("KSU", "true");
        }
        map.put("TEMP_DIR", context.getCacheDir().getAbsolutePath());
        fb0 fb0Var = new fb0(context);
        map.put("ANDROID_UID", "" + fb0Var.b());
        try {
            map.put("APP_USER_ID", fb0Var.a());
        } catch (Exception unused) {
        }
        map.put("ANDROID_SDK", "" + Build.VERSION.SDK_INT);
        map.put("ROOT_PERMISSION", a() ? "true" : "false");
        map.put("SDCARD_PATH", Environment.getExternalStorageDirectory().getAbsolutePath());
        String strD = c60.f5764a.d(context, "busybox");
        if (new File(c60.f5764a.d(context, "busybox")).exists()) {
            map.put("BUSYBOX", strD);
        } else {
            map.put("BUSYBOX", "busybox");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            map.put("PACKAGE_NAME", context.getPackageName());
            map.put("PACKAGE_VERSION_NAME", packageInfo.versionName);
            if (Build.VERSION.SDK_INT >= 28) {
                sb = new StringBuilder();
                sb.append("");
                sb.append(packageInfo.getLongVersionCode());
            } else {
                sb = new StringBuilder();
                sb.append("");
                sb.append(packageInfo.versionCode);
            }
            map.put("PACKAGE_VERSION_CODE", sb.toString());
        } catch (Exception unused2) {
        }
        return map;
    }

    public static String h(Context context, String str, String str2) {
        if (!f3677a) {
            k(context);
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("file:///android_asset/")) {
            String strF = f(context, strTrim);
            if (strF != null) {
                str = strF;
            }
        } else {
            str = b(context, str);
        }
        return f3676a + " \"" + str + "\" \"" + str2 + "\"";
    }

    public static String i(Context context) {
        String strC = c60.f5764a.c(context);
        return strC.endsWith("/") ? strC.substring(0, strC.length() - 1) : strC;
    }

    public static ArrayList<String> j(HashMap<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (map != null) {
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (str2 == null) {
                    str2 = "";
                }
                arrayList.add(str + "='" + str2.replaceAll("'", "'\\\\''") + "'");
            }
        }
        return arrayList;
    }

    public static boolean k(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("kr-script-config", 0);
        return l(context, sharedPreferences.getString("executor", "kr-script/executor.sh"), sharedPreferences.getString("toolkitDir", "kr-script/toolkit"));
    }

    public static boolean l(Context context, String str, String str2) {
        if (f3677a) {
            return true;
        }
        if (str2 != null) {
            try {
                if (!str2.isEmpty()) {
                    b = new wc0(context).f(str2);
                }
            } catch (Exception unused) {
                return false;
            }
        }
        String strSubstring = str.startsWith("file:///android_asset/") ? str.substring(22) : str;
        InputStream inputStreamOpen = context.getAssets().open(strSubstring);
        int iAvailable = inputStreamOpen.available();
        byte[] bArr = new byte[iAvailable];
        inputStreamOpen.read(bArr, 0, iAvailable);
        String strReplaceAll = new String(bArr, Charset.defaultCharset()).replaceAll("\r", "");
        HashMap<String, String> mapG = g(context);
        for (String str3 : mapG.keySet()) {
            String str4 = mapG.get(str3);
            if (str4 == null) {
                str4 = "";
            }
            strReplaceAll = strReplaceAll.replace("$({" + str3 + "})", str4);
        }
        String strD = c60.f5764a.d(context, strSubstring);
        boolean zL = c60.f5764a.l(strReplaceAll.replace("$({EXECUTOR_PATH})", strD).getBytes(Charset.defaultCharset()), strSubstring, context);
        f3677a = zL;
        if (zL) {
            f3676a = strD;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("kr-script-config", 0).edit();
        if (!str.equals("kr-script/executor.sh")) {
            editorEdit.putString("executor", str);
        }
        if (str2 != null && !str2.equals("kr-script/toolkit")) {
            editorEdit.putString("toolkitDir", str2);
        }
        editorEdit.apply();
        return f3677a;
    }

    public static boolean m() {
        return f3677a;
    }

    public static String n(String str) {
        if (str.isEmpty()) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
