package cn.mycar.enty;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Stone
 * @time 2017/9/20  9:16
 * @desc ${TODD}
 */
@Entity(nameInDb = "t_user")
public class UserEnty {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "t_name")
    private String name;
    @Property(nameInDb = "t_pwd")
    private String password;
    @Property(nameInDb = "t_nick_name")
    private String nickName;
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 212578114)
    public UserEnty(Long id, String name, String password, String nickName) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.nickName = nickName;
    }
    @Generated(hash = 111569588)
    public UserEnty() {
    }

}
