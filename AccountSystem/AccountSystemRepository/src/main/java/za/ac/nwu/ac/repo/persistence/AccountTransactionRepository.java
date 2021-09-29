package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.util.Optional;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {


    @Query(value = "SELECT " +
            "               at" +
            "               FROM " +
            "               AccountTransaction at" +
            "               WHERE at.memberId = :memberId ")
    AccountTransaction findByMemberId(Long memberId);
}
