package com.flydigi.device_manager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.FZFragment;
import com.flydigi.baseProvider.IDeviceManagerProvider;
import com.flydigi.device_manager.ui.home.DeviceHomeFragment;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31946b)
public class DeviceManagerProvider extends IDeviceManagerProvider {
    @Override // com.flydigi.baseProvider.IDeviceManagerProvider
    public FZFragment o() {
        return DeviceHomeFragment.d7();
    }
}
