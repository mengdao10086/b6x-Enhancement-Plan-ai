package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.a;
import ed.z;
import g.p0;
import hd.u0;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public final class FileDataSource extends ed.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public RandomAccessFile f19023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Uri f19024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f19025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19026i;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public static final class a implements a.InterfaceC0197a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public z f19027a;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            z zVar = this.f19027a;
            if (zVar != null) {
                fileDataSource.d(zVar);
            }
            return fileDataSource;
        }

        public a e(@p0 z zVar) {
            this.f19027a = zVar;
            return this;
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile y(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) hd.a.g(uri.getPath()), SsManifestParser.e.J);
        } catch (FileNotFoundException e10) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e10);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws FileDataSourceException {
        try {
            Uri uri = bVar.f19092a;
            this.f19024g = uri;
            w(bVar);
            RandomAccessFile randomAccessFileY = y(uri);
            this.f19023f = randomAccessFileY;
            randomAccessFileY.seek(bVar.f19098g);
            long length = bVar.f19099h;
            if (length == -1) {
                length = this.f19023f.length() - bVar.f19098g;
            }
            this.f19025h = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.f19026i = true;
            x(bVar);
            return this.f19025h;
        } catch (IOException e10) {
            throw new FileDataSourceException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws FileDataSourceException {
        this.f19024g = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f19023f;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e10) {
                throw new FileDataSourceException(e10);
            }
        } finally {
            this.f19023f = null;
            if (this.f19026i) {
                this.f19026i = false;
                v();
            }
        }
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws FileDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        if (this.f19025h == 0) {
            return -1;
        }
        try {
            int i12 = ((RandomAccessFile) u0.k(this.f19023f)).read(bArr, i10, (int) Math.min(this.f19025h, i11));
            if (i12 > 0) {
                this.f19025h -= (long) i12;
                u(i12);
            }
            return i12;
        } catch (IOException e10) {
            throw new FileDataSourceException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f19024g;
    }
}
