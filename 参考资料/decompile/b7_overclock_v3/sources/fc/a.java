package fc;

import android.view.View;
import com.google.android.exoplayer2.source.ads.b;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static List a(b.a aVar) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (View view : aVar.a()) {
            builder.add(new b.c(view, 0));
        }
        return builder.build();
    }

    @Deprecated
    public static View[] b(b.a aVar) {
        return new View[0];
    }
}
