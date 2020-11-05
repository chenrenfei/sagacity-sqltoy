/**
 * 
 */
package org.sagacity.sqltoy.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.sql.DataSource;

/**
 * @project sagacity-sqltoy
 * @description EntityUpdate内部扩展类，便于隐藏属性避免暴露过多get方法
 * @author zhongxuchen@gmail.com
 * @version v1.0, Date:2020-8-7
 * @modify 2020-8-7,修改说明
 */
public class EntityUpdateExtend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7224627356139617128L;

	/**
	 * 条件语句
	 */
	public String where;

	/**
	 * 条件参数值
	 */
	public Object[] values;

	/**
	 * 数据源
	 */
	public DataSource dataSource;

	/**
	 * update 的字段名称和对应的值
	 */
	public LinkedHashMap<String, Object> updateValues = new LinkedHashMap<String, Object>();

}
