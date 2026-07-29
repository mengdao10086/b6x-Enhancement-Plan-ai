package com.flydigi.base.ui.image_preview;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.lifecycle.y0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class ImagePreviewViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13390e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewViewModel(@k Application application) {
        super(application);
        f0.p(application, "application");
        this.f13390e = e.b(k());
    }

    @l
    public final Object i(@k String str, @k kotlin.coroutines.c<? super Uri> cVar) {
        return h.h(d1.c(), new ImagePreviewViewModel$createPhotoUri$2(str, this, Build.VERSION.SDK_INT >= 29 ? MediaStore.Images.Media.getContentUri("external_primary") : MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null), cVar);
    }

    public final boolean j() {
        return this.f13390e;
    }

    public final Context k() {
        Application applicationG = g();
        f0.o(applicationG, "getApplication()");
        return applicationG;
    }

    public final void l(@k String url, @k ik.a<z1> callback) {
        f0.p(url, "url");
        f0.p(callback, "callback");
        j.f(y0.a(this), null, null, new ImagePreviewViewModel$saveRandomImageFromInternet$1(this, url, callback, null), 3, null);
    }
}
