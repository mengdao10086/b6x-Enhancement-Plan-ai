package v0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.io.FileNotFoundException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52459a = "tree";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f52460a = 512;
    }

    @v0(19)
    public static class b {
        @u
        public static Uri a(String str, String str2) {
            return DocumentsContract.buildDocumentUri(str, str2);
        }

        @u
        public static boolean b(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(contentResolver, uri);
        }

        @u
        public static String c(Uri uri) {
            return DocumentsContract.getDocumentId(uri);
        }

        @u
        public static boolean d(Context context, @p0 Uri uri) {
            return DocumentsContract.isDocumentUri(context, uri);
        }
    }

    /* JADX INFO: renamed from: v0.c$c, reason: collision with other inner class name */
    @v0(21)
    public static class C0609c {
        @u
        public static Uri a(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        @u
        public static Uri b(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        @u
        public static Uri c(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        @u
        public static Uri d(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }

        @u
        public static Uri e(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        @u
        public static String f(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        @u
        public static Uri g(@n0 ContentResolver contentResolver, @n0 Uri uri, @n0 String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }
    }

    @v0(24)
    public static class d {
        @u
        public static boolean a(@n0 Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        @u
        public static boolean b(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }
    }

    @p0
    public static Uri a(@n0 String str, @p0 String str2) {
        return C0609c.a(str, str2);
    }

    @p0
    public static Uri b(@n0 Uri uri, @n0 String str) {
        return C0609c.b(uri, str);
    }

    @p0
    public static Uri c(@n0 String str, @n0 String str2) {
        return b.a(str, str2);
    }

    @p0
    public static Uri d(@n0 Uri uri, @n0 String str) {
        return C0609c.c(uri, str);
    }

    @p0
    public static Uri e(@n0 String str, @n0 String str2) {
        return C0609c.d(str, str2);
    }

    @p0
    public static Uri f(@n0 ContentResolver contentResolver, @n0 Uri uri, @n0 String str, @n0 String str2) throws FileNotFoundException {
        return C0609c.e(contentResolver, uri, str, str2);
    }

    @p0
    public static String g(@n0 Uri uri) {
        return b.c(uri);
    }

    @p0
    public static String h(@n0 Uri uri) {
        return C0609c.f(uri);
    }

    public static boolean i(@n0 Context context, @p0 Uri uri) {
        return b.d(context, uri);
    }

    public static boolean j(@n0 Uri uri) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d.a(uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        return pathSegments.size() >= 2 && f52459a.equals(pathSegments.get(0));
    }

    public static boolean k(@n0 ContentResolver contentResolver, @n0 Uri uri, @n0 Uri uri2) throws FileNotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? d.b(contentResolver, uri, uri2) : b.b(contentResolver, uri);
    }

    @p0
    public static Uri l(@n0 ContentResolver contentResolver, @n0 Uri uri, @n0 String str) throws FileNotFoundException {
        return C0609c.g(contentResolver, uri, str);
    }
}
