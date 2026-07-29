package hd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30956c = "AtomicFile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f30957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f30958b;

    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileOutputStream f30959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f30960b = false;

        public a(File file) throws FileNotFoundException {
            this.f30959a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f30960b) {
                return;
            }
            this.f30960b = true;
            flush();
            try {
                this.f30959a.getFD().sync();
            } catch (IOException e10) {
                t.o("AtomicFile", "Failed to sync file descriptor:", e10);
            }
            this.f30959a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f30959a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f30959a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f30959a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f30959a.write(bArr, i10, i11);
        }
    }

    public b(File file) {
        this.f30957a = file;
        this.f30958b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.f30957a.delete();
        this.f30958b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f30958b.delete();
    }

    public boolean c() {
        return this.f30957a.exists() || this.f30958b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f30957a);
    }

    public final void e() {
        if (this.f30958b.exists()) {
            this.f30957a.delete();
            this.f30958b.renameTo(this.f30957a);
        }
    }

    public OutputStream f() throws IOException {
        if (this.f30957a.exists()) {
            if (this.f30958b.exists()) {
                this.f30957a.delete();
            } else if (!this.f30957a.renameTo(this.f30958b)) {
                t.n("AtomicFile", "Couldn't rename file " + this.f30957a + " to backup file " + this.f30958b);
            }
        }
        try {
            return new a(this.f30957a);
        } catch (FileNotFoundException e10) {
            File parentFile = this.f30957a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f30957a, e10);
            }
            try {
                return new a(this.f30957a);
            } catch (FileNotFoundException e11) {
                throw new IOException("Couldn't create " + this.f30957a, e11);
            }
        }
    }
}
