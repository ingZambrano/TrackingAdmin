package mx.com.avior.dbaccesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.avior.dbacces.ConectionUtil;
import mx.com.avior.dto.DTOBase;

@Service
public class ConectionUtilImpl implements ConectionUtil {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public <T> List<T> executeQueryForList(String queryName, Class<T> resultClass, HashMap<String, Object> parameters) throws Exception
    {   
        ArrayList<T> result = (ArrayList<T>)this.sqlSession.selectList(queryName,parameters);
        if(result==null || result.isEmpty())
        	System.out.println("No se encontraron datos de respuesta...");
        else
        {
            T[] aResult = (T[])result.toArray();
        }
        return result;
    }
	
	public <T> HashMap<String, Object> executeQuery(String queryName, Object[] params, Class<T> resultClass) throws Exception
	    {
		 
	        HashMap<String, Object> parameters = new HashMap<String, Object>();
	        if(params != null)
	        {
	            int size = params.length;
	            if(size % 2 != 0)
	                throw new Exception("Para llamar a un método oracle debe hacerlo en pares [identificador, valor]");
	            
	            for(int c = 0; c < size; c++)
	            {
	                String identifier = (String)params[c++];
	                Object value = params[c];
	                parameters.put(identifier, value);
	                
	            }
	        }

	        this.sqlSession.selectOne(queryName, parameters);
	        return parameters;
	    }

	@Override
	public <T> T executeQueryForObject(String queryName, Class<T> resultClass,
			Object... params) throws Exception {
		
		 HashMap<String, Object> parameters = executeQuery(queryName, params, resultClass);
	        List<T> list = (ArrayList<T>)parameters.get("result");
	        if(list==null || list.isEmpty())
	        {
	        	System.out.println("No se encontraron datos de respuesta...");
	            return null;
	        }
	        else
	        {
	            return (T)list.get(0);
	        }
	        
	}

	@Override
	public DTOBase executePauForObject(String queryName, Object... params)
			throws Exception {
		DTOBase dtoBase;
        HashMap<String, Object> parameters = executeQuery(queryName, params, DTOBase.class);
        System.out.println((Integer)parameters.get("err_num")+" :: "+(String)parameters.get("err_msg"));
        dtoBase = new DTOBase((Integer)parameters.get("err_num"), (String)parameters.get("err_msg"));
        return dtoBase;
	}

	@Override
	public <T> List<T> executeQueryForListNoArgs(String queryName,
			Class<T> resultClass, Object... params) throws Exception {
		ArrayList<T> result = (ArrayList<T>)this.sqlSession.selectList(queryName);
        if(result==null || result.isEmpty())
        	System.out.println("No se encontraron datos de respuesta...");
        else
        {
            T[] aResult = (T[])result.toArray();
        }
        return result;
	}


}
