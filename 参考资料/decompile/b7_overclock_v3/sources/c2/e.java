package c2;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import c2.b;
import g.n0;
import g.p0;
import g.v0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends Closeable {

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f9698b = "SupportSQLite";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9699a;

        public a(int i10) {
            this.f9699a = i10;
        }

        public final void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleting the database file: ");
            sb2.append(str);
            try {
                b.a.c(new File(str));
            } catch (Exception unused) {
            }
        }

        public void b(@n0 d dVar) {
        }

        public void c(@n0 d dVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Corruption reported by sqlite on database: ");
            sb2.append(dVar.getPath());
            if (!dVar.isOpen()) {
                a(dVar.getPath());
                return;
            }
            List<Pair<String, String>> listW = null;
            try {
                try {
                    listW = dVar.w();
                } catch (SQLiteException unused) {
                }
                try {
                    dVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (listW != null) {
                    Iterator<Pair<String, String>> it2 = listW.iterator();
                    while (it2.hasNext()) {
                        a((String) it2.next().second);
                    }
                } else {
                    a(dVar.getPath());
                }
            }
        }

        public abstract void d(@n0 d dVar);

        public void e(@n0 d dVar, int i10, int i11) {
            throw new SQLiteException("Can't downgrade database from version " + i10 + " to " + i11);
        }

        public void f(@n0 d dVar) {
        }

        public abstract void g(@n0 d dVar, int i10, int i11);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final Context f9700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final String f9701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final a f9702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9703d;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Context f9704a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f9705b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public a f9706c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f9707d;

            public a(@n0 Context context) {
                this.f9704a = context;
            }

            @n0
            public b a() {
                if (this.f9706c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f9704a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.f9707d && TextUtils.isEmpty(this.f9705b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.f9704a, this.f9705b, this.f9706c, this.f9707d);
            }

            @n0
            public a b(@n0 a aVar) {
                this.f9706c = aVar;
                return this;
            }

            @n0
            public a c(@p0 String str) {
                this.f9705b = str;
                return this;
            }

            @n0
            public a d(boolean z10) {
                this.f9707d = z10;
                return this;
            }
        }

        public b(@n0 Context context, @p0 String str, @n0 a aVar) {
            this(context, str, aVar, false);
        }

        @n0
        public static a a(@n0 Context context) {
            return new a(context);
        }

        public b(@n0 Context context, @p0 String str, @n0 a aVar, boolean z10) {
            this.f9700a = context;
            this.f9701b = str;
            this.f9702c = aVar;
            this.f9703d = z10;
        }
    }

    public interface c {
        @n0
        e a(@n0 b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @p0
    String getDatabaseName();

    d getReadableDatabase();

    d getWritableDatabase();

    @v0(api = 16)
    void setWriteAheadLoggingEnabled(boolean z10);
}
