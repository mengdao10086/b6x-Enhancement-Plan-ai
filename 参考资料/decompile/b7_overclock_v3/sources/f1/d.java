package f1;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f27920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f27921d;

    public d(@p0 a aVar, Context context, Uri uri) {
        super(aVar);
        this.f27920c = context;
        this.f27921d = uri;
    }

    @Override // f1.a
    public boolean a() {
        return b.a(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public boolean b() {
        return b.b(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public a c(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.a
    public a d(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.a
    public boolean e() {
        try {
            return DocumentsContract.deleteDocument(this.f27920c.getContentResolver(), this.f27921d);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // f1.a
    public boolean f() {
        return b.d(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    @p0
    public String k() {
        return b.f(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    @p0
    public String m() {
        return b.h(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public Uri n() {
        return this.f27921d;
    }

    @Override // f1.a
    public boolean o() {
        return b.i(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public boolean q() {
        return b.j(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public boolean r() {
        return b.k(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public long s() {
        return b.l(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public long t() {
        return b.m(this.f27920c, this.f27921d);
    }

    @Override // f1.a
    public a[] u() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.a
    public boolean v(String str) {
        throw new UnsupportedOperationException();
    }
}
