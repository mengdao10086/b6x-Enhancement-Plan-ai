package com.flydigi.game.data.bean;

import com.flydigi.game.data.StringListConverter;
import com.flydigi.game.data.bean.GameBeanCursor;
import db.d;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import java.util.List;
import li.c;
import ni.b;

/* JADX INFO: loaded from: classes7.dex */
public final class GameBean_ implements EntityInfo<GameBean> {
    public static final Property<GameBean>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "GameBean";
    public static final int __ENTITY_ID = 5;
    public static final String __ENTITY_NAME = "GameBean";
    public static final Property<GameBean> __ID_PROPERTY;
    public static final GameBean_ __INSTANCE;
    public static final Property<GameBean> appointmentStatus;
    public static final Property<GameBean> category;
    public static final Property<GameBean> description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public static final Property<GameBean> f15816id;
    public static final Property<GameBean> idDB;
    public static final Property<GameBean> installed;
    public static final Property<GameBean> isHide;
    public static final Property<GameBean> isSubscribed;
    public static final Property<GameBean> lastOperateTime;
    public static final Property<GameBean> link;
    public static final Property<GameBean> localPath;
    public static final Property<GameBean> log;
    public static final Property<GameBean> packageName;
    public static final Property<GameBean> pattern;
    public static final Property<GameBean> progress;
    public static final Property<GameBean> size;
    public static final Property<GameBean> star;
    public static final Property<GameBean> thumb;
    public static final Property<GameBean> title;
    public static final Property<GameBean> type;
    public static final Property<GameBean> updateAble;
    public static final Property<GameBean> updateTime;
    public static final Property<GameBean> version;
    public static final Property<GameBean> versionCode;
    public static final Property<GameBean> wifiRequired;
    public static final Class<GameBean> __ENTITY_CLASS = GameBean.class;
    public static final b<GameBean> __CURSOR_FACTORY = new GameBeanCursor.Factory();

    @c
    public static final GameBeanIdGetter __ID_GETTER = new GameBeanIdGetter();

    @c
    public static final class GameBeanIdGetter implements ni.c<GameBean> {
        @Override // ni.c
        public long getId(GameBean gameBean) {
            return gameBean.idDB;
        }
    }

    static {
        GameBean_ gameBean_ = new GameBean_();
        __INSTANCE = gameBean_;
        Class cls = Long.TYPE;
        Property<GameBean> property = new Property<>(gameBean_, 0, 1, cls, "idDB", true, "idDB");
        idDB = property;
        Property<GameBean> property2 = new Property<>(gameBean_, 1, 2, String.class, "id");
        f15816id = property2;
        Property<GameBean> property3 = new Property<>(gameBean_, 2, 3, String.class, "title");
        title = property3;
        Property<GameBean> property4 = new Property<>(gameBean_, 3, 13, String.class, "packageName");
        packageName = property4;
        Property<GameBean> property5 = new Property<>(gameBean_, 4, 24, cls, "updateTime");
        updateTime = property5;
        Property<GameBean> property6 = new Property<>(gameBean_, 5, 4, String.class, "thumb");
        thumb = property6;
        Property<GameBean> property7 = new Property<>(gameBean_, 6, 19, String.class, d.f26139i);
        version = property7;
        Class cls2 = Integer.TYPE;
        Property<GameBean> property8 = new Property<>(gameBean_, 7, 21, cls2, "versionCode");
        versionCode = property8;
        Property<GameBean> property9 = new Property<>(gameBean_, 8, 5, cls2, "star");
        star = property9;
        Property<GameBean> property10 = new Property<>(gameBean_, 9, 23, String.class, "log");
        log = property10;
        Property<GameBean> property11 = new Property<>(gameBean_, 10, 6, String.class, "description");
        description = property11;
        Property<GameBean> property12 = new Property<>(gameBean_, 11, 7, String.class, "link");
        link = property12;
        Property<GameBean> property13 = new Property<>(gameBean_, 12, 8, String.class, "size");
        size = property13;
        Property<GameBean> property14 = new Property<>(gameBean_, 13, 9, String.class, "category", false, "category", StringListConverter.class, List.class);
        category = property14;
        Property<GameBean> property15 = new Property<>(gameBean_, 14, 26, String.class, "pattern", false, "pattern", StringListConverter.class, List.class);
        pattern = property15;
        Class cls3 = Boolean.TYPE;
        Property<GameBean> property16 = new Property<>(gameBean_, 15, 22, cls3, "updateAble");
        updateAble = property16;
        Property<GameBean> property17 = new Property<>(gameBean_, 16, 25, cls, "lastOperateTime");
        lastOperateTime = property17;
        Property<GameBean> property18 = new Property<>(gameBean_, 17, 10, cls2, "type");
        type = property18;
        Property<GameBean> property19 = new Property<>(gameBean_, 18, 17, cls3, "installed");
        installed = property19;
        Property<GameBean> property20 = new Property<>(gameBean_, 19, 14, String.class, "localPath");
        localPath = property20;
        Property<GameBean> property21 = new Property<>(gameBean_, 20, 15, Float.TYPE, "progress");
        progress = property21;
        Property<GameBean> property22 = new Property<>(gameBean_, 21, 18, cls3, "wifiRequired");
        wifiRequired = property22;
        Property<GameBean> property23 = new Property<>(gameBean_, 22, 27, cls2, "appointmentStatus");
        appointmentStatus = property23;
        Property<GameBean> property24 = new Property<>(gameBean_, 23, 28, cls2, "isSubscribed");
        isSubscribed = property24;
        Property<GameBean> property25 = new Property<>(gameBean_, 24, 30, cls3, "isHide");
        isHide = property25;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22, property23, property24, property25};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public Property<GameBean>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public b<GameBean> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "GameBean";
    }

    @Override // io.objectbox.EntityInfo
    public Class<GameBean> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 5;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "GameBean";
    }

    @Override // io.objectbox.EntityInfo
    public ni.c<GameBean> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public Property<GameBean> getIdProperty() {
        return __ID_PROPERTY;
    }
}
