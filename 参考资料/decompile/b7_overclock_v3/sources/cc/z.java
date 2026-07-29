package cc;

import android.net.Uri;
import cc.y;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.k;
import g.p0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class z<T extends y<T>> implements k.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.a<? extends T> f10853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final List<StreamKey> f10854b;

    public z(k.a<? extends T> aVar, @p0 List<StreamKey> list) {
        this.f10853a = aVar;
        this.f10854b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(Uri uri, InputStream inputStream) throws IOException {
        T tA = this.f10853a.a(uri, inputStream);
        List<StreamKey> list = this.f10854b;
        return (list == null || list.isEmpty()) ? tA : (T) tA.a(this.f10854b);
    }
}
