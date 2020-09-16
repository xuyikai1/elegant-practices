package com.example.chaindemo.pojo;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDto<T> {

	/** 未知错误 **/
	public final static Integer UNKNOWN_ERR_CODE = -1;
	/** 正确 **/
	public final static Integer SUCCESS_CODE = 0;
	/** 失败 **/
	public final static Integer FAIL_CODE = 1;
	/** 参数错误 **/
	public final static Integer PARAM_ERROR_CODE = 400;
	/** 限制调用 **/
	public final static Integer LIMIT_ERROR_CODE = 401;
	/** token 过期 **/
	public final static Integer TOKEN_TIMEOUT_CODE = 402;
	/** 禁止访问 **/
	public final static Integer NO_AUTH_CODE = 403;
	/** 资源没找到 **/
	public final static Integer NOT_FOUND = 404;
	/** 服务器错误 **/
	public final static Integer SERVER_ERROR_CODE = 500;
	/** 服务降级中 **/
	public final static Integer DOWNGRADE = 406;
	/** 上传文件不能为空 **/
	public final static Integer RET_CODE_SYS_FILE_MUST_NO_EMPTY = 7;
	/** 上传文件大小超出限制 **/
	public final static Integer RET_CODE_SYS_FILE_SIZE_EXCEED = 8;
	/** 调用时间戳不满足系统要求（默认与服务端间隔不能超过10min） **/
	public final static Integer RET_CODE_SYS_TIME_INCORRECT = 9;
	/** 系统繁忙 **/
	public final static Integer RET_CODE_SYS_BUSY = 10;
	/** 参数缺失 **/
	public final static Integer RET_CODE_APP_PARAM_MISS = 11;
	/** APP KEY不存在 **/
	public final static Integer RET_CODE_APP_NO_EXISTS = 12;
	/** 签名错误 **/
	public final static Integer RET_CODE_APP_SIGN_INCORRECT = 13;
	/** App方法/服务 不存在 **/
	public final static Integer RET_CODE_APP_METHOD_NO_EXISTS = 14;
	public final static Integer RET_CODE_USER_EXISTS = 15;
	/** 方法/服务 未授权 **/
	public final static Integer RET_CODE_APP_METHOD_UN_AUTHORIZE = 16;
	/** 用户不存在 **/
	public final static Integer RET_CODE_USER_NO_EXISTS = 17;
	public final static Integer RET_CODE_USER_ITEM_EXISTS = 18;
	public final static Integer RET_CODE_ITEMSPEC_UNKNOWN = 19;
	public final static Integer RET_CODE_APP_GAME_UNAUTHORIZE = 20;
	public final static Integer RET_CODE_USER_RELATIONSHIP_NOT_EXITS= 21;
	public final static Integer RET_CODE_USER_RELATIONSHIP_EXITS= 22;
	public final static Integer RET_CODE_BUILD_RELATIONSHIP_WITHSELF= 23;
	/**
	 * 非法参数
	 */
	public final static Integer RET_CODE_ILLEGAL_PARAMETER = 24;
	/**
	 * 参数限制
	 */
	public final static Integer RET_CODE_PARAMETER_LIMIT= 25;


	private static final String SUCCESS_MSG = "SUCCESS";

	private String reqId;

	private Integer code;

	private String msg;

	private T data;

	public static <T>  ResultDto<T> build(Integer code, String msg){
		return new ResultDto<T>("",code, msg, null);
	}

	public static <T>  ResultDto<T> ok(T data){
		return new ResultDto<T>("",SUCCESS_CODE, SUCCESS_MSG, data);
	}

	public static <T> ResultDto<T> fail(String msg){
		return new ResultDto<T>("",FAIL_CODE, msg, null);
	}

}
