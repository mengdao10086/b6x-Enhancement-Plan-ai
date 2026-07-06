package android.support.v4.media;

import a.e;
import a.f;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f8118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f3928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f3929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f3930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3932a;
    public final Uri b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final CharSequence f3933b;
    public final CharSequence c;

    public static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.q(e.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f8119a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Uri f3934a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Bundle f3935a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CharSequence f3936a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f3937a;
        public Uri b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public CharSequence f3938b;
        public CharSequence c;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f3937a, this.f3936a, this.f3938b, this.c, this.f8119a, this.f3934a, this.f3935a, this.b);
        }

        public b b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f3935a = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f8119a = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f3934a = uri;
            return this;
        }

        public b f(String str) {
            this.f3937a = str;
            return this;
        }

        public b g(Uri uri) {
            this.b = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f3938b = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f3936a = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f3932a = parcel.readString();
        this.f3930a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3933b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f8118a = (Bitmap) parcel.readParcelable(classLoader);
        this.f3928a = (Uri) parcel.readParcelable(classLoader);
        this.f3929a = parcel.readBundle(classLoader);
        this.b = (Uri) parcel.readParcelable(classLoader);
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f3932a = str;
        this.f3930a = charSequence;
        this.f3933b = charSequence2;
        this.c = charSequence3;
        this.f8118a = bitmap;
        this.f3928a = uri;
        this.f3929a = bundle;
        this.b = uri2;
    }

    public static MediaDescriptionCompat q(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        b bVar = new b();
        bVar.f(e.f(obj));
        bVar.i(e.h(obj));
        bVar.h(e.g(obj));
        bVar.b(e.b(obj));
        bVar.d(e.d(obj));
        bVar.e(e.e(obj));
        Bundle bundleC = e.c(obj);
        if (bundleC != null) {
            MediaSessionCompat.a(bundleC);
            uri = (Uri) bundleC.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = bundleC;
        } else if (!bundleC.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleC.size() != 2) {
            bundleC.remove("android.support.v4.media.description.MEDIA_URI");
            bundleC.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleC;
        }
        bVar.c(bundle);
        if (uri != null) {
            bVar.g(uri);
        } else if (Build.VERSION.SDK_INT >= 23) {
            bVar.g(f.a(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        mediaDescriptionCompatA.f3931a = obj;
        return mediaDescriptionCompatA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object r() {
        if (this.f3931a != null || Build.VERSION.SDK_INT < 21) {
            return this.f3931a;
        }
        Object objB = e.a.b();
        e.a.g(objB, this.f3932a);
        e.a.i(objB, this.f3930a);
        e.a.h(objB, this.f3933b);
        e.a.c(objB, this.c);
        e.a.e(objB, this.f8118a);
        e.a.f(objB, this.f3928a);
        Bundle bundle = this.f3929a;
        if (Build.VERSION.SDK_INT < 23 && this.b != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.b);
        }
        e.a.d(objB, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            f.a.a(objB, this.b);
        }
        Object objA = e.a.a(objB);
        this.f3931a = objA;
        return objA;
    }

    public String toString() {
        return ((Object) this.f3930a) + ", " + ((Object) this.f3933b) + ", " + ((Object) this.c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.i(r(), parcel, i);
            return;
        }
        parcel.writeString(this.f3932a);
        TextUtils.writeToParcel(this.f3930a, parcel, i);
        TextUtils.writeToParcel(this.f3933b, parcel, i);
        TextUtils.writeToParcel(this.c, parcel, i);
        parcel.writeParcelable(this.f8118a, i);
        parcel.writeParcelable(this.f3928a, i);
        parcel.writeBundle(this.f3929a);
        parcel.writeParcelable(this.b, i);
    }
}
