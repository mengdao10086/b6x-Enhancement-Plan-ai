package u9;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.x;
import com.flydigi.action.CommonLog;
import com.flydigi.action.LogAction;
import com.flydigi.base.common.n;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.flydigi.community.ui.search.result.ResultFragment;
import com.flydigi.data.DataConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import f0.v;
import java.util.HashMap;
import o5.m;
import org.json.JSONException;
import org.json.JSONObject;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static HashMap<String, String> a(LogAction statistics) {
        HashMap<String, String> map = new HashMap<>();
        map.put("action", statistics.a());
        map.put("gamepad", statistics.T());
        map.put("phone", statistics.X());
        map.put("model", statistics.b0());
        map.put("system", String.valueOf(Build.VERSION.SDK_INT));
        map.put("firmware", statistics.W());
        map.put("connect_type", statistics.C());
        return map;
    }

    public static <T extends LogAction> void b(T statistics, String action) throws JSONException {
        String strE = v5.a.j().e();
        String strG = v5.a.j().g();
        String strC = v5.a.j().c();
        String strB = v5.a.j().b();
        String str = v5.a.j().l() ? "已连接" : "未连接";
        String strH = v5.a.j().m() ? v5.a.j().h() : "";
        if (TextUtils.isEmpty(strE)) {
            try {
                String strR = m.k(DataConstant.SP_MAIN).r(DataConstant.SP_NAME_APP_START_DATA_STATISTICS, "");
                if (!TextUtils.isEmpty(strR)) {
                    JSONObject jSONObject = new JSONObject(strR);
                    if (jSONObject.has(com.flydigi.community.ui.search.b.f14046c)) {
                        strE = jSONObject.getString(com.flydigi.community.ui.search.b.f14046c);
                    }
                    if (d1.g(strG)) {
                        strG = jSONObject.getString("deviceName");
                    }
                    if (d1.g(strC)) {
                        strC = jSONObject.getString("firmwareVersion");
                    }
                    if (jSONObject.has("connectType")) {
                        strB = jSONObject.getString("connectType");
                    }
                    if (jSONObject.has("driverVersion")) {
                        strH = jSONObject.getString("driverVersion");
                    }
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        statistics.r0(strE);
        statistics.t0(strG);
        statistics.v0(strC);
        statistics.u0(strH);
        statistics.q0(strB);
        statistics.p0(str);
        statistics.x0(x.b());
        statistics.w0(Build.BRAND);
        statistics.y0(Build.MODEL);
        statistics.m0(action);
    }

    public static void c(Context context, String actionKey, String actionName) {
        e(context, actionKey, actionName, true);
    }

    public static void d(Context context, String actionKey, String actionName, ArrayMap<String, String> extraInfo) {
        f(context, actionKey, actionName, true, extraInfo);
    }

    public static void e(Context context, String actionKey, String actionName, boolean sendUserBehavior) throws JSONException {
        f(context, actionKey, actionName, sendUserBehavior, null);
    }

    public static void f(Context context, String actionKey, String actionName, boolean sendUserBehavior, ArrayMap<String, String> extraInfo) throws JSONException {
        CommonLog commonLog = new CommonLog();
        b(commonLog, actionName);
        HashMap<String, String> mapA = a(commonLog);
        if (n0.A(extraInfo)) {
            for (int i10 = 0; i10 < extraInfo.size(); i10++) {
                mapA.put(extraInfo.keyAt(i10), extraInfo.valueAt(i10));
            }
        }
        g.a().e(context, actionKey, mapA);
        if (sendUserBehavior) {
            com.flydigi.userBehavior.a.a().b(context, actionName);
        }
    }

    public static void g(final Context context, final String action) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, action);
        HashMap<String, String> mapA = a(commonLog);
        if (o5.b.k(context)) {
            mapA.put("usb_debug", "已开启");
        } else {
            mapA.put("usb_debug", "未开启");
        }
        n.a("sendActivationStatistics:" + action);
        g.a().e(context, "Module_Driver_Active", mapA);
    }

    public static void h(Context context, long id2, boolean isClick, boolean isSkip) {
        HashMap map = new HashMap();
        map.put("ad_id", String.valueOf(id2));
        if (isClick) {
            map.put("state", "点击广告");
        } else if (isSkip) {
            map.put("state", "点击跳过");
        } else {
            map.put("state", "倒计时结束");
        }
        g.a().e(context, "App_Start_Ad", map);
    }

    public static void i(Context context, final int id2, final int type, final String source, String action) {
        HashMap map = new HashMap();
        map.put(CommentListFragment.M8, String.valueOf(id2));
        if (!d1.g(source)) {
            map.put("source", source);
        }
        map.put("action", action);
        if (type == 0) {
            map.put("type", "官方");
        } else if (type == 1) {
            map.put("type", "讨论");
        } else if (type == 2) {
            map.put("type", "配置");
        }
        g.a().e(context, "Community_Article_Read", map);
    }

    public static void j(final Context context, final String action, final String keyword, String refer) {
        HashMap map = new HashMap();
        if (keyword != null) {
            map.put(ResultFragment.H8, keyword);
        }
        map.put("action", action);
        map.put("source", refer);
        g.a().e(context, "Community_Search_Action", map);
    }

    public static void k(Context context, String packageName, String actionKey, String actionName) {
        l(context, packageName, actionKey, actionName, true);
    }

    public static void l(Context context, String packageName, String actionKey, String actionName, boolean sendUserBehavior) throws JSONException {
        m(context, packageName, actionKey, actionName, sendUserBehavior, null);
    }

    public static void m(Context context, String packageName, String actionKey, String actionName, boolean sendUserBehavior, ArrayMap<String, String> extraInfo) throws JSONException {
        CommonLog commonLog = new CommonLog();
        b(commonLog, actionName);
        HashMap<String, String> mapA = a(commonLog);
        mapA.put("packageName", packageName);
        if (n0.A(extraInfo)) {
            for (int i10 = 0; i10 < extraInfo.size(); i10++) {
                mapA.put(extraInfo.keyAt(i10), extraInfo.valueAt(i10));
            }
        }
        g.a().e(context, actionKey, mapA);
        if (sendUserBehavior) {
            com.flydigi.userBehavior.a.a().b(context, actionName);
        }
    }

    public static void n(Context context, String action, String gameId, String refer) {
        HashMap map = new HashMap();
        map.put("game_id", gameId);
        map.put("source", refer);
        g.a().e(context, "Game_Detail_Visit", map);
    }

    public static void o(Context context, String gameId, String event, String refer) {
        HashMap map = new HashMap();
        map.put("game_id", gameId);
        map.put(v.I0, event);
        map.put("source", refer);
        g.a().e(context, "Game_Download", map);
    }

    public static void p(@l Context context, @l String title, @l String type) throws JSONException {
        String str;
        CommonLog commonLog = new CommonLog();
        b(commonLog, "外设公告点击");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put("title", title);
        if (n0.x(type)) {
            type.hashCode();
            switch (type) {
                case "1":
                    str = "帖子";
                    break;
                case "2":
                    str = "游戏详情";
                    break;
                case "3":
                case "7":
                    str = "外链";
                    break;
                case "4":
                    str = "天猫商品详情";
                    break;
                case "5":
                    str = "店铺";
                    break;
                case "6":
                    str = "斗鱼";
                    break;
                default:
                    str = "未知";
                    break;
            }
            mapA.put("type", str);
        }
        g.a().e(context, "Device_Top_Notice_Click", mapA);
    }

    public static void q(Context context, boolean fromShortcut, int position, String mPackageName) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "悬浮窗_游戏配置_应用配置");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put("source", fromShortcut ? "快捷键" : "触屏");
        mapA.put(CommonNetImpl.POSITION, String.valueOf(position));
        mapA.put("packageName", mPackageName);
        g.a().e(context, "FloatView_Import_Config", mapA);
    }

    public static void r(Context context, String productName) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "访问商品详情");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put("product", productName);
        g.a().e(context, "Mall_Product_Detail", mapA);
    }

    public static void s(Context context, String productName) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "访问淘宝商品详情");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put("product", productName);
        g.a().e(context, "Mall_Product_Detail_CLICK", mapA);
    }

    public static void t(Context context, String packageName, String title) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "悬浮窗_游戏配置_推荐配置下载");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put(DataConstant.CONFIG_FOLDER, title);
        mapA.put("packageName", packageName);
        g.a().e(context, "FloatView_Download_Recommend_Config", mapA);
    }

    public static void u(Context context, String title, String packageName, String action) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "悬浮窗_游戏配置_推荐下载重命名");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put(DataConstant.CONFIG_FOLDER, title);
        mapA.put("packageName", packageName);
        mapA.put("action", action);
        g.a().e(context, "FloatView_Rename_Config_When_Download", mapA);
    }

    public static void v(Context context, String title, String packageName, boolean inTop) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "悬浮窗_游戏配置_置顶配置");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put(DataConstant.CONFIG_FOLDER, title);
        mapA.put("packageName", packageName);
        mapA.put("action", inTop ? "置顶" : "取消置顶");
        g.a().e(context, "FloatView_SetTop_Config", mapA);
    }

    public static void w(Context context, String packageName, boolean show) {
        CommonLog commonLog = new CommonLog();
        b(commonLog, "悬浮窗_游戏配置_显示配置");
        HashMap<String, String> mapA = a(commonLog);
        mapA.put("packageName", packageName);
        mapA.put("show", show ? "显示" : "隐藏");
        g.a().e(context, "FloatView_Show_Config", mapA);
    }
}
