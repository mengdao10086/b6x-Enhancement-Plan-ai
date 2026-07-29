package com.flydigi.sdk.bluetooth.ota;

/* JADX INFO: loaded from: classes3.dex */
public enum OtaStatus {
    ERR_DEVICE_NOT_CONNECTED(16),
    ERR_FIRMWARE_NOT_FOUND(17),
    ERR_DEVICE_NOT_PREPARED(18),
    ERR_OTA_FAILED(19);

    private final int code;

    OtaStatus(int i10) {
        this.code = i10;
    }
}
