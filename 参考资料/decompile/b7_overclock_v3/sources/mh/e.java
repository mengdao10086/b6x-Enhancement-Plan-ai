package mh;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import g.n0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41223a = "FileUtils";

    public static void a(@n0 Context context, @n0 Uri uri, @n0 Uri uri2) throws Throwable {
        OutputStream outputStream;
        if (uri.equals(uri2)) {
            return;
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri2);
                if (!(inputStreamOpenInputStream instanceof FileInputStream) || !(outputStreamOpenOutputStream instanceof FileOutputStream)) {
                    throw new IllegalArgumentException("The input or output URI don't represent a file. uCrop requires then to represent files in order to work properly.");
                }
                FileChannel channel = ((FileInputStream) inputStreamOpenInputStream).getChannel();
                channel.transferTo(0L, channel.size(), ((FileOutputStream) outputStreamOpenOutputStream).getChannel());
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                if (outputStreamOpenOutputStream != null) {
                    outputStreamOpenOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpenInputStream;
                outputStream = null;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static void b(@n0 String str, @n0 String str2) throws Throwable {
        FileChannel fileChannel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel channel = null;
        try {
            FileChannel channel2 = new FileInputStream(new File(str)).getChannel();
            try {
                channel = new FileOutputStream(new File(str2)).getChannel();
                channel2.transferTo(0L, channel2.size(), channel);
                channel2.close();
                if (channel != null) {
                    channel.close();
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel2 = channel;
                channel = channel2;
                fileChannel = fileChannel2;
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L2f java.lang.IllegalArgumentException -> L31
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2f java.lang.IllegalArgumentException -> L31
            if (r8 == 0) goto L29
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L27 java.lang.Throwable -> L4a
            if (r9 == 0) goto L29
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L27 java.lang.Throwable -> L4a
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.IllegalArgumentException -> L27 java.lang.Throwable -> L4a
            r8.close()
            return r9
        L27:
            r9 = move-exception
            goto L33
        L29:
            if (r8 == 0) goto L49
        L2b:
            r8.close()
            goto L49
        L2f:
            r9 = move-exception
            goto L4c
        L31:
            r9 = move-exception
            r8 = r7
        L33:
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r11 = "getDataColumn: _data - [%s]"
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4a
            r1 = 0
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L4a
            r0[r1] = r9     // Catch: java.lang.Throwable -> L4a
            java.lang.String.format(r10, r11, r0)     // Catch: java.lang.Throwable -> L4a
            if (r8 == 0) goto L49
            goto L2b
        L49:
            return r7
        L4a:
            r9 = move-exception
            r7 = r8
        L4c:
            if (r7 == 0) goto L51
            r7.close()
        L51:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: mh.e.c(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String d(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (f(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + fh.a.f28350w + strArrSplit[1];
                }
            } else if (e(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException e10) {
                        e10.getMessage();
                        return null;
                    }
                }
            } else if (h(uri)) {
                String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = strArrSplit2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return c(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return g(uri) ? uri.getLastPathSegment() : c(context, uri, null, null);
            }
            if (m7.a.f40702b.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean e(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean f(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean g(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean h(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
