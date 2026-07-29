package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import hd.c0;
import hd.p0;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17373b;

    public class a implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand[] newArray(int i10) {
            return new TimeSignalCommand[i10];
        }
    }

    public /* synthetic */ TimeSignalCommand(long j10, long j11, a aVar) {
        this(j10, j11);
    }

    public static TimeSignalCommand a(c0 c0Var, long j10, p0 p0Var) {
        long jB = b(c0Var, j10);
        return new TimeSignalCommand(jB, p0Var.b(jB));
    }

    public static long b(c0 c0Var, long j10) {
        long jG = c0Var.G();
        return (128 & jG) != 0 ? 8589934591L & ((((jG & 1) << 32) | c0Var.I()) + j10) : g.f56663b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f17372a);
        parcel.writeLong(this.f17373b);
    }

    public TimeSignalCommand(long j10, long j11) {
        this.f17372a = j10;
        this.f17373b = j11;
    }
}
