package no.nordicsemi.android.dfu.internal.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class SizeValidationException extends IOException {
    private static final long serialVersionUID = -6467104024030837875L;

    public SizeValidationException(final String message) {
        super(message);
    }
}
