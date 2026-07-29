package x6;

import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f54891a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f54892b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Integer> f54893c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f54894d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<Integer> f54895e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Integer> f54896f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int[] f54897g = {16, 17, 18, 19, 20, 21};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int[] f54898h = {16, 17, 18, 19, 20, 21};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int[] f54899i = {16, 17, 18, 19, 20, 21, 28, 27, 24, 15};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int[] f54900j = {18, 19, 20, 21, 28, 27, 24, 15};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f54901k = {240, 4, 5, 12, 10};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int[] f54902l = {240, 4, 5, 12, 10, 14, 6, 18};

    public static int a(int i10, GamepadInfo gamepadInfo) {
        if (gamepadInfo.isConnected()) {
            int deviceType = gamepadInfo.getDeviceType();
            int i11 = 0;
            if (deviceType != 16) {
                if (deviceType == 17) {
                    if (f54891a.size() == 0) {
                        int[] iArr = f54897g;
                        int length = iArr.length;
                        while (i11 < length) {
                            f54891a.add(Integer.valueOf(iArr[i11]));
                            i11++;
                        }
                    }
                    if (f54891a.contains(Integer.valueOf(i10))) {
                        return -1;
                    }
                    return i10;
                }
                if (deviceType == 32) {
                    if (f54893c.size() == 0) {
                        int[] iArr2 = f54899i;
                        int length2 = iArr2.length;
                        while (i11 < length2) {
                            f54893c.add(Integer.valueOf(iArr2[i11]));
                            i11++;
                        }
                    }
                    if (f54893c.contains(Integer.valueOf(i10))) {
                        return -1;
                    }
                    return i10;
                }
                if (deviceType == 33) {
                    if (f54894d.size() == 0) {
                        int[] iArr3 = f54900j;
                        int length3 = iArr3.length;
                        while (i11 < length3) {
                            f54894d.add(Integer.valueOf(iArr3[i11]));
                            i11++;
                        }
                    }
                    if (f54894d.contains(Integer.valueOf(i10))) {
                        return -1;
                    }
                    return i10;
                }
                switch (deviceType) {
                    case 64:
                    case 65:
                    case 66:
                        if (f54895e.size() == 0) {
                            int[] iArr4 = f54901k;
                            int length4 = iArr4.length;
                            while (i11 < length4) {
                                f54895e.add(Integer.valueOf(iArr4[i11]));
                                i11++;
                            }
                        }
                        if (f54895e.contains(Integer.valueOf(i10))) {
                            return i10;
                        }
                        return -1;
                    case 67:
                        if (f54896f.size() == 0) {
                            int[] iArr5 = f54902l;
                            int length5 = iArr5.length;
                            while (i11 < length5) {
                                f54896f.add(Integer.valueOf(iArr5[i11]));
                                i11++;
                            }
                        }
                        if (f54896f.contains(Integer.valueOf(i10))) {
                            return i10;
                        }
                        return -1;
                    default:
                        return i10;
                }
            }
            if (f54892b.size() == 0) {
                int[] iArr6 = f54898h;
                int length6 = iArr6.length;
                while (i11 < length6) {
                    f54892b.add(Integer.valueOf(iArr6[i11]));
                    i11++;
                }
            }
            if (f54892b.contains(Integer.valueOf(i10))) {
                return -1;
            }
        }
        return i10;
    }

    public static int b(int i10) {
        switch (i10) {
        }
        return R.drawable.cjzc_action_icon_28;
    }

    public static String c(int i10) {
        switch (i10) {
        }
        return "疾跑";
    }

    public static int d(int i10, GamepadInfo gamepadInfo) {
        int iE = e(i10, gamepadInfo);
        if (gamepadInfo.isConnected()) {
            int deviceType = gamepadInfo.getDeviceType();
            int i11 = 0;
            if (deviceType != 16) {
                if (deviceType == 17) {
                    if (f54891a.size() == 0) {
                        int[] iArr = f54897g;
                        int length = iArr.length;
                        while (i11 < length) {
                            f54891a.add(Integer.valueOf(iArr[i11]));
                            i11++;
                        }
                    }
                    if (f54891a.contains(Integer.valueOf(iE))) {
                        return -1;
                    }
                    return iE;
                }
                if (deviceType == 32) {
                    if (f54893c.size() == 0) {
                        int[] iArr2 = f54899i;
                        int length2 = iArr2.length;
                        while (i11 < length2) {
                            f54893c.add(Integer.valueOf(iArr2[i11]));
                            i11++;
                        }
                    }
                    if (f54893c.contains(Integer.valueOf(iE))) {
                        return -1;
                    }
                    return iE;
                }
                if (deviceType == 33) {
                    if (f54894d.size() == 0) {
                        int[] iArr3 = f54900j;
                        int length3 = iArr3.length;
                        while (i11 < length3) {
                            f54894d.add(Integer.valueOf(iArr3[i11]));
                            i11++;
                        }
                    }
                    if (f54894d.contains(Integer.valueOf(iE))) {
                        return -1;
                    }
                    return iE;
                }
                switch (deviceType) {
                    case 64:
                    case 65:
                    case 66:
                        if (f54895e.size() == 0) {
                            int[] iArr4 = f54901k;
                            int length4 = iArr4.length;
                            while (i11 < length4) {
                                f54895e.add(Integer.valueOf(iArr4[i11]));
                                i11++;
                            }
                        }
                        if (f54895e.contains(Integer.valueOf(iE))) {
                            return iE;
                        }
                        return -1;
                    case 67:
                        if (f54896f.size() == 0) {
                            int[] iArr5 = f54902l;
                            int length5 = iArr5.length;
                            while (i11 < length5) {
                                f54896f.add(Integer.valueOf(iArr5[i11]));
                                i11++;
                            }
                        }
                        if (f54896f.contains(Integer.valueOf(iE))) {
                            return iE;
                        }
                        return -1;
                    default:
                        return iE;
                }
            }
            if (f54892b.size() == 0) {
                int[] iArr6 = f54898h;
                int length6 = iArr6.length;
                while (i11 < length6) {
                    f54892b.add(Integer.valueOf(iArr6[i11]));
                    i11++;
                }
            }
            if (f54892b.contains(Integer.valueOf(iE))) {
                return -1;
            }
        }
        return iE;
    }

    public static int e(int i10, GamepadInfo gamepadInfo) {
        switch (i10) {
            case 0:
                return !gamepadInfo.isSupportMotion() ? -1 : 12;
            case 1:
                return 240;
            case 2:
                return 10;
            case 3:
                return 5;
            case 4:
                return 7;
            case 5:
                return 0;
            case 6:
                return 241;
            case 7:
                return 11;
            case 8:
                return gamepadInfo.isGamepadHalf() ? 12 : 13;
            case 9:
                return 8;
            case 10:
                return 2;
            case 11:
                return 9;
            case 12:
            case 32:
            case 35:
            default:
                return -1;
            case 13:
                return 3;
            case 14:
                return 1;
            case 15:
                return 8;
            case 16:
                return gamepadInfo.isGamepadHalf() ? -1 : 13;
            case 17:
                return 0;
            case 18:
                return 28;
            case 19:
                return 24;
            case 20:
                return 10;
            case 21:
                return 11;
            case 22:
                return 0;
            case 23:
                return 2;
            case 24:
                return 3;
            case 25:
                return 1;
            case 26:
                return 10;
            case 27:
                return 11;
            case 28:
                return 4;
            case 29:
                return 7;
            case 30:
                return 13;
            case 31:
            case 33:
            case 34:
                return 4;
            case 36:
                return 19;
            case 37:
                return 18;
            case 38:
                return 4;
            case 39:
                return 15;
            case 40:
                return 27;
            case 41:
                return 6;
            case 42:
            case 43:
                return 4;
        }
    }

    public static int f(int i10) {
        switch (i10) {
            case 1:
                return 240;
            case 2:
                return 44;
            case 3:
                return 6;
            case 4:
                return 29;
            case 5:
                return 46;
            case 6:
                return 116;
            case 7:
                return 101;
            case 8:
                return 100;
            case 9:
                return 21;
            case 10:
                return 5;
            case 11:
                return 16;
            case 12:
                return 41;
            case 13:
                return 30;
            case 14:
                return 31;
            case 15:
                return 101;
            case 16:
                return 9;
            case 17:
                return 46;
            case 18:
                return 10;
            case 19:
                return 53;
            case 20:
                return 44;
            case 21:
                return 6;
            case 22:
                return 26;
            case 23:
                return 22;
            case 24:
                return 4;
            case 25:
                return 7;
            case 26:
                return 109;
            case 27:
                return 44;
            case 28:
                return 9;
            case 29:
                return 29;
            case 30:
                return 108;
            case 31:
                return 100;
            case 32:
            default:
                return -1;
            case 33:
            case 34:
                return 9;
            case 35:
                return 32;
            case 36:
                return 20;
            case 37:
                return 8;
            case 38:
                return 28;
            case 39:
                return 111;
            case 40:
                return 43;
            case 41:
                return 28;
            case 42:
            case 43:
                return 9;
        }
    }

    public static int g(int i10) {
        if (i10 == 24) {
            return R.drawable.flydigi_gp_key_menu;
        }
        if (i10 == 27) {
            return R.drawable.flydigi_gp_key_home;
        }
        if (i10 == 28) {
            return R.drawable.flydigi_gp_key_back;
        }
        if (i10 == 240) {
            return R.drawable.flydigi_gp_key_leftstick;
        }
        if (i10 == 241) {
            return R.drawable.flydigi_gp_key_rightstick;
        }
        switch (i10) {
            case 0:
                return R.drawable.flydigi_gp_key_up;
            case 1:
                return R.drawable.flydigi_gp_key_right;
            case 2:
                return R.drawable.flydigi_gp_key_down;
            case 3:
                return R.drawable.flydigi_gp_key_left;
            case 4:
                return R.drawable.flydigi_gp_key_a;
            case 5:
                return R.drawable.flydigi_gp_key_b;
            case 6:
                return R.drawable.flydigi_gp_key_select;
            case 7:
                return R.drawable.flydigi_gp_key_x;
            case 8:
                return R.drawable.flydigi_gp_key_y;
            case 9:
                return R.drawable.flydigi_gp_key_start;
            case 10:
                return R.drawable.flydigi_gp_key_lb;
            case 11:
                return R.drawable.flydigi_gp_key_rb;
            case 12:
                return R.drawable.flydigi_gp_key_lt;
            case 13:
                return R.drawable.flydigi_gp_key_rt;
            case 14:
                return R.drawable.flydigi_gp_key_l3;
            case 15:
                return R.drawable.flydigi_gp_key_r3;
            case 16:
                return R.drawable.flydigi_gp_key_c;
            case 17:
                return R.drawable.flydigi_gp_key_z;
            case 18:
                return R.drawable.flydigi_gp_key_m1;
            case 19:
                return R.drawable.flydigi_gp_key_m2;
            case 20:
                return R.drawable.flydigi_gp_key_m3;
            case 21:
                return R.drawable.flydigi_gp_key_m4;
            default:
                return R.drawable.flydigi_gp_key_null;
        }
    }

    public static int h(int i10) {
        if (i10 == 116) {
            return R.drawable.flydigi_km_key_mouse;
        }
        if (i10 == 240) {
            return R.drawable.flydigi_km_key_asdw;
        }
        switch (i10) {
            case 4:
                return R.drawable.flydigi_km_key_a;
            case 5:
                return R.drawable.flydigi_km_key_b;
            case 6:
                return R.drawable.flydigi_km_key_c;
            case 7:
                return R.drawable.flydigi_km_key_d;
            case 8:
                return R.drawable.flydigi_km_key_e;
            case 9:
                return R.drawable.flydigi_km_key_f;
            case 10:
                return R.drawable.flydigi_km_key_g;
            case 11:
                return R.drawable.flydigi_km_key_h;
            case 12:
                return R.drawable.flydigi_km_key_i;
            case 13:
                return R.drawable.flydigi_km_key_j;
            case 14:
                return R.drawable.flydigi_km_key_k;
            case 15:
                return R.drawable.flydigi_km_key_l;
            case 16:
                return R.drawable.flydigi_km_key_m;
            case 17:
                return R.drawable.flydigi_km_key_n;
            case 18:
                return R.drawable.flydigi_km_key_o;
            case 19:
                return R.drawable.flydigi_km_key_p;
            case 20:
                return R.drawable.flydigi_km_key_q;
            case 21:
                return R.drawable.flydigi_km_key_r;
            case 22:
                return R.drawable.flydigi_km_key_s;
            case 23:
                return R.drawable.flydigi_km_key_t;
            case 24:
                return R.drawable.flydigi_km_key_u;
            case 25:
                return R.drawable.flydigi_km_key_v;
            case 26:
                return R.drawable.flydigi_km_key_w;
            case 27:
                return R.drawable.flydigi_km_key_x;
            case 28:
                return R.drawable.flydigi_km_key_y;
            case 29:
                return R.drawable.flydigi_km_key_z;
            case 30:
                return R.drawable.flydigi_km_key_1;
            case 31:
                return R.drawable.flydigi_km_key_2;
            case 32:
                return R.drawable.flydigi_km_key_3;
            case 33:
                return R.drawable.flydigi_km_key_4;
            case 34:
                return R.drawable.flydigi_km_key_5;
            case 35:
                return R.drawable.flydigi_km_key_6;
            case 36:
                return R.drawable.flydigi_km_key_7;
            case 37:
                return R.drawable.flydigi_km_key_8;
            case 38:
                return R.drawable.flydigi_km_key_9;
            case 39:
                return R.drawable.flydigi_km_key_0;
            case 40:
                return R.drawable.flydigi_km_key_enter;
            case 41:
                return R.drawable.flydigi_km_key_esc;
            case 42:
                return R.drawable.flydigi_km_key_backspace;
            case 43:
                return R.drawable.flydigi_km_key_tab;
            case 44:
                return R.drawable.flydigi_km_key_space;
            case 45:
                return R.drawable.flydigi_km_key_minussign;
            case 46:
                return R.drawable.flydigi_km_key_plus;
            case 47:
                return R.drawable.flydigi_km_key_leftbrackets;
            case 48:
                return R.drawable.flydigi_km_key_rightbrackets;
            case 49:
                return R.drawable.flydigi_km_key_backslash;
            case 50:
                return R.drawable.flymapping_front_def;
            case 51:
                return R.drawable.flydigi_km_key_semicolon;
            case 52:
                return R.drawable.flydigi_km_key_quotationmarks;
            case 53:
                return R.drawable.flydigi_km_key_graveaccent;
            case 54:
                return R.drawable.flydigi_km_key_comma;
            case 55:
                return R.drawable.flydigi_km_key_fullstop;
            case 56:
                return R.drawable.flydigi_km_key_questionmark;
            case 57:
                return R.drawable.flydigi_km_key_capslock;
            case 58:
                return R.drawable.flydigi_km_key_f1;
            case 59:
                return R.drawable.flydigi_km_key_f2;
            case 60:
                return R.drawable.flydigi_km_key_f3;
            case 61:
                return R.drawable.flydigi_km_key_f4;
            case 62:
                return R.drawable.flydigi_km_key_f5;
            case 63:
                return R.drawable.flydigi_km_key_f6;
            case 64:
                return R.drawable.flydigi_km_key_f7;
            case 65:
                return R.drawable.flydigi_km_key_f8;
            case 66:
                return R.drawable.flydigi_km_key_f9;
            case 67:
                return R.drawable.flydigi_km_key_f10;
            case 68:
                return R.drawable.flydigi_km_key_f11;
            case 69:
                return R.drawable.flydigi_km_key_f12;
            case 70:
                return R.drawable.flydigi_km_key_prtscrsysrq;
            case 71:
                return R.drawable.flydigi_km_key_scrolllock;
            case 72:
                return R.drawable.flydigi_km_key_pausebreak;
            case 73:
                return R.drawable.flydigi_km_key_insert;
            case 74:
                return R.drawable.flydigi_km_key_home;
            case 75:
                return R.drawable.flydigi_km_key_pageup;
            case 76:
                return R.drawable.flydigi_km_key_delete;
            case 77:
                return R.drawable.flydigi_km_key_end;
            case 78:
                return R.drawable.flydigi_km_key_pagedown;
            case 79:
                return R.drawable.flydigi_km_key_right;
            case 80:
                return R.drawable.flydigi_km_key_left;
            case 81:
                return R.drawable.flydigi_km_key_down;
            case 82:
                return R.drawable.flydigi_km_key_up;
            case 83:
                return R.drawable.flydigi_km_key_numlock;
            case 84:
                return R.drawable.flydigi_km_key_numforwardslash;
            case 85:
                return R.drawable.flydigi_km_key_numasterisk;
            case 86:
                return R.drawable.flydigi_km_key_numminussign;
            case 87:
                return R.drawable.flydigi_km_key_numplus;
            case 88:
                return R.drawable.flydigi_km_key_numenter;
            case 89:
                return R.drawable.flydigi_km_key_num1;
            case 90:
                return R.drawable.flydigi_km_key_num2;
            case 91:
                return R.drawable.flydigi_km_key_num3;
            case 92:
                return R.drawable.flydigi_km_key_num4;
            case 93:
                return R.drawable.flydigi_km_key_num5;
            case 94:
                return R.drawable.flydigi_km_key_num6;
            case 95:
                return R.drawable.flydigi_km_key_num7;
            case 96:
                return R.drawable.flydigi_km_key_num8;
            case 97:
                return R.drawable.flydigi_km_key_num9;
            case 98:
                return R.drawable.flydigi_km_key_num0;
            case 99:
                return R.drawable.flydigi_km_key_numdel;
            case 100:
                return R.drawable.flydigi_km_key_leftmouse;
            case 101:
                return R.drawable.flydigi_km_key_rightmouse;
            case 102:
                return R.drawable.flydigi_km_key_middlemouse;
            case 103:
                return R.drawable.flydigi_km_key_mousebackward;
            case 104:
                return R.drawable.flydigi_km_key_mouseforward;
            case 105:
                return R.drawable.flydigi_km_key_middleupmouse;
            case 106:
                return R.drawable.flydigi_km_key_middledownmouse;
            default:
                switch (i10) {
                    case 108:
                        return R.drawable.flydigi_km_key_shift;
                    case 109:
                        return R.drawable.flydigi_km_key_ctrl;
                    case 110:
                        return R.drawable.flydigi_km_key_win;
                    case 111:
                        return R.drawable.flydigi_km_key_alt;
                    default:
                        return R.drawable.flydigi_gp_key_null;
                }
        }
    }
}
