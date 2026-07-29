package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import g.n0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class h extends b<AssetFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor d(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str);
    }
}
