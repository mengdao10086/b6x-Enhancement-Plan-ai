package com.flydigi.baseProvider;

import android.content.Context;
import android.os.Parcelable;
import com.alibaba.android.arouter.facade.template.IProvider;

/* JADX INFO: loaded from: classes2.dex */
public interface IStatisticsProvider extends IProvider {
    void b(Context context, String action, String keyType, int valueType, String keyData, Parcelable valueData, String keySave, boolean valueSave);

    void j(Context context, String action, String keySave, boolean valueSave);
}
