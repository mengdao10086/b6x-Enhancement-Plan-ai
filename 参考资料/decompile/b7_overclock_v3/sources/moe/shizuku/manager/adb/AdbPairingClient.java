package moe.shizuku.manager.adb;

import hk.m;
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
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import moe.shizuku.manager.adb.PairingPacketHeader;
import moe.shizuku.manager.adb.PeerInfo;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nAdbPairingClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingClient.kt\nmoe/shizuku/manager/adb/AdbPairingClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n1#2:332\n*E\n"})
public final class AdbPairingClient implements Closeable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final a f41465k = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final String f41466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final String f41468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final AdbKey f41469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Socket f41470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataInputStream f41471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataOutputStream f41472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final PeerInfo f41473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PairingContext f41474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public State f41475j;

    public enum State {
        Ready,
        ExchangingMsgs,
        ExchangingPeerInfo,
        Stopped
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        public final boolean a() {
            return AdbPairingClient.available();
        }
    }

    static {
        System.loadLibrary("adb");
    }

    public AdbPairingClient(@k String host, int i10, @k String pairCode, @k AdbKey key) {
        f0.p(host, "host");
        f0.p(pairCode, "pairCode");
        f0.p(key, "key");
        this.f41466a = host;
        this.f41467b = i10;
        this.f41468c = pairCode;
        this.f41469d = key;
        this.f41473h = new PeerInfo(PeerInfo.Type.ADB_RSA_PUB_KEY.getValue(), key.h());
        this.f41475j = State.Ready;
    }

    @m
    public static final native boolean available();

    public final PairingPacketHeader a(PairingPacketHeader.Type type, int i10) {
        return new PairingPacketHeader((byte) 1, type.getValue(), i10);
    }

    public final boolean c() throws IOException {
        PairingContext pairingContext = this.f41474i;
        PairingContext pairingContext2 = null;
        if (pairingContext == null) {
            f0.S("pairingContext");
            pairingContext = null;
        }
        byte[] bArrE = pairingContext.e();
        int length = bArrE.length;
        PairingPacketHeader.Type type = PairingPacketHeader.Type.SPAKE2_MSG;
        k(a(type, length), bArrE);
        PairingPacketHeader pairingPacketHeaderF = f();
        if (pairingPacketHeaderF == null || pairingPacketHeaderF.b() != type.getValue()) {
            return false;
        }
        byte[] bArr = new byte[pairingPacketHeaderF.a()];
        DataInputStream dataInputStream = this.f41471f;
        if (dataInputStream == null) {
            f0.S("inputStream");
            dataInputStream = null;
        }
        dataInputStream.readFully(bArr);
        PairingContext pairingContext3 = this.f41474i;
        if (pairingContext3 == null) {
            f0.S("pairingContext");
        } else {
            pairingContext2 = pairingContext3;
        }
        return pairingContext2.f(bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        PairingContext pairingContext = null;
        try {
            DataInputStream dataInputStream = this.f41471f;
            if (dataInputStream == null) {
                f0.S("inputStream");
                dataInputStream = null;
            }
            dataInputStream.close();
        } catch (Throwable unused) {
        }
        try {
            DataOutputStream dataOutputStream = this.f41472g;
            if (dataOutputStream == null) {
                f0.S("outputStream");
                dataOutputStream = null;
            }
            dataOutputStream.close();
        } catch (Throwable unused2) {
        }
        try {
            Socket socket = this.f41470e;
            if (socket == null) {
                f0.S("socket");
                socket = null;
            }
            socket.close();
        } catch (Exception unused3) {
        }
        if (this.f41475j != State.Ready) {
            PairingContext pairingContext2 = this.f41474i;
            if (pairingContext2 == null) {
                f0.S("pairingContext");
            } else {
                pairingContext = pairingContext2;
            }
            pairingContext.c();
        }
    }

    public final boolean d() throws AdbInvalidPairingCodeException, IOException {
        ByteBuffer buf = ByteBuffer.allocate(8192).order(ByteOrder.BIG_ENDIAN);
        PeerInfo peerInfo = this.f41473h;
        f0.o(buf, "buf");
        peerInfo.d(buf);
        PairingContext pairingContext = this.f41474i;
        PairingContext pairingContext2 = null;
        if (pairingContext == null) {
            f0.S("pairingContext");
            pairingContext = null;
        }
        byte[] bArrArray = buf.array();
        f0.o(bArrArray, "buf.array()");
        byte[] bArrD = pairingContext.d(bArrArray);
        if (bArrD == null) {
            return false;
        }
        PairingPacketHeader.Type type = PairingPacketHeader.Type.PEER_INFO;
        k(a(type, bArrD.length), bArrD);
        PairingPacketHeader pairingPacketHeaderF = f();
        if (pairingPacketHeaderF == null || pairingPacketHeaderF.b() != type.getValue()) {
            return false;
        }
        byte[] bArr = new byte[pairingPacketHeaderF.a()];
        DataInputStream dataInputStream = this.f41471f;
        if (dataInputStream == null) {
            f0.S("inputStream");
            dataInputStream = null;
        }
        dataInputStream.readFully(bArr);
        PairingContext pairingContext3 = this.f41474i;
        if (pairingContext3 == null) {
            f0.S("pairingContext");
        } else {
            pairingContext2 = pairingContext3;
        }
        byte[] bArrB = pairingContext2.b(bArr);
        if (bArrB == null) {
            throw new AdbInvalidPairingCodeException();
        }
        if (bArrB.length != 8192) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Got size=");
            sb2.append(bArrB.length);
            sb2.append(" PeerInfo.size=8192");
            return false;
        }
        PeerInfo.a aVar = PeerInfo.f41483c;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB);
        f0.o(byteBufferWrap, "wrap(decrypted)");
        aVar.a(byteBufferWrap).toString();
        return true;
    }

    public final PairingPacketHeader f() throws IOException {
        byte[] bArr = new byte[6];
        DataInputStream dataInputStream = this.f41471f;
        if (dataInputStream == null) {
            f0.S("inputStream");
            dataInputStream = null;
        }
        dataInputStream.readFully(bArr);
        ByteBuffer buffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        PairingPacketHeader.a aVar = PairingPacketHeader.f41479d;
        f0.o(buffer, "buffer");
        return aVar.a(buffer);
    }

    public final void h() throws IOException {
        Socket socket = new Socket(this.f41466a, this.f41467b);
        this.f41470e = socket;
        socket.setTcpNoDelay(true);
        SSLSocketFactory socketFactory = this.f41469d.l().getSocketFactory();
        Socket socket2 = this.f41470e;
        if (socket2 == null) {
            f0.S("socket");
            socket2 = null;
        }
        Socket socketCreateSocket = socketFactory.createSocket(socket2, this.f41466a, this.f41467b, true);
        f0.n(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
        sSLSocket.startHandshake();
        this.f41471f = new DataInputStream(sSLSocket.getInputStream());
        this.f41472g = new DataOutputStream(sSLSocket.getOutputStream());
        byte[] bytes = this.f41468c.getBytes(kotlin.text.d.f38161b);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] keyMaterial = hi.a.a(sSLSocket, h.f41528g, null, 64);
        byte[] bArr = new byte[this.f41468c.length() + keyMaterial.length];
        kotlin.collections.m.f1(bytes, bArr, 0, 0, 0, 14, null);
        f0.o(keyMaterial, "keyMaterial");
        kotlin.collections.m.f1(keyMaterial, bArr, bytes.length, 0, 0, 12, null);
        PairingContext pairingContextA = PairingContext.f41476c.a(bArr);
        if (pairingContextA == null) {
            throw new IllegalStateException("Unable to create PairingContext.".toString());
        }
        this.f41474i = pairingContextA;
    }

    public final boolean i() throws IOException {
        h();
        this.f41475j = State.ExchangingMsgs;
        if (!c()) {
            this.f41475j = State.Stopped;
            return false;
        }
        this.f41475j = State.ExchangingPeerInfo;
        if (d()) {
            this.f41475j = State.Stopped;
            return true;
        }
        this.f41475j = State.Stopped;
        return false;
    }

    public final void k(PairingPacketHeader pairingPacketHeader, byte[] bArr) {
        ByteBuffer buffer = ByteBuffer.allocate(6).order(ByteOrder.BIG_ENDIAN);
        f0.o(buffer, "buffer");
        pairingPacketHeader.e(buffer);
        DataOutputStream dataOutputStream = this.f41472g;
        DataOutputStream dataOutputStream2 = null;
        if (dataOutputStream == null) {
            f0.S("outputStream");
            dataOutputStream = null;
        }
        dataOutputStream.write(buffer.array());
        DataOutputStream dataOutputStream3 = this.f41472g;
        if (dataOutputStream3 == null) {
            f0.S("outputStream");
        } else {
            dataOutputStream2 = dataOutputStream3;
        }
        dataOutputStream2.write(bArr);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("write payload, size=");
        sb2.append(bArr.length);
    }
}
