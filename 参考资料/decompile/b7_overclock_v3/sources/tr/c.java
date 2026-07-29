package tr;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class c extends FilterInputStream {
    public c(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10;
        int i11;
        int i12 = ((FilterInputStream) this).in.read();
        if (i12 == -1) {
            return -1;
        }
        while (i12 == 61) {
            int i13 = ((FilterInputStream) this).in.read();
            if (i13 == -1) {
                throw new IllegalStateException("Quoted '=' at end of stream");
            }
            if (i13 == 13) {
                i12 = ((FilterInputStream) this).in.read();
                if (i12 == 10) {
                }
            } else if (i13 != 10) {
                if (i13 >= 48 && i13 <= 57) {
                    i10 = i13 - 48;
                } else {
                    if (i13 < 65 || i13 > 70) {
                        throw new IllegalStateException("Expecting '0123456789ABCDEF after quote that was not immediately followed by LF or CRLF");
                    }
                    i10 = (i13 - 65) + 10;
                }
                int i14 = i10 << 4;
                int i15 = ((FilterInputStream) this).in.read();
                if (i15 >= 48 && i15 <= 57) {
                    i11 = i15 - 48;
                } else {
                    if (i15 < 65 || i15 > 70) {
                        throw new IllegalStateException("Expecting second '0123456789ABCDEF after quote that was not immediately followed by LF or CRLF");
                    }
                    i11 = (i15 - 65) + 10;
                }
                return i14 | i11;
            }
            i12 = ((FilterInputStream) this).in.read();
        }
        return i12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 != i11) {
            int i13 = read();
            if (i13 < 0) {
                break;
            }
            bArr[i12 + i10] = (byte) i13;
            i12++;
        }
        if (i12 == 0) {
            return -1;
        }
        return i12;
    }
}
