package pep.pesoftware.wew.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class SysUserForm implements Serializable {
    private Long userId;
    private String username;
    private String name;
    private String password;
    private Long deptId;
    private String email;
    private String mobile;
    private Byte status;
    private Long userIdCreate;
    private Date gmtCreate;
    private Date gmtModified;
    private Long sex;
    private Date birth;
    private Long picId;
    private String liveAddress;
    private String hobby;
    private String province;
    private String city;
    private String district;
    private String token;
}