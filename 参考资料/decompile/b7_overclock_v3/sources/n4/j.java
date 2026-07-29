package n4;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import g.n0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j implements c4.f<InputStream, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f41876d = "StreamGifDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f41877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.f<ByteBuffer, c> f41878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f41879c;

    public j(List<ImageHeaderParser> list, c4.f<ByteBuffer, c> fVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f41877a = list;
        this.f41878b = fVar;
        this.f41879c = bVar;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // c4.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s<c> b(@n0 InputStream inputStream, int i10, int i11, @n0 c4.e eVar) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f41878b.b(ByteBuffer.wrap(bArrE), i10, i11, eVar);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 InputStream inputStream, @n0 c4.e eVar) throws IOException {
        return !((Boolean) eVar.c(i.f41875b)).booleanValue() && com.bumptech.glide.load.a.f(this.f41877a, inputStream, this.f41879c) == ImageHeaderParser.ImageType.GIF;
    }
}
