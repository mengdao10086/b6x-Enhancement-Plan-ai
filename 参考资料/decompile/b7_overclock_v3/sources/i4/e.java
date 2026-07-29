package i4;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import g.n0;
import g.p0;
import h4.n;
import h4.o;
import h4.r;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31829a;

    public static class a implements o<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f31830a;

        public a(Context context) {
            this.f31830a = context;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Uri, InputStream> c(r rVar) {
            return new e(this.f31830a);
        }
    }

    public e(Context context) {
        this.f31829a = context.getApplicationContext();
    }

    @Override // h4.n
    @p0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        if (d4.b.d(i10, i11) && e(eVar)) {
            return new n.a<>(new u4.e(uri), d4.c.g(this.f31829a, uri));
        }
        return null;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return d4.b.c(uri);
    }

    public final boolean e(c4.e eVar) {
        Long l10 = (Long) eVar.c(VideoDecoder.f12549g);
        return l10 != null && l10.longValue() == -1;
    }
}
