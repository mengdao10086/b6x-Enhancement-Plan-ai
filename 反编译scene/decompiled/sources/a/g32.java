package a;

import android.hardware.Camera;
import android.os.Build;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<String> f6166a = new f32();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h32[] f964a;
    public int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f963a = false;

    public g32() {
        byte b = -1;
        String str = Build.MODEL;
        int iHashCode = str.hashCode();
        if (iHashCode != 2365109) {
            if (iHashCode != 193560386) {
                if (iHashCode == 654956528 && str.equals("Mi 10 Pro")) {
                    b = 2;
                }
            } else if (str.equals("MI CC9 Pro")) {
                b = 1;
            }
        } else if (str.equals("MI 9")) {
            b = 0;
        }
        if (b == 0) {
            this.f964a = new h32[]{new h32(0, "❶"), new h32(2, "❷")};
        } else if (b == 1) {
            this.f964a = new h32[]{new h32(0, "❶"), new h32(2, "❷"), new h32(5, "❹")};
        } else {
            if (b != 2) {
                this.f964a = new h32[]{new h32(0, 1.0d)};
                this.f962a = 0;
                a();
                return;
            }
            this.f964a = new h32[]{new h32(0, "❶")};
        }
        this.f962a = 0;
    }

    public final void a() {
        XposedBridge.log("Scene: 摄像头数量 " + Camera.getNumberOfCameras());
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                XposedBridge.log("Scene [Dump CameraInfo] cameraId: " + i);
            }
        }
    }

    public h32 b() {
        int i = this.b;
        return i > -1 ? this.f964a[i] : this.f964a[this.f962a];
    }

    public int c() {
        int i;
        int length;
        int i2 = this.b;
        if (i2 > -1) {
            i = i2 + 1;
            length = this.f964a.length;
        } else {
            i = this.f962a + 1;
            length = this.f964a.length;
        }
        return i % length;
    }

    public void d() {
        if (this.f963a) {
            this.f963a = false;
        } else {
            e(-1);
        }
    }

    public void e(int i) {
        this.b = i;
        this.f963a = true;
        XposedBridge.log("Scene: 切换摄像头 " + i);
    }
}
