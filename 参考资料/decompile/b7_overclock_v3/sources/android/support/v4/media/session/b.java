package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // android.support.v4.media.session.b
        public void B(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void B0(long j10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void C(android.support.v4.media.session.a aVar) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void C0(boolean z10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public boolean D() throws RemoteException {
            return false;
        }

        @Override // android.support.v4.media.session.b
        public ParcelableVolumeInfo D0() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void E(RatingCompat ratingCompat) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void F(int i10, int i11, String str) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void G(Uri uri, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public boolean H() throws RemoteException {
            return false;
        }

        @Override // android.support.v4.media.session.b
        public PendingIntent I() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void K(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void T(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void U(android.support.v4.media.session.a aVar) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void V(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void X(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void Z() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void a0(Uri uri, Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public PlaybackStateCompat d() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public long e() throws RemoteException {
            return 0L;
        }

        @Override // android.support.v4.media.session.b
        public void f() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void f0(float f10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void g(long j10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public boolean g0(KeyEvent keyEvent) throws RemoteException {
            return false;
        }

        @Override // android.support.v4.media.session.b
        public Bundle getExtras() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public String h() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void i() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void j(int i10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void j0(int i10, int i11, String str) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public int k() throws RemoteException {
            return 0;
        }

        @Override // android.support.v4.media.session.b
        public void l0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public String m() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void n0(MediaDescriptionCompat mediaDescriptionCompat, int i10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void next() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void o(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void p(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void pause() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void previous() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public int q() throws RemoteException {
            return 0;
        }

        @Override // android.support.v4.media.session.b
        public CharSequence r() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public MediaMetadataCompat s() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void s0(int i10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void stop() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public Bundle t() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void u(boolean z10) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public int w() throws RemoteException {
            return 0;
        }

        @Override // android.support.v4.media.session.b
        public void w0(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public boolean x() throws RemoteException {
            return false;
        }

        @Override // android.support.v4.media.session.b
        public List<MediaSessionCompat.QueueItem> y() throws RemoteException {
            return null;
        }

        @Override // android.support.v4.media.session.b
        public void y0() throws RemoteException {
        }

        @Override // android.support.v4.media.session.b
        public void z(int i10) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0023b extends Binder implements b {
        public static final int A = 38;
        public static final int B = 47;
        public static final int C = 41;
        public static final int D = 42;
        public static final int E = 43;
        public static final int F = 44;
        public static final int G = 50;
        public static final int H = 33;
        public static final int I = 34;
        public static final int J = 35;
        public static final int K = 36;
        public static final int L = 13;
        public static final int M = 14;
        public static final int N = 15;
        public static final int O = 16;
        public static final int P = 17;
        public static final int Q = 18;
        public static final int R = 19;
        public static final int S = 20;
        public static final int T = 21;
        public static final int U = 22;
        public static final int V = 23;
        public static final int W = 24;
        public static final int X = 25;
        public static final int Y = 51;
        public static final int Z = 49;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1251a = "android.support.v4.media.session.IMediaSession";

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final int f1252a0 = 46;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f1253b = 1;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final int f1254b0 = 39;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f1255c = 2;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int f1256c0 = 40;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f1257d = 3;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final int f1258d0 = 48;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f1259e = 4;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final int f1260e0 = 26;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f1261f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f1262g = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f1263h = 7;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f1264n = 8;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f1265o = 9;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f1266p = 10;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f1267q = 11;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f1268r = 12;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f1269s = 27;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f1270t = 28;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f1271u = 29;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f1272v = 30;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f1273w = 31;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f1274x = 32;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f1275y = 45;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f1276z = 37;

        /* JADX INFO: renamed from: android.support.v4.media.session.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f1277b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1278a;

            public a(IBinder iBinder) {
                this.f1278a = iBinder;
            }

            @Override // android.support.v4.media.session.b
            public void B(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(26, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().B(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void B0(long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeLong(j10);
                    if (this.f1278a.transact(17, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().B0(j10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void C(android.support.v4.media.session.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f1278a.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().C(aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void C0(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f1278a.transact(40, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().C0(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public boolean D() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(38, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().D();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo D0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().D0();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void E(RatingCompat ratingCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (ratingCompat != null) {
                        parcelObtain.writeInt(1);
                        ratingCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(25, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().E(ratingCompat);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void F(int i10, int i11, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeString(str);
                    if (this.f1278a.transact(12, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().F(i10, i11, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void G(Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(36, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().G(uri, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public boolean H() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().H();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent I() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().I();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void K(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(35, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().K(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return AbstractBinderC0023b.f1251a;
            }

            @Override // android.support.v4.media.session.b
            public void T(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(34, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().T(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void U(android.support.v4.media.session.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f1278a.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().U(aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void V(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(14, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().V(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void X(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(15, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().X(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void Z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(22, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().Z();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void a0(Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(16, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().a0(uri, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1278a;
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(28, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public long e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void f() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(33, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().f();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void f0(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeFloat(f10);
                    if (this.f1278a.transact(49, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().f0(f10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void g(long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeLong(j10);
                    if (this.f1278a.transact(24, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().g(j10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public boolean g0(KeyEvent keyEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (keyEvent != null) {
                        parcelObtain.writeInt(1);
                        keyEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f1278a.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().g0(keyEvent);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(31, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().getExtras();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public String h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().h();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void i() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(13, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().i();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void j(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(i10);
                    if (this.f1278a.transact(39, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().j(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void j0(int i10, int i11, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeString(str);
                    if (this.f1278a.transact(11, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().j0(i10, i11, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public int k() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(37, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().k();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void l0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (ratingCompat != null) {
                        parcelObtain.writeInt(1);
                        ratingCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(51, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().l0(ratingCompat, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public String m() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().m();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void n0(MediaDescriptionCompat mediaDescriptionCompat, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (mediaDescriptionCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i10);
                    if (this.f1278a.transact(42, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().n0(mediaDescriptionCompat, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void next() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(20, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().next();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void o(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (mediaDescriptionCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(43, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().o(mediaDescriptionCompat);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void p(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (mediaDescriptionCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(41, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().p(mediaDescriptionCompat);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void pause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(18, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().pause();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void previous() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(21, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().previous();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public int q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(32, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().q();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public CharSequence r() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(30, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().r();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(27, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().s();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void s0(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(i10);
                    if (this.f1278a.transact(44, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().s0(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void stop() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(19, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().stop();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public Bundle t() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(50, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().t();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void u(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f1278a.transact(46, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().u(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public int w() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(47, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().w();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void w0(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (resultReceiverWrapper != null) {
                        parcelObtain.writeInt(1);
                        resultReceiverWrapper.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1278a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().w0(str, bundle, resultReceiverWrapper);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public boolean x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(45, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().x();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public List<MediaSessionCompat.QueueItem> y() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (!this.f1278a.transact(29, parcelObtain, parcelObtain2, 0) && AbstractBinderC0023b.R0() != null) {
                        return AbstractBinderC0023b.R0().y();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void y0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    if (this.f1278a.transact(23, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().y0();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void z(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0023b.f1251a);
                    parcelObtain.writeInt(i10);
                    if (this.f1278a.transact(48, parcelObtain, parcelObtain2, 0) || AbstractBinderC0023b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0023b.R0().z(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0023b() {
            attachInterface(this, f1251a);
        }

        public static b Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f1251a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b R0() {
            return a.f1277b;
        }

        public static boolean S0(b bVar) {
            if (a.f1277b != null || bVar == null) {
                return false;
            }
            a.f1277b = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f1251a);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f1251a);
                    w0(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(f1251a);
                    boolean zG0 = g0(parcel.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zG0 ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(f1251a);
                    C(a.b.Q0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(f1251a);
                    U(a.b.Q0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(f1251a);
                    boolean zH = H();
                    parcel2.writeNoException();
                    parcel2.writeInt(zH ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(f1251a);
                    String strM = m();
                    parcel2.writeNoException();
                    parcel2.writeString(strM);
                    return true;
                case 7:
                    parcel.enforceInterface(f1251a);
                    String strH = h();
                    parcel2.writeNoException();
                    parcel2.writeString(strH);
                    return true;
                case 8:
                    parcel.enforceInterface(f1251a);
                    PendingIntent pendingIntentI = I();
                    parcel2.writeNoException();
                    if (pendingIntentI != null) {
                        parcel2.writeInt(1);
                        pendingIntentI.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface(f1251a);
                    long jE = e();
                    parcel2.writeNoException();
                    parcel2.writeLong(jE);
                    return true;
                case 10:
                    parcel.enforceInterface(f1251a);
                    ParcelableVolumeInfo parcelableVolumeInfoD0 = D0();
                    parcel2.writeNoException();
                    if (parcelableVolumeInfoD0 != null) {
                        parcel2.writeInt(1);
                        parcelableVolumeInfoD0.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface(f1251a);
                    j0(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(f1251a);
                    F(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(f1251a);
                    i();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(f1251a);
                    V(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(f1251a);
                    X(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(f1251a);
                    a0(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(f1251a);
                    B0(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(f1251a);
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(f1251a);
                    stop();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(f1251a);
                    next();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(f1251a);
                    previous();
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(f1251a);
                    Z();
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(f1251a);
                    y0();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(f1251a);
                    g(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(f1251a);
                    E(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(f1251a);
                    B(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(f1251a);
                    MediaMetadataCompat mediaMetadataCompatS = s();
                    parcel2.writeNoException();
                    if (mediaMetadataCompatS != null) {
                        parcel2.writeInt(1);
                        mediaMetadataCompatS.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface(f1251a);
                    PlaybackStateCompat playbackStateCompatD = d();
                    parcel2.writeNoException();
                    if (playbackStateCompatD != null) {
                        parcel2.writeInt(1);
                        playbackStateCompatD.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface(f1251a);
                    List<MediaSessionCompat.QueueItem> listY = y();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listY);
                    return true;
                case 30:
                    parcel.enforceInterface(f1251a);
                    CharSequence charSequenceR = r();
                    parcel2.writeNoException();
                    if (charSequenceR != null) {
                        parcel2.writeInt(1);
                        TextUtils.writeToParcel(charSequenceR, parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface(f1251a);
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    if (extras != null) {
                        parcel2.writeInt(1);
                        extras.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 32:
                    parcel.enforceInterface(f1251a);
                    int iQ = q();
                    parcel2.writeNoException();
                    parcel2.writeInt(iQ);
                    return true;
                case 33:
                    parcel.enforceInterface(f1251a);
                    f();
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(f1251a);
                    T(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(f1251a);
                    K(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(f1251a);
                    G(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(f1251a);
                    int iK = k();
                    parcel2.writeNoException();
                    parcel2.writeInt(iK);
                    return true;
                case 38:
                    parcel.enforceInterface(f1251a);
                    boolean zD = D();
                    parcel2.writeNoException();
                    parcel2.writeInt(zD ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface(f1251a);
                    j(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface(f1251a);
                    C0(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface(f1251a);
                    p(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(f1251a);
                    n0(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(f1251a);
                    o(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(f1251a);
                    s0(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(f1251a);
                    boolean zX = x();
                    parcel2.writeNoException();
                    parcel2.writeInt(zX ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface(f1251a);
                    u(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(f1251a);
                    int iW = w();
                    parcel2.writeNoException();
                    parcel2.writeInt(iW);
                    return true;
                case 48:
                    parcel.enforceInterface(f1251a);
                    z(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(f1251a);
                    f0(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(f1251a);
                    Bundle bundleT = t();
                    parcel2.writeNoException();
                    if (bundleT != null) {
                        parcel2.writeInt(1);
                        bundleT.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 51:
                    parcel.enforceInterface(f1251a);
                    l0(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void B(String str, Bundle bundle) throws RemoteException;

    void B0(long j10) throws RemoteException;

    void C(android.support.v4.media.session.a aVar) throws RemoteException;

    void C0(boolean z10) throws RemoteException;

    boolean D() throws RemoteException;

    ParcelableVolumeInfo D0() throws RemoteException;

    void E(RatingCompat ratingCompat) throws RemoteException;

    void F(int i10, int i11, String str) throws RemoteException;

    void G(Uri uri, Bundle bundle) throws RemoteException;

    boolean H() throws RemoteException;

    PendingIntent I() throws RemoteException;

    void K(String str, Bundle bundle) throws RemoteException;

    void T(String str, Bundle bundle) throws RemoteException;

    void U(android.support.v4.media.session.a aVar) throws RemoteException;

    void V(String str, Bundle bundle) throws RemoteException;

    void X(String str, Bundle bundle) throws RemoteException;

    void Z() throws RemoteException;

    void a0(Uri uri, Bundle bundle) throws RemoteException;

    PlaybackStateCompat d() throws RemoteException;

    long e() throws RemoteException;

    void f() throws RemoteException;

    void f0(float f10) throws RemoteException;

    void g(long j10) throws RemoteException;

    boolean g0(KeyEvent keyEvent) throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String h() throws RemoteException;

    void i() throws RemoteException;

    void j(int i10) throws RemoteException;

    void j0(int i10, int i11, String str) throws RemoteException;

    int k() throws RemoteException;

    void l0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    String m() throws RemoteException;

    void n0(MediaDescriptionCompat mediaDescriptionCompat, int i10) throws RemoteException;

    void next() throws RemoteException;

    void o(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void p(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void pause() throws RemoteException;

    void previous() throws RemoteException;

    int q() throws RemoteException;

    CharSequence r() throws RemoteException;

    MediaMetadataCompat s() throws RemoteException;

    void s0(int i10) throws RemoteException;

    void stop() throws RemoteException;

    Bundle t() throws RemoteException;

    void u(boolean z10) throws RemoteException;

    int w() throws RemoteException;

    void w0(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    boolean x() throws RemoteException;

    List<MediaSessionCompat.QueueItem> y() throws RemoteException;

    void y0() throws RemoteException;

    void z(int i10) throws RemoteException;
}
