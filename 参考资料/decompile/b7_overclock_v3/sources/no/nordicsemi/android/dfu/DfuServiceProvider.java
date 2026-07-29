package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import g.n0;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes5.dex */
class DfuServiceProvider implements DfuCallback {
    private boolean mAborted;
    private BaseDfuImpl mImpl;
    private boolean mPaused;

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mAborted = true;
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.abort();
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public DfuCallback.DfuGattCallback getGattCallback() {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            return baseDfuImpl.getGattCallback();
        }
        return null;
    }

    public DfuService getServiceImpl(@n0 final Intent intent, @n0 final DfuBaseService service, @n0 final BluetoothGatt gatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BaseDfuImpl baseDfuImpl;
        try {
            ButtonlessDfuWithBondSharingImpl buttonlessDfuWithBondSharingImpl = new ButtonlessDfuWithBondSharingImpl(intent, service);
            this.mImpl = buttonlessDfuWithBondSharingImpl;
            if (buttonlessDfuWithBondSharingImpl.isClientCompatible(intent, gatt)) {
                BaseDfuImpl baseDfuImpl2 = this.mImpl;
                if (baseDfuImpl2 != null) {
                    if (this.mPaused) {
                        baseDfuImpl2.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl2;
            }
            ButtonlessDfuWithoutBondSharingImpl buttonlessDfuWithoutBondSharingImpl = new ButtonlessDfuWithoutBondSharingImpl(intent, service);
            this.mImpl = buttonlessDfuWithoutBondSharingImpl;
            if (buttonlessDfuWithoutBondSharingImpl.isClientCompatible(intent, gatt)) {
                BaseDfuImpl baseDfuImpl3 = this.mImpl;
                if (baseDfuImpl3 != null) {
                    if (this.mPaused) {
                        baseDfuImpl3.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl3;
            }
            SecureDfuImpl secureDfuImpl = new SecureDfuImpl(intent, service);
            this.mImpl = secureDfuImpl;
            if (secureDfuImpl.isClientCompatible(intent, gatt)) {
                BaseDfuImpl baseDfuImpl4 = this.mImpl;
                if (baseDfuImpl4 != null) {
                    if (this.mPaused) {
                        baseDfuImpl4.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl4;
            }
            LegacyButtonlessDfuImpl legacyButtonlessDfuImpl = new LegacyButtonlessDfuImpl(intent, service);
            this.mImpl = legacyButtonlessDfuImpl;
            if (legacyButtonlessDfuImpl.isClientCompatible(intent, gatt)) {
                BaseDfuImpl baseDfuImpl5 = this.mImpl;
                if (baseDfuImpl5 != null) {
                    if (this.mPaused) {
                        baseDfuImpl5.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl5;
            }
            LegacyDfuImpl legacyDfuImpl = new LegacyDfuImpl(intent, service);
            this.mImpl = legacyDfuImpl;
            if (legacyDfuImpl.isClientCompatible(intent, gatt)) {
                BaseDfuImpl baseDfuImpl6 = this.mImpl;
                if (baseDfuImpl6 != null) {
                    if (this.mPaused) {
                        baseDfuImpl6.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl6;
            }
            if (intent.getBooleanExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, false)) {
                ExperimentalButtonlessDfuImpl experimentalButtonlessDfuImpl = new ExperimentalButtonlessDfuImpl(intent, service);
                this.mImpl = experimentalButtonlessDfuImpl;
                if (experimentalButtonlessDfuImpl.isClientCompatible(intent, gatt)) {
                    BaseDfuImpl baseDfuImpl7 = this.mImpl;
                    if (baseDfuImpl7 != null) {
                        if (this.mPaused) {
                            baseDfuImpl7.pause();
                        }
                        if (this.mAborted) {
                            this.mImpl.abort();
                        }
                    }
                    return baseDfuImpl7;
                }
            }
            return null;
        } finally {
            baseDfuImpl = this.mImpl;
            if (baseDfuImpl != null) {
                if (this.mPaused) {
                    baseDfuImpl.pause();
                }
                if (this.mAborted) {
                    this.mImpl.abort();
                }
            }
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(final int state) {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.onBondStateChanged(state);
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
    }
}
