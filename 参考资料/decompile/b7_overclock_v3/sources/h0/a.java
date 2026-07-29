package h0;

import android.content.ContentProvider;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @g.n0
    public static Context a(@g.n0 ContentProvider contentProvider) {
        Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
