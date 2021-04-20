package helper;

import org.sagacity.sqltoy.dao.SqlToyCoreLazyDao;
import org.sagacity.sqltoy.dao.impl.SqlToyCoreLazyDaoImpl;

import java.io.Serializable;


public class QueryHelper {

    public static SqlToyCoreLazyDao sqlToyLazyDao = new SqlToyCoreLazyDaoImpl();//= SpringHelper.getBean(SqlToyLazyDao.class);


    public static <T extends Serializable> T read(T entity) {
        return sqlToyLazyDao.load(entity);
    }

    public static <T extends Serializable> Long save(T entity) {
        return (Long) sqlToyLazyDao.save(entity);
    }

    public static <T extends Serializable> T read(String sql, Class<T> beanClass) {
        return sqlToyLazyDao.loadBySql(sql, new String[]{}, new Object[]{}, beanClass);
    }

    public static void flush() {
        sqlToyLazyDao.flush();
    }

    public static void closeConnection() {
        sqlToyLazyDao.closeConnection();
    }
}
