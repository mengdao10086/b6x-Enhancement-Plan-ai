package h0;

import android.content.UriMatcher;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class q0 {
    @g.n0
    public static androidx.core.util.w<Uri> b(@g.n0 final UriMatcher uriMatcher) {
        return new androidx.core.util.w() { // from class: h0.p0
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return q0.c(uriMatcher, (Uri) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };
    }

    public static /* synthetic */ boolean c(UriMatcher uriMatcher, Uri uri) {
        return uriMatcher.match(uri) != -1;
    }
}
