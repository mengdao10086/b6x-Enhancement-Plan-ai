package n3;

import android.content.Context;
import com.blankj.utilcode.util.r;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import n3.d;
import n3.h;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Socket f41791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OutputStream f41792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public InputStream f41793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f41794r;

    public class a implements h.b {
        public a() {
        }

        @Override // n3.h.b
        public void a(GamepadInfo gamepadInfo) {
            d.c cVar = e.this.f41786i;
            if (cVar != null) {
                cVar.a(gamepadInfo);
            }
            e.this.y();
        }

        @Override // n3.h.b
        public void b(byte[] bArr) {
            d.c cVar = e.this.f41786i;
            if (cVar != null) {
                cVar.x(bArr);
            }
        }

        @Override // n3.h.b
        public void c(byte[] bArr) {
            e.this.M(bArr);
        }
    }

    public e(Context context) {
        super(context);
    }

    public final void N() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connectWithTcpip1 mDeviceConnected:");
        sb2.append(n());
        try {
            try {
                Socket socket = this.f41791o;
                if (socket != null && !socket.isClosed()) {
                    r.a(this.f41791o);
                }
                Socket socket2 = new Socket("localhost", 6330);
                this.f41791o = socket2;
                this.f41792p = socket2.getOutputStream();
                this.f41793q = this.f41791o.getInputStream();
                h();
                P();
            } catch (IOException e10) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("connectWithTcpip1 数据连接异常断开！！！");
                sb3.append(e10.getMessage());
            }
        } finally {
            d();
        }
    }

    public final void O() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connectWithTcpip2 mDeviceConnected:");
        sb2.append(n());
        try {
            try {
                Socket socket = this.f41791o;
                if (socket != null && !socket.isClosed()) {
                    r.a(this.f41791o);
                }
                Socket socket2 = new Socket("localhost", 6331);
                this.f41791o = socket2;
                this.f41792p = socket2.getOutputStream();
                this.f41793q = this.f41791o.getInputStream();
                h();
                P();
            } catch (IOException e10) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("connectWithTcpip2 数据连接异常断开！！！");
                sb3.append(e10.getMessage());
            }
        } finally {
            d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (r4.f41783f != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        J("重试次数用完了");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
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
            r4 = this;
            r0 = 10
        L2:
            r1 = 10
        L4:
            boolean r2 = r4.f41783f
            if (r2 != 0) goto L56
            java.io.InputStream r2 = r4.f41793q
            if (r2 == 0) goto L56
            byte[] r3 = r4.f41780c     // Catch: java.lang.Exception -> L29
            int r2 = r2.read(r3)     // Catch: java.lang.Exception -> L29
            r3 = 7
            if (r2 < r3) goto L19
            r4.m(r2)     // Catch: java.lang.Exception -> L29
            goto L2
        L19:
            if (r1 <= 0) goto L4
            int r1 = r1 + (-1)
            if (r1 != 0) goto L4
            boolean r0 = r4.f41783f     // Catch: java.lang.Exception -> L29
            if (r0 != 0) goto L56
            java.lang.String r0 = "重试次数用完了"
            r4.J(r0)     // Catch: java.lang.Exception -> L29
            goto L56
        L29:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "receiveTcpipData 异常:"
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            boolean r1 = r4.f41783f
            if (r1 != 0) goto L49
            java.lang.String r0 = r0.getMessage()
            r4.J(r0)
        L49:
            r0 = 0
            r4.f41787j = r0
            r1 = -1
            r4.f41788k = r1
            n3.d$c r1 = r4.f41786i
            if (r1 == 0) goto L56
            r1.o(r0, r0)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.P():void");
    }

    public final void Q(byte[] bArr) {
        OutputStream outputStream = this.f41792p;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, 0, bArr.length);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // n3.d
    public void d() {
        super.d();
        try {
            r.a(this.f41792p, this.f41793q);
            Socket socket = this.f41791o;
            if (socket != null) {
                socket.close();
                this.f41791o = null;
            }
            h hVar = this.f41794r;
            if (hVar != null) {
                hVar.d();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    @Override // n3.d
    public void f(byte[] bArr) {
        Q(bArr);
    }

    @Override // n3.d
    public void g() {
        while (!this.f41783f) {
            N();
            if (!this.f41783f) {
                O();
            }
            if (!this.f41783f) {
                b.a();
                if (!this.f41783f) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // n3.d
    public void m(int i10) {
        if (this.f41794r == null) {
            this.f41794r = new h(new a());
        }
        super.m(i10);
    }
}
