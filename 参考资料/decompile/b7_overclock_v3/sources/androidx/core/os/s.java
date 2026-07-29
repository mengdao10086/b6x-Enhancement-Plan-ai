package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class s {

    public static class a<T> implements Parcelable.ClassLoaderCreator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t<T> f4673a;

        public a(t<T> tVar) {
            this.f4673a = tVar;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.f4673a.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i10) {
            return this.f4673a.newArray(i10);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f4673a.createFromParcel(parcel, classLoader);
        }
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> a(t<T> tVar) {
        return new a(tVar);
    }
}
