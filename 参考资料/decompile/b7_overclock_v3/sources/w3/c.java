package w3;

import android.annotation.SuppressLint;
import android.os.Build;
import com.permissionx.guolindev.request.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53845a = "CALENDAR";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f53846b = "CAMERA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f53847c = "CONTACTS";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f53848d = "LOCATION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f53849e = "MICROPHONE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f53850f = "PHONE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f53851g = "SENSORS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f53852h = "SMS";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f53853i = "STORAGE";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f53854j = "ACTIVITY_RECOGNITION";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f53855k = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f53856l = {"android.permission.CAMERA"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f53857m = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f53858n = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", u.f22155f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f53859o = {"android.permission.RECORD_AUDIO"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f53860p = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f53861q = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f53862r = {"android.permission.BODY_SENSORS"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f53863s = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f53864t = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String[] f53865u = {"android.permission.ACTIVITY_RECOGNITION"};

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static String[] a(String str) {
        if (str == null) {
            return new String[0];
        }
        switch (str) {
            case "LOCATION":
                return f53858n;
            case "SENSORS":
                return f53862r;
            case "STORAGE":
                return f53864t;
            case "SMS":
                return f53863s;
            case "PHONE":
                return Build.VERSION.SDK_INT < 26 ? f53861q : f53860p;
            case "ACTIVITY_RECOGNITION":
                return f53865u;
            case "CONTACTS":
                return f53857m;
            case "CALENDAR":
                return f53855k;
            case "MICROPHONE":
                return f53859o;
            case "CAMERA":
                return f53856l;
            default:
                return new String[]{str};
        }
    }
}
