package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {

    @n0
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final Intent f1385b;

    public class a implements Parcelable.Creator<ActivityResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult createFromParcel(@n0 Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult[] newArray(int i10) {
            return new ActivityResult[i10];
        }
    }

    public ActivityResult(int i10, @p0 Intent intent) {
        this.f1384a = i10;
        this.f1385b = intent;
    }

    @n0
    public static String e(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    @p0
    public Intent a() {
        return this.f1385b;
    }

    public int b() {
        return this.f1384a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + e(this.f1384a) + ", data=" + this.f1385b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeInt(this.f1384a);
        parcel.writeInt(this.f1385b == null ? 0 : 1);
        Intent intent = this.f1385b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.f1384a = parcel.readInt();
        this.f1385b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
