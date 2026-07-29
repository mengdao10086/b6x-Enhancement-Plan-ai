package o4;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import g.n0;
import g.p0;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.CompressFormat f42706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f42707b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // o4.e
    @p0
    public s<byte[]> a(@n0 s<Bitmap> sVar, @n0 c4.e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.get().compress(this.f42706a, this.f42707b, byteArrayOutputStream);
        sVar.a();
        return new k4.b(byteArrayOutputStream.toByteArray());
    }

    public a(@n0 Bitmap.CompressFormat compressFormat, int i10) {
        this.f42706a = compressFormat;
        this.f42707b = i10;
    }
}
