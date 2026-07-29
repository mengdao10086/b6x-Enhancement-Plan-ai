package n0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class e {
    @yt.k
    @v0(26)
    public static final Icon a(@yt.k Bitmap bitmap) {
        f0.p(bitmap, "<this>");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        f0.o(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @yt.k
    @v0(26)
    public static final Icon b(@yt.k Bitmap bitmap) {
        f0.p(bitmap, "<this>");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        f0.o(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @yt.k
    @v0(26)
    public static final Icon c(@yt.k Uri uri) {
        f0.p(uri, "<this>");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        f0.o(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @yt.k
    @v0(26)
    public static final Icon d(@yt.k byte[] bArr) {
        f0.p(bArr, "<this>");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        f0.o(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
