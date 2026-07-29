package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f5773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f5774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BackStackRecordState[] f5775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<String> f5778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<BackStackState> f5779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<FragmentManager.LaunchedFragmentInfo> f5780h;

    public class a implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
        this.f5777e = null;
        this.f5778f = new ArrayList<>();
        this.f5779g = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f5773a);
        parcel.writeStringList(this.f5774b);
        parcel.writeTypedArray(this.f5775c, i10);
        parcel.writeInt(this.f5776d);
        parcel.writeString(this.f5777e);
        parcel.writeStringList(this.f5778f);
        parcel.writeTypedList(this.f5779g);
        parcel.writeTypedList(this.f5780h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f5777e = null;
        this.f5778f = new ArrayList<>();
        this.f5779g = new ArrayList<>();
        this.f5773a = parcel.createStringArrayList();
        this.f5774b = parcel.createStringArrayList();
        this.f5775c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f5776d = parcel.readInt();
        this.f5777e = parcel.readString();
        this.f5778f = parcel.createStringArrayList();
        this.f5779g = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f5780h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
