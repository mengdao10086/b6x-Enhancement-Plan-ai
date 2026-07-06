package a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f7774a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j60 f3421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3422a;
    public boolean b = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3423a = false;

    public wc0(Context context) {
        this.f3422a = context;
        this.f3421a = new j60(context);
    }

    public final String b(String str) {
        return str.startsWith("file:///android_asset/") ? str.substring(22) : str;
    }

    public final void c(String str) {
        new Handler(Looper.getMainLooper()).post(new vc0(this, str));
    }

    public String d(String str) {
        String strB = b(str);
        return strB.contains("/") ? e(strB, strB.substring(0, strB.lastIndexOf("/") + 1)) : e(strB, strB);
    }

    public final String e(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (this.b && f7774a.containsKey(str)) {
            return f7774a.get(str);
        }
        if (str.endsWith(".sh")) {
            return h(str, str2);
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        String strJ = c60.f5764a.j(this.f3422a.getAssets(), str, i(str, str2), this.f3422a);
        if (strJ == null) {
            c(str);
        } else if (!f7774a.containsKey(str)) {
            f7774a.put(str, strJ);
        }
        return strJ;
    }

    public String f(String str) {
        return g(str, str);
    }

    public final String g(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (this.b && f7774a.containsKey(str)) {
            return f7774a.get(str);
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        } else if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        try {
            String[] list = this.f3422a.getAssets().list(str);
            if (list == null || list.length <= 0) {
                return d(str);
            }
            for (String str3 : list) {
                g(str + "/" + str3, str2);
            }
            String strJ = j(str, str2);
            if (!f7774a.containsKey(str)) {
                f7774a.put(str, strJ);
            }
            return strJ;
        } catch (Exception e) {
            c(str + "\n" + e.getMessage());
            return "";
        }
    }

    public final String h(String str, String str2) {
        String strD = null;
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (this.b && f7774a.containsKey(str)) {
            return f7774a.get(str);
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        try {
            byte[] bytes = this.f3421a.b(new String(y50.f7950a.b(this.f3422a, str)), false).getBytes(bb2.f5692a);
            String strI = i(str, str2);
            if (!c60.f5764a.l(c60.f5764a.b(bytes), strI, this.f3422a)) {
                return null;
            }
            strD = c60.f5764a.d(this.f3422a, strI);
            f7774a.put(str, strD);
            return strD;
        } catch (Exception unused) {
            return strD;
        }
    }

    public final String i(String str, String str2) {
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
        }
        return (this.f3423a && str.contains(str2)) ? str.substring(str2.length()) : str;
    }

    public String j(String str, String str2) {
        return c60.f5764a.d(this.f3422a, i(str, str2));
    }
}
