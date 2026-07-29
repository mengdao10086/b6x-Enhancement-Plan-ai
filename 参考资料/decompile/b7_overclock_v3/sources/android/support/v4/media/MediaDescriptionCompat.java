package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f927j = "MediaDescriptionCompat";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f928k = "android.media.extra.BT_FOLDER_TYPE";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f929l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f930m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f931n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f932o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f933p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f934q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f935r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f936s = "android.media.extra.DOWNLOAD_STATUS";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f937t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f938u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f939v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f940w = "android.support.v4.media.description.MEDIA_URI";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f941x = "android.support.v4.media.description.NULL_BUNDLE_FLAG";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaDescription f950i;

    public class a implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f955e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f956f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f957g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f958h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f951a, this.f952b, this.f953c, this.f954d, this.f955e, this.f956f, this.f957g, this.f958h);
        }

        public b b(@p0 CharSequence charSequence) {
            this.f954d = charSequence;
            return this;
        }

        public b c(@p0 Bundle bundle) {
            this.f957g = bundle;
            return this;
        }

        public b d(@p0 Bitmap bitmap) {
            this.f955e = bitmap;
            return this;
        }

        public b e(@p0 Uri uri) {
            this.f956f = uri;
            return this;
        }

        public b f(@p0 String str) {
            this.f951a = str;
            return this;
        }

        public b g(@p0 Uri uri) {
            this.f958h = uri;
            return this;
        }

        public b h(@p0 CharSequence charSequence) {
            this.f953c = charSequence;
            return this;
        }

        public b i(@p0 CharSequence charSequence) {
            this.f952b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f942a = str;
        this.f943b = charSequence;
        this.f944c = charSequence2;
        this.f945d = charSequence3;
        this.f946e = bitmap;
        this.f947f = uri;
        this.f948g = bundle;
        this.f949h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        int i10 = Build.VERSION.SDK_INT;
        b bVar = new b();
        MediaDescription mediaDescription = (MediaDescription) obj;
        bVar.f(mediaDescription.getMediaId());
        bVar.i(mediaDescription.getTitle());
        bVar.h(mediaDescription.getSubtitle());
        bVar.b(mediaDescription.getDescription());
        bVar.d(mediaDescription.getIconBitmap());
        bVar.e(mediaDescription.getIconUri());
        Bundle extras = mediaDescription.getExtras();
        if (extras != null) {
            extras = MediaSessionCompat.G(extras);
        }
        Uri uri = extras != null ? (Uri) extras.getParcelable(f940w) : null;
        if (uri == null) {
            bundle = extras;
        } else if (!extras.containsKey(f941x) || extras.size() != 2) {
            extras.remove(f940w);
            extras.remove(f941x);
            bundle = extras;
        }
        bVar.c(bundle);
        if (uri != null) {
            bVar.g(uri);
        } else if (i10 >= 23) {
            bVar.g(mediaDescription.getMediaUri());
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        mediaDescriptionCompatA.f950i = mediaDescription;
        return mediaDescriptionCompatA;
    }

    @p0
    public Uri C() {
        return this.f949h;
    }

    @p0
    public CharSequence F() {
        return this.f944c;
    }

    @p0
    public CharSequence M() {
        return this.f943b;
    }

    @p0
    public CharSequence b() {
        return this.f945d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @p0
    public Bundle e() {
        return this.f948g;
    }

    @p0
    public Bitmap g() {
        return this.f946e;
    }

    @p0
    public Uri j() {
        return this.f947f;
    }

    public Object s() {
        MediaDescription mediaDescription = this.f950i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        int i10 = Build.VERSION.SDK_INT;
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f942a);
        builder.setTitle(this.f943b);
        builder.setSubtitle(this.f944c);
        builder.setDescription(this.f945d);
        builder.setIconBitmap(this.f946e);
        builder.setIconUri(this.f947f);
        Bundle bundle = this.f948g;
        if (i10 < 23 && this.f949h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean(f941x, true);
            }
            bundle.putParcelable(f940w, this.f949h);
        }
        builder.setExtras(bundle);
        if (i10 >= 23) {
            builder.setMediaUri(this.f949h);
        }
        MediaDescription mediaDescriptionBuild = builder.build();
        this.f950i = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    public String toString() {
        return ((Object) this.f943b) + ", " + ((Object) this.f944c) + ", " + ((Object) this.f945d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        ((MediaDescription) s()).writeToParcel(parcel, i10);
    }

    @p0
    public String z() {
        return this.f942a;
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f942a = parcel.readString();
        this.f943b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f944c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f945d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f946e = (Bitmap) parcel.readParcelable(classLoader);
        this.f947f = (Uri) parcel.readParcelable(classLoader);
        this.f948g = parcel.readBundle(classLoader);
        this.f949h = (Uri) parcel.readParcelable(classLoader);
    }
}
