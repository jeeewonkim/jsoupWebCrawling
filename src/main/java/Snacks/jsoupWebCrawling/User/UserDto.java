package Snacks.jsoupWebCrawling.User;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class UserDto {

    private String userId;
    private String userName;
    private String password;

    public UserDto(String userId, String userName, String password){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
}
