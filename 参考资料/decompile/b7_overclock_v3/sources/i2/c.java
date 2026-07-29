package i2;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import g.n0;
import g.p0;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31804a = "a";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends e> T a(InputStream inputStream) {
        return (T) new androidx.versionedparcelable.a(inputStream, null).g0();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends e> T b(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return (T) ((ParcelImpl) parcelable).a();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    @p0
    public static <T extends e> T c(@n0 Bundle bundle, @n0 String str) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(c.class.getClassLoader());
            return (T) b(bundle2.getParcelable("a"));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @p0
    public static <T extends e> List<T> d(Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            bundle2.setClassLoader(c.class.getClassLoader());
            Iterator it2 = bundle2.getParcelableArrayList("a").iterator();
            while (it2.hasNext()) {
                arrayList.add(b((Parcelable) it2.next()));
            }
            return arrayList;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void e(@n0 Bundle bundle, @n0 String str, @p0 e eVar) {
        if (eVar == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("a", h(eVar));
        bundle.putParcelable(str, bundle2);
    }

    public static void f(@n0 Bundle bundle, @n0 String str, @n0 List<? extends e> list) {
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<? extends e> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(h(it2.next()));
        }
        bundle2.putParcelableArrayList("a", arrayList);
        bundle.putParcelable(str, bundle2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void g(e eVar, OutputStream outputStream) {
        androidx.versionedparcelable.a aVar = new androidx.versionedparcelable.a(null, outputStream);
        aVar.l1(eVar);
        aVar.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Parcelable h(e eVar) {
        return new ParcelImpl(eVar);
    }
}
