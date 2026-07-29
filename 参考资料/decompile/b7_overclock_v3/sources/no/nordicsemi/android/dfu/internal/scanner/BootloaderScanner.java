package no.nordicsemi.android.dfu.internal.scanner;

import g.p0;

/* JADX INFO: loaded from: classes5.dex */
public interface BootloaderScanner {
    public static final int ADDRESS_DIFF = 1;
    public static final long TIMEOUT = 5000;

    @p0
    String searchFor(final String deviceAddress);
}
