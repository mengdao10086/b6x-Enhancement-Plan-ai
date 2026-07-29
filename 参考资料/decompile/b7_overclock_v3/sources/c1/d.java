package c1;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9691a;

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final Uri f9693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final ClipDescription f9694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final Uri f9695c;

        public b(@n0 Uri uri, @n0 ClipDescription clipDescription, @p0 Uri uri2) {
            this.f9693a = uri;
            this.f9694b = clipDescription;
            this.f9695c = uri2;
        }

        @Override // c1.d.c
        @p0
        public Uri a() {
            return this.f9695c;
        }

        @Override // c1.d.c
        @n0
        public Uri b() {
            return this.f9693a;
        }

        @Override // c1.d.c
        public void c() {
        }

        @Override // c1.d.c
        @n0
        public ClipDescription d() {
            return this.f9694b;
        }

        @Override // c1.d.c
        @p0
        public Object e() {
            return null;
        }

        @Override // c1.d.c
        public void f() {
        }
    }

    public interface c {
        @p0
        Uri a();

        @n0
        Uri b();

        void c();

        @n0
        ClipDescription d();

        @p0
        Object e();

        void f();
    }

    public d(@n0 Uri uri, @n0 ClipDescription clipDescription, @p0 Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f9691a = new a(uri, clipDescription, uri2);
        } else {
            this.f9691a = new b(uri, clipDescription, uri2);
        }
    }

    @p0
    public static d g(@p0 Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new d(new a(obj));
        }
        return null;
    }

    @n0
    public Uri a() {
        return this.f9691a.b();
    }

    @n0
    public ClipDescription b() {
        return this.f9691a.d();
    }

    @p0
    public Uri c() {
        return this.f9691a.a();
    }

    public void d() {
        this.f9691a.f();
    }

    public void e() {
        this.f9691a.c();
    }

    @p0
    public Object f() {
        return this.f9691a.e();
    }

    @v0(25)
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final InputContentInfo f9692a;

        public a(@n0 Object obj) {
            this.f9692a = (InputContentInfo) obj;
        }

        @Override // c1.d.c
        @p0
        public Uri a() {
            return this.f9692a.getLinkUri();
        }

        @Override // c1.d.c
        @n0
        public Uri b() {
            return this.f9692a.getContentUri();
        }

        @Override // c1.d.c
        public void c() {
            this.f9692a.requestPermission();
        }

        @Override // c1.d.c
        @n0
        public ClipDescription d() {
            return this.f9692a.getDescription();
        }

        @Override // c1.d.c
        @n0
        public Object e() {
            return this.f9692a;
        }

        @Override // c1.d.c
        public void f() {
            this.f9692a.releasePermission();
        }

        public a(@n0 Uri uri, @n0 ClipDescription clipDescription, @p0 Uri uri2) {
            this.f9692a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public d(@n0 c cVar) {
        this.f9691a = cVar;
    }
}
