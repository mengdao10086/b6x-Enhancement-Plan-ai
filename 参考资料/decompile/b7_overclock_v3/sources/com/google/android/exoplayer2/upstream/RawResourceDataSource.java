package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import g.p0;
import hd.u0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class RawResourceDataSource extends ed.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f19064m = "rawresource";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Resources f19065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f19066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public Uri f19067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public AssetFileDescriptor f19068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public InputStream f19069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f19070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19071l;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f19065f = context.getResources();
        this.f19066g = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i10) {
        return Uri.parse("rawresource:///" + i10);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws RawResourceDataSourceException {
        int identifier;
        String str;
        Uri uri = bVar.f19092a;
        this.f19067h = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals(c.f19120t, uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) hd.a.g(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) hd.a.g(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } else {
            if (!TextUtils.equals(c.f19120t, uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource");
            }
            String strSubstring = (String) hd.a.g(uri.getPath());
            if (strSubstring.startsWith(fh.a.f28350w)) {
                strSubstring = strSubstring.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb2.append(str);
            sb2.append(strSubstring);
            identifier = this.f19065f.getIdentifier(sb2.toString(), "raw", this.f19066g);
            if (identifier == 0) {
                throw new RawResourceDataSourceException("Resource not found.");
            }
        }
        w(bVar);
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f19065f.openRawResourceFd(identifier);
        this.f19068i = assetFileDescriptorOpenRawResourceFd;
        if (assetFileDescriptorOpenRawResourceFd == null) {
            throw new RawResourceDataSourceException("Resource is compressed: " + uri);
        }
        FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
        this.f19069j = fileInputStream;
        try {
            fileInputStream.skip(assetFileDescriptorOpenRawResourceFd.getStartOffset());
            if (fileInputStream.skip(bVar.f19098g) < bVar.f19098g) {
                throw new EOFException();
            }
            long j10 = bVar.f19099h;
            if (j10 != -1) {
                this.f19070k = j10;
            } else {
                long length = assetFileDescriptorOpenRawResourceFd.getLength();
                this.f19070k = length != -1 ? length - bVar.f19098g : -1L;
            }
            this.f19071l = true;
            x(bVar);
            return this.f19070k;
        } catch (IOException e10) {
            throw new RawResourceDataSourceException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws RawResourceDataSourceException {
        this.f19067h = null;
        try {
            try {
                InputStream inputStream = this.f19069j;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f19069j = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f19068i;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f19068i = null;
                        if (this.f19071l) {
                            this.f19071l = false;
                            v();
                        }
                    }
                } catch (IOException e10) {
                    throw new RawResourceDataSourceException(e10);
                }
            } catch (IOException e11) {
                throw new RawResourceDataSourceException(e11);
            }
        } catch (Throwable th2) {
            this.f19069j = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f19068i;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f19068i = null;
                    if (this.f19071l) {
                        this.f19071l = false;
                        v();
                    }
                    throw th2;
                } catch (IOException e12) {
                    throw new RawResourceDataSourceException(e12);
                }
            } finally {
                this.f19068i = null;
                if (this.f19071l) {
                    this.f19071l = false;
                    v();
                }
            }
        }
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws RawResourceDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f19070k;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new RawResourceDataSourceException(e10);
            }
        }
        int i12 = ((InputStream) u0.k(this.f19069j)).read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f19070k == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException(new EOFException());
        }
        long j11 = this.f19070k;
        if (j11 != -1) {
            this.f19070k = j11 - ((long) i12);
        }
        u(i12);
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f19067h;
    }
}
