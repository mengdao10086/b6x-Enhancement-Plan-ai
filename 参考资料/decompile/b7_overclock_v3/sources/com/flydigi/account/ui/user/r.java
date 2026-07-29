package com.flydigi.account.ui.user;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.blankj.utilcode.util.ImageUtils;
import com.yalantis.ucrop.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final void a(@yt.k Uri uri, @yt.k Context context) throws FileNotFoundException {
        f0.p(uri, "<this>");
        f0.p(context, "context");
        String str = Environment.DIRECTORY_PICTURES;
        String strC = fa.g.f28009a.c(uri);
        Bitmap bitmapB = b(uri, context);
        f0.m(bitmapB);
        File file = new File(context.getExternalFilesDir(str), System.currentTimeMillis() + "_selectedImg" + strC);
        fa.h hVar = fa.h.f28010a;
        ImageUtils.v0(bitmapB, file, hVar.b(strC), 50);
        a.C0278a c0278a = new a.C0278a();
        c0278a.p(true);
        c0278a.w(false);
        c0278a.f(hVar.b(strC));
        c0278a.g(80);
        com.yalantis.ucrop.a.i(Uri.fromFile(file), Uri.fromFile(new File(context.getCacheDir(), System.currentTimeMillis() + '.' + strC))).q(c0278a).o(1.0f, 1.0f).j((Activity) context);
    }

    @yt.l
    public static final Bitmap b(@yt.k Uri uri, @yt.k Context context) throws FileNotFoundException {
        f0.p(uri, "<this>");
        f0.p(context, "context");
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(context.getContentResolver(), uri));
        }
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
            kotlin.io.b.a(inputStreamOpenInputStream, null);
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                kotlin.io.b.a(inputStreamOpenInputStream, th2);
                throw th3;
            }
        }
    }
}
