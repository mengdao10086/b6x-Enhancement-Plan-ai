package e6;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.s0;
import com.flydigi.api.download.DownloadHelper;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.R;
import com.flydigi.data.bean.CloudConfigBean;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.EntitySimpleConfig;
import com.flydigi.data.bean.RecommendConfigBean;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateList;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import m5.f0;
import org.json.JSONException;
import org.json.JSONObject;
import xi.c0;
import xi.e0;
import xi.g0;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26694a = "ConfigManager";

    public class a extends TypeToken<CFGEntityList> {
    }

    public class b extends TypeToken<CFGEntityList> {
    }

    public class c extends TypeToken<CFGEntity> {
    }

    public class d implements g0<File> {
        @Override // xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(File file) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("配置已写入：");
            sb2.append(file.getAbsolutePath());
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(Throwable throwable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("配置写入失败：");
            sb2.append(throwable.getMessage());
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b d10) {
        }
    }

    public static CFGEntity A(CFGEntity cfgEntityGp) {
        CFGEntity cFGEntity = new CFGEntity();
        cFGEntity.title = cfgEntityGp.title;
        cFGEntity.setDefault(true);
        ArrayList arrayList = new ArrayList(cfgEntityGp.keyList);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((CFGPropertyKey) arrayList.get(i10)).key_id = com.flydigi.sdk.gamepad.extension.a.e(((CFGPropertyKey) arrayList.get(i10)).key_id);
            ((CFGPropertyKey) arrayList.get(i10)).key = com.flydigi.sdk.gamepad.extension.a.i(((CFGPropertyKey) arrayList.get(i10)).key_id, 1);
            boolean z10 = ((CFGPropertyKey) arrayList.get(i10)).type == 1;
            boolean z11 = ((CFGPropertyKey) arrayList.get(i10)).sub_type == 3;
            boolean z12 = ((CFGPropertyKey) arrayList.get(i10)).sub_type == 2;
            boolean z13 = ((CFGPropertyKey) arrayList.get(i10)).type == 7;
            boolean z14 = ((CFGPropertyKey) arrayList.get(i10)).type == 5;
            boolean z15 = ((CFGPropertyKey) arrayList.get(i10)).type == 6;
            boolean z16 = ((CFGPropertyKey) arrayList.get(i10)).type == 8;
            boolean z17 = ((CFGPropertyKey) arrayList.get(i10)).type == 10;
            boolean z18 = ((CFGPropertyKey) arrayList.get(i10)).type == 3;
            if ((z10 && (z11 || z12)) || z13 || z14 || z15 || z16 || z18 || z17) {
                ((CFGPropertyKey) arrayList.get(i10)).type = 1;
                ((CFGPropertyKey) arrayList.get(i10)).sub_type = 0;
                ((CFGPropertyKey) arrayList.get(i10)).show = 1;
                ((CFGPropertyKey) arrayList.get(i10)).senty_x = -1;
                ((CFGPropertyKey) arrayList.get(i10)).senty_y = -1;
                ((CFGPropertyKey) arrayList.get(i10)).click_times = -1;
                ((CFGPropertyKey) arrayList.get(i10)).angle = -1;
                ((CFGPropertyKey) arrayList.get(i10)).range = -1;
                ((CFGPropertyKey) arrayList.get(i10)).duration = -1;
                ((CFGPropertyKey) arrayList.get(i10)).js_link = -1;
                ((CFGPropertyKey) arrayList.get(i10)).radius = -1;
            }
        }
        cFGEntity.keyList.addAll(arrayList);
        CFGPropertyJS cFGPropertyJS = new CFGPropertyJS();
        cFGPropertyJS.key_id = 240;
        cFGPropertyJS.key = "WASD";
        cFGPropertyJS.type = 1;
        cFGPropertyJS.radius = 64;
        cFGPropertyJS.f16345x = 0.2f;
        cFGPropertyJS.f16346y = 0.7f;
        cFGEntity.jsList.add(cFGPropertyJS);
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.key_id = 116;
        cFGPropertyKey.key = "MOUSE";
        cFGPropertyKey.f16347x = 0.8f;
        cFGPropertyKey.f16348y = 0.2f;
        cFGPropertyKey.senty_x = 50;
        cFGPropertyKey.senty_y = 25;
        cFGPropertyKey.type = 3;
        cFGPropertyKey.show = 0;
        cFGEntity.keyList.add(cFGPropertyKey);
        return cFGEntity;
    }

    public static CFGEntity B(int deviceMode) {
        CFGEntity cFGEntityD = deviceMode != 0 ? deviceMode != 1 ? deviceMode != 2 ? null : D() : A(C()) : C();
        if (cFGEntityD == null) {
            cFGEntityD = new CFGEntity();
        }
        cFGEntityD.setInUse(true);
        cFGEntityD.setDefault(true);
        return cFGEntityD;
    }

    public static CFGEntity C() {
        CFGEntity cFGEntity = new CFGEntity();
        cFGEntity.title = j1.a().getString(R.string.str_lib_text_266);
        cFGEntity.setDefault(true);
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 1;
        cFGPropertyKey.key_id = 4;
        cFGPropertyKey.key = i1.a.W4;
        cFGPropertyKey.sub_type = 0;
        cFGPropertyKey.show = 1;
        cFGPropertyKey.f16347x = 0.7f;
        cFGPropertyKey.f16348y = 0.8f;
        cFGEntity.keyList.add(cFGPropertyKey);
        CFGPropertyKey cFGPropertyKey2 = new CFGPropertyKey();
        cFGPropertyKey2.type = 1;
        cFGPropertyKey2.key_id = 5;
        cFGPropertyKey2.key = "B";
        cFGPropertyKey2.sub_type = 0;
        cFGPropertyKey2.show = 1;
        cFGPropertyKey2.f16347x = 0.75f;
        cFGPropertyKey2.f16348y = 0.7f;
        cFGEntity.keyList.add(cFGPropertyKey2);
        CFGPropertyKey cFGPropertyKey3 = new CFGPropertyKey();
        cFGPropertyKey3.type = 1;
        cFGPropertyKey3.key_id = 7;
        cFGPropertyKey3.key = "X";
        cFGPropertyKey3.sub_type = 0;
        cFGPropertyKey3.show = 1;
        cFGPropertyKey3.f16347x = 0.65f;
        cFGPropertyKey3.f16348y = 0.7f;
        cFGEntity.keyList.add(cFGPropertyKey3);
        CFGPropertyKey cFGPropertyKey4 = new CFGPropertyKey();
        cFGPropertyKey4.type = 1;
        cFGPropertyKey4.key_id = 8;
        cFGPropertyKey4.key = "Y";
        cFGPropertyKey4.sub_type = 0;
        cFGPropertyKey4.show = 1;
        cFGPropertyKey4.f16347x = 0.7f;
        cFGPropertyKey4.f16348y = 0.6f;
        cFGEntity.keyList.add(cFGPropertyKey4);
        CFGPropertyJS cFGPropertyJS = new CFGPropertyJS();
        cFGPropertyJS.key_id = 240;
        cFGPropertyJS.key = "JSLEFT";
        cFGPropertyJS.type = 1;
        cFGPropertyJS.radius = 64;
        cFGPropertyJS.f16345x = 0.2f;
        cFGPropertyJS.f16346y = 0.7f;
        cFGEntity.jsList.add(cFGPropertyJS);
        return cFGEntity;
    }

    public static CFGEntity D() {
        CFGEntity cFGEntity = new CFGEntity();
        cFGEntity.title = j1.a().getString(R.string.str_lib_text_266);
        cFGEntity.setDefault(true);
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 1;
        cFGPropertyKey.key_id = 12;
        cFGPropertyKey.key = "LT";
        cFGPropertyKey.sub_type = 0;
        cFGPropertyKey.show = 1;
        cFGPropertyKey.f16347x = 0.7f;
        cFGPropertyKey.f16348y = 0.7f;
        cFGEntity.keyList.add(cFGPropertyKey);
        CFGPropertyKey cFGPropertyKey2 = new CFGPropertyKey();
        cFGPropertyKey2.type = 1;
        cFGPropertyKey2.key_id = 10;
        cFGPropertyKey2.key = ze.k.f58516r;
        cFGPropertyKey2.sub_type = 0;
        cFGPropertyKey2.show = 1;
        cFGPropertyKey2.f16347x = 0.8f;
        cFGPropertyKey2.f16348y = 0.7f;
        cFGEntity.keyList.add(cFGPropertyKey2);
        CFGPropertyJS cFGPropertyJS = new CFGPropertyJS();
        cFGPropertyJS.key_id = 240;
        cFGPropertyJS.key = "JSLEFT";
        cFGPropertyJS.type = 1;
        cFGPropertyJS.radius = 64;
        cFGPropertyJS.f16345x = 0.2f;
        cFGPropertyJS.f16346y = 0.7f;
        cFGEntity.jsList.add(cFGPropertyJS);
        return cFGEntity;
    }

    public static void E(String packageName) {
        File file = new File(e6.a.f26664f);
        b0.k(file);
        File file2 = new File(file, packageName + e6.a.f26665g);
        if (file2.exists()) {
            b0.o(file2);
        }
        if (Build.VERSION.SDK_INT < 30) {
            File file3 = new File(new File(e6.a.f26663e), packageName + e6.a.f26665g);
            if (file3.exists()) {
                b0.o(file3);
            }
        }
    }

    public static xi.z<File> F(String url) {
        return new DownloadHelper("https://api.flydigi.com/", new com.flydigi.api.download.d() { // from class: e6.b
            @Override // com.flydigi.api.download.d
            public final void a(long j10, long j11, boolean z10) {
                z.K(j10, j11, z10);
            }
        }).c(DataConstant.CONFIG_FOLDER, url, null);
    }

    public static CFGEntityList G(String fileContent) {
        CFGEntityList cFGEntityList = (CFGEntityList) f0.i().h().fromJson(fileContent, new a().getType());
        if (cFGEntityList == null) {
            cFGEntityList = new CFGEntityList();
        }
        z0(cFGEntityList.getConfigsForWholeGamepad(), 0);
        z0(cFGEntityList.getConfigsForKeyboard(), 1);
        z0(cFGEntityList.getConfigsForHalfGamepad(), 2);
        return cFGEntityList;
    }

    public static List<CFGEntity> H(CFGEntityList cfgEntityList, int deviceMode) {
        ArrayList arrayList = new ArrayList();
        return deviceMode == 0 ? cfgEntityList.getConfigsForWholeGamepad().size() > 0 ? cfgEntityList.getConfigsForWholeGamepad() : arrayList : deviceMode == 1 ? cfgEntityList.getConfigsForKeyboard().size() > 0 ? cfgEntityList.getConfigsForKeyboard() : arrayList : (deviceMode != 2 || cfgEntityList.getConfigsForHalfGamepad().size() <= 0) ? arrayList : cfgEntityList.getConfigsForHalfGamepad();
    }

    public static List<String> I() {
        ArrayList arrayList = new ArrayList();
        File file = new File(e6.a.f26664f);
        return (file.exists() && file.isDirectory() && file.canRead()) ? Arrays.asList(file.list(new FilenameFilter() { // from class: e6.p
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                return z.L(file2, str);
            }
        })) : arrayList;
    }

    public static CFGEntity J(CFGEntityList cfgEntityList, GamepadInfo deviceInfo) {
        List<CFGEntity> listH = H(cfgEntityList, deviceInfo.getDeviceMode());
        CFGEntity cFGEntity = null;
        if (!listH.isEmpty()) {
            Iterator<CFGEntity> it2 = listH.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CFGEntity next = it2.next();
                if (next.isForCurrentDevice(deviceInfo.getDeviceCode())) {
                    if (cFGEntity == null) {
                        cFGEntity = next;
                    }
                    if (next.isInUse()) {
                        cFGEntity = next;
                        break;
                    }
                }
            }
        }
        if (cFGEntity == null) {
            cFGEntity = (listH.isEmpty() || !listH.get(0).isTest()) ? new CFGEntity() : listH.get(0);
        }
        cFGEntity.setInUse(true);
        return cFGEntity;
    }

    public static /* synthetic */ void K(long j10, long j11, boolean z10) {
    }

    public static /* synthetic */ boolean L(File file, String str) {
        return str.endsWith(e6.a.f26665g);
    }

    public static /* synthetic */ boolean M(File file) {
        return file.getAbsolutePath().endsWith(e6.a.f26665g);
    }

    public static /* synthetic */ void N(String str, String str2, xi.b0 b0Var) throws Exception {
        b0Var.onNext(l0(str, str2));
        b0Var.onComplete();
    }

    public static /* synthetic */ boolean O(String str, File file, String str2) {
        return str2.contains(str) && str2.contains(e6.a.f26666h);
    }

    public static /* synthetic */ e0 P(final String str, String str2) throws Exception {
        File[] fileArrListFiles;
        File file = new File(e6.a.f26664f);
        b0.k(file);
        File file2 = (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: e6.o
            @Override // java.io.FilenameFilter
            public final boolean accept(File file3, String str3) {
                return z.O(str, file3, str3);
            }
        })) == null || fileArrListFiles.length <= 0) ? null : fileArrListFiles[0];
        RecommendConfigBean recommendConfigBean = file2 != null ? (RecommendConfigBean) f0.i().h().fromJson(a0.q(file2), RecommendConfigBean.class) : null;
        if (recommendConfigBean == null) {
            recommendConfigBean = new RecommendConfigBean();
        }
        return xi.z.m3(recommendConfigBean);
    }

    public static /* synthetic */ String Q(String str, String str2) throws Exception {
        return e6.a.f26664f + fh.a.f28350w + str + e6.a.f26667i;
    }

    public static /* synthetic */ void R(File file) throws Exception {
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException(file.getName() + " is not exist");
    }

    public static /* synthetic */ CFGVibrateList S(String str) throws Exception {
        return (CFGVibrateList) com.blankj.utilcode.util.e0.h(str, CFGVibrateList.class);
    }

    public static /* synthetic */ void T(int i10, List list, CFGEntityList cFGEntityList) throws Exception {
        if (i10 == 0) {
            cFGEntityList.setConfigsForWholeGamepad(list);
        } else if (i10 == 1) {
            cFGEntityList.setConfigsForKeyboard(list);
        } else {
            if (i10 != 2) {
                return;
            }
            cFGEntityList.setConfigsForHalfGamepad(list);
        }
    }

    public static /* synthetic */ void V(Throwable th2) throws Exception {
    }

    public static /* synthetic */ File W(String str) throws Exception {
        File file = new File(e6.a.f26664f);
        b0.k(file);
        File file2 = new File(file, str + e6.a.f26665g);
        b0.m(file2);
        return file2;
    }

    public static /* synthetic */ e0 X(String str, Throwable th2) throws Exception {
        File file = new File(e6.a.f26664f);
        b0.k(file);
        File file2 = new File(file, str + e6.a.f26665g);
        b0.m(file2);
        return xi.z.m3(file2);
    }

    public static /* synthetic */ void Y(CFGEntityList cFGEntityList, File file) throws Exception {
        String json = f0.i().h().toJson(cFGEntityList);
        okio.k kVarD = okio.f0.d(okio.f0.n(file));
        kVarD.H0(json);
        kVarD.flush();
        kVarD.close();
    }

    public static /* synthetic */ e0 Z(RecommendConfigBean recommendConfigBean, String str) throws Exception {
        File file = new File(e6.a.f26664f);
        b0.k(file);
        a0.T(new File(file, str + e6.a.f26666h), f0.i().h().toJson(recommendConfigBean));
        return xi.z.m3(recommendConfigBean);
    }

    public static /* synthetic */ String a0(String str, String str2) throws Exception {
        return e6.a.f26664f + fh.a.f28350w + str + e6.a.f26667i;
    }

    public static /* synthetic */ CFGVibrateList b0(String str) throws Exception {
        CFGVibrateList cFGVibrateList = (CFGVibrateList) com.blankj.utilcode.util.e0.h(str, CFGVibrateList.class);
        return cFGVibrateList == null ? new CFGVibrateList() : cFGVibrateList;
    }

    public static /* synthetic */ void c0(CFGVibrateBean cFGVibrateBean, CFGVibrateList cFGVibrateList) throws Exception {
        cFGVibrateList.getConfigs().clear();
        cFGVibrateList.getConfigs().add(cFGVibrateBean);
    }

    public static /* synthetic */ void d0(String str, CFGVibrateList cFGVibrateList) throws Exception {
        File file = new File(e6.a.f26664f + fh.a.f28350w + str + e6.a.f26667i);
        b0.m(file);
        a0.T(file, com.blankj.utilcode.util.e0.v(cFGVibrateList));
    }

    public static File e0(ConfigBean config) {
        if (config == null || config.getCfgEntity() == null) {
            return null;
        }
        File file = new File(j1.a().getCacheDir(), String.format(Locale.CHINA, "%s_%d_.fdg", a5.f.i().l(), Long.valueOf(System.nanoTime())));
        CFGEntityList cFGEntityList = new CFGEntityList();
        if (config.getDeviceType() == 2) {
            cFGEntityList.getConfigsForHalfGamepad().add(config.getCfgEntity());
        } else if (config.getDeviceType() == 1) {
            cFGEntityList.getConfigsForKeyboard().add(config.getCfgEntity());
        } else {
            cFGEntityList.getConfigsForWholeGamepad().add(config.getCfgEntity());
        }
        a0.T(file, f0.i().h().toJson(cFGEntityList));
        return file;
    }

    public static File f0(EntitySimpleConfig config) throws IOException {
        File file = new File(j1.a().getCacheDir(), String.format(Locale.CHINA, "%s_%d_.fdg", a5.f.i().l(), Long.valueOf(System.nanoTime())));
        CFGEntityList cFGEntityList = new CFGEntityList();
        config.getCfgEntity().setInUse(false);
        if (config.getVersion() == 1) {
            cFGEntityList.getConfigsForWholeGamepad().add(config.getCfgEntity());
        } else if (config.getVersion() == 3) {
            cFGEntityList.getConfigsForHalfGamepad().add(config.getCfgEntity());
        } else if (config.getVersion() == 2) {
            cFGEntityList.getConfigsForKeyboard().add(config.getCfgEntity());
        }
        a0.T(file, f0.i().h().toJson(cFGEntityList));
        return file;
    }

    public static e0<File> g0(String packageName, CFGEntityList cfgEntityList, CFGEntityList newCfgEntityList, boolean forceReplace) {
        if (!newCfgEntityList.getConfigsForWholeGamepad().isEmpty()) {
            h0(cfgEntityList.getConfigsForWholeGamepad(), newCfgEntityList.getConfigsForWholeGamepad(), forceReplace);
        }
        if (!newCfgEntityList.getConfigsForKeyboard().isEmpty()) {
            h0(cfgEntityList.getConfigsForKeyboard(), newCfgEntityList.getConfigsForKeyboard(), forceReplace);
        }
        if (!newCfgEntityList.getConfigsForHalfGamepad().isEmpty()) {
            h0(cfgEntityList.getConfigsForHalfGamepad(), newCfgEntityList.getConfigsForHalfGamepad(), forceReplace);
        }
        return w0(cfgEntityList, packageName);
    }

    public static void h0(List<CFGEntity> oldConfigList, List<CFGEntity> newConfigList, boolean forceReplace) {
        boolean z10;
        for (CFGEntity cFGEntity : newConfigList) {
            int i10 = 0;
            while (true) {
                if (i10 >= oldConfigList.size()) {
                    z10 = false;
                    break;
                }
                CFGEntity cFGEntity2 = oldConfigList.get(i10);
                if (n0.b(cFGEntity2.getTitle(), cFGEntity.getTitle())) {
                    if (forceReplace) {
                        cFGEntity2.setJsList(cFGEntity.getJsList());
                        cFGEntity2.setKeyList(cFGEntity.getKeyList());
                        cFGEntity2.setMarcoList(cFGEntity.getMarcoList());
                    }
                    z10 = true;
                } else {
                    i10++;
                }
            }
            if (!z10) {
                cFGEntity.setInTop(false);
                cFGEntity.setInUse(false);
                oldConfigList.add(cFGEntity);
            }
        }
    }

    public static void i0() {
        try {
            for (File file : b0.y0(e6.a.f26663e, new FileFilter() { // from class: e6.n
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return z.M(file2);
                }
            })) {
                File file2 = new File(e6.a.f26664f, b0.R(file));
                if (!file2.exists() || file.lastModified() > file2.lastModified()) {
                    a0.T(file2, a0.r(file, e6.a.f26660b));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static CFGEntity j0(File file, boolean validateModify, int deviceMode) throws JSONException, IOException {
        CFGEntity cFGEntity;
        okio.l lVarE = okio.f0.e(okio.f0.t(file));
        String strY1 = lVarE.y1();
        JSONObject jSONObject = new JSONObject(strY1);
        if (!validateModify || jSONObject.has("gamepad_list") || jSONObject.has("keyboard_mouse_list") || jSONObject.has("v1_list")) {
            CFGEntityList cFGEntityList = (CFGEntityList) f0.i().h().fromJson(strY1, new b().getType());
            z0(cFGEntityList.getConfigsForWholeGamepad(), 0);
            z0(cFGEntityList.getConfigsForKeyboard(), 1);
            z0(cFGEntityList.getConfigsForHalfGamepad(), 2);
            cFGEntity = n0.z(cFGEntityList.getConfigsForWholeGamepad()) ? cFGEntityList.getConfigsForWholeGamepad().get(0) : n0.z(cFGEntityList.getConfigsForHalfGamepad()) ? cFGEntityList.getConfigsForHalfGamepad().get(0) : cFGEntityList.getConfigsForKeyboard().get(0);
        } else {
            cFGEntity = (CFGEntity) f0.i().h().fromJson(strY1, new c().getType());
            z0(Collections.singletonList(cFGEntity), deviceMode);
        }
        lVarE.close();
        return cFGEntity;
    }

    public static CFGEntityList k0(File file, String encoding) {
        if (file == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("从");
        sb2.append(file.getAbsolutePath());
        sb2.append("读取配置");
        return G(a0.r(file, encoding));
    }

    public static CFGEntityList l0(String localPackageName, String standardPackageName) {
        File file = new File(e6.a.f26664f);
        b0.k(file);
        File file2 = new File(file, standardPackageName + e6.a.f26665g);
        CFGEntityList cFGEntityListK0 = file2.exists() ? k0(file2, "utf-8") : null;
        if (!n0.b(localPackageName, standardPackageName)) {
            File file3 = new File(file, localPackageName + e6.a.f26665g);
            if (file3.exists()) {
                CFGEntityList cFGEntityListK02 = k0(file3, "utf-8");
                if (cFGEntityListK0 == null) {
                    cFGEntityListK0 = new CFGEntityList();
                }
                v(cFGEntityListK0.getConfigsForWholeGamepad(), cFGEntityListK02.getConfigsForWholeGamepad());
                v(cFGEntityListK0.getConfigsForHalfGamepad(), cFGEntityListK02.getConfigsForHalfGamepad());
                v(cFGEntityListK0.getConfigsForKeyboard(), cFGEntityListK02.getConfigsForKeyboard());
                u0(cFGEntityListK0, localPackageName);
                b0.o(file3);
            }
        }
        return cFGEntityListK0 == null ? n0.b(localPackageName, DataConstant.TEST_KEYMAPPING) ? r0() : new CFGEntityList() : cFGEntityListK0;
    }

    public static xi.z<CFGEntityList> m0(String standardPackageName) {
        return n0(standardPackageName, standardPackageName);
    }

    public static xi.z<CFGEntityList> n0(final String localPackageName, final String standardPackageName) {
        return xi.z.r1(new c0() { // from class: e6.q
            @Override // xi.c0
            public final void a(xi.b0 b0Var) throws Exception {
                z.N(localPackageName, standardPackageName, b0Var);
            }
        }).J5(lj.b.d());
    }

    public static ArrayList<EntitySimpleConfig> o0(CFGEntityList cfgEntityList) {
        ArrayList<EntitySimpleConfig> arrayList = new ArrayList<>();
        for (CFGEntity cFGEntity : cfgEntityList.getConfigsForWholeGamepad()) {
            EntitySimpleConfig entitySimpleConfig = new EntitySimpleConfig();
            entitySimpleConfig.setName(cFGEntity.title);
            entitySimpleConfig.setCheck(false);
            entitySimpleConfig.setVersion(1);
            entitySimpleConfig.setCfgEntity(cFGEntity);
            arrayList.add(entitySimpleConfig);
        }
        for (CFGEntity cFGEntity2 : cfgEntityList.getConfigsForKeyboard()) {
            EntitySimpleConfig entitySimpleConfig2 = new EntitySimpleConfig();
            entitySimpleConfig2.setName(cFGEntity2.title);
            entitySimpleConfig2.setCheck(false);
            entitySimpleConfig2.setVersion(2);
            entitySimpleConfig2.setCfgEntity(cFGEntity2);
            arrayList.add(entitySimpleConfig2);
        }
        for (CFGEntity cFGEntity3 : cfgEntityList.getConfigsForHalfGamepad()) {
            EntitySimpleConfig entitySimpleConfig3 = new EntitySimpleConfig();
            entitySimpleConfig3.setName(cFGEntity3.title);
            entitySimpleConfig3.setCheck(false);
            entitySimpleConfig3.setVersion(3);
            entitySimpleConfig3.setCfgEntity(cFGEntity3);
            arrayList.add(entitySimpleConfig3);
        }
        return arrayList;
    }

    public static xi.z<RecommendConfigBean> p0(final String packageName) {
        return DBManager.getInstance().getInstalledGameObservable(packageName).A3(h.f26674a).l2(new dj.o() { // from class: e6.f
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.P(packageName, (String) obj);
            }
        }).J5(lj.b.d());
    }

    @yt.k
    public static xi.z<CFGVibrateList> q0(@yt.k final String packageName) {
        return xi.z.m3(packageName).A3(new dj.o() { // from class: e6.d
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.Q(packageName, (String) obj);
            }
        }).A3(l.f26678a).Y1(new dj.g() { // from class: e6.x
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                z.R((File) obj);
            }
        }).A3(b7.g.f9102a).A3(new dj.o() { // from class: e6.k
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.S((String) obj);
            }
        }).J5(lj.b.d());
    }

    public static CFGEntityList r0() {
        File file = new File(e6.a.f26664f);
        b0.k(file);
        File file2 = new File(file, DataConstant.NAME_TEST_KEY_MAPPING);
        String strP = s0.p("cfg/test_keymapping.local.fdg");
        a0.T(file2, strP);
        return G(strP);
    }

    public static void s0(List<EntitySimpleConfig> entitySimpleConfigs, CFGEntityList cfgEntityList) {
        for (EntitySimpleConfig entitySimpleConfig : entitySimpleConfigs) {
            int version = entitySimpleConfig.getVersion();
            if (version != 1) {
                if (version != 2) {
                    if (version == 3 && n0.z(cfgEntityList.getConfigsForHalfGamepad())) {
                        ArrayList arrayList = new ArrayList(cfgEntityList.getConfigsForHalfGamepad());
                        for (CFGEntity cFGEntity : cfgEntityList.getConfigsForHalfGamepad()) {
                            if (TextUtils.equals(entitySimpleConfig.getName(), cFGEntity.title)) {
                                arrayList.remove(cFGEntity);
                            }
                        }
                        cfgEntityList.setConfigsForHalfGamepad(arrayList);
                    }
                } else if (n0.z(cfgEntityList.getConfigsForKeyboard())) {
                    ArrayList arrayList2 = new ArrayList(cfgEntityList.getConfigsForKeyboard());
                    for (CFGEntity cFGEntity2 : cfgEntityList.getConfigsForKeyboard()) {
                        if (TextUtils.equals(entitySimpleConfig.getName(), cFGEntity2.title)) {
                            arrayList2.remove(cFGEntity2);
                        }
                    }
                    cfgEntityList.setConfigsForKeyboard(arrayList2);
                }
            } else if (n0.z(cfgEntityList.getConfigsForWholeGamepad())) {
                ArrayList arrayList3 = new ArrayList(cfgEntityList.getConfigsForWholeGamepad());
                for (CFGEntity cFGEntity3 : cfgEntityList.getConfigsForWholeGamepad()) {
                    if (TextUtils.equals(entitySimpleConfig.getName(), cFGEntity3.title)) {
                        arrayList3.remove(cFGEntity3);
                    }
                }
                cfgEntityList.setConfigsForWholeGamepad(arrayList3);
            }
        }
    }

    public static void t0(EntitySimpleConfig simpleConfig, CFGEntityList cfgEntityList, String newName) {
        if (n0.z(cfgEntityList.getConfigsForWholeGamepad())) {
            for (CFGEntity cFGEntity : cfgEntityList.getConfigsForWholeGamepad()) {
                if (TextUtils.equals(cFGEntity.title, simpleConfig.getName())) {
                    cFGEntity.title = newName;
                    return;
                }
            }
        }
        if (n0.z(cfgEntityList.getConfigsForKeyboard())) {
            for (CFGEntity cFGEntity2 : cfgEntityList.getConfigsForKeyboard()) {
                if (TextUtils.equals(cFGEntity2.title, simpleConfig.getName())) {
                    cFGEntity2.title = newName;
                    return;
                }
            }
        }
        if (n0.z(cfgEntityList.getConfigsForHalfGamepad())) {
            for (CFGEntity cFGEntity3 : cfgEntityList.getConfigsForHalfGamepad()) {
                if (TextUtils.equals(cFGEntity3.title, simpleConfig.getName())) {
                    cFGEntity3.title = newName;
                    return;
                }
            }
        }
    }

    public static void u(CFGEntityList cfgEntityList, int version, String title, CFGEntity cfgEntity, boolean forceReplace) {
        if (version == 1 || version == 0) {
            x(title, cfgEntity, cfgEntityList.getConfigsForWholeGamepad(), forceReplace);
        } else if (version == 2) {
            x(title, cfgEntity, cfgEntityList.getConfigsForKeyboard(), forceReplace);
        } else if (version == 3) {
            x(title, cfgEntity, cfgEntityList.getConfigsForHalfGamepad(), forceReplace);
        }
    }

    @SuppressLint({"CheckResult"})
    public static void u0(CFGEntityList config, String packageName) {
        w0(config, packageName).c(new d());
    }

    public static void v(List<CFGEntity> newCFGEntityList, List<CFGEntity> oldCFGEntityList) {
        for (CFGEntity cFGEntity : oldCFGEntityList) {
            if (!newCFGEntityList.contains(cFGEntity)) {
                newCFGEntityList.add(cFGEntity);
            }
        }
        boolean z10 = false;
        for (CFGEntity cFGEntity2 : newCFGEntityList) {
            if (cFGEntity2.isInUse()) {
                if (z10) {
                    cFGEntity2.setInUse(false);
                } else {
                    z10 = true;
                }
            }
        }
    }

    public static void v0(final String packageName, final int deviceMode, final List<CFGEntity> mConfigsForCurrentDevice) {
        n0(packageName, packageName).Y1(new dj.g() { // from class: e6.m
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                z.T(deviceMode, mConfigsForCurrentDevice, (CFGEntityList) obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d()).F5(new dj.g() { // from class: e6.t
            @Override // dj.g
            public final void accept(Object obj) {
                z.u0((CFGEntityList) obj, packageName);
            }
        }, new dj.g() { // from class: e6.y
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                z.V((Throwable) obj);
            }
        });
    }

    public static void w(CFGEntityList cfgEntityList, CloudConfigBean cloudConfigBean, File downloadConfig, boolean forceReplace) throws JSONException, IOException {
        int i10 = cloudConfigBean.version;
        int i11 = 2;
        if (i10 == 2) {
            i11 = 1;
        } else if (i10 != 3) {
            i11 = 0;
        }
        u(cfgEntityList, cloudConfigBean.version, cloudConfigBean.title, j0(downloadConfig, true, i11), forceReplace);
    }

    public static e0<File> w0(final CFGEntityList config, final String packageName) {
        return DBManager.getInstance().getInstalledGameObservable(packageName).A3(h.f26674a).A3(new dj.o() { // from class: e6.j
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.W((String) obj);
            }
        }).f4(new dj.o() { // from class: e6.g
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.X(packageName, (Throwable) obj);
            }
        }).Y1(new dj.g() { // from class: e6.r
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                z.Y(config, (File) obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r0 >= r6.size()) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r4 = r6.get(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r4.isForCurrentDevice(r5.getGamepad()) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r4.isInTop() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r5.isInTop() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        if (r0 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        r6.add(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        r6.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void x(java.lang.String r4, com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r5, java.util.List<com.flydigi.sdk.gamepad.extension.config.data.CFGEntity> r6, boolean r7) {
        /*
            r0 = 0
            r5.setInUse(r0)
            r1 = 0
        L5:
            int r2 = r6.size()
            if (r1 >= r2) goto L2d
            java.lang.Object r2 = r6.get(r1)
            com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r2 = (com.flydigi.sdk.gamepad.extension.config.data.CFGEntity) r2
            java.lang.String r3 = r5.getGamepad()
            boolean r3 = r2.isForCurrentDevice(r3)
            if (r3 == 0) goto L2a
            java.lang.String r2 = r2.title
            boolean r2 = android.text.TextUtils.equals(r2, r4)
            if (r2 == 0) goto L2a
            if (r7 == 0) goto L29
            r6.remove(r1)
            goto L2d
        L29:
            return
        L2a:
            int r1 = r1 + 1
            goto L5
        L2d:
            int r4 = r6.size()
            r7 = -1
            if (r0 >= r4) goto L4e
            java.lang.Object r4 = r6.get(r0)
            com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r4 = (com.flydigi.sdk.gamepad.extension.config.data.CFGEntity) r4
            java.lang.String r1 = r5.getGamepad()
            boolean r1 = r4.isForCurrentDevice(r1)
            if (r1 == 0) goto L4b
            boolean r4 = r4.isInTop()
            if (r4 != 0) goto L4b
            goto L4f
        L4b:
            int r0 = r0 + 1
            goto L2d
        L4e:
            r0 = -1
        L4f:
            boolean r4 = r5.isInTop()
            if (r4 == 0) goto L5b
            if (r0 == r7) goto L5b
            r6.add(r0, r5)
            goto L5e
        L5b:
            r6.add(r5)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.z.x(java.lang.String, com.flydigi.sdk.gamepad.extension.config.data.CFGEntity, java.util.List, boolean):void");
    }

    public static e0<RecommendConfigBean> x0(final RecommendConfigBean recommendConfigBean, String localPackageName) {
        return DBManager.getInstance().getInstalledGameObservable(localPackageName).A3(h.f26674a).l2(new dj.o() { // from class: e6.c
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.Z(recommendConfigBean, (String) obj);
            }
        }).J5(lj.b.d());
    }

    public static boolean y(CFGEntityList oldConfigList, CFGEntityList newConfigList) {
        if (!oldConfigList.getConfigsForWholeGamepad().isEmpty() && !newConfigList.getConfigsForWholeGamepad().isEmpty()) {
            for (CFGEntity cFGEntity : newConfigList.getConfigsForWholeGamepad()) {
                Iterator<CFGEntity> it2 = oldConfigList.getConfigsForWholeGamepad().iterator();
                while (it2.hasNext()) {
                    if (n0.b(it2.next().getTitle(), cFGEntity.getTitle())) {
                        return true;
                    }
                }
            }
        }
        if (!oldConfigList.getConfigsForKeyboard().isEmpty() && !newConfigList.getConfigsForKeyboard().isEmpty()) {
            for (CFGEntity cFGEntity2 : newConfigList.getConfigsForKeyboard()) {
                Iterator<CFGEntity> it3 = oldConfigList.getConfigsForKeyboard().iterator();
                while (it3.hasNext()) {
                    if (n0.b(it3.next().getTitle(), cFGEntity2.getTitle())) {
                        return true;
                    }
                }
            }
        }
        if (oldConfigList.getConfigsForHalfGamepad().isEmpty() || newConfigList.getConfigsForHalfGamepad().isEmpty()) {
            return false;
        }
        for (CFGEntity cFGEntity3 : newConfigList.getConfigsForHalfGamepad()) {
            Iterator<CFGEntity> it4 = oldConfigList.getConfigsForHalfGamepad().iterator();
            while (it4.hasNext()) {
                if (n0.b(it4.next().getTitle(), cFGEntity3.getTitle())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static xi.z<CFGVibrateList> y0(final String packageName, final CFGVibrateBean vibrateConfig) {
        return xi.z.m3(packageName).A3(new dj.o() { // from class: e6.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.a0(packageName, (String) obj);
            }
        }).A3(l.f26678a).Y1(new dj.g() { // from class: e6.w
            @Override // dj.g
            public final void accept(Object obj) {
                b0.m((File) obj);
            }
        }).A3(b7.g.f9102a).A3(new dj.o() { // from class: e6.i
            @Override // dj.o
            public final Object apply(Object obj) {
                return z.b0((String) obj);
            }
        }).Y1(new dj.g() { // from class: e6.s
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                z.c0(vibrateConfig, (CFGVibrateList) obj);
            }
        }).Y1(new dj.g() { // from class: e6.v
            @Override // dj.g
            public final void accept(Object obj) {
                com.blankj.utilcode.util.e0.v((CFGVibrateList) obj);
            }
        }).Y1(new dj.g() { // from class: e6.u
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                z.d0(packageName, (CFGVibrateList) obj);
            }
        }).J5(lj.b.d());
    }

    public static boolean z(List<CFGEntity> configs, CFGEntity currentEntity, String newConfigName) {
        if (n0.o(configs)) {
            return false;
        }
        for (CFGEntity cFGEntity : configs) {
            if (cFGEntity.isForCurrentDevice(currentEntity.getGamepad()) && n0.b(cFGEntity.title, newConfigName)) {
                return true;
            }
        }
        return false;
    }

    public static void z0(List<CFGEntity> cfgEntities, int type) {
        if (cfgEntities == null || cfgEntities.size() <= 0) {
            return;
        }
        for (CFGEntity cFGEntity : cfgEntities) {
            ArrayList<CFGPropertyKey> arrayList = cFGEntity.keyList;
            if (arrayList != null) {
                for (CFGPropertyKey cFGPropertyKey : arrayList) {
                    if (cFGPropertyKey.key_id != 256) {
                        if (d1.g(cFGPropertyKey.key)) {
                            cFGPropertyKey.key = com.flydigi.sdk.gamepad.extension.a.i(cFGPropertyKey.key_id, type);
                        }
                        int iF = com.flydigi.sdk.gamepad.extension.a.f(cFGPropertyKey.key, type);
                        cFGPropertyKey.key_id = iF;
                        if (iF == -1 && cFGPropertyKey.comboKeyFirst != -1 && cFGPropertyKey.comboKeySecond != -1) {
                            cFGPropertyKey.key_id = 256;
                        }
                    }
                    if (m9.m.a(cFGPropertyKey.key_id)) {
                        if (cFGPropertyKey.comboKeyMode == -1) {
                            cFGPropertyKey.comboKeyMode = 2;
                        }
                        if (cFGPropertyKey.comboKeyFirst == -1) {
                            cFGPropertyKey.comboKeyFirst = o9.b.b(m9.m.c(cFGPropertyKey.key_id));
                        }
                        if (cFGPropertyKey.comboKeySecond == -1) {
                            cFGPropertyKey.comboKeySecond = o9.b.b(m9.m.d(cFGPropertyKey.key_id));
                        }
                    }
                }
            }
            ArrayList<CFGPropertyJS> arrayList2 = cFGEntity.jsList;
            if (arrayList2 != null) {
                for (CFGPropertyJS cFGPropertyJS : arrayList2) {
                    if (d1.g(cFGPropertyJS.key)) {
                        cFGPropertyJS.key = com.flydigi.sdk.gamepad.extension.a.i(cFGPropertyJS.key_id, type);
                    }
                    cFGPropertyJS.key_id = com.flydigi.sdk.gamepad.extension.a.f(cFGPropertyJS.key, type);
                }
            }
            ArrayList<CFGPropertyMacro> arrayList3 = cFGEntity.marcoList;
            if (arrayList3 != null) {
                for (CFGPropertyMacro cFGPropertyMacro : arrayList3) {
                    if (cFGPropertyMacro.key_id != 256) {
                        if (d1.g(cFGPropertyMacro.key)) {
                            cFGPropertyMacro.key = com.flydigi.sdk.gamepad.extension.a.i(cFGPropertyMacro.key_id, type);
                        }
                        int iF2 = com.flydigi.sdk.gamepad.extension.a.f(cFGPropertyMacro.key, type);
                        cFGPropertyMacro.key_id = iF2;
                        if (iF2 == -1 && cFGPropertyMacro.comboKeyFirst != -1 && cFGPropertyMacro.comboKeySecond != -1) {
                            cFGPropertyMacro.key_id = 256;
                        }
                    }
                    if (m9.m.a(cFGPropertyMacro.key_id)) {
                        if (cFGPropertyMacro.comboKeyMode == -1) {
                            cFGPropertyMacro.comboKeyMode = 2;
                        }
                        if (cFGPropertyMacro.comboKeyFirst == -1) {
                            cFGPropertyMacro.comboKeyFirst = o9.b.b(m9.m.c(cFGPropertyMacro.key_id));
                        }
                        if (cFGPropertyMacro.comboKeySecond == -1) {
                            cFGPropertyMacro.comboKeySecond = o9.b.b(m9.m.d(cFGPropertyMacro.key_id));
                        }
                    }
                }
            }
        }
    }
}
