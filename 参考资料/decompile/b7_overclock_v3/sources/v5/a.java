package v5;

import android.text.TextUtils;
import com.blankj.utilcode.util.e0;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.headset.HeadsetInfo;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import m5.f0;
import o5.m;
import t9.j;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GamepadInfo f52704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WaspWingInfo f52705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HeadsetInfo f52706c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f52707a = new a();
    }

    public static a j() {
        return b.f52707a;
    }

    public boolean a() {
        return m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_KEY_CAST_ASSIST, true);
    }

    public String b() {
        GamepadInfo gamepadInfo = this.f52704a;
        return gamepadInfo != null ? gamepadInfo.getReadableConnectMode() : "";
    }

    public String c() {
        GamepadInfo gamepadInfo = this.f52704a;
        return gamepadInfo != null ? gamepadInfo.getFirmwareVersion() : "";
    }

    public GamepadInfo d() {
        if (this.f52704a == null) {
            String strR = m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_LATEST_DEVICE, "");
            if (TextUtils.isEmpty(strR)) {
                this.f52704a = new GamepadInfo();
            } else {
                GamepadInfo gamepadInfo = (GamepadInfo) f0.i().h().fromJson(strR, GamepadInfo.class);
                this.f52704a = gamepadInfo;
                gamepadInfo.setConnectState(0);
                this.f52704a.setDriverConnected(false);
            }
        }
        return this.f52704a;
    }

    public String e() {
        GamepadInfo gamepadInfo = this.f52704a;
        return gamepadInfo != null ? gamepadInfo.getAddress() : "";
    }

    public int f() {
        GamepadInfo gamepadInfo = this.f52704a;
        if (gamepadInfo != null) {
            return gamepadInfo.getDeviceMode();
        }
        return -1;
    }

    public String g() {
        GamepadInfo gamepadInfo = this.f52704a;
        return gamepadInfo != null ? gamepadInfo.getDeviceName() : "";
    }

    public String h() {
        GamepadInfo gamepadInfo = this.f52704a;
        return gamepadInfo != null ? gamepadInfo.getDriverVersion() : "";
    }

    public HeadsetInfo i() {
        if (this.f52706c == null) {
            try {
                HeadsetInfo headsetInfo = (HeadsetInfo) e0.h(m.i().q(DataConstant.SP_DEVICE_HAS_HEADSET_CONNECTED), HeadsetInfo.class);
                this.f52706c = headsetInfo;
                if (headsetInfo.getAddress().isEmpty()) {
                    this.f52706c = null;
                }
            } catch (Exception unused) {
                this.f52706c = null;
            }
        }
        if (this.f52706c == null && !q9.f.h().isEmpty()) {
            this.f52706c = HeadsetInfo.convertFromDevice(q9.f.h().get(0));
        }
        HeadsetInfo headsetInfo2 = this.f52706c;
        if (headsetInfo2 != null) {
            headsetInfo2.setConnected(q9.f.q(headsetInfo2.getAddress()));
        }
        return this.f52706c;
    }

    public WaspWingInfo k() {
        if (this.f52705b == null) {
            try {
                WaspWingInfo waspWingInfo = (WaspWingInfo) e0.h(m.i().q(DataConstant.SP_DEVICE_HAS_WASPWING_CONNECTED), WaspWingInfo.class);
                this.f52705b = waspWingInfo;
                if (waspWingInfo.getAddress() == null || this.f52705b.getAddress().isEmpty()) {
                    this.f52705b = null;
                }
            } catch (Exception unused) {
                this.f52705b = null;
            }
        }
        if (this.f52705b == null && !j.g().isEmpty()) {
            this.f52705b = WaspWingInfo.convertFromDevice(j.g().get(0));
        }
        WaspWingInfo waspWingInfo2 = this.f52705b;
        if (waspWingInfo2 != null) {
            waspWingInfo2.setConnected(j.s(waspWingInfo2.getAddress()));
        }
        return this.f52705b;
    }

    public boolean l() {
        GamepadInfo gamepadInfo = this.f52704a;
        if (gamepadInfo != null) {
            return gamepadInfo.isConnected();
        }
        return false;
    }

    public boolean m() {
        GamepadInfo gamepadInfo = this.f52704a;
        if (gamepadInfo != null) {
            return gamepadInfo.isDriverConnected();
        }
        return false;
    }

    public boolean n() {
        GamepadInfo gamepadInfo = this.f52704a;
        if (gamepadInfo != null) {
            return gamepadInfo.isFlashplayMode();
        }
        return false;
    }

    public void o(GamepadInfo deviceInfo) {
        this.f52704a = deviceInfo;
    }

    public a() {
    }
}
