package gm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class w implements h, org.bouncycastle.util.g {
    public static boolean w(Object obj, int i10) {
        return (obj instanceof byte[]) && ((byte[]) obj)[0] == i10;
    }

    @Override // gm.h
    public abstract c0 b();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return b().C(((h) obj).b());
        }
        return false;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b().t(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return b().hashCode();
    }

    public void t(OutputStream outputStream) throws IOException {
        b().t(outputStream);
    }

    public void u(OutputStream outputStream, String str) throws IOException {
        b().u(outputStream, str);
    }

    public byte[] v(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b().u(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }
}
