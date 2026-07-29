package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12212d = "LocalUriFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f12214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f12215c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f12214b = contentResolver;
        this.f12213a = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t10 = this.f12215c;
        if (t10 != null) {
            try {
                c(t10);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(T t10) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    public abstract T d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.d
    @n0
    public DataSource e() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(@n0 Priority priority, @n0 d.a<? super T> aVar) {
        try {
            T tD = d(this.f12213a, this.f12214b);
            this.f12215c = tD;
            aVar.d(tD);
        } catch (FileNotFoundException e10) {
            aVar.c(e10);
        }
    }
}
