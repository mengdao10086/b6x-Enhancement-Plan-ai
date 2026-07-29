package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaMetadataCompat implements Parcelable {
    public static final String A = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String B = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String C = "android.media.metadata.DISPLAY_ICON";
    public static final String C1 = "android.media.metadata.DOWNLOAD_STATUS";
    public static final int C2 = 2;
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final String D = "android.media.metadata.DISPLAY_ICON_URI";
    public static final androidx.collection.a<String, Integer> E7;
    public static final String[] F7;
    public static final String[] G7;
    public static final String[] H7;
    public static final String K0 = "android.media.metadata.MEDIA_URI";
    public static final int K1 = 0;
    public static final int K2 = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f959d = "MediaMetadata";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f960e = "android.media.metadata.TITLE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f961f = "android.media.metadata.ARTIST";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f962g = "android.media.metadata.DURATION";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f963h = "android.media.metadata.ALBUM";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f964i = "android.media.metadata.AUTHOR";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f965j = "android.media.metadata.WRITER";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f966k = "android.media.metadata.COMPOSER";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f967k0 = "android.media.metadata.MEDIA_ID";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f968k1 = "android.media.metadata.BT_FOLDER_TYPE";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f969l = "android.media.metadata.COMPILATION";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f970m = "android.media.metadata.DATE";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f971n = "android.media.metadata.YEAR";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f972o = "android.media.metadata.GENRE";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f973p = "android.media.metadata.TRACK_NUMBER";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f974q = "android.media.metadata.NUM_TRACKS";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f975r = "android.media.metadata.DISC_NUMBER";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f976s = "android.media.metadata.ALBUM_ARTIST";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f977t = "android.media.metadata.ART";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f978u = "android.media.metadata.ART_URI";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f979v = "android.media.metadata.ALBUM_ART";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final String f980v1 = "android.media.metadata.ADVERTISEMENT";

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f981v2 = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f982w = "android.media.metadata.ALBUM_ART_URI";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f983x = "android.media.metadata.USER_RATING";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f984y = "android.media.metadata.RATING";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f985z = "android.media.metadata.DISPLAY_TITLE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaMetadata f987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MediaDescriptionCompat f988c;

    public class a implements Parcelable.Creator<MediaMetadataCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat[] newArray(int i10) {
            return new MediaMetadataCompat[i10];
        }
    }

    static {
        androidx.collection.a<String, Integer> aVar = new androidx.collection.a<>();
        E7 = aVar;
        aVar.put(f960e, 1);
        aVar.put(f961f, 1);
        aVar.put(f962g, 0);
        aVar.put(f963h, 1);
        aVar.put(f964i, 1);
        aVar.put(f965j, 1);
        aVar.put(f966k, 1);
        aVar.put(f969l, 1);
        aVar.put(f970m, 1);
        aVar.put(f971n, 0);
        aVar.put(f972o, 1);
        aVar.put(f973p, 0);
        aVar.put(f974q, 0);
        aVar.put(f975r, 0);
        aVar.put(f976s, 1);
        aVar.put(f977t, 2);
        aVar.put(f978u, 1);
        aVar.put(f979v, 2);
        aVar.put(f982w, 1);
        aVar.put(f983x, 3);
        aVar.put(f984y, 3);
        aVar.put(f985z, 1);
        aVar.put(A, 1);
        aVar.put(B, 1);
        aVar.put(C, 2);
        aVar.put(D, 1);
        aVar.put(f967k0, 1);
        aVar.put(f968k1, 0);
        aVar.put(K0, 1);
        aVar.put(f980v1, 0);
        aVar.put(C1, 0);
        F7 = new String[]{f960e, f961f, f963h, f976s, f965j, f964i, f966k};
        G7 = new String[]{C, f977t, f979v};
        H7 = new String[]{D, f978u, f982w};
        CREATOR = new a();
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.f986a = bundle2;
        MediaSessionCompat.c(bundle2);
    }

    public static MediaMetadataCompat b(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        mediaMetadata.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        mediaMetadataCompatCreateFromParcel.f987b = mediaMetadata;
        return mediaMetadataCompatCreateFromParcel;
    }

    public RatingCompat C(String str) {
        try {
            return RatingCompat.a(this.f986a.getParcelable(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public String F(String str) {
        CharSequence charSequence = this.f986a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence M(String str) {
        return this.f986a.getCharSequence(str);
    }

    public Set<String> S() {
        return this.f986a.keySet();
    }

    public int T() {
        return this.f986a.size();
    }

    public boolean a(String str) {
        return this.f986a.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap e(String str) {
        try {
            return (Bitmap) this.f986a.getParcelable(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public Bundle g() {
        return new Bundle(this.f986a);
    }

    public MediaDescriptionCompat j() {
        Bitmap bitmapE;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.f988c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String strF = F(f967k0);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence charSequenceM = M(f985z);
        if (TextUtils.isEmpty(charSequenceM)) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < 3) {
                String[] strArr = F7;
                if (i11 >= strArr.length) {
                    break;
                }
                int i12 = i11 + 1;
                CharSequence charSequenceM2 = M(strArr[i11]);
                if (!TextUtils.isEmpty(charSequenceM2)) {
                    charSequenceArr[i10] = charSequenceM2;
                    i10++;
                }
                i11 = i12;
            }
        } else {
            charSequenceArr[0] = charSequenceM;
            charSequenceArr[1] = M(A);
            charSequenceArr[2] = M(B);
        }
        int i13 = 0;
        while (true) {
            String[] strArr2 = G7;
            if (i13 >= strArr2.length) {
                bitmapE = null;
                break;
            }
            bitmapE = e(strArr2[i13]);
            if (bitmapE != null) {
                break;
            }
            i13++;
        }
        int i14 = 0;
        while (true) {
            String[] strArr3 = H7;
            if (i14 >= strArr3.length) {
                uri = null;
                break;
            }
            String strF2 = F(strArr3[i14]);
            if (!TextUtils.isEmpty(strF2)) {
                uri = Uri.parse(strF2);
                break;
            }
            i14++;
        }
        String strF3 = F(K0);
        Uri uri2 = TextUtils.isEmpty(strF3) ? null : Uri.parse(strF3);
        MediaDescriptionCompat.b bVar = new MediaDescriptionCompat.b();
        bVar.f(strF);
        bVar.i(charSequenceArr[0]);
        bVar.h(charSequenceArr[1]);
        bVar.b(charSequenceArr[2]);
        bVar.d(bitmapE);
        bVar.e(uri);
        bVar.g(uri2);
        Bundle bundle = new Bundle();
        if (this.f986a.containsKey(f968k1)) {
            bundle.putLong(MediaDescriptionCompat.f928k, s(f968k1));
        }
        if (this.f986a.containsKey(C1)) {
            bundle.putLong(MediaDescriptionCompat.f936s, s(C1));
        }
        if (!bundle.isEmpty()) {
            bVar.c(bundle);
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        this.f988c = mediaDescriptionCompatA;
        return mediaDescriptionCompatA;
    }

    public long s(String str) {
        return this.f986a.getLong(str, 0L);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f986a);
    }

    public Object z() {
        if (this.f987b == null) {
            Parcel parcelObtain = Parcel.obtain();
            writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            this.f987b = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
        }
        return this.f987b;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f989a;

        public b() {
            this.f989a = new Bundle();
        }

        public MediaMetadataCompat a() {
            return new MediaMetadataCompat(this.f989a);
        }

        public b b(String str, Bitmap bitmap) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.E7;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 2) {
                this.f989a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public b c(String str, long j10) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.E7;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 0) {
                this.f989a.putLong(str, j10);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public b d(String str, RatingCompat ratingCompat) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.E7;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 3) {
                this.f989a.putParcelable(str, (Parcelable) ratingCompat.e());
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public b e(String str, String str2) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.E7;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 1) {
                this.f989a.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public b f(String str, CharSequence charSequence) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.E7;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 1) {
                this.f989a.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }

        public final Bitmap g(Bitmap bitmap, int i10) {
            float f10 = i10;
            float fMin = Math.min(f10 / bitmap.getWidth(), f10 / bitmap.getHeight());
            return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), true);
        }

        public b(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = new Bundle(mediaMetadataCompat.f986a);
            this.f989a = bundle;
            MediaSessionCompat.c(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public b(MediaMetadataCompat mediaMetadataCompat, int i10) {
            this(mediaMetadataCompat);
            for (String str : this.f989a.keySet()) {
                Object obj = this.f989a.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i10 || bitmap.getWidth() > i10) {
                        b(str, g(bitmap, i10));
                    }
                }
            }
        }
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f986a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
