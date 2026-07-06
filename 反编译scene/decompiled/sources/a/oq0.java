package a;

import android.accessibilityservice.AccessibilityService;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nq0 f7047a = new nq0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static AccessibilityNodeInfo f2281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static CharSequence f2282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f2283a;
    public static String b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jx0 f2286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lq0 f2287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nb2 f2288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilityService f2289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f2290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String> f2291a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2292b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final nb2 f2293b;

    public oq0(AccessibilityService accessibilityService) {
        f92.d(accessibilityService, "service");
        this.f2289a = accessibilityService;
        this.f2286a = new jx0(this.f2289a.getApplicationContext());
        this.f2290a = this.f2289a.getSharedPreferences(hz0.f1282a.c(), 0);
        this.f2287a = new lq0();
        this.f2291a = y42.c("android", "com.android.systemui", "com.miui.home", "com.tencent.mobileqq", "com.tencent.mm", "com.omarea.vtools", "com.omarea.gesture", "com.android.settings");
        this.f2288a = new nb2("^[0-9]+[\\ss]*跳过[广告]*$");
        this.f2293b = new nb2("^[点击]*跳过[广告]*[\\ss]{0,}[0-9]+$");
    }

    public final boolean d(Rect rect) {
        String str;
        float f = rect.top;
        int i = this.f2292b;
        float f2 = i - rect.bottom;
        float f3 = rect.left;
        int i2 = this.f2284a;
        float f4 = i2 - rect.right;
        if (i > i2) {
            i = i2;
        }
        float f5 = i;
        float f6 = 0.3f * f5;
        float f7 = f5 * 0.28f;
        if (f > f7 && f2 > f7) {
            str = "Y Filter " + f + ' ' + f2 + ' ' + f7;
        } else {
            if (f3 <= f6 || f4 <= f6) {
                return true;
            }
            str = "X Filter " + f3 + ' ' + f4 + ' ' + f6;
        }
        Log.d("@Scene", str);
        return false;
    }

    public final boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        String strC = this.f2286a.c(b);
        if (strC == null || (listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(strC)) == null) {
            return false;
        }
        int size = listFindAccessibilityNodeInfosByViewId.size();
        for (int i = 0; i < size; i++) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = listFindAccessibilityNodeInfosByViewId.get(i);
            if (!f92.a(f7047a.c(), accessibilityNodeInfo2)) {
                f7047a.d(accessibilityNodeInfo2);
                CharSequence packageName = accessibilityNodeInfo.getPackageName();
                f2283a = packageName != null ? packageName.toString() : null;
                lq0 lq0Var = this.f2287a;
                f92.c(accessibilityNodeInfo2, "node");
                if (!lq0Var.b(accessibilityNodeInfo2)) {
                    this.f2287a.e(accessibilityNodeInfo2, this.f2289a);
                }
                Scene.f4798a.o("Scene自动点了(" + strC + ')', 0);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.view.accessibility.AccessibilityEvent r20, boolean r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.oq0.f(android.view.accessibility.AccessibilityEvent, boolean, int, int):void");
    }
}
