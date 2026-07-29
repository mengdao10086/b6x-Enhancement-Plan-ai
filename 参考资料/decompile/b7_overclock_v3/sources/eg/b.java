package eg;

import android.annotation.TargetApi;
import bg.c;
import com.permissionx.guolindev.request.u;
import com.permissionx.guolindev.request.v;
import com.permissionx.guolindev.request.x;
import com.permissionx.guolindev.request.y;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d1;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.d0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n\"&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"", "", "allSpecialPermissions", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "", "permissionMapOnQ", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "permissionMapOnR", "c", "permissionMapOnS", "d", "permissionMapOnT", "e", "permissionx_release"}, k = 2, mv = {1, 7, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final Set<String> f26989a = d1.u(u.f22155f, "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", y.f22163f, x.f22161f, c.a.f9430a, v.f22157f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    @TargetApi(29)
    public static final Map<String, String> f26990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    @TargetApi(30)
    public static final Map<String, String> f26991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    @TargetApi(31)
    public static final Map<String, String> f26992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    @TargetApi(33)
    public static final Map<String, String> f26993e;

    static {
        Map<String, String> mapW = s0.W(kotlin.d1.a("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR"), kotlin.d1.a("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR"), kotlin.d1.a("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), kotlin.d1.a("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), kotlin.d1.a("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), kotlin.d1.a("android.permission.CAMERA", "android.permission-group.CAMERA"), kotlin.d1.a("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS"), kotlin.d1.a("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS"), kotlin.d1.a("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS"), kotlin.d1.a("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION"), kotlin.d1.a("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION"), kotlin.d1.a(u.f22155f, "android.permission-group.LOCATION"), kotlin.d1.a("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE"), kotlin.d1.a("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE"), kotlin.d1.a("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE"), kotlin.d1.a("android.permission.CALL_PHONE", "android.permission-group.PHONE"), kotlin.d1.a("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE"), kotlin.d1.a("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE"), kotlin.d1.a("android.permission.USE_SIP", "android.permission-group.PHONE"), kotlin.d1.a("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE"), kotlin.d1.a("android.permission.BODY_SENSORS", "android.permission-group.SENSORS"), kotlin.d1.a("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), kotlin.d1.a("android.permission.SEND_SMS", "android.permission-group.SMS"), kotlin.d1.a("android.permission.RECEIVE_SMS", "android.permission-group.SMS"), kotlin.d1.a("android.permission.READ_SMS", "android.permission-group.SMS"), kotlin.d1.a("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS"), kotlin.d1.a("android.permission.RECEIVE_MMS", "android.permission-group.SMS"), kotlin.d1.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), kotlin.d1.a("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), kotlin.d1.a("android.permission.ACCESS_MEDIA_LOCATION", "android.permission-group.STORAGE"));
        f26990b = mapW;
        Map mapJ0 = s0.J0(r0.k(kotlin.d1.a(y.f22163f, "android.permission-group.STORAGE")));
        mapJ0.putAll(mapW);
        Map<String, String> mapD0 = s0.D0(mapJ0);
        f26991c = mapD0;
        Map mapJ02 = s0.J0(s0.W(kotlin.d1.a("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), kotlin.d1.a("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), kotlin.d1.a("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")));
        mapJ02.putAll(mapD0);
        Map<String, String> mapD02 = s0.D0(mapJ02);
        f26992d = mapD02;
        Map mapJ03 = s0.J0(s0.W(kotlin.d1.a("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL"), kotlin.d1.a("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL"), kotlin.d1.a("android.permission.READ_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL"), kotlin.d1.a(c.a.f9430a, "android.permission-group.NOTIFICATIONS"), kotlin.d1.a("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES"), kotlin.d1.a(v.f22157f, "android.permission-group.SENSORS")));
        mapJ03.putAll(mapD02);
        f26993e = s0.D0(mapJ03);
    }

    @k
    public static final Set<String> a() {
        return f26989a;
    }

    @k
    public static final Map<String, String> b() {
        return f26990b;
    }

    @k
    public static final Map<String, String> c() {
        return f26991c;
    }

    @k
    public static final Map<String, String> d() {
        return f26992d;
    }

    @k
    public static final Map<String, String> e() {
        return f26993e;
    }
}
