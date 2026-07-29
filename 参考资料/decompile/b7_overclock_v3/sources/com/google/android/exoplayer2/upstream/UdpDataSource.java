package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import g.p0;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public final class UdpDataSource extends ed.e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f19072p = 2000;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f19073q = 8000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f19074r = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f19076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DatagramPacket f19077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public Uri f19078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public DatagramSocket f19079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public MulticastSocket f19080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public InetAddress f19081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public InetSocketAddress f19082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19084o;

    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws UdpDataSourceException {
        Uri uri = bVar.f19092a;
        this.f19078i = uri;
        String host = uri.getHost();
        int port = this.f19078i.getPort();
        w(bVar);
        try {
            this.f19081l = InetAddress.getByName(host);
            this.f19082m = new InetSocketAddress(this.f19081l, port);
            if (this.f19081l.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f19082m);
                this.f19080k = multicastSocket;
                multicastSocket.joinGroup(this.f19081l);
                this.f19079j = this.f19080k;
            } else {
                this.f19079j = new DatagramSocket(this.f19082m);
            }
            try {
                this.f19079j.setSoTimeout(this.f19075f);
                this.f19083n = true;
                x(bVar);
                return -1L;
            } catch (SocketException e10) {
                throw new UdpDataSourceException(e10);
            }
        } catch (IOException e11) {
            throw new UdpDataSourceException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.f19078i = null;
        MulticastSocket multicastSocket = this.f19080k;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f19081l);
            } catch (IOException unused) {
            }
            this.f19080k = null;
        }
        DatagramSocket datagramSocket = this.f19079j;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f19079j = null;
        }
        this.f19081l = null;
        this.f19082m = null;
        this.f19084o = 0;
        if (this.f19083n) {
            this.f19083n = false;
            v();
        }
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws UdpDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        if (this.f19084o == 0) {
            try {
                this.f19079j.receive(this.f19077h);
                int length = this.f19077h.getLength();
                this.f19084o = length;
                u(length);
            } catch (IOException e10) {
                throw new UdpDataSourceException(e10);
            }
        }
        int length2 = this.f19077h.getLength();
        int i12 = this.f19084o;
        int iMin = Math.min(i12, i11);
        System.arraycopy(this.f19076g, length2 - i12, bArr, i10, iMin);
        this.f19084o -= iMin;
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f19078i;
    }

    public int y() {
        DatagramSocket datagramSocket = this.f19079j;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    public UdpDataSource(int i10) {
        this(i10, 8000);
    }

    public UdpDataSource(int i10, int i11) {
        super(true);
        this.f19075f = i11;
        byte[] bArr = new byte[i10];
        this.f19076g = bArr;
        this.f19077h = new DatagramPacket(bArr, 0, i10);
    }
}
