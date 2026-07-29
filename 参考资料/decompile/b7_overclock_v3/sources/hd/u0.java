package hd;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseLongArray;
import android.view.Display;
import android.view.WindowManager;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.listener.ISchedulers;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.base.Charsets;
import com.google.common.math.DoubleMath;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import v7.a;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f31158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f31159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f31160g = "Util";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f31161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f31162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f31163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f31164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f31165l = "format=m3u8-aapl";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f31166m = "format=mpd-time-csf";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.p0
    public static HashMap<String, String> f31167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f31168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f31169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f31170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f31171r;

    static {
        String str = Build.VERSION.CODENAME;
        int i10 = i1.a.R4.equals(str) ? 31 : "R".equals(str) ? 30 : Build.VERSION.SDK_INT;
        f31154a = i10;
        String str2 = Build.DEVICE;
        f31155b = str2;
        String str3 = Build.MANUFACTURER;
        f31156c = str3;
        String str4 = Build.MODEL;
        f31157d = str4;
        f31158e = str2 + ", " + str4 + ", " + str3 + ", " + i10;
        f31159f = new byte[0];
        f31161h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f31162i = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f31163j = Pattern.compile("%([A-Fa-f0-9]{2})");
        f31164k = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f31168o = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", SocializeProtocolConstants.PROTOCOL_KEY_DE, "gre", "el", "fre", SocializeProtocolConstants.PROTOCOL_KEY_FR, "geo", "ka", "ice", an.f23203ae, SocializeProtocolConstants.PROTOCOL_KEY_MAC, "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f31169p = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f31170q = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f31171r = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, mb.e.f41040l1, mb.e.f41061s1, 233, 252, mb.e.f41067u1, m9.m.f40854e0, 245, 216, 223, 214, 209, 196, 195, a.c.f52772h, 205, 144, rc.c.f48463k0, 158, 153, 140, 139, 130, 133, os.a.f46207a, HideBottomViewOnScrollBehavior.f19616g, 166, 161, 180, 179, 186, rb.a0.f47918w, 199, 192, 201, a.c.f52775k, 219, 220, 213, ISchedulers.IS_M3U8_PEER, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, NormalCmdFactory.TASK_CANCEL_ALL, 190, 171, rb.h0.K, 165, 162, 143, 136, 129, 134, uf.c.Ya, com.google.zxing.oned.d.f21430g, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, WaspWingInfo.COLD_LEVEL_STANDARD_B7, 146, 155, 156, 177, 182, 191, 184, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, DoubleMath.MAX_FACTORIAL, 163, ISchedulers.SUB_CANCEL, a4.d.f205j, 254, 247, 240, 229, 226, 235, 236, s0.c.f49294u, 198, a.c.f52776l, 200, 221, 218, hr.a.f31427a, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, mb.e.f41073w1, ob.h.H, 160, 167, 178, 181, 188, mb.e.f41031i2, 150, 145, rc.c.f48464l0, 159, 138, 141, 132, 131, 222, 217, 208, mb.e.f41076x1, 194, 197, a.c.f52774j, a.c.f52773i, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL, 225, 232, 239, 250, 253, 244, 243};
    }

    public static Handler A(@g.p0 Handler.Callback callback) {
        return y((Looper) a.k(Looper.myLooper()), callback);
    }

    public static int A0(String str) {
        String strW1 = w1(str);
        if (strW1.endsWith(".mpd")) {
            return 0;
        }
        if (strW1.endsWith(".m3u8")) {
            return 2;
        }
        Matcher matcher = f31164k.matcher(strW1);
        if (!matcher.matches()) {
            return 3;
        }
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            return 1;
        }
        if (strGroup.contains(f31166m)) {
            return 0;
        }
        return strGroup.contains(f31165l) ? 2 : 1;
    }

    @g.p0
    public static String A1(String str) {
        int length = str.length();
        int iEnd = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) == '%') {
                i10++;
            }
        }
        if (i10 == 0) {
            return str;
        }
        int i12 = length - (i10 * 2);
        StringBuilder sb2 = new StringBuilder(i12);
        Matcher matcher = f31163j.matcher(str);
        while (i10 > 0 && matcher.find()) {
            char c10 = (char) Integer.parseInt((String) a.g(matcher.group(1)), 16);
            sb2.append((CharSequence) str, iEnd, matcher.start());
            sb2.append(c10);
            iEnd = matcher.end();
            i10--;
        }
        if (iEnd < length) {
            sb2.append((CharSequence) str, iEnd, length);
        }
        if (sb2.length() != i12) {
            return null;
        }
        return sb2.toString();
    }

    public static Handler B() {
        return C(null);
    }

    public static int B0(Uri uri, @g.p0 String str) {
        if (str == null) {
            return y0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            default:
                return 3;
        }
    }

    public static void B1(Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static Handler C(@g.p0 Handler.Callback callback) {
        return y(X(), callback);
    }

    public static boolean C0(c0 c0Var, c0 c0Var2, @g.p0 Inflater inflater) {
        if (c0Var.a() <= 0) {
            return false;
        }
        if (c0Var2.b() < c0Var.a()) {
            c0Var2.c(c0Var.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(c0Var.d(), c0Var.e(), c0Var.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(c0Var2.d(), iInflate, c0Var2.b() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (iInflate == c0Var2.b()) {
                        c0Var2.c(c0Var2.b() * 2);
                    }
                } else {
                    c0Var2.R(iInflate);
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static HashMap<String, String> D() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> map = new HashMap<>(iSOLanguages.length + f31168o.length);
        int i10 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f31168o;
            if (i10 >= strArr.length) {
                return map;
            }
            map.put(strArr[i10], strArr[i10 + 1]);
            i10 += 2;
        }
    }

    public static boolean D0(int i10) {
        return i10 == 536870912 || i10 == 805306368 || i10 == 4;
    }

    public static File E(Context context, String str) throws IOException {
        File fileF = F(context, str);
        fileF.delete();
        fileF.mkdir();
        return fileF;
    }

    public static boolean E0(int i10) {
        return i10 == 3 || i10 == 2 || i10 == 268435456 || i10 == 536870912 || i10 == 805306368 || i10 == 4;
    }

    public static File F(Context context, String str) throws IOException {
        return File.createTempFile(str, null, (File) a.g(context.getCacheDir()));
    }

    public static boolean F0(int i10) {
        return i10 == 10 || i10 == 13;
    }

    public static String G(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (k1(str.charAt(i12))) {
                i11++;
            }
        }
        if (i11 == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder((i11 * 2) + length);
        while (i11 > 0) {
            int i13 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (k1(cCharAt)) {
                sb2.append('%');
                sb2.append(Integer.toHexString(cCharAt));
                i11--;
            } else {
                sb2.append(cCharAt);
            }
            i10 = i13;
        }
        if (i10 < length) {
            sb2.append((CharSequence) str, i10, length);
        }
        return sb2.toString();
    }

    public static boolean G0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || m7.a.f40702b.equals(scheme);
    }

    public static Uri H(Uri uri) {
        String strW1 = w1(uri.getPath());
        if (strW1 == null) {
            return uri;
        }
        Matcher matcher = f31164k.matcher(strW1);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    @g.v0(api = 24)
    public static boolean H0(Uri uri) {
        return "http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted((String) a.g(uri.getHost()));
    }

    public static String I(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean I0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static String J(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    public static /* synthetic */ Thread J0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static String K(byte[] bArr, int i10, int i11) {
        return new String(bArr, i10, i11, Charsets.UTF_8);
    }

    public static int K0(int[] iArr, int i10) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    @g.p0
    public static String L(int i10) {
        if (i10 == 0) {
            return w.f31187h0;
        }
        if (i10 == 1) {
            return w.f31191j0;
        }
        if (i10 != 2) {
            return null;
        }
        return w.f31189i0;
    }

    public static int L0(long[] jArr, long j10) {
        for (int i10 = 0; i10 < jArr.length; i10++) {
            if (jArr[i10] == j10) {
                return i10;
            }
        }
        return -1;
    }

    public static int M(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2 || i10 == 4 || i10 == 5 || i10 == 8) ? 4 : 2;
        }
        return 1;
    }

    public static String M0(String str) {
        int i10 = 0;
        while (true) {
            String[] strArr = f31169p;
            if (i10 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i10])) {
                return strArr[i10 + 1] + str.substring(strArr[i10].length());
            }
            i10 += 2;
        }
    }

    public static int N(int i10) {
        switch (i10) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return a.c.f52774j;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i11 = f31154a;
                return (i11 < 23 && i11 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static boolean N0(Activity activity, Uri... uriArr) {
        if (f31154a < 23) {
            return false;
        }
        for (Uri uri : uriArr) {
            if (G0(uri)) {
                return g1(activity);
            }
        }
        return false;
    }

    public static int O(int i10) {
        if (i10 == 0) {
            return 2;
        }
        if (i10 == 1) {
            return 13;
        }
        if (i10 == 2) {
            return 6;
        }
        int i11 = 4;
        if (i10 != 4) {
            i11 = 5;
            if (i10 != 5) {
                return i10 != 8 ? 1 : 3;
            }
        }
        return i11;
    }

    public static boolean O0(Activity activity, ya.v0... v0VarArr) {
        if (f31154a < 23) {
            return false;
        }
        for (ya.v0 v0Var : v0VarArr) {
            v0.g gVar = v0Var.f57132b;
            if (gVar != null) {
                if (G0(gVar.f57183a)) {
                    return g1(activity);
                }
                for (int i10 = 0; i10 < v0Var.f57132b.f57189g.size(); i10++) {
                    if (G0(v0Var.f57132b.f57189g.get(i10).f57191a)) {
                        return g1(activity);
                    }
                }
            }
        }
        return false;
    }

    public static int P(ByteBuffer byteBuffer, int i10) {
        int i11 = byteBuffer.getInt(i10);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i11 : Integer.reverseBytes(i11);
    }

    @g.v0(18)
    public static long P0(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            throw new NoSuchElementException();
        }
        long jMin = Long.MAX_VALUE;
        for (int i10 = 0; i10 < sparseLongArray.size(); i10++) {
            jMin = Math.min(jMin, sparseLongArray.valueAt(i10));
        }
        return jMin;
    }

    public static byte[] Q(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) ((Character.digit(str.charAt(i11), 16) << 4) + Character.digit(str.charAt(i11 + 1), 16));
        }
        return bArr;
    }

    public static <T> void Q0(List<T> list, int i10, int i11, int i12) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i13 = (i11 - i10) - 1; i13 >= 0; i13--) {
            arrayDeque.addFirst(list.remove(i10 + i13));
        }
        list.addAll(Math.min(i12, list.size()), arrayDeque);
    }

    public static int R(@g.p0 String str, int i10) {
        int i11 = 0;
        for (String str2 : p1(str)) {
            if (i10 == w.n(str2)) {
                i11++;
            }
        }
        return i11;
    }

    public static ExecutorService R0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: hd.t0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return u0.J0(str, runnable);
            }
        });
    }

    @g.p0
    public static String S(@g.p0 String str, int i10) {
        String[] strArrP1 = p1(str);
        if (strArrP1.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrP1) {
            if (i10 == w.n(str2)) {
                if (sb2.length() > 0) {
                    sb2.append(ag.c.f654g);
                }
                sb2.append(str2);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public static String S0(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !"und".equals(strReplace)) {
            str = strReplace;
        }
        String strW1 = w1(str);
        String str2 = o1(strW1, "-")[0];
        if (f31167n == null) {
            f31167n = D();
        }
        String str3 = f31167n.get(str2);
        if (str3 != null) {
            strW1 = str3 + strW1.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? M0(strW1) : strW1;
    }

    public static String T(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            sb2.append(objArr[i10].getClass().getSimpleName());
            if (i10 < objArr.length - 1) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    public static <T> T[] T0(T[] tArr, T t10) {
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length + 1);
        objArrCopyOf[tArr.length] = t10;
        return (T[]) l(objArrCopyOf);
    }

    public static String U(@g.p0 Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return y1(networkCountryIso);
            }
        }
        return y1(Locale.getDefault().getCountry());
    }

    public static <T> T[] U0(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static Point V(Context context) {
        return W(context, ((WindowManager) a.g((WindowManager) context.getSystemService("window"))).getDefaultDisplay());
    }

    public static <T> T[] V0(T[] tArr, int i10) {
        a.a(i10 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i10);
    }

    public static Point W(Context context, Display display) {
        int i10 = f31154a;
        if (i10 <= 29 && display.getDisplayId() == 0 && I0(context)) {
            if ("Sony".equals(f31156c) && f31157d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, androidx.core.view.f.f4868b);
            }
            String strT0 = i10 < 28 ? t0("sys.display-size") : t0("vendor.display-size");
            if (!TextUtils.isEmpty(strT0)) {
                try {
                    String[] strArrN1 = n1(strT0.trim(), "x");
                    if (strArrN1.length == 2) {
                        int i11 = Integer.parseInt(strArrN1[0]);
                        int i12 = Integer.parseInt(strArrN1[1]);
                        if (i11 > 0 && i12 > 0) {
                            return new Point(i11, i12);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                t.d(f31160g, "Invalid display size: " + strT0);
            }
        }
        Point point = new Point();
        int i13 = f31154a;
        if (i13 >= 23) {
            b0(display, point);
        } else if (i13 >= 17) {
            a0(display, point);
        } else {
            Z(display, point);
        }
        return point;
    }

    public static <T> T[] W0(T[] tArr, int i10, int i11) {
        a.a(i10 >= 0);
        a.a(i11 <= tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i10, i11);
    }

    public static Looper X() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static <T> void X0(List<T> list, T[] tArr) {
        a.i(list.size() == tArr.length);
        list.toArray(tArr);
    }

    public static Uri Y(String str, String str2) {
        return Uri.parse("data:" + str + ";base64," + Base64.encodeToString(str2.getBytes(), 2));
    }

    public static long Y0(String str) throws ParserException {
        Matcher matcher = f31161h.matcher(str);
        if (!matcher.matches()) {
            throw new ParserException("Invalid date/time format: " + str);
        }
        int i10 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i10 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i10 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i10 != 0 ? timeInMillis - ((long) (i10 * 60000)) : timeInMillis;
    }

    public static void Z(Display display, Point point) {
        display.getSize(point);
    }

    public static long Z0(String str) {
        Matcher matcher = f31162i.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d10 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d11 = d10 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d12 = d11 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d13 = d12 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d14 = d13 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        long j10 = (long) ((d14 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
        return zIsEmpty ? -j10 : j10;
    }

    @g.v0(17)
    public static void a0(Display display, Point point) {
        display.getRealSize(point);
    }

    public static boolean a1(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static long b(long j10, long j11, long j12) {
        long j13 = j10 + j11;
        return ((j10 ^ j13) & (j11 ^ j13)) < 0 ? j12 : j13;
    }

    @g.v0(23)
    public static void b0(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static boolean b1(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static boolean c(@g.p0 Object obj, @g.p0 Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @g.p0
    public static UUID c0(String str) {
        String strW1 = w1(str);
        strW1.hashCode();
        switch (strW1) {
            case "playready":
                return ya.g.L1;
            case "widevine":
                return ya.g.K1;
            case "clearkey":
                return ya.g.J1;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static byte[] c1(com.google.android.exoplayer2.upstream.a aVar, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = aVar.read(bArr, i11, i10 - i11);
            if (i12 == -1) {
                throw new IllegalStateException("Not enough data could be read: " + i11 + " < " + i10);
            }
            i11 += i12;
        }
        return bArr;
    }

    public static <T extends Comparable<? super T>> int d(List<? extends Comparable<? super T>> list, T t10, boolean z10, boolean z11) {
        int i10;
        int iBinarySearch = Collections.binarySearch(list, t10);
        if (iBinarySearch < 0) {
            i10 = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t10) == 0);
            i10 = z10 ? iBinarySearch - 1 : iBinarySearch;
        }
        return z11 ? Math.min(list.size() - 1, i10) : i10;
    }

    public static int d0(String str) {
        int length = str.length();
        a.a(length <= 4);
        int iCharAt = 0;
        for (int i10 = 0; i10 < length; i10++) {
            iCharAt = (iCharAt << 8) | str.charAt(i10);
        }
        return iCharAt;
    }

    public static byte[] d1(com.google.android.exoplayer2.upstream.a aVar) throws IOException {
        byte[] bArrCopyOf = new byte[1024];
        int i10 = 0;
        int i11 = 0;
        while (i10 != -1) {
            if (i11 == bArrCopyOf.length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
            }
            i10 = aVar.read(bArrCopyOf, i11, bArrCopyOf.length - i11);
            if (i10 != -1) {
                i11 += i10;
            }
        }
        return Arrays.copyOf(bArrCopyOf, i11);
    }

    public static int e(int[] iArr, int i10, boolean z10, boolean z11) {
        int i11;
        int iBinarySearch = Arrays.binarySearch(iArr, i10);
        if (iBinarySearch < 0) {
            i11 = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= iArr.length) {
                    break;
                }
            } while (iArr[iBinarySearch] == i10);
            i11 = z10 ? iBinarySearch - 1 : iBinarySearch;
        }
        return z11 ? Math.min(iArr.length - 1, i11) : i11;
    }

    public static String e0(Locale locale) {
        return f31154a >= 21 ? f0(locale) : locale.toString();
    }

    public static void e1(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                e1(file2);
            }
        }
        file.delete();
    }

    public static int f(long[] jArr, long j10, boolean z10, boolean z11) {
        int i10;
        int iBinarySearch = Arrays.binarySearch(jArr, j10);
        if (iBinarySearch < 0) {
            i10 = ~iBinarySearch;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == j10);
            i10 = z10 ? iBinarySearch - 1 : iBinarySearch;
        }
        return z11 ? Math.min(jArr.length - 1, i10) : i10;
    }

    @g.v0(21)
    public static String f0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static <T> void f1(List<T> list, int i10, int i11) {
        if (i10 < 0 || i11 > list.size() || i10 > i11) {
            throw new IllegalArgumentException();
        }
        if (i10 != i11) {
            list.subList(i10, i11).clear();
        }
    }

    public static int g(u uVar, long j10, boolean z10, boolean z11) {
        int i10;
        int iC = uVar.c() - 1;
        int i11 = 0;
        while (i11 <= iC) {
            int i12 = (i11 + iC) >>> 1;
            if (uVar.b(i12) < j10) {
                i11 = i12 + 1;
            } else {
                iC = i12 - 1;
            }
        }
        if (z10 && (i10 = iC + 1) < uVar.c() && uVar.b(i10) == j10) {
            return i10;
        }
        if (z11 && iC == -1) {
            return 0;
        }
        return iC;
    }

    public static long g0(long j10, float f10) {
        return f10 == 1.0f ? j10 : Math.round(j10 * ((double) f10));
    }

    @g.v0(api = 23)
    public static boolean g1(Activity activity) {
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        return true;
    }

    public static <T extends Comparable<? super T>> int h(List<? extends Comparable<? super T>> list, T t10, boolean z10, boolean z11) {
        int i10;
        int iBinarySearch = Collections.binarySearch(list, t10);
        if (iBinarySearch < 0) {
            i10 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t10) == 0);
            i10 = z10 ? iBinarySearch + 1 : iBinarySearch;
        }
        return z11 ? Math.max(0, i10) : i10;
    }

    public static int h0(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return f31154a >= 29 ? 9 : 0;
        }
    }

    public static long h1(long j10, long j11, long j12) {
        if (j12 >= j11 && j12 % j11 == 0) {
            return j10 / (j12 / j11);
        }
        if (j12 < j11 && j11 % j12 == 0) {
            return j10 * (j11 / j12);
        }
        return (long) (j10 * (j11 / j12));
    }

    public static int i(int[] iArr, int i10, boolean z10, boolean z11) {
        int i11;
        int iBinarySearch = Arrays.binarySearch(iArr, i10);
        if (iBinarySearch < 0) {
            i11 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (iArr[iBinarySearch] == i10);
            i11 = z10 ? iBinarySearch + 1 : iBinarySearch;
        }
        return z11 ? Math.max(0, i11) : i11;
    }

    public static int i0(Context context) {
        ConnectivityManager connectivityManager;
        int i10 = 0;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i10 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return h0(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i10;
    }

    public static long[] i1(List<Long> list, long j10, long j11) {
        int size = list.size();
        long[] jArr = new long[size];
        int i10 = 0;
        if (j11 >= j10 && j11 % j10 == 0) {
            long j12 = j11 / j10;
            while (i10 < size) {
                jArr[i10] = list.get(i10).longValue() / j12;
                i10++;
            }
        } else if (j11 >= j10 || j10 % j11 != 0) {
            double d10 = j10 / j11;
            while (i10 < size) {
                jArr[i10] = (long) (list.get(i10).longValue() * d10);
                i10++;
            }
        } else {
            long j13 = j10 / j11;
            while (i10 < size) {
                jArr[i10] = list.get(i10).longValue() * j13;
                i10++;
            }
        }
        return jArr;
    }

    public static int j(long[] jArr, long j10, boolean z10, boolean z11) {
        int i10;
        int iBinarySearch = Arrays.binarySearch(jArr, j10);
        if (iBinarySearch < 0) {
            i10 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == j10);
            i10 = z10 ? iBinarySearch + 1 : iBinarySearch;
        }
        return z11 ? Math.max(0, i10) : i10;
    }

    public static long j0(long j10) {
        return j10 == ya.g.f56663b ? System.currentTimeMillis() : j10 + SystemClock.elapsedRealtime();
    }

    public static void j1(long[] jArr, long j10, long j11) {
        int i10 = 0;
        if (j11 >= j10 && j11 % j10 == 0) {
            long j12 = j11 / j10;
            while (i10 < jArr.length) {
                jArr[i10] = jArr[i10] / j12;
                i10++;
            }
            return;
        }
        if (j11 >= j10 || j10 % j11 != 0) {
            double d10 = j10 / j11;
            while (i10 < jArr.length) {
                jArr[i10] = (long) (jArr[i10] * d10);
                i10++;
            }
            return;
        }
        long j13 = j10 / j11;
        while (i10 < jArr.length) {
            jArr[i10] = jArr[i10] * j13;
            i10++;
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T k(@g.p0 T t10) {
        return t10;
    }

    public static int k0(int i10) {
        if (i10 == 8) {
            return 3;
        }
        if (i10 == 16) {
            return 2;
        }
        if (i10 == 24) {
            return 536870912;
        }
        if (i10 != 32) {
            return 0;
        }
        return ya.g.C;
    }

    public static boolean k1(char c10) {
        return c10 == '\"' || c10 == '%' || c10 == '*' || c10 == '/' || c10 == ':' || c10 == '<' || c10 == '\\' || c10 == '|' || c10 == '>' || c10 == '?';
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] l(T[] tArr) {
        return tArr;
    }

    public static Format l0(int i10, int i11, int i12) {
        return new Format.b().e0(w.G).H(i11).f0(i12).Y(i10).E();
    }

    public static void l1(Throwable th2) throws Throwable {
        m1(th2);
    }

    public static int m(int i10, int i11) {
        return ((i10 + i11) - 1) / i11;
    }

    public static int m0(int i10, int i11) {
        if (i10 != 2) {
            if (i10 == 3) {
                return i11;
            }
            if (i10 != 4) {
                if (i10 != 268435456) {
                    if (i10 == 536870912) {
                        return i11 * 3;
                    }
                    if (i10 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i11 * 4;
        }
        return i11 * 2;
    }

    public static <T extends Throwable> void m1(Throwable th2) throws Throwable {
        throw th2;
    }

    public static long n(long j10, long j11) {
        return ((j10 + j11) - 1) / j11;
    }

    public static long n0(long j10, float f10) {
        return f10 == 1.0f ? j10 : Math.round(j10 / ((double) f10));
    }

    public static String[] n1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static boolean o(ya.v0... v0VarArr) {
        if (f31154a < 24) {
            return true;
        }
        for (ya.v0 v0Var : v0VarArr) {
            v0.g gVar = v0Var.f57132b;
            if (gVar != null) {
                if (H0(gVar.f57183a)) {
                    return false;
                }
                for (int i10 = 0; i10 < v0Var.f57132b.f57189g.size(); i10++) {
                    if (H0(v0Var.f57132b.f57189g.get(i10).f57191a)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int o0(int i10) {
        if (i10 == 13) {
            return 1;
        }
        switch (i10) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static String[] o1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static void p(@g.p0 com.google.android.exoplayer2.upstream.a aVar) {
        if (aVar != null) {
            try {
                aVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String p0(StringBuilder sb2, Formatter formatter, long j10) {
        if (j10 == ya.g.f56663b) {
            j10 = 0;
        }
        String str = j10 < 0 ? "-" : "";
        long jAbs = (Math.abs(j10) + 500) / 1000;
        long j11 = jAbs % 60;
        long j12 = (jAbs / 60) % 60;
        long j13 = jAbs / 3600;
        sb2.setLength(0);
        return j13 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j13), Long.valueOf(j12), Long.valueOf(j11)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j12), Long.valueOf(j11)).toString();
    }

    public static String[] p1(@g.p0 String str) {
        return TextUtils.isEmpty(str) ? new String[0] : n1(str.trim(), "(\\s*,\\s*)");
    }

    public static void q(@g.p0 Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String[] q0() {
        String[] strArrR0 = r0();
        for (int i10 = 0; i10 < strArrR0.length; i10++) {
            strArrR0[i10] = S0(strArrR0[i10]);
        }
        return strArrR0;
    }

    @g.p0
    public static ComponentName q1(Context context, Intent intent) {
        return f31154a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static int r(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    public static String[] r0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f31154a >= 24 ? s0(configuration) : new String[]{e0(configuration.locale)};
    }

    public static long r1(long j10, long j11, long j12) {
        long j13 = j10 - j11;
        return ((j10 ^ j13) & (j11 ^ j10)) < 0 ? j12 : j13;
    }

    public static float s(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f10, f12));
    }

    @g.v0(24)
    public static String[] s0(Configuration configuration) {
        return n1(configuration.getLocales().toLanguageTags(), ag.c.f654g);
    }

    public static boolean s1(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static int t(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i10, i12));
    }

    @g.p0
    public static String t0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e10) {
            t.e(f31160g, "Failed to read system property " + str, e10);
            return null;
        }
    }

    public static byte[] t1(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static long u(long j10, long j11, long j12) {
        return Math.max(j11, Math.min(j10, j12));
    }

    public static String u0(int i10) {
        if (i10 == 0) {
            return "default";
        }
        if (i10 == 1) {
            return "audio";
        }
        if (i10 == 2) {
            return "video";
        }
        if (i10 == 3) {
            return "text";
        }
        if (i10 == 5) {
            return "metadata";
        }
        if (i10 == 6) {
            return "camera motion";
        }
        if (i10 == 7) {
            return "none";
        }
        if (i10 < 10000) {
            return "?";
        }
        return "custom (" + i10 + ee.a.f26979d;
    }

    public static String u1(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            sb2.append(Character.forDigit((bArr[i10] >> 4) & 15, 16));
            sb2.append(Character.forDigit(bArr[i10] & 15, 16));
        }
        return sb2.toString();
    }

    public static boolean v(Object[] objArr, @g.p0 Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String v0(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + fh.a.f28350w + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + ya.r0.f57056c;
    }

    public static long v1(int i10, int i11) {
        return x1(i11) | (x1(i10) << 32);
    }

    public static int w(byte[] bArr, int i10, int i11, int i12) {
        while (i10 < i11) {
            i12 = f31170q[((i12 >>> 24) ^ (bArr[i10] & 255)) & 255] ^ (i12 << 8);
            i10++;
        }
        return i12;
    }

    public static byte[] w0(String str) {
        return str.getBytes(Charsets.UTF_8);
    }

    public static String w1(String str) {
        return str == null ? str : str.toLowerCase(Locale.US);
    }

    public static int x(byte[] bArr, int i10, int i11, int i12) {
        while (i10 < i11) {
            i12 = f31171r[i12 ^ (bArr[i10] & 255)];
            i10++;
        }
        return i12;
    }

    public static byte[] x0(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public static long x1(int i10) {
        return ((long) i10) & 4294967295L;
    }

    public static Handler y(Looper looper, @g.p0 Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static int y0(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return A0(path);
    }

    public static String y1(String str) {
        return str == null ? str : str.toUpperCase(Locale.US);
    }

    public static Handler z() {
        return A(null);
    }

    public static int z0(Uri uri, @g.p0 String str) {
        if (TextUtils.isEmpty(str)) {
            return y0(uri);
        }
        return A0(j3.b.f36044h + str);
    }

    public static CharSequence z1(CharSequence charSequence, int i10) {
        return charSequence.length() <= i10 ? charSequence : charSequence.subSequence(0, i10);
    }
}
