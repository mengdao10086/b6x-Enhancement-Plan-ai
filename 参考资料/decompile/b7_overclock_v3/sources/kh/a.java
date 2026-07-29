package kh;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap.CompressFormat f37374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f37376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f37377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f37378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Uri f37379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Uri f37380i;

    public a(int i10, int i11, Bitmap.CompressFormat compressFormat, int i12, String str, String str2, b bVar) {
        this.f37372a = i10;
        this.f37373b = i11;
        this.f37374c = compressFormat;
        this.f37375d = i12;
        this.f37376e = str;
        this.f37377f = str2;
        this.f37378g = bVar;
    }

    public Bitmap.CompressFormat a() {
        return this.f37374c;
    }

    public int b() {
        return this.f37375d;
    }

    public Uri c() {
        return this.f37379h;
    }

    public Uri d() {
        return this.f37380i;
    }

    public b e() {
        return this.f37378g;
    }

    public String f() {
        return this.f37376e;
    }

    public String g() {
        return this.f37377f;
    }

    public int h() {
        return this.f37372a;
    }

    public int i() {
        return this.f37373b;
    }

    public void j(Uri uri) {
        this.f37379h = uri;
    }

    public void k(Uri uri) {
        this.f37380i = uri;
    }
}
