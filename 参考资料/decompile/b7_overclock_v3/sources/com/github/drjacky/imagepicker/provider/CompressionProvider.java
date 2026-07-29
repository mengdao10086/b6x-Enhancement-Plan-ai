package com.github.drjacky.imagepicker.provider;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.z;
import com.flydigi.sdk.bluetooth.l;
import com.github.drjacky.imagepicker.ImagePickerActivity;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/CompressionProvider;", "Lcom/github/drjacky/imagepicker/provider/a;", "Landroid/net/Uri;", "uri", "", k.f40564b, "Lkotlin/z1;", j.f55230b, "Ljava/io/File;", "k", "", l.f16298a, "", "b", "I", "maxWidth", "c", "maxHeight", "d", "Z", "keepRatio", "Lcom/github/drjacky/imagepicker/ImagePickerActivity;", androidx.appcompat.widget.c.f2369r, "<init>", "(Lcom/github/drjacky/imagepicker/ImagePickerActivity;)V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class CompressionProvider extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16559d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressionProvider(@yt.k ImagePickerActivity activity) {
        super(activity);
        f0.p(activity, "activity");
        Bundle extras = activity.getIntent().getExtras();
        extras = extras == null ? new Bundle() : extras;
        this.f16557b = extras.getInt(com.github.drjacky.imagepicker.b.f16534i, 0);
        this.f16558c = extras.getInt(com.github.drjacky.imagepicker.b.f16535j, 0);
        this.f16559d = extras.getBoolean(com.github.drjacky.imagepicker.b.f16536k, false);
    }

    public final void j(@yt.k Uri uri) {
        f0.p(uri, "uri");
        kotlinx.coroutines.j.f(z.a(a()), null, null, new CompressionProvider$compress$1(this, uri, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.File k(android.net.Uri r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.drjacky.imagepicker.provider.CompressionProvider.k(android.net.Uri):java.io.File");
    }

    public final int[] l(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        return new int[]{options.outWidth, options.outHeight};
    }

    public final boolean m(@yt.k Uri uri) {
        f0.p(uri, "uri");
        if (this.f16557b > 0 && this.f16558c > 0) {
            int[] iArrL = l(uri);
            if (iArrL[0] > this.f16557b || iArrL[1] > this.f16558c) {
                return true;
            }
        }
        return false;
    }
}
