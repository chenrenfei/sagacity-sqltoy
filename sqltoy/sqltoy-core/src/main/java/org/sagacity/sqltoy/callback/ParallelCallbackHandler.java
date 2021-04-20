/**
 * 
 */
package org.sagacity.sqltoy.callback;

import org.sagacity.sqltoy.SqlToyContext;
import org.sagacity.sqltoy.model.ShardingGroupModel;

import java.util.List;

/**
 * @project sagacity-sqltoy4.0
 * @description 并行执行反调定义
 * @author chenrenfei <a href="mailto:zhongxuchen@gmail.com">联系作者</a>
 * @version id:ParallelCallbackHandler.java,Revision:v1.0,Date:2017年11月3日
 */
@FunctionalInterface
public interface ParallelCallbackHandler {
	/**
	 * @todo 并行执行反调计算
	 * @param sqlToyContext
	 * @param shardingGroupModel
	 * @return
	 * @throws Exception
	 */
	public List<?> execute(SqlToyContext sqlToyContext, ShardingGroupModel shardingGroupModel) throws Exception;
}
