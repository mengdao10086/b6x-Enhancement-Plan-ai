package a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.omarea.Scene;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jq0 extends lq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f6535a = {"始终允许", "仅在使用中允许", "允许访问全部", "允许", "Allow"};
    public String[] b = {"发送通知", "获取已安装的应用", "获取位置信息", "访问设备上的照片", "访问照片和视频", "访问设备上的音乐和视频", "通话状态和移动网络信息", "发现并连接到附近的设备"};
    public final String[] c = {"你喜欢", "推荐", "广告", "还下载", "大家", "猜你", "热门", "同类"};
    public final String[] d = {"Don't", "商店", "安全", "删除", "退出", "取消"};

    public static /* synthetic */ CharSequence h(jq0 jq0Var, String[] strArr, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService, long j, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            z = false;
        }
        return jq0Var.g(strArr, accessibilityNodeInfo, accessibilityService, j2, z);
    }

    public final void f(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        String str;
        f92.d(accessibilityService, "service");
        f92.d(accessibilityEvent, "event");
        if (!Scene.f4798a.b(hz0.f1282a.I(), false) || accessibilityEvent.getSource() == null) {
            return;
        }
        try {
            AccessibilityNodeInfo source = accessibilityEvent.getSource();
            String[] strArr = this.b;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = null;
                    break;
                }
                String str2 = strArr[i];
                f92.c(source.findAccessibilityNodeInfosByText(str2), "view.findAccessibilityNodeInfosByText(text)");
                if (!r4.isEmpty()) {
                    str = str2;
                    break;
                }
                i++;
            }
            if (str != null) {
                String[] strArr2 = this.f6535a;
                f92.c(source, "view");
                CharSequence charSequenceH = h(this, strArr2, source, accessibilityService, 0L, false, 24, null);
                if (charSequenceH != null) {
                    Scene.c.p(Scene.f4798a, "Scene为“" + str + "”请求选择了“" + charSequenceH + (char) 8221, 0, 2, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final CharSequence g(String[] strArr, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService, long j, boolean z) {
        for (String str : strArr) {
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
            if (!(listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty())) {
                int size = listFindAccessibilityNodeInfosByText.size();
                for (int i = 0; i < size; i++) {
                    AccessibilityNodeInfo accessibilityNodeInfo2 = listFindAccessibilityNodeInfosByText.get(i);
                    f92.c(accessibilityNodeInfo2, "nodes[i]");
                    CharSequence text = accessibilityNodeInfo2.getText();
                    f92.b(text);
                    if (!j(text.toString())) {
                        AccessibilityNodeInfo accessibilityNodeInfo3 = listFindAccessibilityNodeInfosByText.get(i);
                        f92.c(accessibilityNodeInfo3, "nodes[i]");
                        AccessibilityNodeInfo accessibilityNodeInfoC = c(accessibilityNodeInfo3);
                        if (accessibilityNodeInfoC != null) {
                            if (!accessibilityNodeInfoC.isEnabled()) {
                                accessibilityNodeInfoC.setEnabled(true);
                            }
                            if ((!z || !i(accessibilityNodeInfo)) && !super.b(accessibilityNodeInfoC)) {
                                super.e(accessibilityNodeInfoC, accessibilityService);
                            }
                            if (j > 0) {
                                try {
                                    Thread.sleep(j);
                                } catch (Exception unused) {
                                }
                            }
                            AccessibilityNodeInfo accessibilityNodeInfo4 = listFindAccessibilityNodeInfosByText.get(i);
                            f92.c(accessibilityNodeInfo4, "nodes[i]");
                            CharSequence text2 = accessibilityNodeInfo4.getText();
                            f92.b(text2);
                            return text2;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final boolean i(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (String str : this.c) {
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
            if (!(listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty())) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(String str) {
        for (String str2 : this.d) {
            if (ec2.C(str, str2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }
}
