package no.nordicsemi.android.dfu.internal.scanner;

/* JADX INFO: loaded from: classes5.dex */
public class BootloaderScannerFactory {
    public static BootloaderScanner getScanner() {
        return new BootloaderScannerLollipop();
    }
}
