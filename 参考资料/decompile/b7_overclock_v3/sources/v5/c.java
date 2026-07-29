package v5;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.util.j;
import com.blankj.utilcode.util.i0;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.x;
import com.flydigi.data.DataConstant;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import o5.m;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52709a = "7.4.2.0";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f52710b = "7.5.5.2";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52711c = "motionelf_server";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f52712d = "libmotionelf_server.so";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f52713e = "FZToolHelperAndroid";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f52715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f52716h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f52714f = "starter.sh";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f52717i = "shell:sh " + DataConstant.FOLDER_SERVER + fh.a.f28350w + f52714f + i0.f11861z + j1.a().getPackageName();

    public static String b() {
        PackageManager packageManager = j1.a().getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        for (int i10 = 0; i10 < installedPackages.size(); i10++) {
            PackageInfo packageInfo = installedPackages.get(i10);
            String string = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            String str = packageInfo.packageName;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(";");
            sb2.append(str);
            if (str.equals("com.microvirt.market")) {
                return "逍遥模拟器";
            }
            if (str.equals("com.mumu.store")) {
                return "MuMu模拟器";
            }
            if (str.equals("com.tencent.tinput")) {
                return "腾讯模拟器";
            }
            if (string.equals("雷电核心服务")) {
                return "雷电模拟器";
            }
            if (string.equals("游戏中心") && str.equals("com.android.Calendar")) {
                return "夜神模拟器";
            }
        }
        return new File("storage/emulated/0/Android/data/com.bluestacks.settings/").exists() ? "蓝叠模拟器" : h() ? "夜神模拟器" : "";
    }

    public static boolean c(String driver) {
        return !n0.b(driver, (f() || d()) ? f52709a : f52710b);
    }

    public static boolean d() {
        return Build.MODEL.equals("ASUS_Z00AD");
    }

    public static boolean e() {
        return !m.l(DataConstant.SP_FLOAT, 2).e(DataConstant.SP_APP_KEY_FORCE_COMPATIBLE_DRIVER) && j.a(x.a()[0], "arm64-v8a");
    }

    public static boolean f() {
        if (f52715g) {
            return f52716h;
        }
        if (m.l(DataConstant.SP_FLOAT, 2).c(DataConstant.SP_FLOAT_KEY_CPU_TYPE)) {
            f52716h = m.l(DataConstant.SP_FLOAT, 2).e(DataConstant.SP_FLOAT_KEY_CPU_TYPE);
        } else {
            f52716h = !b().isEmpty();
            m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_KEY_CPU_TYPE, f52716h);
        }
        f52715g = true;
        return f52716h;
    }

    public static boolean g() {
        List<PackageInfo> installedPackages = j1.a().getPackageManager().getInstalledPackages(0);
        for (int i10 = 0; i10 < installedPackages.size(); i10++) {
            if (installedPackages.get(i10).packageName.equals("com.microvirt.market")) {
                return true;
            }
        }
        return false;
    }

    public static boolean h() {
        String[] list;
        File file = new File("/storage/emulated/0/Android/data/");
        return file.isDirectory() && file.list() != null && (list = file.list(new FilenameFilter() { // from class: v5.b
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                return c.i(file2, str);
            }
        })) != null && list.length > 0;
    }

    public static /* synthetic */ boolean i(File file, String str) {
        return n0.b("com.bignox.app.store.hd", str);
    }
}
