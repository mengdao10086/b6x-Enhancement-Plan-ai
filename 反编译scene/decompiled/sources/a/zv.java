package a;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zv implements Parcelable {
    public static final Parcelable.Creator<zv> CREATOR = new yv();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3889a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public zv(Context context) {
        this.c = 255;
        this.d = -1;
        this.b = new qy(context, iv.TextAppearance_MaterialComponents_Badge).f2653a.getDefaultColor();
        this.f3889a = context.getString(hv.mtrl_badge_numberless_content_description);
        this.f = gv.mtrl_badge_content_description;
        this.g = hv.mtrl_exceed_max_badge_number_content_description;
    }

    public zv(Parcel parcel) {
        this.c = 255;
        this.d = -1;
        this.f8099a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f3889a = parcel.readString();
        this.f = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8099a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f3889a.toString());
        parcel.writeInt(this.f);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
