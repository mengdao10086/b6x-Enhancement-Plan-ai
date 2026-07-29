package h4;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import g.n0;
import h4.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class w<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f30524b = Collections.unmodifiableSet(new HashSet(Arrays.asList(m7.a.f40702b, com.google.android.exoplayer2.upstream.c.f19120t, "content")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<Data> f30525a;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f30526a;

        public a(ContentResolver contentResolver) {
            this.f30526a = contentResolver;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.w.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> b(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f30526a, uri);
        }

        @Override // h4.o
        public n<Uri, AssetFileDescriptor> c(r rVar) {
            return new w(this);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f30527a;

        public b(ContentResolver contentResolver) {
            this.f30527a = contentResolver;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.w.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> b(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f30527a, uri);
        }

        @Override // h4.o
        @n0
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new w(this);
        }
    }

    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> b(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f30528a;

        public d(ContentResolver contentResolver) {
            this.f30528a = contentResolver;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.w.c
        public com.bumptech.glide.load.data.d<InputStream> b(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f30528a, uri);
        }

        @Override // h4.o
        @n0
        public n<Uri, InputStream> c(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f30525a = cVar;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(uri), this.f30525a.b(uri));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return f30524b.contains(uri.getScheme());
    }
}
