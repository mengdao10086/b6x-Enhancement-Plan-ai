package cp;

/* JADX INFO: loaded from: classes5.dex */
public class p1 extends o1 {
    @Override // cp.o1, org.bouncycastle.crypto.k0
    public String b() {
        return "VMPC-KSA3";
    }

    @Override // cp.o1
    public void c(byte[] bArr, byte[] bArr2) {
        this.f25593c = (byte) 0;
        this.f25592b = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            this.f25592b[i10] = (byte) i10;
        }
        for (int i11 = 0; i11 < 768; i11++) {
            byte[] bArr3 = this.f25592b;
            int i12 = i11 & 255;
            byte b10 = bArr3[(this.f25593c + bArr3[i12] + bArr[i11 % bArr.length]) & 255];
            this.f25593c = b10;
            byte b11 = bArr3[i12];
            bArr3[i12] = bArr3[b10 & 255];
            bArr3[b10 & 255] = b11;
        }
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr4 = this.f25592b;
            int i14 = i13 & 255;
            byte b12 = bArr4[(this.f25593c + bArr4[i14] + bArr2[i13 % bArr2.length]) & 255];
            this.f25593c = b12;
            byte b13 = bArr4[i14];
            bArr4[i14] = bArr4[b12 & 255];
            bArr4[b12 & 255] = b13;
        }
        for (int i15 = 0; i15 < 768; i15++) {
            byte[] bArr5 = this.f25592b;
            int i16 = i15 & 255;
            byte b14 = bArr5[(this.f25593c + bArr5[i16] + bArr[i15 % bArr.length]) & 255];
            this.f25593c = b14;
            byte b15 = bArr5[i16];
            bArr5[i16] = bArr5[b14 & 255];
            bArr5[b14 & 255] = b15;
        }
        this.f25591a = (byte) 0;
    }
}
