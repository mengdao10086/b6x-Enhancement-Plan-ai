package androidx.room;

import android.content.Context;
import c2.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class a3 implements c2.e, p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final Context f7325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public final String f7326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public final File f7327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.p0
    public final Callable<InputStream> f7328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final c2.e f7330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.p0
    public n0 f7331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7332h;

    public class a extends e.a {
        public a(int i10) {
            super(i10);
        }

        @Override // c2.e.a
        public void d(@g.n0 c2.d dVar) {
        }

        @Override // c2.e.a
        public void f(@g.n0 c2.d dVar) {
            int i10 = this.f9699a;
            if (i10 < 1) {
                dVar.A(i10);
            }
        }

        @Override // c2.e.a
        public void g(@g.n0 c2.d dVar, int i10, int i11) {
        }
    }

    public a3(@g.n0 Context context, @g.p0 String str, @g.p0 File file, @g.p0 Callable<InputStream> callable, int i10, @g.n0 c2.e eVar) {
        this.f7325a = context;
        this.f7326b = str;
        this.f7327c = file;
        this.f7328d = callable;
        this.f7329e = i10;
        this.f7330f = eVar;
    }

    public final void a(File file, boolean z10) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.f7326b != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.f7325a.getAssets().open(this.f7326b));
        } else if (this.f7327c != null) {
            readableByteChannelNewChannel = new FileInputStream(this.f7327c).getChannel();
        } else {
            Callable<InputStream> callable = this.f7328d;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel(callable.call());
            } catch (Exception e10) {
                throw new IOException("inputStreamCallable exception on call", e10);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f7325a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        b2.d.a(readableByteChannelNewChannel, new FileOutputStream(fileCreateTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        d(fileCreateTempFile, z10);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    public final c2.e c(File file) {
        try {
            return new d2.c().a(e.b.a(this.f7325a).c(file.getAbsolutePath()).b(new a(Math.max(b2.c.g(file), 1))).a());
        } catch (IOException e10) {
            throw new RuntimeException("Malformed database file, unable to read version.", e10);
        }
    }

    @Override // c2.e, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f7330f.close();
        this.f7332h = false;
    }

    public final void d(File file, boolean z10) {
        n0 n0Var = this.f7331g;
        if (n0Var == null || n0Var.f7485f == null) {
            return;
        }
        c2.e eVarC = c(file);
        try {
            this.f7331g.f7485f.a(z10 ? eVarC.getWritableDatabase() : eVarC.getReadableDatabase());
        } finally {
            eVarC.close();
        }
    }

    public void f(@g.p0 n0 n0Var) {
        this.f7331g = n0Var;
    }

    @Override // c2.e
    public String getDatabaseName() {
        return this.f7330f.getDatabaseName();
    }

    @Override // c2.e
    public synchronized c2.d getReadableDatabase() {
        if (!this.f7332h) {
            h(false);
            this.f7332h = true;
        }
        return this.f7330f.getReadableDatabase();
    }

    @Override // c2.e
    public synchronized c2.d getWritableDatabase() {
        if (!this.f7332h) {
            h(true);
            this.f7332h = true;
        }
        return this.f7330f.getWritableDatabase();
    }

    public final void h(boolean z10) {
        String databaseName = getDatabaseName();
        File databasePath = this.f7325a.getDatabasePath(databaseName);
        n0 n0Var = this.f7331g;
        b2.a aVar = new b2.a(databaseName, this.f7325a.getFilesDir(), n0Var == null || n0Var.f7492m);
        try {
            aVar.b();
            if (!databasePath.exists()) {
                try {
                    a(databasePath, z10);
                    return;
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to copy database file.", e10);
                }
            }
            if (this.f7331g == null) {
                return;
            }
            try {
                int iG = b2.c.g(databasePath);
                int i10 = this.f7329e;
                if (iG == i10) {
                    return;
                }
                if (this.f7331g.a(iG, i10)) {
                    return;
                }
                if (this.f7325a.deleteDatabase(databaseName)) {
                    try {
                        a(databasePath, z10);
                    } catch (IOException unused) {
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to delete database file (");
                    sb2.append(databaseName);
                    sb2.append(") for a copy destructive migration.");
                }
            } catch (IOException unused2) {
            }
        } finally {
            aVar.c();
        }
    }

    @Override // androidx.room.p0
    @g.n0
    public c2.e l() {
        return this.f7330f;
    }

    @Override // c2.e
    @g.v0(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f7330f.setWriteAheadLoggingEnabled(z10);
    }
}
