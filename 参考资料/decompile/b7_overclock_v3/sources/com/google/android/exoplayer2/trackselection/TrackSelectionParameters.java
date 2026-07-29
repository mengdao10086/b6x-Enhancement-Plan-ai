package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import com.google.common.collect.ImmutableList;
import g.p0;
import g.v0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TrackSelectionParameters f18582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final TrackSelectionParameters f18583h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<String> f18584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImmutableList<String> f18586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f18589f;

    public class a implements Parcelable.Creator<TrackSelectionParameters> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackSelectionParameters[] newArray(int i10) {
            return new TrackSelectionParameters[i10];
        }
    }

    static {
        TrackSelectionParameters trackSelectionParametersA = new b().a();
        f18582g = trackSelectionParametersA;
        f18583h = trackSelectionParametersA;
        CREATOR = new a();
    }

    public TrackSelectionParameters(ImmutableList<String> immutableList, int i10, ImmutableList<String> immutableList2, int i11, boolean z10, int i12) {
        this.f18584a = immutableList;
        this.f18585b = i10;
        this.f18586c = immutableList2;
        this.f18587d = i11;
        this.f18588e = z10;
        this.f18589f = i12;
    }

    public static TrackSelectionParameters b(Context context) {
        return new b(context).a();
    }

    public b a() {
        return new b(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.f18584a.equals(trackSelectionParameters.f18584a) && this.f18585b == trackSelectionParameters.f18585b && this.f18586c.equals(trackSelectionParameters.f18586c) && this.f18587d == trackSelectionParameters.f18587d && this.f18588e == trackSelectionParameters.f18588e && this.f18589f == trackSelectionParameters.f18589f;
    }

    public int hashCode() {
        return ((((((((((this.f18584a.hashCode() + 31) * 31) + this.f18585b) * 31) + this.f18586c.hashCode()) * 31) + this.f18587d) * 31) + (this.f18588e ? 1 : 0)) * 31) + this.f18589f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f18584a);
        parcel.writeInt(this.f18585b);
        parcel.writeList(this.f18586c);
        parcel.writeInt(this.f18587d);
        u0.B1(parcel, this.f18588e);
        parcel.writeInt(this.f18589f);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImmutableList<String> f18590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImmutableList<String> f18592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18595f;

        public b(Context context) {
            this();
            g(context);
        }

        public TrackSelectionParameters a() {
            return new TrackSelectionParameters(this.f18590a, this.f18591b, this.f18592c, this.f18593d, this.f18594e, this.f18595f);
        }

        public b b(int i10) {
            this.f18595f = i10;
            return this;
        }

        public b c(@p0 String str) {
            return str == null ? d(new String[0]) : d(str);
        }

        public b d(String... strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : (String[]) hd.a.g(strArr)) {
                builder.add(u0.S0((String) hd.a.g(str)));
            }
            this.f18590a = builder.build();
            return this;
        }

        public b e(int i10) {
            this.f18591b = i10;
            return this;
        }

        public b f(@p0 String str) {
            return str == null ? i(new String[0]) : i(str);
        }

        public b g(Context context) {
            if (u0.f31154a >= 19) {
                h(context);
            }
            return this;
        }

        @v0(19)
        public final void h(Context context) {
            CaptioningManager captioningManager;
            if ((u0.f31154a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f18593d = rs.d.f49161j;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f18592c = ImmutableList.of(u0.e0(locale));
                }
            }
        }

        public b i(String... strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : (String[]) hd.a.g(strArr)) {
                builder.add(u0.S0((String) hd.a.g(str)));
            }
            this.f18592c = builder.build();
            return this;
        }

        public b j(int i10) {
            this.f18593d = i10;
            return this;
        }

        public b k(boolean z10) {
            this.f18594e = z10;
            return this;
        }

        @Deprecated
        public b() {
            this.f18590a = ImmutableList.of();
            this.f18591b = 0;
            this.f18592c = ImmutableList.of();
            this.f18593d = 0;
            this.f18594e = false;
            this.f18595f = 0;
        }

        public b(TrackSelectionParameters trackSelectionParameters) {
            this.f18590a = trackSelectionParameters.f18584a;
            this.f18591b = trackSelectionParameters.f18585b;
            this.f18592c = trackSelectionParameters.f18586c;
            this.f18593d = trackSelectionParameters.f18587d;
            this.f18594e = trackSelectionParameters.f18588e;
            this.f18595f = trackSelectionParameters.f18589f;
        }
    }

    public TrackSelectionParameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.f18584a = ImmutableList.copyOf((Collection) arrayList);
        this.f18585b = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, null);
        this.f18586c = ImmutableList.copyOf((Collection) arrayList2);
        this.f18587d = parcel.readInt();
        this.f18588e = u0.b1(parcel);
        this.f18589f = parcel.readInt();
    }
}
