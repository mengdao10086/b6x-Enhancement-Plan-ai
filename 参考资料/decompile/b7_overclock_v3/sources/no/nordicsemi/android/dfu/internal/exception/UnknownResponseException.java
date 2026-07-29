package no.nordicsemi.android.dfu.internal.exception;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class UnknownResponseException extends Exception {
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = -8716125467309979289L;
    private final int mExpectedOpCode;
    private final int mExpectedReturnCode;
    private final byte[] mResponse;

    public UnknownResponseException(final String message, final byte[] response, final int expectedReturnCode, final int expectedOpCode) {
        super(message);
        this.mResponse = response == null ? new byte[0] : response;
        this.mExpectedReturnCode = expectedReturnCode;
        this.mExpectedOpCode = expectedOpCode;
    }

    public static String bytesToHex(final byte[] bytes, final int start, final int length) {
        if (bytes == null || bytes.length <= start || length <= 0) {
            return "";
        }
        int iMin = Math.min(length, bytes.length - start);
        char[] cArr = new char[iMin * 2];
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = bytes[start + i10] & 255;
            int i12 = i10 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
        }
        return "0x" + new String(cArr);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Locale locale = Locale.US;
        byte[] bArr = this.mResponse;
        return String.format(locale, "%s (response: %s, expected: 0x%02X%02X..)", super.getMessage(), bytesToHex(bArr, 0, bArr.length), Integer.valueOf(this.mExpectedReturnCode), Integer.valueOf(this.mExpectedOpCode));
    }
}
