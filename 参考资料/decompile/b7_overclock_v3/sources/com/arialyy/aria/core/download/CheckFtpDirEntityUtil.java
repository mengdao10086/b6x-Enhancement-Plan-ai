package com.arialyy.aria.core.download;

import android.text.TextUtils;
import com.arialyy.aria.core.FtpUrlEntity;
import com.arialyy.aria.core.inf.ICheckEntityUtil;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import fh.a;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class CheckFtpDirEntityUtil implements ICheckEntityUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String TAG = "CheckFtpDirEntityUtil";
    private int action;
    private DownloadGroupEntity mEntity;
    private DGTaskWrapper mWrapper;

    /* JADX WARN: Multi-variable type inference failed */
    private CheckFtpDirEntityUtil(DGTaskWrapper dGTaskWrapper, int i10) {
        this.action = i10;
        this.mWrapper = dGTaskWrapper;
        this.mEntity = (DownloadGroupEntity) dGTaskWrapper.getEntity();
    }

    private boolean checkDirPath() {
        String dirPathTemp = this.mWrapper.getDirPathTemp();
        if (TextUtils.isEmpty(dirPathTemp)) {
            ALog.e("CheckFtpDirEntityUtil", "文件夹路径不能为null");
            return false;
        }
        if (!dirPathTemp.startsWith(a.f28350w)) {
            ALog.e("CheckFtpDirEntityUtil", String.format("文件夹路径【%s】错误", dirPathTemp));
            return false;
        }
        File file = new File(dirPathTemp);
        if (file.isFile()) {
            ALog.e("CheckFtpDirEntityUtil", String.format("路径【%s】是文件，请设置文件夹路径", dirPathTemp));
            return false;
        }
        if (this.mWrapper.isNewTask() && !CheckUtil.checkDGPathConflicts(this.mWrapper.isIgnoreFilePathOccupy(), dirPathTemp)) {
            return false;
        }
        if (TextUtils.isEmpty(this.mEntity.getDirPath()) || !this.mEntity.getDirPath().equals(dirPathTemp)) {
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mEntity.setDirPath(dirPathTemp);
            ALog.i("CheckFtpDirEntityUtil", String.format("文件夹路径改变，将更新文件夹路径为：%s", dirPathTemp));
        }
        return true;
    }

    private boolean checkUrl() {
        String key = this.mEntity.getKey();
        if (TextUtils.isEmpty(key)) {
            ALog.e("CheckFtpDirEntityUtil", "下载失败，url为null");
            return false;
        }
        if (!key.startsWith("ftp")) {
            ALog.e("CheckFtpDirEntityUtil", "下载失败，url【" + key + "】错误");
            return false;
        }
        if (key.indexOf("://") != -1) {
            return true;
        }
        ALog.e("CheckFtpDirEntityUtil", "下载失败，url【" + key + "】不合法");
        return false;
    }

    public static CheckFtpDirEntityUtil newInstance(DGTaskWrapper dGTaskWrapper, int i10) {
        return new CheckFtpDirEntityUtil(dGTaskWrapper, i10);
    }

    @Override // com.arialyy.aria.core.inf.ICheckEntityUtil
    public boolean checkEntity() {
        if (this.mWrapper.getErrorEvent() != null) {
            ALog.e("CheckFtpDirEntityUtil", String.format("任务操作失败，%s", this.mWrapper.getErrorEvent().errorMsg));
            return false;
        }
        boolean z10 = checkDirPath() && checkUrl();
        if (z10) {
            this.mEntity.save();
        }
        FtpUrlEntity ftpUrlEntity = (FtpUrlEntity) this.mWrapper.getOptionParams().getParam(IOptionConstant.ftpUrlEntity);
        if (ftpUrlEntity.isFtps) {
            if (TextUtils.isEmpty(ftpUrlEntity.idEntity.storePath)) {
                ALog.e("CheckFtpDirEntityUtil", "证书路径为空");
                return false;
            }
            if (TextUtils.isEmpty(ftpUrlEntity.idEntity.keyAlias)) {
                ALog.e("CheckFtpDirEntityUtil", "证书别名为空");
                return false;
            }
        }
        return z10;
    }
}
