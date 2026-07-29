package org.bouncycastle.est;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ESTException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f44771a = 8192;
    private InputStream body;
    private Throwable cause;
    private int statusCode;

    public ESTException(String str) {
        this(str, null);
    }

    public ESTException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
        this.body = null;
        this.statusCode = 0;
    }

    public ESTException(String str, Throwable th2, int i10, InputStream inputStream) {
        super(str);
        this.cause = th2;
        this.statusCode = i10;
        if (inputStream == null) {
            this.body = null;
            return;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i11 = inputStream.read(bArr);
                if (i11 < 0) {
                    break;
                }
                if (byteArrayOutputStream.size() + i11 > 8192) {
                    byteArrayOutputStream.write(bArr, 0, 8192 - byteArrayOutputStream.size());
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i11);
            } catch (Exception unused) {
                return;
            }
        }
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        this.body = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        inputStream.close();
    }

    public InputStream a() {
        return this.body;
    }

    public int b() {
        return this.statusCode;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " HTTP Status Code: " + this.statusCode;
    }
}
