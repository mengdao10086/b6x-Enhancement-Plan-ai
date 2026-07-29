package h5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.AppConfigDTO;
import nu.f;
import nu.o;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    @o("https://data.flydigi.com//API/androidData")
    @nu.e
    z<BaseResponse<Object>> a(@nu.c("action") String action, @nu.c("fdgVersion") String fdgVersion, @nu.c("gameName") String gameName, @nu.c("gamepad") String gamepad, @nu.c(com.flydigi.community.ui.search.b.f14046c) String deviceID, @nu.c("manufacture") String manufacture, @nu.c("model") String model, @nu.c("sysVersion") String sysVersion);

    @o("https://data.flydigi.com//api/appstore/start")
    @nu.e
    z<BaseResponse<Object>> b(@nu.c(xf.z.f55306i) String method, @nu.c("deviceMac") String deviceMac, @nu.c("deviceName") String deviceName, @nu.c("connectType") String connectType, @nu.c("driverVersion") String driverVersion, @nu.c("firmwareVersion") String firmwareVersion, @nu.c("appPkgName") String appPkgName, @nu.c("sysVersion") String sysVersion, @nu.c("manufacture") String manufacture, @nu.c("model") String model);

    @o("https://data.flydigi.com//v1/pandora/android_behaviors")
    @nu.e
    z<BaseResponse<Object>> c(@nu.c("event_data") String eventData);

    @f("https://data.flydigi.com//api/config/init")
    z<BaseResponse<AppConfigDTO>> d();
}
