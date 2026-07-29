package o4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.bitmap.x;
import g.n0;
import g.p0;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f42708a;

    public b(@n0 Context context) {
        this(context.getResources());
    }

    @Override // o4.e
    @p0
    public s<BitmapDrawable> a(@n0 s<Bitmap> sVar, @n0 c4.e eVar) {
        return x.f(this.f42708a, sVar);
    }

    @Deprecated
    public b(@n0 Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this(resources);
    }

    public b(@n0 Resources resources) {
        this.f42708a = (Resources) m.d(resources);
    }
}
