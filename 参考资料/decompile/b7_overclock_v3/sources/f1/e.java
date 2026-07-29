package f1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import g.p0;
import g.v0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class e extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f27922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f27923d;

    public e(@p0 a aVar, Context context, Uri uri) {
        super(aVar);
        this.f27922c = context;
        this.f27923d = uri;
    }

    public static void w(@p0 AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    @p0
    public static Uri x(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // f1.a
    public boolean a() {
        return b.a(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public boolean b() {
        return b.b(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    @p0
    public a c(String str) {
        Uri uriX = x(this.f27922c, this.f27923d, "vnd.android.document/directory", str);
        if (uriX != null) {
            return new e(this, this.f27922c, uriX);
        }
        return null;
    }

    @Override // f1.a
    @p0
    public a d(String str, String str2) {
        Uri uriX = x(this.f27922c, this.f27923d, str, str2);
        if (uriX != null) {
            return new e(this, this.f27922c, uriX);
        }
        return null;
    }

    @Override // f1.a
    public boolean e() {
        try {
            return DocumentsContract.deleteDocument(this.f27922c.getContentResolver(), this.f27923d);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // f1.a
    public boolean f() {
        return b.d(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    @p0
    public String k() {
        return b.f(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    @p0
    public String m() {
        return b.h(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public Uri n() {
        return this.f27923d;
    }

    @Override // f1.a
    public boolean o() {
        return b.i(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public boolean q() {
        return b.j(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public boolean r() {
        return b.k(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public long s() {
        return b.l(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public long t() {
        return b.m(this.f27922c, this.f27923d);
    }

    @Override // f1.a
    public a[] u() {
        ContentResolver contentResolver = this.f27922c.getContentResolver();
        Uri uri = this.f27923d;
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f27923d, cursorQuery.getString(0)));
                }
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed query: ");
                sb2.append(e10);
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            a[] aVarArr = new a[uriArr.length];
            for (int i10 = 0; i10 < uriArr.length; i10++) {
                aVarArr[i10] = new e(this, this.f27922c, uriArr[i10]);
            }
            return aVarArr;
        } finally {
            w(cursorQuery);
        }
    }

    @Override // f1.a
    public boolean v(String str) {
        try {
            Uri uriRenameDocument = DocumentsContract.renameDocument(this.f27922c.getContentResolver(), this.f27923d, str);
            if (uriRenameDocument != null) {
                this.f27923d = uriRenameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
