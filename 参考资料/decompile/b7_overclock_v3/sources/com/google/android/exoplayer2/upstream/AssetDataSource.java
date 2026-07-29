package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import g.p0;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class AssetDataSource extends ed.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AssetManager f19011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Uri f19012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public InputStream f19013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f19014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19015j;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f19011f = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws AssetDataSourceException {
        try {
            Uri uri = bVar.f19092a;
            this.f19012g = uri;
            String strSubstring = (String) hd.a.g(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith(fh.a.f28350w)) {
                strSubstring = strSubstring.substring(1);
            }
            w(bVar);
            InputStream inputStreamOpen = this.f19011f.open(strSubstring, 1);
            this.f19013h = inputStreamOpen;
            if (inputStreamOpen.skip(bVar.f19098g) < bVar.f19098g) {
                throw new EOFException();
            }
            long j10 = bVar.f19099h;
            if (j10 != -1) {
                this.f19014i = j10;
            } else {
                long jAvailable = this.f19013h.available();
                this.f19014i = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f19014i = -1L;
                }
            }
            this.f19015j = true;
            x(bVar);
            return this.f19014i;
        } catch (IOException e10) {
            throw new AssetDataSourceException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws AssetDataSourceException {
        this.f19012g = null;
        try {
            try {
                InputStream inputStream = this.f19013h;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e10) {
                throw new AssetDataSourceException(e10);
            }
        } finally {
            this.f19013h = null;
            if (this.f19015j) {
                this.f19015j = false;
                v();
            }
        }
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws AssetDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f19014i;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new AssetDataSourceException(e10);
            }
        }
        int i12 = ((InputStream) u0.k(this.f19013h)).read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f19014i == -1) {
                return -1;
            }
            throw new AssetDataSourceException(new EOFException());
        }
        long j11 = this.f19014i;
        if (j11 != -1) {
            this.f19014i = j11 - ((long) i12);
        }
        u(i12);
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f19012g;
    }
}
