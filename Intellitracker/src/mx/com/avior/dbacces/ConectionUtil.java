package mx.com.avior.dbacces;

import java.util.HashMap;
import java.util.List;

import mx.com.avior.dto.DTOBase;



public interface ConectionUtil {
	<T> List<T> executeQueryForList(String queryName, Class<T> resultClass, HashMap<String, Object> parameters) throws Exception;
	<T> List<T> executeQueryForListNoArgs(String queryName, Class<T> resultClass, Object... params) throws Exception;
	<T> T executeQueryForObject(String queryName, Class<T> resultClass, Object... params) throws Exception;
	DTOBase executePauForObject(String queryName, Object... params) throws Exception;
}
