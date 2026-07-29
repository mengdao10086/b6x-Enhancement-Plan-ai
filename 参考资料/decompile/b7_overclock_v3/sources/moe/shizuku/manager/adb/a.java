package moe.shizuku.manager.adb;

import android.os.Build;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final String f41486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final AdbKey f41488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Socket f41489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataInputStream f41490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataOutputStream f41491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SSLSocket f41493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DataInputStream f41494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DataOutputStream f41495j;

    public a(@k String host, int i10, @k AdbKey key) {
        f0.p(host, "host");
        f0.p(key, "key");
        this.f41486a = host;
        this.f41487b = i10;
        this.f41488c = key;
    }

    public static /* synthetic */ void m(a aVar, int i10, int i11, int i12, byte[] bArr, int i13, Object obj) throws IOException {
        if ((i13 & 8) != 0) {
            bArr = null;
        }
        aVar.k(i10, i11, i12, bArr);
    }

    public final void a() throws IOException {
        Socket socket = new Socket(this.f41486a, this.f41487b);
        this.f41489d = socket;
        socket.setTcpNoDelay(true);
        Socket socket2 = this.f41489d;
        SSLSocket sSLSocket = null;
        if (socket2 == null) {
            f0.S("socket");
            socket2 = null;
        }
        this.f41490e = new DataInputStream(socket2.getInputStream());
        Socket socket3 = this.f41489d;
        if (socket3 == null) {
            f0.S("socket");
            socket3 = null;
        }
        this.f41491f = new DataOutputStream(socket3.getOutputStream());
        i(1314410051, 16777216, 4096, "host::");
        g gVarF = f();
        if (gVarF.c() == 1397511251) {
            if (Build.VERSION.SDK_INT < 29) {
                throw new IllegalStateException("Connect to adb with TLS is not supported before Android 9".toString());
            }
            m(this, i.f41539i, 16777216, 0, null, 8, null);
            SSLSocketFactory socketFactory = this.f41488c.l().getSocketFactory();
            Socket socket4 = this.f41489d;
            if (socket4 == null) {
                f0.S("socket");
                socket4 = null;
            }
            Socket socketCreateSocket = socketFactory.createSocket(socket4, this.f41486a, this.f41487b, true);
            f0.n(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            this.f41493h = sSLSocket2;
            if (sSLSocket2 == null) {
                f0.S("tlsSocket");
                sSLSocket2 = null;
            }
            sSLSocket2.startHandshake();
            SSLSocket sSLSocket3 = this.f41493h;
            if (sSLSocket3 == null) {
                f0.S("tlsSocket");
                sSLSocket3 = null;
            }
            this.f41494i = new DataInputStream(sSLSocket3.getInputStream());
            SSLSocket sSLSocket4 = this.f41493h;
            if (sSLSocket4 == null) {
                f0.S("tlsSocket");
            } else {
                sSLSocket = sSLSocket4;
            }
            this.f41495j = new DataOutputStream(sSLSocket.getOutputStream());
            this.f41492g = true;
            gVarF = f();
        } else if (gVarF.c() == 1213486401) {
            if (gVarF.c() != 1213486401 && gVarF.a() != 1) {
                throw new IllegalStateException("not A_AUTH ADB_AUTH_TOKEN".toString());
            }
            k(1213486401, 2, 0, this.f41488c.n(gVarF.d()));
            gVarF = f();
            if (gVarF.c() != 1314410051) {
                k(1213486401, 3, 0, this.f41488c.h());
                gVarF = f();
            }
        }
        if (gVarF.c() != 1314410051) {
            throw new IllegalStateException("not A_CNXN".toString());
        }
    }

    public final DataInputStream c() {
        DataInputStream dataInputStream;
        String str;
        if (this.f41492g) {
            dataInputStream = this.f41494i;
            if (dataInputStream == null) {
                str = "tlsInputStream";
                f0.S(str);
                return null;
            }
            return dataInputStream;
        }
        dataInputStream = this.f41490e;
        if (dataInputStream == null) {
            str = "plainInputStream";
            f0.S(str);
            return null;
        }
        return dataInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SSLSocket sSLSocket = null;
        try {
            DataInputStream dataInputStream = this.f41490e;
            if (dataInputStream == null) {
                f0.S("plainInputStream");
                dataInputStream = null;
            }
            dataInputStream.close();
        } catch (Throwable unused) {
        }
        try {
            DataOutputStream dataOutputStream = this.f41491f;
            if (dataOutputStream == null) {
                f0.S("plainOutputStream");
                dataOutputStream = null;
            }
            dataOutputStream.close();
        } catch (Throwable unused2) {
        }
        try {
            Socket socket = this.f41489d;
            if (socket == null) {
                f0.S("socket");
                socket = null;
            }
            socket.close();
        } catch (Exception unused3) {
        }
        if (this.f41492g) {
            try {
                DataInputStream dataInputStream2 = this.f41494i;
                if (dataInputStream2 == null) {
                    f0.S("tlsInputStream");
                    dataInputStream2 = null;
                }
                dataInputStream2.close();
            } catch (Throwable unused4) {
            }
            try {
                DataOutputStream dataOutputStream2 = this.f41495j;
                if (dataOutputStream2 == null) {
                    f0.S("tlsOutputStream");
                    dataOutputStream2 = null;
                }
                dataOutputStream2.close();
            } catch (Throwable unused5) {
            }
            try {
                SSLSocket sSLSocket2 = this.f41493h;
                if (sSLSocket2 == null) {
                    f0.S("tlsSocket");
                } else {
                    sSLSocket = sSLSocket2;
                }
                sSLSocket.close();
            } catch (Exception unused6) {
            }
        }
    }

    public final DataOutputStream d() {
        DataOutputStream dataOutputStream;
        String str;
        if (this.f41492g) {
            dataOutputStream = this.f41495j;
            if (dataOutputStream == null) {
                str = "tlsOutputStream";
                f0.S(str);
                return null;
            }
            return dataOutputStream;
        }
        dataOutputStream = this.f41491f;
        if (dataOutputStream == null) {
            str = "plainOutputStream";
            f0.S(str);
            return null;
        }
        return dataOutputStream;
    }

    public final g f() throws IOException {
        byte[] bArr;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(24).order(ByteOrder.LITTLE_ENDIAN);
        c().readFully(byteBufferOrder.array(), 0, 24);
        int i10 = byteBufferOrder.getInt();
        int i11 = byteBufferOrder.getInt();
        int i12 = byteBufferOrder.getInt();
        int i13 = byteBufferOrder.getInt();
        int i14 = byteBufferOrder.getInt();
        int i15 = byteBufferOrder.getInt();
        if (i13 >= 0) {
            bArr = new byte[i13];
            c().readFully(bArr, 0, i13);
        } else {
            bArr = null;
        }
        g gVar = new g(i10, i11, i12, i13, i14, i15, bArr);
        gVar.k();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("read ");
        sb2.append(gVar.i());
        return gVar;
    }

    public final void h(@k String command, @l ik.l<? super byte[], z1> lVar) throws IOException {
        g gVarF;
        int iA;
        f0.p(command, "command");
        i(1313165391, 1, 0, command);
        g gVarF2 = f();
        int iC = gVarF2.c();
        if (iC == 1163086915) {
            m(this, 1163086915, 1, gVarF2.a(), null, 8, null);
            return;
        }
        if (iC != 1497451343) {
            throw new IllegalStateException("not A_OKAY or A_CLSE".toString());
        }
        while (true) {
            gVarF = f();
            iA = gVarF.a();
            if (gVarF.c() != 1163154007) {
                break;
            }
            if (gVarF.f() > 0 && lVar != null) {
                byte[] bArrD = gVarF.d();
                f0.m(bArrD);
                lVar.i(bArrD);
            }
            m(this, 1497451343, 1, iA, null, 8, null);
        }
        if (gVarF.c() != 1163086915) {
            throw new IllegalStateException("not A_WRTE or A_CLSE".toString());
        }
        m(this, 1163086915, 1, iA, null, 8, null);
    }

    public final void i(int i10, int i11, int i12, String str) throws IOException {
        l(new g(i10, i11, i12, str));
    }

    public final void k(int i10, int i11, int i12, byte[] bArr) throws IOException {
        l(new g(i10, i11, i12, bArr));
    }

    public final void l(g gVar) throws IOException {
        d().write(gVar.h());
        d().flush();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("write ");
        sb2.append(gVar.i());
    }
}
