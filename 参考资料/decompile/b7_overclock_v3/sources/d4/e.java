package d4;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25982f = "ThumbStreamOpener";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f25983g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f25984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f25985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f25986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContentResolver f25987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ImageHeaderParser> f25988e;

    public e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, f25983g, dVar, bVar, contentResolver);
    }

    public int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f25987d.openInputStream(uri);
                int iB = com.bumptech.glide.load.a.b(this.f25988e, inputStreamOpenInputStream, this.f25986c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iB;
            } catch (IOException | NullPointerException unused2) {
                if (Log.isLoggable(f25982f, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to open uri: ");
                    sb2.append(uri);
                }
                if (inputStreamOpenInputStream == null) {
                    return -1;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
        } catch (Throwable th2) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(@g.n0 android.net.Uri r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            d4.d r1 = r4.f25985b     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L20
            android.database.Cursor r1 = r1.a(r5)     // Catch: java.lang.Throwable -> L1e java.lang.SecurityException -> L20
            if (r1 == 0) goto L18
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.SecurityException -> L21 java.lang.Throwable -> L3d
            if (r2 == 0) goto L18
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.SecurityException -> L21 java.lang.Throwable -> L3d
            r1.close()
            return r5
        L18:
            if (r1 == 0) goto L1d
            r1.close()
        L1d:
            return r0
        L1e:
            r5 = move-exception
            goto L3f
        L20:
            r1 = r0
        L21:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L37
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            r2.<init>()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3d
            r2.append(r5)     // Catch: java.lang.Throwable -> L3d
        L37:
            if (r1 == 0) goto L3c
            r1.close()
        L3c:
            return r0
        L3d:
            r5 = move-exception
            r0 = r1
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.e.b(android.net.Uri):java.lang.String");
    }

    public final boolean c(File file) {
        return this.f25984a.a(file) && 0 < this.f25984a.c(file);
    }

    public InputStream d(Uri uri) throws Throwable {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.f25984a.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.f25987d.openInputStream(uriFromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e10));
        }
    }

    public e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this.f25984a = aVar;
        this.f25985b = dVar;
        this.f25986c = bVar;
        this.f25987d = contentResolver;
        this.f25988e = list;
    }
}
