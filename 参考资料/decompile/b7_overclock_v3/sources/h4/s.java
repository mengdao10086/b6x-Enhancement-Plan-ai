package h4;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import g.n0;
import g.p0;
import h4.n;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class s<Data> implements n<Integer, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30511c = "ResourceLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<Uri, Data> f30512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f30513b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f30514a;

        public a(Resources resources) {
            this.f30514a = resources;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        public n<Integer, AssetFileDescriptor> c(r rVar) {
            return new s(this.f30514a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f30515a;

        public b(Resources resources) {
            this.f30515a = resources;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Integer, ParcelFileDescriptor> c(r rVar) {
            return new s(this.f30515a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f30516a;

        public c(Resources resources) {
            this.f30516a = resources;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Integer, InputStream> c(r rVar) {
            return new s(this.f30516a, rVar.d(Uri.class, InputStream.class));
        }
    }

    public static class d implements o<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f30517a;

        public d(Resources resources) {
            this.f30517a = resources;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Integer, Uri> c(r rVar) {
            return new s(this.f30517a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f30513b = resources;
        this.f30512a = nVar;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 Integer num, int i10, int i11, @n0 c4.e eVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f30512a.a(uriD, i10, i11, eVar);
    }

    @p0
    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f30513b.getResourcePackageName(num.intValue()) + zc.f.f58380j + this.f30513b.getResourceTypeName(num.intValue()) + zc.f.f58380j + this.f30513b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable(f30511c, 5)) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received invalid resource id: ");
            sb2.append(num);
            return null;
        }
    }

    @Override // h4.n
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 Integer num) {
        return true;
    }
}
