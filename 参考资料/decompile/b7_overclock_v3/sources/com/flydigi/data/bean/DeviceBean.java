package com.flydigi.data.bean;

import g.v;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceBean {

    @v
    private int deviceBgPic;
    private String deviceCode;

    @v
    private int devicePic;
    private String deviceShortName;

    public boolean equals(final Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        DeviceBean deviceBean = (DeviceBean) o10;
        return this.devicePic == deviceBean.devicePic && this.deviceBgPic == deviceBean.deviceBgPic && Objects.equals(this.deviceCode, deviceBean.deviceCode) && Objects.equals(this.deviceShortName, deviceBean.deviceShortName);
    }

    public int getDeviceBgPic() {
        return this.deviceBgPic;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public int getDevicePic() {
        return this.devicePic;
    }

    public String getDeviceShortName() {
        return this.deviceShortName;
    }

    public int hashCode() {
        return Objects.hash(this.deviceCode, this.deviceShortName, Integer.valueOf(this.devicePic), Integer.valueOf(this.deviceBgPic));
    }

    public DeviceBean setDeviceBgPic(final int deviceBgPic) {
        this.deviceBgPic = deviceBgPic;
        return this;
    }

    public DeviceBean setDeviceCode(final String deviceCode) {
        this.deviceCode = deviceCode;
        return this;
    }

    public DeviceBean setDevicePic(@v final int devicePic) {
        this.devicePic = devicePic;
        return this;
    }

    public DeviceBean setDeviceShortName(final String deviceShortName) {
        this.deviceShortName = deviceShortName;
        return this;
    }
}
