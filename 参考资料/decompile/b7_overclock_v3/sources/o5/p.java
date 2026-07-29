package o5;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.j1;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static boolean a(Context context, String str) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("text", str);
        if (clipboardManager == null) {
            return false;
        }
        clipboardManager.setPrimaryClip(clipDataNewPlainText);
        return true;
    }

    public static String b() {
        Locale localeM = h0.m();
        return localeM.getLanguage() + "_" + localeM.getCountry();
    }

    public static boolean c(String str) {
        if (d1.h(str)) {
            return false;
        }
        try {
            return j1.a().getPackageManager().getApplicationInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean d() {
        return androidx.core.util.j.a(h0.m().getLanguage(), "zh");
    }
}
