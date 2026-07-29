package ec;

import android.net.Uri;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import g.p0;
import java.util.List;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public interface x {
    @Deprecated
    x a(@p0 String str);

    @Deprecated
    x b(@p0 List<StreamKey> list);

    com.google.android.exoplayer2.source.l c(v0 v0Var);

    @Deprecated
    x d(@p0 HttpDataSource.b bVar);

    int[] e();

    x f(@p0 gb.r rVar);

    @Deprecated
    x g(@p0 com.google.android.exoplayer2.drm.c cVar);

    @Deprecated
    com.google.android.exoplayer2.source.l h(Uri uri);

    x i(@p0 com.google.android.exoplayer2.upstream.j jVar);
}
