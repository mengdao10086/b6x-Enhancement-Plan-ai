/* ============================================================
 * B6X 智能温控 WebUI — 参数定义 (schema)
 * 键范围以 tempctrl.c 的 clamp() 为准；说明摘自 profile.conf 注释
 * 注意：改 profile.conf 加/改参数时，必须同步更新本文件
 * ============================================================ */
window.B6X_SCHEMA = {
  moduleId: "b6x-Enhancement-Plan",
  configPath: "/data/adb/modules/b6x-Enhancement-Plan/profile.conf",
  statusB6: "/data/local/tmp/tempctrl_b6x.status",
  statusB7: "/data/local/tmp/tempctrl_b7x.status",
  gearFile: "/data/local/tmp/tempctrl.gear",
  dataFile: "/data/local/tmp/tempctrl_webui.data",  // C 每 1s 写入的曲线数据文件
  chartWindowOptions: [120, 180, 240, 360, 480, 720],

  groups: [
    // [0] 日志 & 调试（置顶，调试便捷）
    {
      id: "g1", title: "[0] 日志 & 调试", master: "DEBUG_ENABLED",
      headerSwitch: "DEBUG_ENABLED",
      keys: [],
      subKeys: ["DEBUG_SENSOR", "DEBUG_EMERG", "DEBUG_BATT", "DEBUG_EXEC",
                "DEBUG_CONN", "DEBUG_CONFIG", "DEBUG_MAIN", "DEBUG_PID", "DEBUG_LAUNCH", "DEBUG_FAN"]
    },
    // [1] 总开关：组头开关 PERF_ENABLED + 通用参数子面板（复用开关+子面板机制）
    {
      id: "g0", title: "[1] 总开关", master: "PERF_ENABLED",
      headerSwitch: "PERF_ENABLED",
      keys: [],
      subKeys: ["RATE_LIMIT_FAN_UP", "RATE_LIMIT_FAN_DOWN", "FAN_RPM_CHANGE_THRESHOLD",
                "RATE_LIMIT_COLD", "RATE_LIMIT_TEMP", "BATT_BASELINE",
                "COLD_MAP_START", "COLD_MAP_EXP", "HOT_MAP", "RPM_SMOOTH_ALPHA", "FAN_RPM",
                "BATT_SKIP_MAX"]
    },
    // [2] 控制模式：PID 与 Gear 同一窗口。组头开关 CTRL_MODE 仅切换模式（1=PID / 0=Gear），
    // 不控制折叠；展开/折叠由 PERF_ENABLED 总开关驱动（master）。组内按模式切换显示参数面板
    {
      id: "g4", title: "[2] 控制模式", master: "PERF_ENABLED",
      headerSwitch: "CTRL_MODE",
      keys: [],
      modePanels: [
        { when: "1", title: "PID 模式控制",
          keys: ["PID_KP", "PID_KI", "PID_INTEGRAL_LIMIT", "PID_KI_VAR_THRESHOLD",
                 "PID_KI_VAR_SAMPLES", "PID_KI_DEADBAND", "PID_KD", "PID_INPUT_FILTER_ENABLED",
                 "PID_FILTER_AUTO_THRESHOLD", "PID_ALPHA", "PID_CPU_COMP_ENABLED",
                 "PID_CPU_COMP_DIVISOR", "PID_PREDICT_WEIGHT", "PID_PREDICT_WIN",
                 "PID_PREDICT_RISE", "PID_PREDICT_MIN_DELTA", "PID_COLD"] },
        { when: "0", title: "Gear 模式控制",
          keys: ["BATT_BOUNDARY", "BATT_COOLDOWN_CYCLES", "CURRENT_GEAR_MODE",
                 "CURRENT_GEAR_MULT", "CURRENT_GEAR_SMOOTH_ALPHA", "CURRENT_GEAR_MIN",
                 "REV_COMP", "REV_COMP_T", "REV_COMP_COOLDOWN", "TREND_RESET_THRESHOLD",
                 "EMERG_CPU_ENABLED", "CPU_EMERG", "CPU_FILTER_ALPHA", "EMERG_MODE",
                 "EMERG_FORCED", "EMERG_EXIT_CAP_OFFSET", "EMERG_STEP",
                 "EMERG_EXIT_BATT_THRESHOLD", "EMERG_RECOVERY_MULT",
                 "EMERG_RECOVERY_PHASE_CYCLES",
                 "GEAR_CONFIG_ENABLED", "GEAR_AUTO_FAN"],
          gearTables: ["GEAR_B6X_", "GEAR_B7X_"] }
      ]
    },
    // [3] sysfs 路径与缩放：独立大类（SYSFS_ENABLED 开关控制加载）
    {
      id: "g2", title: "[3] sysfs 路径与缩放", headerSwitch: "SYSFS_ENABLED",
      keys: [],
      subKeys: ["BATT_TEMP_PATH", "BATT_TEMP_DIVISOR", "BATT_CURRENT_PATH",
                "BATT_CURRENT_DIVISOR", "CPU_TEMP_PATH_FMT", "CPU_TEMP_DIVISOR",
                "CPU_ZONE", "LOG_FILE", "LOG_MAX", "LOG_TRIM_LINES"]
    },
    // [4] 自动拉起散热器 app：独立分组，开关常显在组头；说明区常显（无折叠内容，不渲染小三角）
    {
      id: "g3", title: "[4] 自动拉起散热器 app", headerSwitch: "APP_LAUNCH_ENABLED",
      keys: []
    }
  ],

  keys: {
    // ---- [0] ----
    PERF_ENABLED: { type: "switch", label: "性能参数总开关", desc: "" },

    // ---- [1] ----
    DEBUG_ENABLED: { type: "switch", label: "调试日志总开关", desc: "" },
    DEBUG_SENSOR: { type: "switch", label: "传感器读数", desc: "电池/CPU/电流读数调试日志" },
    DEBUG_EMERG: { type: "switch", label: "紧急干预", desc: "紧急等级计算调试日志" },
    DEBUG_BATT: { type: "switch", label: "电池温度控制", desc: "电池温度调档/恢复期/反补调试日志" },
    DEBUG_EXEC: { type: "switch", label: "执行下发", desc: "速率限制与广播下发调试日志" },
    DEBUG_CONN: { type: "switch", label: "连接状态", desc: "App 存活/BLE/重连调试日志" },
    DEBUG_CONFIG: { type: "switch", label: "配置加载", desc: "配置文件解析过程调试日志" },
    DEBUG_MAIN: { type: "switch", label: "主循环", desc: "主循环流程跟踪调试日志" },
    DEBUG_PID: { type: "switch", label: "PID", desc: "PID 模式调试日志（需开 DEBUG_ENABLED）" },
    DEBUG_LAUNCH: { type: "switch", label: "自动拉起", value: "0",
      desc: "自动拉起散热器 app 的决策过程（目标选择/回退/跳过），拉起成功/失败始终输出" },
    DEBUG_FAN: { type: "switch", label: "风扇", value: "0",
      desc: "风扇转速计算/限速/下发调试日志" },

    // ---- [7] 路径与缩放 ----
    SYSFS_ENABLED: { type: "switch", label: "sysfs 路径与缩放开关", desc: "" },
    BATT_TEMP_PATH: { type: "path", label: "电池温度 sysfs",
      desc: "不同机型位置可能不同，可自行修改" },
    BATT_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "电池温度缩放系数",
      desc: "原始值 ÷ 缩放系数 → 0.1°C" },
    BATT_CURRENT_PATH: { type: "path", label: "电池电流 sysfs",
      desc: "不同机型位置可能不同，可自行修改" },
    BATT_CURRENT_DIVISOR: { type: "int", min: 1, max: 100000, label: "电池电流缩放系数",
      desc: "原始值 ÷ 缩放系数 → µA" },
    CPU_TEMP_PATH_FMT: { type: "path", label: "CPU 温度 sysfs 模板",
      desc: "%d 会替换为目标 thermal_zone 编号" },
    CPU_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "CPU 温度缩放系数",
      desc: "原始值 ÷ 缩放系数 → 0.1°C" },
    CPU_ZONE: { type: "multi", fields: [{ label: "最小 zone", min: 0, max: 99 }, { label: "最大 zone", min: 0, max: 99 }],
      label: "CPU thermal_zone 扫描范围", desc: "首次扫描范围（0~99），K60 推荐 30~40" },
    LOG_FILE: { type: "path", label: "日志文件路径",
      desc: "空则自动根据二进制名在 /cache/ 生成" },
    LOG_MAX: { type: "int", min: 0, max: 1048576, label: "日志上限（字节）",
      desc: "0=关闭日志；默认 7936" },
    LOG_TRIM_LINES: { type: "int", min: 0, max: 50, label: "日志超限清理行数",
      desc: "删除最早 N 行，0=不清理" },

    // ---- [2] 通用 ----
    RATE_LIMIT_FAN_UP: { type: "multi", fields: [{ label: "升速基础值", min: 50, max: 2000 }, { label: "升速倍率", min: 1, max: 200 }],
      label: "风扇升速限制", desc: "值 = 基础值 + d(0.1°C) × 倍率 / 10" },
    RATE_LIMIT_FAN_DOWN: { type: "int", min: 50, max: 2000, label: "风扇降速限制",
      desc: "固定值，不受温差影响" },
    FAN_RPM_CHANGE_THRESHOLD: { type: "int", min: 0, max: 2000, label: "风扇转速降低变化阈值",
      desc: "0=不限制；距最低转速 < 阈值×1.5 时失效" },
    RATE_LIMIT_COLD: { type: "multi", fields: [{ label: "基础值", min: 1, max: 194 }, { label: "倍率", min: 1, max: 100 }],
      label: "制冷强度限速",
      desc: "升速=base+dev×mult/10，降速=base-dev×mult/10；负值→0=禁止该方向" },
    RATE_LIMIT_TEMP: { type: "int", min: 1, max: 30, label: "目标温度限速（°C）",
      desc: "目标温度每周期最大变化量（智能温控模式）" },
    APP_LAUNCH_ENABLED: { type: "switch", label: "自动拉起散热器 app",
      desc: "无散热器 app 存活时自动拉起上次使用的 app" },
    BATT_SKIP_MAX: { type: "int", min: 1, max: 60, label: "温度未变强制处理周期",
      desc: "温度值连续未变达 N 周期时强制进入一次计算，防止温度文件卡死控制停摆" },
    CTRL_MODE: { type: "switch", label: "控制模式", desc: "" },
    BATT_BASELINE: { type: "int", min: 300, max: 500, label: "基准温度（0.1°C）",
      desc: "电池温度与此值计算偏差，PID 和 Gear 共用" },
    COLD_MAP_START: { type: "int", min: 0, max: 194, label: "制冷映射起始强度",
      desc: "低于此值时线性外推下限" },
    COLD_MAP_EXP: { type: "int", min: 50, max: 500, label: "制冷映射指数",
      desc: "n^exp（÷100，150=1.50），>1 低冷慢转" },
    HOT_MAP: { type: "multi", fields: [{ label: "最低温度", min: 200, max: 500 }, { label: "最高温度", min: 200, max: 500 }],
      label: "热端线性映射范围（0.1°C）",
      desc: "热端在此区间线性映射到风扇转速，超出取边界" },
    RPM_SMOOTH_ALPHA: { type: "int", min: 1, max: 99, label: "冷/热端→RPM 平滑系数（%）",
      desc: "冷端与热端共用，值越大越跟随原始值，越小越平滑" },
    FAN_RPM: { type: "multi", fields: [{ label: "最低转速", min: 1000, max: 6000 }, { label: "最高转速(B6X)", min: 1000, max: 6000 }, { label: "最高转速(B7X)", min: 2000, max: 6000 }],
      label: "风扇转速范围", desc: "B6X/B7X 共用，B7X 暂与 B6X 一致" },

    // ---- [3] PID ----
    PID_KP: { type: "int", min: 1, max: 1000, label: "KP 比例", desc: "÷1000；过大震荡，过小偏慢（推荐 200~500）" },
    PID_KI: { type: "int", min: 0, max: 1000, label: "KI 积分", desc: "受方差门控+死区双重控制；过大降温滞后（推荐 30~80）" },
    PID_INTEGRAL_LIMIT: { type: "int", min: 0, max: 1000, label: "KI 积分上限",
      desc: "防饱和；默认 800/1000×190=152" },
    PID_KI_VAR_THRESHOLD: { type: "int", min: 0, max: 200, label: "KI 方差门控阈值（0.1°C²）",
      desc: "温度方差低于此值时 I 项全温度段启用；0=关闭方差门控（推荐 20~50）" },
    PID_KI_VAR_SAMPLES: { type: "int", min: 2, max: 20, label: "KI 方差采样数",
      desc: "样本越多方差判断越滤波，但响应越慢" },
    PID_KI_DEADBAND: { type: "int", min: 0, max: 100, label: "KI 积分分离死区（0.1°C）",
      desc: "|error| < 此值则累积 I（推荐 10~30）" },
    PID_KD: { type: "int", min: 0, max: 1000, label: "KD 微分",
      desc: "抑制过冲；太大调节缓慢甚至反冲（推荐 100~300）" },
    PID_INPUT_FILTER_ENABLED: { type: "switch", label: "PID 输入滤波开关",
      desc: "默认关：非预测直通原始值；预测进入/退出后 6 周期自动临时开启防跳变" },
    PID_FILTER_AUTO_THRESHOLD: { type: "multi", fields: [{ label: "自动关闭阈值", min: 5, max: 100 }, { label: "自动恢复阈值", min: 5, max: 100 }],
      label: "滤波自动关闭/恢复阈值", desc: "×0.1 周期" },
    PID_ALPHA: { type: "multi", fields: [{ label: "更新间隔滤波强度(%)", min: 1, max: 100 }, { label: "电池温度滤波强度(%)", min: 1, max: 100 }, { label: "预测滤波强度(%)", min: 1, max: 100 }],
      label: "滤波强度", desc: "三段滤波强度：更新间隔/电池温度/预测" },
    PID_CPU_COMP_ENABLED: { type: "switch", label: "CPU 补偿开关", desc: "=1 启用" },
    PID_CPU_COMP_DIVISOR: { type: "int", min: 5, max: 200, label: "CPU 补偿除数",
      desc: "(cpu-batt 0.1°C)÷divisor→0.1°C" },
    PID_PREDICT_WEIGHT: { type: "multi", fields: [{ label: "升温权重", min: 0, max: 10 }, { label: "降温权重", min: 0, max: 10 }, { label: "抑制系数(%)", min: 0, max: 100 }],
      label: "预测方向权重 + 抑制系数",
      desc: "升温默认10(全效)，降温默认5(半效)；抑制系数默认50=×0.5，0=完全抑制=停止" },
    PID_PREDICT_WIN: { type: "multi", fields: [{ label: "缓冲区大小", min: 3, max: 32 }, { label: "最大计算窗口", min: 3, max: 10 }, { label: "最小计算窗口", min: 2, max: 5 }],
      label: "预测窗口", desc: "3~32 / 3~10 / 2~5" },
    PID_PREDICT_RISE: { type: "multi", fields: [{ label: "最大温升(0.1°C)", min: 10, max: 100 }, { label: "Ramp-up 周期数", min: 0, max: 10 }],
      label: "预测上升限制", desc: "预测最大温升（0.1°C）与渐入周期数" },
    PID_PREDICT_MIN_DELTA: { type: "int", min: 1, max: 10, label: "最小起始 delta（0.1°C/周期）",
      desc: "默认2=0.2°C" },
    PID_COLD: { type: "multi", fields: [{ label: "下限", min: 0, max: 194 }, { label: "上限(B6X)", min: 0, max: 194 }, { label: "上限(B7X)", min: 1, max: 190 }],
      label: "制冷强度范围", desc: "B7X 上限暂与 B6X 一致" },

    // ---- [4] Gear 电池 ----
    BATT_BOUNDARY: { type: "multi", fields: [{ label: "死区", min: 1, max: 100 }, { label: "±1档边界", min: 1, max: 100 }, { label: "±2档边界", min: 1, max: 100 }],
      label: "三区间阈值（0.1°C）", desc: "死区与 ±1/±2 档边界" },
    BATT_COOLDOWN_CYCLES: { type: "int", min: 0, max: 20, label: "档位变动冷却周期",
      desc: "每次档位变动后冻结 N 周期 ×5 秒，紧急不受限" },
    CURRENT_GEAR_MODE: { type: "multi", fields: [{ label: "充电", min: 0, max: 1 }, { label: "放电", min: 0, max: 1 }],
      label: "电流-挡位映射开关", desc: "0=仅普通电池温度，1=电流映射推荐挡位" },
    CURRENT_GEAR_MULT: { type: "multi", fields: [{ label: "充电倍率", min: 1, max: 50 }, { label: "放电倍率", min: 1, max: 50 }],
      label: "电流映射倍率", desc: "推荐档位 = 滤波电流(0.01A) × 倍率 ÷ 100" },
    CURRENT_GEAR_SMOOTH_ALPHA: { type: "int", min: 1, max: 100, label: "电流滤波强度（%）",
      desc: "电流 EMA 平滑强度，越大越跟随原始值" },
    CURRENT_GEAR_MIN: { type: "int", min: 1, max: 12, label: "电流映射最低档位",
      desc: "推荐档位低于此值时回退到基准（电池温度）模式" },
    REV_COMP: { type: "multi", fields: [{ label: "反补", min: 0, max: 1 }, { label: "趋势豁免", min: 0, max: 1 }],
      label: "反补 + 趋势豁免开关", desc: "=0 禁用对应功能" },
    REV_COMP_T: { type: "multi", fields: [{ label: "阈值1", min: 1, max: 50 }, { label: "阈值2", min: 1, max: 50 }, { label: "阈值3", min: 1, max: 50 }],
      label: "反补三级阈值",
      desc: "默认 2 3 4 = 0.2°C/0.3°C/0.4°C 每周期" },
    REV_COMP_COOLDOWN: { type: "int", min: 0, max: 10, label: "反补冷却周期数",
      desc: "反补生效后冻结 N 周期" },
    TREND_RESET_THRESHOLD: { type: "int", min: 0, max: 20, label: "趋势豁免锚点复位阈值",
      desc: "以区间中值为偏移量计算复位阈值，越过则复位豁免计数器" },

    // ---- [5] Gear 紧急 ----
    EMERG_CPU_ENABLED: { type: "switch", label: "CPU 温度紧急开关", desc: "=0 禁用" },
    CPU_EMERG: { type: "multi", fields: [{ label: "退出紧急", min: 300, max: 700 }, { label: "进入1级", min: 400, max: 800 }, { label: "进入2级", min: 500, max: 900 }, { label: "进入3级", min: 600, max: 1000 }],
      label: "CPU 紧急阈值（0.1°C）",
      desc: "> 值1/2/3 → 进入紧急 1/2/3，< 值0/1/2 → 恢复到 0/1/2" },
    CPU_FILTER_ALPHA: { type: "int", min: 1, max: 100, label: "CPU 温度滤波强度（%）",
      desc: "越大越跟原始值，越小越滤波" },
    EMERG_MODE: { type: "multi", fields: [{ label: "进入(升档)", min: 0, max: 1 }, { label: "退出(降档)", min: 0, max: 1 }],
      label: "紧急干预模式", desc: "0=表查，1=步进" },
    EMERG_FORCED: { type: "multi", fields: [{ label: "等级1", min: 0, max: 12 }, { label: "等级2", min: 0, max: 12 }, { label: "等级3", min: 0, max: 12 }, { label: "等级4", min: 0, max: 12 }],
      label: "强制最低档位", desc: "各等级强制最低档位（1~4 级）" },
    EMERG_EXIT_CAP_OFFSET: { type: "int", min: 0, max: 5, label: "退出钳制偏移量",
      desc: "cap = 高一级最低档 + 此值，仅降档模式=0 生效" },
    EMERG_STEP: { type: "int", min: 1, max: 12, label: "升/降档步数", desc: "模式=1 时生效" },
    EMERG_EXIT_BATT_THRESHOLD: { type: "int", min: 5, max: 50, label: "紧急退出电池阈值",
      desc: "低于基准+此值 → 全效退出，×2 → 半效退出" },
    EMERG_RECOVERY_MULT: { type: "multi", fields: [{ label: "阶段1", min: 1, max: 20 }, { label: "阶段2", min: 1, max: 20 }, { label: "阶段3", min: 1, max: 20 }],
      label: "紧急退出恢复期倍率",
      desc: "退出紧急后调档阈值逐步恢复：×P1→×P2→×P3→1" },
    EMERG_RECOVERY_PHASE_CYCLES: { type: "int", min: 1, max: 50, label: "恢复阶段周期数",
      desc: "每阶段持续 N 周期" },

    // ---- [6] 档位表 ----
    GEAR_CONFIG_ENABLED: { type: "switch", label: "自定义档位表开关",
      desc: "=1 使用下方 GEAR_N，=0 使用代码默认表" },
    GEAR_AUTO_FAN: { type: "switch", label: "档位表自动风扇转速",
      desc: "=1 用冷端强度+热端温度双映射计算风扇转速，挡位表风扇转速变为截断上限；=0 直接使用配置风扇转速" }
  },

  // 档位表行格式：模式,目标温度(°C),风扇RPM,制冷强度
  gearRow: {
    fields: [
      { key: "mode", label: "模式", min: 0, max: 1, type: "int" },
      { key: "target", label: "目标°C", min: 5, max: 35, type: "int" },
      { key: "rpm", label: "风扇RPM", min: 2000, max: 6000, type: "int" },
      { key: "cold", label: "制冷", min: 1, max: 190, type: "int" }
    ],
    maxN: 32,
    defaultValue: "1,0,2000,5"
  }
};
