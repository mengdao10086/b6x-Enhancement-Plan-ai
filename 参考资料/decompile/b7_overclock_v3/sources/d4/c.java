package d4;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import g.i1;
import g.n0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25972d = "MediaStoreThumbFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f25973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f25974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f25975c;

    public static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f25976b = {"_data"};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f25977c = "kind = 1 AND image_id = ?";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f25978a;

        public a(ContentResolver contentResolver) {
            this.f25978a = contentResolver;
        }

        @Override // d4.d
        public Cursor a(Uri uri) {
            return this.f25978a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f25976b, f25977c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f25979b = {"_data"};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f25980c = "kind = 1 AND video_id = ?";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f25981a;

        public b(ContentResolver contentResolver) {
            this.f25981a = contentResolver;
        }

        @Override // d4.d
        public Cursor a(Uri uri) {
            return this.f25981a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f25979b, f25980c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @i1
    public c(Uri uri, e eVar) {
        this.f25973a = uri;
        this.f25974b = eVar;
    }

    public static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.e(context).n().g(), dVar, com.bumptech.glide.b.e(context).g(), context.getContentResolver()));
    }

    public static c d(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f25975c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public DataSource e() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void f(@n0 Priority priority, @n0 d.a<? super InputStream> aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.f25975c = inputStreamH;
            aVar.d(inputStreamH);
        } catch (FileNotFoundException e10) {
            aVar.c(e10);
        }
    }

    public final InputStream h() throws Throwable {
        InputStream inputStreamD = this.f25974b.d(this.f25973a);
        int iA = inputStreamD != null ? this.f25974b.a(this.f25973a) : -1;
        return iA != -1 ? new g(inputStreamD, iA) : inputStreamD;
    }
}
