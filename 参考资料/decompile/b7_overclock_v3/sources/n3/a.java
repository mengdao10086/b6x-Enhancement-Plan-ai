package n3;

import android.os.Handler;
import android.os.Message;
import com.blankj.utilcode.util.u;
import com.flydigi.base.common.n;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f41766e = 6330;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f41767f = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DatagramSocket f41768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f41769b = new byte[256];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41770c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41771d;

    /* JADX INFO: renamed from: n3.a$a, reason: collision with other inner class name */
    public class C0462a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f41772a;

        public C0462a(Handler handler) {
            this.f41772a = handler;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n.a("flydigitestdata DriverQuitWithUDP justConnectThenKill UDP准备连接");
            a.this.d();
            a.this.e();
            a.this.d();
            n.a("flydigitestdata DriverQuitWithUDP justConnectThenKill UDP连接最终失败....");
            Message message = new Message();
            if (a.this.f41771d) {
                message.what = 1;
            } else {
                message.what = 0;
            }
            this.f41772a.sendMessage(message);
        }
    }

    public final void d() {
        n.a("flydigitestdata DriverQuitWithUDP closeIO");
        if (this.f41768a != null) {
            n.a("flydigitestdata DriverQuitWithUDP mDatagramSocket.close()");
            this.f41768a.close();
            this.f41768a = null;
        }
    }

    public final void e() {
        n.a("flydigitestdata DriverQuitWithUDP connectWithUDP");
        if (this.f41770c) {
            return;
        }
        try {
            try {
                g();
                i();
                n.a("flydigitestdata DriverQuitWithUDP connectWithUDP 数据连接断开！！！");
            } catch (Exception e10) {
                e10.printStackTrace();
                n.a("flydigitestdata DriverQuitWithUDP connectWithUDP 数据连接异常断开！！！" + e10.getMessage());
            }
        } finally {
            d();
        }
    }

    public final void f(int i10) {
        if (i10 == 80) {
            byte[] bArr = this.f41769b;
            if ((bArr[0] & 15) == 4) {
                n.a("flydigitestdata DriverQuitWithUDP handleSocketData 获取到驱动版本号:" + u9.b.j(((bArr[12] << 8) & 65280) | (bArr[8] & 255)));
                if (this.f41768a != null) {
                    try {
                        byte[] bArrS = l3.b.s();
                        this.f41768a.send(new DatagramPacket(bArrS, bArrS.length, InetAddress.getByName("localhost"), 6330));
                        n.a("flydigitestdata DriverQuitWithUDP 发送退出指令:" + u.l(bArrS));
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    this.f41771d = true;
                    this.f41770c = true;
                    n.a("flydigitestdata DriverQuitWithUDP 连接并退出最终成功");
                }
            }
        }
    }

    public final void g() throws Exception {
        DatagramSocket datagramSocket = this.f41768a;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f41768a = null;
        }
        n.a("flydigitestdata DriverQuitWithUDP start init");
        DatagramSocket datagramSocket2 = new DatagramSocket(6331, InetAddress.getByName("localhost"));
        this.f41768a = datagramSocket2;
        datagramSocket2.setBroadcast(true);
        this.f41768a.setSoTimeout(5000);
        n.a("flydigitestdata DriverQuitWithUDP end init");
    }

    public synchronized void h(Handler handler) {
        new C0462a(handler).start();
    }

    public final void i() {
        byte[] bArr = this.f41769b;
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        while (true) {
            int i10 = 10;
            while (!this.f41770c) {
                try {
                    this.f41768a.receive(datagramPacket);
                    int length = datagramPacket.getLength();
                    if (length >= 7) {
                        if (this.f41771d) {
                            return;
                        } else {
                            f(length);
                        }
                    } else if (i10 > 0 && i10 - 1 == 0) {
                        n.a("flydigitestdata DriverQuitWithUDP receiveUdpData 连接数据内容异常，重试失败，退出连接！！！");
                        return;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    n.a("flydigitestdata DriverQuitWithUDP receiveUdpData 异常:" + e10.getMessage());
                    return;
                }
            }
            return;
        }
    }
}
