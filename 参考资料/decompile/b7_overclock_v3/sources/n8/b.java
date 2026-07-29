package n8;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.core.util.k;
import com.blankj.utilcode.util.d1;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import i9.a;
import java.util.Objects;
import l9.c;
import m9.m;
import m9.t;
import o5.d;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static k<Integer, String> a(Context context, CFGEntity cFGEntity, GamepadInfo gamepadInfo) {
        return b(context, cFGEntity, gamepadInfo, false);
    }

    public static k<Integer, String> b(Context context, CFGEntity cFGEntity, GamepadInfo gamepadInfo, boolean z10) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < cFGEntity.keyList.size(); i14++) {
            CFGPropertyKey cFGPropertyKey = cFGEntity.keyList.get(i14);
            int i15 = cFGPropertyKey.type;
            boolean z11 = i15 == 1 && cFGPropertyKey.sub_type == 0;
            boolean z12 = i15 == 1 && cFGPropertyKey.sub_type == 7;
            boolean z13 = i15 == 1 && cFGPropertyKey.sub_type == 5;
            boolean z14 = i15 == 11;
            boolean z15 = i15 == 1 && cFGPropertyKey.sub_type == 2;
            boolean z16 = i15 == 1 && cFGPropertyKey.sub_type == 3;
            if (z11 || z12 || z13 || z14 || z15 || z16) {
                i12++;
            } else {
                i11++;
                if (i15 == 34) {
                    i10++;
                }
            }
            if (m.a(cFGPropertyKey.key_id)) {
                i13++;
            }
        }
        if (gamepadInfo.isGamepadHalf() && i10 > 1) {
            return new k<>(-1, context.getString(z10 ? R.string.floatview_key_count_validate_assist_shoot_import : R.string.floatview_key_count_validate_assist_shoot, 1));
        }
        int i16 = t.d(gamepadInfo) ? 15 : 10;
        if (i11 > i16) {
            return new k<>(-3, context.getString(z10 ? R.string.floatview_key_count_validate_adv_import : R.string.floatview_key_count_validate_adv, Integer.valueOf(i16)));
        }
        int i17 = t.d(gamepadInfo) ? 60 : 40;
        if (i12 + cFGEntity.marcoList.size() > i17) {
            return new k<>(-4, context.getString(z10 ? R.string.floatview_key_count_validate_basic_import : R.string.floatview_key_count_validate_basic, Integer.valueOf(i17)));
        }
        int size = 0;
        for (int i18 = 0; i18 < cFGEntity.marcoList.size(); i18++) {
            CFGPropertyMacro cFGPropertyMacro = cFGEntity.marcoList.get(i18);
            if (com.flydigi.sdk.gamepad.extension.a.f(cFGPropertyMacro.key_cancel, gamepadInfo.getDeviceMode()) == cFGPropertyMacro.key_id) {
                return new k<>(-7, context.getString(R.string.macro_stop_key_conflict_desc));
            }
            size += cFGPropertyMacro.macro_keys.size();
            if (m.a(cFGPropertyMacro.key_id)) {
                i13++;
            }
        }
        String firmwareVersion = gamepadInfo.getFirmwareVersion();
        Objects.requireNonNull(firmwareVersion);
        int i19 = c.b(m9.k.f40818d, firmwareVersion) ? 60 : 40;
        if (size > i19) {
            return new k<>(-8, String.format(context.getString(z10 ? R.string.floatview_key_count_validate_macro_child_count_import : R.string.floatview_key_count_validate_macro_child_count), Integer.valueOf(i19)));
        }
        if (!gamepadInfo.isGamepadKeyboard()) {
            if (i13 > 12 && t.b(gamepadInfo)) {
                return new k<>(-5, context.getString(z10 ? R.string.floatview_key_count_validate_key_combination_import : R.string.floatview_key_count_validate_key_combination, 12));
            }
            if (i13 > 24) {
                return new k<>(-5, context.getString(z10 ? R.string.floatview_key_count_validate_key_combination_import : R.string.floatview_key_count_validate_key_combination, 24));
            }
        }
        return new k<>(0, "");
    }

    public static boolean c(int i10, CFGEntity cFGEntity) {
        if (cFGEntity != null) {
            for (int i11 = 0; i11 < cFGEntity.keyList.size(); i11++) {
                if (cFGEntity.keyList.get(i11).key_id == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(int i10, CFGEntity cFGEntity) {
        if (cFGEntity != null) {
            for (int i11 = 0; i11 < cFGEntity.keyList.size(); i11++) {
                if (cFGEntity.keyList.get(i11).key_id == i10) {
                    return true;
                }
            }
            for (int i12 = 0; i12 < cFGEntity.marcoList.size(); i12++) {
                if (cFGEntity.marcoList.get(i12).key_id == i10) {
                    return true;
                }
            }
            for (int i13 = 0; i13 < cFGEntity.marcoList.size(); i13++) {
                if (cFGEntity.marcoList.get(i13).key_id_cancel == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        return d1.g(str) || TextUtils.equals(str, DataConstant.TEST_KEYMAPPING) || TextUtils.equals(str, context.getPackageName());
    }

    /* JADX WARN: Removed duplicated region for block: B:305:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(android.content.Context r2, int r3, int r4, int r5) {
        /*
            Method dump skipped, instruction units count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.b.f(android.content.Context, int, int, int):java.lang.String");
    }

    public static String g(Context context, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != 256) {
            return f(context, i10, i13, i14);
        }
        return f(context, i11, i13, i14) + com.google.android.material.badge.a.f19590u + f(context, i12, i13, i14);
    }

    public static WindowManager.LayoutParams h(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? d.q(true, true) : d.q(false, false) : d.q(false, true) : d.q(true, false) : d.q(true, true);
    }

    public static int i(int i10) {
        if (i10 == 1) {
            return R.string.floatview_property_joystick_move;
        }
        if (i10 == 2) {
            return R.string.floatview_property_joystick_mapkey;
        }
        if (i10 == 4) {
            return R.string.floatview_property_joystick_fps;
        }
        if (i10 == 6) {
            return R.string.floatview_property_joystick_direction;
        }
        if (i10 == 11) {
            return R.string.floatview_property_joystick_move_fixed;
        }
        if (i10 == 500) {
            return R.string.floatview_property_cursor_control;
        }
        if (i10 == 206) {
            return R.string.floatview_property_key_motion_always_on;
        }
        if (i10 == 207) {
            return R.string.floatview_property_key_fps_lunpan;
        }
        switch (i10) {
            case 100:
                return R.string.floatview_property_key_single_click_normal_click;
            case 101:
                return R.string.floatview_property_key_single_click_continue_click;
            case 102:
                return R.string.floatview_property_key_single_click_quick_click;
            case 103:
                return R.string.floatview_property_key_single_click_pressed_click;
            case 104:
                return R.string.floatview_property_key_single_click_released_click;
            default:
                switch (i10) {
                    case 200:
                        return R.string.floatview_property_key_fps_motion_view;
                    case 201:
                        return R.string.floatview_property_key_motion_shoot;
                    case a.c.f52772h /* 202 */:
                        return R.string.floatview_property_key_assist_shoot;
                    case a.c.f52773i /* 203 */:
                        return R.string.floatview_property_key_get_off_car;
                    case a.c.f52774j /* 204 */:
                        return R.string.floatview_property_key_mouse_relation;
                    default:
                        switch (i10) {
                            case 300:
                                return v5.a.j().f() == 1 ? R.string.floatview_property_direction_relation : R.string.floatview_property_left_joystick_relation;
                            case 301:
                                return R.string.floatview_property_right_joystick_relation;
                            case 302:
                                return R.string.floatview_property_key_joystick_auto_relation;
                            case 303:
                                return R.string.floatview_property_key_moba_cancel;
                            case 304:
                                return R.string.floatview_property_key_look_map;
                            case 305:
                                return R.string.floatview_property_key_moba_attack;
                            case 306:
                                return R.string.floatview_property_key_lock_view;
                            case 307:
                                return R.string.floatview_property_key_extend_view;
                            case 308:
                                return R.string.floatview_property_key_moba_motion_view;
                            case 309:
                                return R.string.floatview_property_key_wheel_relation;
                            case 310:
                                return R.string.floatview_property_key_moba_skill_relation;
                            case 311:
                                return R.string.floatview_property_macro_key_moba_left_joystick_exclusive;
                            default:
                                switch (i10) {
                                    case 400:
                                        return R.string.floatview_property_key_slide_up;
                                    case 401:
                                        return R.string.floatview_property_key_slide_down;
                                    case 402:
                                        return R.string.floatview_property_key_slide_left;
                                    case 403:
                                        return R.string.floatview_property_key_slide_right;
                                    case a.c.C /* 404 */:
                                        return R.string.floatview_property_key_slide_left_up;
                                    case a.c.D /* 405 */:
                                        return R.string.floatview_property_key_slide_right_up;
                                    case 406:
                                        return R.string.floatview_property_key_slide_left_down;
                                    case a.c.F /* 407 */:
                                        return R.string.floatview_property_key_slide_right_down;
                                    default:
                                        switch (i10) {
                                            case 600:
                                                return R.string.floatview_property_type_macro;
                                            case 601:
                                                return R.string.floatview_property_macro_key_trigger_mode_pressed;
                                            case 602:
                                                return R.string.floatview_property_macro_key_trigger_mode_released;
                                            case 603:
                                                return R.string.floatview_property_macro_key_trigger_mode_hold;
                                            default:
                                                return R.string.key_unknown;
                                        }
                                }
                        }
                }
        }
    }

    public static String j(int i10) {
        if (i10 == 500) {
            return "32_0";
        }
        switch (i10) {
            case 100:
                return "1_0";
            case 101:
                return "1_1";
            case 102:
                return "1_7";
            case 103:
                return "1_4";
            case 104:
                return "1_5";
            default:
                switch (i10) {
                    case 200:
                        return "3_0";
                    case 201:
                        return "4_0";
                    case a.c.f52772h /* 202 */:
                        return "34_0";
                    case a.c.f52773i /* 203 */:
                        return "11_0";
                    case a.c.f52774j /* 204 */:
                        return "4_0";
                    default:
                        switch (i10) {
                            case 300:
                                return "5_0";
                            case 301:
                                return "6_0";
                            case 302:
                                return "7_0";
                            case 303:
                                return "1_2";
                            case 304:
                                return "8_0";
                            case 305:
                                return "1_3";
                            case 306:
                                return "20_0";
                            case 307:
                                return "21_0";
                            default:
                                String str = "2_0";
                                switch (i10) {
                                    default:
                                        str = "100_0";
                                        switch (i10) {
                                            case 601:
                                            case 602:
                                            case 603:
                                                break;
                                            default:
                                                return "";
                                        }
                                    case 400:
                                    case 401:
                                    case 402:
                                    case 403:
                                    case a.c.C /* 404 */:
                                    case a.c.D /* 405 */:
                                    case 406:
                                    case a.c.F /* 407 */:
                                        return str;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public static float k(float f10) {
        return (f10 * 1.0f) / 1280.0f;
    }

    public static String l(Context context, int i10) {
        return (i10 == 0 || i10 == 2) ? context.getString(R.string.floatview_key_listen_gamepad) : i10 == 1 ? context.getString(R.string.floatview_key_listen_keyboard) : "";
    }

    public static void m(Context context, String str) {
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).f(context, DataConstant.FLOAT_WINDOW_ACTION_TOAST, DataConstant.TOAST_CONTENT, str);
    }
}
