package efub.toyproject.twitter.account.dto;

import efub.toyproject.twitter.account.domain.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponseDto {
    private Long accountId;
    private String nickname;
    private String email;

    public AccountResponseDto(Long accountId, String nickname, String email){
        this.accountId=accountId;
        this.nickname=nickname;
        this.email=email;
    }

    public static AccountResponseDto from(Account account){
        return new AccountResponseDto(
                account.getAccountId(),
                account.getNickname(),
                account.getEmail());
    }
}
