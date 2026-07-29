package com.umeng.socialize.a;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class l {
    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            gZIPOutputStream.write(bArr);
            c.a(gZIPOutputStream);
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                UMRTLog.e("zip", th.getMessage());
            } finally {
                c.a(gZIPOutputStream2);
            }
        }
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i10 = gZIPInputStream.read(bArr2);
                if (i10 == -1) {
                    c.a(gZIPInputStream);
                    return;
                }
                outputStream.write(bArr2, 0, i10);
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream2 = gZIPInputStream;
            try {
                UMRTLog.e("unzip", th.getMessage());
            } finally {
                c.a(gZIPInputStream2);
            }
        }
    }
}
