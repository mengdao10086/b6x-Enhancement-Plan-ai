package no.nordicsemi.android.dfu;

import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public interface DfuProgressListener {
    void onDeviceConnected(@n0 final String deviceAddress);

    void onDeviceConnecting(@n0 final String deviceAddress);

    void onDeviceDisconnected(@n0 final String deviceAddress);

    void onDeviceDisconnecting(final String deviceAddress);

    void onDfuAborted(@n0 final String deviceAddress);

    void onDfuCompleted(@n0 final String deviceAddress);

    void onDfuProcessStarted(@n0 final String deviceAddress);

    void onDfuProcessStarting(@n0 final String deviceAddress);

    void onEnablingDfuMode(@n0 final String deviceAddress);

    void onError(@n0 final String deviceAddress, final int error, final int errorType, final String message);

    void onFirmwareValidating(@n0 final String deviceAddress);

    void onProgressChanged(@n0 final String deviceAddress, final int percent, final float speed, final float avgSpeed, final int currentPart, final int partsTotal);
}
