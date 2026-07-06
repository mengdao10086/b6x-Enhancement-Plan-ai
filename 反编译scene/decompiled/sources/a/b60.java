package a;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b60 {
    public static File a(String str, File file) {
        String strSubstring;
        if (str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            int iLastIndexOf = str.lastIndexOf(46);
            int i = 0;
            if (iLastIndexOf > 0) {
                String strSubstring2 = str.substring(0, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf);
                str = strSubstring2;
            } else {
                strSubstring = "";
            }
            while (file2.exists()) {
                i++;
                file2 = new File(file, str + '(' + i + ')' + strSubstring);
            }
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File c(Context context) {
        File file = new File(context.getCacheDir(), "documents");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void k(Context context, Uri uri, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, false));
                } catch (IOException unused) {
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    inputStreamOpenInputStream.read(bArr);
                    do {
                        bufferedOutputStream.write(bArr);
                    } while (inputStreamOpenInputStream.read(bArr) != -1);
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    bufferedOutputStream.close();
                } catch (IOException unused2) {
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException unused3) {
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039 A[PHI: r9
  0x0039: PHI (r9v3 android.database.Cursor) = (r9v2 android.database.Cursor), (r9v4 android.database.Cursor) binds: [B:20:0x0037, B:13:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L36
            r6 = 0
            r2 = r10
            r4 = r11
            r5 = r12
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L36
            if (r9 == 0) goto L2c
            boolean r10 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L37
            if (r10 == 0) goto L2c
            int r10 = r9.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L37
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L37
            if (r9 == 0) goto L28
            r9.close()
        L28:
            return r10
        L29:
            r10 = move-exception
            r7 = r9
            goto L30
        L2c:
            if (r9 == 0) goto L3c
            goto L39
        L2f:
            r10 = move-exception
        L30:
            if (r7 == 0) goto L35
            r7.close()
        L35:
            throw r10
        L36:
            r9 = r7
        L37:
            if (r9 == 0) goto L3c
        L39:
            r9.close()
        L3c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b60.b(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public String d(Context context, Uri uri) throws Throwable {
        if (context.getContentResolver().getType(uri) == null) {
            String strF = f(context, uri);
            return strF == null ? e(uri.toString()) : new File(strF).getName();
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }

    public String e(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    @SuppressLint({"NewApi"})
    public String f(Context context, Uri uri) throws Throwable {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (h(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else {
                if (g(uri)) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (new nb2("^[0-9]{1,}").f(documentId)) {
                        return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), null, null);
                    }
                    File fileA = a(d(context, uri), c(context));
                    if (fileA == null) {
                        return null;
                    }
                    String absolutePath = fileA.getAbsolutePath();
                    k(context, uri, absolutePath);
                    return absolutePath;
                }
                if (j(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return b(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return i(uri) ? uri.getLastPathSegment() : b(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public final boolean g(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public final boolean h(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public final boolean i(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public final boolean j(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
