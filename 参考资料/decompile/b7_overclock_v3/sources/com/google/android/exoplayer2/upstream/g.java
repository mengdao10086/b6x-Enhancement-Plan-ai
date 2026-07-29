package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import ed.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class g implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f19256b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f19257c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f19258d = 60000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f19259e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19260a;

    public g() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public long a(j.a aVar) {
        IOException iOException = aVar.f19266c;
        return ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) ? ya.g.f56663b : Math.min((aVar.f19267d - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public /* synthetic */ long b(int i10, long j10, IOException iOException, int i11) {
        return t.c(this, i10, j10, iOException, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public /* synthetic */ long c(int i10, long j10, IOException iOException, int i11) {
        return t.a(this, i10, j10, iOException, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public /* synthetic */ void d(long j10) {
        t.e(this, j10);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public long e(j.a aVar) {
        IOException iOException = aVar.f19266c;
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return ya.g.f56663b;
        }
        int i10 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        if (i10 == 403 || i10 == 404 || i10 == 410 || i10 == 416 || i10 == 500 || i10 == 503) {
            return 60000L;
        }
        return ya.g.f56663b;
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public int f(int i10) {
        int i11 = this.f19260a;
        return i11 == -1 ? i10 == 7 ? 6 : 3 : i11;
    }

    public g(int i10) {
        this.f19260a = i10;
    }
}
