package com.android.motionelf.tools;

import com.flydigi.base.common.n;
import com.flydigi.sdk.gamepad.GamepadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11388a = 255;

    public static int a(byte[] bArr, int i10, GamepadInfo gamepadInfo) {
        float f10 = ((((bArr[15] & 15) << 8) & 3840) | (bArr[14] & 255)) / 2048.0f;
        float fE = n8.a.e(b.d(), gamepadInfo.isFlashplayMode());
        int i11 = ((int) (f10 * fE)) - i10;
        n.a("flydigitestdata getCursorYT.value:" + f10 + ",realWidth:" + fE + ",result:" + i11);
        return i11;
    }

    public static int b(byte[] bArr, int i10, GamepadInfo gamepadInfo) {
        float f10 = (((bArr[16] << 4) & 4080) | (15 & ((bArr[15] & 240) >> 4))) / 2048.0f;
        float fD = n8.a.d(b.a(), gamepadInfo.isFlashplayMode());
        int i11 = ((int) (f10 * fD)) - i10;
        n.a("flydigitestdata getCursorYT.value:" + f10 + ",realHeight:" + fD + ",result:" + i11);
        return i11;
    }

    public static double c(float f10, float f11) {
        return ((double) f11) * Math.sin((((double) f10) * 3.141592653589793d) / 180.0d);
    }

    public static double d(float f10, float f11) {
        return ((double) f11) * (-Math.cos((((double) f10) * 3.141592653589793d) / 180.0d));
    }

    public static byte e(float f10, int i10, int i11, boolean z10) {
        return (byte) ((((f10 * i11) + i10) / n8.a.e(b.d(), z10)) * 255.0f);
    }

    public static byte f(float f10, int i10, int i11, boolean z10) {
        return (byte) ((((f10 * i11) + i10) / n8.a.d(b.a(), z10)) * 255.0f);
    }
}
