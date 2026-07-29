package fa;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.flydigi.sdk.bluetooth.l;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J=\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u001e"}, d2 = {"Lfa/g;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Landroid/net/Uri;", "uri", "", "h", "uriImage", "c", "Ljava/io/File;", m7.a.f40702b, "d", "Landroid/graphics/Bitmap$CompressFormat;", "e", "f", "selection", "", "selectionArgs", "a", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "b", "g", "", xf.j.f55230b, "i", l.f16298a, "k", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final g f28009a = new g();

    public final String a(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        String[] strArr2 = {"_data"};
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            f0.m(uri);
            cursorQuery = contentResolver.query(uri, strArr2, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final String b(Context context, Uri uri) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c(@yt.k android.net.Uri r9) {
        /*
            r8 = this;
            java.lang.String r0 = "uriImage"
            kotlin.jvm.internal.f0.p(r9, r0)
            r0 = 1
            r1 = 0
            java.lang.String r9 = r9.getPath()     // Catch: java.lang.Exception -> L32
            if (r9 == 0) goto L33
            java.lang.String r3 = "."
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r9
            int r2 = kotlin.text.StringsKt__StringsKt.G3(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L32
            r3 = -1
            if (r2 == r3) goto L33
            java.lang.String r3 = "."
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r9
            int r2 = kotlin.text.StringsKt__StringsKt.G3(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L32
            int r2 = r2 + r0
            java.lang.String r9 = r9.substring(r2)     // Catch: java.lang.Exception -> L32
            java.lang.String r2 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.f0.o(r9, r2)     // Catch: java.lang.Exception -> L32
            r1 = r9
            goto L33
        L32:
        L33:
            if (r1 == 0) goto L3f
            int r9 = r1.length()
            if (r9 != 0) goto L3c
            goto L3d
        L3c:
            r0 = 0
        L3d:
            if (r0 == 0) goto L41
        L3f:
            java.lang.String r1 = "jpg"
        L41:
            java.lang.String r9 = "."
            java.lang.String r9 = kotlin.jvm.internal.f0.C(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fa.g.c(android.net.Uri):java.lang.String");
    }

    @yt.k
    public final String d(@yt.k File file) {
        f0.p(file, "file");
        Uri uriFromFile = Uri.fromFile(file);
        f0.o(uriFromFile, "fromFile(file)");
        return c(uriFromFile);
    }

    @yt.k
    public final Bitmap.CompressFormat e(@yt.k Uri uri) {
        f0.p(uri, "uri");
        return f0.g(c(uri), ".png") ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    public final String f(Context context, Uri uri) {
        List listE;
        List listE2;
        Uri uri2 = null;
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            String scheme = uri.getScheme();
            f0.m(scheme);
            if (u.L1("content", scheme, true)) {
                return k(uri) ? uri.getLastPathSegment() : a(context, uri, null, null);
            }
            String scheme2 = uri.getScheme();
            f0.m(scheme2);
            if (u.L1(m7.a.f40702b, scheme2, true)) {
                return uri.getPath();
            }
        } else {
            if (j(uri)) {
                String docId = DocumentsContract.getDocumentId(uri);
                f0.o(docId, "docId");
                List<String> listT = new Regex(":").t(docId, 0);
                if (listT.isEmpty()) {
                    listE2 = CollectionsKt__CollectionsKt.E();
                } else {
                    ListIterator<String> listIterator = listT.listIterator(listT.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            listE2 = CollectionsKt___CollectionsKt.E5(listT, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    listE2 = CollectionsKt__CollectionsKt.E();
                }
                Object[] array = listE2.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                if (!u.L1("primary", strArr[0], true)) {
                    String strC = f0.C("storage/", u.l2(docId, ":", fh.a.f28350w, false, 4, null));
                    return new File(strC).exists() ? strC : f0.C("/storage/sdcard/", strArr[1]);
                }
                if (strArr.length <= 1) {
                    return f0.C(Environment.getExternalStorageDirectory().toString(), fh.a.f28350w);
                }
                return Environment.getExternalStorageDirectory().toString() + zc.f.f58380j + strArr[1];
            }
            if (i(uri)) {
                String id2 = DocumentsContract.getDocumentId(uri);
                f0.o(id2, "id");
                if (StringsKt__StringsKt.W2(id2, ":", false, 2, null)) {
                    f0.o(id2, "id");
                    id2 = (String) StringsKt__StringsKt.U4(id2, new String[]{":"}, false, 0, 6, null).get(1);
                }
                f0.o(id2, "id");
                if (!u.V1(id2)) {
                    try {
                        Uri uri3 = Uri.parse("content://downloads/public_downloads");
                        Long lValueOf = Long.valueOf(id2);
                        f0.o(lValueOf, "valueOf(id)");
                        Uri uriWithAppendedId = ContentUris.withAppendedId(uri3, lValueOf.longValue());
                        f0.o(uriWithAppendedId, "withAppendedId(\n                                Uri.parse(\"content://downloads/public_downloads\"),\n                                java.lang.Long.valueOf(id)\n                            )");
                        return a(context, uriWithAppendedId, null, null);
                    } catch (NumberFormatException e10) {
                        e10.getMessage();
                        return null;
                    }
                }
            } else if (l(uri)) {
                String docId2 = DocumentsContract.getDocumentId(uri);
                f0.o(docId2, "docId");
                List<String> listT2 = new Regex(":").t(docId2, 0);
                if (listT2.isEmpty()) {
                    listE = CollectionsKt__CollectionsKt.E();
                } else {
                    ListIterator<String> listIterator2 = listT2.listIterator(listT2.size());
                    while (listIterator2.hasPrevious()) {
                        if (!(listIterator2.previous().length() == 0)) {
                            listE = CollectionsKt___CollectionsKt.E5(listT2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    }
                    listE = CollectionsKt__CollectionsKt.E();
                }
                Object[] array2 = listE.toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr2 = (String[]) array2;
                String str = strArr2[0];
                if (f0.g("image", str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if (f0.g("video", str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (f0.g("audio", str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return a(context, uri2, "_id=?", new String[]{strArr2[1]});
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x003d
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final java.lang.String g(android.content.Context r6, android.net.Uri r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = r5.c(r7)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L59
            android.content.ContentResolver r3 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L59
            java.io.InputStream r7 = r3.openInputStream(r7)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L59
            fa.h r3 = fa.h.f28010a     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.io.File r4 = r6.getCacheDir()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.io.File r6 = r3.e(r6, r4, r2)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            if (r6 != 0) goto L21
            if (r7 != 0) goto L1d
            goto L20
        L1d:
            r7.close()     // Catch: java.io.IOException -> L20
        L20:
            return r1
        L21:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L41
            r2.<init>(r6)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L41
            if (r7 == 0) goto L31
            r3 = 4096(0x1000, float:5.74E-42)
            kotlin.io.a.k(r7, r2, r3)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L5c
            r3 = 1
            goto L32
        L2f:
            r6 = move-exception
            goto L43
        L31:
            r3 = 0
        L32:
            if (r7 != 0) goto L35
            goto L38
        L35:
            r7.close()     // Catch: java.io.IOException -> L38
        L38:
            r2.close()     // Catch: java.io.IOException -> L3d
            r0 = r3
            goto L6a
        L3d:
            goto L6a
        L3f:
            r2 = r1
            goto L5c
        L41:
            r6 = move-exception
            r2 = r1
        L43:
            r1 = r7
            goto L4a
        L45:
            r6 = r1
            r2 = r6
            goto L5c
        L48:
            r6 = move-exception
            r2 = r1
        L4a:
            if (r1 != 0) goto L4d
            goto L52
        L4d:
            r1.close()     // Catch: java.io.IOException -> L51
            goto L52
        L51:
        L52:
            if (r2 != 0) goto L55
            goto L58
        L55:
            r2.close()     // Catch: java.io.IOException -> L58
        L58:
            throw r6
        L59:
            r6 = r1
            r7 = r6
            r2 = r7
        L5c:
            if (r7 != 0) goto L5f
            goto L64
        L5f:
            r7.close()     // Catch: java.io.IOException -> L63
            goto L64
        L63:
        L64:
            if (r2 != 0) goto L67
            goto L6a
        L67:
            r2.close()     // Catch: java.io.IOException -> L3d
        L6a:
            if (r0 == 0) goto L73
            kotlin.jvm.internal.f0.m(r6)
            java.lang.String r1 = r6.getPath()
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fa.g.g(android.content.Context, android.net.Uri):java.lang.String");
    }

    @yt.l
    public final String h(@yt.k Context context, @yt.k Uri uri) {
        f0.p(context, "context");
        f0.p(uri, "uri");
        String strF = f(context, uri);
        return strF == null ? g(context, uri) : strF;
    }

    public final boolean i(Uri uri) {
        return f0.g("com.android.providers.downloads.documents", uri.getAuthority());
    }

    public final boolean j(Uri uri) {
        return f0.g("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean k(Uri uri) {
        return f0.g("com.google.android.apps.photos.content", uri.getAuthority());
    }

    public final boolean l(Uri uri) {
        return f0.g("com.android.providers.media.documents", uri.getAuthority());
    }
}
