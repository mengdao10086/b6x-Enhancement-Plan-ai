package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import ub.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] O() {
        return a.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return a.b(this);
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
