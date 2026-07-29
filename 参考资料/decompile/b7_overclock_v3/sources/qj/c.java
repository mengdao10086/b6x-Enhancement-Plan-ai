package qj;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.d0;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f47372d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f47373e = "jp.wasabeef.glide.transformations.CropSquareTransformation.1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47374c;

    @Override // qj.a, c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update((f47373e + this.f47374c).getBytes(c4.b.f9745b));
    }

    @Override // qj.a
    public Bitmap c(@n0 Context context, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        int iMax = Math.max(i10, i11);
        this.f47374c = iMax;
        return d0.b(eVar, bitmap, iMax, iMax);
    }

    @Override // qj.a, c4.b
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f47374c == this.f47374c;
    }

    @Override // qj.a, c4.b
    public int hashCode() {
        return (-789843280) + (this.f47374c * 10);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.f47374c + ee.a.f26979d;
    }
}
