package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.m3u8.M3U8LiveOption;
import com.arialyy.aria.core.download.m3u8.M3U8VodOption;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class HttpBuilderTarget extends AbsBuilderTarget<HttpBuilderTarget> {
    private DNormalConfigHandler<HttpBuilderTarget> mConfigHandler;

    public HttpBuilderTarget(String str) {
        DNormalConfigHandler<HttpBuilderTarget> dNormalConfigHandler = new DNormalConfigHandler<>(this, -1L);
        this.mConfigHandler = dNormalConfigHandler;
        dNormalConfigHandler.setUrl(str);
        getTaskWrapper().setRequestType(1);
        getTaskWrapper().setNewTask(true);
        ((DownloadEntity) getEntity()).setTaskType(1);
    }

    public HttpBuilderTarget m3u8LiveOption(M3U8LiveOption m3U8LiveOption) {
        Objects.requireNonNull(m3U8LiveOption, "m3u8任务设置为空");
        getTaskWrapper().setRequestType(8);
        ((DTaskWrapper) getTaskWrapper()).getM3U8Params().setParams(m3U8LiveOption);
        return this;
    }

    public HttpBuilderTarget m3u8VodOption(M3U8VodOption m3U8VodOption) {
        Objects.requireNonNull(m3U8VodOption, "m3u8任务设置为空");
        getTaskWrapper().setRequestType(7);
        getTaskWrapper().getEntity().setFileSize(m3U8VodOption.getFileSize());
        ((DTaskWrapper) getTaskWrapper()).getM3U8Params().setParams(m3U8VodOption);
        return this;
    }

    public HttpBuilderTarget option(HttpOption httpOption) {
        Objects.requireNonNull(httpOption, "任务配置为空");
        getTaskWrapper().getOptionParams().setParams(httpOption);
        return this;
    }

    public HttpBuilderTarget setFilePath(String str) {
        this.mConfigHandler.setTempFilePath(str);
        return this;
    }

    @Deprecated
    public HttpBuilderTarget setFilePath(String str, boolean z10) {
        this.mConfigHandler.setTempFilePath(str);
        this.mConfigHandler.setForceDownload(z10);
        return this;
    }
}
