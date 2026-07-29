package moe.shizuku.manager.adb;

import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import qk.v;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class PeerInfo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final a f41483c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f41484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final byte[] f41485b;

    public enum Type {
        ADB_RSA_PUB_KEY((byte) 0),
        ADB_DEVICE_GUID((byte) 0);

        private final byte value;

        Type(byte b10) {
            this.value = b10;
        }

        public final byte getValue() {
            return this.value;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final PeerInfo a(@k ByteBuffer buffer) {
            f0.p(buffer, "buffer");
            byte b10 = buffer.get();
            byte[] bArr = new byte[8191];
            buffer.get(bArr);
            return new PeerInfo(b10, bArr);
        }
    }

    public PeerInfo(byte b10, @k byte[] data) {
        f0.p(data, "data");
        this.f41484a = b10;
        byte[] bArr = new byte[8191];
        this.f41485b = bArr;
        m.W0(data, bArr, 0, 0, v.B(data.length, 8191));
    }

    @k
    public final byte[] a() {
        return this.f41485b;
    }

    public final byte b() {
        return this.f41484a;
    }

    @k
    public final String c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("type=");
        sb2.append((int) this.f41484a);
        sb2.append(", data=");
        String string = Arrays.toString(this.f41485b);
        f0.o(string, "toString(this)");
        sb2.append(string);
        return sb2.toString();
    }

    public final void d(@k ByteBuffer buffer) {
        f0.p(buffer, "buffer");
        buffer.put(this.f41484a);
        buffer.put(this.f41485b);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("write PeerInfo ");
        sb2.append(c());
    }

    @k
    public String toString() {
        return "PeerInfo(" + c() + ')';
    }
}
