package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12181d = "AssetPathFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f12183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f12184c;

    public b(AssetManager assetManager, String str) {
        this.f12183b = assetManager;
        this.f12182a = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t10 = this.f12184c;
        if (t10 == null) {
            return;
        }
        try {
            c(t10);
        } catch (IOException unused) {
        }
    }

    public abstract void c(T t10) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    public abstract T d(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    @n0
    public DataSource e() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void f(@n0 Priority priority, @n0 d.a<? super T> aVar) {
        try {
            T tD = d(this.f12183b, this.f12182a);
            this.f12184c = tD;
            aVar.d(tD);
        } catch (IOException e10) {
            aVar.c(e10);
        }
    }
}
