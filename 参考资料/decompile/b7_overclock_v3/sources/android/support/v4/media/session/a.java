package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    public static class C0021a implements a {
        @Override // android.support.v4.media.session.a
        public void L0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void M() throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void M0(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void N(Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void O0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void Q(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.media.session.a
        public void c0(boolean z10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void h0(boolean z10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void i0(CharSequence charSequence) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void m0() throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void o0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void u0(int i10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.a
        public void v(int i10) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1235a = "android.support.v4.media.session.IMediaControllerCallback";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f1236b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f1237c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f1238d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f1239e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f1240f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f1241g = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f1242h = 7;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f1243n = 8;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f1244o = 9;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f1245p = 10;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f1246q = 11;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f1247r = 12;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f1248s = 13;

        /* JADX INFO: renamed from: android.support.v4.media.session.a$b$a, reason: collision with other inner class name */
        public static class C0022a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static a f1249b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1250a;

            public C0022a(IBinder iBinder) {
                this.f1250a = iBinder;
            }

            @Override // android.support.v4.media.session.a
            public void L0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (playbackStateCompat != null) {
                        parcelObtain.writeInt(1);
                        playbackStateCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1250a.transact(3, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().L0(playbackStateCompat);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void M() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (this.f1250a.transact(13, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().M();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void M0(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1250a.transact(1, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().M0(str, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void N(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1250a.transact(7, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().N(bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void O0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (parcelableVolumeInfo != null) {
                        parcelObtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1250a.transact(8, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().O0(parcelableVolumeInfo);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void Q(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    parcelObtain.writeTypedList(list);
                    if (this.f1250a.transact(5, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().Q(list);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return b.f1235a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1250a;
            }

            @Override // android.support.v4.media.session.a
            public void c0(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f1250a.transact(11, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().c0(z10);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void h0(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f1250a.transact(10, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().h0(z10);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void i0(CharSequence charSequence) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1250a.transact(6, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().i0(charSequence);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void m0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (this.f1250a.transact(2, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().m0();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void o0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    if (mediaMetadataCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1250a.transact(4, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().o0(mediaMetadataCompat);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void u0(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    parcelObtain.writeInt(i10);
                    if (this.f1250a.transact(12, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().u0(i10);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void v(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f1235a);
                    parcelObtain.writeInt(i10);
                    if (this.f1250a.transact(9, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().v(i10);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f1235a);
        }

        public static a Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f1235a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0022a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a R0() {
            return C0022a.f1249b;
        }

        public static boolean S0(a aVar) {
            if (C0022a.f1249b != null || aVar == null) {
                return false;
            }
            C0022a.f1249b = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f1235a);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f1235a);
                    M0(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(f1235a);
                    m0();
                    return true;
                case 3:
                    parcel.enforceInterface(f1235a);
                    L0(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface(f1235a);
                    o0(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface(f1235a);
                    Q(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    parcel.enforceInterface(f1235a);
                    i0(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface(f1235a);
                    N(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface(f1235a);
                    O0(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface(f1235a);
                    v(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface(f1235a);
                    h0(parcel.readInt() != 0);
                    return true;
                case 11:
                    parcel.enforceInterface(f1235a);
                    c0(parcel.readInt() != 0);
                    return true;
                case 12:
                    parcel.enforceInterface(f1235a);
                    u0(parcel.readInt());
                    return true;
                case 13:
                    parcel.enforceInterface(f1235a);
                    M();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void L0(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void M() throws RemoteException;

    void M0(String str, Bundle bundle) throws RemoteException;

    void N(Bundle bundle) throws RemoteException;

    void O0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void Q(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void c0(boolean z10) throws RemoteException;

    void h0(boolean z10) throws RemoteException;

    void i0(CharSequence charSequence) throws RemoteException;

    void m0() throws RemoteException;

    void o0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void u0(int i10) throws RemoteException;

    void v(int i10) throws RemoteException;
}
