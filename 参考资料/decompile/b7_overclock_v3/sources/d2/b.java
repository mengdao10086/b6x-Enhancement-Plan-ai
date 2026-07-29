package d2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import c2.b;
import c2.e;
import g.v0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b implements c2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f25956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.a f25958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f25959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f25960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f25961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25962g;

    public static class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d2.a[] f25963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e.a f25964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f25965c;

        /* JADX INFO: renamed from: d2.b$a$a, reason: collision with other inner class name */
        public class C0291a implements DatabaseErrorHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e.a f25966a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d2.a[] f25967b;

            public C0291a(e.a aVar, d2.a[] aVarArr) {
                this.f25966a = aVar;
                this.f25967b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f25966a.c(a.d(this.f25967b, sQLiteDatabase));
            }
        }

        public a(Context context, String str, d2.a[] aVarArr, e.a aVar) {
            super(context, str, null, aVar.f9699a, new C0291a(aVar, aVarArr));
            this.f25964b = aVar;
            this.f25963a = aVarArr;
        }

        public static d2.a d(d2.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            d2.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new d2.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        public synchronized c2.d a() {
            this.f25965c = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (!this.f25965c) {
                return c(readableDatabase);
            }
            close();
            return a();
        }

        public d2.a c(SQLiteDatabase sQLiteDatabase) {
            return d(this.f25963a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f25963a[0] = null;
        }

        public synchronized c2.d f() {
            this.f25965c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.f25965c) {
                return c(writableDatabase);
            }
            close();
            return f();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f25964b.b(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f25964b.d(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f25965c = true;
            this.f25964b.e(c(sQLiteDatabase), i10, i11);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f25965c) {
                return;
            }
            this.f25964b.f(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f25965c = true;
            this.f25964b.g(c(sQLiteDatabase), i10, i11);
        }
    }

    public b(Context context, String str, e.a aVar) {
        this(context, str, aVar, false);
    }

    public final a a() {
        a aVar;
        synchronized (this.f25960e) {
            if (this.f25961f == null) {
                d2.a[] aVarArr = new d2.a[1];
                if (Build.VERSION.SDK_INT < 23 || this.f25957b == null || !this.f25959d) {
                    this.f25961f = new a(this.f25956a, this.f25957b, aVarArr, this.f25958c);
                } else {
                    this.f25961f = new a(this.f25956a, new File(b.c.a(this.f25956a), this.f25957b).getAbsolutePath(), aVarArr, this.f25958c);
                }
                b.a.h(this.f25961f, this.f25962g);
            }
            aVar = this.f25961f;
        }
        return aVar;
    }

    @Override // c2.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // c2.e
    public String getDatabaseName() {
        return this.f25957b;
    }

    @Override // c2.e
    public c2.d getReadableDatabase() {
        return a().a();
    }

    @Override // c2.e
    public c2.d getWritableDatabase() {
        return a().f();
    }

    @Override // c2.e
    @v0(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this.f25960e) {
            a aVar = this.f25961f;
            if (aVar != null) {
                b.a.h(aVar, z10);
            }
            this.f25962g = z10;
        }
    }

    public b(Context context, String str, e.a aVar, boolean z10) {
        this.f25956a = context;
        this.f25957b = str;
        this.f25958c = aVar;
        this.f25959d = z10;
        this.f25960e = new Object();
    }
}
