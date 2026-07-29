package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import g.n0;
import g.p0;
import g.u0;
import g.v;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public interface g<T> {
    @g.j
    @Deprecated
    T d(@p0 URL url);

    @g.j
    @n0
    T e(@p0 Uri uri);

    @g.j
    @n0
    T h(@p0 byte[] bArr);

    @g.j
    @n0
    T i(@p0 File file);

    @g.j
    @n0
    T j(@p0 Drawable drawable);

    @g.j
    @n0
    T k(@p0 Bitmap bitmap);

    @g.j
    @n0
    T o(@p0 Object obj);

    @g.j
    @n0
    T p(@p0 @u0 @v Integer num);

    @g.j
    @n0
    T t(@p0 String str);
}
