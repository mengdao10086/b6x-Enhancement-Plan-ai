package gm;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class z1 extends o {
    public z1(String str) {
        super(str);
    }

    public z1(Date date) {
        super(date);
    }

    public z1(byte[] bArr) {
        super(bArr);
    }

    @Override // gm.o, gm.c0
    public int A(boolean z10) {
        return b0.i(z10, U().length);
    }

    @Override // gm.o, gm.c0
    public c0 E() {
        return this;
    }

    @Override // gm.o, gm.c0
    public c0 F() {
        return this;
    }

    public final byte[] U() {
        byte[] bArr = this.f29757a;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!Q()) {
            byte[] bArr2 = this.f29757a;
            byte[] bArr3 = new byte[bArr2.length + 4];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(Strings.i("0000Z"), 0, bArr3, this.f29757a.length - 1, 5);
            return bArr3;
        }
        if (!R()) {
            byte[] bArr4 = this.f29757a;
            byte[] bArr5 = new byte[bArr4.length + 2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(Strings.i("00Z"), 0, bArr5, this.f29757a.length - 1, 3);
            return bArr5;
        }
        if (!P()) {
            return this.f29757a;
        }
        int length = this.f29757a.length - 2;
        while (length > 0 && this.f29757a[length] == 48) {
            length--;
        }
        byte[] bArr6 = this.f29757a;
        if (bArr6[length] == 46) {
            byte[] bArr7 = new byte[length + 1];
            System.arraycopy(bArr6, 0, bArr7, 0, length);
            bArr7[length] = 90;
            return bArr7;
        }
        byte[] bArr8 = new byte[length + 2];
        int i10 = length + 1;
        System.arraycopy(bArr6, 0, bArr8, 0, i10);
        bArr8[i10] = 90;
        return bArr8;
    }

    @Override // gm.o, gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 24, U());
    }
}
