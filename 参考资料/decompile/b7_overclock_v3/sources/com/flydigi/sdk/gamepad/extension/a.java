package com.flydigi.sdk.gamepad.extension;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import h0.d;
import hk.m;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import l9.c;
import m9.h;
import m9.t;
import o9.b;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f16344a = new a();

    @m
    public static final boolean b(@k GamepadInfo deviceInfo, int i10, int i11, int i12) {
        f0.p(deviceInfo, "deviceInfo");
        if (!deviceInfo.isGamepadKeyboard()) {
            switch (i10) {
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!deviceInfo.isFlashplayMode()) {
                        return true;
                    }
                    String firmwareVersion = deviceInfo.getFirmwareVersion();
                    Objects.requireNonNull(firmwareVersion);
                    return c.b(m9.k.f40828n, firmwareVersion);
                default:
                    switch (i10) {
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                            if (!deviceInfo.isFlashplayMode()) {
                                return true;
                            }
                            String firmwareVersion2 = deviceInfo.getFirmwareVersion();
                            Objects.requireNonNull(firmwareVersion2);
                            return c.b(m9.k.f40830p, firmwareVersion2);
                        default:
                            switch (i10) {
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                    if (deviceInfo.isSupportLunpan()) {
                                        if (!deviceInfo.isFlashplayMode()) {
                                            return true;
                                        }
                                        String firmwareVersion3 = deviceInfo.getFirmwareVersion();
                                        Objects.requireNonNull(firmwareVersion3);
                                        if (c.b(m9.k.f40830p, firmwareVersion3)) {
                                            return true;
                                        }
                                    }
                                    return false;
                            }
                    }
            }
        }
        return m9.m.a(i10) ? f16344a.a(deviceInfo, i10, i11, i12) : deviceInfo.containKey(i10);
    }

    @m
    public static final int d(int i10, int i11) {
        if ((i10 == 12 && i11 == 4) || (i10 == 4 && i11 == 12)) {
            return 21;
        }
        if ((i10 == 12 && i11 == 5) || (i10 == 5 && i11 == 12)) {
            return 22;
        }
        if ((i10 == 12 && i11 == 7) || (i10 == 7 && i11 == 12)) {
            return 23;
        }
        if ((i10 == 12 && i11 == 8) || (i10 == 8 && i11 == 12)) {
            return 24;
        }
        if ((i10 == 12 && i11 == 11) || (i10 == 11 && i11 == 12)) {
            return 25;
        }
        if ((i10 == 12 && i11 == 13) || (i10 == 13 && i11 == 12)) {
            return 26;
        }
        if ((i10 == 12 && i11 == 16) || (i10 == 16 && i11 == 12)) {
            return 27;
        }
        if ((i10 == 12 && i11 == 17) || (i10 == 17 && i11 == 12)) {
            return 28;
        }
        if ((i10 == 10 && i11 == 4) || (i10 == 4 && i11 == 10)) {
            return 29;
        }
        if ((i10 == 10 && i11 == 5) || (i10 == 5 && i11 == 10)) {
            return 30;
        }
        if ((i10 == 10 && i11 == 7) || (i10 == 7 && i11 == 10)) {
            return 31;
        }
        if ((i10 == 10 && i11 == 8) || (i10 == 8 && i11 == 10)) {
            return 32;
        }
        if ((i10 == 10 && i11 == 11) || (i10 == 11 && i11 == 10)) {
            return 33;
        }
        if ((i10 == 10 && i11 == 13) || (i10 == 13 && i11 == 10)) {
            return 34;
        }
        if ((i10 == 10 && i11 == 16) || (i10 == 16 && i11 == 10)) {
            return 35;
        }
        if ((i10 == 10 && i11 == 17) || (i10 == 17 && i11 == 10)) {
            return 36;
        }
        if ((i10 == 18 && i11 == 4) || (i10 == 4 && i11 == 18)) {
            return 44;
        }
        if ((i10 == 18 && i11 == 5) || (i10 == 5 && i11 == 18)) {
            return 45;
        }
        if ((i10 == 18 && i11 == 7) || (i10 == 7 && i11 == 18)) {
            return 46;
        }
        if ((i10 == 18 && i11 == 8) || (i10 == 8 && i11 == 18)) {
            return 47;
        }
        if ((i10 == 19 && i11 == 4) || (i10 == 4 && i11 == 19)) {
            return 48;
        }
        if ((i10 == 19 && i11 == 5) || (i10 == 5 && i11 == 19)) {
            return 49;
        }
        if ((i10 == 19 && i11 == 7) || (i10 == 7 && i11 == 19)) {
            return 50;
        }
        return ((i10 == 19 && i11 == 8) || (i10 == 8 && i11 == 19)) ? 51 : 256;
    }

    @m
    public static final int e(int i10) {
        switch (i10) {
            case 0:
                return 30;
            case 1:
                return 33;
            case 2:
                return 31;
            case 3:
                return 32;
            case 4:
                return 20;
            case 5:
                return 8;
            case 6:
                return 59;
            case 7:
                return 21;
            case 8:
                return 23;
            case 9:
                return 111;
            case 10:
                return 100;
            case 11:
                return 101;
            case 12:
                return 108;
            case 13:
                return 44;
            case 14:
                return 58;
            case 15:
                return 109;
            default:
                switch (i10) {
                    case 18:
                        return 6;
                    case 19:
                        return 29;
                    case 20:
                        return 43;
                    default:
                        switch (i10) {
                            case 37:
                                return 105;
                            case 38:
                                return 106;
                            case 39:
                                return 9;
                            case 40:
                                return 10;
                            case 41:
                                return 27;
                            case 42:
                                return 25;
                            default:
                                return -1;
                        }
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @m
    public static final int f(@l String str, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                if (str != null) {
                    int iHashCode = str.hashCode();
                    switch (iHashCode) {
                        case -2130463047:
                            if (str.equals("INSERT")) {
                                return 73;
                            }
                            break;
                        case -2074195076:
                            if (str.equals("PRTSCRSYSRQ")) {
                                return 70;
                            }
                            break;
                        case -1942422166:
                            if (str.equals("PAGEUP")) {
                                return 75;
                            }
                            break;
                        case -1707125105:
                            if (str.equals("MOUSE_MIDDLE")) {
                                return 102;
                            }
                            break;
                        case -1421726356:
                            if (str.equals("MOUSE_WHEELM")) {
                                return 106;
                            }
                            break;
                        case -1421726353:
                            if (str.equals("MOUSE_WHEELP")) {
                                return 105;
                            }
                            break;
                        case -1281670254:
                            if (str.equals("NUM_DEL")) {
                                return 99;
                            }
                            break;
                        case -1076824476:
                            if (str.equals("NUM_LOCK")) {
                                return 83;
                            }
                            break;
                        case -1076707629:
                            if (str.equals("NUM_PLUS")) {
                                return 87;
                            }
                            break;
                        case -900755603:
                            if (str.equals("RIGHTARROW")) {
                                return 79;
                            }
                            break;
                        case -893275409:
                            if (str.equals("GRAVEACCENT")) {
                                return 53;
                            }
                            break;
                        case -392696227:
                            if (str.equals("MOUSE_BACKWARD")) {
                                return 103;
                            }
                            break;
                        case -205720441:
                            if (str.equals("DOWNARROW")) {
                                return 81;
                            }
                            break;
                        case -154983210:
                            if (str.equals("BACKSLASH")) {
                                return 49;
                            }
                            break;
                        case -154864545:
                            if (str.equals("BACKSPACE")) {
                                return 42;
                            }
                            break;
                        case -50447934:
                            if (str.equals("MOUSE_RIGHT")) {
                                return 101;
                            }
                            break;
                        case 64905:
                            if (str.equals("ALT")) {
                                return 111;
                            }
                            break;
                        case 68795:
                            if (str.equals("END")) {
                                return 77;
                            }
                            break;
                        case 82805:
                            if (str.equals("TAB")) {
                                return 43;
                            }
                            break;
                        case 85948:
                            if (str.equals("WIN")) {
                                return 110;
                            }
                            break;
                        case 2079339:
                            if (str.equals("CTRL")) {
                                return 109;
                            }
                            break;
                        case 2223327:
                            if (str.equals("HOME")) {
                                return 74;
                            }
                            break;
                        case 2459034:
                            if (str.equals("PLUS")) {
                                return 46;
                            }
                            break;
                        case 2656923:
                            if (str.equals("WASD")) {
                                return 240;
                            }
                            break;
                        case 64305845:
                            if (str.equals("COMMA")) {
                                return 54;
                            }
                            break;
                        case 66129592:
                            if (str.equals("ENTER")) {
                                return 40;
                            }
                            break;
                        case 73363536:
                            if (str.equals("MINUS")) {
                                return 45;
                            }
                            break;
                        case 73548933:
                            if (str.equals("MOUSE")) {
                                return 116;
                            }
                            break;
                        case 74465803:
                            if (str.equals("NONUS")) {
                                return 50;
                            }
                            break;
                        case 78869602:
                            if (str.equals("SHIFT")) {
                                return 108;
                            }
                            break;
                        case 79100134:
                            if (str.equals("SPACE")) {
                                return 44;
                            }
                            break;
                        case 158693842:
                            if (str.equals("LEFTBRACKETS")) {
                                return 47;
                            }
                            break;
                        case 235393090:
                            if (str.equals("LEFTARROW")) {
                                return 80;
                            }
                            break;
                        case 440625353:
                            if (str.equals("PAUSEBREAK")) {
                                return 72;
                            }
                            break;
                        case 481286702:
                            if (str.equals("UPARROW")) {
                                return 82;
                            }
                            break;
                        case 540393236:
                            if (str.equals("VIRTUAL_CLICK")) {
                                return 117;
                            }
                            break;
                        case 552102264:
                            if (str.equals("SCROLLLOCK")) {
                                return 71;
                            }
                            break;
                        case 731699084:
                            if (str.equals("CAPSLOCK")) {
                                return 57;
                            }
                            break;
                        case 971701407:
                            if (str.equals("NUM_ENTER")) {
                                return 88;
                            }
                            break;
                        case 978935351:
                            if (str.equals("NUM_MINUS")) {
                                return 86;
                            }
                            break;
                        case 1181398251:
                            if (str.equals("MOUSE_FORWARD")) {
                                return 104;
                            }
                            break;
                        case 1491909332:
                            if (str.equals("NUM_STARKEY")) {
                                return 85;
                            }
                            break;
                        case 1522210689:
                            if (str.equals("MOUSE_LEFT")) {
                                return 100;
                            }
                            break;
                        case 1642567601:
                            if (str.equals("PAGEDOWN")) {
                                return 78;
                            }
                            break;
                        case 1790240455:
                            if (str.equals("RIGHTBRACKETS")) {
                                return 48;
                            }
                            break;
                        case 2012838315:
                            if (str.equals("DELETE")) {
                                return 76;
                            }
                            break;
                        case 2054124673:
                            if (str.equals("ESCAPE")) {
                                return 41;
                            }
                            break;
                        case 2072503441:
                            if (str.equals("SEMICOLON")) {
                                return 51;
                            }
                            break;
                        case 2084900409:
                            if (str.equals("QUOTATIONMARK")) {
                                return 52;
                            }
                            break;
                        case 2100910609:
                            if (str.equals("NUM_FORWARDSLASH")) {
                                return 84;
                            }
                            break;
                        case 2114599697:
                            if (str.equals("FULLSTOP")) {
                                return 55;
                            }
                            break;
                        case 2145896371:
                            if (str.equals("QUESTIONMARK")) {
                                return 56;
                            }
                            break;
                        default:
                            switch (iHashCode) {
                                case 65:
                                    if (str.equals(i1.a.W4)) {
                                        return 4;
                                    }
                                    break;
                                case 66:
                                    if (str.equals("B")) {
                                        return 5;
                                    }
                                    break;
                                case 67:
                                    if (str.equals("C")) {
                                        return 6;
                                    }
                                    break;
                                case 68:
                                    if (str.equals("D")) {
                                        return 7;
                                    }
                                    break;
                                case 69:
                                    if (str.equals(i1.a.S4)) {
                                        return 8;
                                    }
                                    break;
                                case 70:
                                    if (str.equals("F")) {
                                        return 9;
                                    }
                                    break;
                                case 71:
                                    if (str.equals("G")) {
                                        return 10;
                                    }
                                    break;
                                case 72:
                                    if (str.equals("H")) {
                                        return 11;
                                    }
                                    break;
                                case 73:
                                    if (str.equals("I")) {
                                        return 12;
                                    }
                                    break;
                                case 74:
                                    if (str.equals("J")) {
                                        return 13;
                                    }
                                    break;
                                case 75:
                                    if (str.equals("K")) {
                                        return 14;
                                    }
                                    break;
                                case 76:
                                    if (str.equals("L")) {
                                        return 15;
                                    }
                                    break;
                                case 77:
                                    if (str.equals("M")) {
                                        return 16;
                                    }
                                    break;
                                case 78:
                                    if (str.equals("N")) {
                                        return 17;
                                    }
                                    break;
                                case 79:
                                    if (str.equals("O")) {
                                        return 18;
                                    }
                                    break;
                                case 80:
                                    if (str.equals("P")) {
                                        return 19;
                                    }
                                    break;
                                case 81:
                                    if (str.equals("Q")) {
                                        return 20;
                                    }
                                    break;
                                case 82:
                                    if (str.equals("R")) {
                                        return 21;
                                    }
                                    break;
                                case 83:
                                    if (str.equals(i1.a.R4)) {
                                        return 22;
                                    }
                                    break;
                                case 84:
                                    if (str.equals(i1.a.f31577d5)) {
                                        return 23;
                                    }
                                    break;
                                case 85:
                                    if (str.equals("U")) {
                                        return 24;
                                    }
                                    break;
                                case 86:
                                    if (str.equals(i1.a.X4)) {
                                        return 25;
                                    }
                                    break;
                                case 87:
                                    if (str.equals(i1.a.T4)) {
                                        return 26;
                                    }
                                    break;
                                case 88:
                                    if (str.equals("X")) {
                                        return 27;
                                    }
                                    break;
                                case 89:
                                    if (str.equals("Y")) {
                                        return 28;
                                    }
                                    break;
                                case 90:
                                    if (str.equals("Z")) {
                                        return 29;
                                    }
                                    break;
                                default:
                                    switch (iHashCode) {
                                        case 2219:
                                            if (str.equals("F1")) {
                                                return 58;
                                            }
                                            break;
                                        case 2220:
                                            if (str.equals("F2")) {
                                                return 59;
                                            }
                                            break;
                                        case 2221:
                                            if (str.equals("F3")) {
                                                return 60;
                                            }
                                            break;
                                        case 2222:
                                            if (str.equals("F4")) {
                                                return 61;
                                            }
                                            break;
                                        case 2223:
                                            if (str.equals("F5")) {
                                                return 62;
                                            }
                                            break;
                                        case 2224:
                                            if (str.equals("F6")) {
                                                return 63;
                                            }
                                            break;
                                        case 2225:
                                            if (str.equals("F7")) {
                                                return 64;
                                            }
                                            break;
                                        case 2226:
                                            if (str.equals("F8")) {
                                                return 65;
                                            }
                                            break;
                                        case 2227:
                                            if (str.equals("F9")) {
                                                return 66;
                                            }
                                            break;
                                        default:
                                            switch (iHashCode) {
                                                case 2466:
                                                    if (str.equals("N0")) {
                                                        return 39;
                                                    }
                                                    break;
                                                case 2467:
                                                    if (str.equals("N1")) {
                                                        return 30;
                                                    }
                                                    break;
                                                case 2468:
                                                    if (str.equals("N2")) {
                                                        return 31;
                                                    }
                                                    break;
                                                case 2469:
                                                    if (str.equals("N3")) {
                                                        return 32;
                                                    }
                                                    break;
                                                case 2470:
                                                    if (str.equals("N4")) {
                                                        return 33;
                                                    }
                                                    break;
                                                case 2471:
                                                    if (str.equals("N5")) {
                                                        return 34;
                                                    }
                                                    break;
                                                case 2472:
                                                    if (str.equals("N6")) {
                                                        return 35;
                                                    }
                                                    break;
                                                case 2473:
                                                    if (str.equals("N7")) {
                                                        return 36;
                                                    }
                                                    break;
                                                case 2474:
                                                    if (str.equals("N8")) {
                                                        return 37;
                                                    }
                                                    break;
                                                case 2475:
                                                    if (str.equals("N9")) {
                                                        return 38;
                                                    }
                                                    break;
                                                default:
                                                    switch (iHashCode) {
                                                        case 68837:
                                                            if (str.equals("F10")) {
                                                                return 67;
                                                            }
                                                            break;
                                                        case 68838:
                                                            if (str.equals("F11")) {
                                                                return 68;
                                                            }
                                                            break;
                                                        case 68839:
                                                            if (str.equals("F12")) {
                                                                return 69;
                                                            }
                                                            break;
                                                        default:
                                                            switch (iHashCode) {
                                                                case 74643863:
                                                                    if (str.equals("NUM_0")) {
                                                                        return 98;
                                                                    }
                                                                    break;
                                                                case 74643864:
                                                                    if (str.equals("NUM_1")) {
                                                                        return 89;
                                                                    }
                                                                    break;
                                                                case 74643865:
                                                                    if (str.equals("NUM_2")) {
                                                                        return 90;
                                                                    }
                                                                    break;
                                                                case 74643866:
                                                                    if (str.equals("NUM_3")) {
                                                                        return 91;
                                                                    }
                                                                    break;
                                                                case 74643867:
                                                                    if (str.equals("NUM_4")) {
                                                                        return 92;
                                                                    }
                                                                    break;
                                                                case 74643868:
                                                                    if (str.equals("NUM_5")) {
                                                                        return 93;
                                                                    }
                                                                    break;
                                                                case 74643869:
                                                                    if (str.equals("NUM_6")) {
                                                                        return 94;
                                                                    }
                                                                    break;
                                                                case 74643870:
                                                                    if (str.equals("NUM_7")) {
                                                                        return 95;
                                                                    }
                                                                    break;
                                                                case 74643871:
                                                                    if (str.equals("NUM_8")) {
                                                                        return 96;
                                                                    }
                                                                    break;
                                                                case 74643872:
                                                                    if (str.equals("NUM_9")) {
                                                                        return 97;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                }
                return -1;
            }
            if (i10 != 2) {
                return -1;
            }
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -2097425200:
                    if (!str.equals("JSLEFT")) {
                    }
                    break;
                case -1852692228:
                    if (!str.equals("SELECT")) {
                    }
                    break;
                case -1821016746:
                    if (!str.equals("THUMBL")) {
                    }
                    break;
                case -1821016740:
                    if (!str.equals("THUMBR")) {
                    }
                    break;
                case -1753859974:
                    if (!str.equals("JS_LEFT_RIGHT")) {
                    }
                    break;
                case -729916538:
                    if (!str.equals("JS_RIGHT")) {
                    }
                    break;
                case -590010797:
                    if (!str.equals("JSRIGHT")) {
                    }
                    break;
                case -585425006:
                    if (!str.equals("JSWHEEL")) {
                    }
                    break;
                case -578145832:
                    if (!str.equals("JS_DOWN")) {
                    }
                    break;
                case -577917635:
                    if (!str.equals("JS_LEFT")) {
                    }
                    break;
                case 65:
                    if (!str.equals(i1.a.W4)) {
                    }
                    break;
                case 66:
                    if (!str.equals("B")) {
                    }
                    break;
                case 67:
                    if (!str.equals("C")) {
                    }
                    break;
                case 88:
                    if (!str.equals("X")) {
                    }
                    break;
                case 89:
                    if (!str.equals("Y")) {
                    }
                    break;
                case 90:
                    if (!str.equals("Z")) {
                    }
                    break;
                case 2407:
                    if (!str.equals("L3")) {
                    }
                    break;
                case 2422:
                    if (!str.equals(ze.k.f58516r)) {
                    }
                    break;
                case 2436:
                    if (!str.equals("M1")) {
                    }
                    break;
                case 2437:
                    if (!str.equals("M2")) {
                    }
                    break;
                case 2438:
                    if (!str.equals("M3")) {
                    }
                    break;
                case 2439:
                    if (!str.equals("M4")) {
                    }
                    break;
                case 2440:
                    if (!str.equals("LT")) {
                        if (!str.equals("M5")) {
                        }
                    }
                    break;
                case 2441:
                    if (!str.equals("M6")) {
                    }
                    break;
                case 2593:
                    if (!str.equals("R3")) {
                    }
                    break;
                case 2608:
                    if (!str.equals("RB")) {
                    }
                    break;
                case 2626:
                    if (!str.equals("RT")) {
                    }
                    break;
                case 2715:
                    if (!str.equals("UP")) {
                    }
                    break;
                case 75147:
                    if (!str.equals("LBA")) {
                    }
                    break;
                case 75148:
                    if (!str.equals("LBB")) {
                    }
                    break;
                case 75149:
                    if (!str.equals("LBC")) {
                    }
                    break;
                case 75170:
                    if (!str.equals("LBX")) {
                    }
                    break;
                case 75171:
                    if (!str.equals("LBY")) {
                    }
                    break;
                case 75172:
                    if (!str.equals("LBZ")) {
                    }
                    break;
                case 75581:
                    if (!str.equals("M1A")) {
                    }
                    break;
                case 75582:
                    if (!str.equals("M1B")) {
                    }
                    break;
                case 75604:
                    if (!str.equals("M1X")) {
                    }
                    break;
                case 75605:
                    if (!str.equals("M1Y")) {
                    }
                    break;
                case 75612:
                    if (!str.equals("M2A")) {
                    }
                    break;
                case 75613:
                    if (!str.equals("M2B")) {
                    }
                    break;
                case 75635:
                    if (!str.equals("M2X")) {
                    }
                    break;
                case 75636:
                    if (!str.equals("M2Y")) {
                    }
                    break;
                case 75705:
                    if (!str.equals("LTA")) {
                    }
                    break;
                case 75706:
                    if (!str.equals("LTB")) {
                    }
                    break;
                case 75707:
                    if (!str.equals("LTC")) {
                    }
                    break;
                case 75728:
                    if (!str.equals("LTX")) {
                    }
                    break;
                case 75729:
                    if (!str.equals("LTY")) {
                    }
                    break;
                case 75730:
                    if (!str.equals("LTZ")) {
                    }
                    break;
                case 2030823:
                    if (!str.equals("BACK")) {
                    }
                    break;
                case 2104482:
                    if (!str.equals("DOWN")) {
                    }
                    break;
                case 2223327:
                    if (!str.equals("HOME")) {
                    }
                    break;
                case 2330150:
                    if (!str.equals("LBRB")) {
                    }
                    break;
                case 2330168:
                    if (!str.equals("LBRT")) {
                    }
                    break;
                case 2332679:
                    if (!str.equals("LEFT")) {
                    }
                    break;
                case 2347448:
                    if (!str.equals("LTRB")) {
                    }
                    break;
                case 2347466:
                    if (!str.equals("LTRT")) {
                    }
                    break;
                case 2362719:
                    if (!str.equals("MENU")) {
                    }
                    break;
                case 70907217:
                    if (!str.equals("JS_UP")) {
                    }
                    break;
                case 73548933:
                    if (!str.equals("MOUSE")) {
                    }
                    break;
                case 77974012:
                    if (!str.equals("RIGHT")) {
                    }
                    break;
                case 79219778:
                    if (!str.equals("START")) {
                    }
                    break;
                case 912844388:
                    if (!str.equals("JS_LEFT_DOWN")) {
                    }
                    break;
                case 913072585:
                    if (!str.equals("JS_LEFT_LEFT")) {
                    }
                    break;
                case 1396191820:
                    if (!str.equals("JS_LUNPAN_UP")) {
                    }
                    break;
                case 1484306603:
                    if (!str.equals("JS_LUNPAN_RIGHT")) {
                    }
                    break;
                case 1710038035:
                    if (!str.equals("JS_LUNPAN_DOWN")) {
                    }
                    break;
                case 1710266232:
                    if (!str.equals("JS_LUNPAN_LEFT")) {
                    }
                    break;
                case 1779719389:
                    if (!str.equals("JS_LEFT_UP")) {
                    }
                    break;
            }
            return -1;
        }
        return -1;
    }

    @m
    @k
    public static final String i(int i10, int i11) {
        if (i11 != 0) {
            if (i11 == 1) {
                if (i10 == 116) {
                    return "MOUSE";
                }
                if (i10 == 117) {
                    return "VIRTUAL_CLICK";
                }
                if (i10 == 240) {
                    return "WASD";
                }
                switch (i10) {
                    case 4:
                        return i1.a.W4;
                    case 5:
                        return "B";
                    case 6:
                        return "C";
                    case 7:
                        return "D";
                    case 8:
                        return i1.a.S4;
                    case 9:
                        return "F";
                    case 10:
                        return "G";
                    case 11:
                        return "H";
                    case 12:
                        return "I";
                    case 13:
                        return "J";
                    case 14:
                        return "K";
                    case 15:
                        return "L";
                    case 16:
                        return "M";
                    case 17:
                        return "N";
                    case 18:
                        return "O";
                    case 19:
                        return "P";
                    case 20:
                        return "Q";
                    case 21:
                        return "R";
                    case 22:
                        return i1.a.R4;
                    case 23:
                        return i1.a.f31577d5;
                    case 24:
                        return "U";
                    case 25:
                        return i1.a.X4;
                    case 26:
                        return i1.a.T4;
                    case 27:
                        return "X";
                    case 28:
                        return "Y";
                    case 29:
                        return "Z";
                    case 30:
                        return "N1";
                    case 31:
                        return "N2";
                    case 32:
                        return "N3";
                    case 33:
                        return "N4";
                    case 34:
                        return "N5";
                    case 35:
                        return "N6";
                    case 36:
                        return "N7";
                    case 37:
                        return "N8";
                    case 38:
                        return "N9";
                    case 39:
                        return "N0";
                    case 40:
                        return "ENTER";
                    case 41:
                        return "ESCAPE";
                    case 42:
                        return "BACKSPACE";
                    case 43:
                        return "TAB";
                    case 44:
                        return "SPACE";
                    case 45:
                        return "MINUS";
                    case 46:
                        return "PLUS";
                    case 47:
                        return "LEFTBRACKETS";
                    case 48:
                        return "RIGHTBRACKETS";
                    case 49:
                        return "BACKSLASH";
                    case 50:
                        return "NONUS";
                    case 51:
                        return "SEMICOLON";
                    case 52:
                        return "QUOTATIONMARK";
                    case 53:
                        return "GRAVEACCENT";
                    case 54:
                        return "COMMA";
                    case 55:
                        return "FULLSTOP";
                    case 56:
                        return "QUESTIONMARK";
                    case 57:
                        return "CAPSLOCK";
                    case 58:
                        return "F1";
                    case 59:
                        return "F2";
                    case 60:
                        return "F3";
                    case 61:
                        return "F4";
                    case 62:
                        return "F5";
                    case 63:
                        return "F6";
                    case 64:
                        return "F7";
                    case 65:
                        return "F8";
                    case 66:
                        return "F9";
                    case 67:
                        return "F10";
                    case 68:
                        return "F11";
                    case 69:
                        return "F12";
                    case 70:
                        return "PRTSCRSYSRQ";
                    case 71:
                        return "SCROLLLOCK";
                    case 72:
                        return "PAUSEBREAK";
                    case 73:
                        return "INSERT";
                    case 74:
                        return "HOME";
                    case 75:
                        return "PAGEUP";
                    case 76:
                        return "DELETE";
                    case 77:
                        return "END";
                    case 78:
                        return "PAGEDOWN";
                    case 79:
                        return "RIGHTARROW";
                    case 80:
                        return "LEFTARROW";
                    case 81:
                        return "DOWNARROW";
                    case 82:
                        return "UPARROW";
                    case 83:
                        return "NUM_LOCK";
                    case 84:
                        return "NUM_FORWARDSLASH";
                    case 85:
                        return "NUM_STARKEY";
                    case 86:
                        return "NUM_MINUS";
                    case 87:
                        return "NUM_PLUS";
                    case 88:
                        return "NUM_ENTER";
                    case 89:
                        return "NUM_1";
                    case 90:
                        return "NUM_2";
                    case 91:
                        return "NUM_3";
                    case 92:
                        return "NUM_4";
                    case 93:
                        return "NUM_5";
                    case 94:
                        return "NUM_6";
                    case 95:
                        return "NUM_7";
                    case 96:
                        return "NUM_8";
                    case 97:
                        return "NUM_9";
                    case 98:
                        return "NUM_0";
                    case 99:
                        return "NUM_DEL";
                    case 100:
                        return "MOUSE_LEFT";
                    case 101:
                        return "MOUSE_RIGHT";
                    case 102:
                        return "MOUSE_MIDDLE";
                    case 103:
                        return "MOUSE_BACKWARD";
                    case 104:
                        return "MOUSE_FORWARD";
                    case 105:
                        return "MOUSE_WHEELP";
                    case 106:
                        return "MOUSE_WHEELM";
                    default:
                        switch (i10) {
                            case 108:
                                return "SHIFT";
                            case 109:
                                return "CTRL";
                            case 110:
                                return "WIN";
                            case 111:
                                return "ALT";
                            default:
                                return "";
                        }
                }
            }
            if (i11 != 2) {
                return "";
            }
        }
        if (i10 == 53) {
            return "M5";
        }
        if (i10 == 54) {
            return "M6";
        }
        switch (i10) {
            case 0:
                return "UP";
            case 1:
                return "RIGHT";
            case 2:
                return "DOWN";
            case 3:
                return "LEFT";
            case 4:
                return i1.a.W4;
            case 5:
                return "B";
            case 6:
                return "SELECT";
            case 7:
                return "X";
            case 8:
                return "Y";
            case 9:
                return "START";
            case 10:
                return ze.k.f58516r;
            case 11:
                return "RB";
            case 12:
                return "LT";
            case 13:
                return "RT";
            case 14:
                return "L3";
            case 15:
                return "R3";
            default:
                switch (i10) {
                    case 18:
                        return "BACK";
                    case 19:
                        return "HOME";
                    case 20:
                        return "MENU";
                    case 21:
                        return "LTA";
                    case 22:
                        return "LTB";
                    case 23:
                        return "LTX";
                    case 24:
                        return "LTY";
                    case 25:
                        return "LTRB";
                    case 26:
                        return "LTRT";
                    case 27:
                        return "LTC";
                    case 28:
                        return "LTZ";
                    case 29:
                        return "LBA";
                    case 30:
                        return "LBB";
                    case 31:
                        return "LBX";
                    case 32:
                        return "LBY";
                    case 33:
                        return "LBRB";
                    case 34:
                        return "LBRT";
                    case 35:
                        return "LBC";
                    case 36:
                        return "LBZ";
                    case 37:
                        return "C";
                    case 38:
                        return "Z";
                    case 39:
                        return "M1";
                    case 40:
                        return "M2";
                    case 41:
                        return "M3";
                    case 42:
                        return "M4";
                    case 43:
                        return "MOUSE";
                    case 44:
                        return "M1A";
                    case 45:
                        return "M1B";
                    case 46:
                        return "M1X";
                    case 47:
                        return "M1Y";
                    case 48:
                        return "M2A";
                    case 49:
                        return "M2B";
                    case 50:
                        return "M2X";
                    case 51:
                        return "M2Y";
                    default:
                        switch (i10) {
                            case 64:
                                return "JS_UP";
                            case 65:
                                return "JS_RIGHT";
                            case 66:
                                return "JS_DOWN";
                            case 67:
                                return "JS_LEFT";
                            case 68:
                                return "JS_LEFT_UP";
                            case 69:
                                return "JS_LEFT_RIGHT";
                            case 70:
                                return "JS_LEFT_DOWN";
                            case 71:
                                return "JS_LEFT_LEFT";
                            case 72:
                                return "JS_LUNPAN_UP";
                            case 73:
                                return "JS_LUNPAN_RIGHT";
                            case 74:
                                return "JS_LUNPAN_DOWN";
                            case 75:
                                return "JS_LUNPAN_LEFT";
                            default:
                                switch (i10) {
                                    case 240:
                                        return "JSLEFT";
                                    case 241:
                                        return "JSRIGHT";
                                    case m9.m.f40854e0 /* 242 */:
                                        return "JSWHEEL";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    @m
    @k
    public static final String j(int i10, int i11, int i12, int i13) {
        if (i10 != 256) {
            return i(i10, i13);
        }
        return i(i11, i13) + i(i12, i13);
    }

    @m
    @l
    public static final Drawable k(@k Context context, int i10, @k GamepadInfo deviceInfo, boolean z10) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        int iH = deviceInfo.isGamepadKeyboard() ? f16344a.h(i10, deviceInfo.getDeviceType(), z10) : f16344a.g(i10, deviceInfo.getDeviceType(), z10);
        if (iH == 0) {
            return null;
        }
        return d.i(context, iH);
    }

    @m
    @k
    public static final CharSequence l(@k CFGPropertyKey key, @k GamepadInfo deviceInfo) {
        f0.p(key, "key");
        f0.p(deviceInfo, "deviceInfo");
        int i10 = key.key_id;
        if (i10 != 256) {
            Spanned spannedA = y0.c.a(n(i10, deviceInfo), 0);
            f0.o(spannedA, "{\n            HtmlCompat…Y\n            )\n        }");
            return spannedA;
        }
        Spanned spannedA2 = y0.c.a(n(b.a(key.comboKeyFirst), deviceInfo) + '+' + n(b.a(key.comboKeySecond), deviceInfo), 0);
        f0.o(spannedA2, "{\n            val comboF…ML_MODE_LEGACY)\n        }");
        return spannedA2;
    }

    @m
    @k
    public static final CharSequence m(@k CFGPropertyMacro key, @k GamepadInfo deviceInfo) {
        f0.p(key, "key");
        f0.p(deviceInfo, "deviceInfo");
        int i10 = key.key_id;
        if (i10 != 256) {
            Spanned spannedA = y0.c.a(n(i10, deviceInfo), 0);
            f0.o(spannedA, "{\n            HtmlCompat…Y\n            )\n        }");
            return spannedA;
        }
        Spanned spannedA2 = y0.c.a(n(b.a(key.comboKeyFirst), deviceInfo) + '+' + n(b.a(key.comboKeySecond), deviceInfo), 0);
        f0.o(spannedA2, "{\n            val comboF…ML_MODE_LEGACY)\n        }");
        return spannedA2;
    }

    @m
    @k
    public static final String n(int i10, @k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        if (!deviceInfo.isGamepadKeyboard()) {
            switch (i10) {
                case 0:
                case 64:
                case 68:
                case 72:
                    return "&#xe66c;";
                case 1:
                case 65:
                case 69:
                case 73:
                    return "&#xe661;";
                case 2:
                case 66:
                case 70:
                case 74:
                    return "&#xe66a;";
                case 3:
                case 67:
                case 71:
                case 75:
                    return "&#xe66d;";
                case 4:
                    return "&#xe609;";
                case 5:
                    return "&#xe60b;";
                case 6:
                    int deviceType = deviceInfo.getDeviceType();
                    return (deviceType == 67 || deviceType == 69) ? "&#xe66b;" : "&#xe672;";
                case 7:
                    return "&#xe614;";
                case 8:
                    return "&#xe61d;";
                case 9:
                    return "&#xe674;";
                case 10:
                    return "&#xe65a;";
                case 11:
                    return "&#xe65d;";
                case 12:
                    return "&#xe656;";
                case 13:
                    return "&#xe667;";
                case 14:
                    switch (deviceInfo.getDeviceType()) {
                        case 64:
                        case 65:
                        case 66:
                            return "&#xe66b;";
                        default:
                            return "&#xe673;";
                    }
                case 15:
                    return "&#xe671;";
                case 16:
                case 17:
                case 43:
                case 52:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                default:
                    return "";
                case 18:
                    return "&#xe65c;";
                case 19:
                    return "&#xe65e;";
                case 20:
                    if (h.f40779v.equals(deviceInfo.getDeviceCode()) || h.f40780w.equals(deviceInfo.getDeviceCode()) || h.f40781x.equals(deviceInfo.getDeviceCode())) {
                        return "&#xe605;";
                    }
                    int deviceType2 = deviceInfo.getDeviceType();
                    return (deviceType2 == 16 || deviceType2 == 17) ? "&#xe664;" : (deviceType2 == 20 || deviceType2 == 22 || deviceType2 == 23) ? "&#xe649;" : "&#xe65f;";
                case 21:
                    return "&#xe656;+&#xe609;";
                case 22:
                    return "&#xe656;+&#xe60b;";
                case 23:
                    return "&#xe656;+&#xe614;";
                case 24:
                    return "&#xe656;+&#xe61d;";
                case 25:
                    return "&#xe656;+&#xe65d;";
                case 26:
                    return "&#xe656;+&#xe667;";
                case 27:
                    return "&#xe656;+&#xe620;";
                case 28:
                    return "&#xe656;+&#xe62b;";
                case 29:
                    return "&#xe65a;+&#xe609;";
                case 30:
                    return "&#xe65a;+&#xe60b;";
                case 31:
                    return "&#xe65a;+&#xe614;";
                case 32:
                    return "&#xe65a;+&#xe61d;";
                case 33:
                    return "&#xe65a;+&#xe65d;";
                case 34:
                    return "&#xe65a;+&#xe667;";
                case 35:
                    return "&#xe65a;+&#xe620;";
                case 36:
                    return "&#xe65a;+&#xe62b;";
                case 37:
                    return "&#xe620;";
                case 38:
                    return "&#xe62b;";
                case 39:
                    int deviceType3 = deviceInfo.getDeviceType();
                    return (deviceType3 == 67 || deviceType3 == 69) ? "&#xe621;" : "&#xe62f;";
                case 40:
                    return "&#xe627;";
                case 41:
                    return "&#xe62c;";
                case 42:
                    return "&#xe62d;";
                case 44:
                    return "&#xe62f;+&#xe609;";
                case 45:
                    return "&#xe62f;+&#xe60b;";
                case 46:
                    return "&#xe62f;+&#xe614;";
                case 47:
                    return "&#xe62f;+&#xe61d;";
                case 48:
                    return "&#xe627;+&#xe609;";
                case 49:
                    return "&#xe627;+&#xe60b;";
                case 50:
                    return "&#xe627;+&#xe614;";
                case 51:
                    return "&#xe627;+&#xe61d;";
                case 53:
                    return "&#xe62e;";
                case 54:
                    return "&#xe635;";
            }
        }
        if (!deviceInfo.isGamepadKeyboard()) {
            return "";
        }
        switch (i10) {
            case 4:
                return "&#xe609;";
            case 5:
                return "&#xe60b;";
            case 6:
                return "&#xe620;";
            case 7:
                return "&#xe613;";
            case 8:
                return "&#xe60a;";
            case 9:
                return "&#xe617;";
            case 10:
                return "&#xe60c;";
            case 11:
                return "&#xe615;";
            case 12:
                return "&#xe619;";
            case 13:
                return "&#xe60e;";
            case 14:
                return "&#xe629;";
            case 15:
                return "&#xe60d;";
            case 16:
                return "&#xe621;";
            case 17:
                return "&#xe625;";
            case 18:
                return "&#xe611;";
            case 19:
                return "&#xe618;";
            case 20:
                return "&#xe612;";
            case 21:
                return "&#xe623;";
            case 22:
                return "&#xe62a;";
            case 23:
                return "&#xe610;";
            case 24:
                return "&#xe60f;";
            case 25:
                return "&#xe61f;";
            case 26:
                return "&#xe61b;";
            case 27:
                return "&#xe614;";
            case 28:
                return "&#xe61d;";
            case 29:
                return "&#xe62b;";
            case 30:
                return "&#xe676;";
            case 31:
                return "&#xe675;";
            case 32:
                return "&#xe677;";
            case 33:
                return "&#xe67e;";
            case 34:
                return "&#xe67a;";
            case 35:
                return "&#xe67d;";
            case 36:
                return "&#xe67c;";
            case 37:
                return "&#xe67b;";
            case 38:
                return "&#xe678;";
            case 39:
                return "&#xe679;";
            case 40:
                return "&#xe66e;";
            case 41:
                return "&#xe659;";
            case 42:
                return "&#xe655;";
            case 43:
                return "&#xe668;";
            case 44:
                return "&#xe64a;";
            case 45:
                return "&#xe651;";
            case 46:
                return "&#xe649;";
            case 47:
                return "&#xe64e;";
            case 48:
                return "&#xe650;";
            case 49:
                return "&#xe652;";
            case 50:
                break;
            case 51:
                return "&#xe669;";
            case 52:
                return "&#xe64b;";
            case 53:
                return "&#xe642;";
            case 54:
                return "&#xe644;";
            case 55:
                return "&#xe647;";
            case 56:
                return "&#xe64d;";
            case 57:
                return "&#xe662;";
            case 58:
                return deviceInfo.getDeviceType() == 49 ? "&#xe682;" : "&#xe643;";
            case 59:
                return deviceInfo.getDeviceType() == 49 ? "&#xe67f;" : "&#xe616;";
            case 60:
                return deviceInfo.getDeviceType() == 49 ? "&#xe680;" : "&#xe624;";
            case 61:
                return deviceInfo.getDeviceType() == 49 ? "&#xe681;" : "&#xe61c;";
            case 62:
                return "&#xe638;";
            case 63:
                return "&#xe622;";
            case 64:
                return "&#xe61e;";
            case 65:
                return "&#xe626;";
            case 66:
                return "&#xe631;";
            case 67:
                return "&#xe634;";
            case 68:
                return "&#xe628;";
            case 69:
                return "&#xe630;";
            case 70:
                return "&#xe658;";
            case 71:
                return "&#xe646;";
            case 72:
                return "&#xe660;";
            case 73:
                return "&#xe657;";
            case 74:
                return "&#xe670;";
            case 75:
                return "&#xe645;";
            case 76:
                return "&#xe654;";
            case 77:
                return "&#xe653;";
            case 78:
                return "&#xe648;";
            case 79:
                return "&#xe661;";
            case 80:
                return "&#xe66d;";
            case 81:
                return "&#xe66a;";
            case 82:
                return "&#xe66c;";
            case 83:
                return "&#xe640;";
            case 84:
                return "&#xe63e;";
            case 85:
                return "&#xe63d;";
            case 86:
                return "&#xe64c;";
            case 87:
                return "&#xe641;";
            case 88:
                return "&#xe63f;";
            case 89:
                return "&#xe632;";
            case 90:
                return "&#xe639;";
            case 91:
                return "&#xe637;";
            case 92:
                return "&#xe636;";
            case 93:
                return "&#xe63a;";
            case 94:
                return "&#xe64f;";
            case 95:
                return "&#xe61a;";
            case 96:
                return "&#xe63b;";
            case 97:
                return "&#xe63c;";
            case 98:
                return "&#xe633;";
            case 99:
                return "&#xe65b;";
            default:
                switch (i10) {
                    case 108:
                        return "&#xe663;";
                    case 109:
                        return "&#xe666;";
                    case 110:
                        return "&#xe66f;";
                    case 111:
                        return "&#xe665;";
                }
        }
        return "";
    }

    public final boolean a(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        if (t.b(gamepadInfo)) {
            return true;
        }
        if (i11 != -1 && i12 != -1) {
            return d(i11, i12) != 256 && gamepadInfo.containKey(b.a(i11)) && gamepadInfo.containKey(b.a(i12));
        }
        if (!m9.m.a(i10)) {
            return false;
        }
        Pair<Integer, Integer> pairC = c(i10);
        return gamepadInfo.containKey(b.a(pairC.f().intValue())) && gamepadInfo.containKey(b.a(pairC.h().intValue()));
    }

    public final Pair<Integer, Integer> c(int i10) {
        switch (i10) {
            case 21:
                return new Pair<>(12, 4);
            case 22:
                return new Pair<>(12, 5);
            case 23:
                return new Pair<>(12, 7);
            case 24:
                return new Pair<>(12, 8);
            case 25:
                return new Pair<>(12, 11);
            case 26:
                return new Pair<>(12, 13);
            case 27:
                return new Pair<>(12, 16);
            case 28:
                return new Pair<>(12, 17);
            case 29:
                return new Pair<>(10, 4);
            case 30:
                return new Pair<>(10, 5);
            case 31:
                return new Pair<>(10, 7);
            case 32:
                return new Pair<>(10, 8);
            case 33:
                return new Pair<>(10, 11);
            case 34:
                return new Pair<>(10, 13);
            case 35:
                return new Pair<>(10, 16);
            case 36:
                return new Pair<>(10, 17);
            default:
                switch (i10) {
                    case 44:
                        return new Pair<>(18, 4);
                    case 45:
                        return new Pair<>(18, 5);
                    case 46:
                        return new Pair<>(18, 7);
                    case 47:
                        return new Pair<>(18, 8);
                    case 48:
                        return new Pair<>(19, 4);
                    case 49:
                        return new Pair<>(19, 5);
                    case 50:
                        return new Pair<>(19, 7);
                    case 51:
                        return new Pair<>(19, 8);
                    default:
                        return new Pair<>(-1, -1);
                }
        }
    }

    public final int g(int i10, int i11, boolean z10) {
        if (i10 == 53) {
            return z10 ? R.drawable.flymapping_gp_after_m5 : R.drawable.flymapping_gp_front_m5_normal;
        }
        if (i10 == 54) {
            return z10 ? R.drawable.flymapping_gp_after_m6 : R.drawable.flymapping_gp_front_m6_normal;
        }
        switch (i10) {
            case 0:
                return z10 ? R.drawable.flymapping_gp_after_up : R.drawable.flymapping_gp_front_up;
            case 1:
                return z10 ? R.drawable.flymapping_gp_after_right : R.drawable.flymapping_gp_front_right;
            case 2:
                return z10 ? R.drawable.flymapping_gp_after_down : R.drawable.flymapping_gp_front_down;
            case 3:
                return z10 ? R.drawable.flymapping_gp_after_left : R.drawable.flymapping_gp_front_left;
            case 4:
                return z10 ? R.drawable.flymapping_gp_after_a : R.drawable.flymapping_gp_front_a;
            case 5:
                return z10 ? R.drawable.flymapping_gp_after_b : R.drawable.flymapping_gp_front_b;
            case 6:
                return (i11 == 67 || i11 == 69) ? z10 ? R.drawable.flymapping_gp_after_logo : R.drawable.flymapping_gp_front_logo_normal : z10 ? R.drawable.flymapping_gp_after_select : R.drawable.flymapping_gp_front_select_normal;
            case 7:
                return z10 ? R.drawable.flymapping_gp_after_x : R.drawable.flymapping_gp_front_x;
            case 8:
                return z10 ? R.drawable.flymapping_gp_after_y : R.drawable.flymapping_gp_front_y;
            case 9:
                return z10 ? R.drawable.flymapping_gp_after_start : R.drawable.flymapping_gp_front_start_normal;
            case 10:
                return z10 ? R.drawable.flymapping_gp_after_lb : R.drawable.flymapping_gp_front_lb;
            case 11:
                return z10 ? R.drawable.flymapping_gp_after_rb : R.drawable.flymapping_gp_front_rb;
            case 12:
                return z10 ? R.drawable.flymapping_gp_after_lt : R.drawable.flymapping_gp_front_lt;
            case 13:
                return z10 ? R.drawable.flymapping_gp_after_rt : R.drawable.flymapping_gp_front_rt;
            case 14:
                if (i11 != 33) {
                    switch (i11) {
                        case 64:
                        case 65:
                        case 66:
                            break;
                        default:
                            return z10 ? R.drawable.flymapping_gp_after_l3 : R.drawable.flymapping_gp_front_l3_normal;
                    }
                }
                return z10 ? R.drawable.flymapping_gp_after_logo : R.drawable.flymapping_gp_front_logo_normal;
            case 15:
                return z10 ? R.drawable.flymapping_gp_after_r3 : R.drawable.flymapping_gp_front_r3_normal;
            default:
                switch (i10) {
                    case 18:
                        return (i11 == 20 || i11 == 22 || i11 == 23) ? z10 ? R.drawable.flymapping_km_after_minussign : R.drawable.flymapping_km_front_minussign : z10 ? R.drawable.flymapping_gp_after_back : R.drawable.flymapping_gp_front_back_normal;
                    case 19:
                        return z10 ? R.drawable.flymapping_gp_after_home : R.drawable.flymapping_gp_front_home_normal;
                    case 20:
                        return (i11 == 16 || i11 == 17) ? z10 ? R.drawable.flymapping_gp_after_menu : R.drawable.flymapping_gp_front_menu_normal : (i11 == 20 || i11 == 22 || i11 == 23) ? z10 ? R.drawable.flymapping_km_after_plus : R.drawable.flymapping_km_front_plus : z10 ? R.drawable.flymapping_gp_after_bluetooth : R.drawable.flymapping_gp_front_bluetooth_normal;
                    case 21:
                        return z10 ? R.drawable.flymapping_gp_after_lta : R.drawable.flymapping_gp_front_lta_normal;
                    case 22:
                        return z10 ? R.drawable.flymapping_gp_after_ltb : R.drawable.flymapping_gp_front_ltb_normal;
                    case 23:
                        return z10 ? R.drawable.flymapping_gp_after_ltx : R.drawable.flymapping_gp_front_ltx_normal;
                    case 24:
                        return z10 ? R.drawable.flymapping_gp_after_lty : R.drawable.flymapping_gp_front_lty_normal;
                    case 25:
                        return z10 ? R.drawable.flymapping_gp_after_ltrb : R.drawable.flymapping_gp_front_ltrb_normal;
                    case 26:
                        return z10 ? R.drawable.flymapping_gp_after_ltrt : R.drawable.flymapping_gp_front_ltrt_normal;
                    case 27:
                        return z10 ? R.drawable.flymapping_gp_after_ltc : R.drawable.flymapping_gp_front_ltc_normal;
                    case 28:
                        return z10 ? R.drawable.flymapping_gp_after_ltz : R.drawable.flymapping_gp_front_ltz_normal;
                    case 29:
                        return z10 ? R.drawable.flymapping_gp_after_lba : R.drawable.flymapping_gp_front_lba_normal;
                    case 30:
                        return z10 ? R.drawable.flymapping_gp_after_lbb : R.drawable.flymapping_gp_front_lbb_normal;
                    case 31:
                        return z10 ? R.drawable.flymapping_gp_after_lbx : R.drawable.flymapping_gp_front_lbx_normal;
                    case 32:
                        return z10 ? R.drawable.flymapping_gp_after_lby : R.drawable.flymapping_gp_front_lby_normal;
                    case 33:
                        return z10 ? R.drawable.flymapping_gp_after_lbrb : R.drawable.flymapping_gp_front_lbrb_normal;
                    case 34:
                        return z10 ? R.drawable.flymapping_gp_after_lbrt : R.drawable.flymapping_gp_front_lbrt_normal;
                    case 35:
                        return z10 ? R.drawable.flymapping_gp_after_lbc : R.drawable.flymapping_gp_front_lbc_normal;
                    case 36:
                        return z10 ? R.drawable.flymapping_gp_after_lbz : R.drawable.flymapping_gp_front_lbz_normal;
                    case 37:
                        return z10 ? R.drawable.flymapping_gp_after_c : R.drawable.flymapping_gp_front_c_normal;
                    case 38:
                        return z10 ? R.drawable.flymapping_gp_after_z : R.drawable.flymapping_gp_front_z_normal;
                    case 39:
                        return (i11 == 67 || i11 == 69) ? z10 ? R.drawable.flymapping_gp_after_m : R.drawable.flymapping_gp_front_m_normal : z10 ? R.drawable.flymapping_gp_after_m1 : R.drawable.flymapping_gp_front_m1_normal;
                    case 40:
                        return z10 ? R.drawable.flymapping_gp_after_m2 : R.drawable.flymapping_gp_front_m2_normal;
                    case 41:
                        return z10 ? R.drawable.flymapping_gp_after_m3 : R.drawable.flymapping_gp_front_m3_normal;
                    case 42:
                        return z10 ? R.drawable.flymapping_gp_after_m4 : R.drawable.flymapping_gp_front_m4_normal;
                    default:
                        switch (i10) {
                            case 44:
                                return z10 ? R.drawable.flymapping_gp_after_m1a : R.drawable.flymapping_gp_front_m1a_normal;
                            case 45:
                                return z10 ? R.drawable.flymapping_gp_after_m1b : R.drawable.flymapping_gp_front_m1b_normal;
                            case 46:
                                return z10 ? R.drawable.flymapping_gp_after_m1x : R.drawable.flymapping_gp_front_m1x_normal;
                            case 47:
                                return z10 ? R.drawable.flymapping_gp_after_m1y : R.drawable.flymapping_gp_front_m1y_normal;
                            case 48:
                                return z10 ? R.drawable.flymapping_gp_after_m2a : R.drawable.flymapping_gp_front_m2a_normal;
                            case 49:
                                return z10 ? R.drawable.flymapping_gp_after_m2b : R.drawable.flymapping_gp_front_m2b_normal;
                            case 50:
                                return z10 ? R.drawable.flymapping_gp_after_m2x : R.drawable.flymapping_gp_front_m2x_normal;
                            case 51:
                                return z10 ? R.drawable.flymapping_gp_after_m2y : R.drawable.flymapping_gp_front_m2y_normal;
                            default:
                                switch (i10) {
                                    case 64:
                                    case 68:
                                    case 72:
                                        return z10 ? R.drawable.flymapping_gp_after_js_up : R.drawable.flymapping_gp_front_js_up;
                                    case 65:
                                    case 69:
                                    case 73:
                                        return z10 ? R.drawable.flymapping_gp_after_js_right : R.drawable.flymapping_gp_front_js_right;
                                    case 66:
                                    case 70:
                                    case 74:
                                        return z10 ? R.drawable.flymapping_gp_after_js_down : R.drawable.flymapping_gp_front_js_down;
                                    case 67:
                                    case 71:
                                    case 75:
                                        return z10 ? R.drawable.flymapping_gp_after_js_left : R.drawable.flymapping_gp_front_js_left;
                                    default:
                                        switch (i10) {
                                            case 240:
                                                if (z10) {
                                                    return 0;
                                                }
                                                return R.drawable.flymapping_gp_front_leftstick;
                                            case 241:
                                                if (z10) {
                                                    return 0;
                                                }
                                                return R.drawable.flymapping_gp_front_rightstick;
                                            case m9.m.f40854e0 /* 242 */:
                                                if (z10) {
                                                    return 0;
                                                }
                                                return R.drawable.flymapping_gp_front_lunpan;
                                            default:
                                                return 0;
                                        }
                                }
                        }
                }
        }
    }

    public final int h(int i10, int i11, boolean z10) {
        if (i10 == 116) {
            if (z10) {
                return 0;
            }
            return R.drawable.flymapping_km_front_mouse;
        }
        if (i10 == 240) {
            if (z10) {
                return 0;
            }
            return R.drawable.flymapping_km_front_asdw;
        }
        switch (i10) {
            case 4:
                return z10 ? R.drawable.flymapping_km_after_a : R.drawable.flymapping_km_front_a;
            case 5:
                return z10 ? R.drawable.flymapping_km_after_b : R.drawable.flymapping_km_front_b;
            case 6:
                return z10 ? R.drawable.flymapping_km_after_c : R.drawable.flymapping_km_front_c;
            case 7:
                return z10 ? R.drawable.flymapping_km_after_d : R.drawable.flymapping_km_front_d;
            case 8:
                return z10 ? R.drawable.flymapping_km_after_e : R.drawable.flymapping_km_front_e;
            case 9:
                return z10 ? R.drawable.flymapping_km_after_f : R.drawable.flymapping_km_front_f;
            case 10:
                return z10 ? R.drawable.flymapping_km_after_g : R.drawable.flymapping_km_front_g;
            case 11:
                return z10 ? R.drawable.flymapping_km_after_h : R.drawable.flymapping_km_front_h;
            case 12:
                return z10 ? R.drawable.flymapping_km_after_i : R.drawable.flymapping_km_front_i;
            case 13:
                return z10 ? R.drawable.flymapping_km_after_j : R.drawable.flymapping_km_front_j;
            case 14:
                return z10 ? R.drawable.flymapping_km_after_k : R.drawable.flymapping_km_front_k;
            case 15:
                return z10 ? R.drawable.flymapping_km_after_l : R.drawable.flymapping_km_front_l;
            case 16:
                return z10 ? R.drawable.flymapping_km_after_m : R.drawable.flymapping_km_front_m;
            case 17:
                return z10 ? R.drawable.flymapping_km_after_n : R.drawable.flymapping_km_front_n;
            case 18:
                return z10 ? R.drawable.flymapping_km_after_o : R.drawable.flymapping_km_front_o;
            case 19:
                return z10 ? R.drawable.flymapping_km_after_p : R.drawable.flymapping_km_front_p;
            case 20:
                return z10 ? R.drawable.flymapping_km_after_q : R.drawable.flymapping_km_front_q;
            case 21:
                return z10 ? R.drawable.flymapping_km_after_r : R.drawable.flymapping_km_front_r;
            case 22:
                return z10 ? R.drawable.flymapping_km_after_s : R.drawable.flymapping_km_front_s;
            case 23:
                return z10 ? R.drawable.flymapping_km_after_t : R.drawable.flymapping_km_front_t;
            case 24:
                return z10 ? R.drawable.flymapping_km_after_u : R.drawable.flymapping_km_front_u;
            case 25:
                return z10 ? R.drawable.flymapping_km_after_v : R.drawable.flymapping_km_front_v;
            case 26:
                return z10 ? R.drawable.flymapping_km_after_w : R.drawable.flymapping_km_front_w;
            case 27:
                return z10 ? R.drawable.flymapping_km_after_x : R.drawable.flymapping_km_front_x;
            case 28:
                return z10 ? R.drawable.flymapping_km_after_y : R.drawable.flymapping_km_front_y;
            case 29:
                return z10 ? R.drawable.flymapping_km_after_z : R.drawable.flymapping_km_front_z;
            case 30:
                return z10 ? R.drawable.flymapping_km_after_1 : R.drawable.flymapping_km_front_1;
            case 31:
                return z10 ? R.drawable.flymapping_km_after_2 : R.drawable.flymapping_km_front_2;
            case 32:
                return z10 ? R.drawable.flymapping_km_after_3 : R.drawable.flymapping_km_front_3;
            case 33:
                return z10 ? R.drawable.flymapping_km_after_4 : R.drawable.flymapping_km_front_4;
            case 34:
                return z10 ? R.drawable.flymapping_km_after_5 : R.drawable.flymapping_km_front_5;
            case 35:
                return z10 ? R.drawable.flymapping_km_after_6 : R.drawable.flymapping_km_front_6;
            case 36:
                return z10 ? R.drawable.flymapping_km_after_7 : R.drawable.flymapping_km_front_7;
            case 37:
                return z10 ? R.drawable.flymapping_km_after_8 : R.drawable.flymapping_km_front_8;
            case 38:
                return z10 ? R.drawable.flymapping_km_after_9 : R.drawable.flymapping_km_front_9;
            case 39:
                return z10 ? R.drawable.flymapping_km_after_0 : R.drawable.flymapping_km_front_0;
            case 40:
                return z10 ? R.drawable.flymapping_km_after_enter : R.drawable.flymapping_km_front_enter;
            case 41:
                return z10 ? R.drawable.flymapping_km_after_esc : R.drawable.flymapping_km_front_esc;
            case 42:
                return z10 ? R.drawable.flymapping_km_after_ : R.drawable.flymapping_km_front_;
            case 43:
                return z10 ? R.drawable.flymapping_km_after_tab : R.drawable.flymapping_km_front_tab;
            case 44:
                return z10 ? R.drawable.flymapping_km_after_space : R.drawable.flymapping_km_front_space;
            case 45:
                return z10 ? R.drawable.flymapping_km_after_minussign : R.drawable.flymapping_km_front_minussign;
            case 46:
                return z10 ? R.drawable.flymapping_km_after_plus : R.drawable.flymapping_km_front_plus;
            case 47:
                return z10 ? R.drawable.flymapping_km_after_leftbrackets : R.drawable.flymapping_km_front_leftbrackets;
            case 48:
                return z10 ? R.drawable.flymapping_km_after_rightbrackets : R.drawable.flymapping_km_front_rightbrackets;
            case 49:
                return z10 ? R.drawable.flymapping_km_after_backslash : R.drawable.flymapping_km_front_backslash;
            case 50:
                return z10 ? R.drawable.flymapping_after_def : R.drawable.flymapping_front_def;
            case 51:
                return z10 ? R.drawable.flymapping_km_after_semicolon : R.drawable.flymapping_km_front_semicolon;
            case 52:
                return z10 ? R.drawable.flymapping_km_after_quotationmarks : R.drawable.flymapping_km_front_quotationmarks;
            case 53:
                return z10 ? R.drawable.flymapping_km_after_graveaccent : R.drawable.flymapping_km_front_graveaccent;
            case 54:
                return z10 ? R.drawable.flymapping_km_after_comma : R.drawable.flymapping_km_front_comma;
            case 55:
                return z10 ? R.drawable.flymapping_km_after_fullstop : R.drawable.flymapping_km_front_fullstop;
            case 56:
                return z10 ? R.drawable.flymapping_km_after_questionmark : R.drawable.flymapping_km_front_questionmark;
            case 57:
                return z10 ? R.drawable.flymapping_km_after_capslock : R.drawable.flymapping_km_front_capslock;
            case 58:
                return i11 == 49 ? z10 ? R.drawable.data_ic_key_g1 : R.drawable.data_ic_key_g1_adjust : z10 ? R.drawable.flymapping_km_after_f1 : R.drawable.flymapping_km_front_f1;
            case 59:
                return i11 == 49 ? z10 ? R.drawable.data_ic_key_g2 : R.drawable.data_ic_key_g2_adjust : z10 ? R.drawable.flymapping_km_after_f2 : R.drawable.flymapping_km_front_f2;
            case 60:
                return i11 == 49 ? z10 ? R.drawable.data_ic_key_g3 : R.drawable.data_ic_key_g3_adjust : z10 ? R.drawable.flymapping_km_after_f3 : R.drawable.flymapping_km_front_f3;
            case 61:
                return i11 == 49 ? z10 ? R.drawable.data_ic_key_g4 : R.drawable.data_ic_key_g4_adjust : z10 ? R.drawable.flymapping_km_after_f4 : R.drawable.flymapping_km_front_f4;
            case 62:
                return z10 ? R.drawable.flymapping_km_after_f5 : R.drawable.flymapping_km_front_f5;
            case 63:
                return z10 ? R.drawable.flymapping_km_after_f6 : R.drawable.flymapping_km_front_f6;
            case 64:
                return z10 ? R.drawable.flymapping_km_after_f7 : R.drawable.flymapping_km_front_f7;
            case 65:
                return z10 ? R.drawable.flymapping_km_after_f8 : R.drawable.flymapping_km_front_f8;
            case 66:
                return z10 ? R.drawable.flymapping_km_after_f9 : R.drawable.flymapping_km_front_f9;
            case 67:
                return z10 ? R.drawable.flymapping_km_after_f10 : R.drawable.flymapping_km_front_f10;
            case 68:
                return z10 ? R.drawable.flymapping_km_after_f11 : R.drawable.flymapping_km_front_f11;
            case 69:
                return z10 ? R.drawable.flymapping_km_after_f12 : R.drawable.flymapping_km_front_f12;
            case 70:
                return z10 ? R.drawable.flymapping_km_after_prtscrsysrq : R.drawable.flymapping_km_front_prtscrsysrq;
            case 71:
                return z10 ? R.drawable.flymapping_km_after_scrolllock : R.drawable.flymapping_km_front_scrolllock;
            case 72:
                return z10 ? R.drawable.flymapping_km_after_pausebreak : R.drawable.flymapping_km_front_pausebreak;
            case 73:
                return z10 ? R.drawable.flymapping_km_after_insert : R.drawable.flymapping_km_front_insert;
            case 74:
                return z10 ? R.drawable.flymapping_km_after_home : R.drawable.flymapping_km_front_home;
            case 75:
                return z10 ? R.drawable.flymapping_km_after_pageup : R.drawable.flymapping_km_front_pageup;
            case 76:
                return z10 ? R.drawable.flymapping_km_after_delete : R.drawable.flymapping_km_front_delete;
            case 77:
                return z10 ? R.drawable.flymapping_km_after_end : R.drawable.flymapping_km_front_end;
            case 78:
                return z10 ? R.drawable.flymapping_km_after_pagedown : R.drawable.flymapping_km_front_pagedown;
            case 79:
                return z10 ? R.drawable.flymapping_km_after_right : R.drawable.flymapping_km_front_rightarrow;
            case 80:
                return z10 ? R.drawable.flymapping_km_after_left : R.drawable.flymapping_km_front_leftarrow;
            case 81:
                return z10 ? R.drawable.flymapping_km_after_down : R.drawable.flymapping_km_front_downarrow;
            case 82:
                return z10 ? R.drawable.flymapping_km_after_up : R.drawable.flymapping_km_front_uparrow;
            case 83:
                return z10 ? R.drawable.flymapping_km_after_numlock : R.drawable.flymapping_km_front_numlock;
            case 84:
                return z10 ? R.drawable.flymapping_km_after_numforwardslash : R.drawable.flymapping_km_front_numforwardslash;
            case 85:
                return z10 ? R.drawable.flymapping_km_after_numasterisk : R.drawable.flymapping_km_front_numasterisk;
            case 86:
                return z10 ? R.drawable.flymapping_km_after_numminussign : R.drawable.flymapping_km_front_numminussign;
            case 87:
                return z10 ? R.drawable.flymapping_km_after_numplus : R.drawable.flymapping_km_front_numplus;
            case 88:
                return z10 ? R.drawable.flymapping_km_after_numenter : R.drawable.flymapping_km_front_numenter;
            case 89:
                return z10 ? R.drawable.flymapping_km_after_num1 : R.drawable.flymapping_km_front_num1;
            case 90:
                return z10 ? R.drawable.flymapping_km_after_num2 : R.drawable.flymapping_km_front_num2;
            case 91:
                return z10 ? R.drawable.flymapping_km_after_num3 : R.drawable.flymapping_km_front_num3;
            case 92:
                return z10 ? R.drawable.flymapping_km_after_num4 : R.drawable.flymapping_km_front_num4;
            case 93:
                return z10 ? R.drawable.flymapping_km_after_num5 : R.drawable.flymapping_km_front_num5;
            case 94:
                return z10 ? R.drawable.flymapping_km_after_num6 : R.drawable.flymapping_km_front_num6;
            case 95:
                return z10 ? R.drawable.flymapping_km_after_num7 : R.drawable.flymapping_km_front_num7;
            case 96:
                return z10 ? R.drawable.flymapping_km_after_num8 : R.drawable.flymapping_km_front_num8;
            case 97:
                return z10 ? R.drawable.flymapping_km_after_num9 : R.drawable.flymapping_km_front_num9;
            case 98:
                return z10 ? R.drawable.flymapping_km_after_num0 : R.drawable.flymapping_km_front_num0;
            case 99:
                return z10 ? R.drawable.flymapping_km_after_numdel : R.drawable.flymapping_km_front_numdel;
            case 100:
                return z10 ? R.drawable.flymapping_km_after_leftmouse : R.drawable.flymapping_km_front_leftmouse;
            case 101:
                return z10 ? R.drawable.flymapping_km_after_rightmouse : R.drawable.flymapping_km_front_rightmouse;
            case 102:
                return z10 ? R.drawable.flymapping_km_after_middlemouse : R.drawable.flymapping_km_front_middlemouse;
            case 103:
                return z10 ? R.drawable.flymapping_km_after_mousebackward : R.drawable.flymapping_km_front_mousebackward;
            case 104:
                return z10 ? R.drawable.flymapping_km_after_mouseforward : R.drawable.flymapping_km_front_mouseforward;
            case 105:
                return z10 ? R.drawable.flymapping_km_after_middleupmouse : R.drawable.flymapping_km_front_middleupmouse;
            case 106:
                return z10 ? R.drawable.flymapping_km_after_middledownmouse : R.drawable.flymapping_km_front_middledownmouse;
            default:
                switch (i10) {
                    case 108:
                        return z10 ? R.drawable.flymapping_km_after_shift : R.drawable.flymapping_km_front_shift;
                    case 109:
                        return z10 ? R.drawable.flymapping_km_after_ctrl : R.drawable.flymapping_km_front_ctrl;
                    case 110:
                        return z10 ? R.drawable.flymapping_km_after_win : R.drawable.flymapping_km_front_win;
                    case 111:
                        return z10 ? R.drawable.flymapping_km_after_alt : R.drawable.flymapping_km_front_alt;
                    default:
                        return 0;
                }
        }
    }
}
