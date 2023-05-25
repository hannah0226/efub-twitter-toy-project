package efub.toyproject.twitter.account.repository;

import efub.toyproject.twitter.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Boolean existsByEmail(String email);
}
