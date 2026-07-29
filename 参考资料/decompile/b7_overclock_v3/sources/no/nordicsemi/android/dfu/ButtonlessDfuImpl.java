package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import ee.a;
import g.n0;
import java.util.Locale;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* JADX INFO: loaded from: classes5.dex */
abstract class ButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1};
    private static final int OP_CODE_ENTER_BOOTLOADER_KEY = 1;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 32;

    public ButtonlessDfuImpl(@n0 final Intent intent, @n0 final DfuBaseService service) {
        super(intent, service);
    }

    private int getStatusCode(final byte[] response, final int request) throws UnknownResponseException {
        if (response != null && response.length >= 3 && response[0] == 32 && response[1] == request && (response[2] == 1 || response[2] == 2 || response[2] == 4)) {
            return response[2];
        }
        throw new UnknownResponseException("Invalid response received", response, 32, request);
    }

    public abstract BluetoothGattCharacteristic getButtonlessDfuCharacteristic();

    public abstract int getResponseType();

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(@n0 final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        byte[] notificationResponse;
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGatt bluetoothGatt = this.mGatt;
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        BluetoothGattCharacteristic buttonlessDfuCharacteristic = getButtonlessDfuCharacteristic();
        int responseType = getResponseType();
        enableCCCD(buttonlessDfuCharacteristic, getResponseType());
        DfuBaseService dfuBaseService = this.mService;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(responseType == 2 ? "Indications" : "Notifications");
        sb2.append(" enabled");
        dfuBaseService.sendLogBroadcast(10, sb2.toString());
        this.mService.waitFor(1000);
        try {
            this.mProgressInfo.setProgress(-3);
            logi("Sending Enter Bootloader (Op Code = 1)");
            writeOpCode(buttonlessDfuCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
            this.mService.sendLogBroadcast(10, "Enter bootloader sent (Op Code = 1)");
            try {
                notificationResponse = readNotificationResponse();
            } catch (DeviceDisconnectedException unused) {
                notificationResponse = this.mReceivedData;
            }
            if (notificationResponse != null) {
                int statusCode = getStatusCode(notificationResponse, 1);
                logi("Response received (Op Code = " + ((int) notificationResponse[1]) + ", Status = " + statusCode + a.f26979d);
                this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse[1]) + ", Status = " + statusCode + a.f26979d);
                if (statusCode != 1) {
                    throw new RemoteDfuException("Device returned error after sending Enter Bootloader", statusCode);
                }
                this.mService.waitUntilDisconnected();
            } else {
                logi("Device disconnected before receiving notification");
            }
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
            finalize(intent, false, shouldScanForBootloader());
        } catch (RemoteDfuException e10) {
            int errorNumber = e10.getErrorNumber() | 2048;
            loge(e10.getMessage());
            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", SecureDfuError.parseButtonlessError(errorNumber)));
            this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
        } catch (UnknownResponseException e11) {
            loge(e11.getMessage());
            this.mService.sendLogBroadcast(20, e11.getMessage());
            this.mService.terminateConnection(bluetoothGatt, 4104);
        }
    }

    public abstract boolean shouldScanForBootloader();
}
