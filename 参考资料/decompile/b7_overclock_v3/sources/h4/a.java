package h4;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import g.n0;
import h4.n;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30426c = "android_asset";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f30427d = "file:///android_asset/";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f30428e = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f30429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0361a<Data> f30430b;

    /* JADX INFO: renamed from: h4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0361a<Data> {
        com.bumptech.glide.load.data.d<Data> b(AssetManager assetManager, String str);
    }

    public static class b implements o<Uri, AssetFileDescriptor>, InterfaceC0361a<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f30431a;

        public b(AssetManager assetManager) {
            this.f30431a = assetManager;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.a.InterfaceC0361a
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> b(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // h4.o
        @n0
        public n<Uri, AssetFileDescriptor> c(r rVar) {
            return new a(this.f30431a, this);
        }
    }

    public static class c implements o<Uri, InputStream>, InterfaceC0361a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f30432a;

        public c(AssetManager assetManager) {
            this.f30432a = assetManager;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.a.InterfaceC0361a
        public com.bumptech.glide.load.data.d<InputStream> b(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // h4.o
        @n0
        public n<Uri, InputStream> c(r rVar) {
            return new a(this.f30432a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0361a<Data> interfaceC0361a) {
        this.f30429a = assetManager;
        this.f30430b = interfaceC0361a;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 Uri uri, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(uri), this.f30430b.b(this.f30429a, uri.toString().substring(f30428e)));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Uri uri) {
        return m7.a.f40702b.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f30426c.equals(uri.getPathSegments().get(0));
    }
}
