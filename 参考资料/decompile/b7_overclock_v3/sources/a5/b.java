package a5;

import android.content.Context;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.s0;
import com.flydigi.data.DataConstant;
import com.flydigi.data.R;
import g.p0;
import g.v;
import o5.m;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a(String deviceCode) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
            case "wasp2":
                return R.drawable.device_gif_dfu_wasp2;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_gif_dfu_wasp;
            case "d1":
                return R.drawable.device_gif_dfu_d1;
            case "f1":
                return R.drawable.device_gif_dfu_f1;
            case "q1":
                return R.drawable.device_gif_dfu_q1;
            case "x8":
            case "x8p":
                return R.drawable.device_gif_dfu_x8;
            case "x9":
                return R.drawable.device_gif_dfu_x9;
            case "fp1":
            case "fp2":
            case "fp1s":
                return s0.g("device_upgrade_guide_" + deviceCode);
            case "wee":
                return R.drawable.device_gif_dfu_wee;
            case "apex":
                return R.drawable.device_gif_dfu_apex;
            case "f1_l":
                return R.drawable.device_gif_dfu_f1_l;
            case "wee2":
            case "wee2t":
                return R.drawable.device_gif_dfu_wee2;
            case "apex2":
                return R.drawable.device_gif_dfu_apex2;
            default:
                return Math.max(s0.g("device_gif_dfu_" + deviceCode), 0);
        }
    }

    public static int b(String deviceCode) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
            case "wasp2":
                return R.string.device_dfu_notice_wasp2;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.string.device_dfu_notice_wasp;
            case "d1":
                return R.string.device_dfu_notice_d1;
            case "f1":
                return R.string.device_dfu_notice_f1;
            case "q1":
                return R.string.device_dfu_notice_q1;
            case "x8":
            case "x8p":
                return R.string.device_dfu_notice_x8;
            case "x9":
                return R.string.device_dfu_notice_x9;
            case "wee":
                return R.string.device_dfu_notice_wee;
            case "apex":
                return R.string.device_dfu_notice_apex;
            case "f1_l":
                return R.string.device_dfu_notice_f1_l;
            case "wee2":
            case "wee2t":
                return R.string.device_dfu_notice_wee2;
            case "apex2":
                return R.string.device_dfu_notice_apex2;
            default:
                int iL = s0.l("device_dfu_notice_" + deviceCode);
                return iL > 0 ? iL : R.string.device_dfu_notice_apex;
        }
    }

    public static String c(String deviceCode) {
        return d(deviceCode, Boolean.FALSE, 0);
    }

    public static String d(String deviceCode, Boolean isIpType, int deviceId) {
        int iL;
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        iL = 0;
        switch (lowerCase) {
            case "wasp2t":
                return j1.a().getString(R.string.device_name_wasp2t);
            case "waspbt":
                return j1.a().getString(R.string.device_name_waspbt);
            case "cyberfox":
                return j1.a().getString(R.string.device_name_cyberfox);
            case "b3":
                return j1.a().getString(R.string.device_name_b3);
            case "d1":
                return j1.a().getString(R.string.device_name_d1);
            case "f1":
            case "f1wch":
                return j1.a().getString(R.string.device_name_f1);
            case "fc":
                return j1.a().getString(R.string.device_name_fc);
            case "ft":
                return j1.a().getString(R.string.device_name_ft);
            case "fy":
                return j1.a().getString(R.string.device_name_fy);
            case "hc":
                return j1.a().getString(R.string.device_name_hc);
            case "hw":
                return j1.a().getString(R.string.device_name_hw);
            case "q1":
                return j1.a().getString(R.string.device_name_q1);
            case "x1":
                return j1.a().getString(R.string.device_name_cyberfox_x1);
            case "x8":
            case "x8p":
                return j1.a().getString(R.string.device_name_x8);
            case "x9":
                return j1.a().getString(R.string.device_name_x9);
            case "yc":
                return j1.a().getString(R.string.device_name_yc);
            case "wee":
                return j1.a().getString(R.string.device_name_wee);
            case "apex":
                return j1.a().getString(R.string.device_name_apex);
            case "f1_l":
                return j1.a().getString(R.string.device_name_f1_l);
            case "wasp":
                return j1.a().getString(R.string.device_name_wasp);
            case "wee2":
                return j1.a().getString(R.string.device_name_wee2);
            case "apex2":
                return j1.a().getString(R.string.device_name_apex2);
            case "wasp2":
                return j1.a().getString(R.string.device_name_wasp2);
            case "waspn":
                return j1.a().getString(R.string.device_name_waspn);
            case "waspx":
                return j1.a().getString(R.string.device_name_waspx);
            case "wee2t":
                return j1.a().getString(R.string.device_name_wee2t);
            case "cyberfox_t1":
                return j1.a().getString(R.string.device_name_cyberfox_t1);
            default:
                if (isIpType.booleanValue()) {
                    iL = s0.l("device_name_" + deviceCode + "_" + deviceId);
                }
                if (iL <= 0) {
                    iL = s0.l("device_name_" + deviceCode);
                }
                return iL > 0 ? j1.a().getString(iL) : j1.a().getString(R.string.device_name_common_with_brand);
        }
    }

    public static int e(String deviceCode, boolean ipType, int deviceType) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
            case "wasp2":
                return R.drawable.device_ic_wasp2_simple;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_ic_wasp_simple;
            case "d1":
                return R.drawable.device_ic_d1_simple;
            case "f1":
            case "f1p":
            case "f1wch":
                return R.drawable.device_ic_f1_simple;
            case "q1":
                return R.drawable.device_ic_q1_simple;
            case "x8":
            case "x8p":
                return R.drawable.device_ic_x8_simple;
            case "x9":
                return R.drawable.device_ic_x9_simple;
            case "wee":
                return R.drawable.device_ic_wee_simple;
            case "apex":
                return R.drawable.device_ic_apex_simple;
            case "f1_l":
                return R.drawable.device_ic_f1l_simple;
            case "wee2":
            case "wee2t":
                return R.drawable.device_ic_wee2_simple;
            case "apex2":
                return R.drawable.device_ic_apex2_simple;
            default:
                return m(deviceCode, Boolean.valueOf(ipType), deviceType);
        }
    }

    public static int f(String deviceCode) {
        deviceCode.hashCode();
        switch (deviceCode) {
            case "cyberfox":
            case "x1":
            case "cyberfox_t1":
                return R.string.device_name_headset;
            case "b3":
            case "b5":
            case "b6":
            case "b7":
            case "b5p":
            case "b6x":
            case "b7x":
                return R.string.device_name_radiator;
            default:
                return R.string.device_name_gamepad;
        }
    }

    @l
    public static String g(Context context, @k String selectedDeviceCode) {
        selectedDeviceCode.hashCode();
        switch (selectedDeviceCode) {
            case "f1":
            case "f1p":
                return context.getString(R.string.device_connect_scanning_failure_keep_flash_desc_f1);
            case "x8":
            case "x8p":
                return context.getString(R.string.device_connect_scanning_failure_keep_flash_desc_x8);
            case "x9":
                return context.getString(R.string.device_connect_scanning_failure_keep_flash_desc_x9);
            case "apex":
                return context.getString(R.string.device_connect_scanning_failure_keep_flash_desc_apex);
            case "wasp":
            case "waspn":
            case "waspx":
                return context.getString(R.string.device_connect_scanning_failure_keep_flash_desc_wasp);
            case "apex2":
                return context.getString(R.string.device_connect_scanning_failure_keep_flash_desc_apex2);
            default:
                int iL = s0.l("device_connect_scanning_failure_keep_flash_desc_" + selectedDeviceCode);
                return iL > 0 ? context.getString(iL) : "";
        }
    }

    @v
    public static int h(String deviceCode) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
            case "wasp2":
                return R.drawable.device_situation_led_flash_wasp2;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_situation_led_flash_wasp;
            case "d1":
                return R.drawable.device_situation_led_flash_d1;
            case "f1":
            case "f1p":
                return R.drawable.device_situation_led_flash_f1;
            case "q1":
                return R.drawable.device_situation_led_flash_q1;
            case "x8":
            case "x8p":
                return R.drawable.device_situation_led_flash_x8;
            case "x9":
                return R.drawable.device_situation_led_flash_x9;
            case "wee":
                return R.drawable.device_situation_led_flash_wee;
            case "apex":
                return R.drawable.device_situation_led_flash_apex;
            case "wee2":
            case "wee2t":
                return R.drawable.device_situation_led_flash_wee2;
            case "apex2":
                return R.drawable.device_situation_led_flash_apex2;
            default:
                int iG = s0.g("device_situation_led_flash_" + deviceCode);
                return iG > 0 ? iG : R.drawable.device_situation_led_flash_apex;
        }
    }

    @v
    public static int i(String deviceCode) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
            case "wasp2":
                return R.drawable.device_situation_power_off_wasp2;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_situation_power_off_wasp;
            case "d1":
                return R.drawable.device_situation_power_off_d1;
            case "f1":
            case "f1p":
                return R.drawable.device_situation_power_off_f1;
            case "q1":
                return R.drawable.device_situation_power_off_q1;
            case "x8":
            case "x8p":
                return R.drawable.device_situation_power_off_x8;
            case "x9":
                return R.drawable.device_situation_power_off_x9;
            case "wee":
            case "wee2":
            case "wee2t":
                return R.drawable.device_situation_power_off_wee2;
            case "apex":
                return R.drawable.device_situation_power_off_apex;
            case "apex2":
                return R.drawable.device_situation_power_off_apex2;
            default:
                int iG = s0.g("device_situation_power_off_" + deviceCode);
                return iG > 0 ? iG : R.drawable.device_situation_power_off_apex;
        }
    }

    @v
    public static int j(String deviceCode) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
            case "wasp2":
                return R.drawable.device_situation_led_on_wasp2;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_situation_led_on_wasp;
            case "d1":
                return R.drawable.device_situation_led_on_d1;
            case "f1":
            case "f1p":
                return R.drawable.device_situation_led_on_f1;
            case "q1":
                return R.drawable.device_situation_led_on_q1;
            case "x8":
            case "x8p":
                return R.drawable.device_situation_led_on_x8;
            case "x9":
                return R.drawable.device_situation_led_on_x9;
            case "wee":
                return R.drawable.device_situation_led_on_wee;
            case "apex":
                return R.drawable.device_situation_led_on_apex;
            case "wee2":
            case "wee2t":
                return R.drawable.device_situation_led_on_wee2;
            case "apex2":
                return R.drawable.device_situation_led_on_apex2;
            default:
                int iG = s0.g("device_situation_led_on_" + deviceCode);
                return iG > 0 ? iG : R.drawable.device_situation_led_on_apex;
        }
    }

    public static int k(@p0 String deviceCode, boolean ipType, int deviceType) {
        int iG;
        if (ipType) {
            iG = s0.g("device_pic_led_" + deviceCode + "_" + deviceType);
        } else {
            iG = 0;
        }
        if (iG <= 0) {
            iG = s0.g("device_pic_led_" + deviceCode);
        }
        return Math.max(iG, 0);
    }

    @v
    public static int l(String deviceCode) {
        return m(deviceCode, Boolean.FALSE, 0);
    }

    public static int m(String deviceCode, Boolean isIpType, int deviceId) {
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "wasp2t":
                return R.drawable.device_ic_wasp2pro;
            case "waspbt":
                return R.drawable.device_ic_wasp_bt;
            case "d1":
                return R.drawable.device_ic_d1;
            case "f1":
                return R.drawable.device_ic_f1;
            case "q1":
                return R.drawable.device_ic_q1;
            case "x8":
            case "x8p":
                return R.drawable.device_ic_x8;
            case "x9":
                return R.drawable.device_ic_x9;
            case "wee":
                return R.drawable.device_ic_wee;
            case "apex":
                return R.drawable.device_ic_apex;
            case "f1_l":
                return R.drawable.device_ic_f1_l;
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_ic_wasp;
            case "wee2":
                return R.drawable.device_ic_wee2;
            case "apex2":
                return R.drawable.device_ic_apex2;
            case "wasp2":
                return R.drawable.device_ic_wasp2;
            case "wee2t":
                return R.drawable.device_ic_wee2t;
            default:
                String strR = m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME, "");
                if (isIpType.booleanValue()) {
                    int iG = s0.g("device_ic_" + deviceCode + "_" + deviceId);
                    if (iG > 0) {
                        return iG;
                    }
                }
                int iG2 = s0.g("device_ic_" + deviceCode + "_" + strR);
                if (iG2 > 0) {
                    return iG2;
                }
                int iG3 = s0.g("device_ic_" + deviceCode);
                return iG3 > 0 ? iG3 : R.drawable.device_ic_common;
        }
    }

    public static String n(String deviceCode, Boolean isIpType, int deviceType) {
        int iL;
        String lowerCase = d1.l(deviceCode).toLowerCase();
        lowerCase.hashCode();
        iL = 0;
        switch (lowerCase) {
            case "wasp2t":
                return j1.a().getString(R.string.device_slogan_wasp2t);
            case "waspbt":
                return j1.a().getString(R.string.device_slogan_waspbt);
            case "b3":
                return j1.a().getString(R.string.device_slogan_b3);
            case "d1":
                return j1.a().getString(R.string.device_slogan_d1);
            case "f1":
            case "f1p":
            case "f1_l":
                return j1.a().getString(R.string.device_slogan_f1);
            case "fc":
                return j1.a().getString(R.string.device_slogan_fc);
            case "q1":
                return j1.a().getString(R.string.device_slogan_q1);
            case "x8":
            case "x8p":
                return j1.a().getString(R.string.device_slogan_x8);
            case "x9":
                return j1.a().getString(R.string.device_slogan_x9);
            case "yc":
                return j1.a().getString(R.string.device_slogan_yc);
            case "wee":
                return j1.a().getString(R.string.device_slogan_wee);
            case "apex":
                return j1.a().getString(R.string.device_slogan_apex);
            case "wasp":
            case "waspn":
                return j1.a().getString(R.string.device_slogan_waspn);
            case "wee2":
                return j1.a().getString(R.string.device_slogan_wee2);
            case "apex2":
                return j1.a().getString(R.string.device_slogan_apex2);
            case "wasp2":
                return j1.a().getString(R.string.device_slogan_wasp2);
            case "waspx":
                return j1.a().getString(R.string.device_slogan_waspx);
            case "wee2t":
                return j1.a().getString(R.string.device_slogan_wee2t);
            default:
                if (isIpType.booleanValue()) {
                    iL = s0.l("device_slogan_" + deviceCode + "_" + deviceType);
                }
                if (iL <= 0) {
                    iL = s0.l("device_slogan_" + deviceCode);
                }
                return iL > 0 ? j1.a().getString(iL) : "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String o(java.lang.String r2) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.b.o(java.lang.String):java.lang.String");
    }

    @v
    public static int p(String deviceCode) {
        deviceCode.hashCode();
        switch (deviceCode) {
            case "wasp2t":
            case "wasp2":
                return R.drawable.device_situation_turn_on_wasp2;
            case "waspbt":
            case "wasp":
            case "waspn":
            case "waspx":
                return R.drawable.device_situation_turn_on_wasp;
            case "d1":
                return R.drawable.device_situation_turn_on_d1;
            case "f1":
            case "f1p":
                return R.drawable.device_situation_turn_on_f1;
            case "q1":
                return R.drawable.device_situation_turn_on_q1;
            case "x8":
            case "x8p":
                return R.drawable.device_situation_turn_on_x8;
            case "x9":
                return R.drawable.device_situation_turn_on_x9;
            case "wee":
                return R.drawable.device_situation_turn_on_wee;
            case "apex":
                return R.drawable.device_situation_turn_on_apex;
            case "wee2":
            case "wee2t":
                return R.drawable.device_situation_turn_on_wee2;
            case "apex2":
                return R.drawable.device_situation_turn_on_apex2;
            default:
                int iG = s0.g("device_situation_turn_on_" + deviceCode);
                return iG > 0 ? iG : R.drawable.device_situation_turn_on_apex;
        }
    }
}
