package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final IntentSender f1421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final Intent f1422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final c f1420e = new c(null);

    @hk.e
    @yt.k
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final IntentSender f1425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public Intent f1426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1428d;

        /* JADX INFO: renamed from: androidx.activity.result.IntentSenderRequest$a$a, reason: collision with other inner class name */
        @sj.c(AnnotationRetention.SOURCE)
        @Retention(RetentionPolicy.SOURCE)
        public @interface InterfaceC0027a {
        }

        public a(@yt.k IntentSender intentSender) {
            f0.p(intentSender, "intentSender");
            this.f1425a = intentSender;
        }

        @yt.k
        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f1425a, this.f1426b, this.f1427c, this.f1428d);
        }

        @yt.k
        public final a b(@l Intent intent) {
            this.f1426b = intent;
            return this;
        }

        @yt.k
        public final a c(int i10, int i11) {
            this.f1428d = i10;
            this.f1427c = i11;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(@yt.k PendingIntent pendingIntent) {
            f0.p(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            f0.o(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }
    }

    public static final class b implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(@yt.k Parcel inParcel) {
            f0.p(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        @yt.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(u uVar) {
            this();
        }

        public static /* synthetic */ void a() {
        }
    }

    public IntentSenderRequest(@yt.k IntentSender intentSender, @l Intent intent, int i10, int i11) {
        f0.p(intentSender, "intentSender");
        this.f1421a = intentSender;
        this.f1422b = intent;
        this.f1423c = i10;
        this.f1424d = i11;
    }

    @l
    public final Intent a() {
        return this.f1422b;
    }

    public final int b() {
        return this.f1423c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f1424d;
    }

    @yt.k
    public final IntentSender g() {
        return this.f1421a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@yt.k Parcel dest, int i10) {
        f0.p(dest, "dest");
        dest.writeParcelable(this.f1421a, i10);
        dest.writeParcelable(this.f1422b, i10);
        dest.writeInt(this.f1423c);
        dest.writeInt(this.f1424d);
    }

    public /* synthetic */ IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11, int i12, u uVar) {
        this(intentSender, (i12 & 2) != 0 ? null : intent, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IntentSenderRequest(@yt.k Parcel parcel) {
        f0.p(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        f0.m(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
