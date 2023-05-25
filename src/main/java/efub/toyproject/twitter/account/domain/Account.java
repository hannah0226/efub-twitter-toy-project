package efub.toyproject.twitter.account.domain;

import efub.toyproject.twitter.global.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id",updatable = false)
    private Long accountId;

    @Column(nullable = false,length = 16)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 60)
    private String email;

    @Builder
    public Account(String nickname, String password, String email){
        this.nickname=nickname;
        this.password=password;
        this.email=email;
    }
}
