package a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class mk {
    public mk(mk mkVar) {
    }

    public static mk e(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new ok(null, context, uri);
        }
        return null;
    }

    public static mk f(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new pk(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
        }
        return null;
    }

    public abstract boolean a();

    public abstract mk b(String str);

    public abstract mk c(String str, String str2);

    public mk d(String str) {
        for (mk mkVar : h()) {
            if (str.equals(mkVar.g())) {
                return mkVar;
            }
        }
        return null;
    }

    public abstract String g();

    public abstract mk[] h();
}
