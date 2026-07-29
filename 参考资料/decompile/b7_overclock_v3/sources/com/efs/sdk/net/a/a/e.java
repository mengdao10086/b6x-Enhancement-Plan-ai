package com.efs.sdk.net.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends FilterOutputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f13061b = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<Void> f13062a;

    public static class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f13063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OutputStream f13064b;

        public a(InputStream inputStream, OutputStream outputStream) {
            this.f13063a = inputStream;
            this.f13064b = outputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws IOException {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f13063a);
            try {
                i.a(gZIPInputStream, this.f13064b, new byte[1024]);
                gZIPInputStream.close();
                this.f13064b.close();
                return null;
            } catch (Throwable th2) {
                gZIPInputStream.close();
                this.f13064b.close();
                throw th2;
            }
        }
    }

    private e(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.f13062a = future;
    }

    public static e a(OutputStream outputStream) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new e(new PipedOutputStream(pipedInputStream), f13061b.submit(new a(pipedInputStream, outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        try {
            super.close();
            try {
            } catch (IOException e10) {
                throw e10;
            }
        } finally {
            try {
                a(this.f13062a);
            } catch (IOException unused) {
            }
        }
    }

    private static <T> T a(Future<T> future) throws Throwable {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                d.a(cause, IOException.class);
                d.a(cause, Error.class);
                d.a(cause, RuntimeException.class);
                throw new RuntimeException(cause);
            }
        }
    }
}
