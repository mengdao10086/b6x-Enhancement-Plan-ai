package a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class j72 {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        f92.d(inputStream, "$this$copyTo");
        f92.d(outputStream, "out");
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(inputStream, outputStream, i);
    }

    public static final byte[] c(InputStream inputStream) {
        f92.d(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        f92.c(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
