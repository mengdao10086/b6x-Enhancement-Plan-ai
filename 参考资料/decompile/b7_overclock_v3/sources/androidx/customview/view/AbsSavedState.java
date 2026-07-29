package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f5283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbsSavedState f5282b = new AbsSavedState() { // from class: androidx.customview.view.AbsSavedState.1
    };
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a();

    public class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f5282b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AbsSavedState[] newArray(int i10) {
            return new AbsSavedState[i10];
        }
    }

    @p0
    public final Parcelable a() {
        return this.f5283a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f5283a, i10);
    }

    public AbsSavedState() {
        this.f5283a = null;
    }

    public AbsSavedState(@n0 Parcelable parcelable) {
        if (parcelable != null) {
            this.f5283a = parcelable == f5282b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(@n0 Parcel parcel) {
        this(parcel, null);
    }

    public AbsSavedState(@n0 Parcel parcel, @p0 ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f5283a = parcelable == null ? f5282b : parcelable;
    }
}
