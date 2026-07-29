package no.nordicsemi.android.dfu.internal.scanner;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(21)
public class BootloaderScannerLollipop extends ScanCallback implements BootloaderScanner {
    private String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(final int callbackType, final ScanResult result) {
        String address = result.getDevice().getAddress();
        if (this.mDeviceAddress.equals(address) || this.mDeviceAddressIncremented.equals(address)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    @Override // no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner
    public String searchFor(final String deviceAddress) {
        BluetoothLeScanner bluetoothLeScanner;
        String strSubstring = deviceAddress.substring(0, 15);
        String str = String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(deviceAddress.substring(15), 16).intValue() + 1) & 255));
        this.mDeviceAddress = deviceAddress;
        this.mDeviceAddressIncremented = strSubstring + str;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new Runnable() { // from class: no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerLollipop.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException unused) {
                }
                if (BootloaderScannerLollipop.this.mFound) {
                    return;
                }
                BootloaderScannerLollipop.this.mBootloaderAddress = null;
                BootloaderScannerLollipop.this.mFound = true;
                synchronized (BootloaderScannerLollipop.this.mLock) {
                    BootloaderScannerLollipop.this.mLock.notifyAll();
                }
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12 || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return null;
        }
        bluetoothLeScanner.startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        bluetoothLeScanner.stopScan(this);
        return this.mBootloaderAddress;
    }
}
