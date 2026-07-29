package h4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.n;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements n<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f30474a;

    public static final class a implements o<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f30475a;

        public a(Context context) {
            this.f30475a = context;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Uri, File> c(r rVar) {
            return new k(this.f30475a);
        }
    }

    public static class b implements com.bumptech.glide.load.data.d<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f30476c = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f30477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f30478b;

        public b(Context context, Uri uri) {
            this.f30477a = context;
            this.f30478b = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
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
        public void f(@n0 Priority priority, @n0 d.a<? super File> aVar) {
            Cursor cursorQuery = this.f30477a.getContentResolver().query(this.f30478b, f30476c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.d(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f30478b));
        }
    }

    public k(Context context) {
        this.f30474a = context;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<File> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(uri), new b(this.f30474a, uri));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return d4.b.b(uri);
    }
}
