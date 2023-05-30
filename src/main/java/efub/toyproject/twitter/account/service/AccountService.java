package efub.toyproject.twitter.account.service;

import efub.toyproject.twitter.account.domain.Account;
import efub.toyproject.twitter.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email){
        return accountRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Account findAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()->new EntityNotFoundException("해당 id를 가진 유저를 찾을 수 없습니다. id= "+id));

    }
    //TESTtest
}
