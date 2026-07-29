package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final long A = 16384;
    public static final long B = 32768;
    public static final long C = 65536;
    public static final int C1 = 0;
    public static final int C2 = 3;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();
    public static final long D = 131072;
    public static final int E7 = 5;
    public static final int F7 = 6;
    public static final int G7 = 7;
    public static final int H7 = 8;
    public static final int I7 = 9;
    public static final int J7 = 10;

    @Deprecated
    public static final long K0 = 524288;
    public static final int K1 = 1;
    public static final int K2 = 4;
    public static final int K7 = 11;
    public static final long L7 = -1;
    public static final int M7 = -1;
    public static final int N7 = 0;
    public static final int O7 = 1;
    public static final int P7 = 2;
    public static final int Q7 = 3;
    public static final int R7 = -1;
    public static final int S7 = 0;
    public static final int T7 = 1;
    public static final int U7 = 2;
    public static final int V7 = 0;
    public static final int W7 = 1;
    public static final int X7 = 2;
    public static final int Y7 = 3;
    public static final int Z7 = 4;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f1176a8 = 5;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final int f1177b8 = 6;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final int f1178c8 = 7;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f1179d8 = 8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f1180e8 = 9;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f1181f8 = 10;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int f1182g8 = 11;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f1183h8 = 127;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final int f1184i8 = 126;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final long f1185k0 = 262144;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final long f1186k1 = 1048576;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f1187m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f1188n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f1189o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f1190p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f1191q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f1192r = 32;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f1193s = 64;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f1194t = 128;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f1195u = 256;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f1196v = 512;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final long f1197v1 = 2097152;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f1198v2 = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f1199w = 1024;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f1200x = 2048;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f1201y = 4096;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f1202z = 8192;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f1206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f1209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<CustomAction> f1211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f1213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PlaybackState f1214l;

    public class a implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface b {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface e {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface f {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface g {
    }

    public PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List<CustomAction> list, long j14, Bundle bundle) {
        this.f1203a = i10;
        this.f1204b = j10;
        this.f1205c = j11;
        this.f1206d = f10;
        this.f1207e = j12;
        this.f1208f = i11;
        this.f1209g = charSequence;
        this.f1210h = j13;
        this.f1211i = new ArrayList(list);
        this.f1212j = j14;
        this.f1213k = bundle;
    }

    public static int W(long j10) {
        if (j10 == 4) {
            return 126;
        }
        if (j10 == 2) {
            return 127;
        }
        if (j10 == 32) {
            return 87;
        }
        if (j10 == 16) {
            return 88;
        }
        if (j10 == 1) {
            return 86;
        }
        if (j10 == 64) {
            return 90;
        }
        if (j10 == 8) {
            return 89;
        }
        return j10 == 512 ? 85 : 0;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Bundle extras = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            Iterator<PlaybackState.CustomAction> it2 = customActions.iterator();
            while (it2.hasNext()) {
                arrayList2.add(CustomAction.a(it2.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            extras = playbackState.getExtras();
            MediaSessionCompat.c(extras);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), extras);
        playbackStateCompat.f1214l = playbackState;
        return playbackStateCompat;
    }

    public CharSequence C() {
        return this.f1209g;
    }

    @p0
    public Bundle F() {
        return this.f1213k;
    }

    public long M() {
        return this.f1210h;
    }

    public float S() {
        return this.f1206d;
    }

    public Object T() {
        if (this.f1214l == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(this.f1203a, this.f1204b, this.f1206d, this.f1210h);
            builder.setBufferedPosition(this.f1205c);
            builder.setActions(this.f1207e);
            builder.setErrorMessage(this.f1209g);
            Iterator<CustomAction> it2 = this.f1211i.iterator();
            while (it2.hasNext()) {
                builder.addCustomAction((PlaybackState.CustomAction) it2.next().e());
            }
            builder.setActiveQueueItemId(this.f1212j);
            if (Build.VERSION.SDK_INT >= 22) {
                builder.setExtras(this.f1213k);
            }
            this.f1214l = builder.build();
        }
        return this.f1214l;
    }

    public long U() {
        return this.f1204b;
    }

    public int V() {
        return this.f1203a;
    }

    public long b() {
        return this.f1207e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f1212j;
    }

    public long g() {
        return this.f1205c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public long j(Long l10) {
        return Math.max(0L, this.f1204b + ((long) (this.f1206d * (l10 != null ? l10.longValue() : SystemClock.elapsedRealtime() - this.f1210h))));
    }

    public List<CustomAction> s() {
        return this.f1211i;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f1203a + ", position=" + this.f1204b + ", buffered position=" + this.f1205c + ", speed=" + this.f1206d + ", updated=" + this.f1210h + ", actions=" + this.f1207e + ", error code=" + this.f1208f + ", error message=" + this.f1209g + ", custom actions=" + this.f1211i + ", active item id=" + this.f1212j + zc.a.f58317e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1203a);
        parcel.writeLong(this.f1204b);
        parcel.writeFloat(this.f1206d);
        parcel.writeLong(this.f1210h);
        parcel.writeLong(this.f1205c);
        parcel.writeLong(this.f1207e);
        TextUtils.writeToParcel(this.f1209g, parcel, i10);
        parcel.writeTypedList(this.f1211i);
        parcel.writeLong(this.f1212j);
        parcel.writeBundle(this.f1213k);
        parcel.writeInt(this.f1208f);
    }

    public int z() {
        return this.f1208f;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<CustomAction> f1224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f1231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f1232i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f1233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Bundle f1234k;

        public c() {
            this.f1224a = new ArrayList();
            this.f1233j = -1L;
        }

        public c a(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
            }
            this.f1224a.add(customAction);
            return this;
        }

        public c b(String str, String str2, int i10) {
            return a(new CustomAction(str, str2, i10, null));
        }

        public PlaybackStateCompat c() {
            return new PlaybackStateCompat(this.f1225b, this.f1226c, this.f1227d, this.f1228e, this.f1229f, this.f1230g, this.f1231h, this.f1232i, this.f1224a, this.f1233j, this.f1234k);
        }

        public c d(long j10) {
            this.f1229f = j10;
            return this;
        }

        public c e(long j10) {
            this.f1233j = j10;
            return this;
        }

        public c f(long j10) {
            this.f1227d = j10;
            return this;
        }

        public c g(int i10, CharSequence charSequence) {
            this.f1230g = i10;
            this.f1231h = charSequence;
            return this;
        }

        @Deprecated
        public c h(CharSequence charSequence) {
            this.f1231h = charSequence;
            return this;
        }

        public c i(Bundle bundle) {
            this.f1234k = bundle;
            return this;
        }

        public c j(int i10, long j10, float f10) {
            return k(i10, j10, f10, SystemClock.elapsedRealtime());
        }

        public c k(int i10, long j10, float f10, long j11) {
            this.f1225b = i10;
            this.f1226c = j10;
            this.f1232i = j11;
            this.f1228e = f10;
            return this;
        }

        public c(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f1224a = arrayList;
            this.f1233j = -1L;
            this.f1225b = playbackStateCompat.f1203a;
            this.f1226c = playbackStateCompat.f1204b;
            this.f1228e = playbackStateCompat.f1206d;
            this.f1232i = playbackStateCompat.f1210h;
            this.f1227d = playbackStateCompat.f1205c;
            this.f1229f = playbackStateCompat.f1207e;
            this.f1230g = playbackStateCompat.f1208f;
            this.f1231h = playbackStateCompat.f1209g;
            List<CustomAction> list = playbackStateCompat.f1211i;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f1233j = playbackStateCompat.f1212j;
            this.f1234k = playbackStateCompat.f1213k;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f1216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f1218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PlaybackState.CustomAction f1219e;

        public class a implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f1220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f1221b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f1222c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f1223d;

            public b(String str, CharSequence charSequence, int i10) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                if (i10 == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                }
                this.f1220a = str;
                this.f1221b = charSequence;
                this.f1222c = i10;
            }

            public CustomAction a() {
                return new CustomAction(this.f1220a, this.f1221b, this.f1222c, this.f1223d);
            }

            public b b(Bundle bundle) {
                this.f1223d = bundle;
                return this;
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f1215a = str;
            this.f1216b = charSequence;
            this.f1217c = i10;
            this.f1218d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            Bundle extras = customAction.getExtras();
            MediaSessionCompat.c(extras);
            CustomAction customAction2 = new CustomAction(customAction.getAction(), customAction.getName(), customAction.getIcon(), extras);
            customAction2.f1219e = customAction;
            return customAction2;
        }

        public String b() {
            return this.f1215a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Object e() {
            PlaybackState.CustomAction customAction = this.f1219e;
            if (customAction != null) {
                return customAction;
            }
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(this.f1215a, this.f1216b, this.f1217c);
            builder.setExtras(this.f1218d);
            return builder.build();
        }

        public Bundle g() {
            return this.f1218d;
        }

        public int j() {
            return this.f1217c;
        }

        public CharSequence s() {
            return this.f1216b;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f1216b) + ", mIcon=" + this.f1217c + ", mExtras=" + this.f1218d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f1215a);
            TextUtils.writeToParcel(this.f1216b, parcel, i10);
            parcel.writeInt(this.f1217c);
            parcel.writeBundle(this.f1218d);
        }

        public CustomAction(Parcel parcel) {
            this.f1215a = parcel.readString();
            this.f1216b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1217c = parcel.readInt();
            this.f1218d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f1203a = parcel.readInt();
        this.f1204b = parcel.readLong();
        this.f1206d = parcel.readFloat();
        this.f1210h = parcel.readLong();
        this.f1205c = parcel.readLong();
        this.f1207e = parcel.readLong();
        this.f1209g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1211i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f1212j = parcel.readLong();
        this.f1213k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f1208f = parcel.readInt();
    }
}
