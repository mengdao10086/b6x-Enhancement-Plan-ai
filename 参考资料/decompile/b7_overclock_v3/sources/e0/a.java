package e0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import g.n0;
import g.p0;
import o5.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f26540a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f26541b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f26542c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f26543d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26544e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26545f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26546g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26547h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f26548i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f26549j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f26550k = 32;

    @n0
    public static String a(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? h.f42757n : "CAPABILITY_CAN_FILTER_KEY_EVENTS" : "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY" : "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION" : "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    }

    @n0
    public static String b(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        while (i10 > 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i10);
            i10 &= ~iNumberOfTrailingZeros;
            if (sb2.length() > 1) {
                sb2.append(", ");
            }
            if (iNumberOfTrailingZeros == 1) {
                sb2.append("FEEDBACK_SPOKEN");
            } else if (iNumberOfTrailingZeros == 2) {
                sb2.append("FEEDBACK_HAPTIC");
            } else if (iNumberOfTrailingZeros == 4) {
                sb2.append("FEEDBACK_AUDIBLE");
            } else if (iNumberOfTrailingZeros == 8) {
                sb2.append("FEEDBACK_VISUAL");
            } else if (iNumberOfTrailingZeros == 16) {
                sb2.append("FEEDBACK_GENERIC");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @p0
    public static String c(int i10) {
        if (i10 == 1) {
            return "DEFAULT";
        }
        if (i10 == 2) {
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        if (i10 == 4) {
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        }
        if (i10 == 8) {
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (i10 == 16) {
            return "FLAG_REPORT_VIEW_IDS";
        }
        if (i10 != 32) {
            return null;
        }
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static int d(@n0 AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCapabilities();
    }

    @p0
    public static String e(@n0 AccessibilityServiceInfo accessibilityServiceInfo, @n0 PackageManager packageManager) {
        return accessibilityServiceInfo.loadDescription(packageManager);
    }
}
