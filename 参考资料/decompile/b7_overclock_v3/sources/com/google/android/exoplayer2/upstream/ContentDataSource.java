package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.p0;
import hd.u0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class ContentDataSource extends ed.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ContentResolver f19016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Uri f19017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public AssetFileDescriptor f19018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public FileInputStream f19019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f19020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19021k;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f19016f = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws ContentDataSourceException {
        try {
            Uri uri = bVar.f19092a;
            this.f19017g = uri;
            w(bVar);
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f19016f.openAssetFileDescriptor(uri, SsManifestParser.e.J);
            this.f19018h = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + uri);
            }
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f19019i = fileInputStream;
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(bVar.f19098g + startOffset) - startOffset;
            if (jSkip != bVar.f19098g) {
                throw new EOFException();
            }
            long j10 = bVar.f19099h;
            if (j10 != -1) {
                this.f19020j = j10;
            } else {
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.f19020j = -1L;
                    } else {
                        long jPosition = size - channel.position();
                        this.f19020j = jPosition;
                        if (jPosition < 0) {
                            throw new EOFException();
                        }
                    }
                } else {
                    long j11 = length - jSkip;
                    this.f19020j = j11;
                    if (j11 < 0) {
                        throw new EOFException();
                    }
                }
            }
            this.f19021k = true;
            x(bVar);
            return this.f19020j;
        } catch (IOException e10) {
            throw new ContentDataSourceException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws ContentDataSourceException {
        this.f19017g = null;
        try {
            try {
                FileInputStream fileInputStream = this.f19019i;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f19019i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f19018h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f19018h = null;
                        if (this.f19021k) {
                            this.f19021k = false;
                            v();
                        }
                    }
                } catch (IOException e10) {
                    throw new ContentDataSourceException(e10);
                }
            } catch (IOException e11) {
                throw new ContentDataSourceException(e11);
            }
        } catch (Throwable th2) {
            this.f19019i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f19018h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f19018h = null;
                    if (this.f19021k) {
                        this.f19021k = false;
                        v();
                    }
                    throw th2;
                } catch (IOException e12) {
                    throw new ContentDataSourceException(e12);
                }
            } finally {
                this.f19018h = null;
                if (this.f19021k) {
                    this.f19021k = false;
                    v();
                }
            }
        }
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws ContentDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f19020j;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new ContentDataSourceException(e10);
            }
        }
        int i12 = ((FileInputStream) u0.k(this.f19019i)).read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f19020j == -1) {
                return -1;
            }
            throw new ContentDataSourceException(new EOFException());
        }
        long j11 = this.f19020j;
        if (j11 != -1) {
            this.f19020j = j11 - ((long) i12);
        }
        u(i12);
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f19017g;
    }
}
