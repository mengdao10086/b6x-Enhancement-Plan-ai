package com.arialyy.aria.http.download;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.loader.AbsNormalTTBuilderAdapter;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.core.task.IThreadTaskAdapter;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.BufferedRandomAccessFile;
import com.arialyy.aria.util.FileUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class HttpDTTBuilderAdapter extends AbsNormalTTBuilderAdapter {
    @Override // com.arialyy.aria.core.loader.AbsNormalTTBuilderAdapter
    public IThreadTaskAdapter getAdapter(SubThreadConfig subThreadConfig) {
        return new HttpDThreadTaskAdapter(subThreadConfig);
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalTTBuilderAdapter
    public boolean handleNewTask(TaskRecord taskRecord, int i10) throws Throwable {
        if (taskRecord.isBlock) {
            for (int i11 = 0; i11 < i10; i11++) {
                File file = new File(String.format(IRecordHandler.SUB_PATH, getTempFile().getPath(), Integer.valueOf(i11)));
                if (file.exists()) {
                    ALog.d(this.TAG, String.format("分块【%s】已经存在，将删除该分块", Integer.valueOf(i11)));
                    FileUtil.deleteFile(file);
                }
            }
        } else if (getTempFile().exists()) {
            FileUtil.deleteFile(getTempFile());
        }
        BufferedRandomAccessFile bufferedRandomAccessFile = null;
        if (i10 > 1) {
            try {
                try {
                    if (!taskRecord.isBlock) {
                        BufferedRandomAccessFile bufferedRandomAccessFile2 = new BufferedRandomAccessFile(getTempFile().getPath(), "rwd", 8192);
                        try {
                            bufferedRandomAccessFile2.setLength(getEntity().getFileSize());
                            bufferedRandomAccessFile = bufferedRandomAccessFile2;
                        } catch (IOException e10) {
                            e = e10;
                            bufferedRandomAccessFile = bufferedRandomAccessFile2;
                            e.printStackTrace();
                            ALog.e(this.TAG, String.format("下载失败，filePath: %s, url: %s", getEntity().getFilePath(), getEntity().getUrl()));
                            if (bufferedRandomAccessFile != null) {
                                try {
                                    bufferedRandomAccessFile.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedRandomAccessFile = bufferedRandomAccessFile2;
                            if (bufferedRandomAccessFile != null) {
                                try {
                                    bufferedRandomAccessFile.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (getTempFile().exists()) {
            FileUtil.deleteFile(getTempFile());
        }
        if (bufferedRandomAccessFile != null) {
            try {
                bufferedRandomAccessFile.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
        }
        return true;
    }
}
