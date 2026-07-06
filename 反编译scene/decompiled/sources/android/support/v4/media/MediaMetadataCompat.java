package android.support.v4.media;

import a.ba;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ba<String, Integer> f8120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f3939a;

    public static class a implements Parcelable.Creator<MediaMetadataCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    static {
        ba<String, Integer> baVar = new ba<>();
        f8120a = baVar;
        baVar.put("android.media.metadata.TITLE", 1);
        f8120a.put("android.media.metadata.ARTIST", 1);
        f8120a.put("android.media.metadata.DURATION", 0);
        f8120a.put("android.media.metadata.ALBUM", 1);
        f8120a.put("android.media.metadata.AUTHOR", 1);
        f8120a.put("android.media.metadata.WRITER", 1);
        f8120a.put("android.media.metadata.COMPOSER", 1);
        f8120a.put("android.media.metadata.COMPILATION", 1);
        f8120a.put("android.media.metadata.DATE", 1);
        f8120a.put("android.media.metadata.YEAR", 0);
        f8120a.put("android.media.metadata.GENRE", 1);
        f8120a.put("android.media.metadata.TRACK_NUMBER", 0);
        f8120a.put("android.media.metadata.NUM_TRACKS", 0);
        f8120a.put("android.media.metadata.DISC_NUMBER", 0);
        f8120a.put("android.media.metadata.ALBUM_ARTIST", 1);
        f8120a.put("android.media.metadata.ART", 2);
        f8120a.put("android.media.metadata.ART_URI", 1);
        f8120a.put("android.media.metadata.ALBUM_ART", 2);
        f8120a.put("android.media.metadata.ALBUM_ART_URI", 1);
        f8120a.put("android.media.metadata.USER_RATING", 3);
        f8120a.put("android.media.metadata.RATING", 3);
        f8120a.put("android.media.metadata.DISPLAY_TITLE", 1);
        f8120a.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        f8120a.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        f8120a.put("android.media.metadata.DISPLAY_ICON", 2);
        f8120a.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        f8120a.put("android.media.metadata.MEDIA_ID", 1);
        f8120a.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        f8120a.put("android.media.metadata.MEDIA_URI", 1);
        f8120a.put("android.media.metadata.ADVERTISEMENT", 0);
        f8120a.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new a();
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f3939a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f3939a);
    }
}
