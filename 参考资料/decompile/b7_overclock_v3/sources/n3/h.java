package n3;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import m9.q;
import o5.m;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Socket f41798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f41799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OutputStream f41800c;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f41810m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f41801d = new byte[128];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f41802e = new byte[33];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f41803f = new byte[14];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f41804g = {"10.0.2.2", "172.17.99.2", "172.16.151.2"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f41805h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f41806i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41807j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f41808k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final GamepadInfo f41809l = new GamepadInfo(m9.h.G);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f41811n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f41812o = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f41813p = new Runnable() { // from class: n3.f
        @Override // java.lang.Runnable
        public final void run() {
            this.f41796a.h();
        }
    };

    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            h.this.e();
        }
    }

    public interface b {
        void a(GamepadInfo gamepadInfo);

        void b(byte[] bArr);

        void c(byte[] bArr);
    }

    public h(b bVar) {
        this.f41810m = bVar;
        n.a("flydigitestdata 准备连接PcTool");
        new a().start();
    }

    public static String g(String str) {
        String hostAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.getName().equals(str)) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!(inetAddressNextElement instanceof Inet6Address) && !"127.0.0.1".equals(inetAddressNextElement.getHostAddress())) {
                                hostAddress = inetAddressNextElement.getHostAddress();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e10) {
            e10.printStackTrace();
        }
        return hostAddress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f41808k = false;
        i(false);
        this.f41809l.setConnectState(0);
        k();
    }

    public void d() {
        this.f41807j = true;
    }

    public final void e() {
        StringBuilder sb2;
        String str;
        int i10 = 2;
        this.f41805h = m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_NAME_SIMULATOR_CONNECTED_IP_ADDRESS, "");
        int i11 = 0;
        int length = 0;
        while (!this.f41807j) {
            n.a("flydigitestdata createPCToolSocket 准备尝试连接");
            try {
                try {
                    if (d1.g(this.f41805h)) {
                        String strG = g("wlan0");
                        if (n0.x(strG)) {
                            str = strG.substring(i11, strG.lastIndexOf(46) + 1) + "2";
                        } else {
                            str = new File("/system/lib/libldutils.so").exists() ? Build.VERSION.SDK_INT >= 25 ? "172.16.1.2" : "172.16.2.2" : v5.c.h() ? "172.17.99.2" : this.f41804g[length];
                        }
                    } else {
                        str = this.f41805h;
                    }
                    String str2 = str;
                    n.a("flydigitestdata createPCToolSocket 尝试连接IP：" + str2);
                    Socket socket = new Socket(str2, 13524);
                    this.f41798a = socket;
                    socket.setSoTimeout(5000);
                    this.f41799b = this.f41798a.getInputStream();
                    this.f41800c = this.f41798a.getOutputStream();
                    n.a("flydigitestdata createPCToolSocket state：" + this.f41798a.isConnected());
                    while (true) {
                        if (!this.f41798a.isConnected() || this.f41807j) {
                            break;
                        }
                        if (!this.f41806i) {
                            this.f41806i = true;
                            m.l(DataConstant.SP_FLOAT, i10).C(DataConstant.SP_NAME_SIMULATOR_CONNECTED_IP_ADDRESS, str2, true);
                        }
                        try {
                        } catch (IOException e10) {
                            e10.printStackTrace();
                            n.a("flydigitestdata createPCToolSocket readError:" + e10.getMessage());
                            i10 = 2;
                        }
                        if (this.f41799b.read(this.f41801d) < 0) {
                            n.a("flydigitestdata createPCToolSocket 连接异常");
                            break;
                        }
                        j(this.f41801d);
                    }
                    InputStream inputStream = this.f41799b;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            n.a("flydigitestdata createPCToolSocket mInputStream close");
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            n.a("flydigitestdata createPCToolSocket mInputStream Err:" + e11.getMessage());
                        }
                    }
                    OutputStream outputStream = this.f41800c;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            n.a("flydigitestdata createPCToolSocket mOutputStream close");
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            n.a("flydigitestdata createPCToolSocket mOutputStream Err:" + e12.getMessage());
                        }
                    }
                    Socket socket2 = this.f41798a;
                    if (socket2 != null) {
                        try {
                            socket2.close();
                            n.a("flydigitestdata createPCToolSocket mSocket close");
                        } catch (IOException e13) {
                            e = e13;
                            e.printStackTrace();
                            sb2 = new StringBuilder();
                            sb2.append("flydigitestdata createPCToolSocket mSocket Err:");
                            sb2.append(e.getMessage());
                            n.a(sb2.toString());
                        }
                    }
                } finally {
                }
            } catch (IOException e14) {
                e14.printStackTrace();
                n.a("flydigitestdata createPCToolSocket error:" + e14.getMessage());
                InputStream inputStream2 = this.f41799b;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        n.a("flydigitestdata createPCToolSocket mInputStream close");
                    } catch (IOException e15) {
                        e15.printStackTrace();
                        n.a("flydigitestdata createPCToolSocket mInputStream Err:" + e15.getMessage());
                    }
                }
                OutputStream outputStream2 = this.f41800c;
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                        n.a("flydigitestdata createPCToolSocket mOutputStream close");
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        n.a("flydigitestdata createPCToolSocket mOutputStream Err:" + e16.getMessage());
                    }
                }
                Socket socket3 = this.f41798a;
                if (socket3 != null) {
                    try {
                        socket3.close();
                        n.a("flydigitestdata createPCToolSocket mSocket close");
                    } catch (IOException e17) {
                        e = e17;
                        e.printStackTrace();
                        sb2 = new StringBuilder();
                        sb2.append("flydigitestdata createPCToolSocket mSocket Err:");
                        sb2.append(e.getMessage());
                        n.a(sb2.toString());
                    }
                }
            }
            this.f41805h = "";
            length = (length + 1) % this.f41804g.length;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e18) {
                e18.printStackTrace();
            }
            i10 = 2;
            i11 = 0;
        }
    }

    public final byte[] f(byte[] bArr) {
        byte[] bArr2 = this.f41803f;
        bArr2[0] = bArr[18];
        bArr2[1] = bArr[20];
        bArr2[2] = bArr[22];
        bArr2[3] = bArr[23];
        bArr2[4] = bArr[10];
        bArr2[5] = bArr[11];
        bArr2[6] = bArr[24];
        bArr2[7] = bArr[25];
        bArr2[8] = bArr[9];
        bArr2[9] = bArr[8];
        bArr2[11] = bArr[5];
        bArr2[12] = bArr[6];
        bArr2[13] = bArr[7];
        return bArr2;
    }

    public final void i(boolean z10) {
        byte[] bArr = this.f41802e;
        bArr[0] = 67;
        bArr[1] = z10 ? (byte) 1 : (byte) 0;
        bArr[2] = 10;
        bArr[3] = 0;
        l(bArr);
    }

    public final void j(byte[] bArr) {
        this.f41812o.removeCallbacks(this.f41813p);
        this.f41812o.postDelayed(this.f41813p, 2000L);
        if (!this.f41808k) {
            this.f41808k = true;
            this.f41809l.setConnectState(2);
            i(this.f41808k);
            q.A(this.f41809l, (byte) 0, 0, 1);
            this.f41812o.removeCallbacks(new Runnable() { // from class: n3.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41797a.k();
                }
            });
            this.f41812o.postDelayed(new Runnable() { // from class: n3.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41797a.k();
                }
            }, 250L);
        }
        if ((bArr[15] & 255) == 236 && (bArr[3] & 255) != 0) {
            q.A(this.f41809l, bArr[3], bArr[12], bArr[14]);
            this.f41809l.setAddress(ft.c.q(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}, "", ":"));
            byte b10 = bArr[9];
            byte b11 = bArr[10];
            int i10 = b11 & 15;
            int i11 = b11 >> 4;
            this.f41809l.setFirmwareVersion(i11 + j3.b.f36044h + i10 + j3.b.f36044h + (b10 >> 4) + j3.b.f36044h + (b10 & 15));
            this.f41809l.setBattery(bArr[11]);
            this.f41812o.removeCallbacks(new Runnable() { // from class: n3.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41797a.k();
                }
            });
            k();
        }
        if ((bArr[0] & 255) == 5 && (bArr[1] & 255) == 254) {
            byte[] bArr2 = this.f41802e;
            bArr2[0] = 67;
            bArr2[1] = 0;
            bArr2[2] = 10;
            bArr2[3] = 0;
        } else {
            byte[] bArr3 = this.f41802e;
            bArr3[0] = 65;
            System.arraycopy(bArr, 0, bArr3, 1, 32);
        }
        l(this.f41802e);
    }

    public final void k() {
        b bVar = this.f41810m;
        if (bVar != null) {
            bVar.a(this.f41809l);
        }
    }

    public final void l(byte[] bArr) {
        b bVar = this.f41810m;
        if (bVar != null) {
            bVar.c(bArr);
            this.f41810m.b(f(bArr));
        }
    }
}
