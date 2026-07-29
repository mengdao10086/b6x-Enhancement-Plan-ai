package com.android.motionelf.tools;

import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.FloatWindowSizeBean;
import g.n0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jt.l;
import m9.k;
import m9.t;
import o9.h;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f11357a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f11358b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11359c = 9;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11360d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11361e = 80;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11362f = 120;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11363g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11364h = 160;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11365i = 240;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f11366j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11367k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f11368l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f11369m = 34;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f11370n = 114;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f11371o = 274;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f11372p = 754;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f11373q = 794;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f11374r = 874;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f11375s;

    public static synchronized List<Byte> a(CFGEntity cFGEntity, GamepadInfo gamepadInfo, FloatWindowSizeBean floatWindowSizeBean, int i10, boolean z10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList<Byte> arrayList3;
        ArrayList arrayList4;
        l(gamepadInfo);
        int i11 = floatWindowSizeBean.getFloatWindowStartPosition()[0];
        int i12 = floatWindowSizeBean.getFloatWindowStartPosition()[1];
        int floatWindowWidth = floatWindowSizeBean.getFloatWindowWidth();
        int floatWindowHeight = floatWindowSizeBean.getFloatWindowHeight();
        float fC = b.c();
        ArrayList<Byte> arrayListH = h(cFGEntity.title.getBytes(), gamepadInfo.getDeviceMode(), i10);
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        m(cFGEntity.jsList, gamepadInfo, fC, i11, i12, floatWindowWidth, floatWindowHeight, arrayList5, arrayList8, arrayList9, arrayList6, arrayList7);
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        n(cFGEntity.keyList, gamepadInfo, fC, i11, i12, floatWindowWidth, floatWindowHeight, arrayList10, arrayList12, arrayList8, arrayList13, cFGEntity.isTest());
        List<Byte> listJ = j(cFGEntity, gamepadInfo, arrayList13);
        if (arrayList10.size() > 80) {
            arrayList2 = new ArrayList(arrayList10.subList(80, arrayList10.size()));
            arrayList = new ArrayList(arrayList10.subList(0, 80));
        } else {
            arrayList = arrayList10;
            arrayList2 = arrayList11;
        }
        ArrayList arrayList14 = new ArrayList(arrayList6);
        arrayList14.addAll(arrayList7);
        ArrayList arrayList15 = new ArrayList();
        if (arrayList14.size() + arrayList12.size() <= 160) {
            arrayList14.addAll(arrayList12);
            arrayList3 = arrayListH;
        } else {
            arrayList3 = arrayListH;
            int size = 160 - arrayList14.size();
            arrayList14.addAll(arrayList12.subList(0, size));
            arrayList15.addAll(arrayList12.subList(size, arrayList12.size()));
        }
        if (arrayList14.size() + arrayList13.size() <= 160) {
            arrayList14.addAll(arrayList13);
        } else {
            int size2 = 160 - arrayList14.size();
            arrayList14.addAll(arrayList13.subList(0, size2));
            arrayList15.addAll(arrayList13.subList(size2, arrayList13.size()));
        }
        if (arrayList14.size() + listJ.size() <= 160) {
            arrayList14.addAll(listJ);
        } else {
            int size3 = 160 - arrayList14.size();
            arrayList14.addAll(listJ.subList(0, size3));
            arrayList15.addAll(listJ.subList(size3, listJ.size()));
        }
        ArrayList<Byte> arrayList16 = arrayList3;
        List<Byte> listI = i(cFGEntity, fC, i11, floatWindowWidth, i12, floatWindowHeight, gamepadInfo);
        arrayList4 = new ArrayList(arrayList16);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("头部：");
        sb2.append(arrayList4.size());
        arrayList4.addAll(arrayList5);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("左摇杆（对齐前）：");
        sb3.append(arrayList4.size());
        g(arrayList4, 25);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("左摇杆（对齐后）：");
        sb4.append(arrayList4.size());
        arrayList4.addAll(arrayList8);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("右摇杆（对齐前）：");
        sb5.append(arrayList4.size());
        g(arrayList4, 34);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("右摇杆（对齐后）：");
        sb6.append(arrayList4.size());
        if (z10) {
            arrayList4.addAll(arrayList9);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("轮盘（对齐前）：");
            sb7.append(arrayList4.size());
            g(arrayList4, 43);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("轮盘（对齐后）：");
            sb8.append(arrayList4.size());
            arrayList4.addAll(arrayList);
            arrayList4.addAll(arrayList2);
            StringBuilder sb9 = new StringBuilder();
            sb9.append("特殊属性（对齐前）：");
            sb9.append(arrayList4.size());
            g(arrayList4, 163);
            StringBuilder sb10 = new StringBuilder();
            sb10.append("特殊属性（对齐后）：");
            sb10.append(arrayList4.size());
            arrayList4.addAll(arrayList14);
            arrayList4.addAll(arrayList15);
            StringBuilder sb11 = new StringBuilder();
            sb11.append("普通属性（对齐前）：");
            sb11.append(arrayList4.size());
            g(arrayList4, 403);
            StringBuilder sb12 = new StringBuilder();
            sb12.append("普通属性（对齐后）：");
            sb12.append(arrayList4.size());
            arrayList4.addAll(listI);
            StringBuilder sb13 = new StringBuilder();
            sb13.append("宏按键（对齐前）：");
            sb13.append(arrayList4.size());
            g(arrayList4, 883);
            StringBuilder sb14 = new StringBuilder();
            sb14.append("宏按键（对齐后）：");
            sb14.append(arrayList4.size());
        } else {
            if (!arrayList.isEmpty()) {
                StringBuilder sb15 = new StringBuilder();
                sb15.append("特殊属性（对齐前）：");
                sb15.append(arrayList4.size());
                arrayList4.addAll(arrayList);
            }
            if (!arrayList14.isEmpty()) {
                g(arrayList4, 114);
                StringBuilder sb16 = new StringBuilder();
                sb16.append("特殊属性（对齐后）：");
                sb16.append(arrayList4.size());
                arrayList4.addAll(arrayList14);
                StringBuilder sb17 = new StringBuilder();
                sb17.append("普通属性（对齐前）：");
                sb17.append(arrayList4.size());
            }
            if (!listI.isEmpty()) {
                StringBuilder sb18 = new StringBuilder();
                sb18.append("普通属性（对齐后）：");
                sb18.append(arrayList4.size());
                g(arrayList4, 274);
                arrayList4.addAll(listI);
                StringBuilder sb19 = new StringBuilder();
                sb19.append("宏按键（对齐前）：");
                sb19.append(arrayList4.size());
            }
            if (!arrayList2.isEmpty()) {
                g(arrayList4, f11372p);
                StringBuilder sb20 = new StringBuilder();
                sb20.append("宏按键（对齐后）：");
                sb20.append(arrayList4.size());
                arrayList4.addAll(arrayList2);
                StringBuilder sb21 = new StringBuilder();
                sb21.append("特殊属性扩容（对齐前）：");
                sb21.append(arrayList4.size());
            }
            if (!arrayList15.isEmpty()) {
                g(arrayList4, f11373q);
                StringBuilder sb22 = new StringBuilder();
                sb22.append("特殊属性扩容（对齐后）：");
                sb22.append(arrayList4.size());
                arrayList4.addAll(arrayList15);
                StringBuilder sb23 = new StringBuilder();
                sb23.append("普通属性扩容（对齐前）：");
                sb23.append(arrayList4.size());
            }
            if (!arrayList9.isEmpty()) {
                String firmwareVersion = gamepadInfo.getFirmwareVersion();
                Objects.requireNonNull(firmwareVersion);
                if (l9.c.b(k.f40830p, firmwareVersion)) {
                    g(arrayList4, f11374r);
                    arrayList4.addAll(arrayList9);
                }
            }
        }
        StringBuilder sb24 = new StringBuilder();
        sb24.append("总长度：");
        sb24.append(arrayList4.size());
        return arrayList4;
    }

    public static synchronized byte[] b(CFGEntity cFGEntity, FloatWindowSizeBean floatWindowSizeBean, GamepadInfo gamepadInfo, int i10) {
        List<Byte> listA;
        listA = a(cFGEntity, gamepadInfo, floatWindowSizeBean, i10, true);
        listA.add(0, Byte.valueOf(l.f36952t));
        f(listA, 899);
        return com.blankj.utilcode.util.e.A2((Byte[]) listA.toArray(new Byte[listA.size()]));
    }

    public static synchronized List<byte[]> c(CFGEntity cFGEntity, GamepadInfo gamepadInfo, FloatWindowSizeBean floatWindowSizeBean, int i10) {
        ArrayList arrayList;
        List<Byte> listA = a(cFGEntity, gamepadInfo, floatWindowSizeBean, i10, false);
        if (!t.d(gamepadInfo) && listA.size() > 754) {
            listA = listA.subList(0, f11372p);
        }
        e(listA);
        List listA2 = p9.a.a(listA, 16);
        arrayList = new ArrayList();
        arrayList.add(m9.e.w(true));
        for (int i11 = 0; i11 < listA2.size(); i11++) {
            arrayList.add(m9.e.z((List) listA2.get(i11), i11 / 8, i11 % 8));
        }
        arrayList.add(m9.e.w(false));
        return arrayList;
    }

    public static List<Byte> d(@n0 List<Byte> list, int i10) {
        byte b10 = list.size() == 0 ? (byte) -1 : (byte) 0;
        while (list.size() < i10) {
            list.add(Byte.valueOf(b10));
        }
        return list;
    }

    public static void e(List<Byte> list) {
        if (list.size() % 16 != 0) {
            g(list, ((list.size() / 16) + 1) * 16);
        }
    }

    public static List<Byte> f(@n0 List<Byte> list, int i10) {
        while (list.size() < i10) {
            list.add((byte) 0);
        }
        return list;
    }

    public static List<Byte> g(@n0 List<Byte> list, int i10) {
        while (list.size() < i10) {
            list.add((byte) -1);
        }
        return list;
    }

    public static ArrayList<Byte> h(byte[] bArr, int i10, int i11) {
        ArrayList<Byte> arrayList = new ArrayList<>(16);
        arrayList.add((byte) -3);
        if (i10 == 1) {
            arrayList.add((byte) -69);
        } else {
            arrayList.add((byte) -52);
        }
        arrayList.add((byte) 86);
        arrayList.add(Byte.valueOf(tc.a.f51065w));
        for (int i12 = 0; i12 < 12; i12++) {
            if (i12 < bArr.length) {
                arrayList.add(Byte.valueOf(bArr[i12]));
            } else {
                arrayList.add((byte) 0);
            }
        }
        arrayList.set(15, Byte.valueOf((byte) i11));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.Byte> i(com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r23, float r24, int r25, int r26, int r27, int r28, com.flydigi.sdk.gamepad.GamepadInfo r29) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.motionelf.tools.a.i(com.flydigi.sdk.gamepad.extension.config.data.CFGEntity, float, int, int, int, int, com.flydigi.sdk.gamepad.GamepadInfo):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6 A[PHI: r5
  0x00d6: PHI (r5v5 int) = (r5v4 int), (r5v4 int), (r5v4 int), (r5v4 int), (r5v21 int), (r5v26 int), (r5v26 int) binds: [B:17:0x0047, B:19:0x0053, B:40:0x00c2, B:42:0x00c6, B:47:0x00d2, B:38:0x00b2, B:37:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0123 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.Byte> j(com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r9, com.flydigi.sdk.gamepad.GamepadInfo r10, java.util.List<java.lang.Byte> r11) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.motionelf.tools.a.j(com.flydigi.sdk.gamepad.extension.config.data.CFGEntity, com.flydigi.sdk.gamepad.GamepadInfo, java.util.List):java.util.List");
    }

    public static ArrayList<Byte> k(GamepadInfo gamepadInfo, CFGPropertyJS cFGPropertyJS, float f10, int i10, int i11, int i12, int i13) {
        int i14;
        ArrayList<Byte> arrayList = new ArrayList<>();
        if (cFGPropertyJS != null) {
            int iA = h.a(cFGPropertyJS.type);
            arrayList.add(Byte.valueOf((byte) iA));
            arrayList.add(Byte.valueOf(f.e(cFGPropertyJS.f16345x, i12, i10, gamepadInfo.isFlashplayMode())));
            arrayList.add(Byte.valueOf(f.f(cFGPropertyJS.f16346y, i13, i11, gamepadInfo.isFlashplayMode())));
            if (iA == 10) {
                arrayList.add(Byte.valueOf((byte) (cFGPropertyJS.radius / f10)));
                arrayList.add(Byte.valueOf((byte) cFGPropertyJS.radius));
                int i15 = cFGPropertyJS.start_delay;
                if (i15 < 0) {
                    arrayList.add((byte) 0);
                } else {
                    arrayList.add(Byte.valueOf((byte) i15));
                }
                int i16 = cFGPropertyJS.edge_dframe;
                if (i16 < 0) {
                    arrayList.add((byte) 0);
                } else {
                    arrayList.add(Byte.valueOf((byte) i16));
                }
                if (gamepadInfo.isGamepadKeyboard() && cFGPropertyJS.key_id == 240 && (i14 = cFGPropertyJS.js_mode) != -1) {
                    arrayList.add(Byte.valueOf((byte) i14));
                } else {
                    arrayList.add((byte) 0);
                }
                int i17 = cFGPropertyJS.ban;
                if (i17 > 0) {
                    arrayList.add(Byte.valueOf((byte) i17));
                } else {
                    arrayList.add((byte) 0);
                }
            } else if (iA == 11) {
                int i18 = cFGPropertyJS.senty_x;
                int iMin = (int) Math.min(cFGPropertyJS.senty_y * f10, 127.0f);
                int i19 = cFGPropertyJS.reverse_type;
                if (i19 == 3) {
                    i18 = -i18;
                } else {
                    if (i19 == 1) {
                        i18 = -i18;
                    } else if (i19 == 2) {
                    }
                    arrayList.add(Byte.valueOf((byte) i18));
                    arrayList.add(Byte.valueOf((byte) iMin));
                }
                iMin = -iMin;
                arrayList.add(Byte.valueOf((byte) i18));
                arrayList.add(Byte.valueOf((byte) iMin));
            } else if (iA == 14) {
                arrayList.add((byte) 0);
                arrayList.add((byte) 0);
                int i20 = cFGPropertyJS.start_delay;
                if (i20 < 0) {
                    arrayList.add((byte) 0);
                } else {
                    arrayList.add(Byte.valueOf((byte) i20));
                }
                int i21 = cFGPropertyJS.edge_dframe;
                if (i21 < 0) {
                    arrayList.add((byte) 0);
                } else {
                    arrayList.add(Byte.valueOf((byte) i21));
                }
                arrayList.add((byte) 0);
                int i22 = cFGPropertyJS.ban;
                if (i22 > 0) {
                    arrayList.add(Byte.valueOf((byte) i22));
                } else {
                    arrayList.add((byte) 0);
                }
            } else if (iA == 13) {
                arrayList.add(Byte.valueOf((byte) (cFGPropertyJS.radius / f10)));
                arrayList.add(Byte.valueOf((byte) cFGPropertyJS.radius));
            }
        }
        d(arrayList, 9);
        return arrayList;
    }

    public static void l(GamepadInfo gamepadInfo) {
        if (gamepadInfo.isDriverConnected() || l9.c.b(k.f40818d, gamepadInfo.getFirmwareVersion())) {
            f11375s = 60;
        } else {
            f11375s = 40;
        }
    }

    public static void m(ArrayList<CFGPropertyJS> arrayList, GamepadInfo gamepadInfo, float f10, int i10, int i11, int i12, int i13, List<Byte> list, List<Byte> list2, List<Byte> list3, List<Byte> list4, List<Byte> list5) {
        for (CFGPropertyJS cFGPropertyJS : arrayList) {
            int i14 = cFGPropertyJS.key_id;
            if (i14 == 240) {
                if (cFGPropertyJS.type == 2 && gamepadInfo.isFlashplayMode() && l9.c.b(k.f40828n, gamepadInfo.getFirmwareVersion()) && !l9.c.b(k.f40830p, gamepadInfo.getFirmwareVersion())) {
                    cFGPropertyJS.type = 1;
                }
                list.addAll(k(gamepadInfo, cFGPropertyJS, f10, i12, i13, i10, i11));
                int iB = cFGPropertyJS.switchRKey;
                if (iB != -1) {
                    if (!gamepadInfo.isGamepadKeyboard()) {
                        iB = o9.b.b(iB);
                    }
                    list4.add(Byte.valueOf((byte) iB));
                    list4.add((byte) 6);
                    list4.add((byte) 0);
                    list4.add((byte) 0);
                }
                int iB2 = cFGPropertyJS.double_click_key;
                if (iB2 != -1) {
                    if (!gamepadInfo.isGamepadKeyboard()) {
                        iB2 = o9.b.b(iB2);
                    }
                    list5.add(Byte.valueOf((byte) iB2));
                    list5.add((byte) 51);
                    list5.add((byte) 0);
                    list5.add((byte) 0);
                }
            } else if (i14 == 241) {
                list2.addAll(k(gamepadInfo, cFGPropertyJS, f10, i12, i13, i10, i11));
            } else if (i14 == 242 && gamepadInfo.getDeviceType() == 19 && (gamepadInfo.isDriverMode() || l9.c.b(k.f40830p, gamepadInfo.getFirmwareVersion()))) {
                list3.addAll(k(gamepadInfo, cFGPropertyJS, f10, i12, i13, i10, i11));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0595 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014a A[PHI: r12
  0x014a: PHI (r12v6 int) = (r12v5 int), (r12v5 int), (r12v5 int), (r12v5 int), (r12v52 int), (r12v68 int) binds: [B:21:0x00ba, B:23:0x00c6, B:45:0x0136, B:47:0x013a, B:52:0x0146, B:43:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(java.util.ArrayList<com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey> r17, com.flydigi.sdk.gamepad.GamepadInfo r18, float r19, int r20, int r21, int r22, int r23, java.util.List<java.lang.Byte> r24, java.util.List<java.lang.Byte> r25, java.util.List<java.lang.Byte> r26, java.util.List<java.lang.Byte> r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 1436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.motionelf.tools.a.n(java.util.ArrayList, com.flydigi.sdk.gamepad.GamepadInfo, float, int, int, int, int, java.util.List, java.util.List, java.util.List, java.util.List, boolean):void");
    }

    public static void o(List<Byte> list, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            bArr[i10 + i11] = list.get(i11).byteValue();
        }
    }
}
