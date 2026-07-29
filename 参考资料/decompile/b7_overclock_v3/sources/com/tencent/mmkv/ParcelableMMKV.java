package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new Parcelable.Creator<ParcelableMMKV>() { // from class: com.tencent.mmkv.ParcelableMMKV.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV createFromParcel(Parcel source) {
            String string = source.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            String string2 = source.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(string, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), string2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV[] newArray(int size) {
            return new ParcelableMMKV[size];
        }
    };
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private final String mmapID;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public MMKV toMMKV() {
        int i10;
        int i11 = this.ashmemFD;
        if (i11 < 0 || (i10 = this.ashmemMetaFD) < 0) {
            return null;
        }
        return MMKV.mmkvWithAshmemFD(this.mmapID, i11, i10, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        try {
            dest.writeString(this.mmapID);
            ParcelFileDescriptor parcelFileDescriptorFromFd = ParcelFileDescriptor.fromFd(this.ashmemFD);
            ParcelFileDescriptor parcelFileDescriptorFromFd2 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i10 = flags | 1;
            parcelFileDescriptorFromFd.writeToParcel(dest, i10);
            parcelFileDescriptorFromFd2.writeToParcel(dest, i10);
            String str = this.cryptKey;
            if (str != null) {
                dest.writeString(str);
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = mmkv.mmapID();
        this.ashmemFD = mmkv.ashmemFD();
        this.ashmemMetaFD = mmkv.ashmemMetaFD();
        this.cryptKey = mmkv.cryptKey();
    }

    private ParcelableMMKV(String id2, int fd2, int metaFD, String key) {
        this.mmapID = id2;
        this.ashmemFD = fd2;
        this.ashmemMetaFD = metaFD;
        this.cryptKey = key;
    }
}
