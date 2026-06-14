package a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pk extends mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Uri f2435a;

    public pk(mk mkVar, Context context, Uri uri) {
        super(mkVar);
        this.f7125a = context;
        this.f2435a = uri;
    }

    public static void i(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static Uri j(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // a.mk
    public boolean a() {
        return nk.a(this.f7125a, this.f2435a);
    }

    @Override // a.mk
    public mk b(String str) {
        Uri uriJ = j(this.f7125a, this.f2435a, "vnd.android.document/directory", str);
        if (uriJ != null) {
            return new pk(this, this.f7125a, uriJ);
        }
        return null;
    }

    @Override // a.mk
    public mk c(String str, String str2) {
        Uri uriJ = j(this.f7125a, this.f2435a, str, str2);
        if (uriJ != null) {
            return new pk(this, this.f7125a, uriJ);
        }
        return null;
    }

    @Override // a.mk
    public String g() {
        return nk.c(this.f7125a, this.f2435a);
    }

    @Override // a.mk
    public mk[] h() {
        ContentResolver contentResolver = this.f7125a.getContentResolver();
        Uri uri = this.f2435a;
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f2435a, cursorQuery.getString(0)));
                }
            } catch (Exception e) {
                Log.w("DocumentFile", "Failed query: " + e);
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            mk[] mkVarArr = new mk[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                mkVarArr[i] = new pk(this, this.f7125a, uriArr[i]);
            }
            return mkVarArr;
        } finally {
            i(cursorQuery);
        }
    }
}
