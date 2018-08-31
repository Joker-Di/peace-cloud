package pep.pesoftware.coc.constant;

import java.math.BigDecimal;

public class PeaceConstant {

    public static final String DATA_FORMAT_DATA_SHORT_SYMBOL = "yyyy-MM-dd";
    public static final String DATA_FORMAT_DATA_SHORT = "yyyyMMdd";
    public static final String DATA_FORMAT_DATA_TIME_SHORT_SYMBOL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_FORMAT_DATA_TIME_SHORT = "yyyyMMddHHmmss";

    /**
     * 超级用户名
     */
    public static final String ADMIN_USER_NAME = "admin";

    /**
     * 下拉列表显示的名称
     */
    public static final String LIST_NAME = "name";
    /**
     * 下拉列表显示的Code
     */
    public static final String LIST_CODE = "code";
    /**
     * 下拉列表显示的类型,联动查询时使用
     */
    public static final String LIST_TYPE = "type";

    /**
     * 生成主键添加随机数的个数
     */
    public static final int KEY_RANDOM_COUNT = 10;


    /**
     * 下拉列表联动,全部返回
     */
    public static final String LIST_ASSOCIATION_ALL = "0";
    /**
     * 下拉列表联动,查询ADX的时候
     */
    public static final String LIST_ASSOCIATION_ADX = "1";
    /**
     * 下拉列表联动,查询媒体的时候
     */
    public static final String LIST_ASSOCIATION_MEDIA = "2";
    /**
     * 下拉列表联动,查询广告位的时候
     */
    public static final String LIST_ASSOCIATION_POS = "3";

    /**
     * 下拉列表联动,查询广告主的时候
     */
    public static final String LIST_ASSOCIATION_ADV = "1";
    /**
     * 下拉列表联动,查询推广计划的时候
     */
    public static final String LIST_ASSOCIATION_PLAN = "2";
    /**
     * 下拉列表联动,查询推广组的时候
     */
    public static final String LIST_ASSOCIATION_GROUP = "3";


    /**
     * 版本号
     */
    public static final String V1 = "/v1";
    /**
     * 字符串转换编码
     */
    public static final String USER_STRING_CHARSET = "UTF-8";
    /**
     * 发生异常时使用Log
     */
    public static final String HANDLE_ERROR = "处理失败";
    /**
     * 已删除
     */
    public static final String DEL_FLAG_YES = "1";
    /**
     * 未删除
     */
    public static final String DEL_FLAG_NO = "0";
    /**
     * SQL模糊查询
     */
    public static final String SQL_LIKE = "%";
    /**
     * 竖线分隔符
     */
    public static final String LINE_CONNECT = "|";
    /**
     * 竖线分隔符
     */
    public static final String LINE_SPILT = "\\|";
    /**
     * 下划线
     */
    public static final String UNDER_LINE = "_";
    /**
     * 逗号
     */
    public static final String COMMON = ",";

    /**
     * 创意类型
     */
    public static final String CREATIVE_TYPE_IMAGE = "1";
    public static final String CREATIVE_TYPE_VIDEO = "2";
    public static final String CREATIVE_TYPE_FLOW = "3";

    /**
     * 常量true/false
     */
    public static final boolean CONSTANT_BOOLEAN_TRUE=true;
    public static final boolean CONSTANT_BOOLEAN_FALSE=false;
    /**
     * insert true
     */
    public static final int SQL_INSERT_RESULT_TRUE=1;

    /**
     * 开关
     */
    public static final String STATUS_OPEN = "1";
    public static final String STATUS_CLOSE = "0";

    /**
     * 缓存Redis中父子关联的个数Key
     */
    public static final String REDIS_KEY_ADX_MEDIA = "redis_key_adx_media_count";
    public static final String REDIS_KEY_MEDIA_POS = "redis_key_media_pos_count";
    public static final String REDIS_KEY_PLAN_GROUP = "redis_key_plan_group_count";
    public static final String REDIS_KEY_GROUP_CREATIVE = "redis_key_group_creative_count";
    public static final String REDIS_KEY_DIMENSION_SUB = "redis_key_dimension_sub_count";
    public static final String REDIS_KEY_DIMENSION_SUB_POS = "redis_key_dimension_sub_pos_count";
    public static final String REDIS_KEY_MEDIA_APPLY = "redis_key_media_apply_count";
    //设置保存定向分布式锁
    public static final String REDIS_KEY_LOCK_SAVE_GROUP = "redis_lock_group";

    //单选框或者复选框全部的代码
    public static final String SELECT_ALL = "000000";

    /**
     * recharge充值type
     */
    public static final String RECHARGE_TYPE_RECHARGE = "1";
    public static final String RECHARGE_TYPE_CONSUME = "0";

    /**
     * 计划回扣默认值
     */
    public static final Integer PLAN_KICKBACK_VALUE=0;

    /**
     * 推广组定向type值
     */
    //时段定向
    public static final String GROUP_TARGETING_TIME="01";
    //地域
    public static final String GROUP_TARGETING_REGION="02";
    //广告位
    public static final String GROUP_TARGETING_POS="03";
    //系统定向
    public static final String GROUP_TARGETING_OS="04";
    //移动网络定向
    public static final String GROUP_TARGETING_NETWORK="05";
    //移动设备定向
    public static final String GROUP_TARGETING_DEVICE="06";


    /**
     * 素材图片的分类,分为:icon\logo\图片\视频
     */
    public static final String MATERIAL_TYPE_ICON = "1";
    public static final String MATERIAL_TYPE_LOGO = "2";
    public static final String MATERIAL_TYPE_IMAGE = "3";
    public static final String MATERIAL_TYPE_VIDEO = "4";

    /**
     * 素材审核状态
     */
    // 未提审
    public static final String CREATIVE_AUDIT_STATUS_NO = "01";
    // 提审失败
    public static final String CREATIVE_AUDIT_STATUS_ERROR = "02";
    // 审核中
    public static final String CREATIVE_AUDIT_STATUS_ING = "03";
    // 审核成功
    public static final String CREATIVE_AUDIT_STATUS_SUCCESS = "04";
    // 审核失败
    public static final String CREATIVE_AUDIT_STATUS_FAIL = "05";

    /**
     * 阿里API调用失败
     */
    public static final String ALIBABA_FAILURE = "FAILURE";

    /**
     * 上传的默认阿里用户
     */
    public static final String ALIBABA_HOMIE_ADV = "1084";
    public static final String ALIBABA_STATUS_STOP = "0";
    public static final String ALIBABA_STATUS_START = "1";


    /**
     * 设置返回参数
     */
    public static final String RESPONSE_DATA_FLAG = "success";
    public static final String RESPONSE_DATA_DATA = "data";

    /**
     * 媒介计划审核状态
     * examineType: [{ name: '未通过', code: '0' }, { name: '通过', code: '1' }, { name: '审核中', code: '2' }],
     */
    public static final String MEDIA_PLAN_NO = "0";
    public static final String MEDIA_PLAN_YES = "1";
    public static final String MEDIA_PLAN_ING = "2";

    /**
     * 媒介计划取消预订状态
     * { name: '未取消', code: '0' }, { name: '已取消', code: '1' }
     */
    public static final String MEDIA_PLAN_CANCEL_YES = "1";
    public static final String MEDIA_PLAN_CANCEL_NO = "0";

    /**
     * 媒介计划操作类型
     * { name: '审核', code: '0' }, { name: '取消预订', code: '1' }
     */
    public static final String MEDIA_PLAN_OPERATION_CANCEL = "1";
    public static final String MEDIA_PLAN_OPERATION_EXAMINE = "0";

    /**
     * 提现税率
     */
    public static final BigDecimal DARW_BALANCE_TAX = new BigDecimal("0.02");

    /**
     * 提现状态
     */
    public static final String DARW_BALANCE__STATUS_START = "0";

    /**
     * 查询广告位所用的类型
     * 1、媒体  2、资源包  3、关键词
     */
    public static final String SELECT_POS_BY_APP = "1";
    public static final String SELECT_POS_BY_PACKAGE = "2";
    public static final String SELECT_POS_BY_KEY_WORD = "3";

    /**
     * 投放状态
     *  1、投放  0、未投放
     */
    public static final String LAUNCH_YES = "1";
    public static final String LAUNCH_NO = "0";

    /**
     * 订单来源
     * 0：手动创建  1：媒介计划生产
     */
    public static final String GENERATE_ORDER_MEDIA_PLAN = "1";
    public static final String GENERATE_ORDER_SELF = "0";

    /**
     * 订单是否生成投放
     * 1：生成 0：未生成
     */
    public static final String ORDER_GENERATE_YES = "1";
    public static final String ORDER_GENERATE_NO = "0";

    /**
     * 库存区分
     * 1：预订 0：投放
     */
    public static final String STOCK_ORDER = "1";
    public static final String STOCK_LAUNCH = "0";

    /**
     * 广告位-默认广告开启
     * 1：开启 2: 关闭
     */
    public static final String POSFLAG_YES = "1";
    public static final String POSFLAG_NO = "2";


}
