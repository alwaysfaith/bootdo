package com.bootdo.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @author: zhengfei
 * @param:
 * @date: 2019-01-03 16:32
 */

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS("0", "操作成功",""),
    OVERFLOW("US_100001","系统繁忙，请稍后再试",""),
    SYS_ERR("US_100002", "操作失败,请稍后再试","" ),
    ILLEGAL_REQUEST("US_100003", "非法请求","" ),
    PARMAS_HAS_ERROR("US_100003", "参数异常",""),
    NOT_LOGIN("US_100004", "未登录，请登录",""),
    USER_NOT_EXISTE("US_100005", "用户不存在","查询用户不存在"),
    ORGANIZATION_NOT_EXISTE("US_100006", "用户组织不存在","查询组织不存在"),
    ORGANIZATION_CODE_EMPTY("US_100007", "用户组织编码为空","用户组织编码为空"),
    REC_ORGANIZATION_NOT_EXISTE("US_100008", "收获组织不存在","查询收获门店组织不存在"),
    PLEASE_ENTERING_RIGHT_MOBILE("US_100009","请输入正确的联系方式",""),
    ADDRESS_GIS_ERROR("US_100010","地址解析失败",""),
    EXPORT_ERROR("US_100011","导出生成excel出错",""),
    PRINT_DATE_ERROR("US_100012","地址信息填写不准确，请删除订单重新下单",""),
    IMPORT_ERROR("US_100013","导入excel出错",""),
    IMPORT_TYPE_ERROR("US_100028","导入表格字段不符合导入要求，请按业务配置导入模板填写",""),
    EAST_ORGANIZATION_EMPTY("US_100014","获取所有组织为空",""),
    DATA_LIMIT_EXPORT_ERROR("US_100015","导出数量太大，请修改查询条件导出",""),
    XML_CONVERT_FAILED("US_100016","XML 格式转换异常",""),
    DATA_EMPTY_EXPORT_ERROR("US_100017","无数据可以导出",""),
    GIS_ADDRESS_ERROR("US_100018","地址gis解析异常",""),
    TWO_LEVEL_ORGANIZATION_NOT_EXIST("US_100019","获取二级组织不存在",""),
    CUSTOM_NUMBER_RULE_TYPE_ERROR("US_100020","月结卡号结算规则非法",""),
    CUSTOM_NUMBER_RULE_NOT_EXIST("US_100021","月结卡号配置规则不存在",""),
    CUSTOM_NUMBER_RULE_EXIST_ERROR("US_100022","规则类型配置已存在",""),
    CUSTOM_NUMBER_NOT_EXIST("US_100023","此月结配置下不存在月结账号",""),
    ORGANIZATION_QUERY_ERROR("US_100024","组织查询失败",""),
    ORGANIZATION_SAVE_ERROR("US_100025","组织新增失败",""),
    ORGANIZATION_UPDATE_ERROR("US_100026","组织修改失败",""),
    ORGANIZATION_DELETE_ERROR("US_100027","组织删除失败",""),


    QUERY_EXP_TIMEOUT("US_200000", "查询相隔天数不能超过3个月",""),
    ORDER_NOT_EXISTE("US_200001", "订单不存在",""),
    CANAL_ORDER_STATUS_ERROR("US_200002", "非待收件状态不能取消订单",""),
    CANAL_ORDER_NOT_STORE_ORDER("US_200003", "只能操作本门店订单",""),
    CANAL_ORDER_ORDER("US_200004", "取消订单失败",""),
    CREATE_ORDER_ORDER("US_200005", "下单失败",""),
    CREATE_ORDER_ORDERS("US_200006", "下单信息有误",""),
    REVIEW_CREATE_ORDER_ERROR("US_200007", "审核下单失败",""),
    REVIEW_REJECT_ORDER_ERROR("US_200008", "审核驳回失败",""),
    CANAL_ORDER_SOURCE_ORDER("US_200009", "只能取消小程序创建的订单",""),
    CANAL_ORDER_SOURCE_OPEN_ORDER("US_200010", "只能取消开放平台创建的订单",""),
    CANAL_ORDER_ALREADY_OPEN_ORDER("US_200011", "订单已取消",""),
    QUERY_ORDER_FREIGHT_ERROR("US_200012", "查询订单运费失败",""),
    ROUTE_DISTRIBUTE_PUSH_ERROR("US_200013", "路由分发推送失败",""),
    ORDER_MANAGE_FILE_EXPORT_LIMIT("US_200014", "延时导出次数上限",""),



    DELETE_ORDER_ORDER("US_300001", "删除订单失败",""),
    REVIEW_ORDER_ERROR("US_300002", "审核订单单次不能超过200条",""),


    //组织模块
    ORGANIZATION_CODE_NOT_EXISTE("US_400001", "组织编码不能为空！",""),
    ORGANIZATION_LEVEL_LIMIT("US_400002", "组织等级限制！",""),
    ORGANIZATION_EXPORT_ERROR("US_400003", "组织导出异常",""),

    //收件地址模块
    USERRECEIVEADDRESS_EXISTE("US_500001","收件地址已存在",""),
    USERRECEIVEADDRESS_ORGANIZATION_ID_ILEGAL("US_500002","组织ID不合法",""),
    USERRECEIVEADDRESS_NOT_EXISTE("US_500003","未查询到收件地址信息",""),
    USERRECEIVEADDRESS_NOT_PERMISSION("US_500004","无权限!",""),
    USERRECEIVEADDRESS_TEMPLATE_ERROR("US_500005","模板不正确",""),

    //sku模块
    SKUINFO_GET_ERROR("US_600001","获取组织id出错",""),
    SKUINFO_UPLOAD_NOT_PERMISSION("US_600002","无权限导入商品信息",""),

    //小程序模块
    ACCESS_TOKEN_GET_ERROR("US_700001","获取access_token出错",""),
    QRCODE_GET_ERROR("US_700002","获取二维码出错",""),
    OPENID_GET_ERROR("US_700003","openId获取出错",""),
    FORMID_QUERY_EMPTY("US_700004","无可用formId",""),

    //路由查询模块
    ROUTE_TIME_OUT("US_800001","超过三个月了,不能查哦",""),
    ROUTE_QUERY_ERROR("US_800002","路由查询失败",""),

    //
    OPERATION_LOG_ERROR("US_900001","操作日志记录失败",""),

    //
    MEDTRONIC_USER_REFRESH_TOKEN_ERROR("US_900002","获取MEDTRONIC access_token出错",""),


    //子单号申请
    ORDER_ZD_QUERY_ERROR("US_1000001","子单号申请失败",""),
    ;
    // 错误编码
    private String code;
    // 提示
    private String prompt;
    // 描述
    private String desc;

    public static ErrorCode getErrorCodeByCode(String code) {
        for (ErrorCode errorCodeEnum : ErrorCode.values()) {
            if (StringUtils.equals(code, errorCodeEnum.getCode())) {
                return errorCodeEnum;
            }
        }
        return null;
    }
}
