package com.flydigi.game.data.bean;

import com.flydigi.game.data.StringListConverter;
import com.flydigi.game.data.bean.GameBean_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import java.util.List;
import li.c;
import ni.b;

/* JADX INFO: loaded from: classes7.dex */
public final class GameBeanCursor extends Cursor<GameBean> {
    private final StringListConverter categoryConverter;
    private final StringListConverter patternConverter;
    private static final GameBean_.GameBeanIdGetter ID_GETTER = GameBean_.__ID_GETTER;
    private static final int __ID_id = GameBean_.f15816id.f32643id;
    private static final int __ID_title = GameBean_.title.f32643id;
    private static final int __ID_packageName = GameBean_.packageName.f32643id;
    private static final int __ID_updateTime = GameBean_.updateTime.f32643id;
    private static final int __ID_thumb = GameBean_.thumb.f32643id;
    private static final int __ID_version = GameBean_.version.f32643id;
    private static final int __ID_versionCode = GameBean_.versionCode.f32643id;
    private static final int __ID_star = GameBean_.star.f32643id;
    private static final int __ID_log = GameBean_.log.f32643id;
    private static final int __ID_description = GameBean_.description.f32643id;
    private static final int __ID_link = GameBean_.link.f32643id;
    private static final int __ID_size = GameBean_.size.f32643id;
    private static final int __ID_category = GameBean_.category.f32643id;
    private static final int __ID_pattern = GameBean_.pattern.f32643id;
    private static final int __ID_updateAble = GameBean_.updateAble.f32643id;
    private static final int __ID_lastOperateTime = GameBean_.lastOperateTime.f32643id;
    private static final int __ID_type = GameBean_.type.f32643id;
    private static final int __ID_installed = GameBean_.installed.f32643id;
    private static final int __ID_localPath = GameBean_.localPath.f32643id;
    private static final int __ID_progress = GameBean_.progress.f32643id;
    private static final int __ID_wifiRequired = GameBean_.wifiRequired.f32643id;
    private static final int __ID_appointmentStatus = GameBean_.appointmentStatus.f32643id;
    private static final int __ID_isSubscribed = GameBean_.isSubscribed.f32643id;
    private static final int __ID_isHide = GameBean_.isHide.f32643id;

    @c
    public static final class Factory implements b<GameBean> {
        @Override // ni.b
        public Cursor<GameBean> createCursor(Transaction transaction, long j10, BoxStore boxStore) {
            return new GameBeanCursor(transaction, j10, boxStore);
        }
    }

    public GameBeanCursor(Transaction transaction, long j10, BoxStore boxStore) {
        super(transaction, j10, GameBean_.__INSTANCE, boxStore);
        this.categoryConverter = new StringListConverter();
        this.patternConverter = new StringListConverter();
    }

    @Override // io.objectbox.Cursor
    public long getId(GameBean gameBean) {
        return ID_GETTER.getId(gameBean);
    }

    @Override // io.objectbox.Cursor
    public long put(GameBean gameBean) {
        String str = gameBean.f15815id;
        int i10 = str != null ? __ID_id : 0;
        String str2 = gameBean.title;
        int i11 = str2 != null ? __ID_title : 0;
        String str3 = gameBean.packageName;
        int i12 = str3 != null ? __ID_packageName : 0;
        String str4 = gameBean.thumb;
        Cursor.collect400000(this.cursor, 0L, 1, i10, str, i11, str2, i12, str3, str4 != null ? __ID_thumb : 0, str4);
        String str5 = gameBean.version;
        int i13 = str5 != null ? __ID_version : 0;
        String str6 = gameBean.log;
        int i14 = str6 != null ? __ID_log : 0;
        String str7 = gameBean.description;
        int i15 = str7 != null ? __ID_description : 0;
        String str8 = gameBean.link;
        Cursor.collect400000(this.cursor, 0L, 0, i13, str5, i14, str6, i15, str7, str8 != null ? __ID_link : 0, str8);
        String str9 = gameBean.size;
        int i16 = str9 != null ? __ID_size : 0;
        List<String> list = gameBean.category;
        int i17 = list != null ? __ID_category : 0;
        List<String> list2 = gameBean.pattern;
        int i18 = list2 != null ? __ID_pattern : 0;
        String str10 = gameBean.localPath;
        Cursor.collect400000(this.cursor, 0L, 0, i16, str9, i17, i17 != 0 ? this.categoryConverter.convertToDatabaseValue(list) : null, i18, i18 != 0 ? this.patternConverter.convertToDatabaseValue(list2) : null, str10 != null ? __ID_localPath : 0, str10);
        Cursor.collect313311(this.cursor, 0L, 0, 0, null, 0, null, 0, null, 0, null, __ID_updateTime, gameBean.updateTime, __ID_lastOperateTime, gameBean.lastOperateTime, __ID_versionCode, gameBean.versionCode, __ID_star, gameBean.star, __ID_type, gameBean.type, __ID_appointmentStatus, gameBean.appointmentStatus, __ID_progress, gameBean.progress, 0, 0.0d);
        long jCollect313311 = Cursor.collect313311(this.cursor, gameBean.idDB, 2, 0, null, 0, null, 0, null, 0, null, __ID_isSubscribed, gameBean.isSubscribed, __ID_updateAble, gameBean.updateAble ? 1L : 0L, __ID_installed, gameBean.installed ? 1L : 0L, __ID_wifiRequired, gameBean.wifiRequired ? 1 : 0, __ID_isHide, gameBean.isHide ? 1 : 0, 0, 0, 0, 0.0f, 0, 0.0d);
        gameBean.idDB = jCollect313311;
        return jCollect313311;
    }
}
