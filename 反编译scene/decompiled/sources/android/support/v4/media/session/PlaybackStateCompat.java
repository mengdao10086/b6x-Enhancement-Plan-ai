package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f8128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f3945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f3946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<CustomAction> f3947a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f3948b;
    public final long c;
    public final long d;
    public final long e;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8129a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Bundle f3949a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CharSequence f3950a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f3951a;

        public static class a implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f3951a = parcel.readString();
            this.f3950a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f8129a = parcel.readInt();
            this.f3949a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f3950a) + ", mIcon=" + this.f8129a + ", mExtras=" + this.f3949a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3951a);
            TextUtils.writeToParcel(this.f3950a, parcel, i);
            parcel.writeInt(this.f8129a);
            parcel.writeBundle(this.f3949a);
        }
    }

    public static class a implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f3943a = parcel.readInt();
        this.f3944a = parcel.readLong();
        this.f8128a = parcel.readFloat();
        this.d = parcel.readLong();
        this.f3948b = parcel.readLong();
        this.c = parcel.readLong();
        this.f3946a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3947a = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.e = parcel.readLong();
        this.f3945a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f3943a + ", position=" + this.f3944a + ", buffered position=" + this.f3948b + ", speed=" + this.f8128a + ", updated=" + this.d + ", actions=" + this.c + ", error code=" + this.b + ", error message=" + this.f3946a + ", custom actions=" + this.f3947a + ", active item id=" + this.e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3943a);
        parcel.writeLong(this.f3944a);
        parcel.writeFloat(this.f8128a);
        parcel.writeLong(this.d);
        parcel.writeLong(this.f3948b);
        parcel.writeLong(this.c);
        TextUtils.writeToParcel(this.f3946a, parcel, i);
        parcel.writeTypedList(this.f3947a);
        parcel.writeLong(this.e);
        parcel.writeBundle(this.f3945a);
        parcel.writeInt(this.b);
    }
}
