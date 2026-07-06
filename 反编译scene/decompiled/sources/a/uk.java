package a;

import a.hn;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class uk implements Parcelable {
    public static final Parcelable.Creator<uk> CREATOR = new tk();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f3186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String> f3188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3189a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final CharSequence f3190b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<String> f3191b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3192b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f3193b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final ArrayList<String> f3194c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int[] f3195c;
    public final int d;
    public final int e;

    public uk(sk skVar) {
        int size = ((hm) skVar).f1187a.size();
        this.f3189a = new int[size * 5];
        if (!((hm) skVar).f1188a) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3188a = new ArrayList<>(size);
        this.f3193b = new int[size];
        this.f3195c = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            gm gmVar = ((hm) skVar).f1187a.get(i);
            int i3 = i2 + 1;
            this.f3189a[i2] = gmVar.f6220a;
            ArrayList<String> arrayList = this.f3188a;
            Fragment fragment = gmVar.f1037a;
            arrayList.add(fragment != null ? fragment.f4267a : null);
            int[] iArr = this.f3189a;
            int i4 = i3 + 1;
            iArr[i3] = gmVar.b;
            int i5 = i4 + 1;
            iArr[i4] = gmVar.c;
            int i6 = i5 + 1;
            iArr[i5] = gmVar.d;
            iArr[i6] = gmVar.e;
            this.f3193b[i] = gmVar.f1036a.ordinal();
            this.f3195c[i] = gmVar.f1038b.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.f7605a = skVar.e;
        this.b = skVar.f;
        this.f3187a = ((hm) skVar).f1186a;
        this.c = skVar.i;
        this.d = skVar.g;
        this.f3186a = ((hm) skVar).f1185a;
        this.e = skVar.h;
        this.f3190b = ((hm) skVar).f1189b;
        this.f3191b = ((hm) skVar).f1190b;
        this.f3194c = ((hm) skVar).f1192c;
        this.f3192b = ((hm) skVar).f1191b;
    }

    public uk(Parcel parcel) {
        this.f3189a = parcel.createIntArray();
        this.f3188a = parcel.createStringArrayList();
        this.f3193b = parcel.createIntArray();
        this.f3195c = parcel.createIntArray();
        this.f7605a = parcel.readInt();
        this.b = parcel.readInt();
        this.f3187a = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f3186a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = parcel.readInt();
        this.f3190b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3191b = parcel.createStringArrayList();
        this.f3194c = parcel.createStringArrayList();
        this.f3192b = parcel.readInt() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public sk q(yl ylVar) {
        sk skVar = new sk(ylVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f3189a.length) {
            gm gmVar = new gm();
            int i3 = i + 1;
            gmVar.f6220a = this.f3189a[i];
            if (yl.h) {
                Log.v("FragmentManager", "Instantiate " + skVar + " op #" + i2 + " base fragment #" + this.f3189a[i3]);
            }
            String str = this.f3188a.get(i2);
            gmVar.f1037a = str != null ? ylVar.f3732a.get(str) : null;
            gmVar.f1036a = hn.b.values()[this.f3193b[i2]];
            gmVar.f1038b = hn.b.values()[this.f3195c[i2]];
            int[] iArr = this.f3189a;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            gmVar.b = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            gmVar.c = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            gmVar.d = i9;
            int i10 = iArr[i8];
            gmVar.e = i10;
            ((hm) skVar).f6323a = i5;
            ((hm) skVar).b = i7;
            ((hm) skVar).c = i9;
            ((hm) skVar).d = i10;
            skVar.d(gmVar);
            i2++;
            i = i8 + 1;
        }
        skVar.e = this.f7605a;
        skVar.f = this.b;
        ((hm) skVar).f1186a = this.f3187a;
        skVar.i = this.c;
        ((hm) skVar).f1188a = true;
        skVar.g = this.d;
        ((hm) skVar).f1185a = this.f3186a;
        skVar.h = this.e;
        ((hm) skVar).f1189b = this.f3190b;
        ((hm) skVar).f1190b = this.f3191b;
        ((hm) skVar).f1192c = this.f3194c;
        ((hm) skVar).f1191b = this.f3192b;
        skVar.p(1);
        return skVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f3189a);
        parcel.writeStringList(this.f3188a);
        parcel.writeIntArray(this.f3193b);
        parcel.writeIntArray(this.f3195c);
        parcel.writeInt(this.f7605a);
        parcel.writeInt(this.b);
        parcel.writeString(this.f3187a);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        TextUtils.writeToParcel(this.f3186a, parcel, 0);
        parcel.writeInt(this.e);
        TextUtils.writeToParcel(this.f3190b, parcel, 0);
        parcel.writeStringList(this.f3191b);
        parcel.writeStringList(this.f3194c);
        parcel.writeInt(this.f3192b ? 1 : 0);
    }
}
