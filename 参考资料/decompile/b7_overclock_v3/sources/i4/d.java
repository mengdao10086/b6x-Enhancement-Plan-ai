package i4;

import android.content.Context;
import android.net.Uri;
import g.n0;
import h4.n;
import h4.o;
import h4.r;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class d implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31827a;

    public static class a implements o<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f31828a;

        public a(Context context) {
            this.f31828a = context;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Uri, InputStream> c(r rVar) {
            return new d(this.f31828a);
        }
    }

    public d(Context context) {
        this.f31827a = context.getApplicationContext();
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        if (d4.b.d(i10, i11)) {
            return new n.a<>(new u4.e(uri), d4.c.d(this.f31827a, uri));
        }
        return null;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return d4.b.a(uri);
    }
}
