package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import g.n0;
import g.p0;
import g.v0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public final class y implements c4.f<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12671b = 536870912;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f12672a;

    public y(o oVar) {
        this.f12672a = oVar;
    }

    @Override // c4.f
    @p0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, @n0 c4.e eVar) throws IOException {
        return this.f12672a.d(parcelFileDescriptor, i10, i11, eVar);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 ParcelFileDescriptor parcelFileDescriptor, @n0 c4.e eVar) {
        return e(parcelFileDescriptor) && this.f12672a.r(parcelFileDescriptor);
    }

    public final boolean e(@n0 ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }
}
