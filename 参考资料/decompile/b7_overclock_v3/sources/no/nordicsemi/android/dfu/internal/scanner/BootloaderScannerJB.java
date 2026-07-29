package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class BootloaderScannerJB implements BootloaderScanner, BluetoothAdapter.LeScanCallback {
    private String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
        String address = device.getAddress();
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
        String strSubstring = deviceAddress.substring(0, 15);
        String str = String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(deviceAddress.substring(15), 16).intValue() + 1) & 255));
        this.mDeviceAddress = deviceAddress;
        this.mDeviceAddressIncremented = strSubstring + str;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new Runnable() { // from class: no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerJB.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException unused) {
                }
                if (BootloaderScannerJB.this.mFound) {
                    return;
                }
                BootloaderScannerJB.this.mBootloaderAddress = null;
                BootloaderScannerJB.this.mFound = true;
                synchronized (BootloaderScannerJB.this.mLock) {
                    BootloaderScannerJB.this.mLock.notifyAll();
                }
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            return null;
        }
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        defaultAdapter.stopLeScan(this);
        return this.mBootloaderAddress;
    }
}
