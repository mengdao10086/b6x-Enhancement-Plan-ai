package a;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalSocket f7659a = new LocalSocket(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataInputStream f3234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataOutputStream f3235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3236a;

    public final void a() {
        try {
            this.f3236a = true;
            this.f7659a.close();
        } catch (Exception unused) {
        }
    }

    public final boolean b() {
        if (!this.f7659a.isConnected()) {
            try {
                this.f7659a.connect(new LocalSocketAddress("Scene", LocalSocketAddress.Namespace.ABSTRACT));
                this.f3235a = new DataOutputStream(new BufferedOutputStream(this.f7659a.getOutputStream()));
                this.f3234a = new DataInputStream(new BufferedInputStream(this.f7659a.getInputStream()));
                this.f3236a = false;
                return c();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final boolean c() {
        return this.f7659a.isConnected() && !this.f3236a;
    }

    public final int d(ByteBuffer byteBuffer) {
        f92.d(byteBuffer, "buffer");
        byte[] bArr = new byte[byteBuffer.capacity()];
        try {
            DataInputStream dataInputStream = this.f3234a;
            if (dataInputStream == null) {
                f92.m("input");
                throw null;
            }
            int i = dataInputStream.read(bArr);
            byteBuffer.put(bArr, 0, i);
            return i;
        } catch (Exception unused) {
            a();
            return -1;
        }
    }

    public final void e(byte[] bArr) {
        f92.d(bArr, "content");
        DataOutputStream dataOutputStream = this.f3235a;
        if (dataOutputStream == null) {
            f92.m("out");
            throw null;
        }
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } catch (Exception unused) {
            dataOutputStream.close();
        }
    }
}
