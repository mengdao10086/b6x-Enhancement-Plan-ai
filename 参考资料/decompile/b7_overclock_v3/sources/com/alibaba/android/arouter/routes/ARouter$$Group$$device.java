package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.DeviceManagerProvider;
import com.flydigi.device_manager.cooperate.cjzc.ui.Activity_CJZC;
import com.flydigi.device_manager.ui.OpenFloatWindowNoticeActivity;
import com.flydigi.device_manager.ui.apex_space.ui.LedSettingActivity;
import com.flydigi.device_manager.ui.connection.EmulatorConnectionActivity;
import com.flydigi.device_manager.ui.connection.KeyboardMouseConnectGuideActivity;
import com.flydigi.device_manager.ui.detail.DetailActivity;
import com.flydigi.device_manager.ui.detail.waspwing.WaspwingUpgradeActivity;
import com.flydigi.device_manager.ui.detail.waspwing.b6.temperature.TargetTemperatureActivity;
import com.flydigi.device_manager.ui.device_list.DeviceListActivity;
import com.flydigi.device_manager.ui.diagnose.DiagnoseActivity;
import com.flydigi.device_manager.ui.driver_active.DriverActivationActivity;
import com.flydigi.device_manager.ui.firmware.FirmwareUpgradeActivity;
import com.flydigi.device_manager.ui.mapping_test.KeyMappingTestActivity;
import com.flydigi.device_manager.ui.remove_bond.RemoveBondActivity;
import com.flydigi.device_manager.ui.setting.GameSettingActivity;
import com.flydigi.device_manager.ui.sync.SyncConfigActivity;
import i9.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$device implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(a.d.f31950f, RouteMeta.build(routeType, DriverActivationActivity.class, a.d.f31950f, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.1
            {
                put(DataConstant.DEVICE_KEY_ACTIVATION_FAILED, 0);
                put(DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK, 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31956l, RouteMeta.build(routeType, LedSettingActivity.class, a.d.f31956l, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31947c, RouteMeta.build(routeType, DeviceListActivity.class, a.d.f31947c, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31948d, RouteMeta.build(routeType, EmulatorConnectionActivity.class, a.d.f31948d, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31949e, RouteMeta.build(routeType, DetailActivity.class, a.d.f31949e, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.2
            {
                put(DataConstant.DEVICE_KEY_AUTO_CONNECT, 0);
                put("key_device_info", 10);
                put("key_device_code", 8);
                put(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE, 0);
                put(DataConstant.DEVICE_KEY_DEVICE_TYPE, 3);
                put("ip_type", 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31961q, RouteMeta.build(routeType, DiagnoseActivity.class, a.d.f31961q, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31952h, RouteMeta.build(routeType, FirmwareUpgradeActivity.class, a.d.f31952h, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.3
            {
                put(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, 0);
                put("key_device_code", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31953i, RouteMeta.build(routeType, WaspwingUpgradeActivity.class, a.d.f31953i, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.4
            {
                put(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, 0);
                put("key_device_code", 8);
                put("key_device_address", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31955k, RouteMeta.build(routeType, KeyboardMouseConnectGuideActivity.class, a.d.f31955k, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.5
            {
                put("type", 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31954j, RouteMeta.build(routeType, KeyMappingTestActivity.class, a.d.f31954j, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.6
            {
                put("key_device_info", 10);
                put("key_device_code", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31959o, RouteMeta.build(routeType, OpenFloatWindowNoticeActivity.class, a.d.f31959o, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.7
            {
                put(DataConstant.DEVICE_KEY_CAN_JUMP, 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31946b, RouteMeta.build(RouteType.PROVIDER, DeviceManagerProvider.class, a.d.f31946b, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31960p, RouteMeta.build(routeType, Activity_CJZC.class, a.d.f31960p, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.8
            {
                put("package_name", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(a.d.f31951g, RouteMeta.build(routeType, RemoveBondActivity.class, a.d.f31951g, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31957m, RouteMeta.build(routeType, GameSettingActivity.class, a.d.f31957m, "device", null, -1, Integer.MIN_VALUE));
        map.put(a.d.f31958n, RouteMeta.build(routeType, SyncConfigActivity.class, a.d.f31958n, "device", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$device.9
            {
                put(a.d.f31963s, 0);
            }
        }, -1, 10000000));
        map.put(a.d.f31962r, RouteMeta.build(routeType, TargetTemperatureActivity.class, a.d.f31962r, "device", null, -1, Integer.MIN_VALUE));
    }
}
