package com.zhihu.matisse;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.collection.c;
import hd.w;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;
import mb.e;
import zh.d;

/* JADX INFO: loaded from: classes5.dex */
public enum MimeType {
    JPEG(w.C0, arraySetOf("jpg", "jpeg")),
    PNG("image/png", arraySetOf("png")),
    GIF("image/gif", arraySetOf("gif")),
    BMP("image/x-ms-bmp", arraySetOf("bmp")),
    WEBP("image/webp", arraySetOf("webp")),
    MPEG(w.f31204q, arraySetOf("mpeg", "mpg")),
    MP4(w.f31182f, arraySetOf("mp4", "m4v")),
    QUICKTIME("video/quicktime", arraySetOf("mov")),
    THREEGPP(w.f31188i, arraySetOf("3gp", "3gpp")),
    THREEGPP2("video/3gpp2", arraySetOf("3g2", "3gpp2")),
    MKV(w.f31184g, arraySetOf("mkv")),
    WEBM(w.f31186h, arraySetOf(e.f41042m0)),
    TS("video/mp2ts", arraySetOf("ts")),
    AVI("video/avi", arraySetOf("avi"));

    private final Set<String> mExtensions;
    private final String mMimeTypeName;

    MimeType(String str, Set set) {
        this.mMimeTypeName = str;
        this.mExtensions = set;
    }

    private static Set<String> arraySetOf(String... strArr) {
        return new c(Arrays.asList(strArr));
    }

    public static boolean isGif(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(GIF.toString());
    }

    public static boolean isImage(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("image");
    }

    public static boolean isVideo(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video");
    }

    public static Set<MimeType> of(MimeType mimeType, MimeType... mimeTypeArr) {
        return EnumSet.of(mimeType, mimeTypeArr);
    }

    public static Set<MimeType> ofAll() {
        return EnumSet.allOf(MimeType.class);
    }

    public static Set<MimeType> ofGif() {
        return ofImage(true);
    }

    public static Set<MimeType> ofImage() {
        return EnumSet.of(JPEG, PNG, GIF, BMP, WEBP);
    }

    public static Set<MimeType> ofVideo() {
        return EnumSet.of(MPEG, MP4, QUICKTIME, THREEGPP, THREEGPP2, MKV, WEBM, TS, AVI);
    }

    public boolean checkType(ContentResolver contentResolver, Uri uri) throws Throwable {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        if (uri == null) {
            return false;
        }
        String extensionFromMimeType = singleton.getExtensionFromMimeType(contentResolver.getType(uri));
        String strC = null;
        boolean z10 = false;
        for (String str : this.mExtensions) {
            if (str.equals(extensionFromMimeType)) {
                return true;
            }
            if (!z10) {
                strC = d.c(contentResolver, uri);
                if (!TextUtils.isEmpty(strC)) {
                    strC = strC.toLowerCase(Locale.US);
                }
                z10 = true;
            }
            if (strC != null && strC.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mMimeTypeName;
    }

    public static Set<MimeType> ofImage(boolean z10) {
        return EnumSet.of(GIF);
    }
}
