package u9;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.t0;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.tencent.connect.common.Constants;
import i9.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import o5.m;
import o5.o;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f51956a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f51957b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f51958c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f51959d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f51960e = true;

    /* JADX WARN: Removed duplicated region for block: B:35:0x0113  */
    @g.n0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(final int r20, final java.lang.String r21, final java.lang.String r22, int r23) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.b.a(int, java.lang.String, java.lang.String, int):java.lang.String");
    }

    public static int b(byte src) {
        return Integer.parseInt(Integer.toHexString(src & 255), 16);
    }

    public static String c(String hex) {
        return hex.equalsIgnoreCase("a") ? Constants.VIA_REPORT_TYPE_SHARE_TO_QQ : hex.equalsIgnoreCase("b") ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : hex.equalsIgnoreCase("c") ? Constants.VIA_REPORT_TYPE_SET_AVATAR : hex.equalsIgnoreCase("d") ? "13" : hex.equalsIgnoreCase("e") ? Constants.VIA_REPORT_TYPE_MAKE_FRIEND : hex.equalsIgnoreCase("f") ? Constants.VIA_REPORT_TYPE_WPA_STATE : hex;
    }

    public static boolean d() {
        return e(false);
    }

    public static boolean e(boolean isReal) {
        return f() && (t0.t() || isReal);
    }

    public static boolean f() {
        if (f51960e) {
            f51960e = false;
            if (t0.t()) {
                String strC = o.c("sys.nubia.fzhandle", "-1");
                f51959d = n0.b(strC, "0") || n0.b(strC, "1");
            } else if (t0.A()) {
                if (com.blankj.utilcode.util.d.N(DataConstant.VIVO_IOTSERVER_PACKAGE_NAME) && com.blankj.utilcode.util.d.R(DataConstant.VIVO_IOTSERVER_PACKAGE_NAME)) {
                    z = true;
                }
                f51959d = z;
            } else {
                f51959d = false;
            }
        }
        return f51959d;
    }

    public static void g(Context mContext) {
        i9.b.d(mContext, DataConstant.REMOTE_ACTION_UART_MODE_END);
    }

    public static String h(Context context, String packageName) {
        return (d1.g(packageName) || !packageName.equals(DataConstant.TEST_KEYMAPPING)) ? com.blankj.utilcode.util.d.k(packageName) : "手柄测试";
    }

    public static int i() {
        return m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_DRIVER_ROTATION, 0);
    }

    public static String j(int driver) {
        int i10 = driver / 256;
        int i11 = driver % 256;
        String hexString = Integer.toHexString(i10 / 16);
        String hexString2 = Integer.toHexString(i10 % 16);
        String hexString3 = Integer.toHexString(i11 / 16);
        String hexString4 = Integer.toHexString(i11 % 16);
        return c(hexString) + j3.b.f36044h + c(hexString2) + j3.b.f36044h + c(hexString3) + j3.b.f36044h + c(hexString4);
    }

    public static float k(float value) {
        return new BigDecimal(value).setScale(4, RoundingMode.UP).floatValue();
    }

    public static String l() throws Throwable {
        String strT = t();
        if (strT == null) {
            return Build.MANUFACTURER;
        }
        if (strT.equals("")) {
            return Build.MANUFACTURER;
        }
        String[] strArrSplit = strT.split(":");
        if (strArrSplit.length >= 2) {
            return y(strArrSplit[1]);
        }
        return null;
    }

    public static List<PackageInfo> m(boolean exceptSelf) {
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : j1.a().getPackageManager().getInstalledPackages(0)) {
            if (!com.blankj.utilcode.util.d.R(packageInfo.packageName) && (!exceptSelf || !TextUtils.equals(packageInfo.packageName, com.blankj.utilcode.util.d.l()))) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static String n(int pid) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            try {
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line)) {
                    line = line.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
                return line;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public static void o(int refer, String source) {
        p(refer, source, "");
    }

    public static void p(int refer, String source, String redirect) {
        q(refer, source, redirect, 0);
    }

    public static void q(int refer, String source, String redirect, int productId) {
        h3.a.j().d(a.f.f31976e).withString(DataConstant.WEB_URL, a(refer, source, redirect, productId)).navigation();
    }

    public static boolean r() throws Throwable {
        if (!f51957b) {
            String strL = l();
            if (d1.g(strL)) {
                f51956a = false;
            } else {
                f51956a = strL.toLowerCase().startsWith("mt") || strL.toLowerCase().startsWith(zc.f.f58393w) || strL.toLowerCase().startsWith("leadcore");
            }
            f51957b = true;
        }
        return f51956a;
    }

    public static void s(Context mContext) {
        i9.b.d(mContext, DataConstant.REMOTE_ACTION_PAUSE_MAPPING);
    }

    public static String t() throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        String line;
        String str = f51958c;
        if (str != null) {
            return str;
        }
        BufferedReader bufferedReader = null;
        if (!new File("/proc/cpuinfo").exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream("/proc/cpuinfo");
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    do {
                        try {
                            line = bufferedReader2.readLine();
                            if (line == null) {
                                f51958c = "";
                                try {
                                    bufferedReader2.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    inputStreamReader.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused3) {
                                }
                                return "";
                            }
                        } catch (Exception unused4) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception unused6) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused7) {
                                }
                            }
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused8) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception unused9) {
                                }
                            }
                            if (fileInputStream == null) {
                                throw th;
                            }
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (Exception unused10) {
                                throw th;
                            }
                        }
                    } while (!line.startsWith("Hardware"));
                    f51958c = line;
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused11) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused12) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused13) {
                    }
                    return line;
                } catch (Exception unused14) {
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused15) {
                inputStreamReader = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
            }
        } catch (Exception unused16) {
            fileInputStream = null;
            inputStreamReader = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            inputStreamReader = null;
        }
    }

    public static void u(Context mContext) {
        i9.b.d(mContext, DataConstant.REMOTE_ACTION_RESUME_MAPPING);
    }

    public static void v(int rotation) {
        m.l(DataConstant.SP_FLOAT, 2).y(DataConstant.SP_DRIVER_ROTATION, rotation, true);
    }

    public static void w(Context context, int rotation) {
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).d(context, DataConstant.REMOTE_ACTION_SET_DRIVER_ROTATION, DataConstant.DRIVER_INSERT_ROTATION, rotation);
    }

    public static void x(Context mContext) {
        i9.b.d(mContext, DataConstant.REMOTE_ACTION_UART_MODE_START);
    }

    public static String y(String s10) {
        return (s10 == null || "".equals(s10)) ? "" : s10.replaceAll("^[\u3000*| *| *|//s*]*", "").replaceAll("[\u3000*| *| *|//s*]*$", "");
    }
}
