package v5;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.t0;
import com.flydigi.base.common.n;
import com.flydigi.base.common.o;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import i9.a;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a(Context context, boolean checkDriver, GamepadInfo deviceInfo) {
        if (deviceInfo == null || !deviceInfo.isConnected()) {
            o.E(context.getString(R.string.device_connect_game_pad_before_start_game));
            return false;
        }
        if (!checkDriver || !deviceInfo.isDriverMode() || u9.b.d() || deviceInfo.isDriverConnected()) {
            return true;
        }
        o.E(context.getString(R.string.device_active_mapping_before_start_game));
        return false;
    }

    public static boolean b(Context context) {
        return 1 == Settings.System.getInt(context.getContentResolver(), DataConstant.KEY_GAME_DO_NOT_DISTURB, 1);
    }

    public static void c(Context context, String packageName) {
        d(context, packageName, true);
    }

    public static void d(Context context, String packageName, boolean notifyRemoteService) {
        try {
            com.blankj.utilcode.util.d.S(packageName);
            if (t0.A() && u9.b.e(true)) {
                Intent intent = new Intent("gamepad.vendor.launch.game");
                intent.putExtra("vendorPkg", com.blankj.utilcode.util.d.l());
                intent.putExtra("gamePkg", packageName);
                context.sendBroadcast(intent);
                b0.n(DataConstant.DIRECTORY_PUBLIC + "/.runState");
            }
            if (notifyRemoteService) {
                ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).e(context, DataConstant.REMOTE_ACTION_START_GAME, "package_name", packageName);
            }
        } catch (Exception e10) {
            n.b("launchApp", e10);
        }
    }
}
