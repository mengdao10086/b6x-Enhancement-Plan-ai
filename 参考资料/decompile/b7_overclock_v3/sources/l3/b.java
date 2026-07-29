package l3;

import com.blankj.utilcode.util.u;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.Arrays;
import jt.l;
import o5.m;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f39431a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f39432b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39433c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39434d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39435e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f39436f = 11;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f39437g = 20;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final short f39438a = 1;
    }

    public static void a(byte[] bArr) {
        bArr[0] = -112;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--clearDriverLutCommand:" + u.l(bArr));
    }

    public static int b(byte[] bArr, int i10) {
        return ((int) (((((bArr[3] << 8) & 65280) | (bArr[2] & 255)) / 65535.0f) * com.android.motionelf.tools.b.d())) - i10;
    }

    public static int c(byte[] bArr, int i10) {
        return ((int) (((((bArr[5] << 8) & 65280) | (bArr[4] & 255)) / 65535.0f) * com.android.motionelf.tools.b.a())) - i10;
    }

    public static byte[] d() {
        byte[] bArr = new byte[33];
        bArr[0] = 8;
        return bArr;
    }

    public static byte[] e() {
        byte[] bArr = new byte[33];
        bArr[0] = l.f36949q;
        bArr[1] = 0;
        return bArr;
    }

    public static byte[] f() {
        byte[] bArr = new byte[33];
        bArr[0] = l.f36949q;
        bArr[1] = 1;
        return bArr;
    }

    public static byte[] g() {
        byte[] bArr = new byte[33];
        bArr[0] = l.f36949q;
        bArr[1] = 2;
        return bArr;
    }

    public static byte[] h(GamepadInfo gamepadInfo) {
        byte[] bArr = new byte[33];
        bArr[0] = 67;
        if (gamepadInfo.isConnected()) {
            bArr[1] = 1;
            bArr[2] = 2;
            bArr[4] = gamepadInfo.isGamepadHalf() ? (byte) 1 : (byte) 0;
            bArr[5] = 1;
            bArr[7] = 1;
            bArr[9] = (byte) gamepadInfo.getDeviceMode();
            bArr[10] = gamepadInfo.isSupportLunpan() ? (byte) 1 : (byte) 0;
            bArr[11] = (byte) (m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, -1) == 1 ? 1 : 0);
        } else {
            bArr[1] = 0;
            bArr[2] = 2;
        }
        bArr[3] = 1;
        bArr[6] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--getConnectInfoToDriverCommand:" + u.l(bArr));
        return bArr;
    }

    public static byte[] i(GamepadInfo gamepadInfo) {
        byte[] bArr = new byte[33];
        bArr[0] = 67;
        bArr[1] = 16;
        bArr[2] = gamepadInfo.isConnected() ? (byte) 1 : (byte) 0;
        bArr[3] = 0;
        bArr[4] = gamepadInfo.isGamepadHalf() ? (byte) 1 : (byte) 0;
        bArr[5] = 1;
        bArr[6] = 0;
        bArr[7] = 1;
        bArr[9] = (byte) gamepadInfo.getDeviceMode();
        bArr[10] = gamepadInfo.isSupportLunpan() ? (byte) 1 : (byte) 0;
        bArr[11] = (byte) (m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, -1) == 1 ? 1 : 0);
        return bArr;
    }

    public static byte[] j() {
        byte[] bArr = new byte[33];
        Arrays.fill(bArr, (byte) -86);
        return bArr;
    }

    public static byte[] k(int i10, byte[] bArr) {
        bArr[0] = 6;
        bArr[1] = (byte) i10;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--getDriverMappingOrientation:" + u.l(bArr));
        return bArr;
    }

    public static byte[] l(int i10) {
        int iN = m.l(DataConstant.SP_FLOAT, 2).n(DataConstant.SP_APP_KEY_FORCE_ROTATION_90, -1);
        int i11 = i10 == 3 ? 1 : 0;
        byte[] bArr = new byte[33];
        bArr[0] = 7;
        bArr[1] = (byte) i11;
        bArr[2] = (byte) (iN != 1 ? 0 : 1);
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--getDriverModeOrientationCommand:" + u.l(bArr));
        return bArr;
    }

    public static byte[] m() {
        byte[] bArr = new byte[33];
        bArr[0] = 10;
        bArr[1] = 10;
        bArr[2] = (byte) (com.android.motionelf.tools.b.d() & 255);
        bArr[3] = (byte) ((com.android.motionelf.tools.b.d() >> 8) & 255);
        bArr[4] = (byte) (com.android.motionelf.tools.b.a() & 255);
        bArr[5] = (byte) ((com.android.motionelf.tools.b.a() >> 8) & 255);
        n.a("flydigitestdata Driver_Command--Tradition--getDriverScreenSizeData:" + u.l(bArr));
        return bArr;
    }

    public static byte[] n(int i10) {
        byte[] bArr = new byte[33];
        bArr[0] = l.f36951s;
        bArr[1] = (byte) i10;
        n.a("flydigitestdata Driver_Command--Tradition--getFlashplayRotation:" + u.l(bArr));
        return bArr;
    }

    public static byte[] o() {
        byte[] bArr = new byte[33];
        bArr[0] = 81;
        bArr[1] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--getFlashplayWaspSocketClear:" + u.l(bArr));
        return bArr;
    }

    public static byte[] p(int i10, int i11, int i12) {
        byte[] bArr = new byte[33];
        bArr[0] = 81;
        bArr[1] = 20;
        bArr[2] = (byte) i10;
        byte b10 = (byte) i12;
        bArr[3] = b10;
        bArr[4] = b10;
        bArr[5] = (byte) i11;
        n.a("flydigitestdata Driver_Command--Tradition--getFlashplayWaspSocketDrift:" + u.l(bArr));
        return bArr;
    }

    public static byte[] q(int i10, int i11, int i12) {
        byte[] bArr = new byte[33];
        bArr[0] = 81;
        bArr[1] = 11;
        bArr[2] = (byte) i10;
        float fC = com.android.motionelf.tools.b.c();
        bArr[3] = (byte) i12;
        bArr[4] = (byte) (i12 / fC);
        bArr[5] = (byte) i11;
        n.a("flydigitestdata Driver_Command--Tradition--getFlashplayWaspSocketViewExtend:" + u.l(bArr));
        return bArr;
    }

    public static byte[] r(int i10, int i11) {
        byte[] bArr = new byte[33];
        bArr[0] = 81;
        bArr[1] = 10;
        bArr[2] = (byte) i10;
        bArr[3] = (byte) i11;
        n.a("flydigitestdata Driver_Command--Tradition--getFlashplayWaspSocketViewLock:" + u.l(bArr));
        return bArr;
    }

    public static byte[] s() {
        byte[] bArr = new byte[33];
        bArr[0] = 11;
        bArr[1] = 102;
        bArr[2] = 102;
        bArr[3] = 102;
        n.a("flydigitestdata Driver_Command--Tradition--getKillDriverCommand:" + u.l(bArr));
        return bArr;
    }

    public static void t(byte[] bArr) {
        bArr[0] = -111;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--pauseDriverLutCommand:" + u.l(bArr));
    }

    public static byte[] u() {
        byte[] bArr = new byte[33];
        bArr[0] = 82;
        n.a("flydigitestdata Driver_Command--Tradition--releaseFlashplayWaspTouch:" + u.l(bArr));
        return bArr;
    }

    public static void v(byte[] bArr) {
        bArr[0] = -110;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        n.a("flydigitestdata Driver_Command--Tradition--resumeDriverLutCommand:" + u.l(bArr));
    }

    public static byte[] w() {
        byte[] bArr = new byte[33];
        bArr[0] = 82;
        bArr[1] = 1;
        n.a("flydigitestdata Driver_Command--Tradition--resumeFlashplayWaspTouch:" + u.l(bArr));
        return bArr;
    }
}
