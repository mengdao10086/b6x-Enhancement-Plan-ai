package m3;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.CheckPhoneSupportBean;
import com.flydigi.data.bean.DeviceListBean;
import com.flydigi.data.bean.KeyPropertyData;
import h5.c;
import h5.d;
import lj.b;
import m5.c0;
import m5.f0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final d f40636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final c f40637b;

    public a() {
        Object objG = f0.i().k().g(d.class);
        kotlin.jvm.internal.f0.o(objG, "getInstance().retrofit.c…inApiService::class.java)");
        this.f40636a = (d) objG;
        Object objG2 = f0.i().k().g(c.class);
        kotlin.jvm.internal.f0.o(objG2, "getInstance().retrofit.c…taApiService::class.java)");
        this.f40637b = (c) objG2;
    }

    @k
    public final z<CheckPhoneSupportBean> a() {
        z<CheckPhoneSupportBean> zVarJ5 = this.f40636a.C().s0(c0.p()).J5(b.d());
        kotlin.jvm.internal.f0.o(zVarJ5, "service.checkFlashplaySu…scribeOn(Schedulers.io())");
        return zVarJ5;
    }

    @k
    public final z<DeviceListBean> b(long j10) {
        z<DeviceListBean> zVarJ5 = this.f40636a.s(j10).s0(c0.p()).J5(b.d());
        kotlin.jvm.internal.f0.o(zVarJ5, "service.getDeviceList(ve…scribeOn(Schedulers.io())");
        return zVarJ5;
    }

    @k
    public final z<KeyPropertyData> c(@k String packageNameList, long j10) {
        kotlin.jvm.internal.f0.p(packageNameList, "packageNameList");
        z<KeyPropertyData> zVarJ5 = this.f40636a.F(packageNameList, j10).s0(c0.p()).J5(b.d());
        kotlin.jvm.internal.f0.o(zVarJ5, "service.getKeyProperty(p…scribeOn(Schedulers.io())");
        return zVarJ5;
    }

    @k
    public final z<BaseResponse<Object>> d() {
        z<BaseResponse<Object>> zVarJ5 = this.f40636a.D().s0(c0.r()).J5(b.d());
        kotlin.jvm.internal.f0.o(zVarJ5, "service.minVersionForGam…scribeOn(Schedulers.io())");
        return zVarJ5;
    }

    @k
    public final z<BaseResponse<Object>> e(@k String appId, @k String deviceId, @k String deviceName, @k String connectType, @k String driverVersion, @k String firmwareVersion, @k String appPkgName, @k String sysVersion, @k String manufacture, @k String model) {
        kotlin.jvm.internal.f0.p(appId, "appId");
        kotlin.jvm.internal.f0.p(deviceId, "deviceId");
        kotlin.jvm.internal.f0.p(deviceName, "deviceName");
        kotlin.jvm.internal.f0.p(connectType, "connectType");
        kotlin.jvm.internal.f0.p(driverVersion, "driverVersion");
        kotlin.jvm.internal.f0.p(firmwareVersion, "firmwareVersion");
        kotlin.jvm.internal.f0.p(appPkgName, "appPkgName");
        kotlin.jvm.internal.f0.p(sysVersion, "sysVersion");
        kotlin.jvm.internal.f0.p(manufacture, "manufacture");
        kotlin.jvm.internal.f0.p(model, "model");
        z<BaseResponse<Object>> zVarJ5 = this.f40637b.b(appId, deviceId, deviceName, connectType, driverVersion, firmwareVersion, appPkgName, sysVersion, manufacture, model).s0(c0.r()).J5(b.d());
        kotlin.jvm.internal.f0.o(zVarJ5, "dataService.appStartData…scribeOn(Schedulers.io())");
        return zVarJ5;
    }
}
