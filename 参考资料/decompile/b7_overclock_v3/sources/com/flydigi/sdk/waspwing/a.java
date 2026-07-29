package com.flydigi.sdk.waspwing;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.graphics.Color;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionController;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionControllerKt;
import com.flydigi.sdk.bluetooth.c0;
import com.flydigi.sdk.bluetooth.u;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import l9.b;
import t9.c;
import t9.i;
import t9.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nWaspWingDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WaspWingDataInteractionController.kt\ncom/flydigi/sdk/waspwing/WaspWingDataInteractionController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,678:1\n1855#2,2:679\n1855#2,2:681\n1855#2,2:683\n1855#2,2:685\n1855#2,2:687\n1855#2,2:689\n1855#2,2:691\n1855#2,2:693\n125#3:695\n133#3:696\n141#3:697\n125#3:698\n133#3:699\n141#3:700\n*S KotlinDebug\n*F\n+ 1 WaspWingDataInteractionController.kt\ncom/flydigi/sdk/waspwing/WaspWingDataInteractionController\n*L\n46#1:679,2\n53#1:681,2\n65#1:683,2\n74#1:685,2\n81#1:687,2\n233#1:689,2\n251#1:691,2\n291#1:693,2\n556#1:695\n557#1:696\n558#1:697\n574#1:698\n575#1:699\n576#1:700\n*E\n"})
public final class a extends c0 {

    @k
    public final UUID S;

    @k
    public final UUID T;

    @k
    public final UUID U;

    @k
    public final UUID V;

    @k
    public ArrayList<i> W;

    @k
    public WaspWingInfo X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context mContext, @k u filter) {
        super(mContext, filter, 7);
        f0.p(mContext, "mContext");
        f0.p(filter, "filter");
        UUID uuidFromString = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")");
        this.S = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString2, "fromString(\"0000ffe0-0000-1000-8000-00805f9b34fb\")");
        this.T = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString3, "fromString(\"0000ffe1-0000-1000-8000-00805f9b34fb\")");
        this.U = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("0000ffe4-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString4, "fromString(\"0000ffe4-0000-1000-8000-00805f9b34fb\")");
        this.V = uuidFromString4;
        this.W = new ArrayList<>();
        this.X = new WaspWingInfo(null, null, false, null, null, false, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, (byte) 0, null, false, false, false, false, null, 0, 0, false, null, null, 0, -1, 1, null);
    }

    public static /* synthetic */ void C2(a aVar, Integer num, Integer num2, Integer num3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        if ((i10 & 2) != 0) {
            num2 = 0;
        }
        if ((i10 & 4) != 0) {
            num3 = 0;
        }
        aVar.B2(num, num2, num3);
    }

    public static /* synthetic */ void F2(a aVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, Object obj) {
        aVar.E2(i10, i11, (i17 & 4) != 0 ? 0 : i12, (i17 & 8) != 0 ? 0 : i13, (i17 & 16) != 0 ? 0 : i14, (i17 & 32) != 0 ? 0 : i15, (i17 & 64) != 0 ? 0 : i16);
    }

    public static /* synthetic */ void l2(a aVar, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = null;
        }
        if ((i10 & 2) != 0) {
            bool2 = null;
        }
        aVar.k2(bool, bool2);
    }

    public static final void m2(a this$0) {
        f0.p(this$0, "this$0");
        this$0.g2();
    }

    public static /* synthetic */ void w2(a aVar, boolean z10, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = 0;
        }
        if ((i10 & 4) != 0) {
            num2 = 0;
        }
        aVar.v2(z10, num, num2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void y2(a aVar, int i10, Integer num, ArrayList arrayList, Integer num2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = 0;
        }
        if ((i11 & 4) != 0) {
            arrayList = null;
        }
        if ((i11 & 8) != 0) {
            num2 = 0;
        }
        aVar.x2(i10, num, arrayList, num2);
    }

    public final void A2() {
        AbstractDataInteractionController.R0(this, new byte[]{16, -1}, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @k
    public UUID B1() {
        return this.S;
    }

    public final void B2(@l Integer num, @l Integer num2, @l Integer num3) {
        byte[] bArr = new byte[4];
        bArr[0] = 51;
        bArr[1] = num != null ? (byte) num.intValue() : (byte) 0;
        bArr[2] = num2 != null ? (byte) num2.intValue() : (byte) 0;
        bArr[3] = num3 != null ? (byte) num3.intValue() : (byte) 0;
        AbstractDataInteractionController.R0(this, bArr, null, 2, null);
    }

    public final void D2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{rc.a.V, (byte) i10}, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E2(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.sdk.waspwing.a.E2(int, int, int, int, int, int, int):void");
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @k
    public UUID F1() {
        return this.V;
    }

    @Override // com.flydigi.sdk.bluetooth.c0, com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void G0(@k Object obj) {
        f0.p(obj, "obj");
        super.G0(obj);
        if ((obj instanceof i) && this.W.contains(obj)) {
            this.W.remove(obj);
        }
    }

    public final void G2(@k int[] intArrayOf) {
        f0.p(intArrayOf, "intArrayOf");
        byte[] bArr = new byte[intArrayOf.length + 2];
        int i10 = 0;
        bArr[0] = 52;
        int length = intArrayOf.length;
        while (i10 < length) {
            int i11 = i10 + 1;
            bArr[i11] = (byte) intArrayOf[i10];
            i10 = i11;
        }
        AbstractDataInteractionController.R0(this, bArr, null, 2, null);
    }

    public final void H2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{17, (byte) i10}, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @k
    public UUID I1() {
        return this.U;
    }

    public final void I2(int i10, @l Integer num, @l Integer num2, @l Integer num3, @l Integer num4, @l Integer num5) {
        if (i10 != 1) {
            AbstractDataInteractionController.R0(this, new byte[]{16, 0}, null, 2, null);
            return;
        }
        byte[] bArr = new byte[7];
        bArr[0] = 16;
        bArr[1] = -1;
        bArr[2] = num != null ? (byte) num.intValue() : (byte) 0;
        bArr[3] = num2 != null ? (byte) num2.intValue() : (byte) 0;
        bArr[4] = num3 != null ? (byte) num3.intValue() : (byte) 0;
        bArr[5] = num4 != null ? (byte) num4.intValue() : (byte) 0;
        bArr[6] = num5 != null ? (byte) num5.intValue() : (byte) 0;
        AbstractDataInteractionController.R0(this, bArr, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void K1(@k byte[] value) {
        f0.p(value, "value");
    }

    public final void K2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{jt.l.f36949q, (byte) i10}, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void L1(@k byte[] value) {
        f0.p(value, "value");
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void M1(@k UUID uuid, @k byte[] value) {
        f0.p(uuid, "uuid");
        f0.p(value, "value");
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void P1(@k BluetoothDevice device) {
        f0.p(device, "device");
        super.P1(device);
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).V0(device);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void R1(@k BluetoothDevice device) {
        f0.p(device, "device");
        super.R1(device);
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).A(device);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void S1(@k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        super.S1(gatt);
        BluetoothDevice it2 = gatt.getDevice();
        v0(it2);
        WaspWingInfo.a aVar = WaspWingInfo.Companion;
        f0.o(it2, "it");
        this.X = aVar.a(it2);
        t0(1);
        Iterator<T> it3 = this.W.iterator();
        while (it3.hasNext()) {
            ((i) it3.next()).e2(it2);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void T1(@k BluetoothGatt gatt) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        f0.p(gatt, "gatt");
        super.T1(gatt);
        X1(gatt);
        for (i iVar : this.W) {
            this.X.setConnected(false);
            iVar.O2(gatt);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void V1(int i10) {
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).k1(i10);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    @k
    public UUID X0() {
        return this.T;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void Z0(@k UUID uuid, @k byte[] value) throws InterruptedException {
        String strSubstring;
        String strHh;
        f0.p(uuid, "uuid");
        f0.p(value, "value");
        int i10 = 5;
        int i11 = 4;
        if (value[0] == 19) {
            if (f0.g(this.X.getDeviceCode(), c.f50954c)) {
                int i12 = value[2];
                if (value[1] == 0) {
                    this.X.setTemperature(-i12);
                } else {
                    this.X.setTemperature(i12);
                }
                this.X.setWindLevel(value[6] & 255);
                this.X.setColdLevel(value[7] & 255);
                this.X.setRunMode(1);
                this.X.setLightState(value[8] == 1);
            } else if (f0.g(this.X.getDeviceCode(), c.f50955d) || f0.g(this.X.getDeviceCode(), c.f50956e)) {
                int i13 = value[2];
                if (value[1] == 0) {
                    this.X.setTemperature(-i13);
                } else {
                    this.X.setTemperature(i13);
                }
                this.X.setTemperatureDecimal(value[3] & 255);
                this.X.setRunMode(value[4] & 255);
                this.X.setOverClockUsable((value[5] & 255) == 255);
                this.X.setWindLevel(value[6] & 255);
                this.X.setColdLevel(value[7] & 255);
                this.X.setLightState((value[8] & 255) == 255);
                this.X.setTargetTemperature(value[9] & 255);
                if (value.length > 10) {
                    this.X.setSpeed(((value[11] & 255) << 8) + (value[10] & 255));
                }
                if (value.length > 12) {
                    this.X.setWindLevelOverclock(value[12] & 255);
                }
                if (value.length > 13) {
                    this.X.setColdLevelOverclock(value[13] & 255);
                }
                if (value.length > 14) {
                    this.X.setWindRunLevel(value[14] & 255);
                }
                if (value.length > 15) {
                    this.X.setColdRunLevel(value[15] & 255);
                }
            } else if (f0.g(this.X.getDeviceCode(), c.f50957f) || f0.g(this.X.getDeviceCode(), c.f50958g)) {
                this.X.setIpType(value[1] & 255);
                this.X.setTemperature(value[2]);
                this.X.setTemperatureDecimal(value[3] & 255);
                int i14 = value[4] & 255;
                this.X.setModeCustom(0);
                if (i14 == 3) {
                    this.X.setModeCustom(1);
                    i14 = 0;
                }
                this.X.setRunMode(i14);
                this.X.setOverClockUsable((value[5] & 255) == 255);
                this.X.setWindLevel((value[6] * 100) + (value[18] & 255));
                this.X.setColdLevel(value[7] & 255);
                this.X.setLightState((value[8] & 255) == 255);
                this.X.setTargetTemperature(value[9] & 255);
                this.X.setSpeed((value[11] * 100) + (value[10] & 255));
                this.X.setWindLevelOverclock((value[12] * 100) + (value[19] & 255));
                this.X.setColdLevelOverclock(value[13] & 255);
                this.X.setWindRunLevel(value[14] & 255);
                this.X.setColdRunLevel(value[15] & 255);
                this.X.setHotSurfaceTemperature(value[16]);
                this.X.setColdProtection((15 & value[17]) == 1);
                this.X.setHotProtectionEnabled(((value[17] & 255) >> 4) == 1);
                this.X.setColdProtectionEnabled(((value[17] & 255) >> 4) == 2);
            } else if (f0.g(this.X.getDeviceCode(), c.f50959h) || f0.g(this.X.getDeviceCode(), c.f50960i)) {
                this.X.setIpType(value[1] & 255);
                int i15 = (value[2] & 255) >> 4;
                this.X.setOverClockUsableLevel(value[2] & 15);
                WaspWingInfo waspWingInfo = this.X;
                waspWingInfo.setOverClockUsable(waspWingInfo.getOverClockUsableLevel() != 0);
                this.X.setColdLevel(value[3] & 255);
                this.X.setWindLevel((value[4] * 100) + (value[5] & 255));
                this.X.setTargetTemperature(value[6] & 255);
                this.X.setTemperature(value[7]);
                this.X.setTemperatureDecimal(value[8] & 255);
                this.X.setHotSurfaceTemperature(value[9]);
                this.X.setColdRunLevel(value[10] & 255);
                this.X.setWindRunLevel(value[11] & 255);
                this.X.setSpeed((value[12] * 100) + (value[13] & 255));
                this.X.setLightState((value[14] & 255) == 255);
                this.X.setLedType(value[15] & 255);
                this.X.setQuickSwitchRunMode(value[16] & 255);
                this.X.setColdProtection((15 & value[17]) == 1);
                this.X.setHotProtectionEnabled(((value[17] & 255) >> 4) == 1);
                this.X.setColdProtectionEnabled(((value[17] & 255) >> 4) == 2);
                if (this.X.getRunMode() != i15) {
                    this.X.setRunMode(i15);
                    j.f50990a.G(0);
                }
                if (this.X.getColdLevel() == 255 || this.X.getColdLevel() == 205 || this.X.getColdLevel() == 198 || this.X.getColdLevel() == 130) {
                    Thread.sleep(250L);
                    j.f50990a.Y(new int[]{155, 55, 0, 6, 104, 55, 155, 55, 0, 6, 104, 50, WaspWingInfo.COLD_LEVEL_STANDARD_B7, 55, 0, 6, 104, 55});
                    Thread.sleep(500L);
                    F2(this, this.X.getRunMode(), this.X.getTargetTemperature(), this.X.getWindLevel(), 104, this.X.getWindLevel(), 155, 0, 64, null);
                }
            }
            Iterator<T> it2 = this.W.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).F1(this.X);
            }
            return;
        }
        if (value[0] == '$') {
            this.X.setAddress(AbstractDataInteractionControllerKt.a(new byte[]{value[6], value[5], value[4], value[3], value[2], value[1]}, ":"));
            return;
        }
        if (value[0] == '@') {
            s2(value);
            return;
        }
        if (value[0] == 'A') {
            this.X.setTempHistories(new byte[(value[1] * 100) + value[2]]);
            return;
        }
        if (value[0] == 'B') {
            Iterator<T> it3 = this.W.iterator();
            while (it3.hasNext()) {
                ((i) it3.next()).q2(this.X.getTempHistories());
            }
            return;
        }
        if (value[0] == 'Q') {
            if (this.X.getLedData() == null) {
                this.X.setLedData(new LedData(value[1], value[2], null, value[17], 4, null));
            } else {
                LedData ledData = this.X.getLedData();
                if (ledData != null) {
                    ledData.T(value[1]);
                }
                LedData ledData2 = this.X.getLedData();
                if (ledData2 != null) {
                    ledData2.V(value[2]);
                }
                LedData ledData3 = this.X.getLedData();
                if (ledData3 != null) {
                    ledData3.U(value[17]);
                }
            }
            LedData ledData4 = this.X.getLedData();
            if (ledData4 != null) {
                if (value[4] == 1) {
                    ledData4.z().clear();
                }
                if (value[4] != 1) {
                    i11 = value[3] - 4;
                } else if (value[3] < 4) {
                    i11 = value[3];
                }
                for (int i16 = 0; i16 < i11; i16++) {
                    int i17 = i10 + 1;
                    int i18 = i17 + 1;
                    i10 = i18 + 1;
                    ledData4.z().add(Integer.valueOf(Color.rgb(value[i10] & 255, value[i17] & 255, value[i18] & 255)));
                }
                return;
            }
            return;
        }
        if (value[0] == 'R') {
            this.X.setExperimentalRunModeValue(Integer.valueOf(value[2] & 255));
            this.X.setExperimentalRunModeOn((value[2] & 255) == 230 && (value[3] & 255) == 57);
            Iterator<T> it4 = this.W.iterator();
            while (it4.hasNext()) {
                ((i) it4.next()).F1(this.X);
            }
            return;
        }
        if (value[0] != -91) {
            if (value.length > 5) {
                WaspWingInfo waspWingInfo2 = this.X;
                char[] cArrE2 = e2(value);
                if (cArrE2 == null || (strHh = ArraysKt___ArraysKt.Hh(cArrE2, "", null, null, 0, null, null, 62, null)) == null) {
                    strSubstring = null;
                } else {
                    strSubstring = strHh.substring(0, 5);
                    f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                waspWingInfo2.setFirmwareVersion(strSubstring);
                P().postDelayed(new Runnable() { // from class: t9.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.flydigi.sdk.waspwing.a.m2(this.f50989a);
                    }
                }, 1000L);
                String uuid2 = this.X.getUuid();
                if (uuid2 != null && uuid2.length() != 0) {
                    z = false;
                }
                if (z) {
                    h2();
                    return;
                }
                return;
            }
            return;
        }
        if (value[1] == -96) {
            WaspWingInfo waspWingInfo3 = this.X;
            int i19 = value[2] & 255;
            int i20 = value[3] & 255;
            int i21 = value[4] & 255;
            int i22 = value[5] & 255;
            int i23 = value[6] & 255;
            int i24 = value[7] & 255;
            int i25 = value[8] & 255;
            int i26 = value[9] & 255;
            int i27 = value[10] & 255;
            int i28 = value[11] & 255;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i19);
            sb2.append(i20);
            sb2.append(i21);
            sb2.append(i22);
            sb2.append(i23);
            sb2.append(i24);
            sb2.append(i25);
            sb2.append(i26);
            sb2.append(i27);
            sb2.append(i28);
            waspWingInfo3.setUuid(sb2.toString());
        }
        j.f50990a.G(0);
    }

    public final char[] e2(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = (char) ((byte) (bArr[i10] & (-1)));
        }
        return cArr;
    }

    @k
    public final WaspWingInfo f2() {
        return this.X;
    }

    public final void g2() {
        AbstractDataInteractionController.R0(this, new byte[]{82, 0}, null, 2, null);
    }

    public final void h2() {
        AbstractDataInteractionController.R0(this, new byte[]{-91, -96, 0, 0}, null, 2, null);
    }

    public final void i2(boolean z10) {
        AbstractDataInteractionController.R0(this, new byte[]{rc.a.Y, !z10 ? 1 : 0}, null, 2, null);
    }

    public final void j2(boolean z10) {
        AbstractDataInteractionController.R0(this, new byte[]{rc.a.X, !z10 ? 1 : 0}, null, 2, null);
    }

    public final void k2(@l Boolean bool, @l Boolean bool2) {
        byte[] bArr = new byte[3];
        bArr[0] = 50;
        if (bool != null) {
            bArr[1] = 0;
            bArr[2] = bool.booleanValue();
        } else if (bool2 != null) {
            bArr[1] = 1;
            bArr[2] = bool2.booleanValue();
        }
        AbstractDataInteractionController.R0(this, bArr, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0, com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void n0(@k Object obj) {
        f0.p(obj, "obj");
        super.n0(obj);
        if (!(obj instanceof i) || this.W.contains(obj)) {
            return;
        }
        this.W.add(obj);
    }

    public final void n2() {
        AbstractDataInteractionController.R0(this, new byte[]{19}, null, 2, null);
    }

    public final void o2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{81, (byte) i10}, null, 2, null);
    }

    public final void p2() {
        AbstractDataInteractionController.R0(this, new byte[]{rc.a.W, 0}, null, 2, null);
    }

    public final void q2() {
        AbstractDataInteractionController.R0(this, new byte[]{64, 0}, null, 2, null);
    }

    public final void r2() {
        AbstractDataInteractionController.R0(this, new byte[]{-1, 10}, null, 2, null);
    }

    public final void s2(byte[] bArr) {
        int length = bArr.length;
        for (int i10 = 2; i10 < length; i10++) {
            int i11 = ((bArr[1] * 18) + i10) - 2;
            if (i11 >= this.X.getTempHistories().length) {
                return;
            }
            this.X.getTempHistories()[i11] = bArr[i10];
        }
    }

    public final void t2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{18, (byte) i10}, null, 2, null);
    }

    public final void u2(@k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "<set-?>");
        this.X = waspWingInfo;
    }

    public final void v2(boolean z10, @l Integer num, @l Integer num2) {
        byte[] bArr = new byte[4];
        bArr[0] = 82;
        bArr[1] = 1;
        bArr[2] = (byte) ((!z10 || num == null) ? 0 : num.intValue());
        if (z10) {
            iIntValue = (num2 != null ? num2.intValue() : 0) / 100;
        }
        bArr[3] = (byte) iIntValue;
        AbstractDataInteractionController.R0(this, bArr, null, 2, null);
    }

    public final void x2(int i10, @l Integer num, @l ArrayList<Integer> arrayList, @l Integer num2) {
        ArrayList arrayList2 = new ArrayList();
        byte[] bArr = new byte[20];
        for (int i11 = 0; i11 < 20; i11++) {
            bArr[i11] = 0;
        }
        bArr[0] = jt.l.f36951s;
        byte b10 = (byte) i10;
        bArr[1] = b10;
        bArr[2] = num != null ? (byte) num.intValue() : (byte) 0;
        if (arrayList != null) {
            char c10 = arrayList.size() > 4 ? (char) 2 : (char) 1;
            bArr[3] = (byte) arrayList.size();
            bArr[4] = 1;
            int size = c10 > 1 ? 4 : arrayList.size();
            for (int i12 = 0; i12 < size; i12++) {
                int i13 = (i12 * 3) + 5;
                Integer num3 = arrayList.get(i12);
                f0.o(num3, "it[idx]");
                bArr[i13] = (byte) ((num3.intValue() >> 16) & 255 & 255);
                Integer num4 = arrayList.get(i12);
                f0.o(num4, "it[idx]");
                bArr[i13 + 1] = (byte) ((num4.intValue() >> 8) & 255 & 255);
                Integer num5 = arrayList.get(i12);
                f0.o(num5, "it[idx]");
                bArr[i13 + 2] = (byte) (num5.intValue() & 255 & 255);
            }
        }
        f0.m(num2);
        bArr[17] = (byte) num2.intValue();
        b.a(bArr);
        arrayList2.add(bArr);
        if (arrayList != null) {
            if ((arrayList.size() > 4 ? (char) 2 : (char) 1) > 1) {
                byte[] bArr2 = new byte[20];
                bArr2[0] = jt.l.f36951s;
                bArr2[1] = b10;
                bArr2[2] = num != null ? (byte) num.intValue() : (byte) 0;
                bArr2[3] = (byte) arrayList.size();
                bArr2[4] = 2;
                int size2 = arrayList.size();
                for (int i14 = 4; i14 < size2; i14++) {
                    int i15 = ((i14 - 4) * 3) + 5;
                    Integer num6 = arrayList.get(i14);
                    f0.o(num6, "it[idx]");
                    bArr2[i15] = (byte) ((num6.intValue() >> 16) & 255 & 255);
                    Integer num7 = arrayList.get(i14);
                    f0.o(num7, "it[idx]");
                    bArr2[i15 + 1] = (byte) ((num7.intValue() >> 8) & 255 & 255);
                    Integer num8 = arrayList.get(i14);
                    f0.o(num8, "it[idx]");
                    bArr2[i15 + 2] = (byte) (num8.intValue() & 255 & 255);
                }
                bArr[17] = (byte) num2.intValue();
                b.a(bArr2);
                arrayList2.add(bArr2);
            }
        }
        arrayList2.add(new byte[]{81, b10});
        AbstractDataInteractionController.O0(this, arrayList2, null, null, 6, null);
    }

    public final void z2() {
        AbstractDataInteractionController.R0(this, new byte[]{16, 0}, null, 2, null);
    }
}
