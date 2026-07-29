package a;

import ft.w;
import zc.f;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f1b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', w.f28816e, 'M', 'N', 'O', 'P', 'Q', w.f28818g, 'S', 'T', w.f28817f, 'V', 'W', 'X', 'Y', w.f28814c, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', f.f58380j};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f2c = new byte[256];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f3a = new byte[4];

    static {
        int i10 = 0;
        for (int i11 = 0; i11 < 255; i11++) {
            f2c[i11] = -1;
        }
        while (true) {
            char[] cArr = f1b;
            if (i10 >= cArr.length) {
                return;
            }
            f2c[cArr[i10]] = (byte) i10;
            i10++;
        }
    }

    @Override // a.c
    public int a() {
        return 4;
    }

    @Override // a.c
    public int b() {
        return 72;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    @Override // a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.io.PushbackInputStream r10, java.io.OutputStream r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.c(java.io.PushbackInputStream, java.io.OutputStream, int):void");
    }
}
