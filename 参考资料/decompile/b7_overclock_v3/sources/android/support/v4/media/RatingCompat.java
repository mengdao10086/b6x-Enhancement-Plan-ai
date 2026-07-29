package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f990d = "Rating";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f991e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f992f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f993g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f994h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f995i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f996j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f997k = 6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f998l = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1001c;

    public class a implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i10) {
            return new RatingCompat[i10];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface b {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public RatingCompat(int i10, float f10) {
        this.f999a = i10;
        this.f1000b = f10;
    }

    public static RatingCompat F(boolean z10) {
        return new RatingCompat(1, z10 ? 1.0f : 0.0f);
    }

    public static RatingCompat M(float f10) {
        if (f10 < 0.0f || f10 > 100.0f) {
            return null;
        }
        return new RatingCompat(6, f10);
    }

    public static RatingCompat S(int i10, float f10) {
        float f11;
        if (i10 == 3) {
            f11 = 3.0f;
        } else if (i10 == 4) {
            f11 = 4.0f;
        } else {
            if (i10 != 5) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid rating style (");
                sb2.append(i10);
                sb2.append(") for a star rating");
                return null;
            }
            f11 = 5.0f;
        }
        if (f10 < 0.0f || f10 > f11) {
            return null;
        }
        return new RatingCompat(i10, f10);
    }

    public static RatingCompat T(boolean z10) {
        return new RatingCompat(2, z10 ? 1.0f : 0.0f);
    }

    public static RatingCompat U(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i10, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat a(Object obj) {
        RatingCompat ratingCompatU = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompatU = F(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompatU = T(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompatU = S(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompatU = M(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompatU = U(ratingStyle);
            }
            ratingCompatU.f1001c = obj;
        }
        return ratingCompatU;
    }

    public boolean C() {
        return this.f999a == 2 && this.f1000b == 1.0f;
    }

    public float b() {
        if (this.f999a == 6 && z()) {
            return this.f1000b;
        }
        return -1.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f999a;
    }

    public Object e() {
        if (this.f1001c == null) {
            if (z()) {
                int i10 = this.f999a;
                switch (i10) {
                    case 1:
                        this.f1001c = Rating.newHeartRating(s());
                        break;
                    case 2:
                        this.f1001c = Rating.newThumbRating(C());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.f1001c = Rating.newStarRating(i10, j());
                        break;
                    case 6:
                        this.f1001c = Rating.newPercentageRating(b());
                        break;
                    default:
                        return null;
                }
            } else {
                this.f1001c = Rating.newUnratedRating(this.f999a);
            }
        }
        return this.f1001c;
    }

    public int g() {
        return this.f999a;
    }

    public float j() {
        int i10 = this.f999a;
        if ((i10 == 3 || i10 == 4 || i10 == 5) && z()) {
            return this.f1000b;
        }
        return -1.0f;
    }

    public boolean s() {
        return this.f999a == 1 && this.f1000b == 1.0f;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Rating:style=");
        sb2.append(this.f999a);
        sb2.append(" rating=");
        float f10 = this.f1000b;
        sb2.append(f10 < 0.0f ? "unrated" : String.valueOf(f10));
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f999a);
        parcel.writeFloat(this.f1000b);
    }

    public boolean z() {
        return this.f1000b >= 0.0f;
    }
}
