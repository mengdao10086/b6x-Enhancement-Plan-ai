package n3;

import android.content.Context;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class i extends d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f41815r = 6330;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DatagramSocket f41816o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DatagramPacket f41817p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public InetAddress f41818q;

    public i(Context context) {
        super(context);
    }

    public final void N() {
        while (!this.f41783f) {
            try {
                try {
                    O();
                    h();
                    P();
                } catch (Exception e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("connectWithUDP 数据连接异常断开");
                    sb2.append(e10.getMessage());
                }
            } finally {
                d();
            }
        }
    }

    public final void O() throws Exception {
        DatagramSocket datagramSocket = this.f41816o;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f41816o = null;
        }
        try {
            this.f41818q = InetAddress.getByName("localhost");
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
        }
        DatagramSocket datagramSocket2 = new DatagramSocket(6331, this.f41818q);
        this.f41816o = datagramSocket2;
        datagramSocket2.setBroadcast(true);
        this.f41816o.setSoTimeout(3300);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r5.f41783f != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        J("重试次数用完了");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P() {
        /*
            r5 = this;
            java.net.DatagramPacket r0 = new java.net.DatagramPacket
            byte[] r1 = r5.f41780c
            int r2 = r1.length
            r0.<init>(r1, r2)
            r1 = 10
        La:
            r2 = 10
        Lc:
            boolean r3 = r5.f41783f
            if (r3 != 0) goto L5e
            java.net.DatagramSocket r3 = r5.f41816o     // Catch: java.lang.Exception -> L30
            r3.receive(r0)     // Catch: java.lang.Exception -> L30
            int r3 = r0.getLength()     // Catch: java.lang.Exception -> L30
            r4 = 7
            if (r3 < r4) goto L20
            r5.m(r3)     // Catch: java.lang.Exception -> L30
            goto La
        L20:
            if (r2 <= 0) goto Lc
            int r2 = r2 + (-1)
            if (r2 != 0) goto Lc
            boolean r0 = r5.f41783f     // Catch: java.lang.Exception -> L30
            if (r0 != 0) goto L5e
            java.lang.String r0 = "重试次数用完了"
            r5.J(r0)     // Catch: java.lang.Exception -> L30
            goto L5e
        L30:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "receiveUdpData异常:"
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            boolean r1 = r5.f41783f
            if (r1 != 0) goto L4d
            java.lang.String r0 = r0.getMessage()
            r5.J(r0)
        L4d:
            boolean r0 = r5.f41787j
            if (r0 == 0) goto L5e
            r0 = 0
            r5.f41787j = r0
            r1 = -1
            r5.f41788k = r1
            n3.d$c r1 = r5.f41786i
            if (r1 == 0) goto L5e
            r1.o(r0, r0)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.i.P():void");
    }

    public final void Q(byte[] bArr) {
        if (this.f41816o == null) {
            return;
        }
        try {
            DatagramPacket datagramPacket = this.f41817p;
            if (datagramPacket == null) {
                this.f41817p = new DatagramPacket(bArr, bArr.length, this.f41818q, 6330);
            } else {
                datagramPacket.setData(bArr);
                this.f41817p.setLength(bArr.length);
            }
            this.f41816o.send(this.f41817p);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // n3.d
    public void d() {
        super.d();
        DatagramSocket datagramSocket = this.f41816o;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f41816o = null;
        }
    }

    @Override // n3.d
    public void f(byte[] bArr) {
        Q(bArr);
    }

    @Override // n3.d
    public void g() {
        if (this.f41783f) {
            return;
        }
        N();
    }
}
