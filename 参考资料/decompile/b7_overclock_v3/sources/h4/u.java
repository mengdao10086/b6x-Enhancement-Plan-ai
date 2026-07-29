package h4;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import g.n0;
import g.p0;
import h4.n;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class u<Data> implements n<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<Uri, Data> f30520a;

    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        public n<String, AssetFileDescriptor> c(@n0 r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<String, ParcelFileDescriptor> c(@n0 r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<String, InputStream> {
        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<String, InputStream> c(@n0 r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f30520a = nVar;
    }

    @p0
    public static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    public static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 String str, int i10, int i11, @n0 c4.e eVar) {
        Uri uriE = e(str);
        if (uriE == null || !this.f30520a.b(uriE)) {
            return null;
        }
        return this.f30520a.a(uriE, i10, i11, eVar);
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 String str) {
        return true;
    }
}
