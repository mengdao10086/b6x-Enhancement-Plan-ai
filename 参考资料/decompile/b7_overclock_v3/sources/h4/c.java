package h4;

import g.n0;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class c implements c4.a<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30438a = "ByteBufferEncoder";

    @Override // c4.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 ByteBuffer byteBuffer, @n0 File file, @n0 c4.e eVar) throws Throwable {
        try {
            v4.a.f(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
