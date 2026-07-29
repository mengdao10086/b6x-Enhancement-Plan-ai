package cl;

import android.os.Parcelable;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final /* synthetic */ <T extends Parcelable> Parcelable.Creator<T> a() throws IllegalAccessException {
        f0.y(4, i1.a.f31577d5);
        Object obj = Parcelable.class.getDeclaredField("CREATOR").get(null);
        Parcelable.Creator<T> creator = obj instanceof Parcelable.Creator ? (Parcelable.Creator) obj : null;
        if (creator != null) {
            return creator;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not access CREATOR field in class ");
        f0.y(4, i1.a.f31577d5);
        sb2.append(n0.d(Parcelable.class).K());
        throw new IllegalArgumentException(sb2.toString());
    }
}
