package com.flydigi.device_manager.ui;

import android.os.Build;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes7.dex */
public class p {
    public static boolean a() {
        boolean z10 = !u9.b.r();
        if (!z10) {
            z10 = Build.VERSION.SDK_INT >= 29;
        }
        return o5.m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_APP_KEY_FLASHPLAY_SUPPORT, -1) != 0 || z10;
    }

    public static int b(GamepadInfo gamepadInfo) {
        com.flydigi.base.common.n.a(MessageFormat.format("{0} 模式 {1}", p.class.getSimpleName(), gamepadInfo.toString()));
        int mappingMode = gamepadInfo.getMappingMode();
        if (gamepadInfo.isFlashplayMode()) {
            com.flydigi.base.common.n.a(MessageFormat.format("{0} 当前是智连模式，开始检测模式是否正确", p.class.getSimpleName()));
            if (!a() || (gamepadInfo.isGamepadHalf() && !u9.b.e(true))) {
                com.flydigi.base.common.n.a(MessageFormat.format("{0} 当前不支持智连模式,需要切换到传统模式", p.class.getSimpleName()));
                return 0;
            }
            if (gamepadInfo.getMappingMode() == 4) {
                com.flydigi.base.common.n.a(MessageFormat.format("{0} 当前是iOS智连模式，需要切换到Android智连模式", p.class.getSimpleName()));
                return 1;
            }
        } else {
            com.flydigi.base.common.n.a(MessageFormat.format("{0} 当前是传统模式，无需切换", p.class.getSimpleName()));
        }
        return mappingMode;
    }
}
