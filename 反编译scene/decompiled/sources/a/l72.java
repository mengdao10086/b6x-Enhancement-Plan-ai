package a;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l72 extends ByteArrayOutputStream {
    public l72(int i) {
        super(i);
    }

    public final byte[] a() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        f92.c(bArr, "buf");
        return bArr;
    }
}
