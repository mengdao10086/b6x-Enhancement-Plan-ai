package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.n0;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends l<AssetFileDescriptor> {
    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.l
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.l
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, SsManifestParser.e.J);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
