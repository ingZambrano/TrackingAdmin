package mx.com.avior.dto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class DTOBase
{
    private Integer idCode = 1;
    private String descCode = "";

    public  DTOBase(){}
    
    public  DTOBase(int idCode, String descCode){
        this.idCode = idCode;
        this.descCode = descCode;
    }
    
    public int getIdCode() {
        return idCode;
    }

    public void setIdCode(int idCode) {
        this.idCode = idCode;
    }

    public String getDescCode() {
        return descCode;
    }


    
    public void setDescCode(String descCode) {
		this.descCode = descCode;
	}

	@Override
    public String toString()
    {
        StringBuilder stringItem = new StringBuilder(getClass().getName() + " [");
        Method[] methods = getClass().getMethods();
        int numMethods = methods.length;
        for(int c = 0; c < numMethods; c++)
        {
            Method currentMethod = methods[c];
            String methodName = currentMethod.getName();
            if(methodName.startsWith("get"))
            {
                String propertyName = methodName.substring(3);
                propertyName = propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1);
                String propertyValue = "";
                if(propertyName.equals("class"))
                    continue;
                try
                {
                    propertyValue = String.valueOf(currentMethod.invoke(this));
                }
                catch(IllegalAccessException e) { e.printStackTrace(); }
                catch(InvocationTargetException e) { e.printStackTrace(); }
                if(stringItem.indexOf("[") != stringItem.length() - 1)
                    stringItem.append(", ");
                stringItem.append(propertyName);
                stringItem.append(":");
                stringItem.append(propertyValue);
            }
        }
        stringItem.append("]");
        return stringItem.toString();
    }
}

