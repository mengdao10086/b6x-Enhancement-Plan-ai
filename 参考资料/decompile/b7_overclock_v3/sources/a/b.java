package a;

import ft.w;
import java.io.IOException;
import java.io.OutputStream;
import okio.w0;
import zc.f;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f4b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', w.f28816e, 'M', 'N', 'O', 'P', 'Q', w.f28818g, 'S', 'T', w.f28817f, 'V', 'W', 'X', 'Y', w.f28814c, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', f.f58380j};

    @Override // a.d
    public int a() {
        return 3;
    }

    @Override // a.d
    public int b() {
        return 57;
    }

    @Override // a.d
    public void h(OutputStream outputStream, byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 1) {
            byte b10 = bArr[i10];
            char[] cArr = f4b;
            outputStream.write(cArr[(b10 >>> 2) & 63]);
            outputStream.write(cArr[((b10 << 4) & 48) + 0]);
            outputStream.write(61);
            outputStream.write(61);
            return;
        }
        if (i11 == 2) {
            byte b11 = bArr[i10];
            byte b12 = bArr[i10 + 1];
            char[] cArr2 = f4b;
            outputStream.write(cArr2[(b11 >>> 2) & 63]);
            outputStream.write(cArr2[((b11 << 4) & 48) + ((b12 >>> 4) & 15)]);
            outputStream.write(cArr2[((b12 << 2) & 60) + 0]);
            outputStream.write(61);
            return;
        }
        byte b13 = bArr[i10];
        byte b14 = bArr[i10 + 1];
        byte b15 = bArr[i10 + 2];
        char[] cArr3 = f4b;
        outputStream.write(cArr3[(b13 >>> 2) & 63]);
        outputStream.write(cArr3[((b13 << 4) & 48) + ((b14 >>> 4) & 15)]);
        outputStream.write(cArr3[((b14 << 2) & 60) + ((b15 >>> 6) & 3)]);
        outputStream.write(cArr3[b15 & w0.f44229a]);
    }
}
