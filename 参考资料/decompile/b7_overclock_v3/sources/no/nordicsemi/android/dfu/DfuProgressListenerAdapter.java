package no.nordicsemi.android.dfu;

import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public class DfuProgressListenerAdapter implements DfuProgressListener {
    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceConnected(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceConnecting(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceDisconnected(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceDisconnecting(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuAborted(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuCompleted(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuProcessStarted(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuProcessStarting(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onEnablingDfuMode(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onError(@n0 final String deviceAddress, final int error, final int errorType, final String message) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onFirmwareValidating(@n0 final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onProgressChanged(@n0 final String deviceAddress, final int percent, final float speed, final float avgSpeed, final int currentPart, final int partsTotal) {
    }
}
