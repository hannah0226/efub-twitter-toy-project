package efub.toyproject.twitter.account.controller;

import efub.toyproject.twitter.account.domain.Account;
import efub.toyproject.twitter.account.dto.AccountResponseDto;
import efub.toyproject.twitter.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public AccountResponseDto getAccount(@PathVariable Long accountId){
        Account findAccount = accountService.findAccountById(accountId);
        return AccountResponseDto.from(findAccount);
    }
}
