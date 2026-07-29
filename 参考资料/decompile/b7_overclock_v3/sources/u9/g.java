package u9;

import android.content.Context;
import com.blankj.utilcode.util.n0;
import com.flydigi.data.DataConstant;
import com.umeng.analytics.MobclickAgent;
import java.util.Map;
import o5.m;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f51966a = new g();
    }

    public static g a() {
        return b.f51966a;
    }

    public void b(Context context, String eventId) {
        if (m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            MobclickAgent.onEvent(context, eventId);
        }
    }

    public void c(Context context, String eventID, String label) {
        if (m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            MobclickAgent.onEvent(context, eventID, label);
        }
    }

    public void d(Context context, String eventID, String label, Map<String, String> map) {
        if (m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            MobclickAgent.onEvent(context, eventID, map);
        }
    }

    public void e(Context context, String eventID, Map<String, String> map) {
        if (m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            if (n0.A(map)) {
                MobclickAgent.onEvent(context, eventID, map);
            } else {
                MobclickAgent.onEvent(context, eventID);
            }
        }
    }

    public void f(Context context, String eventID, Map<String, String> map, int du2) {
        if (m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            MobclickAgent.onEventValue(context, eventID, map, du2);
        }
    }

    public void g(Context context) {
        if (m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            MobclickAgent.onKillProcess(context);
        }
    }

    public g() {
    }
}
