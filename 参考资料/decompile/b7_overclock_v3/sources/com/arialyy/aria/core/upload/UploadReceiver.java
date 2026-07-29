package com.arialyy.aria.core.upload;

import android.text.TextUtils;
import com.arialyy.annotations.TaskEnum;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.AriaManager;
import com.arialyy.aria.core.command.CancelAllCmd;
import com.arialyy.aria.core.command.CmdHelper;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.common.ProxyHelper;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.inf.AbsReceiver;
import com.arialyy.aria.core.inf.ReceiverType;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.scheduler.TaskInternalListenerInterface;
import com.arialyy.aria.core.scheduler.TaskSchedulers;
import com.arialyy.aria.core.upload.target.FtpBuilderTarget;
import com.arialyy.aria.core.upload.target.FtpNormalTarget;
import com.arialyy.aria.core.upload.target.HttpBuilderTarget;
import com.arialyy.aria.core.upload.target.HttpNormalTarget;
import com.arialyy.aria.core.upload.target.UTargetFactory;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.ComponentUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class UploadReceiver extends AbsReceiver {
    public UploadReceiver(Object obj) {
        super(obj);
    }

    public List<UploadEntity> getAllCompleteTask() {
        return DbEntity.findDatas(UploadEntity.class, "isGroupChild=? and isComplete=?", "false", "true");
    }

    public List<UploadEntity> getAllNotCompleteTask() {
        return DbEntity.findDatas(UploadEntity.class, "isGroupChild=? and isComplete=?", "false", "false");
    }

    public UploadEntity getFirstUploadEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (UploadEntity) DbEntity.findFirst(UploadEntity.class, "filePath=?", str);
    }

    public List<UploadEntity> getTaskList() {
        return DbEntity.findAllData(UploadEntity.class);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public ReceiverType getType() {
        return ReceiverType.UPLOAD;
    }

    public List<UploadEntity> getURunningTask() {
        return UTaskQueue.getInstance().getRunningTask(UploadEntity.class);
    }

    public UploadEntity getUploadEntity(long j10) {
        if (j10 == -1) {
            return null;
        }
        return (UploadEntity) DbEntity.findFirst(UploadEntity.class, "rowid=?", String.valueOf(j10));
    }

    public HttpBuilderTarget load(String str) {
        ComponentUtil.getInstance().checkComponentExist(1);
        CheckUtil.checkUploadPathIsEmpty(str);
        return (HttpBuilderTarget) UTargetFactory.getInstance().generateBuilderTarget(HttpBuilderTarget.class, str);
    }

    public FtpBuilderTarget loadFtp(String str) {
        ComponentUtil.getInstance().checkComponentExist(2);
        CheckUtil.checkUploadPathIsEmpty(str);
        return (FtpBuilderTarget) UTargetFactory.getInstance().generateBuilderTarget(FtpBuilderTarget.class, str);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public void register() {
        Object obj = this.obj;
        if (obj == null) {
            ALog.e(this.TAG, String.format("【%s】观察者为空", getTargetName()));
            return;
        }
        if (obj instanceof TaskInternalListenerInterface) {
            ProxyHelper.getInstance().checkProxyType(this.obj.getClass());
            if (this.obj instanceof UploadTaskListener) {
                TaskSchedulers.getInstance().register(this.obj, TaskEnum.UPLOAD);
                return;
            }
            return;
        }
        Set<Integer> setCheckProxyType = ProxyHelper.getInstance().checkProxyType(this.obj.getClass());
        if (setCheckProxyType == null || setCheckProxyType.isEmpty()) {
            ALog.e(this.TAG, "没有Aria的注解方法，详情见：https://aria.laoyuyu.me/aria_doc/other/annotaion_invalid.html");
            return;
        }
        Iterator<Integer> it2 = setCheckProxyType.iterator();
        while (it2.hasNext()) {
            if (it2.next().intValue() == ProxyHelper.PROXY_TYPE_UPLOAD) {
                TaskSchedulers.getInstance().register(this.obj, TaskEnum.UPLOAD);
            }
        }
    }

    public void removeAllTask(boolean z10) {
        AriaManager ariaManager = AriaManager.getInstance();
        CancelAllCmd cancelAllCmd = (CancelAllCmd) CmdHelper.createNormalCmd(new UTaskWrapper(null), NormalCmdFactory.TASK_CANCEL_ALL, 2);
        cancelAllCmd.removeFile = z10;
        EventMsgUtil.getDefault().post(cancelAllCmd);
        Iterator<String> it2 = ariaManager.getReceiver().keySet().iterator();
        while (it2.hasNext()) {
            ariaManager.getReceiver().remove(it2.next());
        }
    }

    @Deprecated
    public UploadReceiver setMaxSpeed(int i10) throws Throwable {
        AriaConfig.getInstance().getUConfig().setMaxSpeed(i10);
        return this;
    }

    public void stopAllTask() {
        EventMsgUtil.getDefault().post(NormalCmdFactory.getInstance().createCmd((AbsTaskWrapper) new UTaskWrapper(null), 183, 2));
    }

    public boolean taskExists(String str) {
        return DbEntity.checkDataExist(UTaskWrapper.class, "key=?", str);
    }

    @Override // com.arialyy.aria.core.inf.IReceiver
    public void unRegister() {
        if (isNeedRmListener()) {
            unRegisterListener();
        }
        AriaManager.getInstance().removeReceiver(this.obj);
    }

    @Override // com.arialyy.aria.core.inf.AbsReceiver
    public void unRegisterListener() {
        if (this.obj == null) {
            ALog.e(this.TAG, String.format("【%s】观察者为空", getTargetName()));
            return;
        }
        Set<Integer> set = ProxyHelper.getInstance().mProxyCache.get(this.obj.getClass().getName());
        if (set != null) {
            Iterator<Integer> it2 = set.iterator();
            while (it2.hasNext()) {
                if (it2.next().intValue() == ProxyHelper.PROXY_TYPE_UPLOAD) {
                    TaskSchedulers.getInstance().unRegister(this.obj);
                }
            }
        }
    }

    public List<UploadEntity> getAllCompleteTask(int i10, int i11) {
        CheckUtil.checkPageParams(i10, i11);
        return DbEntity.findDatas(UploadEntity.class, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "true");
    }

    public List<UploadEntity> getAllNotCompleteTask(int i10, int i11) {
        CheckUtil.checkPageParams(i10, i11);
        return DbEntity.findDatas(UploadEntity.class, i10, i11, "isGroupChild=? and downloadPath!='' and isComplete=?", "false", "false");
    }

    public List<UploadEntity> getTaskList(int i10, int i11) {
        CheckUtil.checkPageParams(i10, i11);
        return DbEntity.findDatas(UploadEntity.class, i10, i11, "isGroupChild=? and downloadPath!=''", "false");
    }

    public List<UploadEntity> getUploadEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return DbEntity.findDatas(UploadEntity.class, "filePath=?", str);
    }

    public HttpNormalTarget load(long j10) {
        ComponentUtil.getInstance().checkComponentExist(1);
        return (HttpNormalTarget) UTargetFactory.getInstance().generateNormalTarget(HttpNormalTarget.class, j10);
    }

    public FtpNormalTarget loadFtp(long j10) {
        ComponentUtil.getInstance().checkComponentExist(2);
        return (FtpNormalTarget) UTargetFactory.getInstance().generateNormalTarget(FtpNormalTarget.class, j10);
    }
}
