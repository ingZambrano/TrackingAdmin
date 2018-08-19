package mx.com.avior.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class DTOUsuario implements org.springframework.security.core.userdetails.UserDetails
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String ipcliente;
 
    /* Spring Security fields*/
    private  List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    
    private String idUser;
    private String numEmp;
    private String name;
    private String secLastName;
    private String idProfile;
    private String profile;
    private String errorCode;
    private String errorMsg;
    private String completeName;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(String numEmp) {
        this.numEmp = numEmp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecLastName() {
        return secLastName;
    }

    public void setSecLastName(String secLastName) {
        this.secLastName = secLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }
    	
    
    
public String getIpcliente() {
		return ipcliente;
	}

	public void setIpcliente(String ipcliente) {
		this.ipcliente = ipcliente;
	}

public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return this.authorities;
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return this.password;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return this.username;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return this.accountNonExpired;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return this.accountNonLocked;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return this.credentialsNonExpired;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return this.enabled;
}

public void addAuthority(String role){
	
	 this.authorities.add(new SimpleGrantedAuthority(role));
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}



}
