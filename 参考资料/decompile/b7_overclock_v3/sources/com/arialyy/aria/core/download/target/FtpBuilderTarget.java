package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.common.SFtpOption;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.util.CommonUtil;
import fh.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FtpBuilderTarget extends AbsBuilderTarget<FtpBuilderTarget> {
    private DNormalConfigHandler<FtpBuilderTarget> mConfigHandler;

    public FtpBuilderTarget(String str) {
        DNormalConfigHandler<FtpBuilderTarget> dNormalConfigHandler = new DNormalConfigHandler<>(this, -1L);
        this.mConfigHandler = dNormalConfigHandler;
        dNormalConfigHandler.setUrl(str);
        getTaskWrapper().setRequestType(3);
        getEntity().setTaskType(3);
        getTaskWrapper().setNewTask(true);
    }

    public FtpBuilderTarget option(FtpOption ftpOption) {
        Objects.requireNonNull(ftpOption, "ftp 任务配置为空");
        ftpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.mConfigHandler.getUrl()));
        getTaskWrapper().getOptionParams().setParams(ftpOption);
        return this;
    }

    public FtpBuilderTarget setFilePath(String str) {
        getEntity().setFileName(this.mConfigHandler.getUrl().substring(this.mConfigHandler.getUrl().lastIndexOf(a.f28350w) + 1));
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }

    public FtpBuilderTarget sftpOption(SFtpOption sFtpOption) {
        Objects.requireNonNull(sFtpOption, "ftp 任务配置为空");
        sFtpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.mConfigHandler.getUrl()));
        getTaskWrapper().getOptionParams().setParams(sFtpOption);
        getEntity().setTaskType(12);
        getTaskWrapper().setRequestType(12);
        return this;
    }

    @Override // com.arialyy.aria.core.inf.AbsTarget
    public DownloadEntity getEntity() {
        return (DownloadEntity) super.getEntity();
    }

    @Deprecated
    public FtpBuilderTarget setFilePath(String str, boolean z10) {
        this.mConfigHandler.setTempFilePath(str);
        this.mConfigHandler.setForceDownload(z10);
        return this;
    }
}
