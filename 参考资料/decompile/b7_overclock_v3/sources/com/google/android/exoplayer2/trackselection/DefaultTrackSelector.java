package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.a;
import com.google.android.exoplayer2.trackselection.b;
import com.google.android.exoplayer2.trackselection.c;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import ya.p1;
import ya.r1;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTrackSelector extends com.google.android.exoplayer2.trackselection.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f18497f = 0.98f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f18498g = new int[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Ordering<Integer> f18499h = Ordering.from(new Comparator() { // from class: ad.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.A((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Ordering<Integer> f18500i = Ordering.from(new Comparator() { // from class: ad.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.B((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.InterfaceC0194b f18501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<Parameters> f18502e;

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f18526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18527c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f18528d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18529e;

        public class a implements Parcelable.Creator<SelectionOverride> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SelectionOverride[] newArray(int i10) {
                return new SelectionOverride[i10];
            }
        }

        public SelectionOverride(int i10, int... iArr) {
            this(i10, iArr, 2, 0);
        }

        public boolean a(int i10) {
            for (int i11 : this.f18526b) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.f18525a == selectionOverride.f18525a && Arrays.equals(this.f18526b, selectionOverride.f18526b) && this.f18528d == selectionOverride.f18528d && this.f18529e == selectionOverride.f18529e;
        }

        public int hashCode() {
            return (((((this.f18525a * 31) + Arrays.hashCode(this.f18526b)) * 31) + this.f18528d) * 31) + this.f18529e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f18525a);
            parcel.writeInt(this.f18526b.length);
            parcel.writeIntArray(this.f18526b);
            parcel.writeInt(this.f18528d);
            parcel.writeInt(this.f18529e);
        }

        public SelectionOverride(int i10, int[] iArr, int i11, int i12) {
            this.f18525a = i10;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f18526b = iArrCopyOf;
            this.f18527c = iArr.length;
            this.f18528d = i11;
            this.f18529e = i12;
            Arrays.sort(iArrCopyOf);
        }

        public SelectionOverride(Parcel parcel) {
            this.f18525a = parcel.readInt();
            int i10 = parcel.readByte();
            this.f18527c = i10;
            int[] iArr = new int[i10];
            this.f18526b = iArr;
            parcel.readIntArray(iArr);
            this.f18528d = parcel.readInt();
            this.f18529e = parcel.readInt();
        }
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final String f18531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Parameters f18532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f18533d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18534e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f18535f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f18536g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f18537h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f18538i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f18539j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f18540k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f18541l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f18542m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f18543n;

        public b(Format format, Parameters parameters, int i10) {
            int i11;
            int iT;
            int iT2;
            this.f18532c = parameters;
            this.f18531b = DefaultTrackSelector.D(format.f16689c);
            int i12 = 0;
            this.f18533d = DefaultTrackSelector.x(i10, false);
            int i13 = 0;
            while (true) {
                i11 = Integer.MAX_VALUE;
                if (i13 >= parameters.f18584a.size()) {
                    i13 = Integer.MAX_VALUE;
                    iT = 0;
                    break;
                } else {
                    iT = DefaultTrackSelector.t(format, parameters.f18584a.get(i13), false);
                    if (iT > 0) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            this.f18535f = i13;
            this.f18534e = iT;
            this.f18536g = Integer.bitCount(format.f16691e & parameters.f18585b);
            boolean z10 = true;
            this.f18539j = (format.f16690d & 1) != 0;
            int i14 = format.f16712y;
            this.f18540k = i14;
            this.f18541l = format.f16713z;
            int i15 = format.f16694h;
            this.f18542m = i15;
            if ((i15 != -1 && i15 > parameters.f18523y) || (i14 != -1 && i14 > parameters.f18522x)) {
                z10 = false;
            }
            this.f18530a = z10;
            String[] strArrQ0 = u0.q0();
            int i16 = 0;
            while (true) {
                if (i16 >= strArrQ0.length) {
                    i16 = Integer.MAX_VALUE;
                    iT2 = 0;
                    break;
                } else {
                    iT2 = DefaultTrackSelector.t(format, strArrQ0[i16], false);
                    if (iT2 > 0) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            this.f18537h = i16;
            this.f18538i = iT2;
            while (true) {
                if (i12 < parameters.D.size()) {
                    String str = format.f16699l;
                    if (str != null && str.equals(parameters.D.get(i12))) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                } else {
                    break;
                }
            }
            this.f18543n = i11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering orderingReverse = (this.f18530a && this.f18533d) ? DefaultTrackSelector.f18499h : DefaultTrackSelector.f18499h.reverse();
            ComparisonChain comparisonChainCompare = ComparisonChain.start().compareFalseFirst(this.f18533d, bVar.f18533d).compare(Integer.valueOf(this.f18535f), Integer.valueOf(bVar.f18535f), Ordering.natural().reverse()).compare(this.f18534e, bVar.f18534e).compare(this.f18536g, bVar.f18536g).compareFalseFirst(this.f18530a, bVar.f18530a).compare(Integer.valueOf(this.f18543n), Integer.valueOf(bVar.f18543n), Ordering.natural().reverse()).compare(Integer.valueOf(this.f18542m), Integer.valueOf(bVar.f18542m), this.f18532c.f18506k0 ? DefaultTrackSelector.f18499h.reverse() : DefaultTrackSelector.f18500i).compareFalseFirst(this.f18539j, bVar.f18539j).compare(Integer.valueOf(this.f18537h), Integer.valueOf(bVar.f18537h), Ordering.natural().reverse()).compare(this.f18538i, bVar.f18538i).compare(Integer.valueOf(this.f18540k), Integer.valueOf(bVar.f18540k), orderingReverse).compare(Integer.valueOf(this.f18541l), Integer.valueOf(bVar.f18541l), orderingReverse);
            Integer numValueOf = Integer.valueOf(this.f18542m);
            Integer numValueOf2 = Integer.valueOf(bVar.f18542m);
            if (!u0.c(this.f18531b, bVar.f18531b)) {
                orderingReverse = DefaultTrackSelector.f18500i;
            }
            return comparisonChainCompare.compare(numValueOf, numValueOf2, orderingReverse).result();
        }
    }

    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18545b;

        public c(Format format, int i10) {
            this.f18544a = (format.f16690d & 1) != 0;
            this.f18545b = DefaultTrackSelector.x(i10, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return ComparisonChain.start().compareFalseFirst(this.f18545b, cVar.f18545b).compareFalseFirst(this.f18544a, cVar.f18544a).result();
        }
    }

    public static final class d extends TrackSelectionParameters.b {
        public boolean A;
        public ImmutableList<String> B;
        public boolean C;
        public boolean D;
        public boolean E;
        public boolean F;
        public boolean G;
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> H;
        public final SparseBooleanArray I;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f18546g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f18547h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f18548i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18549j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f18550k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18551l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18552m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18553n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f18554o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f18555p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f18556q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f18557r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f18558s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f18559t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public ImmutableList<String> f18560u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f18561v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f18562w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f18563x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f18564y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f18565z;

        public static SparseArray<Map<TrackGroupArray, SelectionOverride>> r(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                sparseArray2.put(sparseArray.keyAt(i10), new HashMap(sparseArray.valueAt(i10)));
            }
            return sparseArray2;
        }

        public d A(boolean z10) {
            this.E = z10;
            return this;
        }

        public d B(boolean z10) {
            this.f18554o = z10;
            return this;
        }

        public d C(boolean z10) {
            this.D = z10;
            return this;
        }

        public d D(boolean z10) {
            this.C = z10;
            return this;
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioMimeTypes"})
        public final void E() {
            this.f18546g = Integer.MAX_VALUE;
            this.f18547h = Integer.MAX_VALUE;
            this.f18548i = Integer.MAX_VALUE;
            this.f18549j = Integer.MAX_VALUE;
            this.f18554o = true;
            this.f18555p = false;
            this.f18556q = true;
            this.f18557r = Integer.MAX_VALUE;
            this.f18558s = Integer.MAX_VALUE;
            this.f18559t = true;
            this.f18560u = ImmutableList.of();
            this.f18561v = Integer.MAX_VALUE;
            this.f18562w = Integer.MAX_VALUE;
            this.f18563x = true;
            this.f18564y = false;
            this.f18565z = false;
            this.A = false;
            this.B = ImmutableList.of();
            this.C = false;
            this.D = false;
            this.E = true;
            this.F = false;
            this.G = true;
        }

        public d F(int i10) {
            this.f18562w = i10;
            return this;
        }

        public d G(int i10) {
            this.f18561v = i10;
            return this;
        }

        public d H(int i10) {
            this.f18549j = i10;
            return this;
        }

        public d I(int i10) {
            this.f18548i = i10;
            return this;
        }

        public d J(int i10, int i11) {
            this.f18546g = i10;
            this.f18547h = i11;
            return this;
        }

        public d K() {
            return J(1279, 719);
        }

        public d L(int i10) {
            this.f18553n = i10;
            return this;
        }

        public d M(int i10) {
            this.f18552m = i10;
            return this;
        }

        public d N(int i10, int i11) {
            this.f18550k = i10;
            this.f18551l = i11;
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public d c(@p0 String str) {
            super.c(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public d d(String... strArr) {
            super.d(strArr);
            return this;
        }

        public d Q(@p0 String str) {
            return str == null ? R(new String[0]) : R(str);
        }

        public d R(String... strArr) {
            this.B = ImmutableList.copyOf(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public d e(int i10) {
            super.e(i10);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public d f(@p0 String str) {
            super.f(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public d g(Context context) {
            super.g(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public d i(String... strArr) {
            super.i(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public d j(int i10) {
            super.j(i10);
            return this;
        }

        public d X(@p0 String str) {
            return str == null ? Y(new String[0]) : Y(str);
        }

        public d Y(String... strArr) {
            this.f18560u = ImmutableList.copyOf(strArr);
            return this;
        }

        public final d Z(int i10, boolean z10) {
            if (this.I.get(i10) == z10) {
                return this;
            }
            if (z10) {
                this.I.put(i10, true);
            } else {
                this.I.delete(i10);
            }
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
        public d k(boolean z10) {
            super.k(z10);
            return this;
        }

        public final d b0(int i10, TrackGroupArray trackGroupArray, @p0 SelectionOverride selectionOverride) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i10);
            if (map == null) {
                map = new HashMap<>();
                this.H.put(i10, map);
            }
            if (map.containsKey(trackGroupArray) && u0.c(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public d c0(boolean z10) {
            this.F = z10;
            return this;
        }

        public d d0(int i10, int i11, boolean z10) {
            this.f18557r = i10;
            this.f18558s = i11;
            this.f18559t = z10;
            return this;
        }

        public d e0(Context context, boolean z10) {
            Point pointV = u0.V(context);
            return d0(pointV.x, pointV.y, z10);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Parameters a() {
            return new Parameters(this.f18546g, this.f18547h, this.f18548i, this.f18549j, this.f18550k, this.f18551l, this.f18552m, this.f18553n, this.f18554o, this.f18555p, this.f18556q, this.f18557r, this.f18558s, this.f18559t, this.f18560u, this.f18590a, this.f18591b, this.f18561v, this.f18562w, this.f18563x, this.f18564y, this.f18565z, this.A, this.B, this.f18592c, this.f18593d, this.f18594e, this.f18595f, this.C, this.D, this.E, this.F, this.G, this.H, this.I);
        }

        public final d m(int i10, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i10);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.H.remove(i10);
                }
            }
            return this;
        }

        public final d n() {
            if (this.H.size() == 0) {
                return this;
            }
            this.H.clear();
            return this;
        }

        public final d o(int i10) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i10);
            if (map != null && !map.isEmpty()) {
                this.H.remove(i10);
            }
            return this;
        }

        public d p() {
            return J(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public d q() {
            return d0(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public d s(boolean z10) {
            this.A = z10;
            return this;
        }

        public d t(boolean z10) {
            this.f18564y = z10;
            return this;
        }

        public d u(boolean z10) {
            this.f18565z = z10;
            return this;
        }

        public d v(boolean z10) {
            this.G = z10;
            return this;
        }

        public d w(boolean z10) {
            this.f18555p = z10;
            return this;
        }

        public d x(boolean z10) {
            this.f18556q = z10;
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public d b(int i10) {
            super.b(i10);
            return this;
        }

        public d z(boolean z10) {
            this.f18563x = z10;
            return this;
        }

        @Deprecated
        public d() {
            E();
            this.H = new SparseArray<>();
            this.I = new SparseBooleanArray();
        }

        public d(Context context) {
            super(context);
            E();
            this.H = new SparseArray<>();
            this.I = new SparseBooleanArray();
            e0(context, true);
        }

        public d(Parameters parameters) {
            super(parameters);
            this.f18546g = parameters.f18503i;
            this.f18547h = parameters.f18504j;
            this.f18548i = parameters.f18505k;
            this.f18549j = parameters.f18508l;
            this.f18550k = parameters.f18509m;
            this.f18551l = parameters.f18510n;
            this.f18552m = parameters.f18511o;
            this.f18553n = parameters.f18512p;
            this.f18554o = parameters.f18513q;
            this.f18555p = parameters.f18514r;
            this.f18556q = parameters.f18515s;
            this.f18557r = parameters.f18516t;
            this.f18558s = parameters.f18517u;
            this.f18559t = parameters.f18518v;
            this.f18560u = parameters.f18521w;
            this.f18561v = parameters.f18522x;
            this.f18562w = parameters.f18523y;
            this.f18563x = parameters.f18524z;
            this.f18564y = parameters.A;
            this.f18565z = parameters.B;
            this.A = parameters.C;
            this.B = parameters.D;
            this.C = parameters.f18506k0;
            this.D = parameters.K0;
            this.E = parameters.f18507k1;
            this.F = parameters.f18519v1;
            this.G = parameters.C1;
            this.H = r(parameters.K1);
            this.I = parameters.f18520v2.clone();
        }
    }

    public static final class e implements Comparable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f18568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f18569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18570e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f18571f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f18572g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f18573h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f18574i;

        public e(Format format, Parameters parameters, int i10, @p0 String str) {
            int iT;
            boolean z10 = false;
            this.f18567b = DefaultTrackSelector.x(i10, false);
            int i11 = format.f16690d & (~parameters.f18589f);
            this.f18568c = (i11 & 1) != 0;
            this.f18569d = (i11 & 2) != 0;
            int i12 = Integer.MAX_VALUE;
            ImmutableList<String> immutableListOf = parameters.f18586c.isEmpty() ? ImmutableList.of("") : parameters.f18586c;
            int i13 = 0;
            while (true) {
                if (i13 >= immutableListOf.size()) {
                    iT = 0;
                    break;
                }
                iT = DefaultTrackSelector.t(format, immutableListOf.get(i13), parameters.f18588e);
                if (iT > 0) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            this.f18570e = i12;
            this.f18571f = iT;
            int iBitCount = Integer.bitCount(format.f16691e & parameters.f18587d);
            this.f18572g = iBitCount;
            this.f18574i = (format.f16691e & rs.d.f49161j) != 0;
            int iT2 = DefaultTrackSelector.t(format, str, DefaultTrackSelector.D(str) == null);
            this.f18573h = iT2;
            if (iT > 0 || ((parameters.f18586c.isEmpty() && iBitCount > 0) || this.f18568c || (this.f18569d && iT2 > 0))) {
                z10 = true;
            }
            this.f18566a = z10;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            ComparisonChain comparisonChainCompare = ComparisonChain.start().compareFalseFirst(this.f18567b, eVar.f18567b).compare(Integer.valueOf(this.f18570e), Integer.valueOf(eVar.f18570e), Ordering.natural().reverse()).compare(this.f18571f, eVar.f18571f).compare(this.f18572g, eVar.f18572g).compareFalseFirst(this.f18568c, eVar.f18568c).compare(Boolean.valueOf(this.f18569d), Boolean.valueOf(eVar.f18569d), this.f18571f == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.f18573h, eVar.f18573h);
            if (this.f18572g == 0) {
                comparisonChainCompare = comparisonChainCompare.compareTrueFirst(this.f18574i, eVar.f18574i);
            }
            return comparisonChainCompare.result();
        }
    }

    public static final class f implements Comparable<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Parameters f18576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f18577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f18578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18579e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f18580f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f18581g;

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public f(com.google.android.exoplayer2.Format r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.f18576b = r8
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r1 = 1
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L33
                int r4 = r7.f16704q
                if (r4 == r3) goto L14
                int r5 = r8.f18503i
                if (r4 > r5) goto L33
            L14:
                int r4 = r7.f16705r
                if (r4 == r3) goto L1c
                int r5 = r8.f18504j
                if (r4 > r5) goto L33
            L1c:
                float r4 = r7.f16706s
                int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r5 == 0) goto L29
                int r5 = r8.f18505k
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L33
            L29:
                int r4 = r7.f16694h
                if (r4 == r3) goto L31
                int r5 = r8.f18508l
                if (r4 > r5) goto L33
            L31:
                r4 = 1
                goto L34
            L33:
                r4 = 0
            L34:
                r6.f18575a = r4
                if (r10 == 0) goto L5e
                int r10 = r7.f16704q
                if (r10 == r3) goto L40
                int r4 = r8.f18509m
                if (r10 < r4) goto L5e
            L40:
                int r10 = r7.f16705r
                if (r10 == r3) goto L48
                int r4 = r8.f18510n
                if (r10 < r4) goto L5e
            L48:
                float r10 = r7.f16706s
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L55
                int r0 = r8.f18511o
                float r0 = (float) r0
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L5e
            L55:
                int r10 = r7.f16694h
                if (r10 == r3) goto L5f
                int r0 = r8.f18512p
                if (r10 < r0) goto L5e
                goto L5f
            L5e:
                r1 = 0
            L5f:
                r6.f18577c = r1
                boolean r9 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.x(r9, r2)
                r6.f18578d = r9
                int r9 = r7.f16694h
                r6.f18579e = r9
                int r9 = r7.j0()
                r6.f18580f = r9
                r9 = 2147483647(0x7fffffff, float:NaN)
            L74:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.f18521w
                int r10 = r10.size()
                if (r2 >= r10) goto L91
                java.lang.String r10 = r7.f16699l
                if (r10 == 0) goto L8e
                com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f18521w
                java.lang.Object r0 = r0.get(r2)
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L8e
                r9 = r2
                goto L91
            L8e:
                int r2 = r2 + 1
                goto L74
            L91:
                r6.f18581g = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.f.<init>(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, boolean):void");
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(f fVar) {
            Ordering orderingReverse = (this.f18575a && this.f18578d) ? DefaultTrackSelector.f18499h : DefaultTrackSelector.f18499h.reverse();
            return ComparisonChain.start().compareFalseFirst(this.f18578d, fVar.f18578d).compareFalseFirst(this.f18575a, fVar.f18575a).compareFalseFirst(this.f18577c, fVar.f18577c).compare(Integer.valueOf(this.f18581g), Integer.valueOf(fVar.f18581g), Ordering.natural().reverse()).compare(Integer.valueOf(this.f18579e), Integer.valueOf(fVar.f18579e), this.f18576b.f18506k0 ? DefaultTrackSelector.f18499h.reverse() : DefaultTrackSelector.f18500i).compare(Integer.valueOf(this.f18580f), Integer.valueOf(fVar.f18580f), orderingReverse).compare(Integer.valueOf(this.f18579e), Integer.valueOf(fVar.f18579e), orderingReverse).result();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.C2, new a.b());
    }

    public static /* synthetic */ int A(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int B(Integer num, Integer num2) {
        return 0;
    }

    public static void C(c.a aVar, int[][][] iArr, r1[] r1VarArr, com.google.android.exoplayer2.trackselection.b[] bVarArr) {
        boolean z10;
        boolean z11 = false;
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < aVar.c(); i12++) {
            int iF = aVar.f(i12);
            com.google.android.exoplayer2.trackselection.b bVar = bVarArr[i12];
            if ((iF == 1 || iF == 2) && bVar != null && E(iArr[i12], aVar.g(i12), bVar)) {
                if (iF == 1) {
                    if (i11 != -1) {
                        z10 = false;
                        break;
                    }
                    i11 = i12;
                } else {
                    if (i10 != -1) {
                        z10 = false;
                        break;
                    }
                    i10 = i12;
                }
            }
        }
        z10 = true;
        if (i11 != -1 && i10 != -1) {
            z11 = true;
        }
        if (z10 && z11) {
            r1 r1Var = new r1(true);
            r1VarArr[i11] = r1Var;
            r1VarArr[i10] = r1Var;
        }
    }

    @p0
    public static String D(@p0 String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean E(int[][] iArr, TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.b bVar) {
        if (bVar == null) {
            return false;
        }
        int iB = trackGroupArray.b(bVar.a());
        for (int i10 = 0; i10 < bVar.length(); i10++) {
            if (p1.e(iArr[iB][bVar.c(i10)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @p0
    public static b.a F(TrackGroupArray trackGroupArray, int[][] iArr, int i10, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i11 = parameters2.f18515s ? 24 : 16;
        boolean z10 = parameters2.f18514r && (i10 & i11) != 0;
        int i12 = 0;
        while (i12 < trackGroupArray2.f17502a) {
            TrackGroup trackGroupA = trackGroupArray2.a(i12);
            int i13 = i12;
            int[] iArrS = s(trackGroupA, iArr[i12], z10, i11, parameters2.f18503i, parameters2.f18504j, parameters2.f18505k, parameters2.f18508l, parameters2.f18509m, parameters2.f18510n, parameters2.f18511o, parameters2.f18512p, parameters2.f18516t, parameters2.f18517u, parameters2.f18518v);
            if (iArrS.length > 0) {
                return new b.a(trackGroupA, iArrS);
            }
            i12 = i13 + 1;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    @p0
    public static b.a I(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i10 = -1;
        TrackGroup trackGroup = null;
        f fVar = null;
        for (int i11 = 0; i11 < trackGroupArray.f17502a; i11++) {
            TrackGroup trackGroupA = trackGroupArray.a(i11);
            List<Integer> listW = w(trackGroupA, parameters.f18516t, parameters.f18517u, parameters.f18518v);
            int[] iArr2 = iArr[i11];
            for (int i12 = 0; i12 < trackGroupA.f17498a; i12++) {
                Format formatA = trackGroupA.a(i12);
                if ((formatA.f16691e & 16384) == 0 && x(iArr2[i12], parameters.f18507k1)) {
                    f fVar2 = new f(formatA, parameters, iArr2[i12], listW.contains(Integer.valueOf(i12)));
                    if ((fVar2.f18575a || parameters.f18513q) && (fVar == null || fVar2.compareTo(fVar) > 0)) {
                        trackGroup = trackGroupA;
                        i10 = i12;
                        fVar = fVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new b.a(trackGroup, i10);
    }

    public static void p(TrackGroup trackGroup, int[] iArr, int i10, @p0 String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!z(trackGroup.a(iIntValue), str, iArr[iIntValue], i10, i11, i12, i13, i14, i15, i16, i17, i18)) {
                list.remove(size);
            }
        }
    }

    public static int[] q(TrackGroup trackGroup, int[] iArr, int i10, int i11, boolean z10, boolean z11, boolean z12) {
        Format formatA = trackGroup.a(i10);
        int[] iArr2 = new int[trackGroup.f17498a];
        int i12 = 0;
        for (int i13 = 0; i13 < trackGroup.f17498a; i13++) {
            if (i13 == i10 || y(trackGroup.a(i13), iArr[i13], formatA, i11, z10, z11, z12)) {
                iArr2[i12] = i13;
                i12++;
            }
        }
        return Arrays.copyOf(iArr2, i12);
    }

    public static int r(TrackGroup trackGroup, int[] iArr, int i10, @p0 String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List<Integer> list) {
        int i19 = 0;
        for (int i20 = 0; i20 < list.size(); i20++) {
            int iIntValue = list.get(i20).intValue();
            if (z(trackGroup.a(iIntValue), str, iArr[iIntValue], i10, i11, i12, i13, i14, i15, i16, i17, i18)) {
                i19++;
            }
        }
        return i19;
    }

    public static int[] s(TrackGroup trackGroup, int[] iArr, boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, boolean z11) {
        String str;
        int i21;
        int i22;
        HashSet hashSet;
        if (trackGroup.f17498a < 2) {
            return f18498g;
        }
        List<Integer> listW = w(trackGroup, i19, i20, z11);
        if (listW.size() < 2) {
            return f18498g;
        }
        if (z10) {
            str = null;
        } else {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i23 = 0;
            int i24 = 0;
            while (i24 < listW.size()) {
                String str3 = trackGroup.a(listW.get(i24).intValue()).f16699l;
                if (hashSet2.add(str3)) {
                    i21 = i23;
                    i22 = i24;
                    hashSet = hashSet2;
                    int iR = r(trackGroup, iArr, i10, str3, i11, i12, i13, i14, i15, i16, i17, i18, listW);
                    if (iR > i21) {
                        i23 = iR;
                        str2 = str3;
                    }
                    i24 = i22 + 1;
                    hashSet2 = hashSet;
                } else {
                    i21 = i23;
                    i22 = i24;
                    hashSet = hashSet2;
                }
                i23 = i21;
                i24 = i22 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        p(trackGroup, iArr, i10, str, i11, i12, i13, i14, i15, i16, i17, i18, listW);
        return listW.size() < 2 ? f18498g : Ints.toArray(listW);
    }

    public static int t(Format format, @p0 String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f16689c)) {
            return 4;
        }
        String strD = D(str);
        String strD2 = D(format.f16689c);
        if (strD2 == null || strD == null) {
            return (z10 && strD2 == null) ? 1 : 0;
        }
        if (strD2.startsWith(strD) || strD.startsWith(strD2)) {
            return 3;
        }
        return u0.o1(strD2, "-")[0].equals(u0.o1(strD, "-")[0]) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Point u(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = hd.u0.m(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = hd.u0.m(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.u(boolean, int, int, int, int):android.graphics.Point");
    }

    public static List<Integer> w(TrackGroup trackGroup, int i10, int i11, boolean z10) {
        int i12;
        ArrayList arrayList = new ArrayList(trackGroup.f17498a);
        for (int i13 = 0; i13 < trackGroup.f17498a; i13++) {
            arrayList.add(Integer.valueOf(i13));
        }
        if (i10 != Integer.MAX_VALUE && i11 != Integer.MAX_VALUE) {
            int i14 = Integer.MAX_VALUE;
            for (int i15 = 0; i15 < trackGroup.f17498a; i15++) {
                Format formatA = trackGroup.a(i15);
                int i16 = formatA.f16704q;
                if (i16 > 0 && (i12 = formatA.f16705r) > 0) {
                    Point pointU = u(z10, i10, i11, i16, i12);
                    int i17 = formatA.f16704q;
                    int i18 = formatA.f16705r;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (pointU.x * 0.98f)) && i18 >= ((int) (pointU.y * 0.98f)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
            if (i14 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iJ0 = trackGroup.a(((Integer) arrayList.get(size)).intValue()).j0();
                    if (iJ0 == -1 || iJ0 > i14) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean x(int i10, boolean z10) {
        int iD = p1.d(i10);
        return iD == 4 || (z10 && iD == 3);
    }

    public static boolean y(Format format, int i10, Format format2, int i11, boolean z10, boolean z11, boolean z12) {
        int i12;
        int i13;
        String str;
        int i14;
        if (!x(i10, false) || (i12 = format.f16694h) == -1 || i12 > i11) {
            return false;
        }
        if (!z12 && ((i14 = format.f16712y) == -1 || i14 != format2.f16712y)) {
            return false;
        }
        if (z10 || ((str = format.f16699l) != null && TextUtils.equals(str, format2.f16699l))) {
            return z11 || ((i13 = format.f16713z) != -1 && i13 == format2.f16713z);
        }
        return false;
    }

    public static boolean z(Format format, @p0 String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        if ((format.f16691e & 16384) != 0 || !x(i10, false) || (i10 & i11) == 0) {
            return false;
        }
        if (str != null && !u0.c(format.f16699l, str)) {
            return false;
        }
        int i20 = format.f16704q;
        if (i20 != -1 && (i16 > i20 || i20 > i12)) {
            return false;
        }
        int i21 = format.f16705r;
        if (i21 != -1 && (i17 > i21 || i21 > i13)) {
            return false;
        }
        float f10 = format.f16706s;
        if (f10 != -1.0f && (i18 > f10 || f10 > i14)) {
            return false;
        }
        int i22 = format.f16694h;
        return i22 == -1 || (i19 <= i22 && i22 <= i15);
    }

    public b.a[] G(c.a aVar, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int i10;
        String str;
        int i11;
        b bVar;
        String str2;
        int i12;
        int iC = aVar.c();
        b.a[] aVarArr = new b.a[iC];
        int i13 = 0;
        boolean z10 = false;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i14 >= iC) {
                break;
            }
            if (2 == aVar.f(i14)) {
                if (!z10) {
                    aVarArr[i14] = L(aVar.g(i14), iArr[i14], iArr2[i14], parameters, true);
                    z10 = aVarArr[i14] != null;
                }
                i15 |= aVar.g(i14).f17502a <= 0 ? 0 : 1;
            }
            i14++;
        }
        b bVar2 = null;
        String str3 = null;
        int i16 = -1;
        int i17 = 0;
        while (i17 < iC) {
            if (i10 == aVar.f(i17)) {
                i11 = i16;
                bVar = bVar2;
                str2 = str3;
                i12 = i17;
                Pair<b.a, b> pairH = H(aVar.g(i17), iArr[i17], iArr2[i17], parameters, parameters.C1 || i15 == 0);
                if (pairH != null && (bVar == null || ((b) pairH.second).compareTo(bVar) > 0)) {
                    if (i11 != -1) {
                        aVarArr[i11] = null;
                    }
                    b.a aVar2 = (b.a) pairH.first;
                    aVarArr[i12] = aVar2;
                    str3 = aVar2.f18623a.a(aVar2.f18624b[0]).f16689c;
                    bVar2 = (b) pairH.second;
                    i16 = i12;
                }
                i17 = i12 + 1;
                i10 = 1;
            } else {
                i11 = i16;
                bVar = bVar2;
                str2 = str3;
                i12 = i17;
            }
            i16 = i11;
            bVar2 = bVar;
            str3 = str2;
            i17 = i12 + 1;
            i10 = 1;
        }
        String str4 = str3;
        e eVar = null;
        int i18 = -1;
        while (i13 < iC) {
            int iF = aVar.f(i13);
            if (iF == 1) {
                str = str4;
            } else if (iF == 2) {
                str = str4;
            } else if (iF != 3) {
                aVarArr[i13] = J(iF, aVar.g(i13), iArr[i13], parameters);
                str = str4;
            } else {
                str = str4;
                Pair<b.a, e> pairK = K(aVar.g(i13), iArr[i13], parameters, str);
                if (pairK != null && (eVar == null || ((e) pairK.second).compareTo(eVar) > 0)) {
                    if (i18 != -1) {
                        aVarArr[i18] = null;
                    }
                    aVarArr[i13] = (b.a) pairK.first;
                    eVar = (e) pairK.second;
                    i18 = i13;
                }
            }
            i13++;
            str4 = str;
        }
        return aVarArr;
    }

    @p0
    public Pair<b.a, b> H(TrackGroupArray trackGroupArray, int[][] iArr, int i10, Parameters parameters, boolean z10) throws ExoPlaybackException {
        b.a aVar = null;
        b bVar = null;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < trackGroupArray.f17502a; i13++) {
            TrackGroup trackGroupA = trackGroupArray.a(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < trackGroupA.f17498a; i14++) {
                if (x(iArr2[i14], parameters.f18507k1)) {
                    b bVar2 = new b(trackGroupA.a(i14), parameters, iArr2[i14]);
                    if ((bVar2.f18530a || parameters.f18524z) && (bVar == null || bVar2.compareTo(bVar) > 0)) {
                        i11 = i13;
                        i12 = i14;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i11 == -1) {
            return null;
        }
        TrackGroup trackGroupA2 = trackGroupArray.a(i11);
        if (!parameters.K0 && !parameters.f18506k0 && z10) {
            int[] iArrQ = q(trackGroupA2, iArr[i11], i12, parameters.f18523y, parameters.A, parameters.B, parameters.C);
            if (iArrQ.length > 1) {
                aVar = new b.a(trackGroupA2, iArrQ);
            }
        }
        if (aVar == null) {
            aVar = new b.a(trackGroupA2, i12);
        }
        return Pair.create(aVar, (b) hd.a.g(bVar));
    }

    @p0
    public b.a J(int i10, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        c cVar = null;
        int i11 = 0;
        for (int i12 = 0; i12 < trackGroupArray.f17502a; i12++) {
            TrackGroup trackGroupA = trackGroupArray.a(i12);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < trackGroupA.f17498a; i13++) {
                if (x(iArr2[i13], parameters.f18507k1)) {
                    c cVar2 = new c(trackGroupA.a(i13), iArr2[i13]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        trackGroup = trackGroupA;
                        i11 = i13;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new b.a(trackGroup, i11);
    }

    @p0
    public Pair<b.a, e> K(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, @p0 String str) throws ExoPlaybackException {
        int i10 = -1;
        TrackGroup trackGroup = null;
        e eVar = null;
        for (int i11 = 0; i11 < trackGroupArray.f17502a; i11++) {
            TrackGroup trackGroupA = trackGroupArray.a(i11);
            int[] iArr2 = iArr[i11];
            for (int i12 = 0; i12 < trackGroupA.f17498a; i12++) {
                if (x(iArr2[i12], parameters.f18507k1)) {
                    e eVar2 = new e(trackGroupA.a(i12), parameters, iArr2[i12], str);
                    if (eVar2.f18566a && (eVar == null || eVar2.compareTo(eVar) > 0)) {
                        trackGroup = trackGroupA;
                        i10 = i12;
                        eVar = eVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new b.a(trackGroup, i10), (e) hd.a.g(eVar));
    }

    @p0
    public b.a L(TrackGroupArray trackGroupArray, int[][] iArr, int i10, Parameters parameters, boolean z10) throws ExoPlaybackException {
        b.a aVarF = (parameters.K0 || parameters.f18506k0 || !z10) ? null : F(trackGroupArray, iArr, i10, parameters);
        return aVarF == null ? I(trackGroupArray, iArr, parameters) : aVarF;
    }

    public void M(Parameters parameters) {
        hd.a.g(parameters);
        if (this.f18502e.getAndSet(parameters).equals(parameters)) {
            return;
        }
        c();
    }

    public void N(d dVar) {
        M(dVar.a());
    }

    @Override // com.google.android.exoplayer2.trackselection.c
    public final Pair<r1[], com.google.android.exoplayer2.trackselection.b[]> j(c.a aVar, int[][][] iArr, int[] iArr2, l.a aVar2, x1 x1Var) throws ExoPlaybackException {
        Parameters parameters = this.f18502e.get();
        int iC = aVar.c();
        b.a[] aVarArrG = G(aVar, iArr, iArr2, parameters);
        int i10 = 0;
        while (true) {
            if (i10 >= iC) {
                break;
            }
            if (parameters.M(i10)) {
                aVarArrG[i10] = null;
            } else {
                TrackGroupArray trackGroupArrayG = aVar.g(i10);
                if (parameters.T(i10, trackGroupArrayG)) {
                    SelectionOverride selectionOverrideS = parameters.S(i10, trackGroupArrayG);
                    aVarArrG[i10] = selectionOverrideS != null ? new b.a(trackGroupArrayG.a(selectionOverrideS.f18525a), selectionOverrideS.f18526b, selectionOverrideS.f18528d, Integer.valueOf(selectionOverrideS.f18529e)) : null;
                }
            }
            i10++;
        }
        com.google.android.exoplayer2.trackselection.b[] bVarArrA = this.f18501d.a(aVarArrG, a(), aVar2, x1Var);
        r1[] r1VarArr = new r1[iC];
        for (int i11 = 0; i11 < iC; i11++) {
            r1VarArr[i11] = !parameters.M(i11) && (aVar.f(i11) == 7 || bVarArrA[i11] != null) ? r1.f57064b : null;
        }
        if (parameters.f18519v1) {
            C(aVar, iArr, r1VarArr, bVarArrA);
        }
        return Pair.create(r1VarArr, bVarArrA);
    }

    public d o() {
        return v().a();
    }

    public Parameters v() {
        return this.f18502e.get();
    }

    @Deprecated
    public DefaultTrackSelector(b.InterfaceC0194b interfaceC0194b) {
        this(Parameters.C2, interfaceC0194b);
    }

    public DefaultTrackSelector(Context context) {
        this(context, new a.b());
    }

    public DefaultTrackSelector(Context context, b.InterfaceC0194b interfaceC0194b) {
        this(Parameters.F(context), interfaceC0194b);
    }

    public DefaultTrackSelector(Parameters parameters, b.InterfaceC0194b interfaceC0194b) {
        this.f18501d = interfaceC0194b;
        this.f18502e = new AtomicReference<>(parameters);
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parameters C2 = new d().a();
        public static final Parcelable.Creator<Parameters> CREATOR = new a();
        public final boolean A;
        public final boolean B;
        public final boolean C;
        public final boolean C1;
        public final ImmutableList<String> D;
        public final boolean K0;
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> K1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f18503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f18504j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f18505k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public final boolean f18506k0;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        public final boolean f18507k1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f18508l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f18509m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f18510n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f18511o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f18512p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f18513q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f18514r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f18515s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f18516t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final int f18517u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f18518v;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public final boolean f18519v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final SparseBooleanArray f18520v2;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final ImmutableList<String> f18521w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f18522x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f18523y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final boolean f18524z;

        public class a implements Parcelable.Creator<Parameters> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Parameters[] newArray(int i10) {
                return new Parameters[i10];
            }
        }

        public Parameters(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10, boolean z11, boolean z12, int i18, int i19, boolean z13, ImmutableList<String> immutableList, ImmutableList<String> immutableList2, int i20, int i21, int i22, boolean z14, boolean z15, boolean z16, boolean z17, ImmutableList<String> immutableList3, ImmutableList<String> immutableList4, int i23, boolean z18, int i24, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(immutableList2, i20, immutableList4, i23, z18, i24);
            this.f18503i = i10;
            this.f18504j = i11;
            this.f18505k = i12;
            this.f18508l = i13;
            this.f18509m = i14;
            this.f18510n = i15;
            this.f18511o = i16;
            this.f18512p = i17;
            this.f18513q = z10;
            this.f18514r = z11;
            this.f18515s = z12;
            this.f18516t = i18;
            this.f18517u = i19;
            this.f18518v = z13;
            this.f18521w = immutableList;
            this.f18522x = i21;
            this.f18523y = i22;
            this.f18524z = z14;
            this.A = z15;
            this.B = z16;
            this.C = z17;
            this.D = immutableList3;
            this.f18506k0 = z19;
            this.K0 = z20;
            this.f18507k1 = z21;
            this.f18519v1 = z22;
            this.C1 = z23;
            this.K1 = sparseArray;
            this.f18520v2 = sparseBooleanArray;
        }

        public static Parameters F(Context context) {
            return new d(context).a();
        }

        public static SparseArray<Map<TrackGroupArray, SelectionOverride>> U(Parcel parcel) {
            int i10 = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = parcel.readInt();
                int i13 = parcel.readInt();
                HashMap map = new HashMap(i13);
                for (int i14 = 0; i14 < i13; i14++) {
                    map.put((TrackGroupArray) hd.a.g((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(i12, map);
            }
            return sparseArray;
        }

        public static void V(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                int iKeyAt = sparseArray.keyAt(i10);
                Map<TrackGroupArray, SelectionOverride> mapValueAt = sparseArray.valueAt(i10);
                int size2 = mapValueAt.size();
                parcel.writeInt(iKeyAt);
                parcel.writeInt(size2);
                for (Map.Entry<TrackGroupArray, SelectionOverride> entry : mapValueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        public static boolean j(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i10)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean s(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i10));
                if (iIndexOfKey < 0 || !z(sparseArray.valueAt(i10), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean z(Map<TrackGroupArray, SelectionOverride> map, Map<TrackGroupArray, SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<TrackGroupArray, SelectionOverride> entry : map.entrySet()) {
                TrackGroupArray key = entry.getKey();
                if (!map2.containsKey(key) || !u0.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public d a() {
            return new d(this);
        }

        public final boolean M(int i10) {
            return this.f18520v2.get(i10);
        }

        @p0
        public final SelectionOverride S(int i10, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.K1.get(i10);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean T(int i10, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.K1.get(i10);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(obj) && this.f18503i == parameters.f18503i && this.f18504j == parameters.f18504j && this.f18505k == parameters.f18505k && this.f18508l == parameters.f18508l && this.f18509m == parameters.f18509m && this.f18510n == parameters.f18510n && this.f18511o == parameters.f18511o && this.f18512p == parameters.f18512p && this.f18513q == parameters.f18513q && this.f18514r == parameters.f18514r && this.f18515s == parameters.f18515s && this.f18518v == parameters.f18518v && this.f18516t == parameters.f18516t && this.f18517u == parameters.f18517u && this.f18521w.equals(parameters.f18521w) && this.f18522x == parameters.f18522x && this.f18523y == parameters.f18523y && this.f18524z == parameters.f18524z && this.A == parameters.A && this.B == parameters.B && this.C == parameters.C && this.D.equals(parameters.D) && this.f18506k0 == parameters.f18506k0 && this.K0 == parameters.K0 && this.f18507k1 == parameters.f18507k1 && this.f18519v1 == parameters.f18519v1 && this.C1 == parameters.C1 && j(this.f18520v2, parameters.f18520v2) && s(this.K1, parameters.K1);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.f18503i) * 31) + this.f18504j) * 31) + this.f18505k) * 31) + this.f18508l) * 31) + this.f18509m) * 31) + this.f18510n) * 31) + this.f18511o) * 31) + this.f18512p) * 31) + (this.f18513q ? 1 : 0)) * 31) + (this.f18514r ? 1 : 0)) * 31) + (this.f18515s ? 1 : 0)) * 31) + (this.f18518v ? 1 : 0)) * 31) + this.f18516t) * 31) + this.f18517u) * 31) + this.f18521w.hashCode()) * 31) + this.f18522x) * 31) + this.f18523y) * 31) + (this.f18524z ? 1 : 0)) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31) + this.D.hashCode()) * 31) + (this.f18506k0 ? 1 : 0)) * 31) + (this.K0 ? 1 : 0)) * 31) + (this.f18507k1 ? 1 : 0)) * 31) + (this.f18519v1 ? 1 : 0)) * 31) + (this.C1 ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f18503i);
            parcel.writeInt(this.f18504j);
            parcel.writeInt(this.f18505k);
            parcel.writeInt(this.f18508l);
            parcel.writeInt(this.f18509m);
            parcel.writeInt(this.f18510n);
            parcel.writeInt(this.f18511o);
            parcel.writeInt(this.f18512p);
            u0.B1(parcel, this.f18513q);
            u0.B1(parcel, this.f18514r);
            u0.B1(parcel, this.f18515s);
            parcel.writeInt(this.f18516t);
            parcel.writeInt(this.f18517u);
            u0.B1(parcel, this.f18518v);
            parcel.writeList(this.f18521w);
            parcel.writeInt(this.f18522x);
            parcel.writeInt(this.f18523y);
            u0.B1(parcel, this.f18524z);
            u0.B1(parcel, this.A);
            u0.B1(parcel, this.B);
            u0.B1(parcel, this.C);
            parcel.writeList(this.D);
            u0.B1(parcel, this.f18506k0);
            u0.B1(parcel, this.K0);
            u0.B1(parcel, this.f18507k1);
            u0.B1(parcel, this.f18519v1);
            u0.B1(parcel, this.C1);
            V(parcel, this.K1);
            parcel.writeSparseBooleanArray(this.f18520v2);
        }

        public Parameters(Parcel parcel) {
            super(parcel);
            this.f18503i = parcel.readInt();
            this.f18504j = parcel.readInt();
            this.f18505k = parcel.readInt();
            this.f18508l = parcel.readInt();
            this.f18509m = parcel.readInt();
            this.f18510n = parcel.readInt();
            this.f18511o = parcel.readInt();
            this.f18512p = parcel.readInt();
            this.f18513q = u0.b1(parcel);
            this.f18514r = u0.b1(parcel);
            this.f18515s = u0.b1(parcel);
            this.f18516t = parcel.readInt();
            this.f18517u = parcel.readInt();
            this.f18518v = u0.b1(parcel);
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, null);
            this.f18521w = ImmutableList.copyOf((Collection) arrayList);
            this.f18522x = parcel.readInt();
            this.f18523y = parcel.readInt();
            this.f18524z = u0.b1(parcel);
            this.A = u0.b1(parcel);
            this.B = u0.b1(parcel);
            this.C = u0.b1(parcel);
            ArrayList arrayList2 = new ArrayList();
            parcel.readList(arrayList2, null);
            this.D = ImmutableList.copyOf((Collection) arrayList2);
            this.f18506k0 = u0.b1(parcel);
            this.K0 = u0.b1(parcel);
            this.f18507k1 = u0.b1(parcel);
            this.f18519v1 = u0.b1(parcel);
            this.C1 = u0.b1(parcel);
            this.K1 = U(parcel);
            this.f18520v2 = (SparseBooleanArray) u0.k(parcel.readSparseBooleanArray());
        }
    }
}
