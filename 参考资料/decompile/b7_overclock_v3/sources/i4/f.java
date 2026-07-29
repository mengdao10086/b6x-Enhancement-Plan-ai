package i4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import g.p0;
import g.v0;
import h4.n;
import h4.o;
import h4.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@v0(29)
public final class f<DataT> implements n<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<File, DataT> f31832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n<Uri, DataT> f31833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class<DataT> f31834d;

    public static abstract class a<DataT> implements o<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f31835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<DataT> f31836b;

        public a(Context context, Class<DataT> cls) {
            this.f31835a = context;
            this.f31836b = cls;
        }

        @Override // h4.o
        public final void a() {
        }

        @Override // h4.o
        @n0
        public final n<Uri, DataT> c(@n0 r rVar) {
            return new f(this.f31835a, rVar.d(File.class, this.f31836b), rVar.d(Uri.class, this.f31836b), this.f31836b);
        }
    }

    @v0(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @v0(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    public static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String[] f31837k = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f31838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n<File, DataT> f31839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n<Uri, DataT> f31840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f31841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f31842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f31843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c4.e f31844g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class<DataT> f31845h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f31846i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public volatile com.bumptech.glide.load.data.d<DataT> f31847j;

        public d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i10, int i11, c4.e eVar, Class<DataT> cls) {
            this.f31838a = context.getApplicationContext();
            this.f31839b = nVar;
            this.f31840c = nVar2;
            this.f31841d = uri;
            this.f31842e = i10;
            this.f31843f = i11;
            this.f31844g = eVar;
            this.f31845h = cls;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<DataT> a() {
            return this.f31845h;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.f31847j;
            if (dVar != null) {
                dVar.b();
            }
        }

        @p0
        public final n.a<DataT> c() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f31839b.a(h(this.f31841d), this.f31842e, this.f31843f, this.f31844g);
            }
            return this.f31840c.a(g() ? MediaStore.setRequireOriginal(this.f31841d) : this.f31841d, this.f31842e, this.f31843f, this.f31844g);
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f31846i = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.f31847j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @p0
        public final com.bumptech.glide.load.data.d<DataT> d() throws FileNotFoundException {
            n.a<DataT> aVarC = c();
            if (aVarC != null) {
                return aVarC.f30488c;
            }
            return null;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public DataSource e() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void f(@n0 Priority priority, @n0 d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> dVarD = d();
                if (dVarD == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f31841d));
                    return;
                }
                this.f31847j = dVarD;
                if (this.f31846i) {
                    cancel();
                } else {
                    dVarD.f(priority, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.c(e10);
            }
        }

        public final boolean g() {
            return this.f31838a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @n0
        public final File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f31838a.getContentResolver().query(uri, f31837k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    public f(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f31831a = context.getApplicationContext();
        this.f31832b = nVar;
        this.f31833c = nVar2;
        this.f31834d = cls;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<DataT> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(uri), new d(this.f31831a, this.f31832b, this.f31833c, uri, i10, i11, eVar, this.f31834d));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && d4.b.b(uri);
    }
}
