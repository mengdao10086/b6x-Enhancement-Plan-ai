package a8;

import android.content.Context;
import b8.g;
import b8.h;
import c8.f;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import h8.i;
import h8.j;
import h8.l;
import hk.m;
import j8.e;
import kotlin.jvm.internal.f0;
import v7.a;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final d f306a = new d();

    @m
    @k
    public static final j8.a a(int i10, @k Context context, @k GamepadInfo deviceInfo) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        if (i10 == 100) {
            return new k8.a(context, deviceInfo);
        }
        if (i10 == 311) {
            return new l8.a(context, deviceInfo);
        }
        if (i10 == 300) {
            return new l8.b(context, deviceInfo);
        }
        if (i10 == 301) {
            return new l8.c(context, deviceInfo);
        }
        switch (i10) {
        }
        return new k8.a(context, deviceInfo);
    }

    @m
    public static final int b(@k CFGSubPropertyMacro property, @k GamepadInfo deviceInfo) {
        f0.p(property, "property");
        f0.p(deviceInfo, "deviceInfo");
        int type = property.getType();
        if (type == 1) {
            return 100;
        }
        if (type != 2) {
            if (type == 5) {
                return 300;
            }
            if (type != 6) {
                return type != 12 ? -1 : 311;
            }
            return 301;
        }
        int angle = property.getAngle();
        if (angle == 0) {
            return 400;
        }
        if (angle == 45) {
            return a.c.D;
        }
        if (angle == 90) {
            return 403;
        }
        if (angle == 135) {
            return a.c.F;
        }
        if (angle == 180) {
            return 401;
        }
        if (angle == 225) {
            return 406;
        }
        if (angle == 270) {
            return 402;
        }
        if (angle != 315) {
            return -1;
        }
        return a.c.C;
    }

    @m
    public static final void c(@k GamepadInfo deviceInfo, @k b listener) {
        f0.p(deviceInfo, "deviceInfo");
        f0.p(listener, "listener");
        a eVar = deviceInfo.isGamepadWhole() ? new e(deviceInfo) : deviceInfo.isGamepadHalf() ? new j8.c(deviceInfo) : deviceInfo.isGamepadKeyboard() ? new j8.d(deviceInfo) : null;
        if (eVar != null) {
            eVar.a(listener);
        }
    }

    @m
    public static final int d(@k CFGPropertyJS property, @k GamepadInfo deviceInfo) {
        f0.p(property, "property");
        f0.p(deviceInfo, "deviceInfo");
        return property.type;
    }

    @m
    @k
    public static final b8.a e(int i10, @k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 6 ? i10 != 11 ? new c8.e(context, deviceInfo, property) : new c8.d(context, deviceInfo, property) : new c8.a(context, deviceInfo, property) : new c8.b(context, deviceInfo, property) : new c8.c(context, deviceInfo, property) : deviceInfo.isGamepadKeyboard() ? new f(context, deviceInfo, property) : new c8.e(context, deviceInfo, property);
    }

    @m
    public static final void f(@k GamepadInfo deviceInfo, @k CFGPropertyJS key, @k b listener) {
        f0.p(deviceInfo, "deviceInfo");
        f0.p(key, "key");
        f0.p(listener, "listener");
        a gVar = deviceInfo.isGamepadWhole() ? new g(deviceInfo, key) : deviceInfo.isGamepadKeyboard() ? new h(deviceInfo, key) : deviceInfo.isGamepadHalf() ? new b8.f(deviceInfo, key) : null;
        if (gVar != null) {
            gVar.a(listener);
        }
    }

    @m
    @k
    public static final d8.a g(int i10, @k Context context, @k GamepadInfo deviceInfo) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        if (i10 == 104) {
            return new f8.d(context, deviceInfo);
        }
        if (i10 == 500) {
            return new e8.a(context, deviceInfo);
        }
        if (i10 == 206) {
            return new g8.f(context, deviceInfo);
        }
        if (i10 == 207) {
            return new g8.d(context, deviceInfo);
        }
        switch (i10) {
            case 100:
                return new f8.b(context, deviceInfo);
            case 101:
                return new f8.a(context, deviceInfo);
            case 102:
                return new f8.c(context, deviceInfo);
            default:
                switch (i10) {
                    case 200:
                        return new g8.g(context, deviceInfo);
                    case 201:
                        return new g8.e(context, deviceInfo);
                    case a.c.f52772h /* 202 */:
                        return new g8.b(context, deviceInfo);
                    case a.c.f52773i /* 203 */:
                        return new g8.c(context, deviceInfo);
                    case a.c.f52774j /* 204 */:
                        return new g8.h(context, deviceInfo);
                    default:
                        switch (i10) {
                            case 300:
                                return new h8.e(context, deviceInfo);
                            case 301:
                                return new i(context, deviceInfo);
                            case 302:
                                return new h8.b(context, deviceInfo);
                            case 303:
                                return new h8.c(context, deviceInfo);
                            case 304:
                                return new h8.g(context, deviceInfo);
                            case 305:
                                return new h8.a(context, deviceInfo);
                            case 306:
                                return new h8.f(context, deviceInfo);
                            case 307:
                                return new h8.d(context, deviceInfo);
                            case 308:
                                return new h8.h(context, deviceInfo);
                            case 309:
                                return new l(context, deviceInfo);
                            case 310:
                                return new j(context, deviceInfo);
                            default:
                                switch (i10) {
                                    case 400:
                                        return new i8.h(context, deviceInfo);
                                    case 401:
                                        return new i8.a(context, deviceInfo);
                                    case 402:
                                        return new i8.c(context, deviceInfo);
                                    case 403:
                                        return new i8.f(context, deviceInfo);
                                    case a.c.C /* 404 */:
                                        return new i8.d(context, deviceInfo);
                                    case a.c.D /* 405 */:
                                        return new i8.g(context, deviceInfo);
                                    case 406:
                                        return new i8.b(context, deviceInfo);
                                    case a.c.F /* 407 */:
                                        return new i8.e(context, deviceInfo);
                                    default:
                                        return new f8.b(context, deviceInfo);
                                }
                        }
                }
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @hk.m
    public static final int h(@yt.k com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey r3, @yt.k com.flydigi.sdk.gamepad.GamepadInfo r4) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.d.h(com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey, com.flydigi.sdk.gamepad.GamepadInfo):int");
    }

    @m
    public static final void i(@k GamepadInfo deviceInfo, @k b listener) {
        f0.p(deviceInfo, "deviceInfo");
        f0.p(listener, "listener");
        a fVar = deviceInfo.isGamepadWhole() ? new d8.f(deviceInfo) : deviceInfo.isGamepadKeyboard() ? new d8.g(deviceInfo) : deviceInfo.isGamepadHalf() ? new d8.e(deviceInfo) : null;
        if (fVar != null) {
            fVar.a(listener);
        }
    }
}
