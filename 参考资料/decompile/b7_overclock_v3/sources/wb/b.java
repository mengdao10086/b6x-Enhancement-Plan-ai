package wb;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f54621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataOutputStream f54622b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f54621a = byteArrayOutputStream;
        this.f54622b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public static void c(DataOutputStream dataOutputStream, long j10) throws IOException {
        dataOutputStream.writeByte(((int) (j10 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j10 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j10 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j10) & 255);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f54621a.reset();
        try {
            b(this.f54622b, eventMessage.f17242a);
            String str = eventMessage.f17243b;
            if (str == null) {
                str = "";
            }
            b(this.f54622b, str);
            c(this.f54622b, eventMessage.f17244c);
            c(this.f54622b, eventMessage.f17245d);
            this.f54622b.write(eventMessage.f17246e);
            this.f54622b.flush();
            return this.f54621a.toByteArray();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
