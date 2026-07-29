package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import ub.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17304a;

    public Id3Frame(String str) {
        this.f17304a = str;
    }

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
        return this.f17304a;
    }
}
