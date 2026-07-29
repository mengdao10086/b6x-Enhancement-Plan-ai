package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import hd.c0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f17341c;

    public class a implements Parcelable.Creator<PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PrivateCommand[] newArray(int i10) {
            return new PrivateCommand[i10];
        }
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static PrivateCommand a(c0 c0Var, int i10, long j10) {
        long jI = c0Var.I();
        int i11 = i10 - 4;
        byte[] bArr = new byte[i11];
        c0Var.k(bArr, 0, i11);
        return new PrivateCommand(jI, bArr, j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f17339a);
        parcel.writeLong(this.f17340b);
        parcel.writeByteArray(this.f17341c);
    }

    public PrivateCommand(long j10, byte[] bArr, long j11) {
        this.f17339a = j11;
        this.f17340b = j10;
        this.f17341c = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.f17339a = parcel.readLong();
        this.f17340b = parcel.readLong();
        this.f17341c = (byte[]) u0.k(parcel.createByteArray());
    }
}
