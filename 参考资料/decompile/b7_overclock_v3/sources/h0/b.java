package h0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @v0(16)
    public static class a {
        @g.u
        public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
    }

    @g.p0
    public static Cursor a(@g.n0 ContentResolver contentResolver, @g.n0 Uri uri, @g.p0 String[] strArr, @g.p0 String str, @g.p0 String[] strArr2, @g.p0 String str2, @g.p0 androidx.core.os.f fVar) throws Exception {
        Object objB;
        if (fVar != null) {
            try {
                objB = fVar.b();
            } catch (Exception e10) {
                if (e10 instanceof OperationCanceledException) {
                    throw new androidx.core.os.OperationCanceledException();
                }
                throw e10;
            }
        } else {
            objB = null;
        }
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, (CancellationSignal) objB);
    }
}
